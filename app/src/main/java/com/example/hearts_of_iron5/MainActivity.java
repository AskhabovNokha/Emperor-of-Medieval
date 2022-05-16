package com.example.hearts_of_iron5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static int OurCountry;
    static TextView PolishCapitalString;
    static TextView GermanCapitalString;
    static TextView GermanInfantryString;
    static TextView GermanCavalryString;
    static TextView GermanArchersString;
    static TextView PolishInfantryString;
    static TextView PolishCavalryString;
    static TextView PolishArchersString;
    static TextView Target;
    static Button GermanButton;
    static Button PolishButton;
    static Button MinisterButton;
    static Button PromButton;
    static TextView MinisterCost;
    static TextView PromCost;
    static ImageButton Infantry;
    static ImageButton Cavalry;
    static ImageButton Archers;
    static int GermanCapitalInt = 6;
    static int PolishCapitalInt = 5;
    static int PolishIncomeMaximum = 3;
    static int PolishIncomeMinimum = 1;
    static int PolishIncome;
    static int GermanIncomeMaximum = 3;
    static int GermanIncomeMinimum = 1;
    static int GermanIncome;
    static int AntiChit = 0;
    static int GermanMinisterIncome = 0;
    static int PolishMinisterIncome = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GermanInfantryString = findViewById(R.id.textView11);
        GermanCavalryString = findViewById(R.id.textView13);
        GermanArchersString = findViewById(R.id.textView16);
        PolishInfantryString = findViewById(R.id.textView12);
        PolishCavalryString = findViewById(R.id.textView15);
        PolishArchersString = findViewById(R.id.textView17);
        Target = findViewById(R.id.textView);
        GermanCapitalString = findViewById(R.id.textView2);
        PolishCapitalString = findViewById(R.id.textView4);
        MinisterCost = findViewById(R.id.textView7);
        PromCost = findViewById(R.id.textView8);
        GermanButton = findViewById(R.id.button);
        PolishButton = findViewById(R.id.button2);
        MinisterButton = findViewById(R.id.button5);
        PromButton = findViewById(R.id.button6);
        Infantry = findViewById(R.id.imageButton4);
        Cavalry = findViewById(R.id.imageButton5);
        Archers = findViewById(R.id.imageButton6);
        Bundle VIPbundle = getIntent().getExtras();
        OurCountry = VIPbundle.getInt("VIPint");
        if (OurCountry == 1){
            MinisterButton.setBackgroundColor(Color.parseColor("#00FF04"));
            PromButton.setBackgroundColor(Color.parseColor("#00FF04"));
        }
        MainStream();
        GermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OurCountry == 0) {
                    GetPowerForGermany();
                }
                else {
                    AttackForPoland();
                }
            }
        });
        PolishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OurCountry == 1){
                    GetPowerForPoland();
                }
                else{
                    AttackForGermany();
                }
            }
        });
        MinisterButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (OurCountry == 0) {
                    HireMinisterForGermany();
                }
                else if(OurCountry == 1){
                    HireMinisterForPoland();
                }
            }
        });
        PromButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (OurCountry == 0) {
                    BuildPromForGermany();
                }
                else if(OurCountry == 1){
                    BuildPromForPoland();
                }
            }
        });
    }
    public void MainStream(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        if (OurCountry == 0) {
                            if (PolishCapitalInt == 0) {
                                runOnUiThread(new Runnable() {
                                    @SuppressLint("ResourceAsColor")
                                    @Override
                                    public void run() {
                                        PolishCapitalInt = 0;
                                        PolishButton.setBackgroundColor(Color.parseColor("#E6FF00"));
                                        Target.setText("Молодец,жди обновлений");
                                    }
                                });
                                break;
                            }
                        }
                        if (OurCountry == 1) {
                            if (GermanCapitalInt == 0) {
                                runOnUiThread(new Runnable() {
                                    @SuppressLint("ResourceAsColor")
                                    @Override
                                    public void run() {
                                        GermanCapitalInt = 0;
                                        GermanButton.setBackgroundColor(Color.parseColor("#00FF04"));
                                        Target.setText("Молодец,жди обновлений");
                                    }
                                });
                                break;
                            }
                            }
                        else
                        {
                            Thread.sleep(1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (AntiChit > GermanIncomeMinimum * 10) {
                                        GermanCapitalInt = 0;
                                    }
                                    GermanCapitalInt = GermanCapitalInt + GermanMinisterIncome;
                                    PolishCapitalInt = PolishCapitalInt + PolishMinisterIncome;
                                    GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
                                    PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
                                    if (OurCountry == 0) {
                                        PolishIncome = (int) ((Math.random() * (GermanIncomeMaximum - GermanIncomeMinimum)) + 1);
                                        PolishCapitalInt = PolishCapitalInt + PolishIncome;
                                        PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
                                    }
                                    else if(OurCountry == 1){
                                        GermanIncome = (int) ((Math.random() * (PolishIncomeMaximum - PolishIncomeMinimum)) + 1);
                                        GermanCapitalInt = GermanCapitalInt + GermanIncome;
                                        GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
                                    }
                                    AntiChit = 0;
                                }
                            });
                        }

                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();
    }
    public static void GetPowerForGermany(){
        GermanIncome = (int) ((Math.random() * (GermanIncomeMaximum - GermanIncomeMinimum)) + 1);
        GermanCapitalInt = GermanCapitalInt + GermanIncome;
        GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
        AntiChit = AntiChit + 1;
    }
    public static void GetPowerForPoland(){
        PolishIncome = (int) ((Math.random() * (PolishIncomeMaximum - PolishIncomeMinimum)) + 1);
        PolishCapitalInt = PolishCapitalInt + PolishIncome;
        PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
        AntiChit = AntiChit + 1;
    }
    public static void AttackForGermany(){
        if (PolishCapitalInt > 0) {
            if (PolishCapitalInt > 0 && GermanCapitalInt > 0) {
                Target.setText("Захвати всех!");
            }
            GermanCapitalInt = GermanCapitalInt - 1;
            PolishCapitalInt = PolishCapitalInt - 1;
            GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
            PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
        }
        else if(PolishCapitalInt <= 0){
            PolishCapitalInt = 0;
            PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
        }
        if(GermanCapitalInt <= 0) {
            Target.setText("Сперва нарасти мощь");
            GermanCapitalInt = 0;
            GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
        }
    }
    public static void AttackForPoland(){
        if (GermanCapitalInt > 0) {
            if (PolishCapitalInt > 0 && GermanCapitalInt > 0) {
                Target.setText("Захвати всех!");
            }
            GermanCapitalInt = GermanCapitalInt - 1;
            PolishCapitalInt = PolishCapitalInt - 1;
            GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
            PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
        }
        else if(GermanCapitalInt <= 0){
            GermanCapitalInt = 0;
            GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
        }
        if(PolishCapitalInt <= 0) {
            Target.setText("Сперва нарасти мощь");
            PolishCapitalInt = 0;
            PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
        }
    }
    public static void HireMinisterForGermany(){
        if(GermanCapitalInt >= 10) {
            GermanCapitalInt = GermanCapitalInt - 10;
            GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
            GermanMinisterIncome = GermanMinisterIncome + 1;
            MinisterButton.setText(String.valueOf(GermanMinisterIncome)+" кликов в секунду");
        }
    }
    public static void HireMinisterForPoland(){
        if(PolishCapitalInt >= 10) {
            PolishCapitalInt = PolishCapitalInt - 10;
            PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
            PolishMinisterIncome = PolishMinisterIncome + 1;
            MinisterButton.setText(String.valueOf(PolishMinisterIncome)+" кликов в секунду");
        }
    }
    public static void BuildPromForGermany(){
        if(GermanCapitalInt >= 20) {
            GermanCapitalInt = GermanCapitalInt - 20;
            GermanCapitalString.setText(String.valueOf(GermanCapitalInt));
            GermanIncomeMaximum = GermanIncomeMaximum + 1;
            PromButton.setText("1 -"+String.valueOf(GermanIncomeMaximum - 1)+" мешков с золотом за клик");
        }
    }
    public static void BuildPromForPoland(){
        if(PolishCapitalInt >= 20) {
            PolishCapitalInt = PolishCapitalInt - 20;
            PolishCapitalString.setText(String.valueOf(PolishCapitalInt));
            PolishIncomeMaximum = PolishIncomeMaximum + 1;
            PromButton.setText("1 -"+String.valueOf(PolishIncomeMaximum - 1)+" мешков с золотом за клик");
        }
    }
    public static void HireInfantry(int CountryCapital,int CountryInfantry,TextView CountryInfantryString){
        
    }

}