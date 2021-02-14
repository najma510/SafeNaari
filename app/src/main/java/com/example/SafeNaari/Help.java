package com.example.SafeNaari;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.SafeNaari.R;
import com.example.SafeNaari.FirstPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Help extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    ImageButton backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);


        TextView tv= (TextView) findViewById(R.id.toolbar_title);
        tv.setText(R.string.help);


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Ask for Help");
        listDataHeader.add("Privacy and Safety Center");
        listDataHeader.add("Information we collect");
        listDataHeader.add("Cookies and other technologies");
        listDataHeader.add("How to contact us");

        // Adding child data
        List<String> ask = new ArrayList<String>();
        ask.add("When you are feeling unsafe,quickly press the power button thrice and inform your Alert Contacts with information like current location and predefined messages about your situation.");


        List<String> privacy = new ArrayList<String>();
        privacy.add("By using our Service you understand and agree that we are providing you a platform to reach out to police or your well-wishers when in danger with just 3 clicks.\n" +

                "    Your current location would be sent with the message.\n" +
                "    This means that the emergency contacts would be able to know you present location.\n" +
                "    Our policy applies to all visitors,users and others who access the Service");


        List<String> info = new ArrayList<String>();
        info.add("Information you provide us:\n" +

                "        -> Your location\n" +
                "        -> Emergency Contacts\n" +
                "        -> Messages sent ");


        List<String> cookie = new ArrayList<String>();
        cookie.add(" -> When you visit the Service, we may use cookies and similar technologies like pixels,web becons and local storage to collect information.\n" +

                "     -> We may ask advertisers or other partners to serve ads or services to your devices,which may use cookies and similar technologies. ");

        List<String> contact = new ArrayList<String>();
        contact.add(" If you have any questions about Privacy Policy or the Service, please find appropriate support channel in Help Center at which to contact us.");

        listDataChild.put(listDataHeader.get(0), ask); // Header, Child data
        listDataChild.put(listDataHeader.get(1), privacy);
        listDataChild.put(listDataHeader.get(2), info);
        listDataChild.put(listDataHeader.get(3), cookie);
        listDataChild.put(listDataHeader.get(4), contact);
    }
    public void back(View v) {

        Intent i = new Intent(getApplicationContext(), FirstPage.class);
        startActivity(i);


    }

}