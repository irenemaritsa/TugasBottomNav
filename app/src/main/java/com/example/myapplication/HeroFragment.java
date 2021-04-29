package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HeroFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Hero> heroes = new ArrayList<>();


    public static HeroFragment newInstance() {
        HeroFragment fragment = new HeroFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_hero_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_hero);
        recyclerView.setHasFixedSize(true);

        heroes.addAll(HeroDataSource.getListData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListHeroAdapter adapter = new ListHeroAdapter(heroes);
        adapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                Intent intent = new Intent(getActivity(), NewActivity.class);
                intent.putExtra(NewActivity.name, data.getName());
                intent.putExtra(NewActivity.detail, data.getDetail());
                intent.putExtra(NewActivity.photo, data.getPhoto());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        return v;
    }
}
