import java.util.*;

public class Player {
    List<Monsteregg> monsters = new ArrayList<>();
    List<Monsteregg> eggs = new ArrayList<>();
    int fruits = 0;
    int balls = 10;
    int distance = 0;
    String name = "Player";
    boolean keepon = true;

    enum ResourceTag {
        fruit("フルーツ"),
        Ball("ボール"),
        Egg("卵");
        public final String name;
        ResourceTag(String name) {this.name = name;}
    }

    public Player(String name) {
        if (name !=null) {
            this.name = name;
        }
    }

    void Itemget(ResourceTag tag) {
        switch (tag) {
            case fruit:
                fruits++;
                break;
            case Ball:
                balls++;
                break;
            case Egg:
                eggs.add(new Monsteregg());
                break;
            default:
                break;
        }
    }

    public void Monsterget(Monsteregg monster) {
        this.monsters.add(monster);
    }

    public boolean useitem(ResourceTag tag) {
        switch (tag) {
            case fruit:
                if (this.fruits > 0) {
                    fruits--;
                    return true;
                }
                break;
            case Ball:
                if (this.balls > 0) {
                    balls--;
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    public void move() {
        this.distance++;
        Eggcheck();
        System.out.print(
                String.format("%s: 手持ちのボールは%d個，フルーツは%d個，%dkm歩いた．\n",this.name, this.balls, this.fruits, this.distance));
    }

    private void Eggcheck() {
        Iterator<Monsteregg> iterator = eggs.iterator();
        while (iterator.hasNext()) {
            Monsteregg Nmoster = iterator.next();
            Nmoster.Eggborn();
            if (Nmoster.getStatus() == Monsteregg.Status.Monster) {
                this.monsters.add(Nmoster);
                iterator.remove();
            }
        }
    }

    public boolean end() {
        if (this.balls <= 0 && this.keepon == true) {
            System.out.print(this.name + ":ボールがなくなった！\n");
            this.keepon = false;
        }
        return this.keepon;
    }

    public void printCatchedMonster() {
       
        for (Monsteregg monster : monsters) {
            System.out.print(monster.species.name + "を捕まえた．\n");
        }
        
    }
}
