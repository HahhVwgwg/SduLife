package kz.edu.sdulife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;



import kz.edu.sdulife.R;
import kz.edu.sdulife.listener.ProfileListener;
import kz.edu.sdulife.model.ProfileItem;


public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    ArrayList<ProfileItem> list;
    ProfileListener listener;
    private Context context;


    public ProfileAdapter(ArrayList<ProfileItem> list, ProfileListener listener, Context context) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if(viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_rec_item0,
                    parent, false);
            return new ViewHolder(view);
        }
        else if(viewType == 1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_rec_item,
                    parent, false);
            return new ViewHolder2(view);
        }

        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_rec_item2,
                    parent, false);

            return new ViewHolder3(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        holder.itemView.setOnClickListener(v -> {
            if (getItemViewType(position)==2) {
                listener.onClick(position);
            }
        });

        if (getItemViewType(position)==0) {
            ProfileItem item = list.get(position);
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.type_name.setText(item.getType_name());
//            ((ViewHolder) holder).edit_icon.setOnClickListener(v ->   listener.onClick(position));
//            ((ViewHolder) holder).icons.setOnClickListener(v ->   listener.onClick(position));
        }

        else if (getItemViewType(position)==1) {
            ProfileItem item = list.get(position);
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.value_name.setText(item.getValue_name());
            holder2.value.setText(item.getValue());
        }
        else {
            ProfileItem item = list.get(position);
            ViewHolder3 holder3 = (ViewHolder3) holder;
            holder3.value_name.setText(item.getValue_name());
            holder3.icon.setImageResource(item.getIcon());
            ((ViewHolder3) holder3).icon.setOnClickListener(v -> listener.onClick(position));
            holder3.itemView.setOnClickListener(v -> listener.onClick(position));
        }
        }



    @Override
    public int getItemViewType(int position) {

        if(list.get(position).getType() == 0)
            return 0;
        else if(list.get(position).getType() == 1)
            return 1;
        else return position;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView type_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            type_name = itemView.findViewById(R.id.type_name);


        }
    }

    public class  ViewHolder2 extends RecyclerView.ViewHolder {
        TextView value;
        TextView value_name;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);

            value = itemView.findViewById(R.id.value);
            value_name = itemView.findViewById(R.id.value_name);


        }
    }


    public class  ViewHolder3 extends RecyclerView.ViewHolder {
        TextView value_name;
        ImageView icon;
        public ViewHolder3(@NonNull View itemView) {
            super(itemView);

            value_name = itemView.findViewById(R.id.value_name);
            icon = (ImageView)itemView.findViewById(R.id.icon);

        }
    }

}

