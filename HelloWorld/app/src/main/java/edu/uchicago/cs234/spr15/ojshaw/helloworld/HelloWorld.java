package edu.uchicago.cs234.spr15.ojshaw.helloworld;

import android.content.Context;
import android.location.*;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

import static android.location.Location.convert;


public class HelloWorld extends ActionBarActivity implements LocationListener {

    private static final int FORMAT_DEGREES = 0 ;
    Bundle hashmap;
    String name;
    TextView lat;
    TextView lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_hello_world);
        LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        lat = (TextView)this.findViewById(R.id.latitude);
        lon = (TextView)this.findViewById(R.id.longitude);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
        hashmap = this.getIntent().getExtras();
        name = hashmap.getString("username");
        TextView text = (TextView)this.findViewById(R.id.label_greeting);
        text.setText("Hello, "+name+"!");
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

    public void onLocationChanged(Location loc) {
        double new_lat = loc.getLatitude();
        double new_lon = loc.getLongitude();
        lat.setText("Lattitude: "+ convert(new_lat,FORMAT_DEGREES));
        lon.setText("Longitude: "+ convert(new_lat,FORMAT_DEGREES));
    }
    public void onProviderDisabled(String info) {

    }
    public void onProviderEnabled(String info) {

    }
    public void onStatusChanged(String arg1, int arg2, Bundle arg3) {

    }
}
