package jihun.bang.jihunpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import jihun.bang.jihunpay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_menu_history -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.item_menu_remittance -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.item_menu_scan -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.item_menu_balance -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.item_menu_more -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
    }
}