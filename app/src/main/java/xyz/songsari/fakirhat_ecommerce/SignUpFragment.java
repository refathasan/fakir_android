package xyz.songsari.fakirhat_ecommerce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment  implements View.OnClickListener {
    Button signUpWithGoogle;
    Button signUpWithEmail;
    Button signUpWithMobile;
    TextView loginTextView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        signUpWithGoogle = rootView.findViewById(R.id.sign_up_google);
        signUpWithEmail = rootView.findViewById(R.id.sign_up_email);
        signUpWithMobile = rootView.findViewById(R.id.sign_up_phone);
        loginTextView = rootView.findViewById(R.id.go_to_login);
        
        signUpWithGoogle.setOnClickListener(this);

        signUpWithEmail.setOnClickListener(this);
        signUpWithMobile.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
        return  rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.sign_up_google:
                Toast.makeText(getContext(), " Google Button Clicked",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_up_email:
                Toast.makeText(getContext(), " Email Button Clicked",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_up_phone:
                Toast.makeText(getContext(), " Phone Button Clicked",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.go_to_login:
                Toast.makeText(getContext(), " Go to Login Clicked",
                        Toast.LENGTH_SHORT).show();
                break;

        }

    }
}