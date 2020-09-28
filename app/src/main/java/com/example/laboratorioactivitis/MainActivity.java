package com.example.laboratorioactivitis;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText et1,et2;
    Button btn,btn2;
    TextView tv1,tv2;
    Float peso,talla,imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.ettalla);
        et2=(EditText)findViewById(R.id.etpeso);
        tv1=(TextView)findViewById(R.id.tvresultado);
        tv2=(TextView)findViewById(R.id.tvrecomedacion);
        btn=(Button)findViewById(R.id.btncalcular);
        btn2=(Button)findViewById(R.id.btnresultado);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                talla=Float.parseFloat(et1.getText().toString());
                peso=Float.parseFloat(et2.getText().toString());
                imc=peso/(talla*talla);

                tv1.setText("IMC = "+redonderar(imc));

                if (imc<18.5){
                    btn2.setText("Insuficiencia Ponderal");
                    btn2.setTextColor(Color.parseColor("#FFFFFF"));
                    btn2.setBackground(getDrawable(R.color.plomo));
                }
                if (imc>=18.5 && imc<25){
                    btn2.setText(R.string.normal);
                    btn2.setTextColor(Color.parseColor("#FFFFFF"));
                    tv2.setText(R.string.resul1);
                    btn2.setBackground(getDrawable(R.color.verde));
                }
                if (imc>=25 && imc<30){
                    btn2.setText(R.string.sobrepeso);
                    btn2.setTextColor(Color.parseColor("#FFFFFF"));
                    btn2.setBackground(getDrawable(R.color.amarillo));
                    tv2.setText(R.string.resul2);
                }
                if (imc>=30 && imc<35){
                    btn2.setText(R.string.obeso);
                    btn2.setTextColor(Color.parseColor("#FFFFFF"));
                    btn2.setBackground(getDrawable(R.color.naranjadi));
                    tv2.setText("Las personas que tienen sobrepeso o son obesas tienen un mayor riesgo de afecciones crónicas, tales como hipertensión arterial, diabetes y colesterol alto.");
                }
                if (imc>=35 && imc<40){
                    btn2.setText("Obesidad II");
                    btn2.setTextColor(Color.parseColor("#FFFFFF"));
                    btn2.setBackground(getDrawable(R.color.rojo1));
                    tv2.setText("Toda persona que tenga sobrepeso debería tratar de evitar ganar más peso. Además, si usted tiene sobrepeso junto con otros factores de riesgo (como niveles altos de colesterol");
                }
                if (imc>=40){
                    btn2.setText("Obesidad III");
                    btn2.setTextColor(Color.parseColor("#FFFFFF"));
                    btn2.setBackground(getDrawable(R.color.rojo2));
                }
            }
        });

    }

    private  Float redonderar(float a){
        float res;
        int valor=0;
        valor=(int)(a*100);
        res=(float)valor/100;
        return  res;
    }

}