package rpc.generators;

import com.sun.javadoc.*;

public class stubs_cc
{
  protected static String nl;
  public static synchronized stubs_cc create(String lineSeparator)
  {
    nl = lineSeparator;
    stubs_cc result = new stubs_cc();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = "#include \"rpc/stub/rpc_service_stub_base.h\"" + NL + "#include \"rpc/stub/rpc_interface_stub_base.h\"" + NL + "#include \"rpc/stub/rpc_invoke_context.h\"" + NL + "#include \""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_2 = "\"" + NL + "#include \""; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_3 = "\"" + NL + "#include \""; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_4 = "\"" + NL + NL + "namespace RPC" + NL + "{" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_5 = "    template<>" + NL + "    bool ServiceStubBase< "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_6 = NL + "    template<>" + NL + "    bool InterfaceStubBase< "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_7 = " >::OnHandleInvoke(" + NL + "        const RPC::InvokeContext& context)" + NL + "    {" + NL + "        switch (context.header.message_type)" + NL + "        {" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
  protected final String TEXT_8 = "        case RPC::MethodInfos<interface_type>::"; //$NON-NLS-1$
  protected final String TEXT_9 = "_Params::ID:" + NL + "        {" + NL + "            RPC::MethodInfos<interface_type>::"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_10 = "_Params params;" + NL + "            IPC::ParamTraits<RPC::MethodInfos<interface_type>::"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_11 = "_Params>::Read(" + NL + "                    context.message, context.iterator, &params);" + NL + "            this->"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_12 = "("; //$NON-NLS-1$
  protected final String TEXT_13 = ","; //$NON-NLS-1$
  protected final String TEXT_14 = NL + "                    params."; //$NON-NLS-1$
  protected final String TEXT_15 = NL + "                    scoped_refptr<RPC::Proxy<"; //$NON-NLS-1$
  protected final String TEXT_16 = " > >( " + NL + "                          new RPC::Proxy< "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_17 = ">(params."; //$NON-NLS-1$
  protected final String TEXT_18 = ")).get()"; //$NON-NLS-1$
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = "            \t  );" + NL + "            break;" + NL + "        }" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_21 = "        default:" + NL + "            return false;" + NL + "        }" + NL + "        return true;" + NL + "    }" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
  protected final String TEXT_22 = "     " + NL + "}// End namespace RPC" + NL + NL + NL + NL; //$NON-NLS-1$ //$NON-NLS-2$

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eInterfaceHeader));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eParamsHeader));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eProxyHeader));
    stringBuffer.append(TEXT_4);
 for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 

    String cppClassName = rpc.Helper.convertCPPType(cls);
    if(rpc.Helper.isService(cls)) {
    
    stringBuffer.append(TEXT_5);
} else if(rpc.Helper.isInterface(cls)){
    stringBuffer.append(TEXT_6);
 }else {
       continue; 
    } 
    stringBuffer.append(cppClassName );
    stringBuffer.append(TEXT_7);
 for(MethodDoc method: cls.methods()) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_12);

              boolean isFirstMethod = true;
              for(Parameter param: method.parameters()) { 
                  if(isFirstMethod) { isFirstMethod = false; }
                  else { 
    stringBuffer.append(TEXT_13);
 } 
                  if(!rpc.Helper.isInterface(param))
			    	{
    stringBuffer.append(TEXT_14);
    stringBuffer.append(param.name());

			    	}else
			    	{
    stringBuffer.append(TEXT_15);
    stringBuffer.append(param.type().qualifiedTypeName().replace('.',':').replace(":","::"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(param.type().qualifiedTypeName().replace('.',':').replace(":","::"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_18);

			    	}
                  
    stringBuffer.append(TEXT_19);
 }//End for params 
    stringBuffer.append(TEXT_20);
 } //for(MethodDoc method: cls.methods()) 
    stringBuffer.append(TEXT_21);
 } //for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) 
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
