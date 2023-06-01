package br.com.matheus.soandroidexer01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private EditText etOp;
    private TextView tvInfo;
    private TextView tvResultado;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum1.setGravity(Gravity.CENTER);

        etNum2 = findViewById(R.id.etNum2);
        etNum2.setGravity(Gravity.CENTER);

        etOp = findViewById(R.id.etOp);
        etOp.setGravity(Gravity.CENTER);
        etOp.setTextSize(16);

        tvInfo = findViewById(R.id.tvInfo);
        tvInfo.setGravity(Gravity.CENTER);

        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setGravity(Gravity.CENTER);

        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(v -> calc());


    }

    private void calc()
    {
        String op = etOp.getText().toString();

        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))
        {
            if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString()) ||
                TextUtils.isEmpty(etOp.getText().toString()))
            {
                Toast.makeText(this, R.string.caixa_vazia, Toast.LENGTH_LONG).show();;
                return;
            }
            int num1 = Integer.parseInt(etNum1.getText().toString());
            int num2 = Integer.parseInt(etNum2.getText().toString());
            int resultado = 0;

            switch(op)
            {
                case "+":
                resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    resultado = num1 / num2;
                    break;
            }
            String textoResult = getResources().getString(R.string.resultado);
            tvResultado.setText(textoResult + num1 + op + num2 + " = " + resultado);
            return;
        }
        Toast.makeText(this, R.string.op_invalido, Toast.LENGTH_LONG).show();
        return;

    }

}