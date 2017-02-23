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
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;
import br.com.brasilcardfacil.www.brasilcardfacil.view.ActiveHealthDetailsActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.OfferDetailsActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.PartnerDetailsActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService{

    String title, body, activity, db, child;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        title = remoteMessage.getNotification().getTitle();
        body = remoteMessage.getNotification().getBody();
        activity = remoteMessage.getData().get(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE);
        db = remoteMessage.getData().get(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE);
        child = remoteMessage.getData().get(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD);

        sendNotification();
    }

    private void sendNotification() {
        Intent intent;

        switch (activity) {
            case FirebaseHelper.FIREBASE_NOTIFICATION_TYPE_PARTNER:
                intent = new Intent(this, PartnerDetailsActivity.class);
                intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE, db);
                intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD, child);
                break;
            case FirebaseHelper.FIREBASE_NOTIFICATION_TYPE_OFFER:
                intent = new Intent(this, OfferDetailsActivity.class);
                intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE, db);
                intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD, child);
                break;
            case FirebaseHelper.FIREBASE_NOTIFICATION_TYPE_UPDATE:
                try {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Utility.APP_PACKAGE_NAME));
                } catch (android.content.ActivityNotFoundException anfe) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="
                            + Utility.APP_PACKAGE_NAME));
                }
                break;
            default:
                intent = new Intent(this, ActiveHealthDetailsActivity.class);
                intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE, db);
                intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD, child);
                break;
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(getNotificationIcon())
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    private int getNotificationIcon() {

        boolean useWhiteIcon = (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP);
        return useWhiteIcon ? R.drawable.brasilcard_icon_notification : R.mipmap.ic_launcher;
    }
}
