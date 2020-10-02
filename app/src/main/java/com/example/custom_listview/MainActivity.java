package com.example.custom_listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String tieude[]={"Java","Python","PHP","Ruby","C++"};
    String tieudephu[]={"James Gosling "," Guido van Rossum"," Rasmus Lerdorf"," Yukihiro Matz Matsumoto","Bjarne Stroustrup"};
    int image[]={R.drawable.java,R.drawable.python,R.drawable.php,R.drawable.ruby,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listView);

        MyAdapter myAdapter = new MyAdapter(this,tieude,tieudephu,image);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(MainActivity.this, "James Gosling", Toast.LENGTH_SHORT).show();
                }  if (position==0){
                    Toast.makeText(MainActivity.this, " Guido van Rossum", Toast.LENGTH_SHORT).show();
                }
                if (position==0){
                    Toast.makeText(MainActivity.this, "Rasmus Lerdorf", Toast.LENGTH_SHORT).show();
                }
                if (position==0){
                    Toast.makeText(MainActivity.this, "Yukihiro Matz Matsumoto", Toast.LENGTH_SHORT).show();
                }
                if (position==0){
                    Toast.makeText(MainActivity.this, "Bjarne Stroustrup", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rtieude[];
        String rtieudephu[];
        int anh[];
        MyAdapter(Context c,String tieude[] ,String tieudephu[],int anh[]){
            super(c,R.layout.row,R.id.textview1,tieude);
            this.context=c;
            this.rtieude=tieude;
            this.rtieudephu=tieudephu;
            this.anh=anh;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =layoutInflater.inflate(R.layout.row,parent,false);
            ImageView image =row.findViewById(R.id.image);
            TextView tieude =row.findViewById(R.id.textview1);
            TextView tieudephu =row.findViewById(R.id.textview2);

            image.setImageResource(anh[position]);
            tieude.setText(rtieude[position]);
            tieudephu.setText(rtieudephu[position]);


            return row;
        }
    }
}