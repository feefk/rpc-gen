package rpc.generators;

import com.sun.javadoc.*;

public class params_cc
{
  protected static String nl;
  public static synchronized params_cc create(String lineSeparator)
  {
    nl = lineSeparator;
    params_cc result = new params_cc();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#include \"";
  protected final String TEXT_2 = "\"" + NL + "namespace IPC" + NL + "{";
  protected final String TEXT_3 = NL + "    " + NL + "    //ParamTraits for ";
  protected final String TEXT_4 = "    " + NL + "    void ParamTraits<RPC::MethodInfos<";
  protected final String TEXT_5 = ">::";
  protected final String TEXT_6 = "_Params> ::Write(Message* m, const param_type& p) {        ";
  protected final String TEXT_7 = NL + "        WriteParam(m, p.";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "        " + NL + "    }" + NL + "    bool ParamTraits<RPC::MethodInfos<";
  protected final String TEXT_10 = ">::";
  protected final String TEXT_11 = "_Params>::Read(const Message* m," + NL + "                                    PickleIterator* iter," + NL + "                                    param_type* r) {" + NL + "      return true";
  protected final String TEXT_12 = " && ";
  protected final String TEXT_13 = "              ReadParam(m, iter, &r->";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = ";" + NL + "    }" + NL + "" + NL + "    void ParamTraits<RPC::MethodInfos<";
  protected final String TEXT_16 = ">::";
  protected final String TEXT_17 = "_Params>::Log(const param_type& p, std::string* l) {" + NL + "      // Doesn't make sense to implement this!" + NL + "    };" + NL + "    ";
  protected final String TEXT_18 = NL + "    //ParamTraits for ";
  protected final String TEXT_19 = NL + "    void ParamTraits<";
  protected final String TEXT_20 = " >::Write(Message* m, const param_type& p) {        ";
  protected final String TEXT_21 = NL + "        WriteParam(m, p.";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "        " + NL + "    }" + NL + "    bool ParamTraits<";
  protected final String TEXT_24 = " >::Read(const Message* m," + NL + "                                    PickleIterator* iter," + NL + "                                    param_type* r) {" + NL + "      return true";
  protected final String TEXT_25 = " && ";
  protected final String TEXT_26 = "              ReadParam(m, iter, &r->";
  protected final String TEXT_27 = ")";
  protected final String TEXT_28 = ";" + NL + "    }" + NL + "" + NL + "    void ParamTraits<";
  protected final String TEXT_29 = " >::Log(const param_type& p, std::string* l) {" + NL + "      // Doesn't make sense to implement this!" + NL + "    };" + NL + "    ";
  protected final String TEXT_30 = NL + "    " + NL + "};";
  protected final String TEXT_31 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eParamsHeader));
    stringBuffer.append(TEXT_2);
     for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    for(MethodDoc method: cls.methods()) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_6);
    for(Parameter param: method.parameters()) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_11);
    
              for(Parameter param: method.parameters()) {
                  
    stringBuffer.append(TEXT_12);
    stringBuffer.append(this.NL  
);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_14);
    
               }// end for Parameter 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_17);
     } 
     } 
     for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().allClasses()) { 
    if(rpc.Helper.isStructure(cls)) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_20);
    for(FieldDoc param: cls.fields()) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_24);
    
              for(FieldDoc param: cls.fields()) {
                  
    stringBuffer.append(TEXT_25);
    stringBuffer.append(this.NL  
);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_27);
    
               }// end for fields 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_29);
     } 
     } 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
