package com.m21290940.myfirstapp.usuarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.m21290940.myfirstapp.R;
import com.m21290940.myfirstapp.usuarios.model.Usuario;
import com.m21290940.myfirstapp.usuarios.repository.UsersRepository;

public class UserDashboardActivity extends AppCompatActivity {

    private UsersRepository ur;
    private Usuario userInfo;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        ur = UsersRepository.getInstance();

        String user, pass;
        user = getIntent().getStringExtra("usuario");
        pass = getIntent().getStringExtra("pass");

        userInfo = ur.getRegisteredUsers().get(user).get(pass);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ShapeableImageView ivUserFoto = findViewById(R.id.ivUserFoto);
        if ( userInfo.getGenero() == 'h' ){
            ivUserFoto.setImageResource(R.drawable.human_man);
        }
        else {
            ivUserFoto.setImageResource(R.drawable.human_woman);
        }


        TextView tvUserUsuario = findViewById(R.id.tvUserUsuario);
        TextView tvUserNombre = findViewById(R.id.tvUserNombre);
        TextView tvUserEmail = findViewById(R.id.tvUserEmail);
        TextView tvUserEdad = findViewById(R.id.tvUserEdad);

        tvUserUsuario.setText( userInfo.getUsuario() );
        tvUserNombre .setText( userInfo.getNombre() );
        tvUserEmail  .setText( userInfo.getEmail() );
        tvUserEdad   .setText( userInfo.getEdad() + " ".concat( getString(R.string.tvUserEdadComplement) ) );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if ( item.getItemId() == R.id.miBorrar ){

        } else if( item.getItemId() == R.id.miinfo ) {
            Toast.makeText(this,
                    "Presionaste botón más información",
                    Toast.LENGTH_LONG).show();
        } else if( item.getItemId() == R.id.miSetting ){

        }

        return super.onOptionsItemSelected(item);
    }
}