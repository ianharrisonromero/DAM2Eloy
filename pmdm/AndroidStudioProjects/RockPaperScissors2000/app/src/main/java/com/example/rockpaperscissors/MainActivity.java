package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btRestart;
    ImageView ivRock, ivRockCpu, ivPaper, ivPaperCpu, ivScissors, ivScissorsCpu;
    TextView tvUser, tvCpu, tvUserScore, tvCpuScore, tvTitle, tvCpuChose,tvResultWin, tvResultLost, tvResultDraw;

    private final int INITIAL_SCORE=0, FINAL_SCORE=0;
    boolean gameEnded = false;

    //ENUMS
    public enum Selection{
        ROCK, PAPER, SCISSORS;
    }

    private void setResultsGone(){
        tvResultLost.setVisibility(View.GONE);
        tvResultWin.setVisibility(View.GONE);
        tvResultDraw.setVisibility(View.GONE);
    }
    View.OnClickListener OnRPSClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (!gameEnded) {
                setResultsGone();
                Selection CPUSelection = CPURandomSelection();
                switch ((Selection) v.getTag()) {
                    case ROCK:
                        if (CPUSelection == Selection.ROCK) {
                            tvResultDraw.setVisibility(View.VISIBLE);
                        } else if (CPUSelection == Selection.SCISSORS) {
                            tvUserScore.setText(String.valueOf(Integer.parseInt(tvUserScore.getText().toString()) + 1));
                            tvResultWin.setVisibility(View.VISIBLE);
                        } else if (CPUSelection == Selection.PAPER) {
                            tvCpuScore.setText(String.valueOf(Integer.parseInt(tvCpuScore.getText().toString()) + 1));
                            tvResultLost.setVisibility(View.VISIBLE);
                        }
                        break;
                    case PAPER:
                        if (CPUSelection == Selection.PAPER) {
                            tvResultDraw.setVisibility(View.VISIBLE);
                        } else if (CPUSelection == Selection.ROCK) {
                            tvUserScore.setText(String.valueOf(Integer.parseInt(tvUserScore.getText().toString()) + 1));
                            tvResultWin.setVisibility(View.VISIBLE);
                        } else if (CPUSelection == Selection.SCISSORS) {
                            tvCpuScore.setText(String.valueOf(Integer.parseInt(tvCpuScore.getText().toString()) + 1));
                            tvResultLost.setVisibility(View.VISIBLE);
                        }
                        break;
                    case SCISSORS:
                        if (CPUSelection == Selection.SCISSORS) {
                            tvResultDraw.setVisibility(View.VISIBLE);
                        } else if (CPUSelection == Selection.PAPER) {
                            tvUserScore.setText(String.valueOf(Integer.parseInt(tvUserScore.getText().toString()) + 1));
                            tvResultWin.setVisibility(View.VISIBLE);
                        } else if (CPUSelection == Selection.ROCK) {
                            tvCpuScore.setText(String.valueOf(Integer.parseInt(tvCpuScore.getText().toString()) + 1));
                            tvResultLost.setVisibility(View.VISIBLE);
                        }
                        break;
                }

                if (Integer.parseInt(tvUserScore.getText().toString())==3 || Integer.parseInt(tvCpuScore.getText().toString())==3){
                    gameEnded = true;
                }

            }
        }
    };

    private Selection CPURandomSelection(){
        Random random = new Random();
        int randomNum = random.nextInt(3);

        switch (randomNum){
            case 0 : return Selection.ROCK;
            case 1 : return Selection.PAPER;
            case 2 : return  Selection.SCISSORS;
            default: return Selection.ROCK; //Justin Case
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRestart = findViewById(R.id.btRestart);
        ivRock = findViewById(R.id.ivRock);
        ivPaper = findViewById(R.id.ivPaper);
        ivScissors = findViewById(R.id.ivScissors);
        ivRockCpu = findViewById(R.id.ivRockCpu);
        ivPaperCpu = findViewById(R.id.ivPaperCpu);
        ivScissorsCpu = findViewById(R.id.ivScissorsCpu);
        tvTitle = findViewById(R.id.tvTitle);
        tvUser = findViewById(R.id.tvUser);
        tvUserScore = findViewById(R.id.tvUserScore);
        tvCpu = findViewById(R.id.tvCpu);
        tvCpuScore = findViewById(R.id.tvCpuScore);
        tvCpuChose = findViewById(R.id.tvCpuChose);
        tvResultWin = findViewById(R.id.tvResultWin);
        tvResultLost = findViewById(R.id.tvResultLost);
        tvResultDraw = findViewById(R.id.tvResultDraw);
        //invisibles/gone
        tvCpuChose.setVisibility(View.GONE);
        ivRockCpu.setVisibility(View.GONE);
        ivPaperCpu.setVisibility(View.GONE);
        ivScissorsCpu.setVisibility(View.GONE);
        tvResultLost.setVisibility(View.GONE);
        tvResultWin.setVisibility(View.GONE);
        tvResultDraw.setVisibility(View.GONE);

        //set on RPS click listener
        ivRock.setOnClickListener(OnRPSClick);
        ivPaper.setOnClickListener(OnRPSClick);
        ivScissors.setOnClickListener(OnRPSClick);

        //setting tags
        ivRock.setTag(Selection.ROCK);
        ivPaper.setTag(Selection.PAPER);
        ivScissors.setTag(Selection.SCISSORS);

        //restart button
        btRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultsGone();
                tvCpuScore.setText(INITIAL_SCORE);
                tvUserScore.setText(INITIAL_SCORE);
            }
        });
    }
}
