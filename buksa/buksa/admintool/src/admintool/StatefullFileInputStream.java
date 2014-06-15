/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admintool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author dbondin
 */
public class StatefullFileInputStream extends FileInputStream {
    public StatefullFileInputStream(String name) throws FileNotFoundException {
        this(new File(name));
    }
    
    public StatefullFileInputStream(File file) throws FileNotFoundException {
        super(file);
        
        offset = 0L;
        fileSize = file.length();
        listeners = new java.util.ArrayList<IStatefullFileInputStreamListener>();
    }
    
    public void addStatefullFileInputStreamListener(IStatefullFileInputStreamListener listener) {
        if(listener == null) {
            return;
        }
        
        if(listeners.contains(listener) != true) {
            listeners.add(listener);
        }
    }
    
    public void removeStatefullFileInputStreamListener(IStatefullFileInputStreamListener listener) {
        if(listener == null) {
            return;
        }
        
        if(listeners.contains(listener) == true) {
            listeners.remove(listener);
        }
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        offset ++;
        notifyInputStreamRead();
        return data;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int rlen = super.read(b);
        if(rlen > 0) {
            offset += rlen;
        }
        notifyInputStreamRead();
        return rlen;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int rlen = super.read(b, off, len);
        if(rlen > 0) {
            offset += rlen;
        }
        notifyInputStreamRead();
        return rlen;
    }

    @Override
    public void close() throws IOException {
        super.close();
        notifyInputStreamClose();
    }

    private void notifyInputStreamRead() {
        for(IStatefullFileInputStreamListener listener : listeners) {
            listener.statefullFileInputStreamRead(this, offset, fileSize);
        }
    }
    
    private void notifyInputStreamClose() {
        for(IStatefullFileInputStreamListener listener : listeners) {
            listener.statefullFileInputStreamClose(this);
        }        
    }
    
    private long offset = 0L;
    private long fileSize = 0L;
    private List<IStatefullFileInputStreamListener> listeners = null;
}
