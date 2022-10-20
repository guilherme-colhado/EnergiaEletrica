package com.example.energia_eletrica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText consumo;
    private TextView fornecimento;
    private TextView icms;
    private TextView cofins;
    private TextView pisPasep;
    private TextView icmsCofins;
    private TextView icmsPisPasep;
    private TextView fatura;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumo = findViewById(R.id.consumo);
        btnCalc = findViewById(R.id.calc);
        fornecimento = findViewById(R.id.fornecimento);
        icms = findViewById(R.id.icms);
        cofins = findViewById(R.id.cofins);
        pisPasep = findViewById(R.id.pisPasep);
        icmsCofins = findViewById(R.id.icmsCofins);
        icmsPisPasep = findViewById(R.id.icmsPisPasep);
        fatura = findViewById(R.id.fatura);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valueConsumo = Double.parseDouble(String.valueOf(consumo.getText()));
                Energy energy = new Energy(valueConsumo);
                fornecimento.setText("FORNECIMENTO: " + energy.fornecimento());
                icms.setText("ICMS: " + energy.icms());
                cofins.setText("COFINS: " + energy.cofins());
                pisPasep.setText("PIS/PASEP: " + energy.pisPasep());
                icmsCofins.setText("ICMS COFINS: " + energy.icmsCofins());
                icmsPisPasep.setText("ICMS PIS/PASEP: " + energy.icmsPisPassep());
                fatura.setText("FATURA: " + energy.fatura());
            }
        });
    }
}