
public class Disk {

    private final int diskSize;
    public static Disk EMPTY_DISK = new Disk(-1);

    Disk(int diskSize) {
        this.diskSize = diskSize;
    }

    public boolean isDiskSmaller(Disk topDisk) {
        return this.diskSize < topDisk.diskSize;
    }

    @Override
    public String toString() {
        return String.valueOf(Character.toChars(65 + diskSize));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disk disk = (Disk) o;

        return diskSize == disk.diskSize;

    }

}
