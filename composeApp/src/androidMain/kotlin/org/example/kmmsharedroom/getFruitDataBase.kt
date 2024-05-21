package org.example.kmmsharedroom

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.FruitDatabase

fun getFruitDataBase(context: Context): FruitDatabase {
    val dbFile = context.getDatabasePath("Fruit.db")

    return Room.databaseBuilder<FruitDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()

}