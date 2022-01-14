package com.unifafibe.paisesportugues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class detalhes_pais extends AppCompatActivity {

    String nome = null;
    String capital = null;
    String regiao = null;
    String subregiao = null;
    String populacao = null;
    String bandeira = null;
    Double coordenadasLat = 0.0;
    Double coordenadasLong = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pais);

        Bundle b = getIntent().getExtras();

        if(b != null)
            nome = b.getString("nome");
            System.out.println(nome);


        if(b != null)
            capital = b.getString("capital");
        System.out.println(capital);


        if(b != null)
            regiao = b.getString("regiao");
        System.out.println(regiao);


        if(b != null)
            subregiao = b.getString("subregiao");
        System.out.println(subregiao);


        if(b != null)
            populacao = b.getString("populacao");
        System.out.println(populacao);


        if(b != null)
            bandeira = b.getString("bandeira");
        System.out.println(bandeira);


        if(b != null)
            coordenadasLat = b.getDouble("coordenadasLat");
        System.out.println(coordenadasLat);


        if(b != null)
            coordenadasLong = b.getDouble("coordenadasLong");
        System.out.println(coordenadasLong);

        WebView myWebView = (WebView) findViewById(R.id.webview);

        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +

                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Detalhes País</title>\n" +
                "    <div style=\"position: relative; text-align: center;\">\n" +
                "    <img src=\"" + bandeira + "\" width=\"300\" height=\"150\">\n" +
                "    </div>\n" +
                        "    <br>\n" +
                "    \n" +
                "    <div style=\"position: relative; background-color: rgb(18, 131, 249); opacity: 0.7; border-radius: 1rem;\">\n" +
                "        <div style=\"margin-left: 10px;\" width=\"350\">\n" +
                "    <br>\n" +
                "    <h1>Nome : " + nome + "</h1>\n" +
                "    <h1>Capital : " + capital + "</h1>\n" +
                "    <h1>Região : " + regiao + "</h1>\n" +
                "    <h1>Sub-Região : " + subregiao + "</h1>\n" +
                "    <h1>População : " + populacao + "</h1>\n" +
                "    " +
                "    <br>\n" +
                "    </div>\n" +
                "    </div>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                "</body>\n" +
                "</html>";

        myWebView.loadDataWithBaseURL("", html, mimeType, encoding, "");

        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent voltarMain = new Intent(detalhes_pais.this, MainActivity.class);

                  startActivity(voltarMain);
            }
        });

        Button btnMapa = findViewById(R.id.btnMapa);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapaActivity = new Intent(detalhes_pais.this, MapsActivity.class);
                mapaActivity.putExtra("nome", nome);
                mapaActivity.putExtra("coordenadasLat", coordenadasLat);
                mapaActivity.putExtra("coordenadasLong", coordenadasLong);

                startActivity(mapaActivity);
            }
        });
    }
}