package com.example.omarxv.pract_9_oigq;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);

    }
    public void grabar(View v){
        //tomar el nombre del archovo
        String nomarchivo=et1.getText().toString();

        try{

            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nomarchivo, Activity.MODE_PRIVATE));
            archivo.write(et2.getText().toString());
            archivo.flush();
        }  catch (IOException e) {
        }
        Toast t= Toast.makeText(this, "El Archivo fue almacenado correctamente...", Toast.LENGTH_SHORT);
        t.show();
        et1.setText("");
        et2.setText("");
    }

    public void recuperar(View v){

        //se toma nombre del archivo
        String nomarchivo = et1.getText().toString();

        boolean enco = false;
        String[]archivos = fileList();
        for(int f=0; f<archivos.length; f++)
            if(nomarchivo.equals(archivos[f]))
                enco=true;
        if(enco==true){
            try{
                InputStreamReader archivo = new InputStreamReader(openFileInput(nomarchivo));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while(linea!=null){
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et2.setText(todo);
            } catch (IOException e) {
            }
        }else
        {
            Toast.makeText(this,"El archivo--"+nomarchivo+"-- no existe...", Toast.LENGTH_LONG).show();
            et2.setText("");
        }
    }

    public void salir(View v){
        finish();
    }
}
