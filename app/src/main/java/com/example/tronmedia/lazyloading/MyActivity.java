package com.example.tronmedia.lazyloading;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MyActivity extends Activity {

    ListView list;
    LazyImageLoadAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        list=(ListView)findViewById(R.id.list);

        // Create custom adapter for listview
        adapter=new LazyImageLoadAdapter(this, mStrings);

        //Set adapter to listview
        list.setAdapter(adapter);

        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(listener);
    }

    @Override
    public void onDestroy()
    {
        // Remove adapter refference from list
        list.setAdapter(null);
        super.onDestroy();
    }

    public OnClickListener listener=new OnClickListener(){
        @Override
        public void onClick(View arg0) {

            //Refresh cache directory downloaded images
            adapter.imageLoader.clearCache();
            adapter.notifyDataSetChanged();
        }
    };
    public void onItemClick(int mPosition)
    {
        String tempValues = mStrings[mPosition];

        Toast.makeText(MyActivity.this,
                "Image URL : "+tempValues,
                Toast.LENGTH_LONG).show();
    }
    private String[] mStrings={
            "http://design.classfunda.com/cfv2/deskboard/Home-icon.png",
            "http://design.classfunda.com/cfv2/deskboard/student.png",
            "http://design.classfunda.com/cfv2/deskboard/Attendance.png",
            "http://design.classfunda.com/cfv2/deskboard/timetableicon.png",
            "http://design.classfunda.com/cfv2/deskboard/note.png",
            "http://design.classfunda.com/cfv2/deskboard/folder.png",
            "http://design.classfunda.com/cfv2/deskboard/QuestionBank.png",
            "http://design.classfunda.com/cfv2/deskboard/Video.png",
            "http://design.classfunda.com/cfv2/deskboard/Blueprint64.png",
            "http://design.classfunda.com/cfv2/deskboard/questionpaper.png",
            "http://design.classfunda.com/cfv2/deskboard/ExamCenter.png",
            "http://design.classfunda.com/cfv2/deskboard/OMR_icon.png",
            "http://design.classfunda.com/cfv2/deskboard/result.png",
            "http://design.classfunda.com/cfv2/deskboard/SMS.png",
            "http://design.classfunda.com/cfv2/deskboard/analytics.png",
            "http://design.classfunda.com/cfv2/deskboard/inquiry.png",
            "http://design.classfunda.com/cfv2/deskboard/message.png",
            "http://design.classfunda.com/cfv2/deskboard/Home-icon.png",
            "http://design.classfunda.com/cfv2/deskboard/student.png",
            "http://design.classfunda.com/cfv2/deskboard/Attendance.png",
            "http://design.classfunda.com/cfv2/deskboard/timetableicon.png",
            "http://design.classfunda.com/cfv2/deskboard/note.png",
            "http://design.classfunda.com/cfv2/deskboard/folder.png",
            "http://design.classfunda.com/cfv2/deskboard/QuestionBank.png",
            "http://design.classfunda.com/cfv2/deskboard/Video.png",
            "http://design.classfunda.com/cfv2/deskboard/Blueprint64.png",
            "http://design.classfunda.com/cfv2/deskboard/questionpaper.png",
            "http://design.classfunda.com/cfv2/deskboard/ExamCenter.png",
            "http://design.classfunda.com/cfv2/deskboard/OMR_icon.png",
            "http://design.classfunda.com/cfv2/deskboard/result.png",
            "http://design.classfunda.com/cfv2/deskboard/SMS.png",
            "http://design.classfunda.com/cfv2/deskboard/analytics.png",
            "http://design.classfunda.com/cfv2/deskboard/inquiry.png",
            "http://design.classfunda.com/cfv2/deskboard/message.png"

    };
}
