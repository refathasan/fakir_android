package xyz.songsari.fakirhat_ecommerce.model;

import android.graphics.Bitmap;
import android.media.Image;

public class StoreTempModel {
    public StoreTempModel(String storeName)
    {
        this.storeName = storeName;
    }
    //Bitmap imageView;
    String storeName;

//    public Bitmap getImageView() {
//        return imageView;
//    }
//
//    public void setImageView(Bitmap imageView) {
//        this.imageView = imageView;
//    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "StoreModelView{" +
                //"imageView=" + imageView +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
