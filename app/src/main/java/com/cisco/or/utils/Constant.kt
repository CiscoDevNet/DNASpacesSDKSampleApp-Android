package com.cisco.or.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cisco.or.sdk.models.User
import javax.net.ssl.SSLEngineResult

class Constant {
    companion object {
        val ApplicationId = "com.cisco.fit"
        var PUSH_TOKEN = "push_token"
        val dnaSpacesKey = "2bba6f2b-2399-4246-8257-fcc6c95ba337"
        val SERVER_CLIENT_ID = "698867933682-8e8eq5ahe1pfe1bt0hkpjpc29gu8d540.apps.googleusercontent.com"
     }
}

open class ProfileObservable : ViewModel()
{
    val profile = MutableLiveData<User>()

    fun profile(item: User) {
        profile.value = item
    }
}