package com.example.textile_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class oder_detail_adapter extends RecyclerView.Adapter<oder_detail_adapter.ViewHolder> {

    private List<order_detail_model> list;
    public oder_detail_adapter(List<order_detail_model> list){

        this.list=list;
    }
    @NonNull
    @Override
    public oder_detail_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_order,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

         String oDate= list.get(position).getoDate();
         String oNo = list.get(position).getoNo();
         String tGray= list.get(position).gettGray();
         String mType= list.get(position).getmType();
         String cNo= list.get(position).getcNo();
         String dNo= list.get(position).getdNo();
         String apLot= list.get(position).getApLot();
         String tAmount= list.get(position).gettAmount();
         String status= list.get(position).getStatus();

         holder.setData(oDate,oNo,tGray,mType,cNo,dNo,apLot,tAmount,status);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        private TextView oDate1;
        private TextView oNo1;
        private TextView tGray1;
        private TextView mType1;
        private TextView cNo1;
        private TextView dNo1;
        private TextView apLot1;
        private TextView tAmount1;
        private TextView status1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            oDate1=itemView.findViewById(R.id.textView3);
            oNo1 =itemView.findViewById(R.id.textView6);
            tGray1 =itemView.findViewById(R.id.textView9);
            mType1 =itemView.findViewById(R.id.textView12);
            cNo1 =itemView.findViewById(R.id.textView15);
            dNo1 =itemView.findViewById(R.id.textView18);
            apLot1 =itemView.findViewById(R.id.textView21);
            tAmount1 =itemView.findViewById(R.id.textView24);
            status1 =itemView.findViewById(R.id.textView27);

        }

        public void setData(String oDate,String oNo, String tGray, String mType, String cNo, String dNo, String apLot, String tAmount, String status){

            oDate1.setText(oDate);
            oNo1.setText(oNo);
            tGray1.setText(tGray);
            mType1.setText(mType);
            cNo1.setText(cNo);
            dNo1.setText(dNo);
            apLot1.setText(apLot);
            tAmount1.setText(tAmount);
            status1.setText(status);

        }

    }
}
