
public class Runner {
    public static void main(String[] args){
        HanoiController hanoiController = new HanoiController(4,3);
        for (int i= 1; i<=15; i++){
            hanoiController.move();
            System.out.println("move " + i + ": " + hanoiController.printDiskLocations());

        }

    }
}
