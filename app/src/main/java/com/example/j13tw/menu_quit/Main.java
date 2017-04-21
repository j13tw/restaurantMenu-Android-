package com.example.j13tw.menu_quit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Main extends AppCompatActivity {

    RadioButton floorA, floorB, floorC;
    Button  seatChooseA, seatChooseB, seatChooseC, seatChooseD, seatChooseE, seatChooseF, clear, sendList;
    TextView chooseFloor, choosePeople, chooseSeat;
    CheckBox childChair;
    EditText childChairCount;

    public int errorA(){   //尚未點選樓層就選來店用餐人數
        int errorCodeA = 0; //錯誤判斷代碼
        if (floorA.isChecked() == false && floorB.isChecked() == false & floorC.isChecked() == false) {
            errorCodeA = 1;
            AlertDialog.Builder checkFloor = new AlertDialog.Builder(Main.this);
            checkFloor.setTitle("APP 流程錯誤");
            checkFloor.setMessage("請先選擇用餐樓層!!!");
            checkFloor.setCancelable(false);
            checkFloor.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            checkFloor.show();
        }
        return errorCodeA;
    }
    public int errorB(){
        int errorCodeB = 0;
        if (("人數".equals(choosePeople.getText().toString())) || ("座位".equals(chooseSeat.getText().toString()))){
            errorCodeB = 1;
            AlertDialog.Builder checkSeat = new AlertDialog.Builder(Main.this);
            checkSeat.setTitle("APP 流程錯誤");
            checkSeat.setMessage("請選擇用餐人數及座位!!!");
            //checkSeat.setCancelable(false);
            checkSeat.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            checkSeat.show();
        }
        return errorCodeB;
    }
    public int errorC(){
        int errorCodeC = 0;
        if (childChair.isChecked()) {
            if (("".equals(childChairCount.getText().toString())) || (Integer.parseInt(childChairCount.getText().toString()) <= 0)) {
                errorCodeC = 1;
                AlertDialog.Builder checkChild = new AlertDialog.Builder(Main.this);
                checkChild.setTitle("APP 流程錯誤");
                checkChild.setMessage("請確認兒童座椅數量!!!");
                checkChild.setCancelable(false);
                checkChild.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                checkChild.show();
            }
        }
        return errorCodeC;
    }
    public int floorCheck(){//樓層確認
        int floor = -1;
        if (floorA.isChecked()) floor = 0;
        else if (floorB.isChecked()) floor = 1;
        else if (floorC.isChecked()) floor = 2;
        return floor;
    }
    public void people(final int people){//依照選取人數選位子
        final String seat[][][] = {{{"A02","A03","A04","A05","A10"},
                                        {"B02","B03","B04","B05","B11"},
                                        {"C01","C03","C04","C05","C12"},
                                        {"D01","D04","D05","D07","D13"},
                                        {"E03","E04","E05","E08","E12"},
                                        {"F01","F04","F05","F07","F13"}},
                                       {{"A02","A04","A05","A07","A10"},
                                        {"B01","B03","B04","B05","B12"},
                                        {"C02","C03","C04","C05","C13"},
                                        {"D02","D04","D06","D07","D14"},
                                        {"E01","E04","E05","E06","E13"},
                                        {"F01","F04","F05","F07","F11"}},
                                       {{"A05","A06","A08","A09","A10"},
                                        {"B01","B03","B07","B09","B10"},
                                        {"C03","C04","C05","C07","C12"},
                                        {"D01","D02","D05","D06","D13"},
                                        {"E04","E05","E07","E08","E12"},
                                        {"F02","F03","F05","F07","F10"}}};
        final int floor = floorCheck();
        AlertDialog.Builder checkSeat = new AlertDialog.Builder(Main.this);
        checkSeat.setTitle(chooseFloor.getText() + " - " + choosePeople.getText() + " - 剩餘座位");
        //checkSeat.setMessage("請選擇：");
        checkSeat.setCancelable(false);
        checkSeat.setItems(seat[floor][people], new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chooseSeat.setText(seat[floor][people][which]);
            }
        });
        checkSeat.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choosePeople.setText("人數");
                chooseSeat.setText("座位");
            }
        });
        checkSeat.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floorA = (RadioButton)findViewById(R.id.floorA);
        floorB = (RadioButton)findViewById(R.id.floorB);
        floorC = (RadioButton)findViewById(R.id.floorC);
        seatChooseA = (Button)findViewById(R.id.seatChooseA);
        seatChooseB = (Button)findViewById(R.id.seatChooseB);
        seatChooseC = (Button)findViewById(R.id.seatChooseC);
        seatChooseD = (Button)findViewById(R.id.seatChooseD);
        seatChooseE = (Button)findViewById(R.id.seatChooseE);
        seatChooseF = (Button)findViewById(R.id.seatChooseF);
        chooseFloor = (TextView)findViewById(R.id.chooseFloor);
        choosePeople = (TextView)findViewById(R.id.choosePeople);
        chooseSeat = (TextView)findViewById(R.id.chooseSeat);
        childChair = (CheckBox)findViewById(R.id.childChair);
        childChairCount = (EditText)findViewById(R.id.childChairCount);
        clear = (Button)findViewById(R.id.clear);
        sendList = (Button)findViewById(R.id.sendList);

        floorA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floorB.setChecked(false);
                floorC.setChecked(false);
                chooseFloor.setText("1樓");
            }
        });
        floorB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floorA.setChecked(false);
                floorC.setChecked(false);
                chooseFloor.setText("2樓");
            }
        });
        floorC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floorA.setChecked(false);
                floorB.setChecked(false);
                chooseFloor.setText("3樓");
            }
        });
        seatChooseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(errorA() == 0){
                    choosePeople.setText("2人座");
                    people(0);
                }
            }
        });
        seatChooseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(errorA() == 0){
                    choosePeople.setText("4人座");
                    people(1);
                }
            }
        });
        seatChooseC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(errorA() == 0){
                    choosePeople.setText("6人座");
                    people(2);
                }
            }
        });
        seatChooseD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(errorA() == 0){
                    choosePeople.setText("8人座");
                    people(3);
                }
            }
        });

        seatChooseE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (errorA() == 0){
                    choosePeople.setText("10人座");
                    people(4);
                }
            }
        });
        seatChooseF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(errorA() == 0){
                    choosePeople.setText("12人座");
                    people(5);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floorA.setChecked(false);
                floorB.setChecked(false);
                floorC.setChecked(false);
                chooseFloor.setText("樓層");
                choosePeople.setText("人數");
                chooseSeat.setText("座位");
                childChair.setChecked(false);
                childChairCount.setText("");
            }
        });
        sendList.setOnClickListener(new View.OnClickListener() {
            int childcount = 0;
            @Override
            public void onClick(View v) {
                if (errorA() == 0 && errorB() == 0 && errorC() == 0){
                    if(childChair.isChecked()) {
                        childcount = Integer.parseInt(childChairCount.getText().toString());
                    }
                    AlertDialog.Builder checkSend = new AlertDialog.Builder(Main.this);
                    checkSend.setTitle("劃位確認");
                    checkSend.setMessage("指定座位： " + chooseFloor.getText() + " - " + choosePeople.getText() + " - " + chooseSeat.getText() + "號桌\n                     兒童座椅 " + childcount + " 張");
                    checkSend.setCancelable(false);
                    checkSend.setNegativeButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(floorCheck() == 0){

                            }
                            else if(floorCheck() == 1){

                            }
                            else if(floorCheck() == 2){

                            }
                            Intent Menu = new Intent();
                            startActivity(new Intent(Main.this, Menu.class));
                            //finish();
                        }
                    });
                    checkSend.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    checkSend.show();
                }
            }
        });
    }
}
