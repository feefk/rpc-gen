package rpc.generators;

import com.sun.javadoc.*;

public class structure_class_h
{
  protected static String nl;
  public static synchronized structure_class_h create(String lineSeparator)
  {
    nl = lineSeparator;
    structure_class_h result = new structure_class_h();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    //struct ";
  protected final String TEXT_2 = NL + "    struct ";
  protected final String TEXT_3 = NL + "    {" + NL + "        //member of structure ";
  protected final String TEXT_4 = NL + "        ";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "    }; // End Class ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    ClassDoc cls = (ClassDoc)argument;
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    
        for(FieldDoc field: cls.fields()) { 
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rpc.Helper.getFieldTraitsType(field));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(field.name());
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    return stringBuffer.toString();
  }
}
