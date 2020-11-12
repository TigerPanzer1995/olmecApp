package com.example.olmecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Laguna extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    private static final String apompo = "https://www.uv.mx/noticias/2015/06/11/pachira-aquatica-o-apompo-solucion-forestal-para-humedales-tropicales/#:~:text=Pachira%20aquatica%2C%20explic%C3%B3%2C%20es%20un,los%20cauces%20de%20los%20r%C3%ADos.";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laguna);
        drawerLayout = findViewById(R.id.drawer_layout);
        Button btn_apom = findViewById(R.id.btn_apompo);
        btn_apom.setOnClickListener(this);

    }//fin del oncreate
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
        recreate();
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
        Intent intent = new Intent(Intent.ACTION_VIEW);
        switch (view.getId()){
            case R.id.btn_apompo:
                intent.setData(Uri.parse(apompo));
                startActivity(intent);

                break;
        }

    }
}//fin de la clase