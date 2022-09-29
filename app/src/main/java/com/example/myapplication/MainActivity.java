package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.SurfaceControl;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final Fragment messageFragment  = new MessageFragment();
    private final Fragment exploreFragment  = new exploreFragment();
    private final Fragment contractFragment = new contractFragment();
    private final Fragment meFragment       = new MeFragment();

    private FragmentManager fm;

    private LinearLayout linerlayoutmessage;
    private LinearLayout linerlayoutcontract;
    private LinearLayout linerlayoutexplore;
    private LinearLayout linerlayoutme;

    private TextView topText;

    private TextView messageText;
    private TextView contractText;
    private TextView exploreText;
    private TextView meText;


    private ImageView imagemessage;
    private ImageView imagecontract;
    private ImageView imageexplore;
    private ImageView imageme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linerlayoutmessage = findViewById(R.id.message);
        linerlayoutcontract = findViewById(R.id.contract);
        linerlayoutexplore = findViewById(R.id.explore);
        linerlayoutme = findViewById(R.id.me);

        topText=findViewById(R.id.topText);

        messageText = findViewById(R.id.textView4);
        contractText = findViewById(R.id.textView3);
        exploreText = findViewById(R.id.textView2);
        meText = findViewById(R.id.textView1);

        imagemessage = findViewById(R.id.imageView4);
        imagecontract =  findViewById(R.id.imageView3);
        imageexplore =  findViewById(R.id.imageView2);
        imageme =  findViewById(R.id.imageView1);

        imagemessage.setOnClickListener(this);
        imageexplore.setOnClickListener(this);
        imagecontract.setOnClickListener(this);
        imageme.setOnClickListener(this);

        initFragmentManager();

    }


    private void  initFragmentManager() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.add(R.id.id_content, messageFragment);
        transaction.add(R.id.id_content,exploreFragment);
        transaction.add(R.id.id_content,contractFragment);
        transaction.add(R.id.id_content,meFragment);
        transaction.commit();

        hideFragmentAll(transaction);
        showFragmentOne(meFragment);
        topText.setText(R.string.我的);
        messageText.setTextColor(Color.GREEN);
        imagemessage.setColorFilter(Color.GREEN);
    }




    private void hideFragmentAll(FragmentTransaction transaction){
        transaction.hide(messageFragment);
        transaction.hide(exploreFragment);
        transaction.hide(contractFragment);
        transaction.hide(meFragment);
    }
    public void showFragmentOne(Fragment oneFragment){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragmentAll(transaction);
        transaction.show(oneFragment);
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView4:
                showFragmentOne(messageFragment);
                topText.setText(R.string.消息);
                setColorDefault();
                messageText.setTextColor(Color.GREEN);
                imagemessage.setColorFilter(Color.GREEN);
                break;
            case R.id.imageView3:
                showFragmentOne(contractFragment);
                topText.setText(R.string.联系人);
                setColorDefault();
                contractText.setTextColor(Color.GREEN);
                imagecontract.setColorFilter(Color.GREEN);
                break;
            case R.id.imageView2:
                showFragmentOne(exploreFragment);
                topText.setText(R.string.发现);
                setColorDefault();
                exploreText.setTextColor(Color.GREEN);
                imageexplore.setColorFilter(Color.GREEN);
                break;
            case R.id.imageView1:
                showFragmentOne(meFragment);
                topText.setText(R.string.我的);
                setColorDefault();
                meText.setTextColor(Color.GREEN);
                imageme.setColorFilter(Color.GREEN);
                break;
            default:
                break;
        }

    }
    public void setColorDefault(){
        imagemessage.setColorFilter(0);
        messageText.setTextColor(Color.BLACK);
        imagecontract.setColorFilter(0);
        contractText.setTextColor(Color.BLACK);
        imageexplore.setColorFilter(0);
        exploreText.setTextColor(Color.BLACK);
        imageme.setColorFilter(0);
        meText.setTextColor(Color.BLACK);
    }

}