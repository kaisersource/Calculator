package com.example.kaisersource.calcolatrice;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.lang.Math;
import android.app.FragmentTransaction;


public class MainActivity extends FragmentActivity {

    private TextView display;
    double a,b,res;
    int idop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //trova gli elementi partendo da resources
        final int V[]=new int[]{0,1,2,3,4,5,6,7,8,9};
        final char C[]=new char[]{'.',','};
        final TextView display= (TextView)findViewById(R.id.display);
        final Button zero,one,two,three,four,five,six,seven,eight,nine,dot,comma,add, sub, mul, div, ris,sqrt,exit,cancel;
        final char op[]=new char[5];



        sqrt= (Button) findViewById(R.id.sqrt); //Trova il bottone nell'hash table resources
        cancel= (Button) findViewById(R.id.cancel); //Trova il bottone nell'hash table resources
        exit= (Button) findViewById(R.id.exit); //Trova il bottone nell'hash table resources
        zero= (Button) findViewById(R.id.zero); //Trova il bottone nell'hash table resources
        one = (Button) findViewById(R.id.one); //Trova il bottone nell'hash table resources
        two = (Button) findViewById(R.id.two); //Trova il bottone nell'hash table resources
        three = (Button) findViewById(R.id.three); //Trova il bottone nell'hash table resources
        four= (Button) findViewById(R.id.four); //Trova il bottone nell'hash table resources
        five= (Button) findViewById(R.id.five); //Trova il bottone nell'hash table resources
        six = (Button) findViewById(R.id.six); //Trova il bottone nell'hash table resources
        seven = (Button) findViewById(R.id.seven); //Trova il bottone nell'hash table resources
        eight = (Button) findViewById(R.id.eight); //Trova il bottone nell'hash table resources


        sqrt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // a=0;b=0;

                //  display.setText(""); //concatenazione numeri
                try {

                        a = Math.sqrt((Double.parseDouble(display.getText().toString()))); //radice quadrata del contenuto
                        display.setText(Double.toString(a));




                }catch(Exception e){}

            }
        });

//il pulsante cancella azzera anche il contenuto delle variabili ed elimina il contenuto della textview


        //metodo cancel che elimina tutto il contenuto solo se tengo premuto
        cancel.setOnLongClickListener(new View.OnLongClickListener()  {
            public boolean onLongClick(View v) {
                a=0;b=0;
                display.setText(""); //concatenazione numeri
                return true;
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // a=0;b=0;
              //  display.setText(""); //concatenazione numeri
                try {
                    String capture = display.getText().toString();
                    display.setText(capture.substring(0, capture.length() - 1));
                }catch(Exception e){}

            }
        });
//perfezionare la dialog in modo tale da chiudere l'applicazione se l'utente preme ok
        //non deve succedere nulla se l'utente preme annulla
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MiaDialog a=new MiaDialog();
                a.alert_msg(MainActivity.this,"title","yourmessage");

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[0]); //concatenazione numeri

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[1]);
                // Perform action on click
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[2]);
                // Perform action on click
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[3]);
                // Perform action on click
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[4]);
                // Perform action on click
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[5]);
                // Perform action on click
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[6]);
                // Perform action on click
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[7]);
                // Perform action on click
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[8]);
                // Perform action on click
            }
        });
        nine = (Button) findViewById(R.id.nine); //Trova il bottone nell'hash table resources
        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+V[9]);
                // Perform action on click
            }
        });
        dot = (Button) findViewById(R.id.dot); //Trova il bottone nell'hash table resources
        dot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+C[0]);

            }
        });
        comma = (Button) findViewById(R.id.comma); //Trova il bottone nell'hash table resources
        comma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString()+C[1]);

                // Perform action on click
            }
        });
        add = (Button) findViewById(R.id.sum); //Trova il bottone nell'hash table resources
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    a = Double.parseDouble(display.getText().toString()); //memorizzo il contenuto
                    idop=v.getId();
                    Log.d("btnListener", Double.toString(idop));
                }catch (Exception e){

                }
                display.setText("");
                // Perform action on click
            }
        });

        sub = (Button) findViewById(R.id.sub); //Trova il bottone nell'hash table resources
        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    a = Double.parseDouble(display.getText().toString()); //memorizzo il contenuto
                    idop=v.getId();

                }catch (Exception e){}
                display.setText("");
                // Perform action on click
            }
        });
        mul = (Button) findViewById(R.id.mul); //Trova il bottone nell'hash table resources

        mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    a = Double.parseDouble(display.getText().toString()); //memorizzo il contenuto
                    idop=v.getId();
                }catch (Exception e){

                }
                display.setText("");
                // Perform action on click
            }
        });



        div= (Button) findViewById(R.id.div); //Trova il bottone nell'hash table resources
        div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    a = Double.parseDouble(display.getText().toString()); //memorizzo il contenuto
                    idop=v.getId();
                }catch(Exception e){}
                display.setText("");
                // Perform action on click
            }
        });

      ris= (Button) findViewById(R.id.ris); //Trova il bottone nell'hash table resources
        ris.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                switch (idop) {
                   // case 2131427428: //divisione
                    case R.id.div:
                        try {
                            b = Double.parseDouble(display.getText().toString());
                            res = a / b;
                            display.setText(Double.toString(res));

                        } catch (Exception e) {
                        }
                    break;

                    case R.id.mul: //valore dell'id
                        try {
                            b = Double.parseDouble(display.getText().toString());
                            res = a * b;
                            display.setText(Double.toString(res));

                        } catch (Exception e) {
                        }
                    break;
                    case R.id.sub: //sottrazione

                        try {
                            b = Double.parseDouble(display.getText().toString());
                            res = a - b;
                            display.setText(Double.toString(res));

                        } catch (Exception e) {
                        }
                        break;

                    case R.id.sum: //somma
                        try {
                            b = Double.parseDouble(display.getText().toString());
                            res = a + b;
                            display.setText(Double.toString(res));

                        } catch (Exception e) {
                        }
                        break;


                }
            }
        });

    }
}
