package amw.radczu.lab2

import amw.radczu.lab2.databinding.ActivityMainBinding
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inspector.PropertyReader.PropertyTypeMismatchException
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onSortButtonClick(view: View) {

        //wyłączyć klawiaturę zasłaniającą wynik
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        sort(view)
    }

    private fun sort(view: View) {
        if(!binding.bubbleRadio.isChecked && !binding.quicksortRadio.isChecked) {
            setErrorText()
        } else {
            val textList = binding.listEditor.text
            val splits = textList.split(" ", ", ", ",")
            println(splits)
            val numbers: ArrayList<Int> = ArrayList()
            splits.forEach() {
                try {
                    val number = it.toInt()
                    numbers.add(number)
                } catch (error: NumberFormatException ) {
                    println("Could not convert '$it to an integer.")
                }
            }
            val array = numbers.toIntArray()
            if(binding.bubbleRadio.isChecked) {
                var bubbleSort = BubbleSortingDesc()
                bubbleSort.run(array)
            } else {
                var quicksort = QuickSortingDesc()
                quicksort.run(array)
            }

            binding.input.text = getString(R.string.input_label) + "\n" + numbers.toIntArray().joinToString()

            binding.output.text = getString(R.string.output_label) + "\n" + array.joinToString()

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

    private fun setErrorText() {
        //edycja tekstu: czerwony, informujący o braku wybranego algorytmu
        binding.algorithmDesc.text = getString(R.string.no_algorithm_selected_message)
        binding.algorithmDesc.setTextColor(getColor(R.color.red))
        binding.algorithmDesc.gravity = Gravity.CENTER
        binding.algorithmDesc.textSize = 20F
    }

}
