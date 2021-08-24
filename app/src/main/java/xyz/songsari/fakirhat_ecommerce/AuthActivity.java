package xyz.songsari.fakirhat_ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AuthActivity extends AppCompatActivity {

    Fragment signUpFragment = new SignUpFragment();
    Toolbar toolbar;
    ImageView expendImageView;
    ImageView userImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.base_layout, signUpFragment);
        ft.commit();
        toolbar = findViewById(R.id.toolbar);
        expendImageView = findViewById(R.id.expanded_bar);
        userImageView = findViewById(R.id.user_bar);
        userImageView.setVisibility(View.GONE);
        userImageView.setEnabled(false);
        expendImageView.setEnabled(false);
        expendImageView.setVisibility(View.GONE);
        appbarActions();

    }

       boolean doubleBackToExitPressedOnce = false;
    //    onBackPressed();

    @Override
    public void onBackPressed() {
        if(doubleBackToExitPressedOnce)
        {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(AuthActivity.this, "Click again to exit", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        },2000);

    }

    private void appbarActions() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(AuthActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}