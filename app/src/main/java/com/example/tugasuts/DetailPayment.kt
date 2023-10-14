package com.example.tugasuts

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasuts.databinding.ActivityDetailPaymentBinding

class DetailPayment : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        val ordernumberValue = intent.getStringExtra(PaymentMethod.EXTRA_ORDERNUMBER)
        val payMethod = intent.getStringExtra(PaymentMethod.EXTRA_PAY)
        val priceSeat = intent.getStringExtra(PaymentMethod.EXTRA_PRICESEAT)
        val totalPay = intent.getStringExtra(PaymentMethod.EXTRA_ACTUAL)
        val film = intent.getParcelableExtra<Film>("film")
        val selectedDate = intent.getStringExtra("selectedDate")
        val selectedTime = intent.getStringExtra("selectedTime")
        val selectedBioskop = intent.getStringExtra("selectedBioskop")
        val textViewBioskop = findViewById<TextView>(R.id.bioskop)
        val selectedSeat = intent.getStringExtra(PaymentMethod.EXTRA_SEAT)


        with(binding) {
            image.setImageResource(film!!.imageResId)
            title.text = film?.title
            orderNumb.text = ordernumberValue
            bankTransfer.text = payMethod
            seatPrice.text = "Rp$priceSeat"
            payLast.text = "Rp$totalPay"
            JenisSeat.text = selectedSeat


            textViewBioskop.text = "$selectedBioskop\n$selectedDate $selectedTime"

            back.setOnClickListener{
                val intent = Intent(this@DetailPayment, PaymentMethod::class.java )
                startActivity(intent)
            }
        }
    }
}