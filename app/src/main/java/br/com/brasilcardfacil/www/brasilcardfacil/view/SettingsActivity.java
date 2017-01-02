package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import br.com.brasilcardfacil.www.brasilcardfacil.R;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREF_NAME = "LoginActivityPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageButton btLogout = (ImageButton) findViewById(R.id.setting_btLogout);

        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);

                builder.setMessage(R.string.message_logout)
                        .setPositiveButton(R.string.yes_logout, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(SettingsActivity.this, R.string.msg_logout, Toast.LENGTH_SHORT).show();
                                Thread mThread = new Thread(){
                                    @Override
                                    public void run() {
                                        signOutFirebase();
                                        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        editor.clear();
                                        editor.apply();
                                        finish();
                                    }
                                };
                                mThread.start();
                            }
                        })
                        .setNegativeButton(R.string.no_logout, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                builder.show();
            }
        });
    }

    private void signOutFirebase() {
        FirebaseAuth.getInstance().signOut();
    }
}
