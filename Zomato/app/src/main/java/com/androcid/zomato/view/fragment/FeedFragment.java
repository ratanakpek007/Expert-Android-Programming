package com.androcid.zomato.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androcid.zomato.R;
import com.androcid.zomato.model.RestaurantItem;
import com.androcid.zomato.view.adapter.FeedItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Androcid on 30-12-2016.
 */

public class FeedFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    List<RestaurantItem> allList;
    FeedItemAdapter allAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.context = getActivity();

        allList = new ArrayList<>();
        allAdapter = new FeedItemAdapter(context, allList);
        allAdapter.setClickListener(new FeedItemAdapter.ClickListener() {
            @Override
            public void onItemClickListener(View v, int pos) {
                gotoDetailsActivity();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(allAdapter);

        setList();
    }

    private void setList() {

        for (int i = 0; i < 8; i++) {

           /* PlaceItem item = new PlaceItem((long) i, "", "", "Name " + i, "Address " + i, "Description " + i, "1.2 km", AppUtils.getPlaceType(i), i);
            allList.add(item);*/

        }
        allAdapter.refresh(allList);

    }


    private void gotoDetailsActivity() {

        /*CollectionItem item = allList.get(pos);
        startActivity(CollectionDetailActivity.getCallIntent(context));*/

    }
}
