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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.getstream.server.driven.core.designsystem.preview.MockUtils
import io.getstream.server.driven.core.designsystem.theme.ServerDrivenTheme
import io.getstream.server.driven.core.model.TextUi

@Composable
fun ConsumeTextUi(
  textUi: TextUi,
  modifier: Modifier = Modifier
) {
  Text(
    modifier = modifier,
    text = textUi.text,
    color = ServerDrivenTheme.colors.textHighEmphasis,
    fontSize = textUi.size.sp,
    fontWeight = textUi.fontWeight.toFontWeight()
  )
}

@Preview
@Composable
private fun ConsumeTextUiPreview() {
  ServerDrivenTheme {
    Column(
      modifier = Modifier
        .background(ServerDrivenTheme.colors.background)
        .fillMaxWidth()
    ) {
      ConsumeTextUi(textUi = MockUtils.mockTextUi1)
      ConsumeTextUi(textUi = MockUtils.mockTextUi2)
    }
  }
}
