package com.example.downloadmanagerexample;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private DownloadManager downloadManager;
	private long queue;
	private ImageView imageView;
	private Button btnDownload;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView = (ImageView) findViewById(R.id.imageView);
		btnDownload = (Button) findViewById(R.id.btnDownload);

		btnDownload.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
		Request request = new Request(
				Uri.parse("http://www.wired.com/images_blogs/gadgetlab/2010/03/_mg_9045.jpg"));

		registerReceiver(new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				if (intent.getAction().equals(
						DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
					Query query = new Query();
					query.setFilterById(queue);
					Cursor cursor = downloadManager.query(query);

					cursor.moveToFirst();

					if (cursor.getInt(cursor
							.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
						String filePathUri = cursor
								.getString(cursor
										.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
						Log.i("vipul", "File Path is " + filePathUri);
						imageView.setImageURI(Uri.parse(filePathUri));
					}

				}
			}
		}, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

		queue = downloadManager.enqueue(request);
		downloadManager.enqueue(request);

	}
}
