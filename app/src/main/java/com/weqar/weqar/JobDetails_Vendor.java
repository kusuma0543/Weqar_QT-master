package com.weqar.weqar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weqar.weqar.Global_url_weqar.Global_URL;

import de.hdodenhof.circleimageview.CircleImageView;


public class JobDetails_Vendor extends AppCompatActivity {
    ImageView IV_jobdetails_back;
    CircleImageView CIV_Ujobdet_logo;
    TextView TV_ujobdet_jobtype,TV_ujobdet_jobfield,TV_ujob_jobdeadline,TV_ujob_desc;
    String s_jobdet_logo,s_jobdet_jobtype,s_jobdet_jobfield,s_jobdet_jobdeadline,s_jobdet_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details__vendor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        IV_jobdetails_back=findViewById(R.id.job_details_back);
        IV_jobdetails_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        CIV_Ujobdet_logo=findViewById(R.id.logo_vendor_jobdet);
        TV_ujobdet_jobtype=findViewById(R.id.text_jobtype_vendor_jobdet);
        TV_ujobdet_jobfield=findViewById(R.id.text_jobfield_vendor_jobdet);
        TV_ujob_jobdeadline=findViewById(R.id.text_deadline_vendor_jobdet);
        TV_ujob_desc=findViewById(R.id.text_desc_vendor_jobdet);
        Intent intent=getIntent();
        s_jobdet_logo=intent.getStringExtra("put_jobs_vendor_logo");
        s_jobdet_jobtype=intent.getStringExtra("put_jobs_vendor_jobtype");
        s_jobdet_jobfield=intent.getStringExtra("put_jobs_vendor_jobfield");
        s_jobdet_jobdeadline=intent.getStringExtra("put_jobs_vendor_deadline");
        s_jobdet_desc=intent.getStringExtra("put_jobs_vendor_desc");
        try
        {

            Picasso.with(this).load(Global_URL.Image_url_load+s_jobdet_logo).error(getResources().getDrawable(R.drawable.rounded)).fit().centerCrop().into(CIV_Ujobdet_logo);
            TV_ujobdet_jobtype.setText(s_jobdet_jobfield+" -");
            TV_ujobdet_jobfield.setText(s_jobdet_jobtype);
            TV_ujob_jobdeadline.setText(s_jobdet_jobdeadline);
            TV_ujob_desc.setText(s_jobdet_desc);

        }catch (Exception e){}


    }

}
