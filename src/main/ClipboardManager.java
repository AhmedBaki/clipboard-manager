package main;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;
import java.io.*;

public final class ClipboardManager implements ClipboardOwner
{
	//Constructor
	public ClipboardManager()
	{
  }

   /*
   * Empty implementation of the ClipboardOwner interface.
   */
   @Override public void lostOwnership(Clipboard aClipboard, Transferable aContents){
     //do nothing
   }

  /*
  * Place a String on the clipboard, and make this class the
  * owner of the Clipboard's contents.
  */
  public void setClipboard(String aString){
    StringSelection stringSelection = new StringSelection(aString);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, this);
  }

  /*
  * Get contents of the clipboard.
  * if none found, return an empty String.
  */
  public String getClipboard() 
  {
    String result = "";
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable contents = clipboard.getContents(null);
    boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
    
    if (hasTransferableText) {
      try {
        result = (String)contents.getTransferData(DataFlavor.stringFlavor);
      }
      catch (UnsupportedFlavorException | IOException ex){
        System.out.println(ex);
        ex.printStackTrace();
      }
    }
    return result;
  }
} 

