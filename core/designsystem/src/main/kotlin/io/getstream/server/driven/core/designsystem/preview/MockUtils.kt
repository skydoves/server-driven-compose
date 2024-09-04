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
package io.getstream.server.driven.core.designsystem.preview

import io.getstream.server.driven.core.model.DpSizeUi
import io.getstream.server.driven.core.model.ImageUi
import io.getstream.server.driven.core.model.LayoutType
import io.getstream.server.driven.core.model.ListUi
import io.getstream.server.driven.core.model.TextUi
import kotlin.random.Random

object MockUtils {

  val mockTextUi1 = TextUi(
    text = "Title",
    size = 32,
    fontWeight = "bold"
  )

  val mockTextUi2 = TextUi(
    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    size = 23,
    fontWeight = "normal"
  )

  val mockImageUi: ImageUi
    get() = ImageUi(
      url = Random.nextInt(10000).toString(),
      scaleType = "crop",
      size = DpSizeUi(0, 250)
    )

  val mockListUi = ListUi(
    layout = LayoutType.GRID.value,
    itemSize = DpSizeUi(120, 120),
    items = listOf(
      mockImageUi,
      mockImageUi,
      mockImageUi,
      mockImageUi
    )
  )
}
