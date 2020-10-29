//package com.example.footballnews.activity.User;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.footballnews.R;
//import com.example.footballnews.model.Users;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class Login extends AppCompatActivity {
//    Button btback, bttoregister, btlogin;
//    TextView edemail, edpass, edname, edgender, edlocation;
//    FirebaseAuth mAuthlogin;
////    private static final String USER = "users";
////    private static final String TAG = "Login";
//    private Users users;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        btback = (Button) findViewById(R.id.idbacklogin);
//        btlogin = (Button) findViewById(R.id.bttouserprofile);
//        bttoregister = (Button) findViewById(R.id.logintoregister);
//        edemail = (EditText) findViewById(R.id.edemaillogin);
//        edpass = (EditText) findViewById(R.id.edpasslogin);
//
//        btback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//        bttoregister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Login.this, Register.class));
//            }
//        });
////        mAuthlogin = FirebaseAuth.getInstance();
////        btlogin.setOnClickListener(new View.OnClickListener() {
////
////            @Override
////            public void onClick(View v) {
////                final String email = edemail.getText().toString().trim();
////                final String password = edpass.getText().toString().trim();
////                if (email.isEmpty()) {
////                    edemail.setError("Hãy nhập Email của bạn");
////                    edemail.requestFocus();
////                    return;
////                } else if (password.isEmpty()) {
////                    edpass.setError("Hãy nhập PassWorld của bạn");
////                    edpass.requestFocus();
////                    return;
////                } else if (password.length() < 6) {
////                    edpass.setError("Mât khẩu phải có ít nhất 6 kí tự");
////                    edpass.requestFocus();
////                    return;
////                }
////                mAuthlogin.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
////                    @Override
////                    public void onComplete(@NonNull Task<AuthResult> task) {
////
////                        if (task.isSuccessful()) {
////                            Log.d(TAG, "Đăng nhập thành công");
////                            FirebaseUser user = mAuthlogin.getCurrentUser();
////                            updateUser(user);
////                        } else {
////                            Log.v(TAG, "Đămg nhập thất bại", task.getException());
////                            Toast.makeText(Login.this, "Đăng nhập không thành công, hãy thử lại", Toast.LENGTH_LONG).show();
////
////                        }
////                    }
////                });
////            }
////        });
//    }
////        @Override
////        public void onStart() {
////            super.onStart();
////            FirebaseUser user = mAuthlogin.getCurrentUser();
////            if (user != null) {
////                updateUser(user);
////            }
////        if (mAuthlogin.getCurrentUser() == null) {
////            edemail.setText("Tài khoản");
////            btlogout.setText("Đăng nhập");
////
////
////        } else {
////            edemail.setText(mUser.getEmail());
////            btlogout.setText("Đăng Xuất");
////            btlogout.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    FirebaseAuth.getInstance().signOut();
////                    startActivity(new Intent(Login.this, Login.class));
////                    btlogout.setText("Đăng nhập");
////                    edemail.setText("Tài Khoản");
////
////                }
////            });
////        }
//
//
////    private void updateUser(FirebaseUser user) {
////        Intent intent = new Intent(this,Register.class);
////        intent.putExtra("email", user.getEmail());
////        startActivity(intent);
////    }
//}