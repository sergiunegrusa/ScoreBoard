package modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class ReadData {
    public String teamAname;
    public String teamBname;
    public HashMap<Integer, HashMap<Integer, Integer>> scoringChart = new HashMap<>();

    public ReadData(File file){
        mainFunction(file);
    }

    public void mainFunction(File file) {
        String[] data1;
        try{
            Scanner myReader = new Scanner(file);

            int line = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data1 = data.split(" ");
//                System.out.println(Arrays.toString(data1));
                if (line == 0){
                    setTeamNames(data1);
                }
                else {
                    setScoringChart(data1, line);
                }
                line++;
            }
            myReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getTeamAname() {
        return teamAname;
    }

    public void setTeamNames(String[] data) {
        this.teamAname = data[0];
        this.teamBname = data[2];
    }

    public String getTeamBname() {
        return teamBname;
    }

    public HashMap<Integer, HashMap<Integer, Integer>> getScoringChart() {
        return scoringChart;
    }

    public void setScoringChart(String[] data, Integer line) {
        HashMap<Integer, Integer> list = new HashMap<>();
        list.put(parseInt(data[0]), parseInt(data[1]));
        scoringChart.put(line, list);

    }
}
