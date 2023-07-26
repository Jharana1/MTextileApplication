package com.example.textile_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class orderprocessingAdapter extends RecyclerView.Adapter<orderprocessingAdapter.ViewHolder> {

    private java.util.List<orderprocessingModel> List;
    public orderprocessingAdapter(List<orderprocessingModel> List){

        this.List=List;
    }
    @NonNull
    @Override
    public orderprocessingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showorderprocessing,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderprocessingAdapter.ViewHolder holder, int position) {
        String oDate= List.get(position).getoDate();
        String oNumber = List.get(position).getoNumber();
        String totalGrayLot= List.get(position).getTotalGrayLot();
        String completedGrayLot= List.get(position).getCompletedGrayLot();
        String remainingGrayLot= List.get(position).getRemainingGrayLot();


        holder.setData(oDate,oNumber,totalGrayLot,completedGrayLot,remainingGrayLot);


    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private TextView oDate1;
        private TextView oNumber1;
        private TextView totalGrayLot1;
        private TextView completedGrayLot1;
        private TextView remainingGrayLot1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            oDate1=itemView.findViewById(R.id.oDate);
            oNumber1 =itemView.findViewById(R.id.oNumber);
            totalGrayLot1 =itemView.findViewById(R.id.totalGrayLot);
            completedGrayLot1 =itemView.findViewById(R.id.completeGrayLot);
            remainingGrayLot1 =itemView.findViewById(R.id.remainingGrayLot);

        }

        public void setData(String oDate, String oNumber, String totalGrayLot, String completedGrayLot, String remainingGrayLot){

            oDate1.setText(oDate);
            oNumber1.setText(oNumber);
            totalGrayLot1.setText(totalGrayLot);
            completedGrayLot1.setText(completedGrayLot);
            remainingGrayLot1.setText(remainingGrayLot);

        }

    }
}
