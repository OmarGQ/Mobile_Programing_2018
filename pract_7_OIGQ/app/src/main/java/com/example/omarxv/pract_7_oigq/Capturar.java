package com.example.omarxv.pract_7_oigq;

import android.app.Activity;
import android.content.ContentValues;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Capturar extends Activity {

    String[] califs = {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100",};
    EditText editN, editCa;
    String nom ="";
    int radE, radJ, radD;
    RadioGroup rgE, rgJ, rgD;
    RadioButton radE1;
    boolean flRd1 = false, flRd2 = false, flRd3 = false;
    int calif = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_capturar);
        super.onCreate(savedInstanceState);
        editN = findViewById(R.id.etN);
        editN.setText("");
        editCa = findViewById(R.id.etC);
        editCa.setText("");
        rgE = findViewById(R.id.rg1);
        rgJ = findViewById(R.id.rg2);
        rgD = findViewById(R.id.rg3);
        radE1 = findViewById(R.id.rdE1);
        rgE.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                flRd1 = true;
                if(checkedId == R.id.rdE1){
                    radE = 1;
                }
                else if(checkedId == R.id.rdE2){
                    radE = 0;
                }
            }
        });
        rgJ.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                flRd2 = true;
                if(checkedId == R.id.rdJ1){
                    radJ = 1;
                }
                else if(checkedId == R.id.rdJ2){
                    radJ = 0;
                }
            }
        });
        rgD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                flRd3 = true;
                if(checkedId == R.id.rdD1){
                    radD = 1;
                }
                else if(checkedId == R.id.rdD2){
                    rgD.clearCheck();
                    Toast.makeText(getMe(), "Error, opcion no disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
        editCa.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE){
                    if(Integer.parseInt(editCa.getText().toString()) <= 70){
                        Toast.makeText(getMe(), "Porfavor, necesitamos la calificacion", Toast.LENGTH_SHORT).show();
                        editCa.setText("");
                        calif = 0;
                    }
                }
                return false;
            }
        });
    }
    public void capturar(View v){
        nom = editN.getText().toString();
        calif=Integer.parseInt(editCa.getText().toString());
        if(nom.matches("") || calif == 0 || !flRd1 || !flRd2 || !flRd3){
            Toast.makeText(this, "Porfavor rellene todos los campos", Toast.LENGTH_SHORT).show();
        }
        else{
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("nombre", nom);
            registro.put("erectil", radE);
            registro.put("dinero", radD);
            registro.put("japo", radJ);
            registro.put("calif", calif);
            bd.insert("encuesta", null, registro);
            bd.close();
            editN.setText("");
            editCa.setText("");
            rgE.clearCheck();
            rgJ.clearCheck();
            rgD.clearCheck();
            Toast.makeText(this, "Los datos se han capturado satisfactoriamente", Toast.LENGTH_SHORT).show();
        }
    }
    public Capturar getMe(){
        return this;
    }
}
