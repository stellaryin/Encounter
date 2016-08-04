package encounter.wilson.com.encounter.UI.Activity;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import encounter.wilson.com.encounter.DTO.Pictrue;
import encounter.wilson.com.encounter.R;
import encounter.wilson.com.encounter.UI.fragment.LeftFragment;
import encounter.wilson.com.encounter.adapter.PicWallAdapter;

/**
 * Created by xiaoqiang on 16/7/31.
 */
public class MainActivity extends BaseActivity {
    //瀑布流
    private PullLoadMoreRecyclerView pullLoadMoreRecyclerView;
    private PicWallAdapter adapter;

    //侧滑
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle drawerbar;

    //侧滑界面
    private LeftFragment menu;
    private LinearLayout leftView;


    //测试数据
    ArrayList<Pictrue> datas;
    private View showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        getdata();
        init();
    }

    private void init() {
        leftView = (LinearLayout) findViewById(R.id.main_left_view);

        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.main_content_list);
        pullLoadMoreRecyclerView.setRefreshing(false);
        pullLoadMoreRecyclerView.setPullRefreshEnable(false);
        pullLoadMoreRecyclerView.setPushRefreshEnable(true);
//        pullLoadMoreRecyclerView.setFooterViewText("loading");
//        pullLoadMoreRecyclerView.setFooterViewTextColor(R.color.white);
//        pullLoadMoreRecyclerView.setFooterViewBackgroundColor(R.color.bg_black);
        pullLoadMoreRecyclerView.setStaggeredGridLayout(2);

        adapter = new PicWallAdapter(this, datas);
        pullLoadMoreRecyclerView.setAdapter(adapter);

        mdrawerLayout = (DrawerLayout) findViewById(R.id.main_DrawerLayout);


        mdrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void loadFragment() {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.main_menu_left, menu)
//                .commit();
    }


    void getdata() {
        List<Integer> piclist = new ArrayList<>();
        piclist.add(R.mipmap.p1);
        piclist.add(R.mipmap.p2);
        piclist.add(R.mipmap.p3);
        piclist.add(R.mipmap.p4);
        piclist.add(R.mipmap.p5);
        piclist.add(R.mipmap.p1);
        piclist.add(R.mipmap.p2);
        piclist.add(R.mipmap.p3);
        piclist.add(R.mipmap.p4);
        piclist.add(R.mipmap.p5);
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Pictrue p = new Pictrue();
            p.setTestpic(piclist.get(i));
            datas.add(p);
        }
        ;
    }


}
