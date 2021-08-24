package xyz.songsari.fakirhat_ecommerce;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

import java.util.List;

import xyz.songsari.fakirhat_ecommerce.adapters.MainStoreAdapter;
import xyz.songsari.fakirhat_ecommerce.model.StoreTempModel;

public class MainActivity extends AppCompatActivity {

    private ImageCarousel carousel;
    private Button btnGrocerry;
    private Button btnPhermacy;
    //    ActionBar actionBar = getSupportActionBar();
    // List<StoreTempModel> temp = new ArrayList<StoreTempModel>();
    ArrayList<StoreTempModel> tempModel;
    MainStoreAdapter adapter;
    Toolbar mToolbar;
    ImageView userBar;
    ImageView expendBar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        carousel = findViewById(R.id.carousel);
        btnGrocerry = findViewById(R.id.btnGrocery);
        btnPhermacy = findViewById(R.id.btnPhermecy);
        userBar = findViewById(R.id.user_bar);
        expendBar = findViewById(R.id.expanded_bar);
        RecyclerView recyclerView = findViewById(R.id.shopListView);


        tollBarSetup();
        //tempModel.
        tempModel = new ArrayList<>();
        tempModel.add(new StoreTempModel("Abu Store"));
        tempModel.add(new StoreTempModel("Babu Store"));
        tempModel.add(new StoreTempModel("Kabu Store"));
        tempModel.add(new StoreTempModel("Dabu Store"));
        tempModel.add(new StoreTempModel("Labu Store"));
        adapter = new MainStoreAdapter(MainActivity.this, tempModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<CarouselItem> list = new ArrayList<>();
        list.add(
                new CarouselItem("https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
                        "")
        );
        list.add(
                new CarouselItem("https://images.pexels.com/photos/929778/pexels-photo-929778" +
                        ".jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "")
        );
        list.add(new CarouselItem("https://images.pexels.com/photos/747964/pexels-photo-747964" +
                ".jpeg?auto=compress&cs=tinysrgb&h=750&w=1260", ""));
        carousel.setData(list);
        btnPhermacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Phermecy Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btnGrocerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Grocerry Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        userBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, AuthActivity.class);
                startActivity(intent);
                finish();

            }
        });
        expendBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Expend Bar Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tollBarSetup() {
        setSupportActionBar(mToolbar);
        // actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setHomeAsUpIndicator(R.drawable.bar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setTitleTextColor(Color.rgb(255, 255, 255));

    }

}