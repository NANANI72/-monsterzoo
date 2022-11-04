import java.util.List;
import java.util.Random;

public class Monsteregg {
    static List<MonsterZukan> refSpecies = MonsterZukan.getmonster();

    static enum Status {
        Egg,
        Monster,
    }

    MonsterZukan species = null;
    int distance = 0;
    Status status = Status.Egg;

    public void Eggborn() {
        if (this.status == Status.Egg)
            if (this.distance < 3) {
                distance++;
            } else {
                System.out.print("卵が孵った\n");
                this.status = Status.Monster;
                this.species = refSpecies.get(new Random().nextInt(refSpecies.size()));
                System.out.print(this.species.name + "が産まれた！\n");
            }
    }

    public Status getStatus() {
        return this.status;
    }

    static public Monsteregg makeMonster(MonsterZukan species) {
        Monsteregg Nmoster = new Monsteregg();
        Nmoster.species = species;
        Nmoster.status = Status.Monster;
        return Nmoster;
    }

    static public Monsteregg makeRandomMonster(Random rand) {
        return makeMonster(refSpecies.get(rand.nextInt(refSpecies.size())));
    }
}
