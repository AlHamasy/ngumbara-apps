package org.himti_umt.ngumbaraapps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.himti_umt.ngumbaraapps.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArsipFragment extends Fragment {


    public ArsipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_arsip, container, false);
    }

}
