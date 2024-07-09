package com.example.midterm;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTwo extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    SharedVewModel sharedViewModel;

    TextView Output;
    private String receivedValue;

    public static FragmentTwo newInstance(String param1) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedVewModel.class);

        Output = view.findViewById(R.id.data3);

        // Observe the shared data and update the TextView
        sharedViewModel.getText().observe(getViewLifecycleOwner(), new androidx.lifecycle.Observer<String>() {
            @Override
            public void onChanged(String s) {
                Output.setText("data is = " + s);
            }
        });

        return view;
    }
}
