package com.example.my_application_v001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        // Создаем объект Intent для вызова новой Activity
        Intent intent = new Intent(this, DisplayMessage.class);

        // Получаем текстовое поле в текущей Activity
        EditText editText = (EditText) findViewById(R.id.edit_message);

        // Получае текст данного текстового поля
        String message = editText.getText().toString();

        // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
        // второй параметр - значение этого объекта
        intent.putExtra(EXTRA_MESSAGE, message);

        // запуск activity
        startActivity(intent);
    }

    // метод обработки нажатия на кнопку "geolocation"
    public void geoLocation(View view) {
        Intent intent = new Intent(this, GeoLocation.class);
        startActivity(intent);
    }

    // метод обработки нажатия на кнопку "geolocation"
    public void goToStopWatch(View view) {
        Intent intent = new Intent(this, StopWatch.class);
        startActivity(intent);
    }

    public void goToContacts(View view) {
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);
    }
}
