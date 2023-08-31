package com.example.ps22039_huynhngoclongnhat_duanmau.DAO;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps22039_huynhngoclongnhat_duanmau.Database.DBHelped;
import com.example.ps22039_huynhngoclongnhat_duanmau.model.ThanhVien;

import java.util.ArrayList;

public class ThanhVienDAO {
    DBHelped dbHelped;
    public ThanhVienDAO(Context context){
dbHelped = new DBHelped(context);
    }
    public ArrayList<ThanhVien> getDSThanhVien(){
        ArrayList<ThanhVien> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelped.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM THANHVIEN", null);
if(cursor.getCount() !=0 ){
    cursor.moveToFirst();
    do{
        list.add(new ThanhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
    }while (cursor.moveToNext());
}
        return list;
    }
    public boolean themThanhVien(String hoten, String namsinh){
        SQLiteDatabase sqLiteDatabase = dbHelped.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoten", hoten);
        contentValues.put("namsinh", namsinh);
        long check = sqLiteDatabase.insert("THANHVIEN", null, contentValues);
        if(check == -1)
            return false;
            return true;
        }
        public boolean capnhatThongTinTV(int matv, String hoten, String namsinh){
        SQLiteDatabase sqLiteDatabase = dbHelped.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoten", hoten);
        contentValues.put("namsinh", namsinh);
        long check = sqLiteDatabase.update("THANHVIEN", contentValues, "matv = ?", new String[]{String.valueOf(matv)});
        if(check == -1)
            return false;
            return true;
        }

        public int xoaThongTinTV(int matv){
        SQLiteDatabase sqLiteDatabase = dbHelped.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PHIEUMUON WHERE matv = ?", new String[]{String.valueOf(matv)});
        if(cursor.getCount() !=0){
            return -1;
            }
        long check = sqLiteDatabase.delete("THANHVIEN", "matv = ?", new String[]{String.valueOf(matv)});
         if(check == -1)
             return 0;
             return 1;
         }
    }

