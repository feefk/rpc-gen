package rpc.generators;

import com.sun.javadoc.*;

public class enum_class_h
{
  protected static String nl;
  public static synchronized enum_class_h create(String lineSeparator)
  {
    nl = lineSeparator;
    enum_class_h result = new enum_class_h();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = NL + NL + "        //enum "; //$NON-NLS-1$
  protected final String TEXT_2 = NL + "        enum "; //$NON-NLS-1$
  protected final String TEXT_3 = NL + "        {" + NL; //$NON-NLS-1$
  protected final String TEXT_4 = "                "; //$NON-NLS-1$
  protected final String TEXT_5 = "," + NL; //$NON-NLS-1$
  protected final String TEXT_6 = "        }; // End enum "; //$NON-NLS-1$

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();

    ClassDoc cls = (ClassDoc)argument;
    
    stringBuffer.append("");
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cls.simpleTypeName());
    stringBuffer.append(TEXT_3);

            for(FieldDoc field: cls.fields()) { 
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(field.name());
    stringBuffer.append(TEXT_5);
 } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    return stringBuffer.toString();
  }
}
