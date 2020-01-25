package dev.cj376.testtt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // currently "editing" number is written into num2 variable
    // when action button is pressed, previous action is used and new action is set
    // result is written into num1
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bc, ba, bs, bm, bd, bp, be; //ten numbers, clear, add, subtract, multiply, divide, dot, equals
    TextView out1, out2;
    public double num1 = 0;
    public double num2 = 0;
    public byte action = 0; //0 -> +, 1 -> -, 2 -> *, 3 -> /
    public String outstr1, outstr2 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        bc = findViewById(R.id.buttonc);
        ba = findViewById(R.id.buttona);
        bs = findViewById(R.id.buttons);
        bm = findViewById(R.id.buttonm);
        bd = findViewById(R.id.buttond);
        bp = findViewById(R.id.buttonp);
        be = findViewById(R.id.buttone);
        out1 = findViewById(R.id.resout1);
        out2 = findViewById(R.id.resout2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bc.setOnClickListener(this);
        ba.setOnClickListener(this);
        bs.setOnClickListener(this);
        bm.setOnClickListener(this);
        bd.setOnClickListener(this);
        bp.setOnClickListener(this);
        be.setOnClickListener(this);
        Toast.makeText(this, "привет, я тупой кулькулятар", Toast.LENGTH_LONG).show();

        out1.setText(String.valueOf(num1));
        out2.setText(String.valueOf(num2));

    }

    private double doaction(double num1, double num2, byte action){
        double result = 0;
        switch (action) {
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
            case 2:
                result = num1 * num2;
                break;
            case 3:
                result = num1 / num2;
                break;
        }
        return result;
    }

    @Override
    public void onClick(View v) {
        Log.i("ButtonPress", ((Button)v).getText().toString());
        switch (((Button)v).getText().toString()){
            case "=":
                num1 = doaction(num1, num2, action);
                num2 = 0;
                break;
            case "+":
                num1 = doaction(num1, num2, action);
                action = 0;
                num2 = 0;
                break;
            case "-":
                num1 = doaction(num1, num2, action);
                action = 1;
                num2 = 0;
                break;
            case "*":
                num1 = doaction(num1, num2, action);
                action = 2;
                num2 = 0;
                break;
            case "/":
                num1 = doaction(num1, num2, action);
                action = 3;
                num2 = 0;
                break;
            case "1":
                num2 = num2*10+1;
                break;
            case "2":
                num2 = num2*10+2;
                break;
            case "3":
                num2 = num2*10+3;
                break;
            case "4":
                num2 = num2*10+4;
                break;
            case "5":
                num2 = num2*10+5;
                break;
            case "6":
                num2 = num2*10+6;
                break;
            case "7":
                num2 = num2*10+7;
                break;
            case "8":
                num2 = num2*10+8;
                break;
            case "9":
                num2 = num2*10+9;
                break;
            case "0":
                num2 = num2*10+0;
                break;
            case "C":
                num1 = 0;
                num2 = 0;
                break;
        }
        out1.setText(String.valueOf(num1));
        out2.setText(String.valueOf(num2));
        Toast.makeText(MainActivity.this, ((Button)v).getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
