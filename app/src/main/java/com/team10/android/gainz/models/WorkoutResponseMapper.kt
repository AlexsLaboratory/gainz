package com.team10.android.gainz.models

interface WorkoutResponseMapper<Response, Model> {
  abstract fun mapFromResponse(response: Response) : Model
}