package com.meterstoinches.companiespart2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME="ANKUSH_DATABASE";
    public static final String TABLE_NAME="Companies";

    public static final String key_comapnyRef="comapnyRef";
    public static final String key_formalName="formalName";
    public static final String key_companyTypeCode="companyTypeCode";
    public static final String key_mainAdress="mainAdress";
    public static final String key_mainPostcode="mainPostcode";
    public static final String key_receptionNo="receptionNo";
    public static final String key_websiteURL="websiteURL";
    public static final String key_customer="customer";
    public static final String key_supplier="supplier";
    public static final String key_compaynotes="compaynotes";


    String create_companytable="create table "+ TABLE_NAME +"("+
            key_comapnyRef+" INTEGER PRIMARY KEY,"+ key_formalName+" TEXT,"+
            key_companyTypeCode +" text,"+key_mainAdress +" text,"+
            key_mainPostcode +" text,"+key_receptionNo+" text,"+
            key_websiteURL +" text,"+key_customer+" text,"+
            key_supplier+" text,"+key_compaynotes+" text"+")";
    String drop_companytable="drop table if exists "+ TABLE_NAME;






    public DatabaseHandler( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_companytable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_companytable);
        onCreate(db);

    }
    public void addCompany(String a1,String a2,String a3,String a4,String a5,
                           String a6,String a7,String a8,String a9){
        SQLiteDatabase db=this.getWritableDatabase();
        Companies companies=new Companies();
        ContentValues values=new ContentValues();
        values.put(key_formalName,a1);
        values.put(key_companyTypeCode,a2);
        values.put(key_mainAdress,a3);
        values.put(key_mainPostcode,a4);
        values.put(key_receptionNo,a5);
        values.put(key_websiteURL,a6);
        values.put(key_customer,a7);
        values.put(key_supplier,a8);
        values.put(key_compaynotes,a9);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public List<Companies> getallCompanies(){
        List<Companies> companiesList = new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        String selectquery="select * from "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(selectquery,null);
        if (cursor.moveToFirst()){
            do {
                Companies companies=new Companies();
                companies.setComapnyRef(Integer.parseInt(cursor.getString(0)));
                companies.setFormalName(cursor.getString(1));
                companies.setCompanyTypeCode(cursor.getString(2));
                companies.setMainAdress(cursor.getString(3));
                companies.setMainPostcode(cursor.getString(4));
                companies.setReceptionNo(cursor.getString(5));
                companies.setWebsiteURL(cursor.getString(6));
                companies.setCustomer(cursor.getString(7));
                companies.setSupplier(cursor.getString(8));
                companies.setCompaynotes(cursor.getString(9));
                companiesList.add(companies);
            }while (cursor.moveToNext());
        }
        return companiesList;
    }
    public void deleteLastRow(){
        Companies companies = new Companies();
        SQLiteDatabase db=this.getWritableDatabase();
        String selectquery="select * from "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(selectquery,null);

        if (cursor.moveToLast()) {
            companies.setComapnyRef(Integer.parseInt(cursor.getString(0)));
        }
        db.execSQL("DELETE FROM " + TABLE_NAME+ " WHERE "+key_comapnyRef+"='"+companies.getComapnyRef()+"'");
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(drop_companytable);
        db.execSQL(create_companytable);
    }

}
