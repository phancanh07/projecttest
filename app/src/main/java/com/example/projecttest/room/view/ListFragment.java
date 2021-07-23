package com.example.projecttest.room.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projecttest.R;
import com.example.projecttest.adapter.SinhVienAdapter;
import com.example.projecttest.databinding.FragmentListBinding;
import com.example.projecttest.modelView.BookModelView;
import com.example.projecttest.modelView.StudentViewModel;
import com.example.projecttest.room.service.SinhVien;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private StudentViewModel studentViewModel;
    private SinhVienAdapter sinhVienAdapter;
    private StudentModel model;

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        View view = binding.getRoot();
        sinhVienAdapter = new SinhVienAdapter();
        model = ViewModelProviders.of(requireActivity()).get(StudentModel.class);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        model.getMutableLiveData().observe(requireActivity(), new Observer<List<SinhVien>>() {
            @Override
            public void onChanged(List<SinhVien> sinhViens) {
                sinhVienAdapter.setList(sinhViens);
                binding.rvStudent.setLayoutManager(manager);
                binding.rvStudent.setHasFixedSize(false);
                binding.rvStudent.setAdapter(sinhVienAdapter);
            }
        });

        return view;
    }
}