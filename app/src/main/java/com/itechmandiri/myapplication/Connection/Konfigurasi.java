package com.itechmandiri.myapplication.Connection;

        public class Konfigurasi {


            //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
            public static final String URL_ADD="http://128.159.0.129:8090/Android/pegawai/tambahPgw.php";
            public static final String URL_GET_ALL = "http://128.159.0.129:8090/Android/pegawai/tampilSemuaPgw.php";
            public static final String URL_GET_EMP = "http://128.159.0.129:8090/Android/pegawai/tampilPgw.php?id=";
            public static final String URL_UPDATE_EMP = "http://128.159.0.129:8090/Android/pegawai/updatePgw.php";
            public static final String URL_DELETE_EMP = "http://128.159.0.129:8090/Android/pegawai/hapusPgw.php?id=";

            //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
            public static final String KEY_EMP_ID_TASKS = "id";
            public static final String KEY_EMP_SUBJECT_TASKS = "subject_tasks";
            public static final String KEY_EMP_STATUS_TASKS = "status_tasks";
            public static final String KEY_EMP_TANGGAL_TASKS = "tanggal_tasks";

            public static final String KEY_EMP_WAKTU_TASKS = "waktu_tasks";
            public static final String KEY_EMP_OUTCOME_TASKS = "outcome_tasks";
            public static final String KEY_EMP_CUSTOMERS_TASKS = "customers_tasks";
            public static final String KEY_EMP_TYPE_TASKS = "type_tasks";
            public static final String KEY_EMP_DESCRIPTION_TASKS = "description_tasks";


    //JSON Tags
            public static final String TAG_JSON_ARRAY="result";
            public static final String TAG_ID_TASKS = "id";
            public static final String TAG_SUBJECT_TASKS = "subject_tasks";
            public static final String TAG_STATUS_TASKS = "status_tasks";
            public static final String TAG_TANGGAL_TASKS = "tanggal_tasks";

            public static final String TAG_WAKTU_TASKS = "waktu_tasks";
            public static final String TAG_OUTCOME_TASKS = "outcome_tasks";
            public static final String TAG_CUSTOMERS_TASKS = "customers_tasks";
            public static final String TAG_TYPE_TASKS = "type_tasks";
            public static final String TAG_DESCRIPTION_TASKS = "description_tasks";

            //ID karyawan
            //emp itu singkatan dari Employee
            public static final String EMP_ID = "emp_id";
        }
