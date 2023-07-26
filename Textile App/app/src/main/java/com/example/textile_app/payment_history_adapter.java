package com.example.textile_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class payment_history_adapter extends RecyclerView.Adapter<payment_history_adapter.ViewHolder> {

    private List<payment_history_model> list;
    public  payment_history_adapter(List<payment_history_model> list){

        this.list=list;
    }

    @NonNull
    @Override
    public payment_history_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_payment_history,parent,false);
        return new payment_history_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull payment_history_adapter.ViewHolder holder, int position) {


        String pId = list.get(position).getpId();
        String oNo = list.get(position).getoNO();
        String tAmount = list.get(position).gettAmount();
        String pDetail = list.get(position).getpDetail();



        holder.setData(pId,oNo,tAmount,pDetail);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{

        private TextView pId1;
        private TextView oNo1;
        private TextView tAmount1;
        private TextView pdetail1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            pId1 = itemView.findViewById(R.id.payid);
            oNo1 = itemView.findViewById(R.id.ordernumber);
            tAmount1 = itemView.findViewById(R.id.totalamount);
            pdetail1 = itemView.findViewById(R.id.paymentdetail);
        }

        public  void setData(String pId,String oNo, String tAmount,String pDetail){

            pId1.setText(pId);
            oNo1.setText(oNo);
            tAmount1.setText(tAmount);
            pdetail1.setText(pDetail);


        }
    }
}
