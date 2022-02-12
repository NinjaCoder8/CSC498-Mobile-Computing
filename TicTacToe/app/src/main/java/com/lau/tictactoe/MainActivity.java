package com.lau.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player = 0; //0: red, 1: yellow, -1: empty (state)
    boolean game_active = true;
    int[] game_state = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    int[][] winning_states = { {0,1,2}, {3,4,5}, {6,7,8}, {0,4,8}, {2,4,6}, {0,3,6}, {1,4,7}, {2,5,8} };
    TextView winning_status;
    Button play_again;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winning_status = (TextView) findViewById(R.id.winView);
        winning_status.setText("");
        play_again = (Button) findViewById(R.id.playView);
        play_again.setVisibility(View.GONE);
        counter = 0;
    }

    public void reset(View view){
        player = 0;
        game_active = true;
        counter = 0;
        for(int i=0; i< 9; i++){
            game_state[i] = -1;
        }
        winning_status.setText("");
        play_again.setVisibility(View.GONE);


        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);
        ImageView img;
        for(int i =0; i< 9; i++){
            img = (ImageView) grid.getChildAt(i);
            img.setImageDrawable(null);
        }
    }

    public void tic(View view){

        ImageView tic = (ImageView) view;
        Log.i("Tag:", tic.getTag().toString());
        int tic_tag = Integer.parseInt(tic.getTag().toString());

        if(game_state[tic_tag] == -1 && game_active){
            counter++;

            tic.setTranslationY(-1500);
            game_state[tic_tag] = player;

            if(player == 0){
                tic.setImageResource(R.drawable.red);
                player = 1;
            }else{
                tic.setImageResource(R.drawable.yellow);
                player = 0;
            }

            tic.animate().translationYBy(1500).rotation(3600).setDuration(600);

            for(int[] winning_state: winning_states){
                if(game_state[winning_state[0]] == game_state[winning_state[1]] && game_state[winning_state[1]] == game_state[winning_state[2]] && game_state[winning_state[0]] != -1){
                    if(player == 1){
                        //Toast.makeText(this, "Red has won", Toast.LENGTH_LONG).show();
                        winning_status.setText("Red has won!!");
                    }else{
                        //Toast.makeText(this, "Yellow has won", Toast.LENGTH_LONG).show();
                        winning_status.setText("Yellow has won!!");
                    }
                    game_active = false;
                    play_again.setVisibility(View.VISIBLE);
                }
            }

            if(counter == 9){
                winning_status.setText("It's a tie!");
                play_again.setVisibility(View.VISIBLE);
            }
        }


    }
}