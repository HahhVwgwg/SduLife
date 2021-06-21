package kz.edu.sdulife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import org.jetbrains.annotations.NotNull;



import kz.edu.sdulife.R;
import kz.edu.sdulife.model.ProfileItem;


public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>{
    ArrayList<ProfileItem> list;
    private Context context;

    public ProfileAdapter(ArrayList<ProfileItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_rec_item,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        ProfileItem profileItem = list.get(position);
        holder.value.setText(profileItem.getValue());
        holder.value_name.setText(profileItem.getValue_name());

    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView value_name;
        TextView value;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            value_name = itemView.findViewById(R.id.value_name);
            value = itemView.findViewById(R.id.value);


        }
    }
}
