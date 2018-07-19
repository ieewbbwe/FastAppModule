package com.mobile_core.base.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

import com.mobile_core.base.BuildConfig;
import com.mobile_core.base.R;

import java.util.List;

/**
 * Created by picher on 2018/7/6.
 * Describe：Create Notification Channels for adaptive Android8.0
 * https://developer.android.com/reference/android/app/NotificationChannel?hl=zh-cn
 */

public class NotificationManager {

    public static final String SILENCE_PUSH_CHANNEL = BuildConfig.APPLICATION_ID + ".silent";
    public static final String SOUND_PUSH_CHANNEL = BuildConfig.APPLICATION_ID  + ".sound";

    private static NotificationManager mInstance = null;
    private NotifyStrategy notifyStrategy = null;

    private NotificationManager(){
        notifyStrategy = new NotifyHelper();

    }

    public void init(Context context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createSilenceChannel(context);
            createSoundChannel(context);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createSoundChannel(@NonNull Context context) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(SOUND_PUSH_CHANNEL, context.getResources().getString(R.string.channel_sound_name),
                android.app.NotificationManager.IMPORTANCE_HIGH);
        channel.setShowBadge(true);
        channel.enableVibration(true);
        channel.setVibrationPattern(new long[200]);
        AudioAttributes att = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        channel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), att);
        channel.enableLights(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createSilenceChannel(@NonNull Context context) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(SILENCE_PUSH_CHANNEL, context.getResources().getString(R.string.channel_silence_name),
                android.app.NotificationManager.IMPORTANCE_HIGH);
        channel.setShowBadge(true);
        channel.enableVibration(true);
        channel.setVibrationPattern(new long[200]);
        channel.setSound(null, null);
        channel.enableLights(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isChannelCrated(@NonNull Context context, @NonNull String channelID) {
        if (!TextUtils.isEmpty(channelID)) {
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                List<NotificationChannel> channels = notificationManager.getNotificationChannels();
                for (NotificationChannel channel : channels) {
                    if (TextUtils.equals(channelID,channel.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static NotificationManager getInstance(){
        if(mInstance == null){
            synchronized (NotificationManager.class){
                mInstance = new NotificationManager();
            }
        }
        return mInstance;
    }

    private void notify(Context context, String title, String content, int smallIcon, PendingIntent action, String tag, int id){
        if(notifyStrategy != null){
            notifyStrategy.notify(context,title,content,smallIcon,action, tag, id);
        }
    }

    private void notifySimple(Context context, String title, String label,int smallIcon){
        if(notifyStrategy != null){
            notifyStrategy.notifySimple(context,title,label,smallIcon);
        }
    }

    private void cancel(String tag, int id){
        if(notifyStrategy != null){
            notifyStrategy.cancel(tag,id);
        }
    }
}
