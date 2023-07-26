package com.example.textile_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class delivery_adapter extends RecyclerView.Adapter<delivery_adapter.ViewHolder> {

    private List<delivery_model> list;
    public  delivery_adapter(List<delivery_model> list){

        this.list=list;
    }

    @NonNull
    @Override
    public delivery_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_delivery,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull delivery_adapter.ViewHolder holder, int position) {


        String dNo= list.get(position).getdNO();
        String dDate= list.get(position).getdDate();
        String tGray= list.get(position).gettGray();
        String cNo= list.get(position).getcNo();
        String deNo= list.get(position).getDeNo();
        String vNo= list.get(position).getvNo();
        String dName= list.get(position).getdName();
        String dNumber= list.get(position).getdNumber();


       holder.setData(dNo,dDate,tGray,cNo,deNo,vNo,dName,dNumber);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{

        private TextView dNo1;
        private TextView dDate1;
        private TextView tGray1;
        private TextView cNo1;
        private TextView deNo1;
        private TextView vNo1;
        private TextView dName1;
        private TextView dNumber1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            dNo1 = itemView.findViewById(R.id.tv2);
            dDate1 = itemView.findViewById(R.id.tv5);
            tGray1 = itemView.findViewById(R.id.tv8);
            cNo1 = itemView.findViewById(R.id.tv11);
            deNo1 = itemView.findViewById(R.id.tv14);
            vNo1 = itemView.findViewById(R.id.tv17);
            dName1 = itemView.findViewById(R.id.tv20);
            dNumber1 = itemView.findViewById(R.id.tv23);
        }

        public  void setData(String dNo,String dDate, String tGray,String cNo, String deNo, String vNo, String dName, String dNumber){

            dNo1.setText(dNo);
            dDate1.setText(dDate);
            tGray1.setText(tGray);
            cNo1.setText(cNo);
            deNo1.setText(deNo);
            vNo1.setText(vNo);
            dName1.setText(dName);
            dNumber1.setText(dNumber);

        }
    }
}
