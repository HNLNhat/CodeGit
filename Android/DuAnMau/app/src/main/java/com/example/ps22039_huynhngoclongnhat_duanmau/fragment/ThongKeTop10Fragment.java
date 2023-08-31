package com.example.ps22039_huynhngoclongnhat_duanmau.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ps22039_huynhngoclongnhat_duanmau.DAO.ThongKeDAO;
import com.example.ps22039_huynhngoclongnhat_duanmau.DAO.ThuThuDAO;
import com.example.ps22039_huynhngoclongnhat_duanmau.R;
import com.example.ps22039_huynhngoclongnhat_duanmau.adapter.Top10Adapter;
import com.example.ps22039_huynhngoclongnhat_duanmau.model.Sach;

import java.io.FileReader;
import java.util.ArrayList;

public class ThongKeTop10Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_thongketop10, container, false);

        RecyclerView recyclerTop10 = view.findViewById(R.id.recyclerTop10);

        ThongKeDAO thongKeDAO = new ThongKeDAO(getContext());
        ArrayList<Sach> list = thongKeDAO.getTop10();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerTop10.setLayoutManager(linearLayoutManager);
        Top10Adapter adapter = new Top10Adapter(getContext(), list);
        recyclerTop10.setAdapter(adapter);

        return view;
    }
}
