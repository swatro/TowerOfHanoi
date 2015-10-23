import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Runner {

    public static void main(String[] args){
        Runner runner = new Runner();
        int numberOfDisks = 12;
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
        for (int diskSize =0; diskSize< numberOfDisks; diskSize++){
            disks.add(new Disk(diskSize));
        }
        return new Tower(disks);
    }
}
