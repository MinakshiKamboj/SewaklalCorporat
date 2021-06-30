package com.example.sewaklalcorporate.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sewaklalcorporate.R;

public class BaseAppCompatActivity extends AppCompatActivity implements View.OnClickListener/* implements NetworkConnectivityObserver.NetworkConnectivityChangeListener */{
    private String activityName = "";
    private ViewGroup contentRootView;
    private LinearLayout noInternetView;
    private View activityRootView;
    ProgressDialog dialog;
    protected Toolbar toolbar;
//    protected CustomerApplication mMyApp;

//    private BroadcastReceiver logoutReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_activity_abstract_layout);

   //     mMyApp = (CustomerApplication) this.getApplicationContext();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            loadBundle(bundle);
        }
        contentRootView = findViewById(R.id.base_activity_content_layout);
        noInternetView = findViewById(R.id.lnrLyt_no_internet_view);
        initRetryConnection();
      /*  logoutReceiver = new LogoutReceiver(this);
        registerReceiver(logoutReceiver, new IntentFilter("logout_customer"));*/
        Intent intent = new Intent();
        intent.setAction("logout_customer");
        sendBroadcast(intent);
    }

    protected void loadBundle(Bundle bundle) {

    }


    protected void onResume() {
        super.onResume();
//        mMyApp.setCurrentActivity(this);

    }

    protected void onPause() {
    //    clearReferences();

       /* try {
            unregisterReceiver(logoutReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }*/
        super.onPause();
    }

    protected void onDestroy() {
     //   clearReferences();

       /* try {
            unregisterReceiver(logoutReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }*/

        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

//        registerReceiver(logoutReceiver, new IntentFilter("logout_customer"));

     /*   Intent intent = new Intent();
        intent.setAction("logout_customer");
        sendBroadcast(intent);*/
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

   /* private void clearReferences() {
        Activity currActivity = mMyApp.getCurrentActivity();
        if (this.equals(currActivity))
            mMyApp.setCurrentActivity(null);
    }*/

    public void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        TextView text = (TextView) view.findViewById(android.R.id.message);
        /*Here you can do anything with above textview like text.setTextColor(Color.parseColor("#000000"));*/
        text.setTextColor(ContextCompat.getColor(this, R.color.white));
        toast.show();
    }

    public void showToast(int stringId) {
        Toast.makeText(this, getString(stringId), Toast.LENGTH_LONG).show();
    }

    public void hideProgressBar() {
//        Log.i(TAG + "Dialog", Thread.currentThread().getName());
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void showProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
        } else {
            dialog = new ProgressDialog(this);
            dialog.setMessage("Please Wait...");
            dialog.show();
            dialog.setCancelable(false);
        }
    }

    public void startNextActivity(Class<? extends AppCompatActivity> activityClass) {
        Intent i = new Intent(this, activityClass);
        startActivity(i);
    }

    public void clearBackStackAndStartNextActivity(Class<? extends AppCompatActivity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void startNextActivityForResult(Class<? extends AppCompatActivity> activityClass, int REQUEST_CODE) {
        Intent i = new Intent(this, activityClass);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void startNextActivity(Bundle bundle,
                                  Class<? extends AppCompatActivity> activityClass) {

        Intent i = new Intent(this, activityClass);
        if (null != bundle) {
            i.putExtras(bundle);
        }
        startActivity(i);
    }

    public void startNextActivityForResult(Bundle bundle,
                                           Class<? extends AppCompatActivity> activityClass, int REQ_CODE) {

        Intent i = new Intent(this, activityClass);
        if (null != bundle) {
            i.putExtras(bundle);
        }
        startActivityForResult(i, REQ_CODE);
    }


    protected void setOnClickListener(int... viewIds) {
        for (int i : viewIds) {
            findViewById(i).setOnClickListener(this);
        }
    }

    protected String getEditText(int editTextId) {
        return ((EditText) findViewById(editTextId)).getText().toString()
                .trim();
    }

    public void setText(String text, int textViewId) {
        TextView view = (TextView) findViewById(textViewId);
        view.setText(text);
    }

    protected String getTextView(int textViewId) {
        return ((TextView) findViewById(textViewId)).getText().toString().trim();
    }


    public void setText(String text, int textViewId, View v) {
        TextView view = (TextView) v.findViewById(textViewId);
        view.setText(text);
    }

    public  void  addFragment(Fragment fragment, boolean b, int containerId){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }

        if (b){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.replace(containerId,fragment).commit();
    }



    @Override
    public void setContentView(int layoutResID) {
        if (shouldOverrideRootView()) { //Override default method and add child layout in content container layout.
            activityRootView = getLayoutInflater().inflate(layoutResID, contentRootView, true); //last param must be true to add it as child.
        } else {
            super.setContentView(layoutResID);
            activityRootView = contentRootView.getChildAt(0);
        }
    }

    @Override
    public void setContentView(View view) {
        if (shouldOverrideRootView()) {
            contentRootView.addView(view);
        } else {
            super.setContentView(view);
        }
        activityRootView = view;
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (shouldOverrideRootView()) {
            contentRootView.addView(view, params);
        } else {
            super.setContentView(view, params);
        }
        activityRootView = view;
    }

    /**
     * Init retry connection when <code>isRetryConnection()</code> returns true.
     */
    private void initRetryConnection() {
        if (isRetryConnection()) {
            Button connectionRetryBtn = findViewById(R.id.button_try_again);
            connectionRetryBtn.setVisibility(View.VISIBLE);
            connectionRetryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    CustomerApplication.getApplication().getNetworkConnectivityObserver().checkInternetConnectivityManually();
                }
            });
        }
    }

    /**
     * Retry button for connection will be visible when this method returns true, otherwise gone. Access this method and override accordingly.
     *
     * @return Default is true
     */
    protected boolean isRetryConnection() {
        return true;
    }

    protected boolean shouldOverrideRootView() {
        return true;
    }

    protected boolean needNetworkIndication() {
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        changeUiBasedOnConnectivity(isInternetAvailable());
//        CustomerApplication.getApplication().getNetworkConnectivityObserver().registerCallbackListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        CustomerApplication.getApplication().getNetworkConnectivityObserver().unregisterCallbackListener(this);
    }

    private void changeUiBasedOnConnectivity(boolean internetAvailable) {
//        noInternetView.setVisibility(internetAvailable ? View.GONE : View.VISIBLE);
//        contentRootView.setVisibility(internetAvailable ? View.VISIBLE : View.GONE);
    }

/*
    @Override
    public void onInternetConnectivityChanged(boolean internetAvailable) {
        changeUiBasedOnConnectivity(internetAvailable);
    }
*/

    /**
     * Callback for the activity which can be used to change activity specific behavior
     *
     * @param internetAvailable flag for internet connectivity
     */
    public void internetConnectivityChanged(boolean internetAvailable) {
        if (!internetAvailable) {
//            Toast.makeText(this, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Utility method to check internet connection in activity
     *
     * @return Internet connectivity flag
     */
    public final boolean isInternetAvailable() {
        return true /*CustomerApplication.getApplication().getNetworkConnectivityObserver().isInternetAvailable()*/;
    }

    private void hideSoftKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            //Find the currently focused view, so we can grab the correct window token from it.
            View view = getCurrentFocus();
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = new View(this);
            }
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception ignore) {
        }
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public void onClick(View v) {

    }

    public void initToolBar(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getHomeIcon());
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        toolbar.setSubtitleTextColor(ContextCompat.getColor(this, R.color.white));
    }

    public void initToolBar(String title,boolean backpress) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(backpress);
        getSupportActionBar().setHomeAsUpIndicator(getHomeIcon());
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        toolbar.setSubtitleTextColor(ContextCompat.getColor(this, R.color.white));
    }

    protected int getHomeIcon() {
        return 0;
    }

    protected void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(color);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onHomePressed();
                return true;
        }
        return false;
    }

    protected void onHomePressed() {
        onBackPressed();
    }


    //    private List<BaseRecyclerModel> baseRecyclerModelList = new ArrayList<>();
//    private BaseRecyclerAdapter baseRecyclerAdapter;
//    private RecyclerView recyclerView;
//
//    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//    baseRecyclerAdapter = new BaseRecyclerAdapter(baseRecyclerModelList, this);
//    final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(baseRecyclerAdapter);
//        baseRecyclerAdapter.setOnRecyclerClickListener(this);
//    int spacingInPixels = getResources().getDimensionPixelOffset(R.dimen.spacing);
//        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
//
//    private void setRecyclerAdapter(List<EarnigListModel> data) {
//        if (data.size() > 0) {
////                ivNoDataFound.setVisibility(View.GONE);
//            baseRecyclerModelList.clear();
//            baseRecyclerModelList.addAll(data);
//        }
////            else {
////                setVisibilityToView();
////            }
//
//        baseRecyclerAdapter.notifyDataSetChanged();

//    }
}
