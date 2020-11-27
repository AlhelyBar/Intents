package com.alhelybar.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnContextClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnContextClickListener(this);
        findViewById(R.id.btn2).setOnContextClickListener(this);
        findViewById(R.id.btn3).setOnContextClickListener(this);
        findViewById(R.id.btn4).setOnContextClickListener(this);
        findViewById(R.id.btn5).setOnContextClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8711310352"));
                startActivity(i);
                break;

            case R.id.btn2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ViWr4rzBgXk&list=RDViWr4rzBgXk&start_radio=1")));
                break;

            case R.id.btn3:
                Intent correo = new Intent(Intent.ACTION_SEND);
                correo.putExtra(Intent.EXTRA_EMAIL, "alhely.bar@gmail.com");
                correo.putExtra(Intent.EXTRA_SUBJECT, "asunto");
                correo.putExtra(Intent.EXTRA_TEXT, "cuerpo");

                startActivity(Intent.createChooser(correo, "Enviar"));
                break;

            case R.id.btn4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0")));
                break;

            case R.id.btn5:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:8711310352")));
                break;
        }
    }

    @Override
    public boolean onContextClick(View v) {
        return false;
    }
}