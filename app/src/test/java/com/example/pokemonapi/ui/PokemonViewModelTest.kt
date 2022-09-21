package com.example.pokemonapi.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.pokemonapi.data.PokeResponse
import com.example.pokemonapi.data.Result
import com.example.pokemonapi.network.IPokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when` as whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: PokemonViewModel

    private var testCoroutineDispatcher : CoroutineDispatcher = UnconfinedTestDispatcher()

    @Mock
    private lateinit var pokemonRepository: IPokemonRepository

    @Mock
    private lateinit var pokemonObserverResponse: Observer<PokeResponse>

    @Before
    fun setUp(){
        viewModel = PokemonViewModel(pokemonRepository, testCoroutineDispatcher)
    }

    @Test
    fun `when fetching pokemon list ok, then return data successfully`() = runTest {
        val expected = PokeResponse(1,"value","value", listOf(Result("value","value")))
        viewModel.pokeResponse.observeForever(pokemonObserverResponse)
        whenever(pokemonRepository.getPokeList()).thenReturn(expected)
        viewModel.getPokeList()
        assertNotNull(viewModel.pokeResponse.value)
        assertEquals(expected, viewModel.pokeResponse.value)
    }

    private fun removeObservers(){
        viewModel.pokeResponse.removeObserver(pokemonObserverResponse)
    }

    @After
    fun tearDown(){
        removeObservers()
    }
}