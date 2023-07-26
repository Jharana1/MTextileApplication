package com.example.textile_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class wholesalerAdapter extends RecyclerView.Adapter<wholesalerAdapter.ViewHolder> {
    String Email;

    private java.util.List<wholesalerModel> List;

    public wholesalerAdapter(List<wholesalerModel> List,String Email)
    {
        this.List = List;
        this.Email = Email;
    }
    Context context;
    int image1;



    @NonNull
    @Override
    public wholesalerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showwholesalerdetails,parent,false);
        context=parent.getContext();

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull wholesalerAdapter.ViewHolder holder, int position) {

        int img = List.get(position).getImg();
        image1 = List.get(position).getImg();
        String catalogueN = List.get(position).getCatalogueN();
        String designN = List.get(position).getDesignN();

        holder.setData(img,catalogueN,designN);

    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img1;
        private int image2;
        private TextView catalogueN1;
        private TextView designN1;
        private Button btn1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img);
            catalogueN1 = itemView.findViewById(R.id.catalogueN);
            designN1 = itemView.findViewById(R.id.designN);

            btn1 = itemView.findViewById(R.id.addCart);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String image = Integer.toString(image2);
                    String catalogue = catalogueN1.getText().toString();
                    String design = designN1.getText().toString();
                    String email = Email;
                    String type = "Add";
                    addFunction function1 = new addFunction(context);
                    function1.execute(type, catalogue, design,image,email);
                }
            });


        }


        public void setData(int img, String catalogueN, String designN) {
            img1.setImageResource(img);
            image2=img;
            catalogueN1.setText(catalogueN);
            designN1.setText(designN);

        }
    }
}
