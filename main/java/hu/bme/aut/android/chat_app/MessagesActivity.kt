package hu.bme.aut.android.chat_app

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MessagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        val snackText=intent.getStringExtra("SnackBarLoginText")
        if (snackText != null) {
            Snackbar.make(findViewById(android.R.id.content),snackText, Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.GREEN)
                .show()
        }
    }
}