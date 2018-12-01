package com.tapperware.topcarnivores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailHewan extends AppCompatActivity {

    @BindView(R.id.imgFoto)
    ImageView imgFoto;
    @BindView(R.id.txtNama)
    TextView txtNama
            ;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hewan);
        ButterKnife.bind(this);


        //TODO mengubah textview dan image view  dengan data dari halaman sebleumnya
        txtNama.setText(getIntent().getStringExtra("nh"));
        txtDetail.setText(getIntent().getStringExtra("dh"));
        Glide.with(this).load(getIntent().getIntExtra("gh",0)).into(imgFoto);
    }
}