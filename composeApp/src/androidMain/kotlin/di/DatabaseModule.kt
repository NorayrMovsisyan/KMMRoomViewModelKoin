package di

import database.FruitDao
import org.example.kmmsharedroom.getFruitDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val databaseModule = module {
    single<FruitDao> { getFruitDataBase(androidContext()).fruitDao() }
}