package com.mf.dres.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "muebles")
data class Mueble(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val color: String,
    val precio: Int,
    val descripcion: String
): Parcelable