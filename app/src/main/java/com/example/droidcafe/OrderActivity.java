package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        /*
        get the orderMessage passed with the intent
        set the order_textView to the passed message
         */
        Intent intent = getIntent();
        String message = "Order: " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView orderTextView = findViewById(R.id.order_textView);
        orderTextView.setText(message);

        // create the spinner
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        // array adapter for the spinner, using the default layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // specifies the type of layout when the list appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // applies the adapter to the spinner
        if (spinner != null){
            spinner.setAdapter(adapter);
        }
    }

    // delivery method toast message
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // is the radio button checked?
        boolean checked = ((RadioButton) view).isChecked();

        // check which radio button is clicked and display toast with option
        switch (view.getId()) {
            case R.id.same_day:
                if (checked)
                    // same day delivery option
                    displayToast(getString(R.string.same_day_messenger_service));
                break;

            case R.id.next_day:
                if (checked)
                    // next day delivery option
                    displayToast(getString(R.string.next_day_messenger_service));
                break;

            case R.id.pickup:
                if (checked)
                    // pick up delivery option
                    displayToast(getString(R.string.pick_up));
                break;

            default:
                // do nothing
                break;
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
