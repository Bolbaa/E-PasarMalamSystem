package com.example.kaodimservices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.AdapterHolder> {

    private Context context;
    private  List<MainData> dataList;

    public  MainAdapter (Context context, List<MainData> dataList){
        this.context = context;
        this.dataList = dataList;

    }



    @NonNull
    @Override
    public MainAdapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_row_main, parent, false);
        AdapterHolder holder = new AdapterHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {

        final MainData mainData = dataList.get(position);
        String image = mainData.getImage();
        String name = mainData.getName();

    }


    @Override
    public int getItemCount() {

        return dataList.size();
    }

    public class AdapterHolder extends  RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public AdapterHolder(@NonNull View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }

}
