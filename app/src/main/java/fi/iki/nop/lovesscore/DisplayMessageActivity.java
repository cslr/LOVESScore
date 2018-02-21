package fi.iki.nop.lovesscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String score = intent.getStringExtra(MainActivity.EXTRA_SCORE);

        TextView textView = findViewById(R.id.textView5);
        textView.setText(score);
    }
}
