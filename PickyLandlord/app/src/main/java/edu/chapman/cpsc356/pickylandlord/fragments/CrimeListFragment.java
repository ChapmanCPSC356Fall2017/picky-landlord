package edu.chapman.cpsc356.pickylandlord.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.adapters.CrimeListAdapter;


public class CrimeListFragment extends Fragment
{
    private CrimeListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_crime_list, container, false);

        RecyclerView crimesListView = v.findViewById(R.id.rv_crimes);

        this.adapter = new CrimeListAdapter();
        crimesListView.setAdapter(adapter);

        // This is lame - don't study this, just do it
        crimesListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        this.adapter.notifyDataSetChanged();
    }
}
