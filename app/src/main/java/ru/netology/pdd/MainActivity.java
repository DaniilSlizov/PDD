package ru.netology.pdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Не забудьте импортировать Button

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Найдите кнопку по ID
        Button buttonStart = findViewById(R.id.buttonStart); // Убедитесь, что ID соответствует вашему XML

        // Установите обработчик нажатия для кнопки
        buttonStart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class); // Создание интента для перехода
            startActivity(intent); // Запуск новой активности
        });
    }
}
