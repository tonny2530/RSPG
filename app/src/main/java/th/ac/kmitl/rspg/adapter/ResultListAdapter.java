package th.ac.kmitl.rspg.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.activity.CreatureActivity;
import th.ac.kmitl.rspg.activity.NewsActivity;
import th.ac.kmitl.rspg.activity.PlantActivity;
import th.ac.kmitl.rspg.bean.BaseItem;
import th.ac.kmitl.rspg.bean.BaseViewHolder;
import th.ac.kmitl.rspg.bean.CardViewHolder;
import th.ac.kmitl.rspg.bean.CardViewItem;
import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.util.ItemClickListener;


public class ResultListAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<BaseItem> itemList = new ArrayList<>();

    private Context context;

    public ResultListAdapter(List<BaseItem> itemList, Context context) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;

        if (viewType == MainConstant.TYPE_CARD_VIEW) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.plant_list, parent, false);
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
            ((CardViewHolder) holder).setImage(cardViewItem.getImage());
            ((CardViewHolder) holder).setText(cardViewItem.getText());
        }

        final CardViewItem finalCardViewItem = cardViewItem;
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                String requestId = finalCardViewItem.getItemId();
                String id = requestId.substring(0,requestId.indexOf("|"));
                String type = requestId.substring(requestId.indexOf("|")+1);
//                ;
                if("News".equalsIgnoreCase(type)){
                    Intent i = new Intent(context,NewsActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("newsId",id);
                    context.startActivity(i);
                }else if("Plant".equalsIgnoreCase(type)){
                    Intent i = new Intent(context,PlantActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("plantId",id);
                    context.startActivity(i);
                }else if("Creature".equalsIgnoreCase(type)){
                    Intent i = new Intent(context,CreatureActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("creatureId",id);
                    context.startActivity(i);
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
