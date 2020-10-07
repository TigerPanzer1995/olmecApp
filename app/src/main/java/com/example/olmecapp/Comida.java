package com.example.olmecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Comida extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);
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
        recreate();
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
}//fin de la clase