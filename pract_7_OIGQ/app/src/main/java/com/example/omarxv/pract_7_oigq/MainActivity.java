package com.example.omarxv.pract_7_oigq;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText3);
        et2 = (EditText) findViewById(R.id.editText);
    }
    public void cerrar(View v){
        finish();
    }
    public void ingresar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 2);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String user = et1.getText().toString();
        String pass = et2.getText().toString();
        Cursor fila = bd.rawQuery("select * from usuarios where nombre='"+user+"' and password='"+pass+"'", null);

        if (fila.moveToFirst()) {
            String us = fila.getString(0);
            String pa = fila.getString(1);
            bd.close();
            if(user.equals(us)&&pass.equals(pa)) {
                Intent ven=new Intent(this, principal.class);
                startActivity(ven);
            }
        }else {
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
        }
    }
}
