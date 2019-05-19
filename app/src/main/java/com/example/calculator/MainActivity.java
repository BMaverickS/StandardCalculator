package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity implements OnItemSelectedListener
{
    TextView txtv;
    Spinner spin;
    EditText num1, num2;
    String Op;
    Button Bttn;
    double a, b, c;
    String[] Operators = {"Operators","+","-","*","/"};

    private OnClickListener myClickListener = new OnClickListener()
    {
        public void onClick(View v) {

            a=Double.parseDouble(num1.getText().toString());
            b=Double.parseDouble(num2.getText().toString());

            if (Op.equals("+"))
            {
                c = a+b;
                txtv.setText(Double.toString(c));
            }
            else if (Op.equals("-"))
            {
                c = a-b;
                txtv.setText(Double.toString(c));
            }
            else if (Op.equals("*"))
            {
                c = a*b;
                txtv.setText(Double.toString(c));
            }
            else if (Op.equals("/"))
            {
                c = a/b;
                txtv.setText(Double.toString(c));
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtv = (TextView)findViewById(R.id.textView7);

        Bttn = (Button) findViewById(R.id.button);
        Bttn.setOnClickListener(myClickListener);

        num1 = (EditText)findViewById(R.id.editText);
        num1.setText("");
        num2 = (EditText)findViewById(R.id.editText2);
        num2.setText("");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,
                Operators);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin = (Spinner) findViewById(R.id.spinner);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

    }
    public void onItemSelected (AdapterView<?> p,View v,int position,long id) {
        Op = Operators[position];
        txtv.setText(Op);
    }

    public void onNothingSelected(AdapterView<?> p)
    {
        txtv.setText("Please select ops");
    }
}
