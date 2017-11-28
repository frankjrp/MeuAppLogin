package meuprimeiroapp.studio.com.meuapplogin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivityLogin extends AppCompatActivity {

    private Boolean btnFloatVisible = false;

    Switch btnSwitch;
    EditText btnEditText;
    EditText btnEditText2;
    FloatingActionButton floatBtn;
    FloatingActionButton floatBtn2;
    FloatingActionButton floatBtn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


    //vincula a variável criada ao objeto físico usando sua ID
        btnSwitch = findViewById(R.id.switch1);
        btnEditText = findViewById(R.id.editText);
        btnEditText2 = findViewById(R.id.editText1);
        floatBtn = findViewById(R.id.floatingActionButton);
        floatBtn2 = findViewById(R.id.floatingActionButton2);
        floatBtn3 = findViewById(R.id.floatingActionButton3);


        btnEditText.requestFocus();

    }



    public void alteraSwitch(View View) {
        if (btnSwitch.isChecked()) {
            btnSwitch.setChecked(false);
            AvisoLogin();
            //Toast.makeText(getApplicationContext(), "Alterado o switch", Toast.LENGTH_LONG).show();
        }

    }


    public void ClickbtnOk(View View) {

        if (btnSwitch.isChecked()) {

            AlertDialog aviso;
            aviso = new AlertDialog.Builder(this).create();
            aviso.setTitle("Aviso");
            aviso.setMessage("Realizado com sucesso! - On");
            Toast.makeText(getApplicationContext(), "Clicou em Ok", Toast.LENGTH_LONG).show();
            aviso.show();
        } else {
            AlertDialog aviso;
            aviso = new AlertDialog.Builder(this).create();
            aviso.setTitle("Aviso");
            aviso.setMessage("Realizado com sucesso! - Off");
            Toast.makeText(getApplicationContext(), "Clicou em Ok", Toast.LENGTH_LONG).show();
            aviso.show();
        }

    }

    public void OnClickFloatBtn(View View) {
        if (this.btnFloatVisible){
            //Esconder
            Animation animationHide = AnimationUtils.loadAnimation(this,R.anim.float_switch_hide);
            floatBtn2.startAnimation(animationHide);
            floatBtn3.startAnimation(animationHide);

            floatBtn2.setVisibility(View.GONE);
            floatBtn3.setVisibility(View.GONE);
            //floatBtn2.setClickable(false);
            //floatBtn3.setClickable(false);
            this.btnFloatVisible = false;
        }else{
            //Mostrar
            Animation animationShow = AnimationUtils.loadAnimation(this,R.anim.float_switch_show);
            floatBtn2.startAnimation(animationShow);
            floatBtn3.startAnimation(animationShow);

            floatBtn2.setVisibility(View.VISIBLE);
            floatBtn3.setVisibility(View.VISIBLE);
            //floatBtn2.setClickable(true);
            //floatBtn3.setClickable(true);
            this.btnFloatVisible = true;
        }

    }

    public void ClickLimpar(View View) {
        btnEditText.setText("");
        btnEditText2.setText("");
        btnSwitch.setChecked(false);
        btnEditText.requestFocus();

    }

    private AlertDialog aviso;

    private void AvisoLogin() {
        //Cria o gerador do AlertDialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Login");
        //define a mensagem
        builder.setMessage("Ao entrar novamente no app, não será solicitado seu login e senha.");
        //define um botão como positivo
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                btnSwitch.setChecked(true);
                Toast.makeText(getApplicationContext(), "Aplicado" + "\n" + "\n" + "Login:  "+btnEditText.getText() + "\n" + "Senha:  "+btnEditText2.getText(), Toast.LENGTH_LONG).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                btnSwitch.setChecked(false);
                Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        aviso = builder.create();
        //Exibe
        aviso.show();
    }


}
