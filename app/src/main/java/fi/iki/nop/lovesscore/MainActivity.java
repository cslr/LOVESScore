package fi.iki.nop.lovesscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "fi.iki.nop.lovesscore.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScore(View view){
        // Response to press of the button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String name1 = editText1.getText().toString();
        String name2 = editText2.getText().toString();
        name1 = name1.toUpperCase();
        name2 = name2.toUpperCase();


        int l_score = 0;
        for(int i=0;i<name1.length();i++)
            if(name1.charAt(i) == 'L') l_score++;
        for(int i=0;i<name2.length();i++)
            if(name2.charAt(i) == 'L') l_score++;

        int o_score = 0;
        for(int i=0;i<name1.length();i++)
            if(name1.charAt(i) == 'O') o_score++;
        for(int i=0;i<name2.length();i++)
            if(name2.charAt(i) == 'O') o_score++;

        int v_score = 0;
        for(int i=0;i<name1.length();i++)
            if(name1.charAt(i) == 'V') v_score++;
        for(int i=0;i<name2.length();i++)
            if(name2.charAt(i) == 'V') v_score++;

        int e_score = 0;
        for(int i=0;i<name1.length();i++)
            if(name1.charAt(i) == 'E') e_score++;
        for(int i=0;i<name2.length();i++)
            if(name2.charAt(i) == 'E') e_score++;

        int s_score = 0;
        for(int i=0;i<name1.length();i++)
            if(name1.charAt(i) == 'S') s_score++;
        for(int i=0;i<name2.length();i++)
            if(name2.charAt(i) == 'S') s_score++;

        ArrayList list = new ArrayList();

        if(l_score < 10) list.add(new Integer(l_score));
        else{ list.add(new Integer(l_score / 10)); list.add(new Integer(l_score % 10)); }

        if(o_score < 10) list.add(new Integer(o_score));
        else{ list.add(new Integer(o_score / 10)); list.add(new Integer(o_score % 10)); }

        if(v_score < 10) list.add(new Integer(v_score));
        else{ list.add(new Integer(v_score / 10)); list.add(new Integer(v_score % 10)); }

        if(e_score < 10) list.add(new Integer(e_score));
        else{ list.add(new Integer(e_score / 10)); list.add(new Integer(e_score % 10)); }

        if(s_score < 10) list.add(new Integer(s_score));
        else{ list.add(new Integer(s_score / 10)); list.add(new Integer(s_score % 10)); }


        while(list.size() > 2){
            ArrayList tmp = new ArrayList();

            for(int i=0;i<list.size()-1;i++){
                int value = ((Integer)list.get(i)).intValue() + ((Integer)list.get(i+1)).intValue();

                if(value < 10) tmp.add(new Integer(value));
                else{ tmp.add(new Integer(value / 10)); tmp.add(new Integer(value % 10)); }
            }

            list = tmp;
        }

        int score = 0;

        if(list.size() == 2) {
            score = ((Integer)list.get(0)).intValue() * 10 + ((Integer)list.get(1)).intValue();
        }
        else if(list.size() == 1){
            score = ((Integer)list.get(0)).intValue();
        }


        /*

        int lo_score = l_score + o_score;
        int ov_score = o_score + v_score;
        int ve_score = v_score + e_score;
        int es_score = e_score + s_score;

        int lov_score = lo_score + ov_score;
        int ove_score = ov_score + ve_score;
        int ves_score = ve_score + es_score;

        int love_score = lov_score + ove_score;
        int oves_score = ove_score + ves_score;

        int score = love_score*10 + oves_score;
        */

        intent.putExtra(EXTRA_SCORE, new Integer(score).toString() + "%");
        startActivity(intent);

    }
}
