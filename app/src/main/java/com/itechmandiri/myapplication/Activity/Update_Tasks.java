package com.itechmandiri.myapplication.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itechmandiri.myapplication.R;
import com.itechmandiri.myapplication.Connection.RequestHandler;
import com.itechmandiri.myapplication.Connection.Konfigurasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;



public class Update_Tasks extends AppCompatActivity implements View.OnClickListener{

    private TextView editId;
    private EditText editSubject,editStatus, editTanggal,editWaktu,editOutcome,editCustomers,editType,editDescription;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_pegawai);

        Intent intent = getIntent();

        id = intent.getStringExtra(Konfigurasi.EMP_ID);

        editId = (TextView) findViewById(R.id.id_tasks);
        editSubject = (EditText) findViewById(R.id.subject);
        editStatus = (EditText) findViewById(R.id.status);
        editTanggal = (EditText) findViewById(R.id.tanggal);

        editWaktu = (EditText) findViewById(R.id.waktu);
        editOutcome = (EditText) findViewById(R.id.outcome);
        editCustomers = (EditText) findViewById(R.id.customers);
        editType = (EditText) findViewById(R.id.type);
        editDescription = (EditText) findViewById(R.id.description);


        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        editId.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Update_Tasks.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Konfigurasi.URL_GET_EMP,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String subject_tasks = c.getString(Konfigurasi.TAG_SUBJECT_TASKS);
            String status_tasks = c.getString(Konfigurasi.TAG_STATUS_TASKS);
            String tanggal_tasks = c.getString(Konfigurasi.TAG_TANGGAL_TASKS);

            String waktu_tasks = c.getString(Konfigurasi.TAG_WAKTU_TASKS);
            String outcome_tasks = c.getString(Konfigurasi.TAG_OUTCOME_TASKS);
            String customers_tasks = c.getString(Konfigurasi.TAG_CUSTOMERS_TASKS);
            String type_tasks = c.getString(Konfigurasi.TAG_TYPE_TASKS);
            String description_tasks = c.getString(Konfigurasi.TAG_DESCRIPTION_TASKS);

            editSubject.setText(subject_tasks);
            editStatus.setText(status_tasks);
            editTanggal.setText(tanggal_tasks);

            editWaktu.setText(waktu_tasks);
            editOutcome.setText(outcome_tasks);
            editCustomers.setText(customers_tasks);
            editType.setText(type_tasks);
            editDescription.setText(description_tasks);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployee(){
        final String subject_tasks = editSubject.getText().toString().trim();
        final String status_tasks = editStatus.getText().toString().trim();
        final String tanggal_tasks = editTanggal.getText().toString().trim();

        final String waktu_tasks = editWaktu.getText().toString().trim();
        final String outcome_tasks = editOutcome.getText().toString().trim();
        final String customers_tasks = editCustomers.getText().toString().trim();
        final String type_tasks = editType.getText().toString().trim();
        final String description_tasks = editDescription.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Update_Tasks.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Update_Tasks.this,s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Konfigurasi.KEY_EMP_ID_TASKS,id);
                hashMap.put(Konfigurasi.KEY_EMP_SUBJECT_TASKS,subject_tasks);
                hashMap.put(Konfigurasi.KEY_EMP_STATUS_TASKS,status_tasks);
                hashMap.put(Konfigurasi.KEY_EMP_TANGGAL_TASKS,tanggal_tasks);

                hashMap.put(Konfigurasi.KEY_EMP_WAKTU_TASKS,waktu_tasks);
                hashMap.put(Konfigurasi.KEY_EMP_OUTCOME_TASKS,outcome_tasks);
                hashMap.put(Konfigurasi.KEY_EMP_CUSTOMERS_TASKS,customers_tasks);
                hashMap.put(Konfigurasi.KEY_EMP_TYPE_TASKS,type_tasks);
                hashMap.put(Konfigurasi.KEY_EMP_DESCRIPTION_TASKS,description_tasks);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(Konfigurasi.URL_UPDATE_EMP,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void deleteEmployee(){
        class DeleteEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Update_Tasks.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Update_Tasks.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Konfigurasi.URL_DELETE_EMP, id);
                return s;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();
    }

    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menghapus Pegawai ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        startActivity(new Intent(Update_Tasks.this,TaskOL.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateEmployee();
        }

        if(v == buttonDelete){
            confirmDeleteEmployee();
        }
    }
}
