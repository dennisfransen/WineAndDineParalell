package grupp3.iths.se.wineanddineparalell;

import android.icu.text.IDNA;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private SearchFragment searchFragment;
    private ProfileFragment profileFragment;
    private WishListFragment wishListFragment;
    private AddFragment addFragment;
    private AppInfoFragment appInfoFragment;


    private ImageButton infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Bound BottomNavigationView & FrameLayout to variable.
        BottomNavigationView mMainNav;
        FrameLayout mMainFrame;

        // Bound MainFrame and MainNav to MainActivity class.
        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);

        // Making an instance of every fragment.
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();
        wishListFragment = new WishListFragment();
        addFragment = new AddFragment();

        // TODO: Delete when LoginActivity sends you to SearchFragment after checked current user status.
        // Set so it will start the SearchFragment and not MainActivity when logged in.
        setFragment(searchFragment);

        // Setup all navigation buttons to redirect to chosen fragment.
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_search:
                        openFragmentWithAnimation(searchFragment);
                        return true;
                    case R.id.nav_profile:
                        openFragmentWithAnimation(profileFragment);
                        return true;
                    case R.id.nav_wishlist:
                        openFragmentWithAnimation(wishListFragment);
                        return true;
                    case R.id.nav_add:
                        openFragmentWithAnimation(addFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });

        appInfoFragment = new AppInfoFragment();

        infoBtn = findViewById(R.id.info_ib);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(appInfoFragment);
            }
        });


    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    public void openFragmentWithAnimation(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.main_frame, fragment, "BLANK_FRAGMENT").commit();
    }
}
