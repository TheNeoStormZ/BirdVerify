package com.tns.birdverify;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nombre y versión de la base de datos
    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;

    // Nombre y columnas de la tabla de usuarios
    public static final String TABLE_USERS = "usuarios";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "username";


    private final Context mContext;

    // Sentencia SQL para crear la tabla de usuarios
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT"
                    + ")";

    // Constructor de la clase
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    private void copyDatabase() throws IOException {
        InputStream inputStream = mContext.getAssets().open(DATABASE_NAME);
        String outFileName = mContext.getDatabasePath(DATABASE_NAME).getPath();
        OutputStream outputStream = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public SQLiteDatabase openDatabase() throws SQLException {
        String dbPath = mContext.getDatabasePath(DATABASE_NAME).getPath();

        try {
            copyDatabase();
        } catch (IOException e) {
            throw new RuntimeException("Error al copiar la base de datos", e);
        }

        return SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    // Método que se llama cuando se crea la base de datos por primera vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Ejecutamos la sentencia SQL para crear la tabla de usuarios
        db.execSQL(CREATE_TABLE_USERS);
    }

    // Método que se llama cuando se cambia la versión de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Borramos la tabla de usuarios si existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        // Creamos la tabla de nuevo
        onCreate(db);
    }

    public boolean checkUserExists(String username) {
        SQLiteDatabase db = this.openDatabase();

        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_NAME + " =?";
        Cursor cursor = db.rawQuery(query, new String[]{username});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return exists;
    }

}
