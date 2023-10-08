package com.example.showcleanarch.ui.components.extensions


/**
 * @author : Mingaleev D
 * @data : 08.10.2023
 */

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T> Flow<T>.collectRepeatOnStart(owner: LifecycleOwner, block: (T) -> Unit) =
    owner.lifecycleScope.launch {
       owner.lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
          collectLatest(block)
       }
    }