//package com.example.footballnews.activity.User;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.footballnews.R;
//import com.example.footballnews.activity.MainActivity;
//import com.example.footballnews.model.Users;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class Register extends AppCompatActivity {
//    Button btbackuser2, btregister, bttologin, bttomain;
//    EditText edemail, edpass, ednameuser, edgioitinh, edlocation;
//    FirebaseAuth firebaseAuth;
//    FirebaseUser firebaseUser;
//    ProgressBar progressBar;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
////    private static final String USER = "users";
//    private static final String TAG = "Register";
//    private Users users;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//        btbackuser2 = (Button) findViewById(R.id.idbackuser2);
//        edemail = (EditText) findViewById(R.id.edemailregister);
//        edpass = (EditText) findViewById(R.id.edpassregister);
//        ednameuser = (EditText) findViewById(R.id.ednameregister);
//        edgioitinh = (EditText) findViewById(R.id.edsexregister);
//        edlocation = (EditText) findViewById(R.id.edlocationregister);
//        bttomain = (Button) findViewById(R.id.bttomainregister);
//        progressBar = (ProgressBar) findViewById(R.id.progressregister);
//        btregister = (Button) findViewById(R.id.btregister);
//        bttologin = (Button) findViewById(R.id.bttologin);
//        bttomain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Register.this, MainActivity.class));
//            }
//        });
//        btbackuser2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//        firebaseDatabase = FirebaseDatabase.getInstance();
////        databaseReference = firebaseDatabase.getReference(USER);
////        firebaseAuth = FirebaseAuth.getInstance();
////        firebaseUser = firebaseAuth.getCurrentUser();
////
////        btregister.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String name = ednameuser.getText().toString();
////                String email = edemail.getText().toString();
////                String password = edpass.getText().toString();
////                String gender = edgioitinh.getText().toString();
////                String location = edlocation.getText().toString();
////                if (email.isEmpty()) {
////                    edemail.setError("Hãy nhập Email của bạn");
////                    edemail.requestFocus();
////                    return;
////                } else if (password.isEmpty()) {
////                    edpass.setError("Hãy nhập PassWorld của bạn");
////                    edpass.requestFocus();
////                    return;
////                }
////                else if (password.length() < 6) {
////                    edpass.setError("Mât khẩu phải có ít nhất 6 kí tự");
////                    edpass.requestFocus();
////                    return;
////                }
////                else if (name.isEmpty()&& gender.isEmpty() && location.isEmpty()) {
////                    Toast.makeText(Register.this,"Hãy điền đầy đủ thông tin",Toast.LENGTH_LONG).show();
////                    return;
////                }
////                users = new Users(name,email,password,gender,location);
////                progressBar.setVisibility(View.VISIBLE);
//////              registeruser(email,password);
////
////            }
////        });
////        bttologin.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                startActivity(new Intent(Register.this,Login.class));
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
////                }
////                else if (password.length() < 6) {
////                    edpass.setError("Mât khẩu phải có ít nhất 6 kí tự");
////                    edpass.requestFocus();
////                }
////                progressBar.setVisibility(View.VISIBLE);
////                signupuser(email,password);
////            }
////        });
////    }
//
////    private void signupuser(String email, String password) {
////        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
////            @Override
////            public void onComplete(@NonNull Task<AuthResult> task) {
////                if (task.isSuccessful()){
////                    Toast.makeText(Register.this,"Đăng nhập thành công",Toast.LENGTH_LONG).show();
////                    startActivity(new Intent(Register.this, User.class));
////
////                }
////                else {
////                    Toast.makeText(Register.this,"Đăng nhập không thành công, hãy thử lại"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
////
////                }
////            }
////        });
////    }
//
//
////    private void registeruser(String email, String password) {
////        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
////            @Override
////            public void onComplete(@NonNull Task<AuthResult> task) {
////                if (task.isSuccessful()) {
////                    Log.d(TAG,"Đăng kí thành công");
////                    FirebaseUser user = firebaseAuth.getCurrentUser();
////                    updateUser(user);
////                    progressBar.setVisibility(View.GONE);
////                } else {
////                    Log.w(TAG,"Đăng kí thất bại"+task.getException());
////                    Toast.makeText(Register.this,"Xảy ra lỗi",Toast.LENGTH_LONG).show();
////                }
////            }
////        });
////    }
////
////    private void updateUser(FirebaseUser users) {
////        String keyid = databaseReference.push().getKey();
////        databaseReference.child(keyid).setValue(users);
////        startActivity(new Intent(this,Login.class));
////    }
//    }
//}
