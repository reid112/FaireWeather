package ca.rjreid.faireweather.ui.screen.home

import ca.rjreid.faireweather.MainCoroutineRule
import ca.rjreid.faireweather.domain.usecases.FetchWeatherForLocationUseCase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
internal class HomeViewModelTest {
    private lateinit var viewModel: HomeViewModel

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var fetchWeatherForLocationUseCaseMock: FetchWeatherForLocationUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `given loading result, when fetching data, then show loading`() = TestScope().runTest {
        // GIVEN
        whenever(fetchWeatherForLocationUseCaseMock.invoke(any())).thenReturn(
            flow { emit(FetchWeatherForLocationUseCase.UseCaseResult.Loading) }
        )

        // WHEN
        createViewModel()

        // THEN
        assertTrue(viewModel.uiState.loading)
    }

    @Test
    fun `given error result, when fetching data, then show error`() = TestScope().runTest {
        // GIVEN
        val message = "Error!"
        whenever(fetchWeatherForLocationUseCaseMock.invoke(any())).thenReturn(
            flow { emit(FetchWeatherForLocationUseCase.UseCaseResult.Error(message)) }
        )

        // WHEN
        createViewModel()

        // THEN
        assertEquals(message, viewModel.uiState.error)
    }

    private fun createViewModel() {
        viewModel = HomeViewModel(
            fetchWeatherForLocationUseCase = fetchWeatherForLocationUseCaseMock
        )
    }
}