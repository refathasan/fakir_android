package xyz.songsari.fakirhat_ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageCarousel carousel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carousel = findViewById(R.id.carousel);
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
    }

}