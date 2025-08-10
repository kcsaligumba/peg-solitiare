public class Rules
{
    /**
     * Checks for win
     * @param board the peg board in use
     * @return true if won
     * @return false if not won
     */
    public boolean checkWin(Board board)
    {
        boolean[] pegs = board.getPegs();
        int count = 0;
        
        for (int i = 0; i < pegs.length; i++)
        {
            if (pegs[i])
            {
                count++;
            }
        }
        
        if (count == 1)
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * Checks for loss
     * @param board the peg board in use
     * @return true if lost
     * @return false if not lost
     */
    public boolean checkLoss(Board board)
    {
        boolean[] pegs = board.getPegs();
        
        for (int i = 0; i < pegs.length; i++)
        {
            if (board.checkPeg(i).size() > 0)
            {
                return false;
            }
        }
        
        return true;
    }
}