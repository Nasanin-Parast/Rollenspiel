package spielfigur.builder;

public enum Rasse {
    ZWERG(0, 2, 2, 1, 0),
    MENSCH(1, 1, 1, 1, 1),
    ELF(2, 0, 0, 1, 2),
    HOBBIT(0, 0, 1, 2, 2);

    final int[] boni = new int[5];

    Rasse(int intBonus, int strBonus, int konBonus, int wisBonus, int gesBonus) {
        boni[0] = intBonus;
        boni[1] = strBonus;
        boni[2] = konBonus;
        boni[3] = wisBonus;
        boni[4] = gesBonus;
    }

    public int getIntBonus() {
        return boni[0];
    }

    public int getStrBonus() {
        return boni[1];
    }

    public int getKonBonus() {
        return boni[2];
    }

    public int getWisBonus() {
        return boni[3];
    }

    public int getGesBonus() {
        return boni[4];
    }
}
