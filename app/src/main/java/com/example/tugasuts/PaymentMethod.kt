package com.example.tugasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.R
import com.example.tugasuts.databinding.ActivityPaymentMethodBinding

class PaymentMethod : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentMethodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bioskop = arrayOf(
            "Ambarrukmo XXI",
            "Empire XXI",
            "CGV Transmart Maguwo",
            "Jogja City XXI",
            "Sleman City Hall XXI",
            "Cinepolis Lippo Plaza Jogja",
            "CGV Hartono Mall"
        )

        val seat = arrayOf(
            "Regular",
            "Premiere",
            "IMAX",
            "Dolby Atmos"
        )

        with(binding) {
            val spinBioskopAdapter = ArrayAdapter(
                this@PaymentMethod,
                R.layout.support_simple_spinner_dropdown_item, bioskop
            )

            spinBioskopAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            spinBioskop.adapter= spinBioskopAdapter

            val seatAdapter = ArrayAdapter(this@PaymentMethod,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,seat)

            seatAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            spinSeat.adapter= seatAdapter

            var selectedDate = ""
            var selectedTime = ""

            datePick.init(datePick.year, datePick.month, datePick.dayOfMonth) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"

                buttonPayment.setOnClickListener {
                    val IntentMethod = Intent(this@PaymentMethod, DetailPayment::class.java)
                    startActivity(IntentMethod)
                }
            }
        }
    }
}