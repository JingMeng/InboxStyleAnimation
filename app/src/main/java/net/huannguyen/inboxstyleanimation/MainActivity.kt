package net.huannguyen.inboxstyleanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .replace(R.id.container, EmailListFragment())
          .commit()
    }
  }

  override fun onBackPressed() {
    if (supportFragmentManager.backStackEntryCount >= 1) {
      supportFragmentManager.popBackStack()
    } else {
      super.onBackPressed()
    }
  }
}
