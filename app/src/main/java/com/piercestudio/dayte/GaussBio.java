package com.piercestudio.dayte;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.piercestudio.dayte.R;

public class GaussBio extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		overridePendingTransition (0, 0);
		setContentView(R.layout.activity_gauss_bio);

		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
		//ActionBar actionBar = getActionBar();
		//actionBar.hide();


		//TextView htmllLinkView = (TextView) findViewById(R.id.link);
		//htmllLinkView.setText(Html.fromHtml("<a href=http://www.en.wikipedia.org/wiki/Carl_Friedrich_Gauss> Read more about Gauss on wikipedia"));
		//htmllLinkView.setMovementMethod(LinkMovementMethod.getInstance());


		TextView scrollingBio = (TextView) findViewById(R.id.bio);
		scrollingBio.setMovementMethod(new ScrollingMovementMethod());
		scrollingBio.setScrollBarFadeDuration(10);

		final ImageButton backToMainButton = (ImageButton) findViewById(R.id.backToMain);

		backToMainButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(GaussBio.this,MainActivity.class);
				startActivity(intent);
			}
		});

		TextView inventorTextView = (TextView) findViewById(R.id.inventorTextViewButton);

		inventorTextView.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(GaussBio.this,MainActivity.class);
				startActivity(intent);
			}
		});




	}

	@Override
	protected void onResume()
	{
		super.onResume();
		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
//		ActionBar actionBar = getActionBar();
//		actionBar.hide();

		overridePendingTransition (0, 0);
	}
}