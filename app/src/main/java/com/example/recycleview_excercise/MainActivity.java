package com.example.recycleview_excercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // recyclerView를 위한 adapter를 추가한다.
    GameAdapter gameAdapter;

    // recyclerView를 제어할 변후
    RecyclerView recyclerView;
    // gameTitle을 저장할 변수 배열
    private ArrayList<String> gameTitle = new ArrayList<>();
    // gameDetails를 저장할 변수 배열
    private ArrayList<String> gameDetails = new ArrayList<>();
    // gameImages 저장할 변수 배열
    private ArrayList<Integer> gameImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recyclerView를 찾아서 지정한다.
        recyclerView = findViewById(R.id.recycleView);
        // recyclerView에 Linear메니저를 설정한다. 해당 context는 MainActivity에서 관리하는 코드이다.
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // 이미지 및 string-array에 데이터를 저장한다.
        saveArray();

        gameAdapter = new GameAdapter(gameTitle, gameDetails, gameImages, MainActivity.this);

        recyclerView.setAdapter(gameAdapter);



    }

    // strings.xml에 있는 string-array와 이미지를 gameTitle, gameDetails 그리고 gameImages에 저장한다.
    private void saveArray(){
        String[] gameTitleArray = getResources().getStringArray(R.array.gameTitle);
        String[] gameDetailsArray = getResources().getStringArray(R.array.gameDetails);
        Integer[] gameImageArray = {R.drawable.portal2_logo2, R.drawable.barotrauma_logo, R.drawable.titanfall_2_logo, R.drawable.homeworld3};

        // for loop를 이용하여 타이틀, 디테일 그리고 이미지를 각각 저장합니다.
        for(int i = 0; i < gameTitleArray.length; i++){
            gameTitle.add(gameTitleArray[i]);
            gameDetails.add(gameDetailsArray[i]);
            gameImages.add(gameImageArray[i]);
        }

    }
}