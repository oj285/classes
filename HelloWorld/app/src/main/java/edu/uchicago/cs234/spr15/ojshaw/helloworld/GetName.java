package edu.uchicago.cs234.spr15.ojshaw.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.EditText;


public class GetName extends ActionBarActivity implements View.OnClickListener {

    EditText field_name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_name, menu);
        field_name = (EditText)this.findViewById(R.id.field_name);
        button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(this);
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

    public void onClick(View v) {
        String name =field_name.getText().toString();
        Intent intent = new Intent(this, HelloWorld.class);
        intent.putExtra("username", name);
        this.startActivity(intent);

    }
}
