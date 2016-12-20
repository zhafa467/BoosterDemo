package com.zhafa467.boosterdemo.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.zhafa467.boosterdemo.R;
import com.zhafa467.boosterdemo.ui.activities.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fan zhang on 16/12/21.
 */

public class SubmissionFragment extends Fragment {

    private int score = 0;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etPhone)
    EditText etPhone;

    @OnClick(R.id.btnSubmit)
    public void onSubmitButtonClick() {
        String name, email, phone;
        if (etName.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Name is empty!", Toast.LENGTH_LONG).show();
            return;
        } else
            name = etName.getText().toString();
        if (etEmail.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Email is empty!", Toast.LENGTH_LONG).show();
            return;
        } else
            email = etEmail.getText().toString();
        if (etPhone.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Phone is empty!", Toast.LENGTH_LONG).show();
            return;
        } else
            phone = etPhone.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "me@example.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nEmail" + email + "\nPhone:" + phone + "\nScore:" + score);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submission, container, false);
        ButterKnife.bind(this, view);
        score = getArguments().getInt(MainActivity.SCORE);
        return view;
    }
}
