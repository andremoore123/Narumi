package com.id.narumi.domain

/**
 * Created by: andreputras.
 * Date: 23/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
sealed class Resource <out T> {
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val errorMessage: String): Resource<Nothing>()
}