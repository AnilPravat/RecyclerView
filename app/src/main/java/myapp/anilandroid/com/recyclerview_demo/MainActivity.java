package myapp.anilandroid.com.recyclerview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   RecyclerView recyclerView;
   RecyclerView.Adapter adapter;
   RecyclerView.LayoutManager layoutManager;
   ArrayList<List_Provider> arrayList =new ArrayList<List_Provider>();
   String [] Name,Capital;
   int[] img_id={R.drawable.india,R.drawable.australiaflag,R.drawable.neatherland,R.drawable.newzeland,R.drawable.srilanka,R.drawable.thailand,R.drawable.uae};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
      recyclerView=(RecyclerView) findViewById( R.id.recyclerView );
      layoutManager= new LinearLayoutManager( this );
      recyclerView.setLayoutManager( layoutManager );
      recyclerView.setHasFixedSize( true );

      Name=getResources().getStringArray( R.array.Country_Name);
      Capital=getResources().getStringArray( R.array.Capital_name );
      int count=0;
      for (String NAME : Name){
          List_Provider list_provider=new List_Provider( img_id[count],NAME,Capital[count]);
          arrayList.add( list_provider );
          count++;
      }
      adapter=new RecyclerAdapter(arrayList);
      recyclerView.setAdapter( adapter );
    }
}
