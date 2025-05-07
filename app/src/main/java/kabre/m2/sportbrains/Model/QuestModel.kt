package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class QuestModel(
    val id: Int,
    val questPic: String?,
    val description: String?,
    val completeNb: Int,
    var currentcCompleteNb: Int,
    val recompencePic: String?,
    val recompence: Int,
    val condition:Int,
    var status: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(questPic)
        parcel.writeString(description)
        parcel.writeInt(completeNb)
        parcel.writeInt(currentcCompleteNb)
        parcel.writeString(recompencePic)
        parcel.writeInt(recompence)
        parcel.writeInt(condition)
        parcel.writeInt(status)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<QuestModel> {
        override fun createFromParcel(parcel: Parcel): QuestModel = QuestModel(parcel)
        override fun newArray(size: Int): Array<QuestModel?> = arrayOfNulls(size)
    }
}
