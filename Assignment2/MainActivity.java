package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtF, txtC, txtKm, txtM, txtKg, txtLb, txtL, txtG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtC = findViewById(R.id.txtc);
        txtF = findViewById(R.id.txtf);
        txtKm = findViewById(R.id.txtkm);
        txtM = findViewById(R.id.txtm);
        txtKg = findViewById(R.id.txtkg);
        txtLb = findViewById(R.id.txtlb);
        txtL = findViewById(R.id.txtl);
        txtG = findViewById(R.id.txtg);

        txtF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strF = s.toString();
                Log.i("Converter", "Value in txtF = " + strF);

                if (!txtF.isFocused()) return;
                if (strF.length() == 0) return;


                try {
                    double valF = Double.parseDouble(strF);
                    double valC = (valF - 32.0)*5/9;
                    String strC = Double.toString(valC);
                    Log.i("UnitConverter", "Value in txtC = " + strC);

                    MainActivity.this.txtC.setText(strC);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        txtC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strC = s.toString();
                Log.i("Converter", "Value in txtF = " + strC);

                if (!txtC.isFocused()) return;
                if (strC.length() == 0) return;


                try {
                    double valC = Double.parseDouble(strC);
                    double valF = (valC * 9/5) + 32;
                    String strF = Double.toString(valF);
                    Log.i("UnitConverter", "Value in txtC = " + strF);

                    MainActivity.this.txtF.setText(strF);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        txtKm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strkm = s.toString();
                Log.i("Converter", "Value in txtKm = " + strkm);

                if (!txtKm.isFocused()) return;
                if (strkm.length() == 0) return;


                try {
                    double valkm = Double.parseDouble(strkm);
                    double valm = (valkm * .62);
                    String strm = Double.toString(valm);
                    Log.i("UnitConverter", "Value in txtM = " + strm);

                    MainActivity.this.txtM.setText(strm);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        txtM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strM = s.toString();
                Log.i("Converter", "Value in txtM = " + strM);

                if (!txtM.isFocused()) return;
                if (strM.length() == 0) return;


                try {
                    double valM = Double.parseDouble(strM);
                    double valKm = (valM * 1.61);
                    String strKm = Double.toString(valKm);
                    Log.i("UnitConverter", "Value in txtKm = " + strKm);

                    MainActivity.this.txtKm.setText(strKm);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        txtKg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strKg = s.toString();
                Log.i("Converter", "Value in txtKg = " + strKg);

                if (!txtKg.isFocused()) return;
                if (strKg.length() == 0) return;


                try {
                    double valKg = Double.parseDouble(strKg);
                    double valLb = valKg * 2.205;
                    String strLb = Double.toString(valLb);
                    Log.i("UnitConverter", "Value in txtLb = " + strLb);

                    MainActivity.this.txtLb.setText(strLb);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        txtLb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strLb = s.toString();
                Log.i("Converter", "Value in txtLb = " + strLb);

                if (!txtLb.isFocused()) return;
                if (strLb.length() == 0) return;


                try {
                    double valLb = Double.parseDouble(strLb);
                    double valKg = valLb * .4536;
                    String strKg = Double.toString(valKg);
                    Log.i("UnitConverter", "Value in txtKg = " + strKg);

                    MainActivity.this.txtKg.setText(strKg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        txtL.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strL = s.toString();
                Log.i("Converter", "Value in txtL = " + strL);

                if (!txtL.isFocused()) return;
                if (strL.length() == 0) return;


                try {
                    double valL = Double.parseDouble(strL);
                    double valG = valL * .264;
                    String strG = Double.toString(valG);
                    Log.i("UnitConverter", "Value in txtG = " + strG);

                    MainActivity.this.txtG.setText(strG);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        txtG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strG = s.toString();
                Log.i("Converter", "Value in txtG = " + strG);

                if (!txtG.isFocused()) return;
                if (strG.length() == 0) return;


                try {
                    double valG = Double.parseDouble(strG);
                    double valL = valG * 3.785;
                    String strL = Double.toString(valL);
                    Log.i("UnitConverter", "Value in txtL = " + strL);

                    MainActivity.this.txtL.setText(strL);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
