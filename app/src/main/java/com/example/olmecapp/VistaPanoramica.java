package com.example.olmecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import co.gofynd.gravityview.GravityView;

public class VistaPanoramica extends AppCompatActivity {
    DrawerLayout drawerLayout;

    private ImageView imageView;
    private GravityView gravityView;
    private boolean esSoportado= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_panoramica);
        init();
        if (esSoportado){
            this.gravityView.setImage(imageView, R.drawable.prueba).center();

        }else {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.prueba);
            imageView.setImageBitmap(bitmap);

        }

    }//fin del oncreate
    public void ClickVolver(View view){
        onBackPressed();
    }

    private void init() {
        this.imageView = findViewById(R.id.imageView);
        this.gravityView = GravityView.getInstance(getBaseContext());
        this.esSoportado = gravityView.deviceSupported();

    }
    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }
}//fin de la clase