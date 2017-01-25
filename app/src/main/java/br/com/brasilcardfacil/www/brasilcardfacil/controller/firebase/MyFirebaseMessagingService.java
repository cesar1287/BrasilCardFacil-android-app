package br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.view.ActiveHealthDetailsActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.OfferDetailsActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.PartnerDetailsActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService{

    String title, body, activity, db, child;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        title = remoteMessage.getNotification().getTitle();
        body = remoteMessage.getNotification().getBody();
        activity = remoteMessage.getData().get("type_notification");
        db = remoteMessage.getData().get("db");
        child = remoteMessage.getData().get("child");

        sendNotification();
    }

    private void sendNotification() {
        Intent intent;

        switch (activity) {
            case "partner":
                intent = new Intent(this, PartnerDetailsActivity.class);
                intent.putExtra("db", db);
                intent.putExtra("child", child);
                break;
            case "offer":
                intent = new Intent(this, OfferDetailsActivity.class);
                intent.putExtra("db", db);
                intent.putExtra("child", child);
                break;
            default:
                intent = new Intent(this, ActiveHealthDetailsActivity.class);
                intent.putExtra("db", db);
                intent.putExtra("child", child);
                break;
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
