package com.itechmandiri.myapplication.Activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import com.itechmandiri.myapplication.Database.DatabaseHelperTasks;
import com.itechmandiri.myapplication.Adapter.Name;
import com.itechmandiri.myapplication.Adapter.NameAdapter;
import com.itechmandiri.myapplication.Connection.NetworkStateChecker;
import com.itechmandiri.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.itechmandiri.myapplication.Database.DatabaseHelperTasks.COLUMN_ID;

public class Tasks extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    AutoCompleteTextView auto;
    /*
    * this is the url to our webservice
    * make sure you are using the ip instead of localhost
    * it will not work if you are using localhost
    * */
    public static final String URL_SAVE_NAME = "http://128.159.0.129:8090/project/sqlitemysqlsync/saveName.php";

    //database helper object
    private DatabaseHelperTasks db;

    //View objects

    private ListView listViewNames;

    //List to store all the names
    private List<Name> names;
    //1 means data is synced and 0 means data is not synced
    public static final int NAME_SYNCED_WITH_SERVER = 1;
    public static final int NAME_NOT_SYNCED_WITH_SERVER = 0;
    //a broadcast to know weather the data is synced or not
    public static final String DATA_SAVED_BROADCAST = "Data Saved";
    //Broadcast receiver to know the sync status
    private BroadcastReceiver broadcastReceiver;
    //adapterobject for list view
    private NameAdapter nameAdapter;

    private EditText editid_tasks;
    private String id_tasks;

    DatabaseHelperTasks dbcenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tasks);

        registerReceiver(new NetworkStateChecker(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        //initializing views and objects
        db = new DatabaseHelperTasks(this);
        names = new ArrayList<>();
        listViewNames = (ListView) findViewById(R.id.listViewNames);
        listViewNames.setOnItemClickListener(this);


        //calling the method to load all the stored names
        loadNames();
        //the broadcast receiver to update sync status
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                //loading the names again
                loadNames();
            }
        };
        //registering the broadcast receiver to update sync status
        registerReceiver(broadcastReceiver, new IntentFilter(DATA_SAVED_BROADCAST));


    }

    /*
    * this method will
    * load the names from the database
    * with updated sync status
    * */
    private void loadNames() {
        names.clear();
        Cursor cursor = db.getNames();
        if (cursor.moveToFirst()) {
            do {
                Name name = new Name(
                        cursor.getString(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_SUBJECT_TASKS)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_STATUS_TASKS)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_TANGGAL)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_WAKTU)),

                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_OUTCOME)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_CUSTOMERS)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_TYPE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_DESCRIPTION)),

                        cursor.getInt(cursor.getColumnIndex(DatabaseHelperTasks.COLUMN_STATUS))
                );
                names.add(name);
            } while (cursor.moveToNext());
        }

        nameAdapter = new NameAdapter(this, R.layout.names, names);
        listViewNames.setAdapter(nameAdapter);
    }



    @Override
    public void onClick(View view) {

    }


    @Override
    public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {

        final Name n = (Name) parent.getItemAtPosition(position);

        final CharSequence[] dialogitem = {"Lihat Draft","Hapus Draft"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Tasks.this);
        builder.setTitle("Pilihan");
        builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch(item) {
                    case 0:
                        Intent i = new Intent(Tasks.this, Detail_Tasks.class);
                        i.putExtra("pesan", n.getId_tasks());
                        startActivity(i);
                        break;
                    case 1:

                }
            }
        });
        builder.create().show();
    }
}
