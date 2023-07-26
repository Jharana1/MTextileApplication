package com.example.textile_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class cardsdapter extends RecyclerView.Adapter<cardsdapter.ViewHolder> {

    private List<cardModel> list;
    private Context context;
    int id;

    public cardsdapter(List<cardModel> list,int id) {

        this.id = id;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cart, parent, false);
        context=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        cardModel c = list.get(position);

        holder.catalogueN1.setText(c.getCatalogueN());
        holder.designN1.setText(c.getDesignN());
        holder.img1.setImageResource(c.getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img1;
        public TextView catalogueN1;
        public TextView designN1;
        public ImageView delete;
//        private TextView amount1;
//        private ImageView delete1;


        public ViewHolder(View itemView) {
            super(itemView);

             img1 = itemView.findViewById(R.id.img1);
            catalogueN1 = itemView.findViewById(R.id.catalogueN);
            designN1 = itemView.findViewById(R.id.designN);
            delete=itemView.findViewById(R.id.delete);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    String id1 = Integer.toString(id);
                    String type = "Delete";
                    cartdeletefunction function = new cartdeletefunction(context);
                    function.execute(type,id1);
                }
            });

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    cardModel cpu = (cardModel) view.getTag();
//
//                    Toast.makeText(view.getContext(), cpu.getCatalogueN() + "and " + cpu.getDesignN(), Toast.LENGTH_SHORT).show();
//                }
//            });

//                }
//            });
//
//        }
//
//
//        public void setData(int img1, String catalogueN, String designN,String amount, int delete) {
//            img2.setImageResource(img1);
//            catalogueN1.setText(catalogueN);
//            designN1.setText(designN);
//            amount1.setText(amount);
//            delete1.setImageResource(delete);


        }
    }
}
