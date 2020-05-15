package com.jeden.jappanappprogram;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface WordDao {


    @Query("SELECT * from word_table")
    LiveData<List<Word>> getAlphabetizedWords();

    @Query("SELECT * FROM word_table ORDER BY RANDOM() LIMIT 1")
    LiveData<List<Word>>  getRandomRow();

    @Delete
    void deleteWord(Word word);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();
}
