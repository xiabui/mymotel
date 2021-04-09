package me.monla.mymotel;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import me.monla.mymotel.adapters.RoomAdapter;
import me.monla.mymotel.models.RoomModel;

public class PaymentScreenLayout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_list_layout);

        List<RoomModel> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gvRoomData);
        gridView.setAdapter(new RoomAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                
            }
        });
    }

    private  List<RoomModel> getListData() {
        List<RoomModel> list = new ArrayList<RoomModel>();
        for(int i = 0; i < 13; i++) {
            int id = getResources().getIdentifier("box_pay", "drawable", getPackageName());
             /*
            if(isRent == false) {
                if(isPay) {
                    id = getResources().getIdentifier("box_pay", "drawable", getPackageName());
                } else {
                    id = getResources().getIdentifier("box_unpay", "drawable", getPackageName());
                }
            } else {
                id = getResources().getIdentifier("box_unrent", "drawable", getPackageName());
            }
             */
            Drawable drawable = getResources().getDrawable(id);
            list.add(new RoomModel(i, Integer.toString(i), 0, 0, drawable));

        }

        return list;
    }
}
