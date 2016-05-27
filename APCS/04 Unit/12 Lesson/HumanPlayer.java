package tictactoe;
import java.util.Scanner;

/**
 * Represents a human player.
 */
public class HumanPlayer extends Player {
    private final Scanner scanner;
    
    public HumanPlayer(TicTacToeBoard board, char mark) {
        /** Pass board and mark to the parent class constructor. */
        super(board, mark);

        
        // Create a scanner for user input.
        scanner = new Scanner(System.in);
    }
    
    /**
     * Retrieves the name associated with this Player.
     * @return Name of the Player.
     */
    @Override
    public String getName() {
        return "Player";
    }
    
    /**
     * Allows player to attempt a move. The player will be notified of invalid
     * or illegal moves and will be asked to try again.
     * @return True if the move results in a finished game.
     */
    @Override
    public boolean makeMove() {
        /** Fix the syntax and logic errors in this method. */
        boolean turnDone = false;
        boolean gameOver = false;
        while (turnDone == false) {
            System.out.println("\nPlease enter your move:");
            String input = scanner.next();
            
            try {
                gameOver = board.move(input, mark);
                turnDone = true;
            } catch (InvalidInputException iie) {
                System.out.println(iie.getMessage());
            } catch (IllegalMoveException ime) {
                System.out.println(ime.getMessage());               
            }
        }
        return gameOver;
    }
}
