package co.edu.unipiloto.laboratoriologinsignup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText addressEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Spinner roleSpinner;
    private EditText birthDateEditText;
    private RadioGroup genderRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullNameEditText = findViewById(R.id.fullNameEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        addressEditText = findViewById(R.id.addressEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        roleSpinner = findViewById(R.id.roleSpinner);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
    }

    public void onRegisterClick(View view) {
        String fullName = fullNameEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();
        String role = roleSpinner.getSelectedItem().toString();
        String birthDate = birthDateEditText.getText().toString();
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
        String gender = selectedGenderRadioButton == null ? "" : selectedGenderRadioButton.getText().toString();

        if (TextUtils.isEmpty(fullName)) {
            fullNameEditText.setError("El nombre completo es requerido");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("El usuario es requerido");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("El email es requerido");
            return;
        }

        if (TextUtils.isEmpty(address)) {
            addressEditText.setError("La dirección física es requerida");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("La contraseña es requerida");
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            confirmPasswordEditText.setError("La confirmación de contraseña es requerida");
            return;
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Las contraseñas no coinciden");
            return;
        }

        if (TextUtils.isEmpty(birthDate)) {
            birthDateEditText.setError("La fecha de nacimiento es requerida");
            return;
        }

        if (selectedGenderId == -1) {
            Toast.makeText(this, "El género es requerido", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}

