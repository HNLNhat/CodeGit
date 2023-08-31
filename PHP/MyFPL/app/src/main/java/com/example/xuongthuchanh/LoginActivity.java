package com.example.xuongthuchanh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    GoogleSignInClient mGogleSignInClient;
    public static final int RC_SIGN_IN = 1;
    EditText edtCoSo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGogleSignInClient = GoogleSignIn.getClient(this, gso);
        //Ánh xạ
        EditText edtCoSo = findViewById(R.id.edtCoSo);
        SignInButton btnSignIn = findViewById(R.id.btnSignInGG);

        //Bắt sự kiện edtCoSo
        edtCoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] selectCoSo = {"Hà Nội", "Hồ Chí Minh", "Cần Thơ", "Đà Nẵng", "Quy Nhơn"};
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Chọn cơ sở");
                builder.setItems(selectCoSo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        edtCoSo.setText(selectCoSo[i]);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        //Bắt sự kiện SignIn
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInReSult(task);
        }
    }

    private void handleSignInReSult(Task<GoogleSignInAccount> task) {

        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            //Đăng nhập thành công

        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private void updateUI(GoogleSignInAccount account) {
        if (account != null) {
            String email = account.getEmail();
            String name = account.getDisplayName();
            String picture = String.valueOf(account.getPhotoUrl());
            String tenCoSo = edtCoSo.getText().toString().trim();

            if (isValidFptEmail(email) && tenCoSo.equals("Hồ Chí Minh")) {
                //Lưu thông tin vào data của thiết bị
                SharedPreferences.Editor editor = getSharedPreferences("usersdata", MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.putString("picture", picture);
                editor.putString("tenCoSo", tenCoSo);
                editor.apply();
                //Lấy thông tin và hiển thị
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("picture", picture);
                intent.putExtra("tenCoSo", tenCoSo);
                startActivity(intent);
                // Lấy là get hiển thị là set
            } else {
                Toast.makeText(this, "FPT email", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isValidFptEmail(String email) {
        // kiểm tra email có hợp lệ không

        if(email == null || email.isEmpty()){
            return false;
        }else{
            // kiểm tra email có kêt thúc bằng đuôi fpt
            if(email.endsWith("@fpt.edu.vn")){
                return  true;
            }
        }
        return  false;
    }
}
