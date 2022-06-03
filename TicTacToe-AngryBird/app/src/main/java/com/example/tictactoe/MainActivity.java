package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean iswinner=false;
    int image_clicked=-1;
    int player=1;  //player one is cross
    int [][]winningStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        image_clicked=gameState[tag];
        if(iswinner==false && image_clicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.bird1);
                gameState[tag] = 1;
                Toast.makeText(this, "Pos: " + tag + "   Sym:" + " Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else if (player == 0) {
                v.setImageResource(R.drawable.bird2);
                gameState[tag] = 0;
                Toast.makeText(this, "Pos: " + tag + "   Sym:" + " Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }

            for (int i = 0; i < winningStates.length; i++) {
                if (gameState[winningStates[i][0]] != -1 && gameState[winningStates[i][0]] == gameState[winningStates[i][1]] && gameState[winningStates[i][1]] == gameState[winningStates[i][2]]) {
                    iswinner = true;
                    if (gameState[winningStates[i][0]] == 1) {
                        Toast.makeText(this, "player 1(with Red) won the game", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "player 2(with Green) won the game", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
    public void restart(View view){
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        int tot_images=gridLayout.getChildCount();
        for(int i=0;i<tot_images;i++){
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        iswinner=false;
        image_clicked=-1;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=-1;
        }
        player=1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}