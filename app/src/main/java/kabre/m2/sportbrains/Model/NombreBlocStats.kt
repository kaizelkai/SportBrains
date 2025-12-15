package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class NombreBlocStats(
    val id: Int,
    var nombre: Int,
): Parcelable{
    constructor(parcel:Parcel): this(
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeInt(id)
        p0.writeInt(nombre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NombreBlocStats>{
        override fun createFromParcel(parcel: Parcel): NombreBlocStats {
            return NombreBlocStats(parcel)
        }

        override fun newArray(size: Int): Array<NombreBlocStats?> {
            return arrayOfNulls(size)
        }
    }
}
