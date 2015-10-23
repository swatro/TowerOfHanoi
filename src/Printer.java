import java.util.List;

public class Printer {

    public String printDiskLocations(List<Tower> towersToPrint) {
        String output = "";
        int count = 1;
        for (Tower tower : towersToPrint){
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

}
