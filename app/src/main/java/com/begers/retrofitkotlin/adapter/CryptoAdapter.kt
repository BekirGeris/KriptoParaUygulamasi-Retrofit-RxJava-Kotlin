package com.begers.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.begers.retrofitkotlin.R
import com.begers.retrofitkotlin.model.CryptoModel


class CryptoAdapter(val cryptoModels: ArrayList<CryptoModel>, private val listener: Listener) : RecyclerView.Adapter<CryptoAdapter.CryptoHolder>() {

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }
    private val colors: Array<String> = arrayOf("#13bd27","#29c1e1","#b129e1","#d3df13","#f6bd0c","#a1fb93","#0d9de3","#ffe48f")

    class CryptoHolder(view: View) : RecyclerView.ViewHolder(view) {
        var currency: TextView = itemView.findViewById(R.id.text_currency)
        var price: TextView = itemView.findViewById(R.id.text_price)

        fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int, listener: Listener){
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            currency.text = cryptoModel.currency
            price.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_row, parent, false)
        return CryptoHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoHolder, position: Int) {
        holder.bind(cryptoModels[position], colors, position, listener)
    }

    override fun getItemCount(): Int {
        return cryptoModels.count()
    }
}