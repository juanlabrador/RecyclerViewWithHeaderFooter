package com.juanlabrador.recyclerviewwithheaderfooter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by juanlabrador on 16/08/15.
 */
public class DailyMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private ArrayList<Item> mItems;
    public static final int HEADER = 1;
    public static final int NORMAL_WITHOUT_IMAGE = 2;
    public static final int NORMAL_WITH_IMAGE = 3;
    public static final int FOOTER = 4;
    private Context mContext;

    public DailyMenuAdapter(Context context, ArrayList<Item> items) {
        mContext = context;
        mLayoutInflater = mLayoutInflater.from(context);
        mItems = items;
    }

    public class Header extends RecyclerView.ViewHolder {

        private TextView mTime;

        public Header(View itemView) {
            super(itemView);

            mTime = (TextView) itemView.findViewById(R.id.content_header);
        }

        public void setTime(String text) {
            mTime.setText(text);
        }
    }

    public class ItemWithoutImage extends RecyclerView.ViewHolder {

        private ImageView mIcon;
        private TextView mContent;
        private TextView mTime;

        public ItemWithoutImage(View itemView) {
            super(itemView);

            mIcon = (ImageView) itemView.findViewById(R.id.icon);
            mContent = (TextView) itemView.findViewById(R.id.content_item);
            mTime = (TextView) itemView.findViewById(R.id.time_item);
        }

        public void setIcon(int image) {
            mIcon.setImageResource(image);
        }

        public void setContent(String text) {
            mContent.setText(text);
        }

        public void setTime(String text) {
            mTime.setText(text);
        }
    }

    public class ItemWithImage extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mIcon;
        private TextView mContent;
        private TextView mTime;
        private ImageView mImage;

        public ItemWithImage(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.icon);
            mContent = (TextView) itemView.findViewById(R.id.content_item);
            mTime = (TextView) itemView.findViewById(R.id.time_item);
            mImage = (ImageView) itemView.findViewById(R.id.image);
            mImage.setOnClickListener(this);
        }

        public void setIcon(int image) {
            mIcon.setImageResource(image);
        }

        public void setContent(String text) {
            mContent.setText(text);
        }

        public void setTime(String text) {
            mTime.setText(text);
        }

        public void setImage(int image) {
            mImage.setTag(image);
            mImage.setImageResource(image);
        }


        @Override
        public void onClick(View v) {
            switch ((Integer) v.getTag()) {
                case R.drawable.bento:
                    Toast.makeText(mContext, "¡Tiempo de sushi!", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.birthday_cake:
                    Toast.makeText(mContext, "Una torta de fresa, rellena de dulce de fresa con capa de fresa. ¡Umm!", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.cooking_pot:
                    Toast.makeText(mContext, "Detesto la sopa. ;)", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.hamburger:
                    Toast.makeText(mContext, "¿Quien no ama McDonald\'s?", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.kebab:
                    Toast.makeText(mContext, "Sabrosas las brochetas.", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.spaghetti:
                    Toast.makeText(mContext, "No soy amante de la comida italiana.", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.noodles:
                    Toast.makeText(mContext, "Tampoco amante de los fideos.", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.wrap:
                    Toast.makeText(mContext, "¡Ohh shawarma!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public class Footer extends RecyclerView.ViewHolder {

        public Footer(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View mItemView;
        switch (viewType) {
            case HEADER:
                mItemView = mLayoutInflater.inflate(R.layout.custom_header, viewGroup, false);
                return new Header(mItemView);
            case NORMAL_WITHOUT_IMAGE:
                mItemView = mLayoutInflater.inflate(R.layout.custom_item_list_without_image, viewGroup, false);
                return new ItemWithoutImage(mItemView);
            case NORMAL_WITH_IMAGE:
                mItemView = mLayoutInflater.inflate(R.layout.custom_item_list_with_image, viewGroup, false);
                return new ItemWithImage(mItemView);
            case FOOTER:
                mItemView = mLayoutInflater.inflate(R.layout.custom_footer, viewGroup, false);
                return new Footer(mItemView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (getItemViewType(position)) {
            case HEADER:
                Header mHeader = (Header) viewHolder;
                mHeader.setTime(mItems.get(position).getTime());
                break;
            case NORMAL_WITHOUT_IMAGE:
                ItemWithoutImage mItemWithout = (ItemWithoutImage) viewHolder;
                mItemWithout.setIcon(mItems.get(position).getIcon());
                mItemWithout.setContent(mItems.get(position).getContent());
                mItemWithout.setTime(mItems.get(position).getTime());
                break;
            case NORMAL_WITH_IMAGE:
                ItemWithImage mItemWith = (ItemWithImage) viewHolder;
                mItemWith.setIcon(mItems.get(position).getIcon());
                mItemWith.setContent(mItems.get(position).getContent());
                mItemWith.setTime(mItems.get(position).getTime());
                mItemWith.setImage(mItems.get(position).getImage());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position).isHeader())
            return HEADER;
        else if (mItems.get(position).isWithoutImage())
            return NORMAL_WITHOUT_IMAGE;
        else if (mItems.get(position).isWithImage())
            return NORMAL_WITH_IMAGE;
        else
            return FOOTER;
    }
}
