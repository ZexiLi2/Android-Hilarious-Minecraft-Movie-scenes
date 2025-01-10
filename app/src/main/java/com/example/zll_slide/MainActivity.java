package com.example.zll_slide;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ViewFlipper vflipper;
    Button button;
    boolean isFlipping = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vflipper = findViewById(R.id.vflipper);
        button  = findViewById(R.id.button3);

        int img[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12};

        for (int imatge : img) {
            flipperImg(imatge);
        }

        button.setOnClickListener(v -> {
            if (isFlipping) {
                vflipper.stopFlipping();  // Stop the carousel
                button.setBackgroundColor(Color.RED);
                button.setText("Slider is STOPPED");
                isFlipping = false;  // Set the state to paused
            } else {
                vflipper.startFlipping();  // Start the carousel
                button.setBackgroundColor(Color.GREEN);
                button.setText("Slider is RESUMED");
                isFlipping = true;  // Set the state to playing
            }
        });

    }

    public void flipperImg (int imatge) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(imatge);

        vflipper.addView(imageView);
        vflipper.setFlipInterval(2500);
        vflipper.setAutoStart(true);

    }
}