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
package io.getstream.server.driven.compose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import io.getstream.server.driven.core.designsystem.theme.ServerDrivenTheme
import io.getstream.server.driven.core.navigation.AppComposeNavigator
import io.getstream.server.driven.core.navigation.ServerDrivenScreen
import io.getstream.server.driven.feature.details.PostDetails
import io.getstream.server.driven.feature.timeline.ServerDrivenTimeline

@Composable
fun ServerDrivenNavHost(
  modifier: Modifier = Modifier,
  composeNavigator: AppComposeNavigator<ServerDrivenScreen>,
  navController: NavHostController = rememberNavController(),
  startDestination: ServerDrivenScreen = ServerDrivenScreen.Timeline
) {
  LaunchedEffect(Unit) {
    composeNavigator.handleNavigationCommands(navController)
  }

  NavHost(
    modifier = modifier
      .fillMaxSize()
      .statusBarsPadding()
      .background(ServerDrivenTheme.colors.background),
    navController = navController,
    startDestination = startDestination
  ) {
    composable<ServerDrivenScreen.Timeline> {
      ServerDrivenTimeline(
        navigateToDetails = { component ->
          composeNavigator.navigate(ServerDrivenScreen.Details(component))
        }
      )
    }

    composable<ServerDrivenScreen.Details>(
      typeMap = ServerDrivenScreen.Details.typeMap
    ) { backStackEntry ->
      val root: ServerDrivenScreen.Details = backStackEntry.toRoute()
      val ui = root.ui
      PostDetails(detailsUi = ui)
    }
  }
}
