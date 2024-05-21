package database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Fruit::class], version = 1)
abstract class FruitDatabase : RoomDatabase() {
    abstract fun fruitDao(): FruitDao

}