package com.example.roomdatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdatabase.PetActivity;
import com.example.roomdatabase.R;
import com.example.roomdatabase.model.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User> mUsers;
    Context mContext;

    public UserAdapter(Context context) {
        mContext = context;
        mUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, null, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.bindView(user);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setUser(List<User> user) {
        mUsers = user;
        notifyDataSetChanged();
    }

    public void addUser(User user) {
        mUsers.add(user);
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name_user)
        TextView textName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindView(User user) {
            textName.setText(user.getUserName());
        }

        @OnClick(R.id.txt_name_user)
        public void onClick() {
            Intent intent = new Intent(mContext, PetActivity.class);
            intent.putExtra("user", mUsers.get(getAbsoluteAdapterPosition()));
            mContext.startActivity(intent);
        }
    }
}
