package modules;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Match match1 = new Match("Romania", "Bulgaria");
        System.out.println(match1.score);
        while (Objects.equals(match1.teamA.getName(), "Romania")) {
            System.out.println("Choose team to score");
            String name = sc.next();
            if (Objects.equals(match1.teamA.getName(), name)) {
                match1.teamA.Score();
                match1.updateScore(match1.teamA.name);
            }
            if (Objects.equals(match1.teamB.getName(), name)) {
                match1.teamB.Score();
                match1.updateScore(match1.teamB.name);
            }
            System.out.println(match1.score);
        }
    }
}
