package a.b.c;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * TODO desc
 * create by duxl 2020/6/19
 */
public class MainActivity extends BaseActivity {

    public static List<String> list = new ArrayList<>();
    static int count=0;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    MyPagerAdapter mPagerAdapter;

    @Override
    protected int getLayoutResid() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager.setAdapter(mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(10);
        onRefresh(null);
    }

    public void onGeText(View v) {
        String text = mPagerAdapter.getItem(0).getText();
        Log.i("duxl", "text.length=" + text.length());
    }

    public void onRefresh(View v) {
        Log.i("duxl", "--------------------- onRefresh -----------------------");
        list.clear();
        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf(++count));
        }
        mPagerAdapter.notifyDataSetChanged();
    }
}
