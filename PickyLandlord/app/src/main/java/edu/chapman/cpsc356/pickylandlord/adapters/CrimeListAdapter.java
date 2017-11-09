package edu.chapman.cpsc356.pickylandlord.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import edu.chapman.cpsc356.pickylandlord.CrimeCollection;
import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.activities.CrimeActivity;
import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;


public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder>
{
    private final String LOGTAG = "CrimeListAdapter";

    @Override
    public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.d(LOGTAG, "onCreateViewHolder()");

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_crime, parent, false);

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

    class CrimeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private CrimeModel crime;

        private TextView titleTextView;
        private CheckBox solvedCheckbox;

        public CrimeViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(this);

            this.titleTextView = itemView.findViewById(R.id.tv_title);
            this.solvedCheckbox = itemView.findViewById(R.id.cb_solved);
        }

        public void setup(CrimeModel crime)
        {
            this.crime = crime;

            this.titleTextView.setText(crime.getTitle());
            this.solvedCheckbox.setChecked(crime.isSolved());
        }

        @Override
        public void onClick(View view)
        {
            Intent crimeIntent = new Intent(view.getContext(), CrimeActivity.class);
            crimeIntent.putExtra(CrimeActivity.EXTRA_CRIME_ID, this.crime.getId());

            view.getContext().startActivity(crimeIntent);
        }
    }
}
