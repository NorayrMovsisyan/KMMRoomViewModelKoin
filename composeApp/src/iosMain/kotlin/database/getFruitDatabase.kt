package database

fun getPeopleDatabase(): FruitDatabase {
    val dbFile = NSHomeDirectory() + "/fruit.db"
    return Room.databaseBuilder<FruitDatabase>(
        name = dbFile,
        factory = { FruitDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}