package com.wang.highui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecycleView extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Fairy>fairyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        recyclerView = findViewById(R.id.recycleView);
        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(layoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        FairyAdapter fairyAdapter = new FairyAdapter(fairyList);
        recyclerView.setAdapter(fairyAdapter);
    }

    void initData(){
        int[] img = new int[]{
                R.drawable.v1,
                R.drawable.v2,
                R.drawable.v3,
                R.drawable.v4,
                R.drawable.v5,
                R.drawable.v6,
                R.drawable.v7,
                R.drawable.v8,
                R.drawable.v9,
        };
        fairyList = new ArrayList<Fairy>();

        for(int i=0;i<img.length;i++){
            Fairy fairy = new Fairy("fairy",img[i]);
            fairyList.add(fairy);
        }
    }

    class FairyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private View fairyView
        public FairyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = findViewById(R.id.itemImage);
            textView = findViewById(R.id.itemTitle);
            fairyView = itemView;
        }
    }

    class FairyAdapter extends RecyclerView.Adapter<FairyViewHolder>{

        private List<Fairy> fairyList;
        public FairyAdapter(List<Fairy> fairyList){
            this.fairyList = fairyList;
        }

        @NonNull
        @Override
        public FairyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);
            final FairyViewHolder fairyViewHolder = new FairyViewHolder(view);
            fairyViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),view.getId(),Toast.LENGTH_SHORT).show();
                }
            });

            fairyViewHolder.fairyView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = fairyViewHolder.getAdapterPosition();
                    Fairy fairy = fairyList.get(position);
                    Toast.makeText(view.getContext(),fairy.getName(),Toast.LENGTH_SHORT).show();
                }
            });
            return fairyViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull FairyViewHolder holder, int position) {
            Fairy fairy = fairyList.get(position);
            holder.textView.setText(fairy.getName());
            holder.imageView.setImageResource(fairy.getId());
        }

        @Override
        public int getItemCount() {
            return fairyList.size();
        }
    }
}

























