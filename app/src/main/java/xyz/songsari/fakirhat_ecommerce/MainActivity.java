package xyz.songsari.fakirhat_ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageCarousel carousel;
    private Button btnGrocerry;
    private Button btnPhermacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carousel = findViewById(R.id.carousel);
        btnGrocerry = findViewById(R.id.btnGrocery);
        btnPhermacy = findViewById(R.id.btnPhermecy);
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
    }

}