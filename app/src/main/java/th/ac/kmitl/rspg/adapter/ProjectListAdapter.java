package th.ac.kmitl.rspg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.bean.BaseItem;
import th.ac.kmitl.rspg.bean.BaseViewHolder;
import th.ac.kmitl.rspg.bean.CardViewHolder;
import th.ac.kmitl.rspg.bean.CardViewItem;
import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.util.ItemClickListener;


public class ProjectListAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<BaseItem> itemList = new ArrayList<>();

    private Context context;

    public ProjectListAdapter(List<BaseItem> itemList, Context context) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;

        if (viewType == MainConstant.TYPE_CARD_VIEW) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.project_list, parent, false);
            return new CardViewHolder(v);
        }

        throw new RuntimeException("type is not match");
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        BaseItem i = itemList.get(position);
        CardViewItem cardViewItem = null;
        if (holder instanceof CardViewHolder) {
            cardViewItem  = (CardViewItem) i;
            ((CardViewHolder) holder).setText(cardViewItem.getText());
        }

        final CardViewItem finalCardViewItem = cardViewItem;
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){
                    Toast.makeText(context,"Long Click "+ finalCardViewItem.getItemId() + " : "+ finalCardViewItem.getText() ,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context,"Click "+ finalCardViewItem.getItemId() + " : "+ finalCardViewItem.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (!itemList.isEmpty() || itemList != null) {
            return itemList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }

    public void setItemList(List<BaseItem> itemList) {
        this.itemList = itemList;

        notifyDataSetChanged();
    }


}
