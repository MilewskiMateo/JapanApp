package com.example.jappanappprogram;


import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;


class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
    void delete(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.deleteWord(word);
        });
    }
    void deleteAll() {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.deleteAll();
        });
    }


    public LiveData<List<Word>> getRandomRow() {
        return mWordDao.getRandomRow();
    }
}