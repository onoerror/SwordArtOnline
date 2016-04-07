package com.quizmagic.swordartonline;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity
implements DialogInterface.OnClickListener{


    private TextView m_tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        m_tv_message = (TextView)findViewById(R.id.tv_message);
    }

    //按下主畫面按鈕
    public void clickAlertDialog(View view){
        new AlertDialog.Builder(this)
                .setMessage("2022年，大廠牌電子機械製造商" +
                        "「ARGUS」發表了－「NERvGear」" +
                        "－能連結虛擬世界的機器。" +
                        "完全且普及的虛擬實境終於能夠實現。")
                .setPositiveButton("明白了", this)//將按鈕點擊事件委託給當前的Activity(居中協調)
                .show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        m_tv_message.setText("請繼續閱讀");
    }

    public void clickAlertDialogYesNo(View view){
        AlertDialogYesNoListener listener = new AlertDialogYesNoListener();
        new AlertDialog.Builder(this)
                .setMessage("你的性別為何")
                .setPositiveButton("男",listener)
                .setNegativeButton("女",listener)
                .show();
    }

    public void clickAlertDialogYesNoCancel(View view) {
        new AlertDialog.Builder(this)
                .setMessage("請選擇你的職業")
                .setPositiveButton("劍聖", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("你將成為新一代劍聖");
                    }
                })
                .setNegativeButton("暗黑刀使", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("黑暗降臨無人能敵");
                    }
                })
                .setNeutralButton("雙刃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("無法透漏更多");
                    }
                })
                .show();
    }

    public void clickAlertDialogItems(View view) {
        final String[] response = getResources().getStringArray(R.array.response);
        new AlertDialog.Builder(this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar)
                .setTitle("性格分析")
                .setItems(response,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        m_tv_message.setText(response[which]);
                    }
                })
                .show();
    }

    private class AlertDialogYesNoListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog,int wich){
            switch (wich){
                case DialogInterface.BUTTON_POSITIVE:
                    m_tv_message.setText("先生，請繼續閱讀");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    m_tv_message.setText("小姐，請繼續閱讀");
                    break;
            }
        }
    }
}
