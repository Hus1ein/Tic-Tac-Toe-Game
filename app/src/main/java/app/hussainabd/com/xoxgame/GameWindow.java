package app.hussainabd.com.xoxgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class GameWindow extends AppCompatActivity {

    private Intent i;
    private Button player1Btn;
    private Button player2Btn;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, newGameBtn;
    private GameLogic gameLogic;
    private List<Button> btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);
        player1Btn = (Button)findViewById(R.id.player1_btn);
        player2Btn = (Button)findViewById(R.id.player2_btn);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        newGameBtn = (Button)findViewById(R.id.new_game_btn);
        ////////////////////////////////
        this.btns = new ArrayList<>();
        btns.add(btn1); btns.add(btn2); btns.add(btn3);
        btns.add(btn4); btns.add(btn5); btns.add(btn6);
        btns.add(btn7); btns.add(btn8); btns.add(btn9);
        btns.add(newGameBtn);
        /////////////////////////////////
        i = getIntent();
        String player1String = i.getStringExtra("player1");
        String player2String = i.getStringExtra("player2");
        gameLogic = new GameLogic(btns, player1String, player2String);
        player1Btn.setText(player1String + ": X");
        player2Btn.setText(player2String + ": O");
        player1Btn.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPlay));
        player2Btn.setEnabled(false);
        newGameBtn.setEnabled(false);
    }

    public void btn1Click(View view) {
        gameLogic.logicFunction(this, btn1, player1Btn, player2Btn, 1);
    }

    public void btn2Click(View view) {
        gameLogic.logicFunction(this, btn2, player1Btn, player2Btn, 2);
    }

    public void btn3Click(View view) {
        gameLogic.logicFunction(this, btn3, player1Btn, player2Btn, 3);
    }

    public void btn4Click(View view) {
        gameLogic.logicFunction(this, btn4, player1Btn, player2Btn, 4);
    }

    public void btn5Click(View view) {
        gameLogic.logicFunction(this, btn5, player1Btn, player2Btn, 5);
    }

    public void btn6Click(View view) {
        gameLogic.logicFunction(this, btn6, player1Btn, player2Btn, 6);
    }

    public void btn7Click(View view) {
        gameLogic.logicFunction(this, btn7, player1Btn, player2Btn, 7);
    }

    public void btn8Click(View view) {
        gameLogic.logicFunction(this, btn8, player1Btn, player2Btn, 8);
    }

    public void btn9Click(View view) {
        gameLogic.logicFunction(this, btn9, player1Btn, player2Btn, 9);
    }

    public void newGameClick(View view) {
        gameLogic.newGame(this, btns, player1Btn, player2Btn);
    }
}
