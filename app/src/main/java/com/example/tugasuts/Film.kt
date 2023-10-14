package com.example.tugasuts
import android.os.Parcel
import android.os.Parcelable

var filmlist = mutableListOf<Film>(
    Film(
        R.drawable.sherina,
        "Petualangan Sherina 2",
        "Riri Riza",
        "Petualangan, Komedi, Drama, Kekeluargaan, Musikal",
        "Petualangan Sherina 2 kembali menampilkan cerita tentang dua orang teman masa kecil yang senang bertualang, yakni Sherina dan Sadam. Setelah bertahun-tahun berlalu, keduanya tumbuh menjadi orang dewasa dan memiliki pekerjaannya yang sangat berbeda. Keduanya telah berpisah lama dan tinggal di tempat yang berjauhan.",
        5,
        35000
    ),
    Film(
        R.drawable.mermaid,
        "The Little Mermaid",
        "Rob Marshall",
        "Petualangan, Fantasi, Kartun",
        " The Little Mermaid menceritakan tentang Ariel si putri duyung yang membuat kesepakatan dengan penyihir laut berbahaya bernama Ursula untuk menukar suaranya dengan kaki manusia untuk mengesankan Pangeran Eric, yang ia selamatkan dari kapal karam.",
        4,
        35000
    ),
    Film(
        R.drawable.aladin,
        "Aladin",
        "Guy Ritchie",
        "Fantasi",
        "Aladdin, seekor tikus jalanan yang baik hati yang tinggal di kota Arab, Agrabah, bersama dengan monyet peliharaannya, Abu, menyelamatkan dan berteman dengan Putri Jasmine, yang menyelinap keluar dari istana untuk menjelajah, lelah dengan kehidupan yang terlindung. Sementara itu, wazir agung Jafar berencana untuk menggulingkan ayah Jasmine sebagai Sultan. ",
        3,
        35000
    ),
    Film(
        R.drawable.moana,
        "Moana",
        "Ron Clements",
        "Drama, Fantasi, Petualangan",
        "Di pulau Motunui di Polinesia, penduduk menyembah dewi Te Fiti, yang membawa kehidupan ke lautan, menggunakan batu pounamu sebagai jantung dan sumber kekuatannya. Maui, dewa setengah jadi dan penguasa pelayaran, mencuri jantung dewi Te Fiti untuk memberi kekuatan penciptaan pada manusia. Namun, Te Fiti hancur, dan Maui diserang oleh orang lain yang mencari jantung dewi Te Fiti: Te Ka, iblis vulkanik",
        4,
        35000
    ),
    Film(
        R.drawable.avatar,
        "Avatar",
        "Director Name",
        "Drama, Romance, Music",
        "Description of the film.",
        4,
        35000
    ),
    Film(
        R.drawable.mulan,
        "Mulan",
        "Niki Caro",
        "Drama, Laga, Fantasi",
        "Di Kekaisaran Tiongkok, Hua Mulan adalah seorang gadis petualang yang aktif. Orang tuanya berharap suatu hari dia akan menikah dengan suami yang baik. Sebagai wanita muda, Mulan terpaksa bertemu dengan seorang wanita tua untuk menunjukkan keanggunannya sebagai calon istri. ",
        5,
        35000
    )
)
class Film (
    var imageResId: Int,
    var title: String,
    var director: String,
    var categories: String,
    var description: String,
    var rating: Int,
    var price: Int
)
    : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(title)
        parcel.writeString(director)
        parcel.writeString(categories)
        parcel.writeString(description)
        parcel.writeInt(rating)
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