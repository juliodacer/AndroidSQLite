package com.devcer.cursoandroidsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class RegisterActiviy extends AppCompatActivity {

    Button btnSaveUser;
    EditText txtName, txtDist, txtEmail, txtPass;

    //Instancia de nuestra base de datos
    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSaveUser = (Button) findViewById(R.id.btnRegisterUser);
        txtName = (EditText) findViewById(R.id.txtNameUser);
        txtDist = (EditText) findViewById(R.id.txtDistUser);
        txtEmail = (EditText) findViewById(R.id.txtEmailUser);
        txtPass = (EditText) findViewById(R.id.txtPassUser);

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.openBD();
                helper.insertarReg(txtName.getText().toString(),
                        txtDist.getText().toString(),
                        txtEmail.getText().toString(),
                        txtPass.getText().toString());
                helper.closeBD();

                Toast.makeText(getApplicationContext(), "Registro almacenado con éxito", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });

    }
}