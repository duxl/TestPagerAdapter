package a.b.c;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO desc
 * create by duxl 2020/6/19
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<MyFragment> mFragments = new ArrayList<>();

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @NonNull
    @Override
    public MyFragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public void notifyDataSetChanged() {
        initData();
        super.notifyDataSetChanged();
    }

    private void initData() {
        mFragments.clear();

        if (!MainActivity.list.isEmpty()) {
            for (int i = 0; i < MainActivity.list.size(); i++) {
                mFragments.add(MyFragment.newInstance(MainActivity.list.get(i)));
            }
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
