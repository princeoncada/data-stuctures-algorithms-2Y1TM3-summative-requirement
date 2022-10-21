package class_supports; 
/**
 * this class limits the textfield alright amazing way klaro akong javadocs HAHAHA
 * @author King Aj Magalona
 * 
 */

import javax.swing.text.*;

public class JTextFieldLimit extends PlainDocument {
   private Integer limit;

   public JTextFieldLimit(Integer limit) {
      super();
      this.limit = limit;
   }

   public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
      if (str == null) {
         return;
      }
      if (limit == null || limit < 1 || ((getLength() + str.length()) <= limit)) {
         super.insertString(offs, str, a);
      } else if ((getLength() + str.length()) > limit) {
         String insertsub = str.substring(0, (limit - getLength()));
         super.insertString(offs, insertsub, a);
      }
   }
}
