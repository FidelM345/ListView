package com.example.fidelmomolo.listview;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String>man;
    ArrayAdapter<String>manmenu;
    SearchView searchView;
    ListView listView;

    String[]items= {
            "Macnchester",
            "Liverpool",
            "Chelsea",
            "Manchester City"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        String[]description= {
                "It is the biggest club in England and the club with the most tittle won",
                "It is the club with the biggest fan base in england also boasts of some tittles",
                "It is the best club in the current english error it is just a good club",
                "it is the club with most expensive players on planet earth"

        };


        Integer[] imgid={
                R.drawable.chelsea,
        R.drawable.mancity,
        R.drawable.family,
        R.drawable.gor

        };


     //  searchView=(SearchView)findViewById(R.id.searchView);

        //ListAdapter man=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
         man=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);

         listView=(ListView) findViewById(R.id.list);

        // ListAdapter lady=new CustomAdapter(this,items,description,imgid);

         listView.setAdapter(man);


       /* searchView.setOnQueryTextListener(

                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {

                        man.getFilter().filter(newText);
                        return false;
                    }
                }
        );*/


       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String food=String.valueOf(parent.getItemAtPosition(position));

               // Toast.makeText(MainActivity.this,food,Toast.LENGTH_SHORT).show();

                if(food=="Chelsea"){

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(food);
                builder.setTitle("The club selected is");
                builder.setCancelable(true);
                builder.show();}



           //     int item=parent.getPositionForView(view);


           //     Toast.makeText(MainActivity.this, ""+item, Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchme, menu);







        MenuItem searchItem = menu.findItem(R.id.action_search1);// name displayed on menu
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchManager searchManager=(SearchManager)getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                man.getFilter().filter(newText);


                return false;
            }
        });






        return true;
    }





}

