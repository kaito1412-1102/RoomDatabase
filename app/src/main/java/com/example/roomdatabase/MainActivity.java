package com.example.roomdatabase;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.adapter.UserAdapter;
import com.example.roomdatabase.dao.UserPetDatabase;
import com.example.roomdatabase.model.User;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_insert)
    Button btnInsert;
    @BindView(R.id.rv_user)
    RecyclerView rvUser;
    @BindView(R.id.edt_name)
    EditText edtName;
    UserAdapter adapter;
    UserPetDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDatabase = UserPetDatabase.getInstance(this);
        initRvUser();
    }

    private void initRvUser() {
        adapter = new UserAdapter(this);
        rvUser.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvUser.setAdapter(adapter);
        if (getUser() != null) {
            adapter.setUser(getUser());
        }
    }

    private List<User> getUser() {
        return mDatabase.getUserDao().getAllUser();
    }

    @OnClick(R.id.btn_insert)
    public void onClick() {
        if (edtName.getText() != null) {
            String name = edtName.getText().toString();
            User user = new User(name);
            long id = mDatabase.getUserDao().insertUser(user);
            Log.d("TAG", "onClick: " + id);
            user.setUserId((int) id);
            adapter.addUser(user);
        }
    }
}