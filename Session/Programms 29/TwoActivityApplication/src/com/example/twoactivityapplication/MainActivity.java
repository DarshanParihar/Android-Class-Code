package com.example.twoactivityapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnCalculate;
	private EditText txtNum1, txtNum2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Main Activity");
		setContentView(R.layout.activity_main);

		btnCalculate = (Button) findViewById(R.id.btnCalculate);
		btnCalculate.setOnClickListener(this);

		txtNum1 = (EditText) findViewById(R.id.txtNum1);
		txtNum2 = (EditText) findViewById(R.id.txtNum2);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		intent.putExtra("num1", Integer.parseInt(txtNum1.getText().toString()));
		intent.putExtra("num2", Integer.parseInt(txtNum2.getText().toString()));
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				int answer = data.getIntExtra("answer", 0);
				Toast.makeText(this, "Answer is " + answer, Toast.LENGTH_SHORT)
						.show();
			} else {
				Toast.makeText(this, "Please enter positive number",
						Toast.LENGTH_SHORT).show();
			}
		}
	}

}
