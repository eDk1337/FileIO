package com.example.a2ramae45.fileio;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import android.app.AlertDialog;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        EditText txt = (EditText)findViewById(R.id.editText);
        String dir_patch = Environment.getExternalStorageDirectory().getAbsolutePath();


        if(item.getItemId() == R.id.saveMenu) {

            try {
                FileWriter fw = new FileWriter(dir_patch + "/data.txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.println(txt.getText());
                fw.flush();
                pw.close();

            } catch (IOException e) {
                System.out.println("I/O Error: " + e);
            }
            return true;
        }


        if(item.getItemId() == R.id.loadMenu) {
            try {
                FileReader fr = new FileReader(dir_patch + "/data.txt");
                BufferedReader br = new BufferedReader(fr);
                while ((txt.getText = br.readLine())) {
                    System.out.println(txt);
                }
                br.close();
            } catch (IOException e) {
                new AlertDialog.Builder(this).setMessage("ERROR:" + e).setPositiveButton("OK", null).show();
            }
            return true;

        }





        return false;
    }






}
