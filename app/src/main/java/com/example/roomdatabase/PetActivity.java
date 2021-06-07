package com.example.roomdatabase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roomdatabase.adapter.PetAdapter;
import com.example.roomdatabase.dao.UserPetDatabase;
import com.example.roomdatabase.model.Pet;
import com.example.roomdatabase.model.User;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PetActivity extends AppCompatActivity implements PetAdapter.IOnclickItem {
    @BindView(R.id.txt_name_user)
    TextView txtNameUser;
    @BindView(R.id.edt_name_pet)
    EditText edtNamePet;
    @BindView(R.id.edt_type)
    EditText edtType;
    @BindView(R.id.rv_pet)
    RecyclerView rvPet;
    @BindView(R.id.btn_insert)
    Button btnInsert;
    PetAdapter adapter;
    User user;
    UserPetDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        ButterKnife.bind(this);
        mDatabase = UserPetDatabase.getInstance(this);
        user = (User) getIntent().getSerializableExtra("user");
        txtNameUser.setText(user.getUserName());
        initRvPet();
    }

    private void initRvPet() {
        adapter = new PetAdapter(this);
        rvPet.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvPet.setAdapter(adapter);
        if (getAllPet() != null)
            adapter.setPets(getAllPet());
    }

    private List<Pet> getAllPet() {
        return mDatabase.getPetDao().getPetUser(user.getUserId());
    }

    @OnClick(R.id.btn_insert)
    public void onClick() {
        if (edtNamePet.getText() != null && edtType.getText() != null) {
            Pet pet = new Pet(edtType.getText().toString(), edtNamePet.getText().toString(), user.getUserId());
            mDatabase.getPetDao().insertPet(pet);
            adapter.addPet(pet);
        }
    }

    @Override
    public void delete(Pet pet) {
        mDatabase.getPetDao().deletePet(pet);
        adapter.deletePet(pet);
    }
}