package com.Android.StatusBar;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

public class StatusService extends IntentService {
	private static final String TAG="StatusService";
	public StatusService() {
		super("StatusService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {//����ʵ��
		// TODO Auto-generated method stub
		Log.i(TAG, "��ʼ����...");
		showNotification();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showNotification() {
		Notification notification = new Notification(R.drawable.ic_launcher, "��ʼ����...", System.currentTimeMillis());//�������ϵ���Ϣ
		Intent intend = new Intent(this, StatusBarActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intend , PendingIntent.FLAG_UPDATE_CURRENT);
		notification.setLatestEventInfo(this, "����", "����������", contentIntent );//����
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//������״̬����ʾ����
		manager.notify(0, notification);
	}

}
