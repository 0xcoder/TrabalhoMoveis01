package com.example.trabalhodaniel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TelaPrincipal();

    }
    private void TelaPrincipal(){
        ImageView img,Menu_Comprar;
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.menu);
        Menu_Comprar = findViewById(R.id.Menu_Comprar);

        Menu_Comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarCompras();
            }
        });

    }

    public void CarregarCompras(){
        setContentView(R.layout.comprafood);
        final CheckBox chkMarmitex,chkSelfService,chkBebida,chkSobremesa;
        Button btPagar ;
        final RadioGroup rgopcoes;

        btPagar = (Button) findViewById(R.id.btPagar);
        chkMarmitex = (CheckBox) findViewById(R.id.chkMarmitex);
        chkSelfService = (CheckBox) findViewById(R.id.chkSelfService);
        chkBebida = (CheckBox) findViewById(R.id.chkBebida);
        chkSobremesa = (CheckBox) findViewById(R.id.chkSobremesa);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);

        btPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0;
                if (chkMarmitex.isChecked()) {
                    total += 14;
                }
                if (chkSelfService.isChecked()) {
                    total += 25;
                }
                if (chkBebida.isChecked()) {
                    total += 5;
                }
                if (chkSobremesa.isChecked()) {
                    total += 10;
                }
                int op = rgopcoes.getCheckedRadioButtonId();
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                if (op == R.id.rbAvista)
                {
                    dialogo.setTitle("Pagamento A Vista:");
                    dialogo.setMessage("Total Final R$: " + total + " Pagamento Realizado com Sucesso");
                    dialogo.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                          TelaPrincipal();
                        }
                    });
                    dialogo.show();

                }

                else if(op == R.id.rbCartao)
                {
                    dialogo.setTitle("Pagamento Cartão de Crédito:");
                    dialogo.setMessage("Total Final R$: " + total + " Pagamento Realizado com Sucesso");
                    dialogo.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TelaPrincipal();
                        }
                    });
                    dialogo.show();
                }

                else{
                    dialogo.setTitle("Pagamento Cartão de Débito:");
                    dialogo.setMessage("Total Final R$: " + total + " Pagamento Realizado com Sucesso");
                    dialogo.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TelaPrincipal();
                        }
                    });
                    dialogo.show();
                }
            }
        });


    }
}