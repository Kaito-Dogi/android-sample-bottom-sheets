package app.myoji.nickname.bottomsheetsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import app.myoji.nickname.bottomsheetsample.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)

        binding.button.setOnClickListener {
            when (bottomSheetBehavior.state) {
                BottomSheetBehavior.STATE_HIDDEN -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }
}