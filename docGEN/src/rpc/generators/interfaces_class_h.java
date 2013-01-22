package rpc.generators;

import com.sun.javadoc.*;

public class interfaces_class_h
{
  protected static String nl;
  public static synchronized interfaces_class_h create(String lineSeparator)
  {
    nl = lineSeparator;
    interfaces_class_h result = new interfaces_class_h();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    //Class ";
  protected final String TEXT_2 = NL + "    class ";
  protected final String TEXT_3 = ": public virtual ";
  protected final String TEXT_4 = "RPC::IService";
  protected final String TEXT_5 = "RPC::IInterface";
  protected final String TEXT_6 = NL + "    {" + NL + "    public:" + NL + "        virtual ~";
  protected final String TEXT_7 = "(){ }";
  protected final String TEXT_8 = NL + "        static const char* ServiceName()" + NL + "        { " + NL + "            return \"";
  protected final String TEXT_9 = "\"; " + NL + "        }";
  protected final String TEXT_10 = NL + "        //Inner Interface Declare";
  protected final String TEXT_11 = NL + "         class ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "         struct ";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "        //Methods ";
  protected final String TEXT_16 = NL + "        virtual void ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = NL + "              ";
  protected final String TEXT_20 = ") = 0;" + NL;
  protected final String TEXT_21 = "        " + NL + "    }; // End Class ";
  protected final String TEXT_22 = NL + "    " + NL + "    //Inner Interface Define";
  protected final String TEXT_23 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    ClassDoc cls = (ClassDoc)argument;
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    stringBuffer.append(TEXT_3);
     
        if(rpc.Helper.isService(cls)) { 
            
    stringBuffer.append(TEXT_4);
    
        }
        else{
            
    stringBuffer.append(TEXT_5);
    
        } 
    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cls.simpleTypeName());
    stringBuffer.append(TEXT_7);
    if(rpc.Helper.isService(cls)){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cls.qualifiedName());
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
     if(cls.innerClasses() != null)
           {
               for(ClassDoc inner: cls.innerClasses())
               {
                       if(rpc.Helper.isService(inner)||rpc.Helper.isInterface(inner)  ) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inner.simpleTypeName());
    stringBuffer.append(TEXT_12);
     
                     }else if(rpc.Helper.isStructure(inner)) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inner.simpleTypeName());
    stringBuffer.append(TEXT_14);
    
                     }else if( rpc.Helper.isEnum(inner) ) { 
                        enum_class_h cg = new enum_class_h();
            
    stringBuffer.append(cg.generate(inner));
    
                     } 
                 }
           }
        
    stringBuffer.append(TEXT_15);
    
        for(MethodDoc method: cls.methods()) { 
        
    stringBuffer.append(TEXT_16);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_17);
    
              boolean isFirstMethod = true;
              for(Parameter param: method.parameters()) { 
                  if(isFirstMethod)
                  {
                      isFirstMethod = false;
                  }
                  else
                  {
                      
    stringBuffer.append(TEXT_18);
    
                  }
              
    stringBuffer.append(TEXT_19);
    stringBuffer.append(rpc.Helper.parameterDeclare(param));
     }//End for params 
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cls.name().replace('.', ':').replace(":", "::"));
    stringBuffer.append(TEXT_22);
     if(cls.innerClasses() != null)
    {
         for(ClassDoc inner: cls.innerClasses())
         {
             if( rpc.Helper.isInterface(inner) || rpc.Helper.isService(inner) ) 
        { 
            interfaces_class_h cg = new interfaces_class_h();
            
    stringBuffer.append(cg.generate(inner));
    
        } else if (rpc.Helper.isEnum(inner))
        {
            
        }else if ( rpc.Helper.isStructure(inner))
        {
            structure_class_h cg = new structure_class_h();
            
    stringBuffer.append(cg.generate(inner));
    
        }
          
         }
    }
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
