package com.piercestudio.dayte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//		View decorView = getWindow().getDecorView();
//		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//		decorView.setSystemUiVisibility(uiOptions);
//		ActionBar actionBar = getActionBar();
//		actionBar.hide();
//		log("gotactionbar");



		final TextView resultView = (TextView) findViewById(R.id.resultTextView);
        final EditText editTextField = (EditText) findViewById(R.id.editText);
		final ImageButton gaussImageButton = (ImageButton) findViewById(R.id.imageButton);
		final TextView whoIsThat = (TextView) findViewById(R.id.whoIsThatView);

		overridePendingTransition (0, 0);

 final OnClickListener switchToGaussBioListener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			log("switchtogaussbio");
			switchToGaussBio();
			}
	};

		gaussImageButton.setOnClickListener(switchToGaussBioListener);
		whoIsThat.setOnClickListener(switchToGaussBioListener);

        editTextField.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
				log("edittextfiledfocuschange");
                if (!hasFocus) {
                    Log.i(testForErrors.E, "Lost focus, getting it back");
                    v.requestFocus();
                }
            }
        });

        editTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				log("closingthekeyboard");
                if (actionId == EditorInfo.IME_ACTION_DONE) {

					InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
					imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

						resultView.callOnClick();

                    return true;
                }
                return false;
            }
        });

		//This runs the error checking, gauss algorithm and output.
        resultView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                log("resultclick");
                String mArray[] = {editTextField.getText().toString(), "error"};

                //error testing here:
                mArray = testForErrors.check(mArray);
				log("testforerrorscomplete");

                    if (mArray[0].length() == 0) {
                        //Intentionally blank so that touching the button does not give errors on pushing the button accidently.
                    } else {
                        switch (mArray[1]){

                        case "error":
                            resultView.setText(mArray[0]  + "\n Is not in mm/dd/yyyy format.\n");
                            editTextField.requestFocus();
                            break;

                        case "Leap Year":
                            resultView.setText(" " + mArray[0].substring(6) + " is not a leap year.\n There is no Feb 29.");
                            editTextField.requestFocus();
                            break;

                        case "too short":
                            resultView.setText(" Your entry is too short\n It needs to be in\n mm/dd/yyyy\n format.");
                            editTextField.requestFocus();
                            break;

                        case "too long":
                            resultView.setText(" Your entry is too long\n It needs to be in\n mm/dd/yyyy\n format.");
                            editTextField.requestFocus();
                            break;

                        case "year error":
                            resultView.setText(" I can only calculate dates\n between 1700 and 2600.");
                            editTextField.requestFocus();
                            break;

                        case "month out of bounds":
                            resultView.setText(" I can only calculate months\n between 01 and 12.");
                            break;

                        case "days error":
                            resultView.setText(" There aren't that number of\n days in this month.");
                            break;

                    }

                }
                //error free

                    if ((mArray[1].equals("PASS"))) {
                        log("pass to gauss");
                        if (mArray[0].equals("04/30/1777")){
                            resultView.setText(mArray[0] + " is " + GuassAlgorithm.getDate(mArray[0]) + "!" + "\nHappy Birthday Carl!");
                        }
                        else {
                            resultView.setText(mArray[0] + " is " + GuassAlgorithm.getDate(mArray[0]) + "!");
                        }

                    }
                    editTextField.setText(null);

                }
            });

    }

	public void switchToGaussBio(){
		Intent intent = new Intent(MainActivity.this, GaussBio.class);
		startActivity(intent);
	}

    @Override
    public void onPause(){
        super.onPause();
        Log.i("close", "onPause");

        final TextView resultView = (TextView) findViewById(R.id.resultTextView);
        resultView.setText("The day will show up here :)");

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("close", "onResume");

        final TextView resultView = (TextView) findViewById(R.id.resultTextView);
        resultView.setText("The day will show up here :)");

			View decorView = getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
			//ActionBar actionBar = getActionBar();
			//actionBar.hide();

		overridePendingTransition (0, 0);
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i("close", "onStop");

        final TextView resultView = (TextView) findViewById(R.id.resultTextView);
        resultView.setText("The day will show up here :)");

    }

	public void log(String s){
		Log.i("string", "string");
	}

}
    //I could also just declare the method here. Note: wouldn't have access to "final Buttons" - I can't make them public
// TODO: Make keyboard disappear after hitting enter
// Fix the Title text so it doesn't move down
// Add a button that says "start over" that is a nice color too
