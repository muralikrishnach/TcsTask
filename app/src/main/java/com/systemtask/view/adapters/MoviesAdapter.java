package com.systemtask.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.systemtask.R;
import com.systemtask.model.MoviesDataDo;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>{

    Context ctx;
    List<MoviesDataDo> heroList;

    public MoviesAdapter(Context ctx,List<MoviesDataDo> heroList){
        this.ctx = ctx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.recyclerview_layout, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        final MoviesDataDo hero = heroList.get(position);

        Glide.with(ctx)
                .load(hero.getImageurl())
                .into(holder.imageView);

        holder.textView.setText(hero.getName());

        holder.biography.setText("AutoBiography :"+hero.getBio());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"I am "+hero.getRealname(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(heroList!=null){
            return heroList.size();
        }else {
            return 0;
        }
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView biography;
        LinearLayout layout;

        public MoviesViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            biography = itemView.findViewById(R.id.tv_biography);
            layout = itemView.findViewById(R.id.lllayout);
        }
    }

}
