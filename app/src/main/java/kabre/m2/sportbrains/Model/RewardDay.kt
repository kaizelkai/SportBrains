package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class RewardDay(
    val id: Int,
    val image: String,
    val soccer: Int,
    var status: Boolean
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readBoolean()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(image)
        parcel.writeInt(soccer)
        parcel.writeBoolean(status)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<RewardDay> {
        override fun createFromParcel(parcel: Parcel): RewardDay {
            return RewardDay(parcel)
        }

        override fun newArray(size: Int): Array<RewardDay?> {
            return arrayOfNulls(size)
        }
    }

}
