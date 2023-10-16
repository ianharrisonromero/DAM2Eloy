package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btRestart;
    ImageView ivRock, ivRockCpu, ivPaper, ivPaperCpu, ivScissors, ivScissorsCpu;
    TextView tvUser, tvCpu, tvScore, tvUserScore, tvCpuScore, tvTitle, tvCpuChose,tvResultWin, tvResultLost;
    public enum Selection{
        ROCK, PAPER, SCISSORS;
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
        tvScore = findViewById(R.id.tvScore);
        tvResultWin = findViewById(R.id.tvResultWin);
        tvResultLost = findViewById(R.id.tvResultLost);
        //invisibles
        tvCpuChose.setVisibility(View.GONE);
        ivRockCpu.setVisibility(View.GONE);
        ivPaperCpu.setVisibility(View.GONE);
        ivScissorsCpu.setVisibility(View.GONE);
        tvResultLost.setVisibility(View.GONE);
        tvResultWin.setVisibility(View.GONE);

        ivRock.setOnClickListener(v -> {


        });





    }
}
