package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class QuestModel(
    val id: Int,
    val nom: String,
    val iconeTache: String,
    val iconeCadeau: String,
    var progress: Int,
    val max: Int,
    val recompence: Int,
    val condition: Int,
    var statusss: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readBoolean()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nom)
        parcel.writeString(iconeTache)
        parcel.writeString(iconeCadeau)
        parcel.writeInt(progress)
        parcel.writeInt(max)
        parcel.writeInt(recompence)
        parcel.writeInt(condition)
        parcel.writeBoolean(statusss)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<QuestModel> {
        override fun createFromParcel(parcel: Parcel): QuestModel = QuestModel(parcel)
        override fun newArray(size: Int): Array<QuestModel?> = arrayOfNulls(size)
    }
}
