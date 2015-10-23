import java.util.List;

public class Tower {
    private final List<Disk> disks;

    public Tower(List<Disk> disks)  {
        this.disks = disks;
    }

    public int getNumberOfDisks() {
        return disks.size();
    }

    public String printDisks() {
        String output = "";
        for (Disk disk : disks){
            output += disk.toString();
        }

        return output;
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public void removeTopDisk() {
        disks.remove(0);
    }

    public void addDiskToTop(Disk disk) {
        disks.add(0, disk);
    }

    public Disk getTopDisk() {
        return (disks.size()==0) ? Disk.EMPTY_DISK : disks.get(0);
    }
}
