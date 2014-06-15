/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admintool;

/**
 *
 * @author dbondin
 */
public interface IStatefullFileInputStreamListener {
    public void statefullFileInputStreamRead(StatefullFileInputStream stream, long offset, long fileSize);
    public void statefullFileInputStreamClose(StatefullFileInputStream stream);
}
