package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    // variable to hold the toast message
    String orderMessage;

    // variable to define the key for our extras
    public static final String EXTRA_MESSAGE = "com.example.droidcafe.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // floating action button set to launch OrderActivity
        // carries the orderMessage as extras to OrderActivity
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, orderMessage);
                if (orderMessage == null){
                    displayToast("Please Select An Item");
                } else {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, orderMessage);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            case R.id.action_settings:
                Intent intent2 = new Intent(this, SettingsActivity.class);
                startActivity(intent2);
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Creates the Toast to be displayed when an image is clicked
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }

    /**
     * Displays the Toast to show Donut image was clicked
     *
     * @param view ImageView of the Donut
     */
    public void showDonutOrder(View view) {
        orderMessage = getString(R.string.donut_order_message);
        displayToast(orderMessage);
    }

    /**
     * Displays the Toast to show IceCream Sandwich image was clicked
     *
     * @param view ImageView of the IceCream Sandwich
     */
    public void showIceCreamOrder(View view) {
        orderMessage = getString(R.string.ice_cream_order_message);
        displayToast(orderMessage);
    }

    /**
     * Displays the Toast to show Froyo image was clicked
     *
     * @param view ImageView of the Froyo
     */
    public void showFroyoOrder(View view) {
        orderMessage = getString(R.string.froyo_oder_message);
        displayToast(orderMessage);
    }
}
