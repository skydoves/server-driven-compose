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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
public data class ServerDrivenColor(
  val primary: Color,
  val secondary: Color,
  val background: Color,
  val tertiary: Color,
  val error: Color,
  val textHighEmphasis: Color,
  val textMediumEmphasis: Color,
  val textLowEmphasis: Color,
  val textPlaceholder: Color,
  val black5: Color,
  val black10: Color,
  val black20: Color,
  val black40: Color,
  val black50: Color,
  val black60: Color,
  val black80: Color,
  val black100: Color,
  val white100: Color,
  val divider: Color,
  val disabled: Color,
  val textOverlay: Color,
  val shimmerBase: Color,
  val shimmerHighlight: Color,
  val absoluteWhite: Color,
  val absoluteBlack: Color
) {

  public companion object {
    /**
     * Provides the default colors for the light mode of the app.
     *
     * @return A [ServerDrivenColor] instance holding our color palette.
     */
    @Composable
    public fun defaultColors(): ServerDrivenColor = ServerDrivenColor(
      primary = Primary,
      secondary = Color(0xFF6644FF),
      background = Color.White,
      error = Color(0xFFe93c3c),
      tertiary = Color(0xFFA966FF),
      textHighEmphasis = DarkGray100,
      textMediumEmphasis = Black80,
      textLowEmphasis = Black40,
      textPlaceholder = Black40,
      textOverlay = Black10,
      black5 = Black5,
      black10 = Black10,
      black20 = Black20,
      black40 = Black40,
      black50 = Black50,
      black60 = Black60,
      black80 = Black80,
      black100 = Color.Black,
      white100 = Color.White,
      divider = Gray80,
      disabled = Gray80,
      shimmerBase = Black5,
      shimmerHighlight = ShimmerHighlight,
      absoluteWhite = Color.White,
      absoluteBlack = Color.Black
    )

    /**
     * Provides the default colors for the dark mode of the app.
     *
     * @return A [ServerDrivenColor] instance holding our color palette.
     */
    @Composable
    public fun defaultDarkColors(): ServerDrivenColor = ServerDrivenColor(
      primary = Primary,
      secondary = Color(0xFF6644FF),
      background = Color.Black,
      error = Color(0xFFe93c3c),
      tertiary = Color(0xFFA966FF),
      textHighEmphasis = Color.White,
      textMediumEmphasis = Black80,
      textLowEmphasis = Black40,
      textPlaceholder = Black80,
      textOverlay = Black10,
      black5 = Black5,
      black10 = Color.White,
      black20 = Black20,
      black40 = Black40,
      black50 = Black50,
      black60 = Black60,
      black80 = Black80,
      black100 = Color.White,
      white100 = Color.White,
      divider = Gray80,
      disabled = Gray80,
      shimmerBase = Color(0xFF6F6F6F),
      shimmerHighlight = ShimmerHighlight,
      absoluteWhite = Color.White,
      absoluteBlack = Color.Black
    )
  }
}

private val Primary: Color = Color(0xFF8D3BEE)

public val Black5: Color = Color(0xFFf4f4f4)
public val Black10: Color = Color(0xFFE9E9EA)
public val Black20: Color = Color(0xFFd3d4d5)
public val Black40: Color = Color(0xFFa8a9aa)
public val Black50: Color = Color(0x80000000)
public val Black60: Color = Color(0xFF7c7e80)
public val Black80: Color = Color(0xFF515355)

public val Gray80: Color = Color(0xFFE8E8E8)
public val DarkGray100: Color = Color(0xFF25282B)

public val ShimmerHighlight: Color = Color(0xFFDFDEDE)
public val ProgressTrack: Color = Color(0x33FFFFFF)
