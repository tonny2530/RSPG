package th.ac.kmitl.rspg.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.fragment.CreatureFragment;
import th.ac.kmitl.rspg.fragment.NewsFragementGeneral;
import th.ac.kmitl.rspg.fragment.NewsFragmentProject;
import th.ac.kmitl.rspg.fragment.PlantFragment;
import th.ac.kmitl.rspg.fragment.HomeFragment;
import th.ac.kmitl.rspg.fragment.NewsFragment;
import th.ac.kmitl.rspg.fragment.ProjectFragment;
import th.ac.kmitl.rspg.util.CircleTransform;
import th.ac.kmitl.rspg.response.SelectUserResponse;

public class HomeActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile, imageView;
    private TextView txtName, txtWebsite, txtTitleName;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    // index to identify current nav menu item
    public static int navItemIndex = 0;
    public static int navIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_NEWS = "news";
    private static final String TAG_HABITAT = "habitat";
    private static final String TAG_MOVIES = "movies";
    public static String CURRENT_TAG = TAG_HOME;
    SelectUserResponse userInfo;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    private SharedPreferences prefs;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userInfo = (SelectUserResponse) getIntent().getSerializableExtra("userInfo");

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefsEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(userInfo);
        prefsEditor.putString("UserInfo", json);
        prefsEditor.commit();

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
//        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);


        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        fab.setOnClickListener(new View.OnClickListener() {
            Intent i = null;
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Action "+navItemIndex, Toast.LENGTH_LONG).show();
                switch (navItemIndex){
                    case 2 :
                        i = new Intent(getApplicationContext(),AddPlantActivity.class);
                        startActivity(i);
                        break;
                    case 3 :
                        i = new Intent(getApplicationContext(),AddCreatureActivity.class);
                        startActivity(i);
                        break;
                    default:
                        Snackbar.make(view, "Replace with your own action : " +navItemIndex, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                }
            }
        });


        // load nav menu header data
        loadNavHeader(userInfo);

        // initializing navigation menu
        setUpNavigationView();

//        if (savedInstanceState == null) {
//            navItemIndex = 0;
//            CURRENT_TAG = TAG_HOME;
//            loadHomeFragment();
//        }
        navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
    }



    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader(SelectUserResponse u) {
        // name, website
        txtName.setText(u.getThname());
        txtName.setTextColor(Color.rgb(0,0,0));
        txtWebsite.setText(u.getEmail());
        txtWebsite.setTextColor(Color.rgb(0,0,0));

        // loading header background image
//        Glide.with(this).load(urlNavHeaderBg)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imgNavHeaderBg);

        // Loading profile image
        if(u.getPicture() == null || u.getPicture().equalsIgnoreCase("")){
            Glide.with(this).load(R.drawable.man)
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgProfile);
        }else{
            Glide.with(this).load(u.getPicture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgProfile);
        }


    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
//


        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
//        txtTitleName = (TextView)this.findViewById(R.id.txt_app_name_bar);
        switch (navItemIndex) {
            case 0:
                // home
//                HomeFragment homeFragment = new HomeFragment();
//                return homeFragment;
                Log.i("RSPG", "Home Fragment Selected from Home");
                NewsFragementGeneral newsFragments = new NewsFragementGeneral();
                return newsFragments;
            case 1 :
                Log.i("RSPG", "News Fragment Selected from News");
                NewsFragmentProject newsFragment = new NewsFragmentProject();
                return newsFragment;
            case 2:
                Log.i("RSPG", "Plant Fragment Selected from Plant");
                PlantFragment habitatFragment = new PlantFragment();
                return habitatFragment;

            case 3:
                Log.i("RSPG", "Creature Fragment Selected from Plant");
                CreatureFragment creatureFragment = new CreatureFragment();
                return creatureFragment;
            default:
                return new HomeFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar bar = getSupportActionBar();
        TextView tv = (TextView) findViewById(R.id.toolbar_title);
        tv.setText(activityTitles[navItemIndex]);
        tv.setTextColor(Color.rgb(146, 39, 143));
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        navItemIndex = 0;
                        navIndex = 1;
                        CURRENT_TAG = TAG_NEWS;
                        break;
                    case R.id.nav_news:
                        navItemIndex = 1;
                        navIndex = 1;
                        CURRENT_TAG = TAG_NEWS;
                        break;
                    case R.id.nav_habitat:
                        if("1".equalsIgnoreCase(String.valueOf(userInfo.getProjectId()))){
                            navItemIndex = 2;
                        }else if("2".equalsIgnoreCase(String.valueOf(userInfo.getProjectId()))){
                            navItemIndex = 3;
                        }
                        navIndex = 2;
                        CURRENT_TAG = TAG_HABITAT;
                        break;
                    default:
                        navItemIndex = 0;
                }
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem mSearchView  = menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView)mSearchView .getActionView(); // findViewById(R.id.search_view);
        searchView.setQueryHint("ค้นหา");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent i = new Intent(getApplicationContext(),SearchResultActivity.class);
                i.putExtra("keyword",query);
                startActivity(i);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setMessage("คุณต้องการออกจากระบบใช่หรือไม่?");
            builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    userInfo = null;

                    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor prefsEditor = prefs.edit();
                    prefsEditor.remove("UserInfo");
                    prefsEditor.commit();
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }
            });
            builder.setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //dialog.dismiss();
                }
            });
            builder.show();

            return true;

        }

        return false;
    }



    private void toggleFab() {
        if (navItemIndex == 2 || navItemIndex == 3)
            fab.show();
        else
            fab.hide();
    }

}


