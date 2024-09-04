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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.getstream.server.driven.core.designsystem.extension.heightDp
import io.getstream.server.driven.core.designsystem.extension.widthDp
import io.getstream.server.driven.core.designsystem.preview.DefaultPreview
import io.getstream.server.driven.core.designsystem.preview.MockUtils
import io.getstream.server.driven.core.designsystem.theme.ServerDrivenTheme
import io.getstream.server.driven.core.model.LayoutType
import io.getstream.server.driven.core.model.ListUi
import io.getstream.server.driven.core.model.UiComponent
import io.getstream.server.driven.core.model.toLayoutType
import io.getstream.server.driven.core.model.typedValue

@Composable
fun ConsumeList(
  listUi: ListUi,
  modifier: Modifier = Modifier,
  onListItemClicked: (UiComponent) -> Unit
) {
  val layoutType = listUi.layout.toLayoutType()

  when (layoutType) {
    LayoutType.GRID -> {
      LazyHorizontalGrid(
        modifier = modifier
          .fillMaxWidth()
          .height(listUi.itemSize.heightDp()),
        rows = GridCells.Adaptive(minSize = listUi.itemSize.widthDp()),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        items(items = listUi.items, key = { it.url }) { imageUi ->
          Box(
            modifier = Modifier
              .clickable { onListItemClicked.invoke(imageUi) }
              .clip(RoundedCornerShape(8.dp))
              .size(
                width = listUi.itemSize.widthDp(),
                height = listUi.itemSize.widthDp()
              )
          ) {
            ConsumeImageUi(
              imageUi = imageUi.copy(size = listUi.itemSize)
            )

            val like = listUi.extra["like"].typedValue(false)
            if (like) {
              Icon(
                modifier = Modifier
                  .align(Alignment.TopEnd)
                  .padding(6.dp),
                imageVector = Icons.Filled.Favorite,
                tint = ServerDrivenTheme.colors.error,
                contentDescription = null
              )
            }

            val banner = listUi.extra["banner"].typedValue(false)
            if (banner) {
              Text(
                modifier = Modifier
                  .background(Color.Black.copy(alpha = 0.65f))
                  .fillMaxWidth()
                  .align(Alignment.BottomCenter)
                  .padding(vertical = 6.dp),
                text = imageUi.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
              )
            }
          }
        }
      }
    }

    LayoutType.COLUMN -> Unit // no-op

    LayoutType.ROW -> Unit // no-op
  }
}

@DefaultPreview
@Composable
private fun ConsumeListPreview() {
  ServerDrivenTheme {
    ConsumeList(
      listUi = MockUtils.mockListUi,
      onListItemClicked = {}
    )
  }
}
