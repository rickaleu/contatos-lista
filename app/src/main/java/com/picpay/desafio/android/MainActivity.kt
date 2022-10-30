package com.picpay.desafio.android

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.presentation.userlist.UserListFragment
import com.picpay.desafio.android.presentation.userlist.adapter.UserListAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {

//    private lateinit var recyclerView: RecyclerView
//    private lateinit var progressBar: ProgressBar
//    private lateinit var adapter: UserListAdapter

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    private val navController: NavController by lazy { navHostFragment.findNavController() }
//    private val navHostFragment: NavHostFragment by lazy {
//        supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.userListToolbar)
        supportActionBar

        val userListFragment = UserListFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.user_list_fragment_container, userListFragment).commit()

//        setupActionBarWithNavController(navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//        return true
//    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.filter_menu_items, menu)
//        return true
//    }

//    private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

    private val gson: Gson by lazy { GsonBuilder().create() }

//    private val okHttp: OkHttpClient by lazy {
//        OkHttpClient.Builder()
//            .build()
//    }

//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(url)
//            .client(okHttp)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }

//    private val service: PicPayService by lazy {
//        retrofit.create(PicPayService::class.java)
//    }

    override fun onResume() {
        super.onResume()

//        recyclerView = findViewById(R.id.recyclerView)
//        progressBar = findViewById(R.id.user_list_progress_bar)

//        adapter = UserListAdapter()
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        progressBar.visibility = View.VISIBLE
//        service.getUsers()
//            .enqueue(object : Callback<List<User>> {
//                override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                    val message = getString(R.string.error)
//
//                    progressBar.visibility = View.GONE
//                    recyclerView.visibility = View.GONE
//
//                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
//                        .show()
//                }

//                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                    progressBar.visibility = View.GONE
//
//                    adapter.users = response.body()!!
//                }
//            })
    }
}
