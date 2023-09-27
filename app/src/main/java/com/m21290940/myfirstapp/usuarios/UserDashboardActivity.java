package com.m21290940.myfirstapp.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.m21290940.myfirstapp.R;
import com.m21290940.myfirstapp.usuarios.model.Usuario;
import com.m21290940.myfirstapp.usuarios.repository.UsersRepository;

public class UserDashboardActivity extends AppCompatActivity {

    private UsersRepository ur;
    private Usuario userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        ur = UsersRepository.getInstance();

        String user, pass;
        user = getIntent().getStringExtra("usuario");
        pass = getIntent().getStringExtra("pass");

        userInfo = ur.getRegisteredUsers().get(user).get(pass);

        ShapeableImageView ivUserImage = findViewById(R.id.ivUserImage);
        if ( userInfo.getGenero() == 'h' )
            ivUserImage.setImageResource(R.drawable.human_man);
        else
            ivUserImage.setImageResource(R.drawable.human_woman);


        TextView tvUserUsuario = findViewById(R.id.tvUserUsuario);
        TextView tvUserNombre = findViewById(R.id.tvUserNombre);
        TextView tvUserEmail = findViewById(R.id.tvUserEmail);
        TextView tvUserEdad = findViewById(R.id.tvUserEdad);

        tvUserUsuario.setText( userInfo.getUsuario() );
        tvUserNombre .setText( userInfo.getNombre() );
        tvUserEmail  .setText( userInfo.getEmail() );
        tvUserEdad   .setText( userInfo.getEdad() + " ".concat( getString(R.string.tvUserEdadComplement) ) );
    }
}