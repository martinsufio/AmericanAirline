package com.example.americanairline;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context context;
    private List<Products> products;

    public ItemAdapter(Context context, List<Products> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Products product= products.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvName;
        private TextView tvprice;
        private  TextView aaprice;
        private ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.cvTitle);
            tvprice = itemView.findViewById(R.id.cvprice);
            ivImage = itemView.findViewById(R.id.cvImage);
            aaprice = itemView.findViewById(R.id.cvAAprice);
            itemView.setOnClickListener(this);
        }

        public void bind(Products products) {
            tvprice.setText(products.getDescription());
            tvName.setText(products.getTitle());
            aaprice.setText(products.getAAPrice());
            Glide.with(context).load(products.getImage().getUrl()).into(ivImage);

        }

        @Override
        public void onClick(View v) {
            int exerciseClicked = getAdapterPosition();
            if (exerciseClicked != RecyclerView.NO_POSITION) {
//                Intent intent = new Intent(context, ExercisesActivity.class);
//                intent.putExtra("page", exerciseClicked);
//                context.startActivity(intent);
            }
        }
    }
}
