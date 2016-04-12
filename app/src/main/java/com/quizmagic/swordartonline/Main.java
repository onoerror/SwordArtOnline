package com.quizmagic.swordartonline;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity
implements DialogInterface.OnClickListener, AccountNumber.CallBack{


    private TextView m_tv_message;
    private int loginCount;

    @Override
    public void call(CharSequence username,int which){
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                loginCount++;
                m_tv_message.setText("次數"+loginCount+"歡迎光臨");
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                m_tv_message.setText("登入取消");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public int getLoginCount(){
        return loginCount;
    }

    public void setLoginCount(int loginCount){
        this.loginCount = loginCount;
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
                .setPositiveButton("男", listener)
                .setNegativeButton("女", listener)
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

    public void clickAlertDialogMultiChoice(View view) {
        final String[] rstorince = getResources().getStringArray(R.array.rstorince);
        final boolean[] selected = new boolean[rstorince.length];
        new AlertDialog.Builder(this)
                .setTitle("命運")
                .setMultiChoiceItems(rstorince,selected,new
                DialogInterface.OnMultiChoiceClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog,int which,boolean isChecked){
                        selected[which] = isChecked;
                    }
                })
                .setPositiveButton("確定",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        StringBuilder result = new StringBuilder();

                        for(int i = 0;i<selected.length;i++){
                            if(selected[i]){
                                result.append(rstorince[i]).append("\n");
                            }
                        }
                        m_tv_message.setText(result);
                    }
                })
                .setNegativeButton("取消",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        m_tv_message.setText("請繼續閱讀");
                    }
                })
                .show();
    }


    private int mChoice;

    public void clickAlertDialogSingleChoice(View view) {
        final String[] name = getResources().getStringArray(R.array.name);
        new AlertDialog.Builder(this)
                .setTitle("選一個老婆")
                .setSingleChoiceItems(name, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mChoice = which;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText(name[mChoice]);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("請繼續閱讀");
                    }
                })
                .show();
    }

    public void clickMyDialogFragment(View view) {

        DialogFragment dialog = new AccountNumber();

        dialog.show(getSupportFragmentManager(),"AccountNumber");
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
