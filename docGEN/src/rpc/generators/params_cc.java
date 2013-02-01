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

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = "#include \""; //$NON-NLS-1$
  protected final String TEXT_2 = "\"" + NL + "namespace IPC" + NL + "{" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_3 = "    " + NL + "    //ParamTraits for "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "    void ParamTraits<RPC::MethodInfos<"; //$NON-NLS-1$
  protected final String TEXT_6 = ">::"; //$NON-NLS-1$
  protected final String TEXT_7 = "_Params> ::Write(Message* m, const param_type& p) {        " + NL; //$NON-NLS-1$
  protected final String TEXT_8 = "        WriteParam(m, p."; //$NON-NLS-1$
  protected final String TEXT_9 = ");" + NL; //$NON-NLS-1$
  protected final String TEXT_10 = "        " + NL + "    }" + NL + "    bool ParamTraits<RPC::MethodInfos<"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_11 = ">::"; //$NON-NLS-1$
  protected final String TEXT_12 = "_Params>::Read(const Message* m," + NL + "                                    PickleIterator* iter," + NL + "                                    param_type* r) {" + NL + "      return true"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_13 = " && "; //$NON-NLS-1$
  protected final String TEXT_14 = "              ReadParam(m, iter, &r->"; //$NON-NLS-1$
  protected final String TEXT_15 = ")"; //$NON-NLS-1$
  protected final String TEXT_16 = ";" + NL + "    }" + NL + NL + "    void ParamTraits<RPC::MethodInfos<"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_17 = ">::"; //$NON-NLS-1$
  protected final String TEXT_18 = "_Params>::Log(const param_type& p, std::string* l) {" + NL + "      // Doesn't make sense to implement this!" + NL + "    };" + NL + "    " + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_19 = "    //ParamTraits for "; //$NON-NLS-1$
  protected final String TEXT_20 = NL + "    void ParamTraits<"; //$NON-NLS-1$
  protected final String TEXT_21 = " >::Write(Message* m, const param_type& p) {        " + NL; //$NON-NLS-1$
  protected final String TEXT_22 = "        WriteParam(m, p."; //$NON-NLS-1$
  protected final String TEXT_23 = ");" + NL; //$NON-NLS-1$
  protected final String TEXT_24 = "        " + NL + "    }" + NL + "    bool ParamTraits<"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_25 = " >::Read(const Message* m," + NL + "                                    PickleIterator* iter," + NL + "                                    param_type* r) {" + NL + "      return true"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_26 = " && "; //$NON-NLS-1$
  protected final String TEXT_27 = "              ReadParam(m, iter, &r->"; //$NON-NLS-1$
  protected final String TEXT_28 = ")"; //$NON-NLS-1$
  protected final String TEXT_29 = ";" + NL + "    }" + NL + NL + "    void ParamTraits<"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_30 = " >::Log(const param_type& p, std::string* l) {" + NL + "      // Doesn't make sense to implement this!" + NL + "    };" + NL + "    " + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_31 = "    " + NL; //$NON-NLS-1$
  protected final String TEXT_32 = "    //ParamTraits for "; //$NON-NLS-1$
  protected final String TEXT_33 = NL + "    void ParamTraits<"; //$NON-NLS-1$
  protected final String TEXT_34 = " >::Write(Message* m, const param_type& p) {        " + NL + "        ParamTraits<int>::Write(m, (int)p);" + NL + "    }" + NL + "    bool ParamTraits<"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_35 = " >::Read(const Message* m," + NL + "                                    PickleIterator* iter," + NL + "                                    param_type* r) {" + NL + "      return ParamTraits<int>::Read(m, iter, (int*)r);" + NL + "    }" + NL + NL + "    void ParamTraits<"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_36 = " >::Log(const param_type& p, std::string* l) {" + NL + "      // Doesn't make sense to implement this!" + NL + "    };" + NL + "    " + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_37 = "    " + NL + "};" + NL; //$NON-NLS-1$ //$NON-NLS-2$

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eParamsHeader));
    stringBuffer.append(TEXT_2);
 for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_4);
for(MethodDoc method: cls.methods()) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_7);
for(Parameter param: method.parameters()) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_9);
 } 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_12);

              for(Parameter param: method.parameters()) {
                  
    stringBuffer.append(TEXT_13);
    stringBuffer.append(this.NL  
);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_15);

               }// end for Parameter 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_18);
 } 
 } 
 for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().allClasses()) { 
if(rpc.Helper.isStructure(cls)) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_21);
for(FieldDoc param: cls.fields()) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_23);
 } 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_25);

              for(FieldDoc param: cls.fields()) {
                  
    stringBuffer.append(TEXT_26);
    stringBuffer.append(this.NL  
);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_28);

               }// end for fields 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_30);
 } 
 } 
    stringBuffer.append(TEXT_31);
 for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().allClasses()) { 
if(rpc.Helper.isEnum(cls)) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(rpc.Helper.convertCPPType(cls));
    stringBuffer.append(TEXT_36);
 } 
 } 
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
