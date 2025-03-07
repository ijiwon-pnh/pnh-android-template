package com.pnhglobal.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pnhglobal.data.database.entity.user.UserEntity

class RoomTypeConverters {
    @TypeConverter
    fun stringToMap(value: String): Map<String, String> {
        val type = object : TypeToken<Map<String?, String?>?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun mapToString(value: Map<String, String>): String {
        return Gson().toJson(value)
    }

    /** 예시 */
    @TypeConverter
    fun userListToString(value: List<UserEntity>): String {
        return Gson().toJson(value)
    }

    /** 예시 */
    @TypeConverter
    fun stringToUserList(value: String): List<UserEntity> {
        val type = object : TypeToken<List<UserEntity?>?>() {}.type
        return Gson().fromJson(value, type)
    }
}