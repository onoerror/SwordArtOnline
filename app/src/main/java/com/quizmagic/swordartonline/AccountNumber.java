package com.quizmagic.swordartonline;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountNumber extends android.support.v4.app.DialogFragment {

    private EditText m_et_username;

    public AccountNumber() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_account_number,null);

        m_et_username = (EditText)view.findViewById(R.id.et_username);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = "歡迎光臨" + m_et_username.getText();
                        ((TextView)getActivity().findViewById(R.id.tv_message)).setText(message);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((TextView)getActivity().findViewById(R.id.tv_message)).setText("登入取消");
                    }
                });
        return builder.create();
    }
}
