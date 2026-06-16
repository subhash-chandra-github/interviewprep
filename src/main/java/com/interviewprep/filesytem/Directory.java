package com.interviewprep.filesytem;

import java.util.HashMap;
import java.util.Map;

public class Directory {

    String name;
    Map<String, Directory> directories;
    Map<String, File> files;

    public Directory(String name) {
        this.name = name;
        this.directories = new HashMap<>();
        this.files = new HashMap<>();
    }
}
