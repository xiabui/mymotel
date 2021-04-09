package me.monla.mymotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import me.monla.mymotel.adapters.ActionAdapter;
import me.monla.mymotel.models.ActionModel;


public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ActionModel> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gvData);
        gridView.setAdapter(new ActionAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                ActionModel actionModel = (ActionModel) o;

                if(position == 1) {
                    Intent intent = new Intent(HomeActivity.this, PaymentScreenLayout.class);
                    startActivity(intent);
                }
            }
        });
    }

    private  List<ActionModel> getListData() {
        List<ActionModel> list = new ArrayList<ActionModel>();
        String[] name = getResources().getStringArray(R.array.action_name),
                image = getResources().getStringArray(R.array.image_name);
        for(int i = 0; i < name.length; i++) {
            list.add(new ActionModel(name[i], image[i]));
        }

        return list;
    }
}
