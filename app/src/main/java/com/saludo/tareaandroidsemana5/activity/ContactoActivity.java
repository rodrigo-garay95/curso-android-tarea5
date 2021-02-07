package com.saludo.tareaandroidsemana5.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.saludo.tareaandroidsemana5.R;

public class ContactoActivity extends AppCompatActivity {

    private Toolbar miActionBar;
    private Button enviarComentario;

    private EditText txtNombre;
    private EditText txtEmail;
    private EditText txtMensaje;
    String nombre;
    String email;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enviarComentario = (Button) findViewById(R.id.btnEnviarcomentario);

        enviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtNombre = (EditText)findViewById(R.id.txtNombre);
                txtEmail = (EditText)findViewById(R.id.txtEmail);
                txtMensaje = (EditText)findViewById(R.id.txtMensaje);
                nombre = txtNombre.getText().toString();
                email = txtEmail.getText().toString();
                mensaje = txtMensaje.getText().toString();
                Snackbar.make(v, "Mensaje Enviado", Snackbar.LENGTH_LONG)
                        .setBackgroundTint(v.getResources().getColor(R.color.green_light))
                        .setTextColor(v.getResources().getColor(R.color.black))
                        .setActionTextColor(v.getResources().getColor(R.color.black))
                        .show();
                //Toast.makeText(getBaseContext(), " Tu : " + nombre + " Enviaste : " + mensaje + " a : " + email, Toast.LENGTH_LONG).show();
                Intent sendIntent = new Intent((Intent.ACTION_SEND));
                sendIntent.setType("plain/text");
                sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje enviado por " + nombre);
                startActivity(Intent.createChooser(sendIntent, "Enviar mail atraves de "));
            }
        });

    }

}