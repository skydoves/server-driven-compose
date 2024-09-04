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

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
public data class ServerDrivenBackground(
  val color: Color = Color.Unspecified,
  val tonalElevation: Dp = Dp.Unspecified
) {
  public companion object {
    public fun defaultBackground(darkTheme: Boolean): ServerDrivenBackground {
      return if (darkTheme) {
        ServerDrivenBackground(
          color = Color.Black,
          tonalElevation = 0.dp
        )
      } else {
        ServerDrivenBackground(
          color = Color.White,
          tonalElevation = 0.dp
        )
      }
    }
  }
}

public val LocalBackgroundTheme: ProvidableCompositionLocal<ServerDrivenBackground> =
  staticCompositionLocalOf { ServerDrivenBackground() }
