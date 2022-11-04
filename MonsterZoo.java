import java.util.*;
import java.util.Map.Entry;

public class MonsterZoo {
    double zooStationRate = 0.2;
    double ballRange = 3;
    double fruitRange = 1;
    double eggRange = 2;

    List<Player> players = new ArrayList<>();
    Map<Player.ResourceTag, Double> Mzoo = new HashMap<>();

    public MonsterZoo() {
        Mzoo.put(Player.ResourceTag.Ball, this.ballRange);
        Mzoo.put(Player.ResourceTag.fruit, this.fruitRange);
        Mzoo.put(Player.ResourceTag.Egg, this.eggRange);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    boolean updatePlayer(Player player) {
        if (player.end() == false) {
            return false;
        }
        System.out.println(player.name + " start\n");
        Random rand = new Random();
        if (rand.nextDouble() < zooStationRate) {
            System.out.println("ズーstationを見つけた！\n");
            for (Entry<Player.ResourceTag, Double> entrySet : Mzoo.entrySet()) {
                double upper = entrySet.getValue() * rand.nextDouble();
                System.out.println(entrySet.getKey().name + "を" + (int) upper + "個Getした！\n");
                for (double i = 0; i < upper; i++) {
                    player.Itemget(entrySet.getKey());
                }
            }
        } else {
            Monsteregg spawnMonster = Monsteregg.makeRandomMonster(rand);
            System.out.println(spawnMonster.species.name + "が現れた！\n");
            boolean currFruit = player.useitem(Player.ResourceTag.fruit);
            if (currFruit)
            System.out.println("フルーツを投げた！捕まえやすさが倍になる！\n");
            for (int i = 0; i < 3 && player.useitem(Player.ResourceTag.Ball); i++) {
                System.out.println(spawnMonster.species.name + "にボールを投げた\n");
                double r = (6 * rand.nextDouble() * (currFruit ? 1 : 2));
                if (spawnMonster.species.rank <= r) {
                    System.out.println(spawnMonster.species.name + "を捕まえた！\n");
                    player.Monsterget(spawnMonster);
                    spawnMonster = null;
                    break;
                }
            }
            if (spawnMonster != null)
            System.out.println(spawnMonster.species.name + "に逃げられた！\n");
        }
        player.move();
        player.end();
        return true;
    }
    
    public void run() {
        for (Player player : players) {
            if (player.end()) {
                updatePlayer(player);
            }
        }
    }

    public void Monstercheck() {
        for (Player player : players) {
            player.printCatchedMonster();
        }
    }

    public boolean end() {
        boolean flag = false;
        for (Player player : players) {
            flag = flag || player.end();
        }
        return flag;
    }
}
