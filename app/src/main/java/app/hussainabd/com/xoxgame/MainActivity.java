package app.hussainabd.com.xoxgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText player1;
    private EditText player2;
    private Button startBtn;
    //private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = (EditText)findViewById(R.id.player1);
        player2 = (EditText)findViewById(R.id.player2);
        startBtn = (Button)findViewById(R.id.start_click);
    }

    public void startBtnClick(View view) {
        Intent i = new Intent(this, GameWindow.class);
        i.putExtra("player1", player1.getText().toString());
        i.putExtra("player2", player2.getText().toString());
        startActivity(i);
    }

}
