package br.com.koitim.segundaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.koitim.segundaapp.model.Contato;

public class FirstActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    private ListView mListViewContatos;

    private ArrayList<Contato> listaContatos;

    private ArrayAdapter<Contato> adapter;

    private int layoutAdapter = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mListViewContatos = (ListView) findViewById(R.id.listViewContatos);

        listaContatos = loadContatos();

        adapter = new ArrayAdapter<Contato>(getApplicationContext(), layoutAdapter, listaContatos);
        mListViewContatos.setAdapter(adapter);

        mListViewContatos.setOnItemClickListener(this);
    }

    private ArrayList<Contato> loadContatos() {
        ArrayList<Contato> lista = new ArrayList<>();
        Contato contatoA = new Contato("Coutinho", "9999", "rua C", "idsfds");
        Contato contatoB = new Contato("Fulano", "1119999", "rua C", "idsfds");
        Contato contatoC = new Contato("Sicrano", "9922299", "rua C", "idsfds");
        Contato contatoD = new Contato("Beltrano", "9999333", "rua C", "idsfds");
        Contato contatoE = new Contato("Ingrid", "44449999", "rua C", "idsfds");
        Contato contatoF = new Contato("Gabriel", "9995559", "rua C", "idsfds");
        Contato contatoG = new Contato("Carol", "96666999", "rua C", "idsfds");
        Contato contatoH = new Contato("Edeilde", "997777799", "rua C", "idsfds");
        Contato contatoI = new Contato("Pedro", "988888999", "rua C", "idsfds");
        Contato contatoJ = new Contato("João", "999000009", "rua C", "idsfds");

        lista.add(contatoA);
        lista.add(contatoB);
        lista.add(contatoC);
        lista.add(contatoD);
        lista.add(contatoE);
        lista.add(contatoF);
        lista.add(contatoG);
        lista.add(contatoH);
        lista.add(contatoI);
        lista.add(contatoJ);
        return lista;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Contato contato = adapter.getItem(i);
        Contato contato = (Contato) adapterView.getAdapter().getItem(i);
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("contatoSelecionado", contato);
        startActivity(intent);

    }
}
