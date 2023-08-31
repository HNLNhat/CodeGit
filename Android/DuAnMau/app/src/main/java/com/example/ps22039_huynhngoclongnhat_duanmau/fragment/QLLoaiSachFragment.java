package com.example.ps22039_huynhngoclongnhat_duanmau.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ps22039_huynhngoclongnhat_duanmau.DAO.LoaiSachDAO;
import com.example.ps22039_huynhngoclongnhat_duanmau.R;
import com.example.ps22039_huynhngoclongnhat_duanmau.adapter.LoaiSachAdapter;
import com.example.ps22039_huynhngoclongnhat_duanmau.model.ItemClick;
import com.example.ps22039_huynhngoclongnhat_duanmau.model.LoaiSach;

import java.util.ArrayList;

public class QLLoaiSachFragment extends Fragment {
    RecyclerView recyclerLoaiSach;
    LoaiSachDAO dao;
    EditText edtLoaiSach;
    int maloai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_qlloaisach, container, false);

        recyclerLoaiSach = view.findViewById(R.id.recyclerLoaiSach);
        edtLoaiSach = view.findViewById(R.id.edtLoaiSach);
        Button btnThem = view.findViewById(R.id.btnThem);
        Button btnSua = view.findViewById(R.id.btnSua);
        dao = new LoaiSachDAO(getContext());

        loadData();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenloai = edtLoaiSach.getText().toString();

                if(dao.themLoaiSach(tenloai)){
                    loadData();
                    edtLoaiSach.setText("");
                    //Thông báo + load danh sách
                }else{
                    Toast.makeText(getContext(), "Thêm loại sách không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenloai = edtLoaiSach.getText().toString();
                LoaiSach loaiSach = new LoaiSach(maloai, tenloai);
                if(dao.thayDoiLoaiSach(loaiSach)){
                    loadData();
                    edtLoaiSach.setText("");
                }else{
                    Toast.makeText(getContext(), "Thay đổi thông tin không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
    private void loadData(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerLoaiSach.setLayoutManager(linearLayoutManager);
        ArrayList<LoaiSach> list = dao.getDSLoaiSach();
        LoaiSachAdapter adapter = new LoaiSachAdapter(getContext(), list, new ItemClick() {
            @Override
            public void onClickLoaiSach(LoaiSach loaiSach) {
            edtLoaiSach.setText(loaiSach.getTenloai());
            maloai = loaiSach.getId();
            }
        });
        recyclerLoaiSach.setAdapter(adapter);
    }
}
