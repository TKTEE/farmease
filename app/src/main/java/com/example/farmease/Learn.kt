package com.example.farmease

import android.os.Parcel
import android.os.Parcelable

data class Learn(val image : Int, val name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Learn> {
        override fun createFromParcel(parcel: Parcel): Learn {
            return Learn(parcel)
        }

        override fun newArray(size: Int): Array<Learn?> {
            return arrayOfNulls(size)
        }
    }
}
