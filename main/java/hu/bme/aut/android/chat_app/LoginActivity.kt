package hu.bme.aut.android.chat_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.reflect.KClass


class LoginActivity: AppCompatActivity(){
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val snackText=intent.getStringExtra("SnackBarRegisterText")
        if (snackText != null) {
            Snackbar.make(findViewById(android.R.id.content),snackText,Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.GREEN)
                .setTextColor(R.color.colorPrimaryDark)
                .show()
        }


        button_ok.background.alpha = 170
        button_register.background.alpha = 100

        button_register.setOnClickListener(View.OnClickListener { openRegisterActivity() })
        button_ok.setOnClickListener(View.OnClickListener { openMessagesActivity() })



    }
    private fun openRegisterActivity(){
        val intent = Intent(this, RegisterActivity::class.java)
        this.startActivity(intent)
    }

    private fun openMessagesActivity(){
        val intent = Intent(this, MessagesActivity::class.java)
        if(ValidateLogin()){
            intent.putExtra("SnackBarLoginText", "Login succeeded")
            this.startActivity(intent)
        }
    }

    private fun ValidateLogin(): Boolean{
        if(editTextLoginName.text.toString().isEmpty()){
           Snackbar.make(findViewById(android.R.id.content),"User Name is reqiured",Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.RED)
                .show()
            return false
        }
        if( editTextLoginPassword.text.toString().isEmpty()){
             Snackbar.make(findViewById(android.R.id.content),"Password is required",Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.RED)
                .show()
            return false
        }
        if(!ValidUserAndPass()){
            Snackbar.make(findViewById(android.R.id.content),"Wrong User Name or Password",Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.RED)
                .show()
            return false
        }

        return true
    }
    private fun ValidUserAndPass():Boolean{
        return true;
    }
}