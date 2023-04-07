package avill.ladv.shellcompose.core

import android.app.Activity
import android.app.Application
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

//to access any color use only R.colo.black
fun Activity.color(@ColorRes color: Int) = ContextCompat.getColor(this,color)
//in any variable use object.isnull()
fun Any?.isnull() = this == null

//in activity use only toast("Message")
fun Activity.toast(text:String,length:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,text,length).show()
}
//in activity use only toast("Message")
fun Application.toast(text:String,length:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this.applicationContext,text,length).show()
}
//in a referency to image make only imageView.load("url")
fun ImageView.load(url:String){
    if (url.isNotEmpty()) {
        Glide.with(this.context).load(url).into(this)
    }
}
//in editText.onTextChanged{"Texto contiene $it"}
fun EditText.onTextChanged(listener:(String)->Unit){
    this.addTextChangedListener(object:TextWatcher{
        override fun afterTextChanged(s: Editable?){
            listener(s.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("Not yet implemented")
        }
    })
}
