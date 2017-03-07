package cardview.demo.carl.co.cardviewdemo;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        initView();
    }

    private void initView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        initAdapter();
    }

    private void initAdapter(){
        List<CardViewItem> list = new ArrayList<>();
        list.add(new CardViewItem("aaa", ResourcesCompat.getDrawable(getResources(),R.mipmap.ic_launcher,null)));
        list.add(new CardViewItem("bbb", ResourcesCompat.getDrawable(getResources(),R.mipmap.ic_launcher,null)));
        list.add(new CardViewItem("ccc", ResourcesCompat.getDrawable(getResources(),R.mipmap.ic_launcher,null)));
        list.add(new CardViewItem("ddd", ResourcesCompat.getDrawable(getResources(),R.mipmap.ic_launcher,null)));
        list.add(new CardViewItem("eee", ResourcesCompat.getDrawable(getResources(),R.mipmap.ic_launcher,null)));
        list.add(new CardViewItem("fff", ResourcesCompat.getDrawable(getResources(),R.mipmap.ic_launcher,null)));
        list.add(new CardViewItem("ggg", ResourcesCompat.getDrawable(getResources(),R.mipmap.ic_launcher,null)));
        mRecyclerAdapter = new MyRecyclerAdapter(this, list);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setOnClickListener(new MyRecyclerAdapter.OnClickListener(){
            @Override
            public void onDleteViewClick(int position) {
                mRecyclerAdapter.itemDismiss(position);
            }
        });
    }
}
