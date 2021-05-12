package com.mf.dres.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mf.dres.model.Mueble

@Database(entities = [Mueble::class], version = 1, exportSchema = false)
abstract class MuebleDatabase: RoomDatabase() {

    abstract fun muebleDao(): MuebleDao

    companion object {
        @Volatile
        private var INSTANCE: MuebleDatabase? = null

        fun getDatabase(context: Context): MuebleDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    MuebleDatabase::class.java,
                    "mueble_database"
                ).build()
                INSTANCE = instace
                return instace
            }
        }
    }
}