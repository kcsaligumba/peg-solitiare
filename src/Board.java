import java.util.ArrayList;

public class Board
{
    boolean[] pegs = {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
    
    boolean end = false;
    
    /**
     * Gives the state of the pegs on the board
     * @return a boolean array of the pegs
     */
    public boolean[] getPegs()
    {
        return pegs;
    }
    
    /**
     * Checks if a peg is able to move (adjacent peg is present and the peg after is not present)
     * @param peg the position of the peg to be moved on the board
     * @return an integer array list of valid middle peg and end peg positions
     */
    public ArrayList<Integer> checkPeg(int peg)
    {
        ArrayList<Integer> toBeMovedTo = new ArrayList<Integer>();
        
        if (peg == 0 && pegs[0])
        {
            if (pegs[1] && !pegs[3])
            {
                toBeMovedTo.add(1);
                toBeMovedTo.add(3);
            }
            if (pegs[2] && !pegs[5])
            {
                toBeMovedTo.add(2);
                toBeMovedTo.add(5);
            }
        }
        if (peg == 1 && pegs[1])
        {
            if (pegs[3] && !pegs[6])
            {
                toBeMovedTo.add(3);
                toBeMovedTo.add(6);
            }
            if (pegs[4] && !pegs[8])
            {
                toBeMovedTo.add(4);
                toBeMovedTo.add(8);
            }
        }
        if (peg == 2 && pegs[2])
        {
            if (pegs[4] && !pegs[7])
            {
                toBeMovedTo.add(4);
                toBeMovedTo.add(7);
            }
            if (pegs[5] && !pegs[9])
            {
                toBeMovedTo.add(5);
                toBeMovedTo.add(9);
            }
        }
        if (peg == 3 && pegs[3])
        {
            if (pegs[1] && !pegs[0])
            {
                toBeMovedTo.add(1);
                toBeMovedTo.add(0);
            }
            if (pegs[4] && !pegs[5])
            {
                toBeMovedTo.add(4);
                toBeMovedTo.add(5);
            }
            if (pegs[7] && !pegs[12])
            {
                toBeMovedTo.add(7);
                toBeMovedTo.add(12);
            }
            if (pegs[6] && !pegs[10])
            {
                toBeMovedTo.add(6);
                toBeMovedTo.add(10);
            }
        }
        if (peg == 4 && pegs[4])
        {
            if (pegs[7] && !pegs[11])
            {
                toBeMovedTo.add(7);
                toBeMovedTo.add(11);
            }
            if (pegs[8] && !pegs[13])
            {
                toBeMovedTo.add(8);
                toBeMovedTo.add(13);
            }
        }
        if (peg == 5 && pegs[5])
        {
            if (pegs[2] && !pegs[0])
            {
                toBeMovedTo.add(2);
                toBeMovedTo.add(0);
            }
            if (pegs[4] && !pegs[3])
            {
                toBeMovedTo.add(4);
                toBeMovedTo.add(3);
            }
            if (pegs[8] && !pegs[12])
            {
                toBeMovedTo.add(8);
                toBeMovedTo.add(12);
            }
            if (pegs[9] && !pegs[14])
            {
                toBeMovedTo.add(9);
                toBeMovedTo.add(14);
            }
        }
        if (peg == 6 && pegs[6])
        {
            if (pegs[3] && !pegs[1])
            {
                toBeMovedTo.add(3);
                toBeMovedTo.add(1);
            }
            if (pegs[7] && !pegs[8])
            {
                toBeMovedTo.add(7);
                toBeMovedTo.add(8);
            }
        }
        if (peg == 7 && pegs[7])
        {
            if (pegs[4] && !pegs[2])
            {
                toBeMovedTo.add(4);
                toBeMovedTo.add(2);
            }
            if (pegs[8] && !pegs[9])
            {
                toBeMovedTo.add(8);
                toBeMovedTo.add(9);
            }
        }
        if (peg == 8 && pegs[8])
        {
            if (pegs[4] && !pegs[1])
            {
                toBeMovedTo.add(4);
                toBeMovedTo.add(1);
            }
            if (pegs[7] && !pegs[6])
            {
                toBeMovedTo.add(7);
                toBeMovedTo.add(6);
            }
        }
        if (peg == 9 && pegs[9])
        {
            if (pegs[5] && !pegs[2])
            {
                toBeMovedTo.add(5);
                toBeMovedTo.add(2);
            }
            if (pegs[8] && !pegs[7])
            {
                toBeMovedTo.add(8);
                toBeMovedTo.add(7);
            }
        }
        if (peg == 10 && pegs[10])
        {
            if (pegs[6] && !pegs[3])
            {
                toBeMovedTo.add(6);
                toBeMovedTo.add(3);
            }
            if (pegs[11] && !pegs[12])
            {
                toBeMovedTo.add(11);
                toBeMovedTo.add(12);
            }
        }
        if (peg == 11 && pegs[11])
        {
            if (pegs[7] && !pegs[4])
            {
                toBeMovedTo.add(7);
                toBeMovedTo.add(4);
            }
            if (pegs[12] && !pegs[13])
            {
                toBeMovedTo.add(12);
                toBeMovedTo.add(13);
            }
        }
        if (peg == 12 && pegs[12])
        {
            if (pegs[7] && !pegs[3])
            {
                toBeMovedTo.add(7);
                toBeMovedTo.add(3);
            }
            if (pegs[8] && !pegs[5])
            {
                toBeMovedTo.add(8);
                toBeMovedTo.add(5);
            }
            if (pegs[11] && !pegs[10])
            {
                toBeMovedTo.add(11);
                toBeMovedTo.add(10);
            }
            if (pegs[13] && !pegs[14])
            {
                toBeMovedTo.add(13);
                toBeMovedTo.add(14);
            }
        }
        if (peg == 13 && pegs[13])
        {
            if (pegs[8] && !pegs[4])
            {
                toBeMovedTo.add(8);
                toBeMovedTo.add(4);
            }
            if (pegs[12] && !pegs[11])
            {
                toBeMovedTo.add(12);
                toBeMovedTo.add(11);
            }
        }
        if (peg == 14 && pegs[14])
        {
            if (pegs[9] && !pegs[5])
            {
                toBeMovedTo.add(9);
                toBeMovedTo.add(5);
            }
            if (pegs[13] && !pegs[12])
            {
                toBeMovedTo.add(13);
                toBeMovedTo.add(12);
            }
        }
        
        return toBeMovedTo;
    }
    
    /**
     * Completes a movement on the peg board
     * @param startPeg the peg to be moved
     * @param midPeg the peg being jumped over
     * @param endPeg the new peg position of moving peg
     */
    public void movePeg(int startPeg, int midPeg, int endPeg)
    {
        pegs[startPeg] = false;
        pegs[midPeg] = false;
        pegs[endPeg] = true;
    }
    
    /**
     * Resets the pegs on the board
     */
    public void restart()
    {
        pegs[0] = false;
        
        for (int i = 1; i < pegs.length; i++)
        {
            pegs[i] = true;
        }
    }
    
    /**
     * Starts the game
     */
    public void startGame()
    {
        end = false;
    }
    
    /**
     * Ends the game
     */
    public void endGame()
    {
        end = true;
    }
    
    /**
     * Checks if the game has ended
     * @return if game has ended
     */
    public boolean gameEnd()
    {
        return end;
    }
}