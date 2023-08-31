package com.example.ps22039_huynhngoclongnhat_duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps22039_huynhngoclongnhat_duanmau.Database.DBHelped;
import com.example.ps22039_huynhngoclongnhat_duanmau.model.LoaiSach;

import java.util.ArrayList;

public class LoaiSachDAO {
    DBHelped dbHelped;

    public LoaiSachDAO(Context context) {
        dbHelped = new DBHelped(context);
    }

    //Lấy danh sách
    public ArrayList<LoaiSach> getDSLoaiSach() {
        ArrayList<LoaiSach> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelped.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM LOAISACH", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new LoaiSach(cursor.getInt(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    //Thêm loại sách
    public boolean themLoaiSach(String tenloai) {
        SQLiteDatabase sqLiteDatabase = dbHelped.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenloai", tenloai);
        long check = sqLiteDatabase.insert("LOAISACH", null, contentValues);
        if (check == -1)
            return false;
        return true;
    }
    //Xóa loại sách
    //1 Xóa thành công

    public int xoaLoaiSach(int id) {
        SQLiteDatabase sqLiteDatabase = dbHelped.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SACH WHERE maloai = ?", new String[]{String.valueOf(id)});
        if (cursor.getCount() != 0) {
            return -1;
        }
        long check = sqLiteDatabase.delete("LOAISACH", "maloai =?", new String[]{String.valueOf(id)});
        if(check == -1)
            return 0;
            return 1;
        }
        public boolean thayDoiLoaiSach(LoaiSach loaiSach){
        SQLiteDatabase sqLiteDatabase = dbHelped.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenloai", loaiSach.getTenloai());
        long check = sqLiteDatabase.update("LOAISACH", contentValues, "maloai = ?", new String[]{String.valueOf(loaiSach.getId())});
        if(check == -1)
            return false;
        return true;

        }
    }

