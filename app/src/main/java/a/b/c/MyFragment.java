package a.b.c;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * TODO desc
 * create by duxl 2020/6/19
 */
public class MyFragment extends Fragment {

    private String mText;

    public String getText() {
        return mText;
    }

    public static MyFragment newInstance(String text) {
        MyFragment instance = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        instance.setArguments(bundle);
        return instance;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mText = getArguments().getString("text");

        View v = inflater.inflate(R.layout.fragment_my, null);
        TextView tv = v.findViewById(R.id.tv);
        String text = "Hash=" + hashCode() + "  Text=" + mText;
        Log.i("duxl", text);
        tv.setText(text);
        return v;
    }
}
