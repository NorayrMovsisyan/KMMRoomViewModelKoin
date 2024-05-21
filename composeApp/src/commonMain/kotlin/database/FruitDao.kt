package database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FruitDao {

    @Query("SELECT * FROM fruit")
    fun getAllFruits(): Flow<List<Fruit>>

    @Upsert
    suspend fun upsertFruit(fruit: Fruit)

    @Delete
    suspend fun deleteFruit(fruit: Fruit)

}