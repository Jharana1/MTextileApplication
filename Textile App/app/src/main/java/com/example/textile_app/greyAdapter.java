package com.example.textile_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class greyAdapter extends RecyclerView.Adapter<greyAdapter.ViewHolder> {

    private List<greyModel> list;

    public greyAdapter(List<greyModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public greyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showgreydetails,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull greyAdapter.ViewHolder holder, int position) {
        String srNo = list.get(position).getSrNo();
        String grayType = list.get(position).getGrayType();
        String grayLot = list.get(position).getGrayLot();
        String dDate = list.get(position).getdDate();
        String dNumber = list.get(position).getdNumber();

        holder.setData(srNo,grayType,grayLot,dDate,dNumber);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView srNo1;
        private TextView grayType1;
        private TextView grayLot1;
        private TextView dDate1;
        private TextView dNumber1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            srNo1 = itemView.findViewById(R.id.srNo);
            grayType1 = itemView.findViewById(R.id.grayType);
            grayLot1 = itemView.findViewById(R.id.grayLot);
            dDate1 = itemView.findViewById(R.id.dDate);
            dNumber1 = itemView.findViewById(R.id.dNumber);
        }


        public void setData(String srNo,String grayType, String grayLot, String dDate, String dNumber) {
            srNo1.setText(srNo);
            grayType1.setText(grayType);
            grayLot1.setText(grayLot);
            dDate1.setText(dDate);
            dNumber1.setText(dNumber);
        }
    }
}
