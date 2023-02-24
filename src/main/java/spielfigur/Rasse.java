package spielfigur;

public enum Rasse {
    Zwerg(0, 2, 2, 1, 0),
    Mensch(1, 1, 1, 1, 1),
    Elf(2, 0, 0, 1, 2),
    Hobbit(0, 0, 1, 2, 2);

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
