package space.beka.valyutalarkursi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import space.beka.valyutalarkursi.R
import space.beka.valyutalarkursi.model.CurrencyData

class CurrencyAdapter(var data: CurrencyData) : RecyclerView.Adapter<CurrencyAdapter.Holder>() {

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view) {

        private var name: MaterialTextView = view.findViewById(R.id.name)
        private var rate: MaterialTextView = view.findViewById(R.id.rate)
        private var diff: MaterialTextView = view.findViewById(R.id.diff)
        private var diffImg: ImageView = view.findViewById(R.id.diff_img)

        fun bind(item: CurrencyData.CurrencyDataItem) {
            name.text = item.ccyNmEN
            rate.text = item.rate
            diff.text = item.diff
            if (item.diff[0] == '-') {
                diffImg.setImageResource(R.drawable.ic_baseline_call_received_24)
            } else {
                diffImg.setImageResource(R.drawable.ic_baseline_call_made_24)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size
}