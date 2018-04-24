package com.example.inhamap.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inhamap.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<DoorData> mDataset; // 넘겨받는 데이터값.

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    // 각각의 데이터 아이템에 대한 뷰에게 레퍼런스를 제공한다.
    // 복잡한 데이터 아이템은 각 아이템당 하나 이상의 뷰가 필요할것이다.
    // 그리고 너는 뷰 홀더에서 데이터 아이템에 대한 모든 뷰를 접근하는걸 제공한다.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView1, mImageView2, mImageView3;

        public ViewHolder(View v) { // constructor
            super(v);
            mTextView = (TextView)v.findViewById(R.id.textView3);
            mImageView1 = (ImageView)v.findViewById(R.id.imageView3_1);
            mImageView2 = (ImageView)v.findViewById(R.id.imageView3_2);
            mImageView3 = (ImageView)v.findViewById(R.id.imageView3_3);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    // 데이터셋의 종류에 알맞은 생성자
    public MyAdapter(ArrayList<DoorData> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_door, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).doorName);
        holder.mImageView1.setImageResource(mDataset.get(position).elevator);
        holder.mImageView2.setImageResource(mDataset.get(position).wheelchair);
        holder.mImageView3.setImageResource(mDataset.get(position).stair);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
