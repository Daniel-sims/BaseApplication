package com.sims.daniel.baseapplication.utils;

import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class ProjectApplicationCache {

    public SharedPreferences mSharedPreferences;

    public ProjectApplicationCache(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    /*
        Set<String> methods.
     */
    public Set<String> getStringSetForKey(String key) {
        return mSharedPreferences.getStringSet(key, null);
    }

    public void addStringToStringSet(String key, String stringVal) {
        Set<String> currentStringSet = getStringSetForKey(key);
        Set<String> newStringSet = new HashSet<>();

        if (currentStringSet != null) {
            newStringSet = new HashSet<>(currentStringSet);
        }

        if (!newStringSet.contains(stringVal)) {
            newStringSet.add(stringVal);

            mSharedPreferences.edit()
                    .putStringSet(key, newStringSet)
                    .apply();
        }
    }

    /*
        String methods.
     */
    public String getStringForKey(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public void putStringForKey(String key, String stringVal) {
        mSharedPreferences.edit()
                .putString(key, stringVal)
                .apply();
    }

    /*
        Int methods.
     */
    public int getIntForKey(String key) {
        return mSharedPreferences.getInt(key, -1);
    }

    public void putIntForKey(String key, int intVal) {
        mSharedPreferences.edit()
                .putInt(key, intVal)
                .apply();
    }

    /*
        Float methods.
     */
    public float getFloatForKey(String key) {
        return mSharedPreferences.getFloat(key, -1);
    }

    public void putFloatForKey(String key, float floatVal) {
        mSharedPreferences.edit()
                .putFloat(key, floatVal)
                .apply();
    }

    /*
       Long methods.
    */
    public long getLongForKey(String key) {
        return mSharedPreferences.getLong(key, -1);
    }

    public void putLongForKey(String key, long longVal) {
        mSharedPreferences.edit()
                .putLong(key, longVal)
                .apply();
    }

    /*
       Boolean methods.
    */
    public boolean getBooleanForKey(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public void putBooleanForKey(String key, boolean booleanVal) {
        mSharedPreferences.edit()
                .putBoolean(key, booleanVal)
                .apply();
    }
}
