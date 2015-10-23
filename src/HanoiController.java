import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class HanoiController {
    private final List<Tower> towers;
    private static List<Disk> diskNames = newArrayList(Disk.A, Disk.B, Disk.C, Disk.D);
    private Disk lastDiskToMove = Disk.D;

    public HanoiController(int numberOfDisks, int numberOfTowers) {
        this.towers = newArrayList();

        towers.add(createFirstTower(numberOfDisks));

        for (int tower = 0; tower< numberOfTowers-1; tower++){
            towers.add(new Tower(newArrayList()));
        }
    }

    public String printDiskLocations() {
        String output = "";
        int count = 1;
        for (Tower tower : towers){
            if (tower.getNumberOfDisks()!=0){
                output += "T" + count + ": " + tower.printDisks() + ", ";
            }
            else {
                output += "T" + count + ": 0 disks, ";
            }
            count++;
        }
        String outputWithOutTrailingComma = output.substring(0, output.length() - 2);
        return outputWithOutTrailingComma;
    }

    public void move() {
        for (int towerIndex= 0; towerIndex<towers.size(); towerIndex++) {
            Tower towerToRemoveFrom = towers.get(towerIndex);
            Disk topDisk = towerToRemoveFrom.getTopDisk();
            if (diskWasSuccessfullyMoved(towerToRemoveFrom, topDisk, towerIndex)) break;
        }
    }

    private Tower createFirstTower(int numberOfDisks) {
        List<Disk> disks = newArrayList();
        for (int disk =0; disk< numberOfDisks; disk++){
            disks.add(diskNames.get(disk));
        }
        return new Tower(disks);
    }

    private boolean diskWasSuccessfullyMoved(Tower towerToRemoveFrom, Disk topDisk, int towerIndex) {
        if (topDisk == lastDiskToMove || topDisk == Disk.EMPTY){
            return false;
        }
        int attempts = 0;
        while (attempts < towers.size()){
            attempts++;
            int index = (towerIndex + 1) % (towers.size());
            towerIndex++;
            Tower tower = towers.get(index);
            if (tower != towerToRemoveFrom) {
                if (canDiskMoveToThisTower(tower, topDisk)) {
                    towerToRemoveFrom.removeTopDisk();
                    tower.addDiskToTop(topDisk);
                    lastDiskToMove = topDisk;
                    return true;
                }
            }

        }
        return false;
    }

    private boolean canDiskMoveToThisTower(Tower tower, Disk topDisk) {
        List<Disk> disks = tower.getDisks();
        return disks.size() == 0 || topDisk.isDiskSmaller(disks.get(0));
    }
}
