package com.example.lv_adapter_add_update_delete_clear;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lv_adapter_add_update_delete_clear.adapter.SinhVienAdapter;
import com.example.lv_adapter_add_update_delete_clear.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTen, edtNamSinh;
    Button btnAdd, btnUpdate, btnDelete, btnClear;
    ListView lvSinhVien;
    ArrayList<SinhVien> sinhVienArrayList;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Ánh xạ:
        edtTen= findViewById(R.id.edtTen);
        edtNamSinh= findViewById(R.id.edtNamSinh);
        btnAdd= findViewById(R.id.btnAdd);
        btnUpdate= findViewById(R.id.btnUpdate);
        btnDelete= findViewById(R.id.btnDelete);
        btnClear=findViewById(R.id.btnClear);
        lvSinhVien=findViewById(R.id.lvSinhVien);

        sinhVienArrayList=new ArrayList<>();
        sinhVienArrayList.add(new SinhVien("Nguyen Van A", 1990));
        sinhVienArrayList.add(new SinhVien("Nguyen Van B", 1991));
        sinhVienArrayList.add(new SinhVien("Nguyen Van E", 1994));
        SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(MainActivity.this, R.layout.layout_item_sinh_vien,sinhVienArrayList);
        lvSinhVien.setAdapter(sinhVienAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString();
                Integer namSinh = Integer.valueOf(edtNamSinh.getText().toString());

                boolean hasDuplicate = false;
                for (SinhVien sinhVien : sinhVienArrayList) {
                    if (sinhVien.getTen().equals(ten)) {
                        hasDuplicate = true;
                        break;
                    }
                }

                if (hasDuplicate) {
                    edtTen.setText("");
                    edtNamSinh.setText("");
                    edtTen.setError("Tên đã tồn tại");
                } else {
                    sinhVienArrayList.add(new SinhVien(ten, namSinh));
                    sinhVienAdapter.notifyDataSetChanged();
                    edtTen.setText("");
                    edtNamSinh.setText("");
                }
            }
        });
        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtTen.setText(sinhVienArrayList.get(position).getTen());
                edtNamSinh.setText(String.valueOf(sinhVienArrayList.get(position).getNamSinh()));
                index=position;
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString();
                Integer nam =Integer.valueOf(edtNamSinh.getText().toString());

                sinhVienArrayList.set(index,new SinhVien(ten,nam));
                sinhVienAdapter.notifyDataSetChanged();
                edtTen.setText("");
                edtNamSinh.setText("");
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận xóa nha! ");
                builder.setMessage("Bạn có chắc chắn là muốn xóa ko ?");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sinhVienArrayList.remove(index);
                        sinhVienAdapter.notifyDataSetChanged();
                        edtTen.setText("");
                        edtNamSinh.setText("");
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinhVienArrayList.clear();
                sinhVienAdapter.notifyDataSetChanged();
            }
        });
    }
}