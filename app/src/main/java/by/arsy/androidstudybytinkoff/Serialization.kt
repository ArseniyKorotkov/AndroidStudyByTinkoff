package by.arsy.androidstudybytinkoff

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class SerializablePerson(
    val name: String,
    val age: Int
) : Serializable

data class ParcelablePerson(
    val name: String,
    val age: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(
        parcel: Parcel,
        flags: Int
    ) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    companion object CREATOR : Parcelable.Creator<ParcelablePerson> {
        override fun createFromParcel(p0: Parcel): ParcelablePerson {
           return ParcelablePerson(parcel = p0)
        }

        override fun newArray(p0: Int): Array<ParcelablePerson?> {
            return arrayOfNulls(p0)
        }
    }
}

@Parcelize
data class ParcelizePerson(val name: String, val age: Int) : Parcelable