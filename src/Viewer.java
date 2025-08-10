import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.Objects;

public class Viewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        ImageIcon icon  = new ImageIcon(Objects.requireNonNull(Viewer.class.getResource("/uiuc2.png"), "Missing uiuc2.png"));
        ImageIcon icon2 = new ImageIcon(Objects.requireNonNull(Viewer.class.getResource("/sphere.png"),  "Missing sphere.png"));
        ImageIcon icon3 = new ImageIcon(Objects.requireNonNull(Viewer.class.getResource("/uiuc3.png"), "Missing uiuc3.png"));
        ImageIcon icon4 = new ImageIcon(Objects.requireNonNull(Viewer.class.getResource("/replay.png"), "Missing replay.png"));
        ImageIcon icon5 = new ImageIcon(Objects.requireNonNull(Viewer.class.getResource("/moves.png"),  "Missing moves.png"));

        
        JButton restartButton = new JButton(icon4);
        restartButton.setBounds(0, 0, 100, 100);
        restartButton.setOpaque(false);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorderPainted(false);
        panel.add(restartButton);
        
        JLabel movesLabel = new JLabel(icon5);
        movesLabel.setBounds(275, 0, 100, 100);
        movesLabel.setOpaque(false);
        panel.add(movesLabel);
        
        JLabel movesNum = new JLabel("0");
        movesNum.setBounds(400, 0, 100, 100);
        movesNum.setOpaque(false);
        movesNum.setFont(new Font("Courier", Font.BOLD, 35));
        panel.add(movesNum);
        
        JLabel ranOutOfMoves = new JLabel("You ran out of moves.");
        ranOutOfMoves.setBounds(175, 200, 400, 300);
        ranOutOfMoves.setOpaque(false);
        ranOutOfMoves.setFont(new Font("Courier", Font.BOLD, 35));
        ranOutOfMoves.setVisible(false);
        panel.add(ranOutOfMoves);
        
        JLabel won = new JLabel("You won!");
        won.setBounds(275, 200, 200, 300);
        won.setOpaque(false);
        won.setFont(new Font("Courier", Font.BOLD, 35));
        won.setVisible(false);
        panel.add(won);
        
        JButton[] buttons = {new JButton(icon2), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon)};
        buttons[0].setBounds(300, 100, 100, 100);
        buttons[1].setBounds(250, 200, 100, 100);
        buttons[2].setBounds(350, 200, 100, 100);
        buttons[3].setBounds(200, 300, 100, 100);
        buttons[4].setBounds(300, 300, 100, 100);
        buttons[5].setBounds(400, 300, 100, 100);
        buttons[6].setBounds(150, 400, 100, 100);
        buttons[7].setBounds(250, 400, 100, 100);
        buttons[8].setBounds(350, 400, 100, 100);
        buttons[9].setBounds(450, 400, 100, 100);
        buttons[10].setBounds(100, 500,100, 100);
        buttons[11].setBounds(200, 500,100, 100);
        buttons[12].setBounds(300, 500,100, 100);
        buttons[13].setBounds(400, 500,100, 100);
        buttons[14].setBounds(500, 500,100, 100);
        
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
        }
        
        for (int i = 0; i < buttons.length; i++)
        {
            panel.add(buttons[i]);
        }
        
        panel.setLayout(null);
        frame.add(panel);
        
        class Click implements ActionListener
        {
            Board board = new Board();
            Rules rules = new Rules();
            int moves = 0;
            int count = 0;
            ArrayList<Integer> moveOptions = new ArrayList<Integer>();
            
            public void actionPerformed(ActionEvent event)
            {
                if (!board.gameEnd())
                {
                    for (int i = 0; i < buttons.length; i++)
                    {
                        //Normal move selection
                        if (buttons[i] == event.getSource() && count == 0)
                        {
                            ArrayList<Integer> pegMove = board.checkPeg(i);
                            
                            if (pegMove.size() > 0 && count == 0)
                            {
                                //If only one move option available
                                if (pegMove.size() == 2)
                                {
                                    board.movePeg(i, pegMove.get(0), pegMove.get(1));
                                    buttons[i].setIcon(icon2);
                                    buttons[pegMove.get(0)].setIcon(icon2);
                                    buttons[pegMove.get(1)].setIcon(icon);
                                    moves++;
                                }
                                
                                //If more than one move option available
                                if (pegMove.size() > 2)
                                {
                                    for (int j = 1; j < pegMove.size(); j += 2)
                                    {
                                        buttons[pegMove.get(j)].setIcon(icon3);
                                    }
                                    
                                    moveOptions.add(i);
                                    
                                    for (int j = 0; j < pegMove.size(); j++)
                                    {
                                        moveOptions.add(pegMove.get(j));
                                    }
                                    
                                    count++;
                                }
                            }
                            
                            break;
                        }
                        
                        //Move selection when more than one move option available
                        if (buttons[i] == event.getSource() && count == 1)
                        {
                            for (int j = 2; j < moveOptions.size(); j += 2)
                            {
                                if (i == moveOptions.get(j))
                                {
                                    board.movePeg(moveOptions.get(0), moveOptions.get(j - 1), i);
                                    buttons[moveOptions.get(0)].setIcon(icon2);
                                    buttons[moveOptions.get(j - 1)].setIcon(icon2);
                                    buttons[i].setIcon(icon);
                                    moves++;
                                        
                                    for (int k = 2; k < moveOptions.size(); k += 2)
                                    {
                                        if (k != j)
                                        {
                                            buttons[moveOptions.get(k)].setIcon(icon2);
                                        }
                                    }
                                    
                                    while (moveOptions.size() > 0)
                                    {
                                        moveOptions.remove(0);
                                    }
                                    
                                    count--;
                                    break;
                                }
                            }
                            
                            break;
                        }
                    }
                    
                    //Check for win
                    if (rules.checkWin(board))
                    {
                        won.setVisible(true);
                        
                        for (int i = 0; i < buttons.length; i++)
                        {
                            buttons[i].setVisible(false);
                        }
                        
                        board.endGame();
                    }
                    //Check for loss
                    else if (rules.checkLoss(board))
                    {
                        ranOutOfMoves.setVisible(true);
                        
                        for (int i = 0; i < buttons.length; i++)
                        {
                            buttons[i].setVisible(false);
                        }
                        
                        board.endGame();
                    }
                }
                
                //If restart button is pressed
                if (restartButton == event.getSource())
                {
                    won.setVisible(false);
                    ranOutOfMoves.setVisible(false);
                    
                    board.startGame();
                    board.restart();
                    
                    buttons[0].setIcon(icon2);
                    buttons[0].setVisible(true);
                    
                    for (int i = 1; i < buttons.length; i++)
                    {
                        buttons[i].setVisible(true);
                        buttons[i].setIcon(icon);
                    }
                    
                    moves = 0;
                }
                
                //Moves counter
                movesNum.setText(String.valueOf(moves));
            }
        }
        
        ActionListener listener = new Click();
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].addActionListener(listener);
        }
        
        restartButton.addActionListener(listener);
        
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}