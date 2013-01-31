package rpc.generators;

import com.sun.javadoc.*;

public class proxys_cc
{
  protected static String nl;
  public static synchronized proxys_cc create(String lineSeparator)
  {
    nl = lineSeparator;
    proxys_cc result = new proxys_cc();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = NL + "#include \"rpc/public/rpc_service_proxy_base.h\"" + NL + "#include \"rpc/proxy/rpc_proxy_helper.h\"" + NL + "#include \"rpc/base/rpc_param_traits.h\"" + NL + "#include \"rpc/base/rpc_thread_state.h\"" + NL + "#include \"rpc/master/service_master_proxy.h\"" + NL + "#include \""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_2 = "\"" + NL + "#include \""; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_3 = "\"" + NL + "#include \""; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_4 = "\"" + NL + "namespace RPC" + NL + "{" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_5 = "    //Proxy methods for "; //$NON-NLS-1$
  protected final String TEXT_6 = "    " + NL; //$NON-NLS-1$
  protected final String TEXT_7 = "        " + NL + "     void Proxy< "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_8 = " >::"; //$NON-NLS-1$
  protected final String TEXT_9 = "("; //$NON-NLS-1$
  protected final String TEXT_10 = ", "; //$NON-NLS-1$
  protected final String TEXT_11 = NL + "              "; //$NON-NLS-1$
  protected final String TEXT_12 = ")" + NL + "      {" + NL + "        RPC::Message::Header header;        " + NL + "        header.message_type = RPC::MethodInfos<"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_13 = ">::"; //$NON-NLS-1$
  protected final String TEXT_14 = "_Params::ID;        " + NL + "        header.source.peer = ProcessState::self()->master_proxy()->localPeerId();" + NL + "        IPC::Message* msg = new IPC::Message(this->handle().address, RPC::Message::ID, IPC::Message::PRIORITY_NORMAL);" + NL + "        IPC::ParamTraits<RPC::Message::Header>::Write(msg, header);" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_15 = "        IPC::ParamTraits< "; //$NON-NLS-1$
  protected final String TEXT_16 = " >::Write(msg, "; //$NON-NLS-1$
  protected final String TEXT_17 = "->handle()"; //$NON-NLS-1$
  protected final String TEXT_18 = ");" + NL; //$NON-NLS-1$
  protected final String TEXT_19 = "        helper_->Send(msg);" + NL + "       }" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_20 = NL + "    //ServiceProxyFactorys " + NL; //$NON-NLS-1$
  protected final String TEXT_21 = "     template<>" + NL + "     Proxy<"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_22 = ">* ServiceProxyFactory<"; //$NON-NLS-1$
  protected final String TEXT_23 = ">::CreateServiceProxy(const std::string& provider)" + NL + "     {" + NL + "         InterfaceHandle handle = ThreadState::self()->masterProxy()->getService(service_type::ServiceName(), provider);" + NL + "         if(handle.peer == 0 || handle.address == 0)" + NL + "         {" + NL + "             return NULL;" + NL + "         }else" + NL + "         {" + NL + "             Proxy<service_type>* proxy =  new Proxy<service_type>(provider, handle);" + NL + "             proxy->AddRef();" + NL + "             return proxy;" + NL + "         }" + NL + "     }" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
  protected final String TEXT_24 = "} // End namespace RPC" + NL + NL; //$NON-NLS-1$

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eProxyHeader));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eInterfaceHeader));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rpc.Helper.getRelativePath(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eParamsHeader));
    stringBuffer.append(TEXT_4);
 for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 

        String cppClassName = rpc.Helper.convertCPPType(cls);
        if(rpc.Helper.isService(cls) || rpc.Helper.isInterface(cls) ) {
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_6);

       for(MethodDoc method: cls.methods()) { 
        
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_9);

              boolean isFirstMethod = true;
              for(Parameter param: method.parameters()) { 
                  if(isFirstMethod)
                  {
                      isFirstMethod = false;
                  }
                  else
                  {
                      
    stringBuffer.append(TEXT_10);

                  }
              
    stringBuffer.append(TEXT_11);
    stringBuffer.append(rpc.Helper.parameterDeclare(param));
 }//End for params 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(method.name());
    stringBuffer.append(TEXT_14);

        for(Parameter param: method.parameters()) {
        //if(rpc.Helper.isInterface(rpc.Context.Get().getRoot().classNamed(param.type()))
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(rpc.Helper.getParamTraitsType(param));
    stringBuffer.append(TEXT_16);

        	if(rpc.Helper.isInterface(param))
        	{
        		
    stringBuffer.append(param.name());
    stringBuffer.append(TEXT_17);

        	}else
        	{
        		
    stringBuffer.append(param.name());

        	}
        
    stringBuffer.append(TEXT_18);
 }//End for params 
    stringBuffer.append(TEXT_19);
 }//End Method 
}//end if(rpc.Helper.isService(cls) || rpc.Helper.isInterface(cls) )
}
    stringBuffer.append(TEXT_20);
 for(ClassDoc cls: rpc.Context.Get().getCurrentPackage().interfaces()) { 

        String cppClassName = rpc.Helper.convertCPPType(cls);
        if(rpc.Helper.isService(cls)) {
    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cppClassName);
    stringBuffer.append(TEXT_23);
}//end if(rpc.Helper.isService(cls))
}
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
