package com.tns.birdverify;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    // A EditText to enter the username
    private EditText usernameEditText;

    // A Button to perform the search
    private Button searchButton;

    // The SQLite database helper instance
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        dbHelper.openDatabase();


        // Find the views by their IDs
        usernameEditText = findViewById(R.id.username_edit_text);
        searchButton = findViewById(R.id.search_button);

        // Set a click listener for the button
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input from the EditText
                String username = usernameEditText.getText().toString().trim();
                // Check if the username is valid and not empty
                // Get the TextView from the layout
                TextView resultTextView = findViewById(R.id.result_textview);

                // Check if the username is valid and not empty
                if (username != null && !username.isEmpty()) {
                    // Search for the username in the HashMap
                    if (dbHelper.checkUserExists(username)) {
                        // If found, show a message in the TextView
                        resultTextView.setText("El usuario " + username + " está verificado");
                    } else {
                        // If not found, show a message in the TextView that it is not in the list
                        resultTextView.setText("El usuario " + username + " no está en la lista de verificados");
                    }
                } else {
                    // If the input is empty, show a message in the TextView to enter a valid username
                    resultTextView.setText("Por favor, ingrese un nombre de usuario válido");
                }
                            }
        });
    }

}
