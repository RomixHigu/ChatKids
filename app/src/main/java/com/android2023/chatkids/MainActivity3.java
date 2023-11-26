package com.android2023.chatkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {

    private Mqtt mqttManager;
    Button enviar;
    EditText mensaje;
    FirebaseDatabase fireBaseDB;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        enviar = findViewById(R.id.btnEnviar);
        mensaje = findViewById(R.id.txtMensaje);


        mqttManager = new Mqtt(getApplicationContext());
        mqttManager.connectToMqttBroker();
        fireBaseDB = FirebaseDatabase.getInstance();
        databaseReference = fireBaseDB.getReference();

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqttManager.publishMessage(mensaje.getText().toString());
                databaseReference.child("Mensaje").setValue(mensaje.getText().toString());

                Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}