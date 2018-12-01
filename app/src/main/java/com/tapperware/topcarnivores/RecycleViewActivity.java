package com.tapperware.topcarnivores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewActivity extends AppCompatActivity {


    @BindView(R.id.my_recyler_view)
    RecyclerView myRecylerView;

    String[] namaHewan, detailHewan;
    int[] gambarHewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);

        namaHewan = getResources().getStringArray(R.array.hewan_name);
        detailHewan = getResources().getStringArray(R.array.hewan_detail);
        gambarHewan = new  int[]{R.drawable.lions, R.drawable.coyote, R.drawable.elang, R.drawable.harimau, R.drawable.buaya, R.drawable.cheetah, R.drawable.hiu, R.drawable.komodo, R.drawable.hyena};

        Adapter adapter = new Adapter(this, gambarHewan, namaHewan, detailHewan);

        myRecylerView.setHasFixedSize(true);
        myRecylerView.setLayoutManager(new LinearLayoutManager(this));
        myRecylerView.setAdapter(adapter);
    }
}
