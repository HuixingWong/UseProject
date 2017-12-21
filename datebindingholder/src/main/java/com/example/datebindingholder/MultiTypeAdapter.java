package com.example.datebindingholder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dogoodsoft-app on 2017/12/21.
 */

public class MultiTypeAdapter extends RecyclerView.Adapter{

    private boolean showheader;
    private boolean showfooter;

    private final int ITEM_TYPE_HEADER = 0;
    private final int ITEM_TYPE_FOOTER = 1;
    private final int ITEM_TYPE_IMAGE = 2;
    private final int ITEM_TYPE_TEXT = 3;

    public interface Item{

        int getType();
    }
    private List<Item> items = new ArrayList<>();



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        int count = items.size();
        if (showheader)
            count ++;
        if (showfooter)
            count++;

        return count;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0 && showheader)
            return ITEM_TYPE_HEADER;
        if (position == getItemCount()-1 && showfooter)
            return ITEM_TYPE_FOOTER;

        return items.get(position).getType();

    }
}
