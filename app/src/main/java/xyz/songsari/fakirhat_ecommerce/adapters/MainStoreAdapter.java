package xyz.songsari.fakirhat_ecommerce.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import xyz.songsari.fakirhat_ecommerce.R;
import xyz.songsari.fakirhat_ecommerce.model.StoreTempModel;

public class MainStoreAdapter extends RecyclerView.Adapter<MainStoreAdapter.MainStoreViewHolder> {
    List<StoreTempModel>storeModel = new ArrayList<StoreTempModel>();
    Context context;
    public MainStoreAdapter(Context context,ArrayList<StoreTempModel> storeModel)
    {
        this.context = context;
        this.storeModel = storeModel;
    }
    @NonNull
    @Override
    public MainStoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item,parent,
                false);
        return new MainStoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainStoreViewHolder holder, @SuppressLint("RecyclerView") int position) {
        StoreTempModel temp = storeModel.get(position);
        //holder.storeImageView.setImageBitmap(temp.getImageView());
        holder.storeTextView.setText(temp.getStoreName());
        holder.storeDetailsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "Clicked"+String.valueOf(position)+" "+temp.getStoreName()+"",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return storeModel.size();
    }

    class MainStoreViewHolder extends RecyclerView.ViewHolder
    {
        ImageView storeImageView;
        TextView storeTextView;
        ImageButton storeDetailsImageButton;
        public MainStoreViewHolder(@NonNull View itemView) {
            super(itemView);
            //storeImageView = itemView.findViewById(R.id.list_icon_store);
            storeTextView = itemView.findViewById(R.id.list_icon_text);
            storeTextView.setTextColor(Color.RED);

            storeDetailsImageButton = itemView.findViewById(R.id.list_item_details);
        }
    }
}
