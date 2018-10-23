package com.bilwg.app.shayri2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  public void Friendship(View v)
    {
        Intent friendIntent = new Intent(this,friendship.class);
        startActivity(friendIntent);
    }
    public void sad(View v)
    {
        Intent sadIntent= new Intent(this, sad.class);
        startActivity(sadIntent);
    }
    public void love(View v)
    {
        Intent loveIntent= new Intent(this, love.class);
        startActivity(loveIntent);
    }
    public void funny(View v)
    {
        Intent funnyIntent = new Intent(this,funny.class);
        startActivity(funnyIntent);
    }
    public void dbs(View v)
    {
        Intent dbsIntent = new Intent(this,dbs.class);
        startActivity(dbsIntent);
    }
    public void best(View v)
    {
        Intent bestIntent = new Intent(this,best.class);
        startActivity(bestIntent);
    }
    public void skm(View v)
    {
        Intent skmIntent = new Intent(this,skm.class);
        startActivity(skmIntent);
    }
}
