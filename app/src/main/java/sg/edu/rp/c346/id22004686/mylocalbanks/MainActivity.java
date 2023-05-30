package sg.edu.rp.c346.id22004686.mylocalbanks;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;
import static android.graphics.Color.red;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView dbs, ocbc,uob, display1,display2,display3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);
        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);
        display3 = findViewById(R.id.display3);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.english) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.chinese) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        } else {
            dbs.setText("Error translation");
            ocbc.setText("Error translation");
            uob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    String click = "";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == dbs){
            click = "dbs";
        } else if (v == ocbc){
            click = "ocbc";
        } else if (v == uob){
            click = "uob";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (click.equalsIgnoreCase("dbs")){
        if (id == R.id.website) {
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intentWeb);
            return true;
        } else if (id == R.id.contact) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18001111111"));
            startActivity(intentCall);
            return true;
        } else if (id == R.id.toggle){
            display1.setBackgroundColor(RED);
        }else if (id == R.id.untoggle){
            display1.setBackgroundColor(BLACK);
        }}
        else if (click.equalsIgnoreCase("ocbc")){
            if (id == R.id.website) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
                return true;
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18003633333"));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.toggle){
                display2.setBackgroundColor(RED);
            }else if (id == R.id.untoggle){
                display2.setBackgroundColor(BLACK);
            }}
        else if (click.equalsIgnoreCase("uob")){
            if (id == R.id.website) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
                return true;
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18002222121"));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.toggle){
                display3.setBackgroundColor(RED);
            }else if (id == R.id.untoggle){
                display3.setBackgroundColor(BLACK);
            }}

        return super.onOptionsItemSelected(item);
    }

}