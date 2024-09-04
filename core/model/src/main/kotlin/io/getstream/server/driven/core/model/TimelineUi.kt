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
package io.getstream.server.driven.core.model

import kotlinx.serialization.Serializable

@Serializable
data class TimelineUi(
  val top: TimelineTopUi,
  val center: TimelineCenterUi,
  val bottom: TimelineBottomUi
) : UiComponent

@Serializable
data class TimelineTopUi(
  override val order: Int,
  val banner: ImageUi
) : OrderedUiComponent

@Serializable
data class TimelineCenterUi(
  override val order: Int,
  val title: TextUi,
  val list: ListUi
) : OrderedUiComponent

@Serializable
data class TimelineBottomUi(
  override val order: Int,
  val title: TextUi,
  val list: ListUi
) : OrderedUiComponent
