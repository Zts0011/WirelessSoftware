package com.example.accountmanager;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static DecimalFormat df = new DecimalFormat("0.00");

    Button btnAdd, btnSub;

    EditText txtDate, txtAmount, txtTitle;
    TextView txtBalance, txtHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = findViewById(R.id.Date);
        txtAmount = findViewById(R.id.Amount);
        txtTitle = findViewById(R.id.Title);
        txtBalance = findViewById(R.id.Balance);
        txtHistory = findViewById(R.id.History);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtDate.getText().toString() == "Date" || txtDate.getText().toString() == "") {
                    return;
                }
                if (txtAmount.getText().toString() == "Amount" || txtAmount.getText().toString() == "") {
                    return;
                }
                if (txtTitle.getText().toString() == "Title" || txtTitle.getText().toString() == "") {
                    return;
                }

                if (txtBalance.getText().toString() == "") {
                    MainActivity.this.txtBalance.setText(txtAmount.getText().toString());
                }
                else {
                    try {
                        Double balance = Double.parseDouble(txtBalance.getText().toString()) + Double.parseDouble(txtAmount.getText().toString());
                        MainActivity.this.txtBalance.setText(String.valueOf(df.format(balance)));
                    }   catch (Exception e) {
                        return;
                    }

                }

                String newHistory = "Added $" + txtAmount.getText().toString() + " on " + txtDate.getText().toString() + " from " + txtTitle.getText().toString() + "\n" + txtHistory.getText().toString();
                MainActivity.this.txtHistory.setText(newHistory);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtDate.getText().toString() == "Date" || txtDate.getText().toString() == "") {
                    return;
                }
                if (txtAmount.getText().toString() == "Amount" || txtAmount.getText().toString() == "") {
                    return;
                }
                if (txtTitle.getText().toString() == "Title" || txtTitle.getText().toString() == "") {
                    return;
                }

                if (txtBalance.getText().toString() == "") {
                    MainActivity.this.txtBalance.setText(txtAmount.getText().toString());
                }
                else {
                    try {
                        Double balance = Double.parseDouble(txtBalance.getText().toString()) - Double.parseDouble(txtAmount.getText().toString());
                        MainActivity.this.txtBalance.setText(String.valueOf(df.format(balance)));
                    }   catch (Exception e) {
                        return;
                    }
                }

                String newHistory = "Spent $" + txtAmount.getText().toString() + " on " + txtDate.getText().toString() + " for " + txtTitle.getText().toString() + "\n" + txtHistory.getText().toString();
                MainActivity.this.txtHistory.setText(newHistory);
            }
        });
    }
}
