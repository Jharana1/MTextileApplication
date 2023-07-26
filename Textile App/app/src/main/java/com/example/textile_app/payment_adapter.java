package com.example.textile_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class payment_adapter extends RecyclerView.Adapter<payment_adapter.ViewHolder> {

    private List<payment_model> list;
    public payment_adapter(List<payment_model> list){

        this.list=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_payment,parent,false);
        return new payment_adapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull payment_adapter.ViewHolder holder, int position) {

        String oNo = list.get(position).getoNo();
        String oDate= list.get(position).getoDate();
        String tAmount= list.get(position).gettAmount();
        String aPay= list.get(position).getaPay();
        String rAmount= list.get(position).getrAmount();
        String status= list.get(position).getStatus();



        holder.setData(oNo,oDate,tAmount,aPay,rAmount,status);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView oNo1;
        private TextView oDate1;
        private TextView tAmount1;
        private TextView aPay1;
        private TextView rAmount1;
        private TextView status1;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            oNo1 =itemView.findViewById(R.id.textView3);
            oDate1=itemView.findViewById(R.id.textView6);
            tAmount1 =itemView.findViewById(R.id.textView9);
            aPay1 =itemView.findViewById(R.id.textView12);
            rAmount1 =itemView.findViewById(R.id.textView15);
            status1 =itemView.findViewById(R.id.textView18);

        }

        public void setData(String oNo, String oDate,  String tAmount, String aPay, String rAmount, String status){

            oNo1.setText(oNo);
            oDate1.setText(oDate);
            tAmount1.setText(tAmount);
            aPay1.setText(aPay);
            rAmount1.setText(rAmount);
            status1.setText(status);

        }

    }
}

