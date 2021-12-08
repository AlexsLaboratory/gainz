package com.team10.android.gainz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.team10.android.gainz.models.LoginUserRequest
import com.team10.android.gainz.models.LoginUserResponse
import com.team10.android.gainz.networking.APIClient
import com.team10.android.gainz.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
  private lateinit var email: EditText
  private lateinit var password: EditText
  private lateinit var loginBtn: Button
  private lateinit var sessionManager: SessionManager

  override fun onAttach(context: Context) {
    super.onAttach(context)
    sessionManager = SessionManager(requireContext())
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_login, container, false)
    email = view.findViewById(R.id.login_email)
    password = view.findViewById(R.id.login_password)
    loginBtn = view.findViewById(R.id.login)
    loginBtn.isEnabled = true

    loginBtn.setOnClickListener {
      val loginRequest = LoginUserRequest(
        email = email.text.toString(),
        password = password.text.toString()
      )
      loginUser(loginRequest)
    }

    return view
  }

  private fun loginUser(loginRequest: LoginUserRequest) {
    val registerResponseCall = APIClient().getAuthService().loginUser(loginRequest)
    registerResponseCall.enqueue(object : Callback<LoginUserResponse> {
      override fun onResponse(
        call: Call<LoginUserResponse>,
        response: Response<LoginUserResponse>
      ) {
        if (response.isSuccessful) {
          val message = "Successful..."
          Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
          sessionManager.saveAuthToken(response.body()?.token)
        } else {
          val message = "Unable to login"
          Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
      }

      override fun onFailure(call: Call<LoginUserResponse>, t: Throwable) {
        val message = t.localizedMessage
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
      }
    })
  }

  companion object {
    fun newInstance() = LoginFragment()
  }
}