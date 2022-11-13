package space.beka.valyutalarkursi.model


import com.google.gson.annotations.SerializedName

class CurrencyData : ArrayList<CurrencyData.CurrencyDataItem>() {
    data class CurrencyDataItem(
        @SerializedName("id")
        val id: Int, // 75
        @SerializedName("Code")
        val code: String, // 710
        @SerializedName("Ccy")
        val ccy: String, // ZAR
        @SerializedName("CcyNm_RU")
        val ccyNmRU: String, // Рэнд
        @SerializedName("CcyNm_UZ")
        val ccyNmUZ: String, // Janubiy Afrika randi
        @SerializedName("CcyNm_UZC")
        val ccyNmUZC: String, // Жанубий Африка ранди
        @SerializedName("CcyNm_EN")
        val ccyNmEN: String, // Rand
        @SerializedName("Nominal")
        val nominal: String, // 1
        @SerializedName("Rate")
        val rate: String, // 677.19
        @SerializedName("Diff")
        val diff: String, // 2.36
        @SerializedName("Date")
        val date: String // 14.12.2021
    )
}