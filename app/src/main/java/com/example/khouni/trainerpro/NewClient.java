package com.example.khouni.trainerpro;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.widget.Button;
import android.widget.Toast;


public class NewClient extends AppCompatActivity {
    DatabasesManage myDb;
    EditText editFName,editLname,editAddress ,editTextId ,editSex , editDob , editPhonenum ;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_client);
        myDb = new DatabasesManage(this);
        editFName = (EditText)findViewById(R.id.EtFname);
        editLname = (EditText)findViewById(R.id.EtLname);
        editAddress = (EditText)findViewById(R.id.etAddress);
        editSex = (EditText)findViewById(R.id.etSex);
        editDob = (EditText)findViewById(R.id.etDob);
        editPhonenum = (EditText)findViewById(R.id.eTPhoneNum);
        //editTextId = (EditText)findViewById(R.id.e);
        btnAddData = (Button)findViewById(R.id.btAddClient);

        AddData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment_user_login, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.item_log_out) {
            super.onOptionsItemSelected(item);
            Intent intentlogin = new Intent(this, LoginActivity.class);
            startActivity(intentlogin);
            return true;
        }
        if (id == R.id.item_add_client) {
            super.onOptionsItemSelected(item);
            Intent intentAddc = new Intent(this, NewClient.class);
            startActivity(intentAddc);
            return true;
        }
        if (id == R.id.item_add_session) {
            super.onOptionsItemSelected(item);
            Intent intentAdds = new Intent(this, NewSession.class);
            startActivity(intentAdds);

            return true;
        }
        if (id == R.id.item_take_picture) {
            super.onOptionsItemSelected(item);
            Intent intentAddc = new Intent(this, TakePicture.class);
            startActivity(intentAddc);
            return true;
        }
        if (id == R.id.item_Marque_Session) {
            super.onOptionsItemSelected(item);
            Intent intentMse = new Intent(this, AddSessionToClient.class);
            startActivity(intentMse);
            return true;
        }
        if (id == R.id.item_view_C_session) {
            super.onOptionsItemSelected(item);
            Intent intentViews = new Intent(this, ClientSession.class);
            startActivity(intentViews);
            return true;
        }
        if (id == R.id.item_billing) {
            super.onOptionsItemSelected(item);
            Intent intentBi = new Intent(this, Payment.class);
            startActivity(intentBi);
            return true;
        }
        if (id == R.id.item_generate_reciept) {
            super.onOptionsItemSelected(item);
            Intent intentRe = new Intent(this, Generate_receipt.class);
            startActivity(intentRe);
            return true;

        }
        return true;
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editFName.getText().toString(),
                                editLname.getText().toString(),
                                editAddress.getText().toString(), editSex.getText().toString(), editDob.getText().toString(), editPhonenum.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(NewClient.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(NewClient.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
