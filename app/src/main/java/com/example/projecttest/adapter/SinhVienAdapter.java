package com.example.projecttest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttest.ClickItemStudent;
import com.example.projecttest.R;
import com.example.projecttest.databinding.SinhvienItemBinding;
import com.example.projecttest.room.service.SinhVien;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienAdapterHolder> {
    private List<SinhVien> list;
    private ClickItemStudent clickItemStudent;

    public void setClickItemStudent(ClickItemStudent clickItemStudent) {
        this.clickItemStudent = clickItemStudent;
        notifyDataSetChanged();
    }

    public void setList(List<SinhVien> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public SinhVienAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SinhvienItemBinding binding = SinhvienItemBinding.inflate(layoutInflater, parent, false);
        return new SinhVienAdapterHolder(binding);
    }

    @Override
    public void onBindViewHolder(SinhVienAdapterHolder holder, int position) {
        final SinhVien sinhVien = list.get(position);
        holder.binding.setSinhvien(sinhVien);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class SinhVienAdapterHolder extends RecyclerView.ViewHolder {

        private SinhvienItemBinding binding;

        public SinhVienAdapterHolder(SinhvienItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItemStudent.clickItem(list.get(getAdapterPosition()));
                }
            });
        }
    }
}
