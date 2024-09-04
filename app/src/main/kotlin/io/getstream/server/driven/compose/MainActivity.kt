/*
 * Designed and developed by 2024 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.getstream.server.driven.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import dagger.hilt.android.AndroidEntryPoint
import io.getstream.server.driven.compose.navigation.ServerDrivenNavHost
import io.getstream.server.driven.core.designsystem.theme.ServerDrivenTheme
import io.getstream.server.driven.core.navigation.AppComposeNavigator
import io.getstream.server.driven.core.navigation.LocalComposeNavigator
import io.getstream.server.driven.core.navigation.ServerDrivenScreen
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject
  lateinit var composeNavigator: AppComposeNavigator<ServerDrivenScreen>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      CompositionLocalProvider(
        LocalComposeNavigator provides composeNavigator
      ) {
        ServerDrivenTheme {
          ServerDrivenNavHost(composeNavigator = composeNavigator)
        }
      }
    }
  }
}
