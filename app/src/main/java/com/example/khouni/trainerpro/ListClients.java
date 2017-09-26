package com.example.khouni.trainerpro;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
public class ListClients extends AppCompatActivity {
    Button btnviewAll;
    DatabasesManage myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clients);
        myDb = new DatabasesManage(this);
        btnviewAll = (Button)findViewById(R.id.listAllButton);
        viewAll();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment_user_login, menu);
        return true;
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("First Name :"+ res.getString(1)+"\n");
                            buffer.append("Last name :"+ res.getString(2)+"\n");
                            buffer.append("Address :"+ res.getString(3)+"\n");
                            buffer.append("Sex :"+ res.getString(4)+"\n");
                            buffer.append("D O B :"+ res.getString(5)+"\n");
                            buffer.append("Phone:"+ res.getString(6)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
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
        if (id == R.id.item_take_picture) {
            super.onOptionsItemSelected(item);
            Intent intentAddc = new Intent(this, TakePicture.class);
            startActivity(intentAddc);
            return true;
        }
        if (id == R.id.item_add_session) {
            super.onOptionsItemSelected(item);
            Intent intentAdds = new Intent(this, NewSession.class);
            startActivity(intentAdds);
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
}

