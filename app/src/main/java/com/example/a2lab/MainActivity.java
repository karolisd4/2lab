package com.example.a2lab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText txtInputText;
    private Spinner spinnerMetricType;
    private Button btnCalculate;
    private TextView txtResult;
    private TextCalculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInputText = findViewById(R.id.txtInputText);
        spinnerMetricType = findViewById(R.id.spinnerMetricType);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        calculator = new TextCalculator();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.metric_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMetricType.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txtInputText.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_empty_input, Toast.LENGTH_SHORT).show();
                    return;
                }

                String selectedMetric = spinnerMetricType.getSelectedItem().toString();
                int result = 0;

                switch (selectedMetric) {
                    case "Sakiniu skaicius":
                        result = calculator.countSentences(input);
                        break;
                    case "Zodziu skaicius":
                        result = calculator.countWords(input);
                        break;
                    case "Rasybos zenklu skaicius":
                        result = calculator.countSymbols(input);
                        break;
                    case "Skaiciu skaicius ( :D )":
                        result = calculator.countNumbers(input);
                        break;
                }

                txtResult.setText(selectedMetric + ": " + result);
            }
        });
    }
}
