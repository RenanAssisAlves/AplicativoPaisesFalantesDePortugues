package com.unifafibe.paisesportugues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class detalhes_pais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pais);
        System.out.println("teste");
        Bundle b = getIntent().getExtras();


        String nome = null; // or other values
        if(b != null)
            nome = b.getString("nome");
            System.out.println(nome);

        String capital = null; // or other values
        if(b != null)
            capital = b.getString("capital");
        System.out.println(capital);

        String regiao = null; // or other values
        if(b != null)
            regiao = b.getString("regiao");
        System.out.println(regiao);

        String subregiao = null; // or other values
        if(b != null)
            subregiao = b.getString("subregiao");
        System.out.println(subregiao);

        String populacao = null; // or other values
        if(b != null)
            populacao = b.getString("populacao");
        System.out.println(populacao);

        String bandeira = null; // or other values
        if(b != null)
            bandeira = b.getString("bandeira");
        System.out.println(bandeira);

        WebView myWebView = (WebView) findViewById(R.id.webview);
//        myWebView.loadUrl(bandeira);
//        String unencodedHtml =
//                "&lt;!DOCTYPE html&gt; &lt;html lang=&quot;en&quot;&gt; &lt;head&gt; &lt;meta charset=&quot;UTF-8&quot;&gt; &lt;meta http-equiv=&quot;X-UA-Compatible&quot; content=&quot;IE=edge&quot;&gt; &lt;meta name=&quot;viewport&quot; content=&quot;width=device-width, initial-scale=1.0&quot;&gt; &lt;title&gt;Detalhes Pa&iacute;s&lt;/title&gt;" +
//                        " &lt;div style=&quot;position: relative; margin-left: 40%;&quot;&gt; &lt;img src=&quot; " + bandeira +  "&quot;&gt; &lt;/div&gt;" +
//                        " &lt;div style=&quot;position: relative; background-color: cyan; border-radius: 1cm;&quot;&gt; &lt;div style=&quot;margin-left: 10px;&quot;&gt; &lt;br&gt;" +
//                        " &lt;h1&gt;Nome : " + nome + "&lt;/h1&gt;" +
//                        " &lt;h1&gt;Capital : " + capital + "&lt;/h1&gt; " +
//                        "&lt;h1&gt;Regiao : " + regiao + "&lt;/h1&gt;" +
//                        " &lt;h1&gt;Populacao : " + populacao + "&lt;/h1&gt;" +
//                        " &lt;h1&gt;Bandeira : " + bandeira + "&lt;/h1&gt;" +
//                        " &lt;br&gt; &lt;/div&gt; &lt;/div&gt; &lt;/head&gt; &lt;body&gt; &lt;/body&gt; &lt;/html&gt;";
//        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
//                Base64.NO_PADDING);
//        myWebView.loadData(encodedHtml, "text/html", "base64");

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
    }
}