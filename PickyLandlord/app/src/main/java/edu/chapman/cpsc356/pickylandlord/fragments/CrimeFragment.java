package edu.chapman.cpsc356.pickylandlord.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import org.joda.time.format.DateTimeFormat;

import edu.chapman.cpsc356.pickylandlord.CrimeCollection;
import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.activities.CrimeActivity;
import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;


public class CrimeFragment extends Fragment
{
    private final String LOGTAG = "CrimeFragment";
    public final static String ARG_CRIME_ID = "crime_id";

    private EditText titleEditText;
    private CheckBox solvedCheckbox;

    private CrimeModel crime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String crimeId = getArguments().getString(CrimeFragment.ARG_CRIME_ID);
        this.crime = CrimeCollection.GetInstance().getCrime(crimeId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        this.titleEditText = v.findViewById(R.id.et_title);
        this.titleEditText.setText(this.crime.getTitle());

        this.solvedCheckbox = v.findViewById(R.id.cb_solved);
        this.solvedCheckbox.setChecked(this.crime.isSolved());

        this.titleEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                Log.d(LOGTAG, "Text changed! to " + editable.toString());
                crime.setTitle(editable.toString());
            }
        });

        this.solvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                Log.d(LOGTAG, "Solved changed to " + isChecked);
                crime.setSolved(isChecked);
            }
        });

        Button dateButton = v.findViewById(R.id.btn_created_date);
        dateButton.setText(this.crime.getDate().toString(DateTimeFormat.longDateTime()));

        return v;
    }
}
