package com.example.olmecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Hotel extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        drawerLayout = findViewById(R.id.drawer_layout);
    }//fin del onCreate
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
        Inicio.redirectActivity(this,Museo.class);
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
        recreate();
    }
    public void ClickSalir(View view){
        Inicio.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Inicio.closeDrawer(drawerLayout);
    }
}//fin de la clase