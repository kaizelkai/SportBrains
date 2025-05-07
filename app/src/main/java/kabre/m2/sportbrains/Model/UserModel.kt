package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class UserModel(
    val id: Int,
    var name: String?,
    var pic: String?,
    var score: Int,
    var scoreDepence: Int,
    var level: Int,
    var levelPart: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(pic)
        parcel.writeInt(score)
        parcel.writeInt(scoreDepence)
        parcel.writeInt(level)
        parcel.writeInt(levelPart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }
}
