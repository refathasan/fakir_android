package xyz.songsari.fakirhat_ecommerce.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainStoreAdapter extends RecyclerView.Adapter<MainStoreAdapter.MainStoreViewHolder> {
    @NonNull
    @Override
    public MainStoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainStoreViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MainStoreViewHolder extends RecyclerView.ViewHolder
    {

        public MainStoreViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
