package com.example.handphoneapp.ui.screen.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.handphoneapp.di.Injection
import com.example.handphoneapp.model.OrderHandphone
import com.example.handphoneapp.ui.ViewModelFactory
import com.example.handphoneapp.ui.common.UiState
import com.example.handphoneapp.ui.component.HandPhoneItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (String) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState) {
            is UiState.Loading -> {
                viewModel.getAllHandPhone()
            }
            is UiState.Success -> {
                HomeContent(
                    handPhone = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {}
         }
    }

}

@Composable
fun HomeContent(
    handPhone: List<OrderHandphone>,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(145.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
       items(handPhone) {data ->
           HandPhoneItem(
               image = data.handPhone.image,
               title = data.handPhone.title,
               modifier = modifier
                   .clickable {
                        navigateToDetail(data.handPhone.id)
                    }
                   .fillMaxWidth()
           )
       }
    }
}

