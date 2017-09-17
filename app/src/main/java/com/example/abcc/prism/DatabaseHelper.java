package com.example.abcc.prism;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shashankbhimani on 02/09/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Table Names
    private static final String TABLE_USER = "user";
    private static final String TABLE_TASK = "task";
    private static final String TABLE_PROJECT = "project";
    private static final String TABLE_TRANSACTION = "transaction";

    // Common column names
    private static final String USER_ID = "user_id";
    private static final String PROJECT_ID = "prj_id";
    private static final String TASK_ID = "task_id";


    // User Table - column nmaes
    private static final String NAME = "name";
    private static final String LOCATION = "location";
    private static final String PASSWORD = "password";
    private static final String CODE = "vip_code";


    // TASK Table - column names

    private static final String TASK_NAME = "task_name";
    private static final String T_START_DT = "start_dt";
    private static final String T_END_DT = "end_dt";
    private static final String T_HRS_REMAINING = "hrs_rem";

    // PROJECT Table - column names

    private static final String PROJECT_NAME = "prj_name";
    private static final String P_START_DT = "start_dt";
    private static final String P_END_DT = "end_dt";
    private static final String P_STATUS = "status";

    // TRASACTION Table - column names
    private static final String TRANS_ID = "trans_id";
    private static final String HRS_SUBMITTED = "hrs_submitted";
    private static final String HRS_REMAINING = "hrs_remaining";

    // Table Create Statements

    // USER table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + USER_ID + " INTEGER PRIMARY KEY," + NAME
            + " TEXT," + LOCATION + " TEXT," + PASSWORD
            + " TEXT," + CODE+ "ÏNTEGER"+")";

    //PROJECT TABLE CREATE STATEMENT
    private static final String CREATE_PROJECT_TABLE = "CREATE TABLE "+TABLE_PROJECT+"("+PROJECT_ID+" INTEGER PRIMARY KEY,"+USER_ID+" INTEGER,"+PROJECT_NAME+
            "TEXT,"+P_START_DT+"DATETIME,"+P_END_DT+"DATETIME,"+P_STATUS+"TEXT"+")";

    //TASK TABLE CREATE STATEMENT
    private static final String CREATE_TASK_TABLE = "CREATE TABLE "+TABLE_TASK+"("+TASK_ID+" INTEGER PRIMARY KEY,"+USER_ID+"INTEGER,"+TASK_NAME+
            "TEXT,"+T_START_DT+"DATETIME,"+T_END_DT+"DATETIME,"+T_HRS_REMAINING+"INTEGER"+")";


    //TRASACTIONAL TABLE CREATE STATEMENT
    private static final String CREATE_TRASACTION_TABLE = "CREATE TABLE "+TABLE_TRANSACTION+"("+TRANS_ID+" INTEGER PRIMARY KEY,"+USER_ID+" INTEGER,"+PROJECT_ID+
            " INTEGER,"+TASK_ID+" INTEGER,"+HRS_SUBMITTED+" INTEGER,"+HRS_REMAINING+" INTEGER"+")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_PROJECT_TABLE);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TASK_TABLE);
        db.execSQL(CREATE_TRASACTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT);

        // create new tables
        onCreate(db);
    }
}
