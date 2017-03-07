package cardview.demo.carl.co.cardviewdemo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Host-0 on 2017/3/7.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private List<CardViewItem> mList;
    private Context mContext;
    private OnClickListener mOnClickListener;
    public MyRecyclerAdapter(Context context, List<CardViewItem> list){
        mList = list;
        mContext = context;
    }

    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRecyclerAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItemTextView.setText(mList.get(position).text);
        holder.mItemImageView.setImageDrawable(mList.get(position).imag);
        holder.mDeleteLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mOnClickListener.onDleteViewClick(holder.getLayoutPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mItem;
        public TextView mItemTextView;
        public ImageView mItemImageView;
        public RelativeLayout mDeleteLayout;
        public ViewHolder(View v) {
            super(v);
            mItem = (CardView)v.findViewById(R.id.main_cardview_item);
            mItemTextView = (TextView)v.findViewById(R.id.item_textview);
            mItemImageView = (ImageView)v.findViewById(R.id.item_imageview);
            mDeleteLayout = (RelativeLayout)v.findViewById(R.id.delete_rl);
        }
    }

    public void itemDismiss(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnClickListener{
        void onDleteViewClick(int position);
    }

    public void setOnClickListener(MyRecyclerAdapter.OnClickListener onClickListener){
        mOnClickListener = onClickListener;
    }
}
