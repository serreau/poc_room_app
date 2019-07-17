package sero.com.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sero.com.entities.Job;

@Dao
public interface JobDao {
    @Insert
    void insert(Job job);

    @Delete
    void delete(Job job);

    @Update
    void update(Job job);

    @Query("SELECT * FROM Job WHERE id = (:id)")
    LiveData<Job> get(long id);

    @Query("SELECT * FROM Job WHERE name LIKE '%' || :name || '%'")
    LiveData<List<Job>> contains(String name);

    @Query("SELECT * FROM Job")
    LiveData<List<Job>> getAll();
}
