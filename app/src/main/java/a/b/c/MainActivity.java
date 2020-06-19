package a.b.c;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
    static int count = 0;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    MyPagerAdapter mAdapter;

    @Override
    protected int getLayoutResid() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager.setAdapter(mAdapter = new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(10);
        onRefresh(null);

        AlertDialog dialog = new AlertDialog
                .Builder(this)
                .setPositiveButton("确定", null)
                .create();
        dialog.setMessage("先点上面的刷新，再点下面的get按钮，居然会报错");
        dialog.show();

        // TODO: 报错的原因在这篇文章中可能会找到
        // TODO: https://www.jianshu.com/p/4840994e3c43
    }

    public void onGeText(View v) {
        String text = mAdapter.getItem(0).getText();
        Log.i("duxl", "text.length=" + text.length());
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

    }

    public void onRefresh(View v) {
        Log.i("duxl", "--------------------- onRefresh -----------------------");
        list.clear();
        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf(++count));
        }
        mAdapter.notifyDataSetChanged();
    }
}
