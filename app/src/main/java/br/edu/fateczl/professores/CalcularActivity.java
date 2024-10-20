package br.edu.fateczl.professores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcularActivity extends AppCompatActivity {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private EditText etSalario;
    private EditText etTempo;
    private TextView tvResultado;
    private Button btCalc;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcular);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etSalario = findViewById(R.id.etSalario);
        etTempo = findViewById(R.id.etTempo);
        tvResultado = findViewById(R.id.tvResultado);
        btCalc = findViewById(R.id.btCalc);
        btVoltar = findViewById(R.id.btVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String tipo = bundle.getString("tipo");

        boolean categoria;
        if (tipo.equals("Professor Titular")){
            categoria = true;
            etSalario.setHint(R.string.vlr_salario);
            etTempo.setHint(R.string.tmp_ano);
        } else {
            categoria = false;
            etSalario.setHint(R.string.vlr_hora);
            etTempo.setHint(R.string.tmp_hora);
        }

        btCalc.setOnClickListener(op -> calcular(bundle, categoria));
        btVoltar.setOnClickListener(op -> voltar());

    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }

    private void calcular(Bundle bundle, boolean categoria) {
        double salario = Double.parseDouble(etSalario.getText().toString());
        int tempo = Integer.parseInt(etTempo.getText().toString());

        String nome = bundle.getString("nome");
        String matricula = bundle.getString("matricula");
        int idade = bundle.getInt("idade");

        Professor professor;
        if(categoria){
            professor = new ProfessorTitular(tempo, salario, nome, matricula, idade);
        } else {
            professor = new ProfessorHorista(tempo, salario, nome, matricula, idade);
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append(getString(R.string.nome)).append(": ").append(professor.getNome()).append("\n");
        buffer.append(getString(R.string.matricula)).append(": ").append(professor.getMatricula()).append("\n");
        buffer.append(getString(R.string.idade)).append(": ").append(professor.getIdade()).append("\n");
        buffer.append(getString(R.string.show_result)).append(professor.calcSalario());

        tvResultado.setText(buffer.toString());
    }
}