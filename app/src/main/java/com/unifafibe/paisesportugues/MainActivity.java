package com.unifafibe.paisesportugues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url ="https://restcountries.eu/rest/v2/lang/pt";
        List<JSONObject> paises = new ArrayList<>();
        List<String> nomesPaises = new ArrayList<>();

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for (int i = 0; i < response.length(); i++)
                            {
                                paises.add(i, response.getJSONObject(i));
                                nomesPaises.add(i, response.getJSONObject(i).getString("name"));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        System.out.println("Não funcionou!");
                        System.out.println(error);
                    }
                });

        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        ArrayAdapter<String> adapterLista = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                nomesPaises);

        ListView listViewLista = (ListView) findViewById(R.id.listPaises);
        listViewLista.setAdapter(adapterLista);

        Button btnAtualizar = findViewById(R.id.btnAtualizar);

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listViewLista = (ListView) findViewById(R.id.listPaises);
                listViewLista.setAdapter(adapterLista);
            }
        });

        listViewLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    Intent janelaDetalhes = new Intent(MainActivity.this, detalhes_pais.class);

                    String nome = paises.get(position).getString("name");
                    String capital = paises.get(position).getString("capital");
                    String regiao = paises.get(position).getString("region");
                    String subregiao = paises.get(position).getString("subregion");
                    String populacao = paises.get(position).getString("population");
                    String bandeira = paises.get(position).getString("flag");
                    JSONArray coordenadas = paises.get(position).getJSONArray("latlng");

                    Double coordenadasLat = coordenadas.getDouble(0);
                    Double coordenadasLong = coordenadas.getDouble(1);

                    janelaDetalhes.putExtra("nome", nome);
                    janelaDetalhes.putExtra("capital", capital);
                    janelaDetalhes.putExtra("regiao", regiao);
                    janelaDetalhes.putExtra("subregiao", subregiao);
                    janelaDetalhes.putExtra("populacao", populacao);
                    janelaDetalhes.putExtra("bandeira", bandeira);

                    janelaDetalhes.putExtra("coordenadasLat", Double.valueOf(coordenadasLat));
                    janelaDetalhes.putExtra("coordenadasLong", Double.valueOf(coordenadasLong));

                    startActivity(janelaDetalhes);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}