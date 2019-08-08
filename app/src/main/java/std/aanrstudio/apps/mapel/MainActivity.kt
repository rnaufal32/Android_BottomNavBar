package std.aanrstudio.apps.mapel

import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView

    private lateinit var Isi: FrameLayout

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val home = HomeFragment()
                addFragment(home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val jadwal = JadwalFragment()
                addFragment(jadwal)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val tugas = TugasFragment()
                addFragment(tugas)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.isi, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val fragment = HomeFragment()
        addFragment(fragment)
    }
}
