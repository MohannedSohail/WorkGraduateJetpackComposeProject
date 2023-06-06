package com.example.workgraduateproject

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

object FileHelper {

    fun mapUrisToPaths(uris: List<Uri>): MutableList<String> {
        val paths = arrayListOf<String>()
        uris.forEach { uri ->

//            paths.add(PathUtil.getMediaPath(uri, contentResolver).toString())

            uri.path?.let { paths.add(it) }

        }
        return paths
    }

    fun mapPathsToFiles(paths: List<String>): MutableList<File> {
        val file = arrayListOf<File>()

        paths.forEach { path ->
            file.add(File(path))
        }
        return file
    }

    fun convertStringToList(jsonString: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(jsonString, type)
    }
}