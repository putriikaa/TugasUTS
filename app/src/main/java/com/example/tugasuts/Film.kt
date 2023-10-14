package com.example.tugasuts
import android.os.Parcel
import android.os.Parcelable

var filmlist = mutableListOf<Film>()
class Film (
    var imageResId: Int,
    var title: String,
    var director: String,
    var categories: String,
    var description: String,
    var rating: Double,
    var price: Int
)
    : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(title)
        parcel.writeString(director)
        parcel.writeString(categories)
        parcel.writeString(description)
        parcel.writeDouble(rating)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }
}