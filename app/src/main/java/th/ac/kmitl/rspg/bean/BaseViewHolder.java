package th.ac.kmitl.rspg.bean;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import th.ac.kmitl.rspg.util.ItemClickListener;


public class BaseViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener,View.OnLongClickListener{

    private ItemClickListener itemClickListener;

    public BaseViewHolder(View itemView) {

        super(itemView);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),true);
        return true;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

}