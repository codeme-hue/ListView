package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

  private TextView tvTitle, tvDesc;
  private ImageView ivImage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    setTitle("Description");

    tvTitle = findViewById(R.id.tv_title);
    tvDesc = findViewById(R.id.tv_desc);
    ivImage = findViewById(R.id.image);
    tvTitle.setText(getIntent().getStringExtra("title"));
    tvDesc.setText(getIntent().getIntExtra("desc", 0));
    ivImage.setImageResource(getIntent().getIntExtra("image", 0));


  }
}
