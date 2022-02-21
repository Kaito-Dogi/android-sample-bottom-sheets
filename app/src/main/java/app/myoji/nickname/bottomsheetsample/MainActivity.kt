package app.myoji.nickname.bottomsheetsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import app.myoji.nickname.bottomsheetsample.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use this to programmatically apply behavior attributes
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)

        // add the callback
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                val logMessage: String = when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> "DRAGGING"
                    BottomSheetBehavior.STATE_SETTLING -> "SETTING"
                    BottomSheetBehavior.STATE_EXPANDED -> "EXPANDED"
                    BottomSheetBehavior.STATE_COLLAPSED -> "COLLAPSED"
                    BottomSheetBehavior.STATE_HIDDEN -> "HIDDEN"
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> "HALF_EXPANDED"
                    else -> ""
                }
                Log.d(BOTTOM_SHEET_STATE, logMessage)
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                when {
                    slideOffset >= 0 -> binding.fab.setImageResource(R.drawable.ic_expand_more)
                    slideOffset < 0 -> binding.fab.setImageResource(R.drawable.ic_expand_less)
                }
            }
        })

        binding.fab.setOnClickListener {
            when (bottomSheetBehavior.state) {
                BottomSheetBehavior.STATE_EXPANDED -> bottomSheetBehavior.state =
                    BottomSheetBehavior.STATE_COLLAPSED
                BottomSheetBehavior.STATE_HIDDEN -> bottomSheetBehavior.state =
                    BottomSheetBehavior.STATE_COLLAPSED
                BottomSheetBehavior.STATE_COLLAPSED -> bottomSheetBehavior.state =
                    BottomSheetBehavior.STATE_HIDDEN
            }
        }
    }

    companion object {
        private const val BOTTOM_SHEET_STATE = "bottom_sheet_state"
    }
}