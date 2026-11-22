package net.huannguyen.inboxstyleanimation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.huannguyen.inboxstyleanimation.State.InProgress
import net.huannguyen.inboxstyleanimation.State.Success

class EmailListViewModel(app: Application) : AndroidViewModel(app) {
  val emails: LiveData<State>
    get() = emailLiveData

  private val emailLiveData = MutableLiveData<State>()
  private val emailData by lazy { (1..17).map { "Email $it" }.toList() }

  fun getEmails() {
    Thread {
      emailLiveData.postValue(InProgress)
      Thread.sleep(2000)
      emailLiveData.postValue(Success(emailData))
    }.start()
  }
}

sealed class State {
  object InProgress : State()
  data class Success(val data: List<String>) : State()
}
