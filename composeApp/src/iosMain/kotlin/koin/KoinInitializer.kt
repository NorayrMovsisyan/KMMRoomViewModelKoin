package koin

import di.databaseModule
import org.koin.core.context.startKoin
import di.viewModelModule

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(viewModelModule, databaseModule)
        }
    }
}