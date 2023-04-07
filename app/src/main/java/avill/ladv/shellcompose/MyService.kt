package avill.ladv.shellcompose

import android.app.Service
import android.content.Intent
import android.os.IBinder
import avill.ladv.shellcompose.data.Repository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyService: Service() { @Inject
    lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}