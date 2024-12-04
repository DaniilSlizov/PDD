package ru.netology.pdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class FinishActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Режим EdgeToEdge для использования всей области экрана
        setContentView(R.layout.activity_finish); // Устанавка макета для активности
        // Установка слушателя для обработки нажатия на кнопку "О программе"
        Button buttonInfo = findViewById(R.id.button5);
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на FinishActivity
                Intent intent = new Intent(FinishActivity.this, InfaprogActivity.class); // Создание интента для перехода на InfaprogActivity
                startActivity(intent); // Запуск новой активности
            }
        });
    }
}
