package com.one.spring.study;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileTest {

    @Test
    public void deletePom(){
//        String filePath = "/Users/zjf1650/Develop/workspace/unipay-parent";
//        deleteFileEndsWith(filePath, ".iml");
        String filePath = "/Users/zjf1650/Develop/workspace/unipay-mini";
        File pathFile = new File(filePath);
        deleteFileDirWithName(pathFile, "target");
    }

    public void deleteFileEndsWith(String filePath, String endsStr){
        File pathFile = new File(filePath);
        if(pathFile.isFile()){
            if(pathFile.getName().endsWith(endsStr)){
                pathFile.delete();
                System.out.println("file delete : " + pathFile.getName());
            }
            return;
        }
        File[] listFiles = pathFile.listFiles();
        if(listFiles != null && listFiles.length > 0){
            for(File listFile : listFiles){
//                if(listFile.isFile() && listFile.getName().endsWith(endsStr)){
//                    listFile.delete();
//                    System.out.println("file delete : " + listFile.getName());
//                }
                deleteFileEndsWith(listFile.getPath(), endsStr);
            }
        }
    }

    public void deleteFileDirWithName(File pathFile, String fileName){
        //File pathFile = new File(filePath);
        if(pathFile == null || pathFile.isFile()){
            return;
        }
        if(pathFile.isDirectory() && pathFile.getName().equalsIgnoreCase(fileName)){
//            boolean flag = pathFile.delete();
//            if(flag){
//                System.out.println("directory delete : " + pathFile.getPath() + pathFile.getName());
//            }
            deleteDirectoryLegacyIO(pathFile);
        }
        File[] listFiles = pathFile.listFiles();
        if(listFiles != null && listFiles.length > 0){
            for (File listFile : listFiles){
                deleteFileDirWithName(listFile, fileName);
            }
        }
    }


    private void deleteDirectoryLegacyIO(File file) {

        File[] list = file.listFiles();  //无法做到list多层文件夹数据
        if (list != null) {
            for (File temp : list) {     //先去递归删除子文件夹及子文件
                deleteDirectoryLegacyIO(temp);   //注意这里是递归调用
            }
        }

        if (file.delete()) {     //再删除自己本身的文件夹
            System.out.printf("删除成功 : %s%n", file);
        } else {
            System.err.printf("删除失败 : %s%n", file);
        }
    }
}
