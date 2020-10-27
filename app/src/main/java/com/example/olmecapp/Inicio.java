package com.example.olmecapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        drawerLayout = findViewById(R.id.drawer_layout);
        viewPager2= findViewById(R.id.viewPagerImageSlider);

        //Aaquí pongo la lista de imagenes
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.cabeza));
        sliderItems.add(new SliderItem(R.drawable.museo));
        sliderItems.add(new SliderItem(R.drawable.vasijas));
        sliderItems.add(new SliderItem(R.drawable.loma));
        sliderItems.add(new SliderItem(R.drawable.laguna));
        sliderItems.add(new SliderItem(R.drawable.resta));
        sliderItems.add(new SliderItem(R.drawable.hotel));


        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);

            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });
    }
    public void ClickMenu(View view){
        //abre el drawer
        openDrawable(drawerLayout);
    }

    public static void openDrawable(DrawerLayout drawerLayout) {
        //abre el drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        //cierra el drawer
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        //cierra el drawer layout
        //verifica el estado del mismo
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //cuando esta abierto
            //se cierra
            drawerLayout.closeDrawer(GravityCompat.START);
        }


    }
    public  void ClickInicio(View view){
        //vuelve a cargar la actividad
        recreate();
    }
    public void ClickMuseo (View view){
        //redirecciona a esa actividad
        redirectActivity(this,Museo.class);
    }
    public void ClickLoma( View view){
        redirectActivity(this,Loma.class);
    }
    public void ClickLaguna(View view){
        redirectActivity(this,Laguna.class);
    }
    public void ClickComida(View view){
        redirectActivity(this,Comida.class);
    }
    public void ClickHotel( View view){
        redirectActivity(this,Hotel.class);

    }
    public void ClickSalir(View view){
        logout(this);
    }
    public void ClickBrujula(View view){
        redirectActivity(this,Brujula.class);
    }

    public static void logout(final Activity activity) {
        //inicializa cuadro de dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Salir");
        builder.setMessage("¿Esta seguro de cerrar su sesión?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finishAffinity();
                System.exit(0);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });
        builder.show();

    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //realizamos un intent
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable,3000);
    }
}