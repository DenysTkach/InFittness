package ken.projects.infit.ui.composables.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ken.projects.infit.R
import ken.projects.infit.ui.composables.RegularButton
import ken.projects.infit.ui.composables.home.Heading
import ken.projects.infit.ui.composables.home.Title
import ken.projects.infit.ui.theme.darkBlue
import ken.projects.infit.viewmodel.UserViewModel
import ken.projects.infit.viewmodel.WorkoutViewModel

@Composable
fun ProfileScreen(
    userViewModel: UserViewModel,
    workoutViewModel: WorkoutViewModel,
    navController: NavHostController
) {

    val user = workoutViewModel.user
    val uid = userViewModel.signInState.uid

    LaunchedEffect(Unit) {
        if (uid != null) {
            workoutViewModel.getUser(uid)
        }
    }

    Surface(modifier = Modifier.fillMaxSize(), color = darkBlue) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Heading(text = stringResource(id = R.string.profile))

            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Title(text = "Username: ${user?.userName ?: "Loading..."}")
                Title(text = "Email: ${user?.userEmail ?: "Loading..."}")
            }


            RegularButton(
                text = stringResource(id = R.string.logout),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                userViewModel.logOut()
                navController.popBackStack()
            }
        }
    }

}
