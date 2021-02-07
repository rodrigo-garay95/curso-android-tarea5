package com.saludo.tareaandroidsemana5.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.saludo.tareaandroidsemana5.R;
import com.saludo.tareaandroidsemana5.adapter.MascotaAdaptador;
import com.saludo.tareaandroidsemana5.adapter.PerfilAdaptador;
import com.saludo.tareaandroidsemana5.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView rvPerfil;
    ArrayList<Mascota> mascotas;
    public MascotaAdaptador mascotaAdaptador;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        CircularImageView circularImageView = v.findViewById(R.id.circularImageView);
        // Set Color
        circularImageView.setCircleColor(Color.WHITE);
        // or with gradient
        circularImageView.setCircleColorStart(Color.WHITE);
        circularImageView.setCircleColorEnd(Color.BLUE);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Set Border
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.WHITE);
        // or with gradient
        circularImageView.setBorderColorStart(Color.WHITE);
        circularImageView.setBorderColorEnd(Color.BLUE);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Add Shadow with default param
        circularImageView.setShadowEnable(true);
        // or with custom param
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.BLUE);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);

        rvPerfil = (RecyclerView) v.findViewById(R.id.rvPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerfil.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador(){

        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        rvPerfil.setAdapter(adaptador);

    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Kodi", R.drawable.kodi, 4));
        mascotas.add(new Mascota("Kodi", R.drawable.kodi, 2));
        mascotas.add(new Mascota("Kodi", R.drawable.kodi, 3));
        mascotas.add(new Mascota("Kodi", R.drawable.kodi, 5));
        mascotas.add(new Mascota("Kodi", R.drawable.kodi, 2));
        mascotas.add(new Mascota("Kodi", R.drawable.kodi, 1));

    }

}