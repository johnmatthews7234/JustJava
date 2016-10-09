package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int pricePerCup = 5;
        CheckBox whippedCream = (CheckBox) findViewById(R.id.cbWhippedCream);
        CheckBox chocolate = (CheckBox) findViewById(R.id.cbChocolate);
        EditText etCustomerName = (EditText) findViewById(R.id.etCustomerName);
        String customerName = etCustomerName.getText().toString();
        displayMessage(createOrderSummary(pricePerCup,customerName,whippedCream.isChecked(),chocolate.isChecked()));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayOrderSummary(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
        }
        displayQuantity(quantity);
    }

    private void displayMessage(String message ) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     * @param pricePerCup is the number of cups of coffee ordered
     */
    private int calculatePrice(int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }

    private String createOrderSummary(int pricePerCup, String customerName, boolean addWhippedCream, boolean addChocolate) {
        String myOutput = "Name: " + customerName + "\n";
        myOutput += "Quantity: " + quantity + "\n";
        myOutput += "Add whipped cream? " + addWhippedCream + "\n";
        myOutput += "Add chocolate? " + addChocolate + "\n";
        myOutput += "Total: $" + (calculatePrice(5)) + "\n";
        myOutput += "Thankyou!";
        return myOutput;
    }
}
