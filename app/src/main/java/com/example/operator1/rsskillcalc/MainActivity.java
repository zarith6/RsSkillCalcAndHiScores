package com.example.operator1.rsskillcalc;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    public EditText characterNameTextBox;
    public Button submitButton;
    public ListView statsListView;
    public ImageView rsLogo;
    public static List statsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterNameTextBox = (EditText)findViewById(R.id.characterNameTextBox);
        submitButton = (Button)findViewById(R.id.submitButton);
        rsLogo = (ImageView)findViewById(R.id.rsLogo);

        int logoId = getResources().getIdentifier("com.example.operator1.rsskillcalc:drawable/" + "rs3logo", null, null);
        rsLogo.setImageResource(logoId);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submitButtonClicked(View view){
        try
        {
            if(!characterNameTextBox.getText().toString().equals("") || characterNameTextBox.getText().toString().length() < 13)
            {
                String characterName = characterNameTextBox.getText().toString();
                RSChar character = new RSChar(characterName, MainActivity.this);
                if(character.getCharacterStatsList() != null)
                {
                    Intent intent = new Intent(this, StatsListViewActivity.class);
                    intent.putExtra("Character", character);
                    startActivity(intent);
                }
            }
            else
            {
                Toast t = Toast.makeText(this, "Please enter a username, or check that it's not too long", Toast.LENGTH_SHORT);
                t.show();
            }
        } catch(Exception ex){Toast t = Toast.makeText(this,ex.getMessage(),Toast.LENGTH_SHORT); t.show();}

    }

}
