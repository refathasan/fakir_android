package xyz.songsari.fakirhat_ecommerce;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class SignUpFragment extends Fragment implements View.OnClickListener {
    Button signUpWithGoogle;
    Button signUpWithEmail;
    Button signUpWithMobile;
    TextView loginTextView;
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    FirebaseUser currentUser;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        signUpWithGoogle = rootView.findViewById(R.id.sign_up_google);
        signUpWithEmail = rootView.findViewById(R.id.sign_up_email);
        signUpWithMobile = rootView.findViewById(R.id.sign_up_phone);
        loginTextView = rootView.findViewById(R.id.go_to_login);

        signUpWithGoogle.setOnClickListener(this);

        signUpWithEmail.setOnClickListener(this);
        signUpWithMobile.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        currentUser = firebaseAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up_google:
                Toast.makeText(getContext(), " Google Button Clicked",
                        Toast.LENGTH_SHORT).show();

                googleSignUp();
                progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Google Sign In...");
                progressDialog.show();
                Intent intent = googleSignInClient.getSignInIntent();
                startActivityForResult(intent, Utils.GOOGLE_REQUEST_CODE);
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

    private void googleSignUp() {
        googleSignInOptions = new GoogleSignInOptions.
                Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("519100241394-r9r8l90rh6l839s5gihvrcrt7so7dmmi.apps.googleusercontent.com")
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(getContext(), googleSignInOptions);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Utils.GOOGLE_REQUEST_CODE) {
            Task<GoogleSignInAccount> googleSignInAccountTask =
                    GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount googleSignInAccount =
                        googleSignInAccountTask.getResult(ApiException.class);
                firebaseAuthWithGoogle(googleSignInAccount.getIdToken());
            } catch (ApiException e) {
                Log.i("Auth-->", e.getMessage());
                progressDialog.dismiss();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener((Activity) getContext(),
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            updateUI(firebaseUser);
                        } else {
                            progressDialog.dismiss();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            signUpWithGoogle.setVisibility(View.GONE);

        } else {
            signUpWithGoogle.setVisibility(View.VISIBLE);

        }

    }
}