package rpc.generators;

import com.sun.javadoc.*;

public class proxys_h
{
  protected static String nl;
  public static synchronized proxys_h create(String lineSeparator)
  {
    nl = lineSeparator;
    proxys_h result = new proxys_h();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = NL + "#define ";
  protected final String TEXT_3 = NL + NL + "#include \"rpc/public/rpc_service_proxy_base.h\"" + NL + "#include \"rpc/public/rpc_interface_proxy_base.h\"" + NL + "#include \"";
  protected final String TEXT_4 = "\"" + NL + "" + NL + "namespace RPC" + NL + "{";
  protected final String TEXT_5 = NL + "    //Proxy for ";
  protected final String TEXT_6 = NL + "    template<>" + NL + "    class Proxy< ";
  protected final String TEXT_7 = " > :" + NL + "        public ";
  protected final String TEXT_8 = ",";
  protected final String TEXT_9 = "public RPC::ServiceProxyBase";
  protected final String TEXT_10 = "public RPC::InterfaceProxyBase";
  protected final String TEXT_11 = NL + "    {" + NL + "    " + NL + "    public:" + NL + "        Proxy(";
  protected final String TEXT_12 = "const std::string& serviceProvider, ";
  protected final String TEXT_13 = "const RPC::InterfaceHandle& handle)";
  protected final String TEXT_14 = ":RPC::ServiceProxyBase(";
  protected final String TEXT_15 = "::ServiceName(),serviceProvider, handle)";
  protected final String TEXT_16 = ":RPC::InterfaceProxyBase(handle)";
  protected final String TEXT_17 = NL + "        {" + NL + "        }" + NL;
  protected final String TEXT_18 = NL + "        " + NL + "        virtual void ";
  protected final String TEXT_19 = "(";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = NL + "              ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "        " + NL + "    private:" + NL + "        //DISALLOW_COPY_AND_ASSIGN" + NL + "        Proxy(const Proxy&);" + NL + "        void operator=(const Proxy&);" + NL + "    };";
  protected final String TEXT_24 = NL + "} // End namespace RPC" + NL + "" + NL + "#endif //#ifndef ";
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    String header_guide =rpc.Helper.getIncludeGuide(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eProxyHeader);
     

    stringBuffer.append(TEXT_1);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eInterfaceHeader));
    stringBuffer.append(TEXT_4);
     for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 
    
        String cppClassName = rpc.Helper.convertCPPType(cls);
        boolean isService = rpc.Helper.isService(cls);
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_8);
    if(isService){
    stringBuffer.append(TEXT_9);
    }else{
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    if(isService){
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
                   if(isService){
               
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_15);
    
               }else{
               
    stringBuffer.append(TEXT_16);
    
               }
    stringBuffer.append(TEXT_17);
    
        for(MethodDoc method: cls.methods()) { 
        
    stringBuffer.append(TEXT_18);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_19);
    
              boolean isFirstMethod = true;
              for(Parameter param: method.parameters()) { 
                  if(isFirstMethod)
                  {
                      isFirstMethod = false;
                  }
                  else
                  {
                      
    stringBuffer.append(TEXT_20);
    
                  }
              
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rpc.Helper.parameterDeclare(param));
     }//End for params 
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
