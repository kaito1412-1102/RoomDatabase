package com.example.roomdatabase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.model.Pet;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetHolder> {
    List<Pet> mPets;
    IOnclickItem mListener;

    public PetAdapter(IOnclickItem listener) {
        mListener = listener;
        mPets = new ArrayList<>();
    }

    @NonNull
    @Override
    public PetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, null, false);
        return new PetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetHolder holder, int position) {
        Pet pet = mPets.get(position);
        holder.bindView(pet.getPetName(), pet.getPetType());
    }

    @Override
    public int getItemCount() {
        return mPets.size();
    }

    public void setPets(List<Pet> pets) {
        mPets = pets;
        notifyDataSetChanged();
    }

    public void addPet(Pet pet) {
        mPets.add(pet);
        notifyDataSetChanged();
    }

    public void deletePet(Pet pet) {
        mPets.remove(pet);
        notifyDataSetChanged();
    }

    class PetHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_type)
        TextView txtType;
        @BindView(R.id.txt_del)
        TextView txtDel;

        public PetHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(String name, String type) {
            txtName.setText(name);
            txtType.setText(type);
        }

        @OnClick(R.id.txt_del)
        public void onClick() {
            mListener.delete(mPets.get(getAbsoluteAdapterPosition()));
        }
    }

    public interface IOnclickItem {
        void delete(Pet pet);
    }
}
