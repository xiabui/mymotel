package me.monla.mymotel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import me.monla.mymotel.R;
import me.monla.mymotel.models.ActionModel;

public class ActionAdapter extends BaseAdapter {
    private List<ActionModel> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ActionAdapter(Context aContext, List<ActionModel> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_gridview_item, null);
            holder = new ViewHolder();
            holder.txtActionName = (TextView) convertView.findViewById(R.id.txtActionName);
            holder.imgAction = (ImageView) convertView.findViewById(R.id.imgAction);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ActionModel actionModel = this.listData.get(position);
        holder.txtActionName.setText(actionModel.getName());
        int imageId = this.getMipmapResIdByName(actionModel.getImage());

        holder.imgAction.setImageResource(imageId);

        return convertView;
    }

    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        return resID;
    }

    static class ViewHolder {
        TextView txtActionName;
        ImageView imgAction;
    }
}
