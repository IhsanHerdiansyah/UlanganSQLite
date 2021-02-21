package com.example.ulangansqlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class AddItem extends AppCompatActivity {
    TextInputLayout inputTitle, inputDesc;
    Button fab;
    Content content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inputTitle = findViewById(R.id.txtinput);
        inputDesc = findViewById(R.id.txtinput2);

        fab = findViewById(R.id.submit);
        fab.setOnClickListener(v -> {
            DatabaseHelper db = new DatabaseHelper(this);
            content = new Content();
            String title = inputTitle.getEditText().getText().toString();
            String Desc = inputDesc.getEditText().getText().toString();
            content.setTitle(title);
            content.setDesc(Desc);

            db.insert(content);

//            Toast.makeText(this, title, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        });
    }
}