package org.example.storage.adapter;

public class FileOrderAdapterFactory {
    public FileOrderAdapter getAdapter(String path){
        if (path.endsWith(".txt")){
            return new TxtFileOrderAdapter();
        } else {
            return new NoneExtensionFileOrderAdapter();
        }
    }
}
