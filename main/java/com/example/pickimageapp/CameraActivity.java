package com.example.pickimageapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.pickimageapp.databinding.ActivityCameraBinding;
import com.example.pickimageapp.databinding.ActivityMainBinding;

public class CameraActivity extends AppCompatActivity {
ActivityCameraBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCameraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCaputre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent takepicture=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takepicture,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==2){
            Bundle bundle=data.getExtras();
            Bitmap imageBitmap=(Bitmap) bundle.get("data");
            binding.image1.setImageBitmap(imageBitmap);
        }
    }
}