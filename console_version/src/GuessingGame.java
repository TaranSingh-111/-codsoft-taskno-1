import java.util.*;
public class GuessingGame {

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("WELCOME TO THE NUMBER GUESSING GAME");
        do{
            beginGame(sc);
        }
        while(playAgainPrompt(sc));


        System.out.println("THANKS FOR PLAYING");
        sc.close();
    }

    public static void beginGame(Scanner sc)                  //Starts the game
    {
        Random rd=new Random();
        int target = rd.nextInt(100)+1;
        int maxAttempts= 5;
        int attempts= 0;
        boolean isCorrect=false;
        while(attempts < maxAttempts)                        //attempt
        {
            attempts++;
            int guess=getUserGuess(sc);

            if(guess == target)
            {
                System.out.println("CORRECT!!!! YOU GUESSED THE NUMBER IN "+attempts+" attempts");
                isCorrect=true;
                break;
            }
            else if(guess < target)
            {
                System.out.println("YOUR GUESS IS LOW");
                isCorrect=false;
            }
            else
            {
                System.out.println("YOUR GUESS IS HIGH");
                isCorrect=false;
            }
            System.out.println("YOU HAVE " +(maxAttempts-attempts)+ " attempts left");


        }
        if(!isCorrect) {                                  //if failed to find
            System.out.println("YOU HAVE USED UP ALL YOUR ATTEMPTS.");
            System.out.println("THE CORRECT NUMBER WAS " + target);
        }
    }

    public static int getUserGuess(Scanner sc)                //gets user input
    {
        System.out.println("ENTER YOUR GUESS ---> ");
        while(!sc.hasNextInt())                     //checks input validity
        {
            System.out.println("INVALID !!!! PLEASE ENTER A NUMBER");
            sc.next();                           // clears the input
        }
        return sc.nextInt();
    }


    public static boolean playAgainPrompt(Scanner sc)                //play again choice
    {
        System.out.println("DO YOU WANT TO PLAY AGAIN ?? (yes/no)");
        String again=sc.next().trim().toLowerCase();
        return again.equals("yes")||again.equals("y");
    }

}
