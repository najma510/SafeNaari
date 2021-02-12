package com.example.SafeNaari;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class People extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    ImageView phoneBook1, phoneBook2, phoneBook3;
    ImageButton backButton;

    int flow = 0;

    public static int getContact = 2;

    int globalContact = 0;
    boolean saveContactd = false;

    // Session Manager Class
    SessionManager session;

    // Button Logout
    Button btnNxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people);

        backButton = (ImageButton) findViewById(R.id.back);


        if (Build.VERSION.SDK_INT < 23) {


        } else
            if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {  // checkSelfPermission is a method avail in 23 api ..without if condition of (SDK_INT < 23 ) you cant implement it..

                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS}, getContact);

            } else {


            }


        TextView tv = (TextView) findViewById(R.id.toolbar_title);
        tv.setText(R.string.contacts);
        session = new SessionManager(getApplicationContext());

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText2 = (EditText) findViewById(R.id.editText3);


        phoneBook1 = (ImageView) findViewById(R.id.iv_phonebook1);
        phoneBook2 = (ImageView) findViewById(R.id.iv_phonebook2);
        phoneBook3 = (ImageView) findViewById(R.id.iv_phonebook3);

        phoneBook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalContact = 101;

                flow = 1;

                if (Build.VERSION.SDK_INT < 23) {

                    openContact1();

                } else
                    if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {  // checkSelfPermission is a method avail in 23 api ..without if condition of (SDK_INT < 23 ) you cant implement it..

                        requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS}, getContact);

                    } else {

                        openContact1();
                    }

            }
        });

        phoneBook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalContact = 102;

                flow = 1;
                if (Build.VERSION.SDK_INT < 23) {

                    openContact1();

                } else
                    if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {  // checkSelfPermission is a method avail in 23 api ..without if condition of (SDK_INT < 23 ) you cant implement it..

                        requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS}, getContact);

                    } else {

                        openContact1();
                    }


            }
        });

        phoneBook3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalContact = 103;
                flow = 1;

                if (Build.VERSION.SDK_INT < 23) {

                    openContact1();

                } else
                    if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {  // checkSelfPermission is a method avail in 23 api ..without if condition of (SDK_INT < 23 ) you cant implement it..

                        requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS}, getContact);

                    } else {

                        openContact1();
                    }

            }
        });

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == (101) && resultCode == RESULT_OK && null != data) {
            Uri contactData = data.getData();

            Cursor c = managedQuery(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String id =
                        c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                String hasPhone =
                        c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (hasPhone.equalsIgnoreCase("1")) {
                    Cursor phones = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);
                    phones.moveToFirst();
                    String phn_no1 = phones.getString(phones.getColumnIndex("data1"));

                    editText1.setText(phn_no1);
                }
            }
        } else if (requestCode == (102) && resultCode == RESULT_OK && null != data) {
            Uri contactData = data.getData();

            Cursor c = managedQuery(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String id =
                        c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                String hasPhone =
                        c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (hasPhone.equalsIgnoreCase("1")) {
                    Cursor phones = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);
                    phones.moveToFirst();
                    String phn_no2 = phones.getString(phones.getColumnIndex("data1"));

                    editText2.setText(phn_no2);
                }
            }
        }
        {
            try {

                Uri contactData = data.getData();

                Cursor c = managedQuery(contactData, null, null, null, null);
                if (c.moveToFirst()) {
                    String id =
                            c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                    String hasPhone =
                            c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                    if (hasPhone.equalsIgnoreCase("1")) {
                        Cursor phones = getContentResolver().query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                                null, null);
                        phones.moveToFirst();
                        String phn_no3 = phones.getString(phones.getColumnIndex("data1"));

                        editText3.setText(phn_no3);
                    }
                }

            } catch (Exception e) {

            }

        }

    }


    public void save(View v) {

        saveContactd = true;

        flow = 2;

        if (Build.VERSION.SDK_INT < 23) {

            saveContactData();

        } else
            if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {  // checkSelfPermission is a method avail in 23 api ..without if condition of (SDK_INT < 23 ) you cant implement it..

                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS}, getContact);

            } else {

                saveContactData();
            }


    }


    public void back(View v) {

        Intent i = new Intent(getApplicationContext(), NavigationAlert.class);
        startActivity(i);


    }

    public void openContact1() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, globalContact);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == getContact) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (flow == 0) {

                } else if (flow == 1) {
                    openContact1();
                } else if (flow == 2) {
                    saveContactData();
                }


            }


        }
    }

    public void saveContactData() {

        String cn1 = editText1.getText().toString();
        String cn2 = editText2.getText().toString();
        String cn3 = editText3.getText().toString();

        if (cn1.trim().length() > 0 && cn2.trim().length() > 0 && cn3.trim().length() > 0) {
            session.createContactSession(cn1, cn2, cn3);
            Intent i = new Intent(getApplicationContext(), PeopleSecond.class);
            startActivity(i);
            Toast.makeText(this, "Contacts Saved Successfully", Toast.LENGTH_LONG).show();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Please Add all 3 Contacts", Toast.LENGTH_LONG).show();

        }
    }

}
