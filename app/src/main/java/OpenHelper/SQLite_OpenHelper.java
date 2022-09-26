package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creación de la tabla
        String query = "create table usuarios(_ID integer primary key autoincrement, Name text, District text, Email text, Password text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Método que permite ABRIR la BD
    public void abrirBD() {
        this.getWritableDatabase(); //INSERT o DELETE (Escribir en la base de datos)
    }

    //Método que permite CERRAR la BD
    public void cerrarBD() {
        this.close();
    }

    //Método que permite INSERTAR registros en la tabla Usuarios
    public void insertarReg(String name, String district, String email, String password){
        ContentValues valores = new ContentValues();
        valores.put("Name", name);
        valores.put("District", district);
        valores.put("Email", email);
        valores.put("Password", password);
        this.getWritableDatabase().insert("usuarios",null, valores);
    }
}