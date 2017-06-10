package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wsiiz.footballclient.R;

public class RegisterFragment extends Fragment {

    private EditText etName, etEmail, etTeam, etPasswd, etConfirmPasswd;
    private Button btnReg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        etName = (EditText) view.findViewById(R.id.etName);
        etEmail = (EditText) view.findViewById(R.id.etMailReg);
        etTeam = (EditText) view.findViewById(R.id.etFavorTeam);
        etName = (EditText) view.findViewById(R.id.etPasswdReg);
        etName = (EditText) view.findViewById(R.id.etRepeatReg);
        btnReg = (Button) view.findViewById(R.id.btnReg);
        return view;
    }


}
