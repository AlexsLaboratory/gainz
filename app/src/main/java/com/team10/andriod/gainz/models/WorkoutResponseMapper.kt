package com.team10.andriod.gainz.models

interface WorkoutResponseMapper<Response, Model> {
  abstract fun mapFromResponse(response: Response) : Model
}