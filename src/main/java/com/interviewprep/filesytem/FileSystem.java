package com.interviewprep.filesytem;

public class FileSystem {

    Directory root;

    public FileSystem(String name) {
        this.root = new Directory(name);
    }

    void mkdir(String path){
        String[] paths = path.split("/");
        Directory d = getRoot(root, paths, 0, true);
        Directory newDirectory = new Directory(paths[paths.length-1]);
        d.directories.put(paths[paths.length-1], newDirectory);
    }

    void addFile(String filePath, int fileSize){
        String[] paths = filePath.split("/");
        Directory d = getRoot(root, paths, 0, false);
        File file = new File(paths[paths.length-1], fileSize);
        d.files.put(paths[paths.length-1], file);
    }

    void delete(String path){
        String[] paths = path.split("/");
        String name = paths[paths.length-1];
        Directory parent = getRoot(root, paths, 0, false);
        if(name.contains(".")){ // it is a file
            if(!parent.files.containsKey(name)){
                throw new IllegalArgumentException("File Not found");
            }
            parent.files.remove(name);
        }else{
            if(!parent.directories.containsKey(name)){
                throw new IllegalArgumentException("Directory Not found");
            }
            parent.directories.remove(name);
        }
    }

    int getSize(String path){
        String[] paths = path.split("/");
        String name = paths[paths.length-1];
        Directory parent = getRoot(root, paths, 0, false);
        if(name.contains(".")){ // it is a file
            File file = parent.files.get(name);
            if(file == null){
                throw new IllegalArgumentException("File Not found");
            }
            return file.size;
        }else{
            Directory target = parent.directories.get(name);
            if(target == null){
                return getSizeRecursive(parent);
            }
            return getSizeRecursive(target);
        }
    }

    int getSizeRecursive(Directory directory){
        int size = 0;
        for(File file : directory.files.values()){
            size = size + file.size;
        }
        for(Directory subDir : directory.directories.values()){
            size = size + getSizeRecursive(subDir);
        }
        return size;
    }

    Directory getRoot(Directory directory, String[] paths, int idx, boolean createIfAbsent){
        if(idx == paths.length - 1){
            return directory;
        }
        String path = paths[idx];
        if(path.isEmpty() || path.equals(directory.name)){
            return getRoot(directory, paths, idx+1, createIfAbsent);
        }
        Directory next = directory.directories.get(path);
        if(next != null){
            return getRoot(next, paths, idx+1, createIfAbsent);
        }
        if(createIfAbsent){
            Directory newDir = new Directory(path);
            directory.directories.put(path, newDir);
            return getRoot(newDir, paths, idx+1, createIfAbsent);
        }
        return directory;
    }

    public static void main(String[] args) {
//        fs = FileSystem()
//
//        fs.mkdir("/home/user")
//        fs.addFile("/home/user/doc1.txt", 100)
//        fs.addFile("/home/user/doc2.txt", 200)
//        fs.mkdir("/home/user/photos")
//        fs.addFile("/home/user/photos/photo1.jpg", 500)
//
//        print(fs.getSize("/home/user"))  # Returns 800
//        print(fs.getSize("/home/user/photos"))  # Returns 500
//
//        fs.delete("/home/user/doc1.txt")
//        print(fs.getSize("/home/user"))  # Returns 700
//
//        fs.delete("/home/user")
//        print(fs.getSize("/home"))  # Returns 0

        FileSystem fs = new FileSystem("root");
        fs.mkdir("/home/user");
        fs.addFile("/home/user/doc1.txt", 100);
        fs.addFile("/home/user/doc2.txt", 200);
        System.out.println(fs.getSize("root/home/user"));

        fs.mkdir("/home/user/photos");
        fs.addFile("/home/user/photos/photo1.jpg", 500);
        System.out.println(fs.getSize("/home/user")); // # Returns 800


        System.out.println(fs.getSize("/home/user/photos"));  //# Returns 500

        fs.delete("/home/user/doc1.txt");
        System.out.println(fs.getSize("/home/user"));//  # Returns 700

        fs.delete("/home/user");
        System.out.println(fs.getSize("/home"));



    }


}
