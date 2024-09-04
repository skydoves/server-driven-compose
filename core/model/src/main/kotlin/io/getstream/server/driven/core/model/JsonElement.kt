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
@file:Suppress("UNCHECKED_CAST")

package io.getstream.server.driven.core.model

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

private fun JsonPrimitive.toAnyValue(): Any? {
  val content = this.content
  if (this.isString) {
    // add custom string convert
    return content
  }
  if (content.equals("null", ignoreCase = true)) {
    return null
  }
  if (content.equals("true", ignoreCase = true)) {
    return true
  }
  if (content.equals("false", ignoreCase = true)) {
    return false
  }
  val intValue = content.toIntOrNull()
  if (intValue != null) {
    return intValue
  }
  val longValue = content.toLongOrNull()
  if (longValue != null) {
    return longValue
  }
  val doubleValue = content.toDoubleOrNull()
  if (doubleValue != null) {
    return doubleValue
  }
  throw Exception("Parsing exception")
}

fun JsonElement?.toAnyOrNull(): Any? {
  return when (this) {
    null -> null
    is JsonNull -> null
    is JsonPrimitive -> toAnyValue()
    // !!! key convert back custom object
    is JsonObject -> this.map { it.key to it.value.toAnyOrNull() }.toMap()
    is JsonArray -> this.map { it.toAnyOrNull() }
  }
}

fun <T> JsonElement?.typedValue(default: T): T {
  return toAnyOrNull() as? T ?: default
}
