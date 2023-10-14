package com.example.tugasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tugasuts.databinding.ActivityPaymentMethodBinding

class PaymentMethod : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentMethodBinding
    private var selectedDate: String = "Tanggal belum di isi"
    private var selectedTime: String = "Waktu belum di isi"

    companion object {
        const val EXTRA_SEAT = "extra_seat"
        const val EXTRA_ACTUAL = "extra_actual"
        const val EXTRA_ORDERNUMBER = "extra_ordernumber"
        const val EXTRA_PAY = "extra_pay"
        const val EXTRA_PRICESEAT = "extra_priceseat"
    }

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

        val seatpilih = arrayOf(
            "Regular" ,
            "Premiere" ,
            "IMAX",
            "Dolby Atmos"
        )

        val seatPrices = mapOf(
            "Regular" to 35000,
            "Premiere" to 45000,
            "IMAX" to 55000,
            "Dolby Atmos" to 60000
        )

        val bank = arrayOf(
            "BNI",
            "BRI",
            "Mandiri",
            "BCA"
        )

        val method = arrayOf(
            "Transfer",
            "Tunai",
            "QR"
        )

        with(binding) {
            val spinBioskopAdapter = ArrayAdapter(
                this@PaymentMethod,
                android.R.layout.simple_spinner_dropdown_item, bioskop
            )

            spinBioskopAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )

            spinBioskop.adapter = spinBioskopAdapter

            val spinSeatPilihAdapter = ArrayAdapter(
                this@PaymentMethod,
                android.R.layout.simple_spinner_dropdown_item, seatpilih
            )

            spinSeatPilihAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )

            spinSeatPilih.adapter = spinSeatPilihAdapter

            val bankAdapter = ArrayAdapter(
                this@PaymentMethod,
                android.R.layout.simple_spinner_dropdown_item, bank
            )

            bankAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )

            spinBank.adapter = bankAdapter

            val methodAdapter = ArrayAdapter(
                this@PaymentMethod,
                android.R.layout.simple_spinner_dropdown_item, method
            )

            methodAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )

            SpinmethodPay.adapter = methodAdapter

            datePick.init(
                datePick.year,
                datePick.month,
                datePick.dayOfMonth
            ) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"
            }

            val timePicker = binding.timePick
            timePicker.setOnTimeChangedListener { _, hourOfDay, minutes ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minutes)
            }

            buttonPayment.setOnClickListener {
                val selectedSeat = spinSeatPilih.selectedItem.toString()
                val selectedBioskop = spinBioskop.selectedItem.toString()
                val selectedBank = spinBank.selectedItem.toString()
                val film = intent.getParcelableExtra<Film>("film")

                val selectedPrice = seatPrices[selectedSeat] ?: 0
                val totalPay = selectedPrice + 1000

                val intent = Intent(this@PaymentMethod, DetailPayment::class.java)
                intent.putExtra("selectedBioskop", selectedBioskop)
                intent.putExtra("selectedDate", selectedDate)
                intent.putExtra("selectedBank", selectedBank)
                intent.putExtra("selectedTime", selectedTime)
                intent.putExtra("film", film)
                intent.putExtra(EXTRA_ORDERNUMBER, accNumb.text.toString())
                intent.putExtra(EXTRA_ACTUAL, totalPay.toString())
                intent.putExtra(EXTRA_PRICESEAT, selectedPrice.toString())
                intent.putExtra(EXTRA_PAY, SpinmethodPay.selectedItem.toString())
                intent.putExtra(EXTRA_SEAT, selectedSeat)

                startActivity(intent)
            }
            back2.setOnClickListener {
                val intentoDetail = Intent(this@PaymentMethod, DetailsMovie::class.java)
                startActivity(intentoDetail)
            }
        }
    }
}
