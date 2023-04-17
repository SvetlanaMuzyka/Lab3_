package disney.character.info.di

import disney.character.info.data.DataManager
import disney.character.info.data.remote.ApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import disney.character.info.ui.main.MainViewModel


val viewModelsModule: Module = module {
    viewModel { MainViewModel(get()) }
}

val apiModule = module {
    single { ApiService.getApi() }
}

private val repositoryModule: Module = module {
    single { DataManager(get()) }
}


val DI_MODULES =
    listOf(viewModelsModule, apiModule, repositoryModule)
