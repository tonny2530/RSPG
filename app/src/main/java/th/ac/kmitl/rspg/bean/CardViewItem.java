package th.ac.kmitl.rspg.bean;

import th.ac.kmitl.rspg.constant.MainConstant;

public class CardViewItem extends BaseItem {

    private String itemId;
    private int cardViewImage;
    private String cardViewText;

    public CardViewItem() {
        super(MainConstant.TYPE_CARD_VIEW);
    }

    public int getImage() {
        return cardViewImage;
    }

    public CardViewItem setImage(int cardViewImage) {
        this.cardViewImage = cardViewImage;
        return this;
    }

    public String getText() {
        return cardViewText;
    }

    public CardViewItem setText(String cardViewText) {
        this.cardViewText = cardViewText;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}