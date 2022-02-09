package com.example.kaodimservices;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        recyclerView = findViewById(R.id.recycle_view);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add fragment here
        viewPagerAdapter.AddFragment(new FragmentHome(), "Home");
        viewPagerAdapter.AddFragment(new FragmentServices(), "Service");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.homeicon);
        tabLayout.getTabAt(1).setIcon(R.drawable.serviceicon);

        //Remove shadow from the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl()
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<MainData>> call = api.getPost();

        call.enqueue(new Callback<List<MainData>>() {
            @Override
            public void onResponse(Call<List<MainData>> call, Response<List<MainData>> response) {

                if(response.isSuccessful()){
                    List<MainData> posts = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<MainData>> call, Throwable t) {

            }
        });



    }
}