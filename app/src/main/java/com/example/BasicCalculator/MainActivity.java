/**
 * Driver class, creates a four function calculator using xml layout
 * Buttons are used for better functionality
 * @author Joshua Mathew
 * email: joshua.mathew@stonybrook.edu
 *
 */
package com.example.BasicCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.BasicCalculator.R;

import java.text.DecimalFormat;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button compute;
    private EditText left;
    private EditText right;
    private TextView result;
    private TextView operator;
    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            add = (Button)findViewById(R.id.add);
            minus = (Button)findViewById(R.id.minus);
            multiply = (Button)findViewById(R.id.multiply);
            divide = (Button)findViewById(R.id.divide);
            compute = (Button)findViewById(R.id.compute);

            operator = (TextView)findViewById(R.id.operator);
            result = (TextView)findViewById(R.id.result);
            left = (EditText)findViewById(R.id.leftN);
            right = (EditText)findViewById(R.id.rightN);

            DecimalFormat f = new DecimalFormat("##.00");

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                operator.setText("+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                operator.setText("-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                operator.setText("X");
            }
        });
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                operator.setText("/");
            }
        });
        compute.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                DecimalFormat f = new DecimalFormat("##.00");
                double res = 0;
                if(operator.getText().equals("+"))
                    res = Double.parseDouble(left.getText().toString())+
                            Double.parseDouble(right.getText().toString());
                else if(operator.getText().equals("-"))
                    res = Double.parseDouble(left.getText().toString())-
                            Double.parseDouble(right.getText().toString());
                else if(operator.getText().equals("X"))
                    res = Double.parseDouble(left.getText().toString())*
                            Double.parseDouble(right.getText().toString());
                else if(operator.getText().equals("/"))
                    res = Double.parseDouble(left.getText().toString())/
                            Double.parseDouble(right.getText().toString());
                result.setText(f.format(res));
                left.setText(null);
                right.setText(null);
                operator.setText(null);
            }
        });

        addListenerOnRadioButton();

    }
    public void addListenerOnRadioButton(){
        System.out.println("HELELE");
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        rb1 = (RadioButton)findViewById(R.id.radioButton2);
        rb2 = (RadioButton)findViewById(R.id.radioButton3);
        rb3 = (RadioButton)findViewById(R.id.radioButton4);
        rg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int rbid = rg.getCheckedRadioButtonId();
                System.out.println(rbid);
                if(rb1.isChecked()){
                    System.out.println("rb1");
                }
                else if(rb2.isChecked()){
                    System.out.println("rb2");
                }
                else if(rb3.isChecked()){
                    System.out.println("rb3");
                }
            }
        });
    }


}