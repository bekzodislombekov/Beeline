package com.android.example.beeline;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.android.example.beeline.adapters.CurrentInfoAdapter;
import com.android.example.beeline.models.CurrentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentTarifFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentTarifFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrentTarifFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentTarifFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentTarifFragment newInstance(String param1, String param2) {
        CurrentTarifFragment fragment = new CurrentTarifFragment();
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

    ImageView imgTarif;
    RecyclerView rv;
    Button changeTarifBtn;
    ImageView backBtn;
    View root;
    List<CurrentInfo> currentInfoList;
    Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_current_tarif, container, false);
        findUI();
        toolbar.setTitle("Joriy tarif va xizmatlar");
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));

        loadData();

        changeTarifBtn.setOnClickListener(v -> {
            Navigation.findNavController(root).navigate(R.id.listTarifFragment);
        });

        CurrentInfoAdapter adapter = new CurrentInfoAdapter(currentInfoList);
        rv.setAdapter(adapter);

        return root;
    }

    private void loadData() {
        currentInfoList = new ArrayList<>();
        currentInfoList.add(new CurrentInfo(R.drawable.ic_cash, "Oylik abonent to'lovi chegirma bilan*", "30000 so'm"));
        currentInfoList.add(new CurrentInfo(R.drawable.ic_cash, "Oylik abonent to'lovi**", "33333 so'm"));
        currentInfoList.add(new CurrentInfo(R.drawable.ic_cash, "Mavjud abonentlarga tarifga o'tish uchun hisobdagi minimal mablag' miqdori", "33583 so'm"));
        currentInfoList.add(new CurrentInfo(R.drawable.ic_telephone, "O'zbekiston bo'yicha kiritilgan daqiqalar paketi", "1000 min"));
        currentInfoList.add(new CurrentInfo(R.drawable.ic_earth_grid_symbol, "MB paketi", "4000 MB"));
        currentInfoList.add(new CurrentInfo(R.drawable.ic_comment, "O'zbekiston bo'yicha kiritilgan SMS paketi", "400"));
    }

    private void findUI() {
        imgTarif = root.findViewById(R.id.imgTarif);
        rv = root.findViewById(R.id.rv_info_tarif);
        changeTarifBtn = root.findViewById(R.id.changeTarifBtn);
        toolbar = root.findViewById(R.id.toolbar);
    }
}