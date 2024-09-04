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
package io.getstream.server.driven.feature.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.getstream.server.driven.core.designsystem.consumer.Consume
import io.getstream.server.driven.core.designsystem.preview.MockUtils.mockTextUi2
import io.getstream.server.driven.core.designsystem.theme.ServerDrivenTheme
import io.getstream.server.driven.core.model.ImageUi
import io.getstream.server.driven.core.model.UiComponent

@Composable
fun PostDetails(
  detailsUi: UiComponent
) {
  Column(
    modifier = Modifier
      .background(ServerDrivenTheme.colors.background)
      .fillMaxSize()
      .padding(12.dp)
      .verticalScroll(state = rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
      detailsUi.Consume()
    }

    if (detailsUi is ImageUi && detailsUi.title.isNotEmpty()) {
      detailsUi.toTextUi().Consume()
    }

    mockTextUi2.Consume()
  }
}
