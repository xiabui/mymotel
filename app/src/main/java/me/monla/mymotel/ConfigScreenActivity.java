package me.monla.mymotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigScreenActivity extends AppCompatActivity {
    private EditText txtTenNhaTro, txtSoLuongPhong, txtTienPhong, txtTienDien, txtTienNuoc, txtTienDichVu;
    private Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_layout);

        txtTenNhaTro = (EditText) findViewById(R.id.txtTenNhaTro);
        txtSoLuongPhong = (EditText) findViewById(R.id.txtSoLuongPhong);
        txtTienPhong = (EditText) findViewById(R.id.txtTienPhong);
        txtTienDien = (EditText) findViewById(R.id.txtTienDien);
        txtTienNuoc = (EditText) findViewById(R.id.txtTienNuoc);
        txtTienDichVu = (EditText) findViewById(R.id.txtTienDichVu);

        btnLuu = (Button) findViewById(R.id.btnSave);


        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check start app
                //If this is a new user => config new data

                //If this is a normal user => save data
                Intent intent = new Intent(ConfigScreenActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
