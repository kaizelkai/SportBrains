package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class Cadeau(
    val id:Int,
    val levelRequard:Int,
    var basicImage: String?,
    val basicPoint:Int,
    val extraImage: String?,
    val extraPoint:Int,
):Parcelable{
    constructor(parcel: Parcel): this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(levelRequard)
        parcel.writeString(basicImage)
        parcel.writeInt(basicPoint)
        parcel.writeString(extraImage)
        parcel.writeInt(extraPoint)
    }
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cadeau>{
        override fun createFromParcel(parcel: Parcel): Cadeau {
            return Cadeau(parcel)
        }

        override fun newArray(size: Int): Array<Cadeau?> {
            return arrayOfNulls(size)
        }
    }

}
