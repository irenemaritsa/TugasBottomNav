package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ViewHolder> {

    private List<Hero> heroes;
    private OnItemClickCallback onItemClickCallback;

    public ListHeroAdapter(List<Hero> heroes) { this.heroes = heroes;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        holder.ivPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(heroes.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvName, tvDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_hero);
            tvName = itemView.findViewById(R.id.tv_hero_name);
            tvDetail = itemView.findViewById(R.id.tv_hero_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hero data);
    }
}
