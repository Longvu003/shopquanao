package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private  int selectab=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ layout
        final LinearLayout trangchuLayout=findViewById(R.id.trangchuLayout);
        final LinearLayout danhmucLayout=findViewById(R.id.danhmucLayout);
        final LinearLayout yeuthichLayout=findViewById(R.id.yeuthich_Layout);
        final LinearLayout canhanLayout=findViewById(R.id.canhanLayout);
        //image
        final ImageView trangchuimage=findViewById(R.id.trangchuimage);
        final ImageView danhmucimage=findViewById(R.id.danhmucimage);
        final ImageView yeuthichimage=findViewById(R.id.yeuthichimage);
        final ImageView canhanimage=findViewById(R.id.canhanimage);
        //txt
        final TextView trangchutxt=findViewById(R.id.trangchutxt);
        final TextView danhmuctxt=findViewById(R.id.danhmuctxt);
        final TextView yeuthichtxt=findViewById(R.id.yeuthichtxt);
        final TextView canhantxt=findViewById(R.id.canhantxt);


        getSupportFragmentManager().beginTransaction().
                setReorderingAllowed(true).replace(R.id.Fragment_container, TrangchuFragment.class,null).
                commit();

        trangchuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectab!=1){
                    getSupportFragmentManager().beginTransaction().
                            setReorderingAllowed(true).replace(R.id.Fragment_container, TrangchuFragment.class,null).
                            commit();
                    danhmuctxt.setVisibility(View.GONE);
                    yeuthichtxt.setVisibility(View.GONE);
                    canhantxt.setVisibility(View.GONE);
                    danhmucimage.setImageResource(R.drawable.danhmuc);
                    yeuthichimage.setImageResource(R.drawable.ic_yeuthich);
                    canhanimage.setImageResource(R.drawable.ic_canhan);

                    trangchutxt.setVisibility(View.VISIBLE);
                    trangchuimage.setImageResource(R.drawable.trangchu);
                    trangchuLayout.setBackgroundResource(R.drawable.btn_background_1);
                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    trangchuLayout.startAnimation(scaleAnimation);
                    selectab=1;
                }
            }
        });
      danhmucLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(selectab!=2){
                  getSupportFragmentManager().beginTransaction().
                          setReorderingAllowed(true).replace(R.id.Fragment_container, DanhmucFragment.class,null).
                          commit();

                  trangchutxt.setVisibility(View.GONE);
                  yeuthichtxt.setVisibility(View.GONE);
                  canhantxt.setVisibility(View.GONE);

                  trangchuimage.setImageResource(R.drawable.trangchu);
                  yeuthichimage.setImageResource(R.drawable.ic_yeuthich);
                  canhanimage.setImageResource(R.drawable.ic_canhan);
                  danhmuctxt.setVisibility(View.VISIBLE);
                  danhmucimage.setImageResource(R.drawable.danhmuc);
                  danhmucLayout.setBackgroundResource(R.drawable.btn_background_1);
                  ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                  scaleAnimation.setDuration(200);
                  scaleAnimation.setFillAfter(true);
                  danhmucLayout.startAnimation(scaleAnimation);
                  selectab=2;


              }
          }
      });
      yeuthichLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(selectab!=3){
                  getSupportFragmentManager().beginTransaction().
                          setReorderingAllowed(true).replace(R.id.Fragment_container, YeuthichFragment.class,null).
                          commit();

                  trangchutxt.setVisibility(View.GONE);
                  danhmuctxt.setVisibility(View.GONE);
                  canhantxt.setVisibility(View.GONE);

                  trangchuimage.setImageResource(R.drawable.trangchu);
                  danhmucimage.setImageResource(R.drawable.danhmuc);
                  canhanimage.setImageResource(R.drawable.ic_canhan);

                   yeuthichtxt.setVisibility(View.VISIBLE);
                  yeuthichimage.setImageResource(R.drawable.ic_yeuthich);
                  yeuthichLayout.setBackgroundResource(R.drawable.white);
                  ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                  scaleAnimation.setDuration(200);
                  scaleAnimation.setFillAfter(true);
                  yeuthichLayout.startAnimation(scaleAnimation);
                  selectab=3;

              }
          }
      });
      canhanLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(selectab!=4){
                  getSupportFragmentManager().beginTransaction().
                          setReorderingAllowed(true).replace(R.id.Fragment_container, CanhanFragment.class,null).
                          commit();

                  trangchutxt.setVisibility(View.GONE);
                  danhmuctxt.setVisibility(View.GONE);
                  yeuthichtxt.setVisibility(View.GONE);

                  trangchuimage.setImageResource(R.drawable.trangchu);
                  danhmucimage.setImageResource(R.drawable.danhmuc);
                  yeuthichimage.setImageResource(R.drawable.ic_yeuthich);

                  canhantxt.setVisibility(View.VISIBLE);
                  canhanimage.setImageResource(R.drawable.ic_canhan);
                  canhanLayout.setBackgroundResource(R.drawable.white);
                  ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                  scaleAnimation.setDuration(200);
                  scaleAnimation.setFillAfter(true);
                  canhanLayout.startAnimation(scaleAnimation);
                  selectab=4;
              }
          }
      });
    }

}