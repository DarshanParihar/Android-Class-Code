package com.example.dialogfragmentexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new Builder(getActivity());
		builder.setMessage("Sample Dialog");
		builder.setTitle("Sample Title");
		builder.setPositiveButton("OK", null);
		return builder.create();
	}
}
