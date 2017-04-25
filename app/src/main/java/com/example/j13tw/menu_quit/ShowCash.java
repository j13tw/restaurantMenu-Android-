package com.example.j13tw.menu_quit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class ShowCash extends AppCompatActivity {

    TextView invoice, serviceCode, floor, seat, people, child, kal, cash, TypeA, TypeB, TypeC, TypeD, TypeE, TypeF, countA, countB, countC, countD, countE, countF, showA, showB, showC, showD, showE, showF, showTips, tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cash);

        invoice = (TextView)findViewById(R.id.invoice);
        floor = (TextView)findViewById(R.id.floor);
        serviceCode = (TextView)findViewById(R.id.serviceCode);
        seat = (TextView)findViewById(R.id.seat);
        people = (TextView)findViewById(R.id.people);
        child = (TextView)findViewById(R.id.child);
        kal = (TextView)findViewById(R.id.kal);
        cash = (TextView)findViewById(R.id.cash);
        TypeA = (TextView)findViewById(R.id.TypeA);
        TypeB = (TextView)findViewById(R.id.TypeB);
        TypeC = (TextView)findViewById(R.id.TypeC);
        TypeD = (TextView)findViewById(R.id.TypeD);
        TypeE = (TextView)findViewById(R.id.TypeE);
        TypeF = (TextView)findViewById(R.id.TypeF);
        countA = (TextView)findViewById(R.id.countA);
        countB = (TextView)findViewById(R.id.countB);
        countC = (TextView)findViewById(R.id.countC);
        countD = (TextView)findViewById(R.id.countD);
        countE = (TextView)findViewById(R.id.countE);
        countF = (TextView)findViewById(R.id.countF);
        showA = (TextView)findViewById(R.id.showA);
        showB = (TextView)findViewById(R.id.showB);
        showC = (TextView)findViewById(R.id.showC);
        showD = (TextView)findViewById(R.id.showD);
        showE = (TextView)findViewById(R.id.showE);
        showF = (TextView)findViewById(R.id.showF);
        showTips = (TextView)findViewById(R.id.showTips);
        tips = (TextView)findViewById(R.id.tips);

        final Bundle show = this.getIntent().getExtras();

        if(show != null){
            floor.setText(show.getString("floor"));
            seat.setText(show.getString("desk"));
            people.setText(show.getString("people"));
            child.setText(show.getInt("child") + "張");
            cash.setText(show.getInt("cash") + "元");
            kal.setText(show.getInt("kal") + "大卡");
            invoice.setText("H" + ((int)(Math.random()*10000000)));
            serviceCode.setText("S-01");
            if(show.getInt("kal")/((show.getInt("peopleCount")) + (show.getInt("child"))*0.5) >= 3000){
                showTips.setText("小提醒:");
                tips.setText("飲食搭配運動是優良習慣!");
            }
            if(show.getInt("countA") != 0){
                TypeA.setText(show.getString("TypeA"));
                countA.setText(Integer.toString(show.getInt("countA")));
                showA.setText("數量");
            }
            if(show.getInt("countB") != 0){
                if("".equals(TypeA.getText())) {
                    TypeA.setText(show.getString("TypeB"));
                    countA.setText(Integer.toString(show.getInt("countB")));
                    showA.setText("數量");
                }
                else{
                    TypeB.setText(show.getString("TypeB"));
                    countB.setText(Integer.toString(show.getInt("countB")));
                    showB.setText("數量");
                }
            }
            if(show.getInt("countC") != 0){
                if("".equals(TypeA.getText())) {
                    TypeA.setText(show.getString("TypeC"));
                    countA.setText(Integer.toString(show.getInt("countC")));
                    showA.setText("數量");
                }
                else if("".equals(TypeB.getText())){
                    TypeB.setText(show.getString("TypeC"));
                    countB.setText(Integer.toString(show.getInt("countC")));
                    showB.setText("數量");
                }
                else{
                    TypeC.setText(show.getString("TypeC"));
                    countC.setText(Integer.toString(show.getInt("countC")));
                    showC.setText("數量");
                }
            }
            if(show.getInt("countD") != 0){
                if("".equals(TypeA.getText())) {
                    TypeA.setText(show.getString("TypeD"));
                    countA.setText(Integer.toString(show.getInt("countD")));
                    showA.setText("數量");
                }
                else if("".equals(TypeB.getText())){
                    TypeB.setText(show.getString("TypeD"));
                    countB.setText(Integer.toString(show.getInt("countD")));
                    showB.setText("數量");
                }
                else if("".equals(TypeC.getText())){
                    TypeC.setText(show.getString("TypeD"));
                    countC.setText(Integer.toString(show.getInt("countD")));
                    showC.setText("數量");
                }
                else{
                    TypeD.setText(show.getString("TypeD"));
                    countD.setText(Integer.toString(show.getInt("countD")));
                    showD.setText("數量");
                }
            }
            if(show.getInt("countE") != 0) {
                if ("".equals(TypeA.getText())) {
                    TypeA.setText(show.getString("TypeE"));
                    countA.setText(Integer.toString(show.getInt("countE")));
                    showA.setText("數量");
                }
                else if ("".equals(TypeB.getText())) {
                    TypeB.setText(show.getString("TypeE"));
                    countB.setText(Integer.toString(show.getInt("countE")));
                    showB.setText("數量");
                }
                else if ("".equals(TypeC.getText())) {
                    TypeC.setText(show.getString("TypeE"));
                    countC.setText(Integer.toString(show.getInt("countE")));
                    showC.setText("數量");
                }
                else if ("".equals(TypeD.getText())) {
                    TypeD.setText(show.getString("TypeE"));
                    countD.setText(Integer.toString(show.getInt("countE")));
                    showD.setText("數量");
                }
                else {
                    TypeE.setText(show.getString("TypeE"));
                    countE.setText(Integer.toString(show.getInt("countE")));
                    showE.setText("數量");
                }
            }
            if(show.getInt("countF") != 0) {
                if ("".equals(TypeA.getText())) {
                    TypeA.setText(show.getString("TypeF"));
                    countA.setText(Integer.toString(show.getInt("countF")));
                    showA.setText("數量");
                }
                else if ("".equals(TypeB.getText())) {
                    TypeB.setText(show.getString("TypeF"));
                    countB.setText(Integer.toString(show.getInt("countF")));
                    showB.setText("數量");
                }
                else if ("".equals(TypeC.getText())) {
                    TypeC.setText(show.getString("TypeF"));
                    countC.setText(Integer.toString(show.getInt("countF")));
                    showC.setText("數量");
                }
                else if ("".equals(TypeD.getText())) {
                    TypeD.setText(show.getString("TypeF"));
                    countD.setText(Integer.toString(show.getInt("countF")));
                    showD.setText("數量");
                }
                else if ("".equals(TypeE.getText())) {
                    TypeE.setText(show.getString("TypeF"));
                    countE.setText(Integer.toString(show.getInt("countF")));
                    showE.setText("數量");
                }
                else {
                    TypeF.setText(show.getString("TypeF"));
                    countF.setText(Integer.toString(show.getInt("countF")));
                    showF.setText("數量");
                }
            }
        }
    }
}
