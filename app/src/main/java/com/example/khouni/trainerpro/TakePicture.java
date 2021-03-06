package com.example.khouni.trainerpro;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class TakePicture extends AppCompatActivity {
    Button button;
    ImageView imageView;
    static final int CAM_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);
        button = (Button) findViewById(R.id.tpButton);
        imageView = (ImageView)findViewById(R.id.CustImageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CAM_REQUEST);


            }
        });
    }
    private File getFile()
    {
    File folder = new File("sdcard/camera_app");
        if(!folder.exists())
        {
        folder.mkdir();
        }
        File image_file = new File(folder,"cam_image.jpg");
        return image_file;
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
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
