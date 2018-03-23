package com.aavdeev.messangerr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {
        EditText message = findViewById(R.id.textView);
        String messageText = message.getText().toString();
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);



        startActivity(intent);
    }

    public void onSendIntent(View view) {
        EditText message = findViewById(R.id.textView);
        String messageText = message.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        Intent chosenIntent = Intent.createChooser(intent, "Выбор способа отправки");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);

        startActivity(chosenIntent);

    }
}
