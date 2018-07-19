package com.mobile_core.base.databases;

/**
 * Created by picher on 2018/6/6.
 * Describe：
 */

public interface BaseDataBasesHandler<T> {

    /**
     * Insert Databases model
     * @param dbItem some module for create
     */
    void insertData(String tableName, T... dbItem);

    /**
     * Delete Databases model
     * @param dbItem some module for delete
     */
    void deleteData(String tableName, T... dbItem);

    /**
     * Update Databases module
     * @param dbItem some module for update
     */
    void updateData(String tableName, T... dbItem);
}
