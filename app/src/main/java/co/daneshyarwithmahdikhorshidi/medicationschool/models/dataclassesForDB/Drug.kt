package co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.database.DatabaseConstants

@Entity(tableName = DatabaseConstants.TABLE_NAME)
data class Drug(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "faname")
    val faname: String?,
    @ColumnInfo(name = "enname")
    val enname: String?,
    @ColumnInfo(name = "fullname")
    val fullname: String?,
    @ColumnInfo(name = "type")
    val type: String?,
    @ColumnInfo(name = "method")
    val method: String?,
    @ColumnInfo(name = "company")
    val company: String?,
    @ColumnInfo(name = "compounds")
    val compounds: String?,
    @ColumnInfo(name = "mavaredmasraf")
    val mavaredmasraf: String?,
    @ColumnInfo(name = "asarjanebi")
    val asarjanebi: String?,
    @ColumnInfo(name = "pharmacokinetics")
    val pharmacokinetics: String?,
    @ColumnInfo(name = "hoshdar")
    val hoshdar: String?,
    @ColumnInfo(name = "avarez")
    val avarez: String?,
    @ColumnInfo(name = "tadakhol")
    val tadakhol: String?,
    @ColumnInfo(name = "nokat")
    val nokat: String?,
)