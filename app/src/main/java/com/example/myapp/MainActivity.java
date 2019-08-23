package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    List<ModelRowItem> modelRowItems;

    public static final String[] titles = new String[]{
            "Bika Ambon",
            "Mie Aceh",
            "Karee Kameng",
            "Lempah Kuning",
            "Gado_Gado",
            "Gulai Ikan Patin",
            "Kerak Telur",
            "Kue Serabi",
            "Lumpia Semarang",
            "Gudeg Yogyakarta"
    };

    public static final int[] descriptions = new int[]{
            R.string.descBkaAmbon,
            R.string.descMieAceh,
            R.string.desKareeKameng,
            R.string.descLempahKuning,
            R.string.descGado,
            R.string.descGulaiPatin,
            R.string.descKerakTelor,
            R.string.descKueSerabi,
            R.string.descLumpiaSemarang,
            R.string.descGudeg
    };

    public static final Integer[] images = {
            R.drawable.bika_ambon,
            R.drawable.mie_aceh,
            R.drawable.karee_kameng,
            R.drawable.lempah_kuning,
            R.drawable.gado,
            R.drawable.gulai_ikan_patin,
            R.drawable.kerak_telor,
            R.drawable.serabi_betawi,
            R.drawable.lumpia_semarang,
            R.drawable.gudeg_jogja
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelRowItems = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            ModelRowItem item = new ModelRowItem(images[i], titles[i], descriptions[i]);
            modelRowItems.add(item);
        }

        listView = findViewById(R.id.list_view);
        CustomListAdapter adapter = new CustomListAdapter(this,
                R.layout.list_item, modelRowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Intent i = new Intent(getApplicationContext(), DetailActivity.class);

        i.putExtra("image", modelRowItems.get(position).getImage());
        i.putExtra("title", modelRowItems.get(position).getTitle());
        i.putExtra("desc", modelRowItems.get(position).getDesc());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}