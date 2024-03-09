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

        // Ustanowić view binding
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onSortButtonClick(view: View) {

        // Wyłączyć klawiaturę zasłaniającą wynik
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        sort(view)
    }

    private fun sort(view: View) {
        // Jeśli nie ma wybranego trybu sortowania, wyświetlić komunikat
        if(!binding.bubbleRadio.isChecked && !binding.quicksortRadio.isChecked) {
            setErrorText()
        } else {
            // W przeciwnym wypadku wydobyć poprawne liczby z wpisanego tekstu jako tablicę
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

            // Posortować na wybrany sposób
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
        // Ustawienie stylu oraz zawartości opisu odpowiedniego algorytmu
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
        // Edycja tekstu: czerwony, informujący o braku wybranego algorytmu
        binding.algorithmDesc.text = getString(R.string.no_algorithm_selected_message)
        binding.algorithmDesc.setTextColor(getColor(R.color.red))
        binding.algorithmDesc.gravity = Gravity.CENTER
        binding.algorithmDesc.textSize = 20F
    }

}
