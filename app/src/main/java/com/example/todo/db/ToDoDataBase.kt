package com.example.todo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [ToDoEntity::class], version = 3, exportSchema = false)
abstract class ToDoDataBase: RoomDatabase() {

    abstract val dataDao: ToDoDao

    companion object {

            @Volatile
            private var INSTANCE: ToDoDataBase? = null

            fun getInstance(context: Context): ToDoDataBase {
                synchronized(this) {
                    var instance = INSTANCE

                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            ToDoDataBase::class.java,
                            "to_do_database"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }

}