package ru.netology.pdd;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class QuestionActivity extends AppCompatActivity {
    private static final String INCORRECT_MESSAGE = "Неправильно!";
    private Button lastClickedButton = null; // Переменная для хранения последней нажатой кнопки
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        // Получение ссылок на кнопки
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        // Установка обработчиков нажатий
        button1.setOnClickListener(view -> handleAnswer(button1));
        button2.setOnClickListener(view -> handleAnswer(button2));
        button3.setOnClickListener(view -> handleCorrectAnswer()); // Переход на FinishActivity
        button4.setOnClickListener(view -> handleAnswer(button4));
    }
    // Метод для обработки нажатий на кнопки
    private void handleAnswer(Button button) {
        // Если есть предыдущая кнопка, сбрасываем её цвет
        if (lastClickedButton != null) {
            lastClickedButton.setBackgroundColor(Color.TRANSPARENT); // использование исходного цвета
        }
        // Установка цвета для текущей кнопки
        button.setBackgroundColor(Color.RED);
        showToast(INCORRECT_MESSAGE);
        // Обновление ссылки на последнюю нажатую кнопку
        lastClickedButton = button;
    }
    // Метод для обработки правильного ответа (нажатие на button3)
    private void handleCorrectAnswer() {
        // Если есть предыдущая кнопка, сбрасываем её цвет
        if (lastClickedButton != null) {
            lastClickedButton.setBackgroundColor(Color.TRANSPARENT); // использование исходного цвета
        }
        // Переход на FinishActivity
        Intent intent = new Intent(QuestionActivity.this, FinishActivity.class); // Создание интента для перехода на FinishActivity
        startActivity(intent); // Запуск новой активности
    }
    // Метод для отображения Toast-сообщения
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
