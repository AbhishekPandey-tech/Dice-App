package com.example.diceapppractice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView diceImage1=findViewById(R.id.diceImage1);
        final ImageView diceImage2=findViewById(R.id.diceImage2);
        final int [] diceImages ={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};


        Button btnRoll = findViewById(R.id.bttnRollthedice);
       final MediaPlayer mp=MediaPlayer.create(this,R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("MyDiceApp", "Button is being Tapped");
                Random rndObject = new Random();
                int myRandomNumber=rndObject.nextInt(6);
                Log.i("MyDiceApp","My random number is "+myRandomNumber);
                diceImage1.setImageResource(diceImages[myRandomNumber]);
                int myRandomNumber2=rndObject.nextInt(6);
                diceImage2.setImageResource(diceImages[myRandomNumber2]);

                    YoYo.with(Techniques.BounceInRight)
                            .duration(700)
                            .repeat(0)
                            .playOn(findViewById(R.id.diceImage1));
                    YoYo.with(Techniques.BounceInLeft)
                            .duration(700)
                            .repeat(0)
                            .playOn(findViewById(R.id.diceImage2));
                for(int i=0;i<5;i++) {
                    mp.start();
                }
            }
        });
        
    }
}
