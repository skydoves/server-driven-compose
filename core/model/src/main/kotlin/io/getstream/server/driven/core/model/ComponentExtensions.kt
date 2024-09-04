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

import kotlin.reflect.full.memberProperties

fun UiComponent.buildUiComponentList(
  uiComponents: List<UiComponent> = emptyList()
): List<UiComponent> {
  val mutableUiLists = mutableListOf<UiComponent>()
  mutableUiLists.addAll(uiComponents)

  this.javaClass.kotlin.memberProperties.sortedBy { member ->
    val uiComponent = member.get(this) as? OrderedUiComponent
    uiComponent?.order
  }.forEach { parent ->
    val uiComponent = parent.get(this) as? UiComponent ?: return@forEach
    var isNested = false
    uiComponent.javaClass.kotlin.memberProperties.reversed().forEach { child ->
      val childComponent = child.get(uiComponent) as? UiComponent
      if (childComponent != null) {
        mutableUiLists.add(childComponent)
        childComponent.buildUiComponentList(mutableUiLists)
        isNested = true
      }
    }

    if (!isNested) {
      mutableUiLists.add(uiComponent)
    }
  }
  return mutableUiLists
}
