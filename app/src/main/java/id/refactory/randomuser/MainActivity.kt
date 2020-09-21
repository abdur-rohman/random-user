package id.refactory.randomuser

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.refactory.randomuser.adapters.UserAdapter
import id.refactory.randomuser.clients.UserClient
import id.refactory.randomuser.models.Result
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = UserAdapter()

        rvUsers.adapter = adapter

        showLoading(true)

        UserClient.service().getUser(1000).enqueue(object: Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                response.body()?.let { adapter.list = it.results }

                showLoading(false)
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                t.printStackTrace()

                showLoading(false)
            }
        })
    }

    fun showLoading(isLoading: Boolean) {
        tvLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        rvUsers.visibility = if (!isLoading) View.VISIBLE else View.GONE
    }
}