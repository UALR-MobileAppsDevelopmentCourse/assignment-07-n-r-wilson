package edu.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.model.Contact;

public class ContactInfoActivity extends AppCompatActivity {
    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    String FullName;
    String Address;
    String Email;
    String Phone;
    String Website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info_layout);

        readContactInfo();

    }

    void readContactInfo() {
        Contact contact = getIntent().getParcelableExtra(ContactFormActivity.EXTRA_CONTACT);
        FullName = contact.getFullName();
        Address = contact.getAddress();
        Email = contact.getEmailAddress();
        Phone = contact.getPhoneNumber();
        Website = contact.getWebsite();
        ((TextView)findViewById(R.id.tv_fullname)).setText(FullName);
        ((TextView)findViewById(R.id.tv_address)).setText(Address);
        ((TextView)findViewById(R.id.tv_email)).setText(Email);
        ((TextView)findViewById(R.id.tv_phone)).setText(Phone);
        ((TextView)findViewById(R.id.tv_website)).setText(Website);
    }

    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    public void onCallButtonClick(View view) {
        String phoneNumberUri = "tel:" + Phone;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumberUri));
        startActivity(intent);
    }
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    public void onTextButtonClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"+Phone));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    public void onMapButtonClick(View view) {
        String map = "http://maps.google.co.in/maps?q=" + Address.replace(" ", "+");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    public void onEmailButtonClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+Email));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step
    public void onWebButtonClick(View view) {
        String link = Website;
        if (!link.startsWith("http://") && !link.startsWith("https://"))
            link = "http://" + link;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
