package modules;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class ScoreBoard {
    public List<Match> matchList = new ArrayList<Match>();

    public ScoreBoard() {
        matchList = addToMatchList();
//        Team teamA = matchList.get(0).getTeamA();
//        Team teamB = matchList.get(0).getTeamB();
//        matchList.get(0).playMatch(new File("matchFiles/RomaniaBulgaria"));
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public List<Match> addToMatchList() {
        // Creates an array in which we will store the names of files and directories
        String[] pathnames;
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        String path = Paths.get("./matchFiles").toAbsolutePath().normalize().toString();
        File f = new File(path);

        // Populates the array with names of files and directories
        pathnames = f.list();

        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            File file = new File("./matchFiles/" + pathname);
            System.out.println("path: ");
            System.out.println(file);
            Match match = new Match(file);
            matchList.add(match);

        }

        return matchList;

    }
}
