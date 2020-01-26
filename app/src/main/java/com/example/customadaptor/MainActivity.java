package com.example.customadaptor;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {


    private final String TAG = "Myactivity";
    ListView lists;
    ArrayList <String> checkedvalue;
    Button btn;
    //String[] items = {"Moong Dal","Thoor Dal","Rice","Fish","Turkey","Chicken","Lamb"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList items=displaydata();
        lists = (ListView)findViewById(R.id.list_view);
        btn = (Button)findViewById(R.id.button);
        CustomAdaptor adaptor = new CustomAdaptor(this,items);
        lists.setAdapter(adaptor);
        lists.setOnItemClickListener(this);
        lists.setItemsCanFocus(true);
        btn.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view) {
                Toast.makeText(MainActivity.this,""+checkedvalue,Toast.LENGTH_LONG).show();

            }
        });

    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main,menu);
        return true;
    }*/

   private ArrayList<CustomData> displaydata(){
       ArrayList<CustomData> dataset = new ArrayList<CustomData>();
       CustomData dataitems = new CustomData("Moong Dal");
       dataset.add(dataitems);
       dataitems = new CustomData("Thoor Dal");
       dataset.add(dataitems);
       dataitems = new CustomData("Fish");
       dataset.add(dataitems);
       dataitems = new CustomData("Octopus");
       dataset.add(dataitems);
       dataitems = new CustomData("Lamb");
       dataset.add(dataitems);
       dataitems = new CustomData("Chicken");
       dataset.add(dataitems);
       dataitems = new CustomData("Turkey");
       dataset.add(dataitems);
       return dataset;
   }
    @Override
    public void onItemClick(AdapterView arg0, View view, int i, long l) {

        Log.i(TAG,"printing mainact"+checkedvalue);
        CheckBox chkbox = (CheckBox)view.findViewById(R.id.checkBox);
        TextView txtview= (TextView)view.findViewById(R.id.textView);
        chkbox.performClick();
        if(chkbox.isChecked()){
            checkedvalue.add(txtview.getText().toString());
            Log.i(TAG,"printing mainact"+checkedvalue);
        }
        else if(!chkbox.isChecked()){
            checkedvalue.remove(txtview.getText().toString());

        }

    }

    /*public void onClick(View view) {
        Toast.makeText(MainActivity.this,""+checkedvalue,Toast.LENGTH_LONG).show();

    }*/
}
