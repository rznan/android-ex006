package br.com.renan.ex006;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
* @author: renan santos carvalho
*/
public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    TextView tvResultC;
    TextView tvResultD;
    TextView tvResultU;

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

        etNumber = findViewById(R.id.etNumber);
        tvResultC = findViewById(R.id.tvResultC);
        tvResultD = findViewById(R.id.tvResultD);
        tvResultU = findViewById(R.id.tvResultU);

        findViewById(R.id.button).setOnClickListener(e -> calculateResult());
    }

    private void calculateResult() {
        int number = Integer.parseInt(etNumber.getText().toString());
        tvResultU.setText(String.valueOf(number%10));
        number /= 10;
        tvResultD.setText(String.valueOf(number%10));
        number /= 10;
        tvResultC.setText(String.valueOf(number%10));
    }
}