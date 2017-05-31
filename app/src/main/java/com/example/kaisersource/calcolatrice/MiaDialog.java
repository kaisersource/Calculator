package com.example.kaisersource.calcolatrice;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;





/**
 * Created by kaisersource on 13/04/17.
 */

public class MiaDialog extends DialogFragment {



    public static void alert_msg(Context c, String title, String message) {
        AlertDialog.Builder alert;
        alert = new AlertDialog.Builder(c);
        alert.setTitle("Are you sure to exit?");

        //ora sono qui

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which) {
                android.os.Process.killProcess(android.os.Process.myPid());

            }
        });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //dialog.cancel();

                        dialog.dismiss();

                    }
                });
        alert.create();
        alert.show();


    }

}

