package ken.projects.infit.data.models

import java.time.DayOfWeek

data class WorkoutPlan (
    val name:String? = null,
    val workouts:ArrayList<DayOfWeek>? = null,
    val difficulty: String?  = null,
    val duration:Int? = null,
)
