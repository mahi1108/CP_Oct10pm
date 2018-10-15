package cubex.mahesh.cp_oct10pm

import android.annotation.SuppressLint
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var resolver = contentResolver
        /*      var c:Cursor = resolver.query(
                     ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
             null,null,null,
                     null)
             var from = arrayOf(
                     ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                     ContactsContract.CommonDataKinds.Phone.NUMBER)
             var to = intArrayOf(R.id.tv1,R.id.tv2)
             var adapter = SimpleCursorAdapter(
                     this@MainActivity,R.layout.indiview,
                     c,from,to,0)
             lview.adapter = adapter  */

        var c:Cursor = resolver.query(CallLog.Calls.CONTENT_URI,
                null,null,
                null,null)
        var from = arrayOf(CallLog.Calls.CACHED_NAME,
                CallLog.Calls.NUMBER,
                CallLog.Calls.TYPE,
                CallLog.Calls.DURATION,
                CallLog.Calls.DATE)
        var to = intArrayOf(R.id.tv1,R.id.tv2,R.id.tv3,
                R.id.tv4,R.id.tv5)
        var adapter = SimpleCursorAdapter(
                this@MainActivity,R.layout.indiview,
                c,from,to,0)
        lview.adapter = adapter
    }
}
