package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wsiiz.footballclient.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterFragment extends Fragment {

    private EditText etName, etEmail, etTeam, etPasswd, etConfirmPasswd;
    private Button btnReg;
    boolean validResult = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        etName = (EditText) view.findViewById(R.id.etName);
        etEmail = (EditText) view.findViewById(R.id.etMailReg);
        etTeam = (EditText) view.findViewById(R.id.etFavorTeam);
        etPasswd = (EditText) view.findViewById(R.id.etPasswdReg);
        etConfirmPasswd = (EditText) view.findViewById(R.id.etRepeatReg);
        btnReg = (Button) view.findViewById(R.id.btnReg);

        final List<EditText> views = new ArrayList<>();
        views.addAll(Arrays.asList(etConfirmPasswd,etEmail,etName,etPasswd,etTeam));

        btnReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getActivity().getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                );
                //performing user input validation
                if (checkIfEmpty(etName)) {
                    etName.setError("Required field");
                }
                if (checkIfEmpty(etEmail)) {
                    etEmail.setError("Required field");
                }
                if (!etEmail.getText().toString().contains("@")) {
                    etEmail.setError("Not valid email");
                }
                if (checkIfEmpty(etPasswd)) {
                    etPasswd.setError("Required field");
                }
                if (checkIfEmpty(etConfirmPasswd)) {
                    etConfirmPasswd.setError("Required field");
                }
                if (!etPasswd.getText().toString().equals(etConfirmPasswd.getText().toString())) {
                    etConfirmPasswd.setError("Password's do not match");
                }
                for (EditText et : views) {
                   if (et.getError() == null) {
                       validResult = false;
                       break;
                   }
                }
                if (validResult == true) {
                    //perform registr logic
                } else {
                    Toast.makeText(getActivity(),"Fix all fields to continue",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public boolean checkIfEmpty (EditText editTextField) {
        if (editTextField.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


}
