import java.util.List;

public class HanoiController {
    private final List<Tower> towers;
    private Disk lastDiskToMove = Disk.EMPTY;

    public HanoiController(List<Tower> towers) {
        this.towers = towers;
    }

    public List<Tower> move() {
        for (int towerIndex= 0; towerIndex<towers.size(); towerIndex++) {
            Tower towerToRemoveFrom = towers.get(towerIndex);
            Disk topDisk = towerToRemoveFrom.getTopDisk();
            if (diskWasSuccessfullyMoved(towerToRemoveFrom, topDisk, towerIndex)) break;
        }
        return towers;
    }


    private boolean diskWasSuccessfullyMoved(Tower towerToRemoveFrom, Disk topDisk, int towerIndex) {
        if (topDisk == lastDiskToMove || topDisk == Disk.EMPTY){
            return false;
        }
        int attempts = 0;
        while (attempts < towers.size()){
            attempts++;
            int nextTowerIndex = (towerIndex++) % (towers.size());
            Tower tower = towers.get(nextTowerIndex);

            if (tower != towerToRemoveFrom && canDiskMoveToThisTower(tower, topDisk)) {
                towerToRemoveFrom.removeTopDisk();
                tower.addDiskToTop(topDisk);
                lastDiskToMove = topDisk;
                return true;
            }

        }
        return false;
    }

    private boolean canDiskMoveToThisTower(Tower tower, Disk topDisk) {
        List<Disk> disks = tower.getDisks();
        return disks.size() == 0 || topDisk.isDiskSmaller(disks.get(0));
    }
}
