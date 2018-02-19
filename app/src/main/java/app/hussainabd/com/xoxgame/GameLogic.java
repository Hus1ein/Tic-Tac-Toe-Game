package app.hussainabd.com.xoxgame;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class GameLogic {
    // 1 for player1, 2 for player2 .
    private int roleOf;
    private int[][] forWin = {{1,2,3},{4,5,6},{7,8,9},
            {1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    private List<Integer> selectedBtnsPlayer1;
    private List<Integer> selectedBtnsPlayer2;
    private List<Button> btns;
    private String player1Name, player2Name;
    public GameLogic(List<Button>pBtns, String pPlayer1Name, String pPlayer2Name)
    {
        this.player1Name = pPlayer1Name;
        this.player2Name = pPlayer2Name;
        this.roleOf = 1;
        this.selectedBtnsPlayer1 = new ArrayList<>();
        this.selectedBtnsPlayer2 = new ArrayList<>();
        this.btns = pBtns;
    }
    public void logicFunction(Context context, Button btn, Button btnOfPlayer1, Button btnOfPlayer2, int buttonNum)
    {
        boolean  gameOverVar;
        if(roleOf == 1)
        {
            btn.setBackground(ContextCompat.getDrawable(context,R.drawable.x));
            btn.setEnabled(false);
            btnOfPlayer1.setEnabled(false);
            btnOfPlayer2.setEnabled(true);
            btnOfPlayer1.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPlayerBtn));
            btnOfPlayer2.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPlay));
            selectedBtnsPlayer1.add(buttonNum);
            roleOf = 2;
            if(gameOver(context, 1))
            {
                endGame(context, btns, btnOfPlayer1, btnOfPlayer2);
            }

        }
        else if(roleOf == 2)
        {
            btn.setBackground(ContextCompat.getDrawable(context,R.drawable.o));
            btn.setEnabled(false);
            btnOfPlayer1.setEnabled(true);
            btnOfPlayer2.setEnabled(false);
            btnOfPlayer1.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPlay));
            btnOfPlayer2.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPlayerBtn));
            selectedBtnsPlayer2.add(buttonNum);
            roleOf = 1;
            if(gameOver(context, 2))
            {
                endGame(context, btns, btnOfPlayer1, btnOfPlayer2);
            }
        }

    }
    private boolean gameOver(Context context, int pRoleOf)
    {
        boolean test = false;
        int counter = 0;
        if(pRoleOf == 1)
        {
            for(int i=0; i<8; i++)
            {
                for(int j=0; j<3; j++)
                {
                    for(int k=0; k<selectedBtnsPlayer1.size(); k++)
                    {
                        if(forWin[i][j] == selectedBtnsPlayer1.get(k))
                        {
                            test = true;
                            counter++;
                            break;
                        }
                    }
                }
                if(counter == 3)
                {
                    Toast.makeText(context,player1Name + " win", Toast.LENGTH_LONG).show();
                    return true;
                }
                else
                    counter = 0;
            }
        }
        else if(pRoleOf == 2)
        {
            for(int i=0; i<8; i++)
            {
                for(int j=0; j<3; j++)
                {
                    for(int k=0; k<selectedBtnsPlayer2.size(); k++)
                    {
                        if(forWin[i][j] == selectedBtnsPlayer2.get(k))
                        {
                            test = true;
                            counter++;
                            break;
                        }
                    }
                }
                if(counter == 3)
                {
                    Toast.makeText(context,player2Name +" win", Toast.LENGTH_LONG).show();
                    return true;
                }
                else
                    counter = 0;
            }
        }
        return false;
    }

    public void endGame(Context context, List<Button> pBtns, Button player1, Button player2)
    {
        for(int i=0; i<pBtns.size() -1; i++)
        {
            pBtns.get(i).setEnabled(false);

        }
        player1.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPlayerBtn));
        player2.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPlayerBtn));
        player1.setEnabled(false);
        player2.setEnabled(false);
        pBtns.get(9).setEnabled(true);
        pBtns.get(9).setBackgroundColor(ContextCompat.getColor(context,R.color.colorPlay));

    }
    public void newGame(Context context, List<Button> pBtns, Button player1, Button player2)
    {
        roleOf = 1;
        player1.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPlay));
        player2.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPlayerBtn));
        player1.setEnabled(true);
        player2.setEnabled(false);
        for(int i=0; i<pBtns.size() -1; i++)
        {
            pBtns.get(i).setEnabled(true);
            pBtns.get(i).setBackgroundColor(ContextCompat.getColor(context,R.color.colorButton));
            this.selectedBtnsPlayer1 = new ArrayList<>();
            this.selectedBtnsPlayer2 = new ArrayList<>();

        }
        pBtns.get(9).setEnabled(false);
        pBtns.get(9).setBackgroundColor(ContextCompat.getColor(context,R.color.colorPlayerBtn));

    }
    

}
