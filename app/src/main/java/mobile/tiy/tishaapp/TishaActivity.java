package mobile.tiy.tishaapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class TishaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    //class implentes 2 different listeners

         ListView list; // variables are declared globally so that the whole class can see them
         EditText text;
         Button addButton;

        AppClient client = new AppClient();

         ArrayAdapter<String> storedMessages; // a way to keep track of things when u add things to the list view by google.

        @Override
        protected void onCreate(Bundle savedInstanceState) { // will intionlize my view(phone)
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tisha);

            list = (ListView) findViewById(R.id.listView); //
            text = (EditText) findViewById(R.id.editText);
            addButton = (Button) findViewById(R.id.button);

            storedMessages = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1); // array list of strings, thats tie to *this*. alist of storedMessages
            list.setAdapter(storedMessages); //for this list i want to setAdapter for this list. type of list u want to keep track of.

            storedMessages.add("Welcome ^.^"); //adding hardcoded item to the list

            addButton.setOnClickListener(this); //my current object = *this* = an instance of itself.
            list.setOnItemLongClickListener(this);

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        @Override
        public void onClick(View v) { // created an onClick Event handler.
            String incomingMessage = text.getText().toString(); //getting value of text the text field.
            String returnedMessage = client.sendMessage(incomingMessage); // sending message ot server.
            storedMessages.add(returnedMessage); // adding whatever is in that text field to the List
            text.setText(""); // clearing that field for another text input

        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            String item = storedMessages.getItem(position); // get current item i selected
            storedMessages.remove(item); // then remove it
            return true;
        }



}
