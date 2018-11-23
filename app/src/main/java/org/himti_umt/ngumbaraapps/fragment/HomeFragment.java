package org.himti_umt.ngumbaraapps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import org.himti_umt.ngumbaraapps.R;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private  SliderLayout sliderLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        init();
        return view;
    }

    public void init() {
        HashMap<String,String> url_maps = new HashMap   <String, String>();
        url_maps.put("Tanjung Pasir", "https://firebasestorage.googleapis.com/v0/b/ngumbara-himtiumt.appspot.com/o/imageNgumbara%2FPantai-tanjung-Pasir.jpg?alt=media&token=235ddde2-d2ca-4fdf-b2c1-f7b4c9f1f249");
        url_maps.put("Taman Kota", "https://firebasestorage.googleapis.com/v0/b/ngumbara-himtiumt.appspot.com/o/imageNgumbara%2FTaman-Kota-1-BSD.jpg?alt=media&token=01eaa145-5596-4128-a5bf-2e46acd5610a");

        for(String name : url_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(getContext());

            // TODO : Inisialisasi Slider
            textSliderView.description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            // TODO : Menambahkan informasi
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Top);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
