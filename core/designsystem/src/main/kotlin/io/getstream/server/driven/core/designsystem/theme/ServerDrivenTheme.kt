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
package io.getstream.server.driven.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf

/**
 * Local providers for various properties we connect to our components, for styling.
 */
private val LocalColors = compositionLocalOf<ServerDrivenColor> {
  error("No colors provided! Make sure to wrap all usages of components in ServerDrivenTheme.")
}

@Stable
@Composable
public fun ServerDrivenTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  colors: ServerDrivenColor = if (darkTheme) {
    ServerDrivenColor.defaultDarkColors()
  } else {
    ServerDrivenColor.defaultColors()
  },
  background: ServerDrivenBackground = ServerDrivenBackground.defaultBackground(darkTheme),
  content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    LocalColors provides colors,
    LocalBackgroundTheme provides background
  ) {
    content()
  }
}

/**
 * Contains ease-of-use accessors for different properties used to style and customize the app
 * look and feel.
 */
public object ServerDrivenTheme {
  /**
   * Retrieves the current [ServerDrivenColor] at the call site's position in the hierarchy.
   */
  public val colors: ServerDrivenColor
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

  /**
   * Retrieves the current [ServerDrivenBackground] at the call site's position in the hierarchy.
   */
  public val background: ServerDrivenBackground
    @Composable
    @ReadOnlyComposable
    get() = LocalBackgroundTheme.current
}
