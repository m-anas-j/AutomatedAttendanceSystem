package com.example.weisslogia.automatedattendancesystem;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class StudentDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_STUDENT = "student";
    private static final String COLUMN_1_ID = "student_id";
    private static final String COLUMN_2_NAME = "student_name";
    private static final String COLUMN_3_PASSWORD = "student_password";



    public StudentDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStudentTable = "CREATE TABLE " + TABLE_STUDENT + "( " +
                COLUMN_1_ID + " TEXT PRIMARY KEY, " +
                COLUMN_2_NAME + " TEXT, " +
                COLUMN_3_PASSWORD + " TEXT )"
                ;
        db.execSQL(createStudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);

    }

    public void addNewStudent(Student newStudent)
    {
        String id = newStudent.getStudentId();
        String name = newStudent.getStudentName();
        String password = newStudent.getStudentPassword();

        ContentValues newStudentValues = new ContentValues();
        newStudentValues.put(COLUMN_1_ID,id);
        newStudentValues.put(COLUMN_2_NAME,name);
        newStudentValues.put(COLUMN_3_PASSWORD,password);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STUDENT,null,newStudentValues);

        //sort the table every time a new entry is added
        db.execSQL("CREATE TABLE ORDERED_TABLE AS SELECT * FROM " + TABLE_STUDENT + " ORDER BY STUDENT_ID ASC");
        db.execSQL("DROP TABLE " + TABLE_STUDENT);
        db.execSQL("ALTER TABLE ORDERED_TABLE RENAME TO " + TABLE_STUDENT);
    }

    public Student getNewlyCreatedStudentInfo(String newStudentId)
    {
        Student studentInfo = new Student();

        SQLiteDatabase db = getWritableDatabase();

        String idQuery = "SELECT " + COLUMN_1_ID + " FROM " + TABLE_STUDENT + " WHERE " + COLUMN_1_ID + " IS " + newStudentId;
        String nameQuery = "SELECT " + COLUMN_2_NAME + " FROM " + TABLE_STUDENT + " WHERE " + COLUMN_1_ID + " IS " + newStudentId;

        Cursor recordSet = db.rawQuery(idQuery, null);
        //Move to the first row in your results
        recordSet.moveToFirst();
        studentInfo.setStudentId(recordSet.getString(recordSet.getColumnIndex(COLUMN_1_ID)));

        recordSet = db.rawQuery(nameQuery, null);
        //Move to the first row in your results
        recordSet.moveToFirst();
        studentInfo.setStudentName(recordSet.getString(recordSet.getColumnIndex(COLUMN_2_NAME)));

        db.close();


        return studentInfo;
    }

    public Cursor viewAllStudents()
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STUDENT;
        Cursor ret = db.rawQuery(query, null);
        ret.moveToFirst();
        return ret;
    }

    public String searchPassword(String userIdStr) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT student_id,student_password FROM " + TABLE_STUDENT;
        Cursor cursor = db.rawQuery(query, null);
        String userId, password;
        password = "NOT FOUND";
        if(cursor.moveToFirst()){
            do {
                userId = cursor.getString(0);
                password = cursor.getString(1);
                if(userId.equals(userIdStr)){
                    password = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return password;
    }
}
