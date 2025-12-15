package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class NombreBlocStats(
    val id: Int,
    var nombre: Int,
    var type: String
): Parcelable{
    constructor(parcel:Parcel): this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString()
    )

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeInt(id)
        p0.writeInt(nombre)
        p0.writeString(type)
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
