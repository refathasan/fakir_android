package xyz.songsari.fakirhat_ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AuthActivity extends AppCompatActivity {

    Fragment signUpFragment  = new SignUpFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction ft =fragmentManager.beginTransaction();
        ft.add(R.id.base_layout, signUpFragment);
        ft.commit();
    }
    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'
        this.startActivity(new Intent(AuthActivity.this,MainActivity.class));

        return;
    }
}