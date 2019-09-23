package th.ac.kmitl.rspg.bean;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import th.ac.kmitl.rspg.R;

public class CardViewHolder extends BaseViewHolder {

    private ImageView imageView;
    private TextView textView;


    public CardViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.habitat_image_view);
        textView = (TextView) itemView.findViewById(R.id.habitat_list_name);

    }

    public void setImage(int image) {
        imageView.setImageResource(image);
    }

    public void setText(String text) {
        textView.setText(text);
    }


}


