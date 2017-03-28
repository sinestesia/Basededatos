package es.pamp.bbdd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import es.pamp.modelo.Cliente;

public class BBDD extends SQLiteOpenHelper {



    public BBDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "CREATE TABLE USUARIOS(USER TEXT, PASS TEXT);";
        db.execSQL(sqlCreate);
        String sqlInsert = "INSERT INTO USUARIOS (USER, PASS) VALUES ('Alex','pass');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO USUARIOS (USER, PASS) VALUES ('Carlos','pass');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO USUARIOS (USER, PASS) VALUES ('Jose','pass');";
        db.execSQL(sqlInsert);

        sqlCreate = "CREATE TABLE CLIENTES(NOMBRE TEXT, CATEGORIA TEXT, TELEFONO TEXT);";
        db.execSQL(sqlCreate);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO CLIENTES (NOMBRE, CATEGORIA,TELEFONO) VALUES ('Alex','Vendedor','555555555');";
        db.execSQL(sqlInsert);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE If Exists USUARIOS");
    }
    public boolean userpass (SQLiteDatabase db, String user, String pass){
        boolean login = false;
        String sqluserpass = "SELECT * FROM USUARIOS WHERE USER = '" + user + "' AND PASS ='" + pass +"';";
        Cursor cursor = db.rawQuery(sqluserpass, null);
        if (cursor.getCount()==0) {
            login = false;
        }else{
            login=true;
        }

        return login;
    }


    public List<Cliente> getData(SQLiteDatabase db){
        List<Cliente> list = new ArrayList<>();
        String sqluserpass = "SELECT * FROM CLIENTES;";
        Cursor cursor = db.rawQuery(sqluserpass, null);
        try{
            if (cursor.moveToFirst()){
                do {
                    list.add(new Cliente(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
                }while (cursor.moveToNext());
            }
        }
        finally {
            cursor.close();
        }
        return list;
    }


}
