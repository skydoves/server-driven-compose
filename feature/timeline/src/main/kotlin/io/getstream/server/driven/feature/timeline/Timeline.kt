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
package io.getstream.server.driven.feature.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.getstream.server.driven.core.designsystem.consumer.Consume
import io.getstream.server.driven.core.designsystem.preview.DefaultPreview
import io.getstream.server.driven.core.designsystem.preview.MockUtils
import io.getstream.server.driven.core.designsystem.theme.ServerDrivenTheme
import io.getstream.server.driven.core.model.ImageUi
import io.getstream.server.driven.core.model.UiComponent

@Composable
fun ServerDrivenTimeline(
  timelineViewModel: TimelineViewModel = hiltViewModel(),
  navigateToDetails: (UiComponent) -> Unit
) {
  val timelineUi by timelineViewModel.timelineUi.collectAsStateWithLifecycle()

  if (timelineUi != null) {
    ServerDrivenTimelineContent(
      timelineUi = timelineUi!!,
      navigateToDetails = navigateToDetails
    )
  } else {
    Box(modifier = Modifier.fillMaxSize()) {
      CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
  }
}

@Composable
private fun ServerDrivenTimelineContent(
  timelineUi: List<UiComponent>,
  navigateToDetails: (UiComponent) -> Unit
) {
  Column(
    modifier = Modifier
      .background(ServerDrivenTheme.colors.background)
      .fillMaxSize()
      .padding(12.dp)
      .verticalScroll(state = rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    timelineUi.forEach { uiComponent ->
      val modifier = if (uiComponent is ImageUi) {
        Modifier.clickable { navigateToDetails.invoke(uiComponent) }
      } else {
        Modifier
      }

      uiComponent.Consume(
        modifier = modifier,
        onListItemClicked = { clickedComponent ->
          navigateToDetails.invoke(clickedComponent)
        }
      )
    }
  }
}

@DefaultPreview
@Composable
private fun ServerDrivenTimelineContentPreview() {
  ServerDrivenTheme {
    ServerDrivenTimelineContent(
      listOf(
        MockUtils.mockImageUi,
        MockUtils.mockTextUi1,
        MockUtils.mockTextUi2
      ),
      navigateToDetails = {}
    )
  }
}
