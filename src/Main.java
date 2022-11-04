public class Main {
	public static void main(String[] args) {
		MonsterZoo masterzoo = new MonsterZoo();
		masterzoo.addPlayer(new Player("P1"));

		while (masterzoo.end() != false) {
			masterzoo.run();
		}
		masterzoo.Monstercheck();

	}
}
