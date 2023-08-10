package sg.edu.rp.c346.id22019799.anightatthemovies;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RetrieveActivity extends AppCompatActivity {

    Button btnSortRating;
    ListView lvMovie;
    // Spinner starspinner;
    //Song song;
    ArrayList<Movie> data;
    ArrayAdapter<Movie> taskky;



    //ArrayList<Song> c = db.getTasks();
    //ArrayAdapter taskky = new ArrayAdapter(RetrieveActivity.this,android.R.layout.simple_list_item_1,songs);
    //lvSong.setAdapter(taskky);//
    //db.close();//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);


        btnSortRating=findViewById(R.id.buttonSortRating);
        lvMovie=findViewById(R.id.lvMovie);
        data = new ArrayList<>();
        taskky = new ArrayAdapter<>(RetrieveActivity.this,
                android.R.layout.simple_list_item_1, data);
        lvMovie.setAdapter(taskky);
        //starspinner=findViewById(R.id.spinnerSortStar);
        DBHelper db = new DBHelper(RetrieveActivity.this);
        data=db.getTasks();
        db.close();
        ArrayAdapter taskky = new ArrayAdapter(RetrieveActivity.this,android.R.layout.simple_list_item_1,data);
        lvMovie.setAdapter(taskky);


        //Intent i = getIntent();
        //song = (Song) i.getSerializableExtra("data");

        //db.close();

        //String txt = "";
        //for (int i = 0; i < data.size(); i++) {
        //Log.d("Database Content", i +". "+data.get(i));
        //txt += i + ". " + data.get(i) + "\n";
    }
}
