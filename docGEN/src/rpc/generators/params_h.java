package rpc.generators;

import com.sun.javadoc.*;

public class params_h
{
  protected static String nl;
  public static synchronized params_h create(String lineSeparator)
  {
    nl = lineSeparator;
    params_h result = new params_h();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = NL + "#define ";
  protected final String TEXT_3 = NL + NL + "#include \"ipc/ipc_param_traits.h\"" + NL + "#include \"rpc/public/rpc_interface.h\"" + NL + "#include \"rpc/base/rpc_message_traits.h\"" + NL + "#include \"rpc/base/rpc_param_traits.h\"" + NL + "#include \"rpc/public/rpc_impl_helper.h\"" + NL + "#include \"";
  protected final String TEXT_4 = "\"" + NL + "" + NL + "namespace RPC" + NL + "{";
  protected final String TEXT_5 = NL + "    template<>" + NL + "    struct MethodInfos< ";
  protected final String TEXT_6 = " >" + NL + "    {";
  protected final String TEXT_7 = NL + "        struct ";
  protected final String TEXT_8 = "_Params" + NL + "        {" + NL + "              enum {ID = ";
  protected final String TEXT_9 = " };";
  protected final String TEXT_10 = NL + "              ";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "        };";
  protected final String TEXT_13 = NL + "    };";
  protected final String TEXT_14 = NL + NL + "};" + NL + "" + NL + "namespace IPC" + NL + "{";
  protected final String TEXT_15 = NL + "    " + NL + "    //ParamTraits for ";
  protected final String TEXT_16 = "    " + NL + "     template<>" + NL + "    struct ParamTraits<RPC::MethodInfos< ";
  protected final String TEXT_17 = " >::";
  protected final String TEXT_18 = "_Params >" + NL + "    {" + NL + "          typedef RPC::MethodInfos< ";
  protected final String TEXT_19 = " >::";
  protected final String TEXT_20 = "_Params param_type;" + NL + "            static void Write(Message* m, const param_type& p);" + NL + "            static bool Read(const Message* m, PickleIterator* iter, param_type* r);" + NL + "            static void Log(const param_type& p, std::string* l);" + NL + "    };";
  protected final String TEXT_21 = NL + "    ";
  protected final String TEXT_22 = NL + "    //ParamTraits for ";
  protected final String TEXT_23 = NL + "     template<>" + NL + "    struct ParamTraits<";
  protected final String TEXT_24 = " >" + NL + "    {" + NL + "          typedef ";
  protected final String TEXT_25 = " param_type;" + NL + "            static void Write(Message* m, const param_type& p);" + NL + "            static bool Read(const Message* m, PickleIterator* iter, param_type* r);" + NL + "            static void Log(const param_type& p, std::string* l);" + NL + "    };";
  protected final String TEXT_26 = NL + "};" + NL + "" + NL + "#endif //#ifndef ";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    String header_guide =rpc.Helper.getIncludeGuide(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eParamsHeader);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eInterfaceHeader));
    stringBuffer.append(TEXT_4);
     for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_6);
    
        int methodId = 1; 
        for(MethodDoc method: cls.methods()) { 
        
    stringBuffer.append(TEXT_7);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(methodId++ );
    stringBuffer.append(TEXT_9);
    for(Parameter param: method.parameters()) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(rpc.Helper.parameterStorage(param));
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
     } 
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
     for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    for(MethodDoc method: cls.methods()) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_20);
     } 
     } 
    stringBuffer.append(TEXT_21);
     for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().allClasses()) { 
    if(rpc.Helper.isStructure(cls) || rpc.Helper.isEnum(cls) ) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_25);
     } 
     } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
