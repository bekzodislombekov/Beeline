package com.android.example.beeline;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.example.beeline.adapters.AppAdapter;
import com.android.example.beeline.models.App;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ConstraintLayout currentTarif;
    LinearLayout numberDialogLayout;
    TextView shareTxt;
    TextView stepTxt;
    RecyclerView rv;
    AppAdapter adapter;
    List<App> appList;
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);
        findUI();
        shareTxt.setSelected(true);
        stepTxt.setSelected(true);

        currentTarif.setOnClickListener(v -> Navigation.findNavController(root).navigate(R.id.currentTarifFragment));

        numberDialogLayout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_number, null, false);
            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            Window window = dialog.getWindow();
            WindowManager.LayoutParams wlp = window.getAttributes();

            wlp.gravity = Gravity.TOP;
            wlp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(wlp);

            dialog.show();
        });

        loadData();
        adapter = new AppAdapter(appList);
        rv.setAdapter(adapter);
        return root;
    }

    private void findUI() {
        shareTxt = root.findViewById(R.id.shareText);
        stepTxt = root.findViewById(R.id.stepText);
        rv = root.findViewById(R.id.rv_apps);
        currentTarif = root.findViewById(R.id.currentTarifLayout);
        numberDialogLayout = root.findViewById(R.id.numberDialogLayout);

    }

    private void loadData() {
        appList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("https://kinobor.com/uploads/files/bobil.jpg");
        list1.add("https://static10.tgstat.ru/channels/_0/71/711888f1975b7285386f9aa2f968990c.jpg");
        list1.add("https://images-na.ssl-images-amazon.com/images/I/51zUbui%2BgbL.jpg");
        list1.add("https://flxt.tmsimg.com/assets/p35189_p_v8_ah.jpg");
        list1.add("https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg");

        List<String> list2 = new ArrayList<>();
        list2.add("http://images.sk-static.com/images/media/img/col6/20200512-114040-029071.jpg");
        list2.add("https://m.media-amazon.com/images/I/718iJ8BoYYL._SS500_.jpg");
        list2.add("https://i1.sndcdn.com/artworks-0XzLXeODj5yuMZTF-oOUPaw-t500x500.jpg");
        list2.add("https://i.guim.co.uk/img/media/73ec4373ed4f59ef1a1312176558752a5793529d/0_336_6552_3932/master/6552.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=b3a7881444203651628e94863df6c9de");
        list2.add("https://images.shazam.com/coverart/t485984834-b1476253401_s400.jpg");

        List<String> list3 = new ArrayList<>();
        list3.add("https://media.gq.com/photos/56e853ef161e63486d04d6d8/master/w_1600%2Cc_limit/david-beckham-gq-0416-cover-01.jpg");
        list3.add("https://images-na.ssl-images-amazon.com/images/I/81gZFs45wFL.jpg");
        list3.add("https://www.magazinecafestore.com/Upload/Product/1066/vogue-spain-magazine-september-2020.jpg?rnd=93020206:13:37AM");
        list3.add("https://gl-images.condecdn.net/image/PkVM4yE8z44/crop/405/f/glamour-kylie-cover-pink-v1_mag.jpg");
        list3.add("https://i.pinimg.com/originals/4b/23/74/4b2374b5f6a14e264513406b9fac79cf.jpg");

        List<String> list4 = new ArrayList<>();
        list4.add("https://www.dubraybooks.ie/images/thumbs/038/0387069_9780571327676_625.jpeg");
        list4.add("https://www.porchlightbooks.com/globalassets/book-covers/9780062316097.jpg?w=1000&scale=both&mode=crop&u=637031281011300000");
        list4.add("https://assets.asaxiy.uz/product/items/desktop/5e15bf1a7128c.jpg");
        list4.add("https://assets.asaxiy.uz/product/main_image/desktop//600ebb8398618.png");
        list4.add("https://m.media-amazon.com/images/I/41k+WVPLwZL.jpg");


        appList.add(new App("Beeline TV", "65dan ortiq telekanallar, filmlar va seriallar", list1));
        appList.add(new App("Beeline Music", "Internet traffikni sarflamagan holda millionlab qo'shiqlar", list2));
        appList.add(new App("Beeline Pressa", "Dunyodagi eng so'nggi yangiliklar va eng so'nggi jurnallar", list3));
        appList.add(new App("Bookmate. Kitoblar", "14 tildan iborat bo'lgan 1 000 000 dan ortiq kitoblar", list4));
    }
}