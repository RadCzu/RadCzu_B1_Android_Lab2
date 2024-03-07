package amw.radczu.lab2

import amw.radczu.lab2.databinding.ActivityMainBinding
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun sort(view: View) {
        if(!binding.bubbleRadio.isChecked && !binding.quicksortRadio.isChecked) {
            //edycja tekstu: czerwony, informujący o braku wybranego algorytmu
            binding.algorithmDesc.text = getString(R.string.no_algorithm_selected_message)
            binding.algorithmDesc.setTextColor(getColor(R.color.red))
            binding.algorithmDesc.gravity = Gravity.CENTER
            binding.algorithmDesc.textSize = 20F
        } else {
            val textList = binding.listEditor.text
            val splits = textList.split(',')
            var numbers: List<Int>
            splits.forEach() {
                try {
                    val number = it.toInt()
                } catch (error: Error) {

                }
            }
            if(binding.bubbleRadio.isChecked) {

                binding.algorithmDesc.text = getString(R.string.bubble_desc)
                binding.algorithmDesc.setTextColor(getColor(R.color.black))
                binding.algorithmDesc.gravity = Gravity.START
                binding.algorithmDesc.textSize = 16F
            } else {

            }
        }
    }

    fun setDesc(view: View) {
        binding.algorithmDesc.textSize = 16F
        binding.algorithmDesc.setTextColor(getColor(R.color.black))
        binding.algorithmDesc.gravity = Gravity.START
        if(binding.bubbleRadio.isChecked) {
            binding.algorithmDesc.text = getString(R.string.bubble_desc)
        } else {
            binding.algorithmDesc.text = getString(R.string.quicksort_desc)
        }
    }

}
