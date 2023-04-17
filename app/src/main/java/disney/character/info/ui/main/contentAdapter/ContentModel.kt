package disney.character.info.ui.main.contentAdapter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContentModel(val name: String, val image: String) : Parcelable
