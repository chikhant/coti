package com.example.andrew.mariogame;


import android.os.Bundle;
import android.app.Activity;

/**
 * Created by Anissa on 13-May-15.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super . onCreate ( savedInstanceState ) ;
        setContentView(new MarioView(getBaseContext())) ;
    }
}
