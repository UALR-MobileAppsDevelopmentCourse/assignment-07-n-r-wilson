package edu.ualr.intentsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import edu.ualr.intentsassignment.model.Contact;

public class ContactFormActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACT = "ContactData";

    // TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_form_layout);
    }
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.

    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
    public void onSubmitButtonClick(View view) {
        Intent intent = new Intent(this, ContactInfoActivity.class);
        Contact contact = new Contact();

        contact.setFirstName(((TextInputEditText)findViewById(R.id.tiet_fname)).getText().toString());
        contact.setLastName(((TextInputEditText)findViewById(R.id.tiet_lname)).getText().toString());
        contact.setAddress(((TextInputEditText)findViewById(R.id.tiet_address)).getText().toString());
        contact.setEmailAddress(((TextInputEditText)findViewById(R.id.tiet_email)).getText().toString());
        contact.setPhoneNumber(((TextInputEditText)findViewById(R.id.tiet_phone)).getText().toString());
        contact.setWebsite(((TextInputEditText)findViewById(R.id.tiet_website)).getText().toString());

        intent.putExtra(EXTRA_CONTACT, contact);
        startActivity(intent);
    }

}
