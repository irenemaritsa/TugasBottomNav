package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    public final static String name = "COMPUTER_NAME";
    public final static String detail = "COMPUTER_SUMMARY";
    public final static String photo = "COMPUTER_PHOTO";

    private ImageView ivHeroPhoto;
    private TextView tvHeroName;
    private TextView tvHeroDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ivHeroPhoto = findViewById(R.id.imgHero);
        tvHeroName = findViewById(R.id.namaHero);
        tvHeroDetail = findViewById(R.id.detailHero);

        tvHeroName.setText(getIntent().getStringExtra(name));
        ivHeroPhoto.setImageResource(getIntent().getIntExtra(photo, 0));
        tvHeroDetail.setText(getIntent().getStringExtra(detail));
    }
}