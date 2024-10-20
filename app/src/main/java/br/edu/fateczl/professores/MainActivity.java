package br.edu.fateczl.professores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private EditText etNome;
    private EditText etMatricula;
    private EditText etIdade;
    private RadioButton rbTitular;
    private RadioButton rbHorista;
    private Button btInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNome = findViewById(R.id.etNome);
        etMatricula = findViewById(R.id.etMatricula);
        etIdade = findViewById(R.id.etIdade);

        rbTitular = findViewById(R.id.rbTitular);
        rbTitular.setChecked(true);

        rbHorista = findViewById(R.id.rbHorista);

        btInicio = findViewById(R.id.btInicio);
        btInicio.setOnClickListener(op -> registrar());
    }

    private void registrar() {
        String nome = etNome.getText().toString();
        String matricula = etMatricula.getText().toString();
        int idade = Integer.parseInt(etIdade.getText().toString());

        String tipo = "";

        if(rbTitular.isChecked()){
            tipo = rbTitular.getText().toString();
        }

        if(rbHorista.isChecked()){
            tipo = rbHorista.getText().toString();
        }

        Bundle bundle = new Bundle();
        bundle.putString("tipo", tipo);
        bundle.putString("nome", nome);
        bundle.putString("matricula", matricula);
        bundle.putInt("idade", idade);
        
        mudar(bundle);
    }

    private void mudar(Bundle bundle) {
        Intent i = new Intent(this, CalcularActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}

