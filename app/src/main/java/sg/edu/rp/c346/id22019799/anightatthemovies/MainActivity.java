package sg.edu.rp.c346.id22019799.anightatthemovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShowList;
    TextView tvTitle,tvGenre,tvYear,tvStars;
    EditText editTitle,editGenre,editYear;
    ListView lvResults;
    Spinner spnRating;
    ArrayList<Movie> data;
    ArrayAdapter<Movie> taskky;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsert);
        btnShowList = findViewById(R.id.buttonShowList);
        tvTitle = findViewById(R.id.textViewTitle);
        tvGenre = findViewById(R.id.textViewGenre);
        tvYear = findViewById(R.id.textViewTitle);
        spnRating = findViewById(R.id.spinnerRating);
        lvResults = findViewById(R.id.songList);
        editTitle = findViewById(R.id.editTextTitle);
        editGenre = findViewById(R.id.editTextGenre);
        editYear = findViewById(R.id.editTextYear);


        DBHelper db = new DBHelper(MainActivity.this);
        data=new ArrayList<Movie>();
        ArrayAdapter taskky = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);



        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                //DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                String title= editTitle.getText().toString();
                String genre= editGenre.getText().toString();
                int year = Integer.parseInt(editYear.getText().toString());
                String rating = "";
                spnRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                        switch (i){
                            case 0:
                                rating = "G";
                                break;
                            case 1:
                                rating = "PG";
                                break;
                            case 2:
                                rating = "PG13";
                                break;
                            case 3:
                                rating = "NC16";
                                break;
                            case 4:
                                rating = "M18";
                                break;
                            case 5:
                                rating = "R21";
                                break;
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        
                    }
                    data=db.getTasks();
                db.insertMovie(title, genre,year,rating);
                taskky.notifyDataSetChanged();

            }
        });


        btnShowList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context


                    Movie target = data.get(0);

                Intent i = new Intent(MainActivity.this,
                        RetrieveActivity.class);
                i.putExtra("data", target);
                startActivity(i);

                //old stuff
                //DBHelper db = new DBHelper(MainActivity.this);



                // Insert a task
                //ArrayList<Song> data = db.getTasks();
                //ArrayAdapter taskky = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);
                //lvResults.setAdapter(taskky);
                //db.close();

                //String txt = "";
                //for (int i = 0; i < data.size(); i++) {
                //Log.d("Database Content", i +". "+data.get(i));
                //txt += i + ". " + data.get(i) + "\n";

                //String filterText = lvResults.getText().toString().trim();
                //if(filterText.length() == 0) {
                //data.addAll(db.getTasks());
                //}
                //else{
                //taskky.addAll(db.getTasks(filterText));
                //}

                //data.add(i,txt);

                //taskky.notifyDataSetChanged();
                //}
            }
        });
    }
}