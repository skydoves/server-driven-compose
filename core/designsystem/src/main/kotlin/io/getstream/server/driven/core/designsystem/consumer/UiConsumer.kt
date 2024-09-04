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
package io.getstream.server.driven.core.designsystem.consumer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.getstream.server.driven.core.model.ImageUi
import io.getstream.server.driven.core.model.ListUi
import io.getstream.server.driven.core.model.TextUi
import io.getstream.server.driven.core.model.UiComponent

@Composable
fun UiComponent.Consume(
  modifier: Modifier = Modifier,
  onListItemClicked: (UiComponent) -> Unit = {}
) {
  when (this) {
    is TextUi -> ConsumeTextUi(textUi = this, modifier = modifier)
    is ImageUi -> ConsumeImageUi(imageUi = this, modifier = modifier)
    is ListUi -> ConsumeList(
      listUi = this,
      modifier = modifier,
      onListItemClicked = onListItemClicked
    )

    else -> ConsumeDefaultUi(uiComponent = this)
  }
}
