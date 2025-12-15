package kabre.m2.sportbrains.Model

import android.os.Parcel
import android.os.Parcelable

data class CompleteTache(
    val id: Int,
    var niveauTerminer: Int,
    var etoileObtenu: Int,
    var pieceDepencer: Int,
    var pieceObtenu: Int,
    var progressTache: Int
): Parcelable{
    constructor(parcel: Parcel): this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(niveauTerminer)
        parcel.writeInt(etoileObtenu)
        parcel.writeInt(pieceDepencer)
        parcel.writeInt(pieceObtenu)
        parcel.writeInt(progressTache)
    }
    override fun describeContents(): Int = 0

    companion object CREATOR: Parcelable.Creator<CompleteTache>{
        override fun createFromParcel(parcel: Parcel): CompleteTache = CompleteTache(parcel)
        override fun newArray(size: Int): Array<CompleteTache?> = arrayOfNulls(size)
    }
}
