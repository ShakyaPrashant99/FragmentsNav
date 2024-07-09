package com.example.midterm;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {

    EditText Email_ET, Pass_ET;
    Button btn;
    TextView Output1, Output2;

    SharedVewModel sharedViewModel;

    private static final String ARG_PARAM1 = "param1";
    private String receivedValue;

    public static FragmentOne newInstance(String param1) {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            receivedValue = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedVewModel.class);

        Email_ET = view.findViewById(R.id.emailEditText);
        Pass_ET = view.findViewById(R.id.passwordEditText);
        btn = view.findViewById(R.id.submitButton);
        Output1 = view.findViewById(R.id.data_1);
        Output2 = view.findViewById(R.id.data_2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typedValue = Email_ET.getText().toString();
                Output2.setText("Your data = " + typedValue);


            }
        });

        // Display the received value
        if (receivedValue != null) {
            Output1.setText(receivedValue);
            sharedViewModel.setText(receivedValue);

            FragmentTwo fragmentTwo = FragmentTwo.newInstance(receivedValue);
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentContainerViewTwo, fragmentTwo);
            transaction.addToBackStack(null);
            transaction.commit();
        }




        return view;
    }
}
