package fr.upjv.com.example.miage2025_introduction;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondaryActivity extends AppCompatActivity {
    private Button buttonClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_secondary);
        buttonClose = findViewById(R.id.id_close_secondaryactivity_button);
        this.buttonClose.setOnClickListener(
                View -> {
                    finish();
                }
        );

        Intent intent = getIntent();
        Bundle extractedBundle = intent.getExtras();

        String login = extractedBundle.getString("login_key", "login_empty");
        String pwd = extractedBundle.getString("pwd_key", "login_empty");

        Toast.makeText(this,  login + " : " + pwd, Toast.LENGTH_SHORT).show();
    }
}
