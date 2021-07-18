package com.example.projecttest.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttest.R;
import com.example.projecttest.bai1.Listesner;
import com.example.projecttest.bai1.OnProgressListener;
import com.example.projecttest.databinding.ItemLayoutBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<User> userList;


    public UserAdapter(List<User> users) {
        this.userList = users;
    }


    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = userList.get(position);
        if (user == null) {
            return;
        }
        holder.txt_user.setText(user.getUserName());
        holder.txt_chat.setText(user.getChat());
        //  holder.binding.setUser(user);
    }

    @Override
    public int getItemCount() {
        if (userList != null) {
            return userList.size();
        }
        return 0;
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        private TextView txt_user, txt_chat;
        //   ItemLayoutBinding binding;

        public UserHolder(View itemView) {
            super(itemView);
            //    binding = itemView;
            txt_chat = itemView.findViewById(R.id.item_chat);
            txt_user = itemView.findViewById(R.id.item_user);
        }
    }
}
