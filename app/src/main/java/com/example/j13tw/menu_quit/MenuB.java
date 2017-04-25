package com.example.j13tw.menu_quit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MenuB extends AppCompatActivity {

    TextView desk, child;
    EditText countA, countB, countC, countD, countE, countF;
    CheckBox TypeA, TypeB, TypeC, TypeD, TypeE, TypeF;
    Button clearMenu, takeCash;
    int cash = 0, kal = 0;

    public void errorA(){
        AlertDialog.Builder chooseCheck = new AlertDialog.Builder(MenuB.this);
        chooseCheck.setTitle("APP 流程錯誤");
        chooseCheck.setMessage("請選擇餐數量或勾選餐點");
        //checkSeat.setCancelable(false);
        chooseCheck.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        chooseCheck.show();
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_b);

        desk = (TextView)findViewById(R.id.desk);
        child = (TextView)findViewById(R.id.child);
        TypeA = (CheckBox) findViewById(R.id.TypeA);
        TypeB = (CheckBox) findViewById(R.id.TypeB);
        TypeC = (CheckBox) findViewById(R.id.TypeC);
        TypeD = (CheckBox) findViewById(R.id.TypeD);
        TypeE = (CheckBox) findViewById(R.id.TypeE);
        TypeF = (CheckBox) findViewById(R.id.TypeF);
        countA = (EditText)findViewById(R.id.countA);
        countB = (EditText)findViewById(R.id.countB);
        countC = (EditText)findViewById(R.id.countC);
        countD = (EditText)findViewById(R.id.countD);
        countE = (EditText)findViewById(R.id.countE);
        countF = (EditText)findViewById(R.id.countF);
        clearMenu = (Button)findViewById(R.id.clearMenu);
        takeCash = (Button)findViewById(R.id.takeCash);

        final Bundle bundle = this.getIntent().getExtras();

        if(bundle != null){
            desk.setText(bundle.getString("seat"));
            child.setText(Integer.toString(bundle.getInt("child")));
        }
        takeCash.setOnClickListener(new View.OnClickListener() {
            Bundle show = new Bundle();
            int mealCount = 0;
            @Override
            public void onClick(View v) {
                int errorCheck = 0;
                if((!TypeA.isChecked() && ("".equals(countA.getText().toString()))) && (!TypeB.isChecked() && ("".equals(countB.getText().toString()))) && (!TypeC.isChecked() && ("".equals(countC.getText().toString()))) && (!TypeD.isChecked() && ("".equals(countD.getText().toString()))) && (!TypeE.isChecked() && ("".equals(countE.getText().toString()))) && (!TypeF.isChecked() && ("".equals(countF.getText().toString()))) && errorCheck == 0){
                    errorCheck++;
                    errorA();
                }
                if((TypeA.isChecked() && ("".equals(countA.getText().toString()))) || (TypeB.isChecked() && ("".equals(countB.getText().toString()))) || (TypeC.isChecked() && ("".equals(countC.getText().toString()))) || (TypeD.isChecked() && ("".equals(countD.getText().toString()))) || (TypeE.isChecked() && ("".equals(countE.getText().toString()))) || (TypeF.isChecked() && ("".equals(countF.getText().toString()))) && errorCheck == 0){
                    errorCheck++;
                    errorA();
                }
                if(TypeA.isChecked() && !("".equals(countA.getText().toString())) && (errorCheck == 0)){
                    if(Integer.parseInt(countA.getText().toString()) <= 0){
                        errorA();
                    }
                    else{
                        cash += Integer.parseInt(countA.getText().toString())*987;
                        kal += Integer.parseInt(countA.getText().toString())*666;
                        mealCount++;
                        show.putInt("countA", Integer.parseInt(countA.getText().toString()));
                    }
                    //TypeA.setChecked(true);
                }
                else if(!TypeA.isChecked() && !("".equals(countA.getText().toString())) && errorCheck == 0){
                    errorA();
                }
                else{
                    show.putInt("countA", 0);
                }
                if(TypeB.isChecked() && !("".equals(countB.getText().toString())) && errorCheck == 0){
                    if(Integer.parseInt(countB.getText().toString()) <= 0){
                        errorA();
                    }
                    else{
                        cash += Integer.parseInt(countB.getText().toString())*999;
                        kal += Integer.parseInt(countB.getText().toString())*9999;
                        mealCount++;
                        show.putInt("countB", Integer.parseInt(countB.getText().toString()));
                    }
                    //TypeB.setChecked(true);
                }
                else if(!TypeB.isChecked() && !("".equals(countB.getText().toString())) && errorCheck == 0){
                    errorA();
                }
                else{
                    show.putInt("countB", 0);
                }
                if(TypeC.isChecked() && !("".equals(countC.getText().toString())) && errorCheck == 0){
                    if(Integer.parseInt(countC.getText().toString()) <= 0){
                        errorA();
                    }
                    else{
                        cash += Integer.parseInt(countC.getText().toString())*300;
                        kal += Integer.parseInt(countC.getText().toString())*850;
                        mealCount++;
                        show.putInt("countC", Integer.parseInt(countC.getText().toString()));
                    }
                    //TypeC.setChecked(true);
                }
                else if(!TypeC.isChecked() && !("".equals(countC.getText().toString())) && errorCheck == 0){
                    errorA();
                }
                else{
                    show.putInt("countC", 0);
                }
                if(TypeD.isChecked() && !("".equals(countD.getText().toString())) && errorCheck == 0){
                    if(Integer.parseInt(countD.getText().toString()) <= 0){
                        errorA();
                    }
                    else{
                        cash += Integer.parseInt(countD.getText().toString())*180;
                        kal += Integer.parseInt(countD.getText().toString())*130;
                        mealCount++;
                        show.putInt("countD", Integer.parseInt(countD.getText().toString()));
                    }
                    //TypeD.setChecked(true);
                }
                else if(!TypeD.isChecked() && !("".equals(countD.getText().toString())) && errorCheck == 0){
                    errorA();
                }
                else{
                    show.putInt("countE", 0);
                }
                if(TypeE.isChecked() && !("".equals(countE.getText().toString())) && errorCheck == 0){
                    if(Integer.parseInt(countE.getText().toString()) <= 0){
                        errorA();
                    }
                    else{
                        cash += Integer.parseInt(countE.getText().toString())*180;
                        kal += Integer.parseInt(countE.getText().toString())*160;
                        mealCount++;
                        show.putInt("countE", Integer.parseInt(countE.getText().toString()));
                    }
                    //TypeE.setChecked(true);
                }
                else if(!TypeE.isChecked() && !("".equals(countE.getText().toString())) && errorCheck == 0){
                    errorA();
                }
                else{
                    show.putInt("countE", 0);
                }
                if(TypeF.isChecked() && !("".equals(countF.getText().toString())) && errorCheck == 0){
                    if(Integer.parseInt(countF.getText().toString()) <= 0){
                        errorA();
                    }
                    else{
                        cash += Integer.parseInt(countF.getText().toString())*110;
                        kal += Integer.parseInt(countF.getText().toString())*220;
                        mealCount++;
                        show.putInt("countF", Integer.parseInt(countF.getText().toString()));
                    }
                    //TypeF.setChecked(true);
                }
                else if(!TypeF.isChecked() && !("".equals(countF.getText().toString())) && errorCheck == 0){
                    errorA();
                }
                else{
                    show.putInt("countF", 0);
                }
                if(errorCheck == 0 && mealCount != 0){
                    AlertDialog.Builder sendCheck = new AlertDialog.Builder(MenuB.this);
                    sendCheck.setTitle("菜單送出確認");
                    sendCheck.setMessage("是否送出菜單?");
                    sendCheck.setCancelable(false);
                    sendCheck.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    sendCheck.setNegativeButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent ShowCash = new Intent();
                            ShowCash.setClass(MenuB.this, ShowCash.class);
                            show.putString("floor", bundle.getString("floor"));
                            show.putString("people", bundle.getString("people"));
                            show.putInt("peopleCount", bundle.getInt("peopleCount"));
                            show.putString("desk", bundle.getString("seat"));
                            show.putInt("child", bundle.getInt("child"));
                            show.putString("TypeA", "昇龍腳趾   $987");
                            show.putString("TypeB", "宇宙燒賣   $999");
                            show.putString("TypeC", "鵝肉燒臘   $300");
                            show.putString("TypeD", "素茶碗蒸    $80");
                            show.putString("TypeE", "鹽漬鮪魚   $180");
                            show.putString("TypeF", "小籠湯包   $110");
                            show.putInt("cash", cash);
                            show.putInt("kal", kal);
                            ShowCash.putExtras(show);
                            startActivity(ShowCash);
                        }
                    });
                    sendCheck.show();
                }
                //desk.setText(Integer.toString(cash));
                //child.setText(Integer.toString(kal));
            }
        });
        clearMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TypeA.setChecked(false);
                TypeB.setChecked(false);
                TypeC.setChecked(false);
                TypeD.setChecked(false);
                TypeE.setChecked(false);
                TypeF.setChecked(false);
                countA.setText("");
                countB.setText("");
                countC.setText("");
                countD.setText("");
                countE.setText("");
                countF.setText("");
            }
        });
    }
}
