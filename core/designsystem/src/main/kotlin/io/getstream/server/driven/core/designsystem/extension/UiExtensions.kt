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
package io.getstream.server.driven.core.designsystem.extension

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.getstream.server.driven.core.model.DpSizeUi

fun DpSizeUi.widthDp(): Dp = width.dp

fun DpSizeUi.heightDp(): Dp = height.dp

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.size(dpSizeUi: DpSizeUi): Modifier = composed {
  val configuration = LocalConfiguration.current
  val width = if (dpSizeUi.width == 0) {
    configuration.screenWidthDp.dp
  } else {
    dpSizeUi.widthDp()
  }
  val height = if (dpSizeUi.height == 0) {
    configuration.screenHeightDp.dp
  } else {
    dpSizeUi.heightDp()
  }
  size(width = width, height = height)
}
