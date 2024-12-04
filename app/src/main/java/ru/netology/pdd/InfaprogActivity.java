package ru.netology.pdd;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class InfaprogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Режим EdgeToEdge для использования всей области экрана
        setContentView(R.layout.activity_infaprog); // Установка макета для активности
        // Получение ссылки на кнопку и установка обработчика нажатия
        Button buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(v -> showExitConfirmationDialog()); // Показ диалогового при нажатии на кнопку
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(InfaprogActivity.this);
        builder.setTitle("Выход из приложения")
                .setIcon(R.drawable.close)
                .setMessage("Вы уверены, что хотите закрыть приложение?")
                .setCancelable(false)
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity(); // Закрытие всех активностей и приложения
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); // Отмена действия
                    }
                });
        AlertDialog alert = builder.create();
        alert.show(); // Показ диалогового окна
    }
}

