package com.harrisson.travelconsuption

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.harrisson.travelconsuption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)


    }

    override fun setSupportActionBar(toolbar: androidx.appcompat.widget.Toolbar?) {
        super.setSupportActionBar(toolbar)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {

        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            if(autonomy == 0f){
                Toast.makeText(this, R.string.validation_autonomy, Toast.LENGTH_SHORT).show()
                binding.labelCalculated.text = "0.0"
            }else {
                val totalValue = (price * distance) / autonomy
                val TotalValueStr = "%.2f".format(totalValue)

                binding.labelCalculated.text = "R$ $TotalValueStr"

            }
        }else{
            Toast.makeText(this, R.string.validation_all_fields, Toast.LENGTH_SHORT).show()
        }

    }


}

