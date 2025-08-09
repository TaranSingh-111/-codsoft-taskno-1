import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GameLogic {
    public static int target;
    public static int attempts;
    public static int maxAttempts=7;
    public static int score;
    public static int high=0;

    //constuctor
    public GameLogic(){
        try (Scanner sc = new Scanner(new File("highscore.txt"))) {
            if (sc.hasNextInt()) {
                high = sc.nextInt();
            } else {
                high = 7; // default worst score
            }
        } catch (IOException e) {
            high = 7; // file not found
        }
        reset();
    }
    public static void reset()
    {
        Random rd=new Random();
        target = rd.nextInt(100)+1;
        attempts=maxAttempts;
    }

    public static String checkGuess(int guess)
    {
        attempts--;
        if(guess==target){
            score =(attempts+1)*10;
            if (high < score) {
                high = score;
                try (PrintWriter pw = new PrintWriter("highscore.txt")) {
                    pw.println(high);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "Correct! Your Score :"+ score;
        }
        if(attempts<=0)
            return "GAME OVER! The number was "+target;

        return guess<target?"Too low!":"Too high!";
    }

}
