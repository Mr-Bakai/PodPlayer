package com.bakai.podplayer.db

import android.content.Context
import androidx.room.*
import com.bakai.podplayer.model.Episode
import com.bakai.podplayer.model.Podcast
import kotlinx.coroutines.CoroutineScope
import java.util.*

class Converters {
  @TypeConverter
  fun fromTimestamp(value: Long?): Date? {
    return if (value == null) null else Date(value)
  }

  @TypeConverter
  fun toTimestamp(date: Date?): Long? {
    return (date?.time)
  }
}

@Database(entities = [Podcast::class, Episode::class], version = 1)
@TypeConverters(Converters::class)
abstract class PodPlayDatabase : RoomDatabase() {

  abstract fun podcastDao(): PodcastDao


  companion object {


    @Volatile
    private var INSTANCE: PodPlayDatabase? = null


    fun getInstance(context: Context): PodPlayDatabase {
      val tempInstance = INSTANCE
      if (tempInstance != null) {
        return tempInstance
      }


      synchronized(this) {
        val instance = Room.databaseBuilder(context.applicationContext,
            PodPlayDatabase::class.java,
            "PodPlayer")
            .build()
        INSTANCE = instance

        return instance
      }
    }
  }
}
