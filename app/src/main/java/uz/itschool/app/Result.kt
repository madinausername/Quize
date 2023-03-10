package uz.itschool.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_math.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_sign_in_registration.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var sharedPreferences = getSharedPreferences("reg", MODE_PRIVATE)
        var edit = sharedPreferences.edit()
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type
        val user_name=intent.getStringExtra(setData.name)

        val score=intent.getStringExtra(setData.score)
        val totalQuestion=intent.getStringExtra("total size")

        val users_score_name=intent.getStringExtra("username_for_Score")
        val users_score_password=intent.getStringExtra("user_password_for_Score")



        congratulation_text.text="Congratulations ${user_name} !!"
        Score.text="${score} / ${totalQuestion}"
        for(i in userList){
            if(users_score_name==i.name && users_score_password==i.passwpord){
                i.score=score.toString().toInt()
            }
        }
        button.setOnClickListener {
            startActivity(Intent(this,Select_cardviews::class.java))
            finish()
        }
        b.setOnClickListener {
                var intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
        }
    }
}