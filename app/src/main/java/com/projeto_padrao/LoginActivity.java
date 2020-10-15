package com.projeto_padrao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projeto_padrao.models.Android;
import com.projeto_padrao.models.Aplicacao;
import com.projeto_padrao.models.Gato;
import com.projeto_padrao.models.Usuario;
import com.projeto_padrao.observers.ActivityObserver;

public class LoginActivity extends AppCompatActivity {

    //DECLARANDO OBJETOS
    EditText login_editText_usuario,login_editText_senha;
    Button login_button_usuario;
    TextView login_text_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Gato gato = new Gato("rogerio",true,20);

        //this.getLifecycle().addObserver(new ActivityObserver());
        identificandoComponentes();
        inicializandoComponentes();

    }

    private void identificandoComponentes() {

        //-------------------IDENTIFICANDO OS COMPONENTES EM "login.xml"----------//
        login_editText_usuario = (EditText) findViewById(R.id.login_editText_usuario);
        login_editText_senha = (EditText) findViewById(R.id.login_editText_senha);
        login_button_usuario = (Button) findViewById(R.id.login_button_login);
        login_text_registrar = (TextView) findViewById(R.id.login_text_registrar);
    }

    private void inicializandoComponentes() {
        //----------------------------- BOTÃO DE LOGIN--------------------------------//

        login_button_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = login_editText_usuario.getText().toString();
                String senha = login_editText_senha.getText().toString();

                Log.d("autenticação","  \nUSUARIO: "+ usuario + "\nSENHA:"+ senha);

                Usuario usuarioLogado = new Usuario(usuario,senha);
                usuarioLogado.logar(LoginActivity.this);


            }
        });

        //------------------------- BOTÃO DE TRANSIÇÃO PARA O REGISTRO--------------------------//
        login_text_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}