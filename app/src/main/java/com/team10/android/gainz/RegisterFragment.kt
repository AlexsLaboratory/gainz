package com.team10.android.gainz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.team10.android.gainz.models.RegisterUserRequest
import com.team10.android.gainz.models.RegisterUserResponse
import com.team10.android.gainz.networking.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
  private lateinit var name: EditText
  private lateinit var email: EditText
  private lateinit var password: EditText
  private lateinit var registerBtn: Button

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_register, container, false)
    name = view.findViewById(R.id.register_name)
    email = view.findViewById(R.id.register_email)
    password = view.findViewById(R.id.register_password)
    registerBtn = view.findViewById(R.id.register)
    registerBtn.isEnabled = true

    registerBtn.setOnClickListener {
      val registerRequest = RegisterUserRequest(
        name = name.text.toString(),
        email = email.text.toString(),
        password = password.text.toString()
      )
      registerUser(registerRequest)
    }

    return view
  }

  private fun registerUser(registerRequest: RegisterUserRequest) {
    val registerResponseCall = APIClient().getAuthService().signupUser(registerRequest)
    registerResponseCall.enqueue(object : Callback<RegisterUserResponse> {
      override fun onResponse(
        call: Call<RegisterUserResponse>,
        response: Response<RegisterUserResponse>
      ) {
        if (response.isSuccessful) {
          val message = "Successful..."
          Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        } else {
          val message = "Unable to register user"
          Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
      }

      override fun onFailure(call: Call<RegisterUserResponse>, t: Throwable) {
        val message = t.localizedMessage
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
      }
    })
  }

  companion object {
    fun newInstance() = RegisterFragment()
  }
}