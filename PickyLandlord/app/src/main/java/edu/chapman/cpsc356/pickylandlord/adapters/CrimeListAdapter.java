package edu.chapman.cpsc356.pickylandlord.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc356.pickylandlord.CrimeCollection;
import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;


public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder>
{
    private final String LOGTAG = "CrimeListAdapter";

    @Override
    public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.d(LOGTAG, "onCreateViewHolder()");

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false); // TODO: replace w/ custom

        return new CrimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CrimeViewHolder holder, int position)
    {
        Log.d(LOGTAG, "onBindViewHolder(" + position + ")");
        // Get crime at specified position
        CrimeModel crime = CrimeCollection.GetInstance().getCrimes().get(position);

        // Setup the ViewHolder
        holder.setup(crime);
    }

    @Override
    public int getItemCount()
    {
        Log.d(LOGTAG, "getItemCount()");
        return CrimeCollection.GetInstance().getCrimes().size();
    }

    class CrimeViewHolder extends RecyclerView.ViewHolder
    {
        private TextView titleTextView;

        public CrimeViewHolder(View itemView)
        {
            super(itemView);

            this.titleTextView = (TextView) itemView;
        }

        public void setup(CrimeModel crime)
        {
            this.titleTextView.setText(crime.getTitle());
        }
    }
}
