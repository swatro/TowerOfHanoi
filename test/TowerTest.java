import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TowerTest {

    @Test
    public void shouldHaveDisksInSizeOrderAtStartOfGame() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        assertThat(controller.printDiskLocations(), is("T1: ABCD, T2: 0 disks, T3: 0 disks"));

    }

    @Test
    public void shoudMoveDiskAToSecondTowerOnFirstMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: BCD, T2: A, T3: 0 disks"));
    }

    @Test
    public void shoudMoveDiskBToThirdTowerOnSecondMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: CD, T2: A, T3: B"));
    }

    @Test
    public void shouldMoveDiskAToThirdTowerOnThirdMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        controller.move();
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: CD, T2: 0 disks, T3: AB"));
    }

    @Test
    public void shouldMoveDiskCToSecondTowerOnFourthMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: D, T2: C, T3: AB"));
    }

    @Test
    public void shouldMoveDiskAToFirstTowerOnFifthMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: AD, T2: C, T3: B"));
    }

    @Test
    public void shouldMoveDiskBToSecondTowerOnSixthMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: AD, T2: BC, T3: 0 disks"));
    }

    @Test
    public void shouldMoveDiskAToSecondTowerOnSeventhMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: D, T2: ABC, T3: 0 disks"));
    }

    @Test
    public void shouldMoveDiskDToThirdTowerOnEightMoveMove() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        assertThat(controller.printDiskLocations(), is("T1: 0 disks, T2: ABC, T3: D"));
    }

    @Test
    public void shouldFinishMovingAllDisksIn15Moves() throws Exception {
        HanoiController controller = new HanoiController(4, 3);
        for (int i=1; i<=15; i++){
            controller.move();
        }
        assertThat(controller.printDiskLocations(), is("T1: 0 disks, T2: 0 disks, T3: ABCD"));

    }
}
