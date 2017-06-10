package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wsiiz.footballclient.R;


public class LoginFragment extends Fragment {

    private EditText etEmail, etPassword;
    private Button btnConfirm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Log.i("hello","LoginFragment");
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etPassword = (EditText) view.findViewById(R.id.etPassword);
        btnConfirm = (Button) view.findViewById(R.id.btnLoginSign);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( etEmail.getText().toString().length() == 0 ){
                    etEmail.setError( "E-mail is required!" );
                }
                if (!etEmail.getText().toString().contains("@")) {
                    etEmail.setError( "It's not an E-mail" );
                }
                if (etPassword.getText().toString().length() == 0 ) {
                    etPassword.setError("Type password");
                }
                if (etEmail.getError() == null && etPassword.getError() == null) {
                    Log.i("Error","OK");
                    //perform login logic
                } else {
                    Toast.makeText(getActivity(),"Fix all input errors",Toast.LENGTH_SHORT).show();
                }


            }
        });



        return view;
    }

}
