package br.com.koitim.segundaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.koitim.segundaapp.model.Contato;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG_W = "WARNING";
    private EditText mEditTextNome;
    private EditText mEditTextTelefone;
    private EditText mEditTextEndereco;
    private EditText mEditTextEmail;

    private Button mButtonLimpar;
    private Button mButtonMensagem;

    private Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mEditTextNome     = (EditText) findViewById(R.id.editTextNome);
        mEditTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        mEditTextEndereco = (EditText) findViewById(R.id.editTextEndereco);
        mEditTextEmail    = (EditText) findViewById(R.id.editTextEmail);
        mButtonLimpar     = (Button) findViewById(R.id.button_Limpar);
        mButtonMensagem   = (Button) findViewById(R.id.buttonMensagem);
        mButtonLimpar.setOnClickListener(this);
        mButtonMensagem.setOnClickListener(this);

        Intent it = getIntent();
        if (it != null) {
            contato = (Contato) it.getSerializableExtra("contatoSelecionado");
            if (contato != null) {
                mEditTextNome.setText(contato.getNome());
                mEditTextTelefone.setText(contato.getTelefone());
                mEditTextEndereco.setText(contato.getEndereco());
                mEditTextEmail.setText(contato.getEmail());
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_Limpar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setCancelable(false)
                        .setMessage("Você realmente deseja limpar os dados?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mEditTextNome.setText("");
                                mEditTextTelefone.setText("");
                                mEditTextEndereco.setText("");
                                mEditTextEmail.setText("");
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.buttonMensagem:
                String mensagem = "Nome: " + mEditTextNome.getText().toString() +
                        " Telefone: " + mEditTextTelefone.getText().toString() +
                        " Email: " + mEditTextEmail.getText().toString();
                //Criando um toas para exibir uma mensagem rápida na tela
                Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();

                break;
            default:
                Log.w(TAG_W, "Situação inesperada. Butão não previsto acionando o click.");
        }



    }
}
