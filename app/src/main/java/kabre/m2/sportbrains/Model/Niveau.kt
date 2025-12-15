package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class Niveau(
    var id: Int,
    var level: Int,
    var levelPart: Int,
    var maxLevelPart: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(level)
        parcel.writeInt(levelPart)
        parcel.writeInt(maxLevelPart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Niveau> {
        override fun createFromParcel(parcel: Parcel): Niveau {
            return Niveau(parcel)
        }

        override fun newArray(size: Int): Array<Niveau?> {
            return arrayOfNulls(size)
        }
    }
}
