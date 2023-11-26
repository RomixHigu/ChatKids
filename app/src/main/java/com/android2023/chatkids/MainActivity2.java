package com.android2023.chatkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    Button entrar;
    EditText nombre;
    FirebaseDatabase fireBaseDB;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        entrar = findViewById(R.id.btnEntrar);
        nombre = findViewById(R.id.txtNombre);

        fireBaseDB = FirebaseDatabase.getInstance();
        databaseReference = fireBaseDB.getReference();


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Nombre").setValue(nombre.getText().toString());
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}