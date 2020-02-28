package com.example.jonshonpaints.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATA_VERSION = 1;
    public static final String DATABASE_NAME = "cartAdd";
    private static final String TABLE_NAME = "cartaddItem";
    private static final String COMPANY_NAME = "cName";
    private static final String PRODUCT_NAME = "pName";
    private static final String COLOR = "color";
    private static final String UNIT = "unit";
    public static final String MOBILE = "phone";
    public static final String USER_NAME = "userName";
    public static final String QTY = "qty";
    private static final String ID = "id";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CART_TABLE = "CREATE TABLE IF NOT EXISTS `cartaddItem` (\n" +
                "\t`cName`\tTEXT,\n" +
                "\t`pName`\tTEXT,\n" +
                "\t`color`\tTEXT,\n" +
                "\t`qty`\tTEXT,\n" +
                "\t`unit`\tTEXT,\n" +
                "\t`userName`\tTEXT,\n" +
                "\t`phone`\tTEXT,\n" +
                "\tPRIMARY KEY(`phone`)\n" +
                ")";
        sqLiteDatabase.execSQL(CREATE_CART_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void insertToCart(String compnyName, String prodName, String colorName, String unit, String mobile, String qty ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COMPANY_NAME, compnyName);
        cv.put(PRODUCT_NAME, prodName);
        cv.put(COLOR, colorName);
        cv.put(UNIT, unit);
        cv.put(MOBILE, mobile);
        cv.put(QTY, qty);

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }


}
