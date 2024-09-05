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
package io.getstream.server.driven.core.designsystem.version

import io.getstream.server.driven.core.model.ScreenUi

enum class UiVersion(val value: Int) {
  VERSION_1_0(1),
  VERSION_2_0(2);

  companion object {

    fun toUiVersion(value: Int): UiVersion {
      return when (value) {
        VERSION_1_0.value -> VERSION_1_0
        VERSION_2_0.value -> VERSION_2_0
        else -> VERSION_1_0
      }
    }
  }
}

val ScreenUi.uiVersion: UiVersion
  get() = UiVersion.toUiVersion(version)
