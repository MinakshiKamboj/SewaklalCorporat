package com.example.sewaklalcorporate.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sewaklalcorporate.Fragments.GetHelpFragment;
import com.example.sewaklalcorporate.Fragments.HomeFragment;
import com.example.sewaklalcorporate.Fragments.MyBookingFragment;
import com.example.sewaklalcorporate.R;
import com.example.sewaklalcorporate.Widgets.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainHomeActivity extends BaseAppCompatActivity {
    NavigationView navigationView;
    FrameLayout frame;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    ProgressDialog progressDialog;
    private static final String TAG = "MainHomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        frame = findViewById(R.id.frame);
        progressDialog=new ProgressDialog(MainHomeActivity.this);
        progressDialog.setMessage("Please wait...");
        navigationView = findViewById(R.id.naviganation);

        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.open, // nav drawer open - description for accessibility
                R.string.close // nav drawer close - description for accessibility
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        ImageView hamMenu = findViewById(R.id.ham_menu);
        hamMenu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                // If the navigation drawer is not open then open it, if its already open then close it.
                if(!drawerLayout.isDrawerOpen(Gravity.START)) drawerLayout.openDrawer(Gravity.START);
                else drawerLayout.closeDrawer(Gravity.END);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_dash_board:
                        Intent board = new Intent(MainHomeActivity.this, MainHomeActivity.class);
                        startActivity(board);
                        finish();
                        break;
                        case R.id.nav_profile_detail:
                        Intent prifile = new Intent(MainHomeActivity.this, ProfileDetailActivity.class);
                        startActivity(prifile);
                        finish();
                        break;

                    case R.id.nav_brances:
                        Intent brances = new Intent(MainHomeActivity.this, BranchManagementActivity.class);
                        startActivity(brances);
                        finish();
                        break;

                    case R.id.nav_request:
                        Intent request = new Intent(MainHomeActivity.this, RequestserviceAddonActivity.class);
                        startActivity(request);
                        finish();
                        break;

                    case R.id.nav_favorite:
                        Intent favorite = new Intent(MainHomeActivity.this, FavouriteSubcategoryActivity.class);
                        startActivity(favorite);
                        finish();
                        break;

                    case R.id.nav_my_account:
                        Intent account = new Intent(MainHomeActivity.this, MyProfileActivity.class);
                        startActivity(account);
                        finish();
                        break;

                        case R.id.nav_book_now:
                        Intent bookNow = new Intent(MainHomeActivity.this, BookNowActivity.class);
                        startActivity(bookNow);
                        finish();
                        break;

                    case R.id.nav_my_booking:
                        Intent myBooking = new Intent(MainHomeActivity.this, BookingDetailsActivity.class);
                        startActivity(myBooking);
                        finish();
                        break;

                    case R.id.nav_logout:
        //              MyPreferences.getActiveInstance(MainHomeActivity.this).setIsLoggedIn(false);
                        Intent log = new Intent(MainHomeActivity.this, LoginActivity.class);
                        startActivity(log);
                        finish();
                        break;
                }
                return true;
            }
        });
        MainHomeActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
        setupNavigationView();

    }
    private void setupNavigationView() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        if (bottomNavigationView != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });
        }
    }

    /**
     * Perform action when any item is selected.
     *
     * @param item Item that is selected.
     */
    protected void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.navigation_home:
                pushFragment(new HomeFragment());
                break;
            case R.id.navigation_my_booking:
                pushFragment(new MyBookingFragment());
                break;
            case R.id.navigation_get_help:
                pushFragment(new GetHelpFragment());
                break;
        }
    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.frame, fragment);
                ft.commit();
            }
        }
    }
}
