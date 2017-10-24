package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import glowingsoft.com.haqkhattebhussain.R;

/**
 * Created by Arslan Shabbir on 10/23/2017.
 */

public class VideosFragments extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.videos_fragment,container,false);


        return view;
    }

}
