package com.example.olmecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class GaleriaMuseo extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private StackView stackView_Museo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_museo);
        drawerLayout = findViewById(R.id.drawer_layout);
        stackView_Museo = findViewById(R.id.stack_view);

        MainAdapterStackMuseo adapter = new MainAdapterStackMuseo(numberWord(), numberImage()
                ,R.layout.item_museo,GaleriaMuseo.this);
        stackView_Museo.setAdapter(adapter);

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

    private List<String> numberWord(){
        List<String> word = new ArrayList<>();
        word.add("Entrada al museo");
        word.add("Entrada al museo");
        word.add("Cabeza colosal de Hueyapan");
        word.add("Osamenta encontrada en los años 90");
        word.add("Estela D");
        word.add("Herramientas de obsidiana");
        word.add("Piezas de ceramicas");
        word.add("Salas del museo");
        word.add("Salas del museo");
        word.add("Salas del museo");
        word.add("Salas del museo");
        return word;
    }

    private List<Integer> numberImage(){
        List<Integer> image = new ArrayList<>();
        image.add(R.drawable.stv_entra);
        image.add(R.drawable.stv_entrada);
        image.add(R.drawable.stv_cabeza);
        image.add(R.drawable.stv_osamenta);
        image.add(R.drawable.stv_estela);
        image.add(R.drawable.herramientas_obsidiana);
        image.add(R.drawable.stv_cuentas);
        image.add(R.drawable.stv_museo);
        image.add(R.drawable.stv_museo1);
        image.add(R.drawable.stv_museo2);
        image.add(R.drawable.stv_museo3);
        return image;

    }
}//fin de la clase