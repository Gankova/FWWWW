package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWatcher {
    public String adress;
    public long interval;
    public File file;


    public FileWatcher(String dir, long pollingInterval) {
        this.adress = dir;
        this.interval = pollingInterval;
    }
    ArrayList<HashMap> filearray1 = new ArrayList<>();

    HashMap<String, Long> filearray = new HashMap();

    public void watch(){
        Thread thread = new Thread(() ->{
            for (int i = 0; i < 10; i++){
                File n = new File(adress);
                for (File file : n.listFiles()){
                    if (file.isFile()){
                        filearray.put(file.getName(), file.length());
                    }
                }
                filearray1.add(i,filearray);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i==0){
                    continue;

                }
                System.out.println(i);
                System.out.println(filearray1.get(i).keySet());
                System.out.println(filearray1.get(i-1).keySet());

                //}




            }

        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }


}
















