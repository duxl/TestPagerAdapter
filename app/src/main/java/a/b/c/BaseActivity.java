package a.b.c;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * TODO desc
 * create by duxl 2020/3/23
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResid());
        unbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayoutResid();

    @Override
    protected void onDestroy() {
        if(unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        super.onDestroy();
    }

    public void printLog(String log) {
        Log.i(getClass().getSimpleName(), log);
    }
}
