
public enum Disk {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8),
    I(9),
    EMPTY(0);

    private final int diskSize;

    Disk(int diskSize) {
        this.diskSize = diskSize;
    }

    public boolean isDiskSmaller(Disk topDisk) {
        return this.diskSize < topDisk.diskSize;
    }

}
