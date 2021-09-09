package com.android.example.beeline;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.example.beeline.adapters.ListTarifAdapter;
import com.android.example.beeline.models.Tarif;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTarifFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTarifFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListTarifFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTarifFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTarifFragment newInstance(String param1, String param2) {
        ListTarifFragment fragment = new ListTarifFragment();
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

    RecyclerView rv;
    List<Tarif> tarifList;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_tarif, container, false);
        rv = root.findViewById(R.id.rv_list_tarif);
        toolbar = root.findViewById(R.id.toolbarTarif);
        toolbar.setTitle("Tariflar");
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
        toolbar.setBackgroundColor(Color.parseColor("#FFFFFF"));

        loadData();
        ListTarifAdapter adapter = new ListTarifAdapter(tarifList, tarif -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("tarif", tarif);

        });
        rv.setAdapter(adapter);
        return root;
    }

    private void loadData() {
        tarifList = new ArrayList<>();
        tarifList.add(new Tarif("ZO'R 2", "https://beeline.uz/binaries/content/gallery/zor_2.png", "20000 so'm", "2000 min", "2000 MB", "2000"));
        tarifList.add(new Tarif("ZO'R 6", "https://beeline.uz/binaries/content/gallery/zor_6.png", "35000 so'm", "6000 min", "6000 MB", "5000"));
        tarifList.add(new Tarif("ZO'R 10", "https://beeline.uz/binaries/content/gallery/zor_10.png", "50000 so'm", "10000 min", "10000 MB", "5000"));
        tarifList.add(new Tarif("ZO'R 15", "https://beeline.uz/binaries/content/gallery/zor_15.png", "70000 so'm", "5000 min", "15000 MB", "5000"));
        tarifList.add(new Tarif("STATUS SILVER NEW", "https://beeline.uz/binaries/content/gallery/status-new_210x210_icon_ru.png", "90000 so'm", "10000 min", "20000 MB", "5000"));
        tarifList.add(new Tarif("STATUS GOLD NEW", "https://beeline.uz/binaries/content/gallery/status-new_210x210_icon_ru.png", "130000 so'm", "20000 min", "3000 MB", "10000"));
        tarifList.add(new Tarif("STATUS PLATINUM NEW", "https://beeline.uz/binaries/content/gallery/status-new_210x210_icon_ru.png", "189000 so'm", "30000 min", "1000 MB", "10000"));
        tarifList.add(new Tarif("ALLO", "https://beeline.uz/binaries/content/gallery/mainsite/b2b/service_img/allo_210x210_ru.png", "15000 so'm", "600 min", "600 MB", "600"));
    }
}