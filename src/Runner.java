import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Runner {
    private static List<Disk> diskNames = newArrayList(Disk.A, Disk.B, Disk.C, Disk.D, Disk.E, Disk.F, Disk.G, Disk.H, Disk.I);

    public static void main(String[] args){
        Runner runner = new Runner();
        int numberOfDisks = 5;
        int stepToTheSolution = (int)(Math.pow(2,numberOfDisks))-1;
        List<Tower> startTowers = runner.createStartTowersWith(numberOfDisks, 3);
        HanoiController hanoiController = new HanoiController(startTowers, numberOfDisks);
        for (int i= 1; i<=stepToTheSolution; i++){
            List<Tower> towers = hanoiController.move();
            System.out.println("Move " + i + ": " + new Printer().printDiskLocations(towers));

        }
    }

    public List<Tower> createStartTowersWith(int numberOfDisks, int numberOfTowers) {
        List<Tower> towers = newArrayList();
        towers.add(createFirstTower(numberOfDisks));
        for (int tower = 0; tower< numberOfTowers-1; tower++){
            towers.add(new Tower(newArrayList()));
        }
        return towers;
    }

    private Tower createFirstTower(int numberOfDisks) {
        List<Disk> disks = newArrayList();
        for (int disk =0; disk< numberOfDisks; disk++){
            disks.add(diskNames.get(disk));
        }
        return new Tower(disks);
    }
}
