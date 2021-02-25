package hu.bme.aut.android.chat_app


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_register_ok.setOnClickListener(View.OnClickListener { Registration() })
    }

    private fun ValidateRegistration(): Boolean{

        if(editTextUserName.text.toString().isEmpty()){
            Snackbar.make(findViewById(android.R.id.content),"User Name is reqiured", Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.RED)
                .show()
            return false
        }
        if( editTextPassword.text.toString().isEmpty()){
            Snackbar.make(findViewById(android.R.id.content),"Password is required", Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.RED)
                .show()
            return false
        }
        if(editTextPassword2.text.toString() != editTextPassword.text.toString()){
            Snackbar.make(findViewById(android.R.id.content),"Password confirmation failed",
                Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.RED)
                .show()
            return false
        }

        return true
    }

    private fun Registration(){
        val intent = Intent(this, LoginActivity::class.java)
        if (ValidateRegistration()){
            intent.putExtra("SnackBarRegisterText", "Registration succeeded")
            this.startActivity(intent)
        }
    }
}