package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class NombreEtoile(
    val id: Int,
    var NbEtoile: Int
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(NbEtoile)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NombreEtoile> {
        override fun createFromParcel(parcel: Parcel): NombreEtoile {
            return NombreEtoile(parcel)
        }

        override fun newArray(size: Int): Array<NombreEtoile?> {
            return arrayOfNulls(size)
        }
    }

}
