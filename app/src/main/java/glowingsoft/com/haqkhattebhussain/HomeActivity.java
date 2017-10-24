package glowingsoft.com.haqkhattebhussain;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import fragments.UpdateFragments;
import fragments.VideosFragments;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Button news_updates_main,videos_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*THIS IS DRAWER LAYOUT FUNCTION*/
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /*THIS IS NAVIGATION VIEW FUNCTION*/
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
        View headerLayout = navigationView.inflateHeaderView(R.layout.drawer_activity   );
        ImageView backto_home = headerLayout.findViewById(R.id.backto_home);
        backto_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(GravityCompat.START)){
                    onBackPressed();
                }else {
                    drawer.isDrawerOpen(GravityCompat.START);
                }
            }
        });
        LinearLayout newsUpdatesll = headerLayout.findViewById(R.id.action_news_updates);
        newsUpdatesll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "News Updates", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayout actionVideosll = headerLayout.findViewById(R.id.action_videos);
        actionVideosll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Action Videos", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayout notificatonsll = headerLayout.findViewById(R.id.action_notification);
        notificatonsll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoNotificationActivity = new Intent(HomeActivity.this,NotificationActivity.class);
                startActivity(gotoNotificationActivity);
            }
        });
        LinearLayout aboutll = headerLayout.findViewById(R.id.action_about);
        aboutll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "About", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayout contactUsll = headerLayout.findViewById(R.id.action_contact_us);
        contactUsll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();
                Intent gotoContactUs = new Intent(HomeActivity.this,ContactUsActivity.class);
                startActivity(gotoContactUs);
            }
        });

        /*this is news update funcation run when HomeActivity load*/
        loadFragment(new UpdateFragments());
        /* THIS IS NEWS UPDATES, VIDEOS, FRAGMENTS AND ON CLICK FUNCATIONS*/
        news_updates_main = (Button) findViewById(R.id.news_updates_main);
        videos_main = (Button) findViewById(R.id.videos_main);
        news_updates_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loadFragment(new UpdateFragments())){

                }else {
                    news_updates_main.setBackgroundResource(R.drawable.purple_bg_left);
                    videos_main.setBackgroundResource(R.drawable.g_right);
                }
            }
        });
        videos_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loadFragment(new VideosFragments())){

                }else {
                    videos_main.setBackgroundResource(R.drawable.purple_bg_right);
                    news_updates_main.setBackgroundResource(R.drawable.fb_left);
                }
            }
        });
    }

    /*THIS LOAD FRAGMENT FUNCTION USE IN UPPER CODE*/
    private boolean loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
        return false;
    }

    /*ON BACK PRESSED*/
    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notification_bell_button) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
/*

        if (id == R.id.action_news_update) {
            // Handle the camera action
            Toast.makeText(this, "News Updates", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_videos) {
            Toast.makeText(this, "Videos", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_notification) {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_contact_us) {
            Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();
        }
*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
