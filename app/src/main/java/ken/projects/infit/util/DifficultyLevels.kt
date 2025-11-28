package ken.projects.infit.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ken.projects.infit.R

sealed class DifficultyLevels() {

    data class Difficulty(
        val name: String,
        @StringRes
        val difficulty: Int? = null,
        @DrawableRes
        val icon: Int? = null
    )

    companion object {
        val Beginner = Difficulty("Beginner", R.string.beginner, R.drawable.ic_skill_level_basic_icon)
        val Intermediate = Difficulty("Intermediate", R.string.intermediate, R.drawable.ic_skill_level_intermediate_icon)
        val Advanced = Difficulty("Advanced", R.string.advanced, R.drawable.ic_skill_level_advanced_icon)

        fun getDifficultyLevelByName(name: String?): Difficulty {
            return when (name) {
                "Beginner" -> Beginner
                "Intermediate" -> Intermediate
                "Advanced" -> Advanced
                else -> Beginner
            }
        }
    }


}
