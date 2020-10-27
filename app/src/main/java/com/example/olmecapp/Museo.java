package com.example.olmecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Museo extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    private FloatingActionButton btn_F_Museo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);
        drawerLayout = findViewById(R.id.drawer_layout);
        btn_F_Museo= findViewById(R.id.btnFloatMuseo);
        btn_F_Museo.setOnClickListener(this);
    }//fin del concreate
    public void ClickMenu(View view){
        Inicio.openDrawable(drawerLayout);
    }
    public void ClickLogo(View view){
        Inicio.closeDrawer(drawerLayout);
    }
    public void ClickInicio(View view){
        Inicio.redirectActivity(this,Inicio.class);
    }
    public void ClickMuseo(View view){
        recreate();
    }
    public  void ClickLoma(View view){
        Inicio.redirectActivity(this,Loma.class);
    }
    public void ClickLaguna(View view){
        Inicio.redirectActivity(this,Laguna.class);
    }
    public  void ClickComida(View view){
        Inicio.redirectActivity(this,Comida.class);
    }
    public void ClickHotel( View view){
        Inicio.redirectActivity(this,Hotel.class);
    }
    public void ClickSalir(View view){
        Inicio.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Inicio.closeDrawer(drawerLayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFloatMuseo:
                Intent intent = new Intent(Museo.this, GaleriaMuseo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }

    }
}//fin de la clase