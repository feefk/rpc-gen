
#include "rpc/public/rpc_service_proxy_base.h"
#include "rpc/proxy/rpc_proxy_helper.h"
#include "rpc/base/rpc_param_traits.h"
#include "rpc/base/rpc_thread_state.h"
#include "rpc/master/service_master_proxy.h"
#include "js/proxys.h"
#include "js/interfaces.h"
#include "js/params.h"
namespace RPC
{
    //Proxy methods for js::ExtensionHandler    
	
        
     void Proxy< js::ExtensionHandler >::BindClient(
              js::ExtensionHandler::Client* client)
      {
        RPC::Message::Header header;        
        header.message_type = RPC::MethodInfos<js::ExtensionHandler>::BindClient_Params::ID;        
        header.source.peer = ProcessState::self()->master_proxy()->localPeerId();
        IPC::Message* msg = new IPC::Message(this->handle().address, RPC::Message::ID, IPC::Message::PRIORITY_NORMAL);
        IPC::ParamTraits<RPC::Message::Header>::Write(msg, header);
        IPC::ParamTraits< RPC::InterfaceHandle >::Write(msg, client->handle());
        helper_->Send(msg);
       }
        
     void Proxy< js::ExtensionHandler >::SendRequest(
              int viewId, 
              int callId, 
              int appId, 
              const std::string& methodName, 
              const std::string& requestJson)
      {
        RPC::Message::Header header;        
        header.message_type = RPC::MethodInfos<js::ExtensionHandler>::SendRequest_Params::ID;        
        header.source.peer = ProcessState::self()->master_proxy()->localPeerId();
        IPC::Message* msg = new IPC::Message(this->handle().address, RPC::Message::ID, IPC::Message::PRIORITY_NORMAL);
        IPC::ParamTraits<RPC::Message::Header>::Write(msg, header);
        IPC::ParamTraits< int >::Write(msg, viewId);
        IPC::ParamTraits< int >::Write(msg, callId);
        IPC::ParamTraits< int >::Write(msg, appId);
        IPC::ParamTraits< std::string >::Write(msg, methodName);
        IPC::ParamTraits< std::string >::Write(msg, requestJson);
        helper_->Send(msg);
       }
    //Proxy methods for js::ExtensionHandler::Client    
	
        
     void Proxy< js::ExtensionHandler::Client >::SendResponse(
              int viewId, 
              int callid, 
              const std::string& responseJson)
      {
        RPC::Message::Header header;        
        header.message_type = RPC::MethodInfos<js::ExtensionHandler::Client>::SendResponse_Params::ID;        
        header.source.peer = ProcessState::self()->master_proxy()->localPeerId();
        IPC::Message* msg = new IPC::Message(this->handle().address, RPC::Message::ID, IPC::Message::PRIORITY_NORMAL);
        IPC::ParamTraits<RPC::Message::Header>::Write(msg, header);
        IPC::ParamTraits< int >::Write(msg, viewId);
        IPC::ParamTraits< int >::Write(msg, callid);
        IPC::ParamTraits< std::string >::Write(msg, responseJson);
        helper_->Send(msg);
       }

    //ServiceProxyFactorys 
     template<>
     Proxy<js::ExtensionHandler>* ServiceProxyFactory<js::ExtensionHandler>::CreateServiceProxy(const std::string& provider)
     {
         InterfaceHandle handle = ThreadState::self()->masterProxy()->getService(service_type::ServiceName(), provider);
         if(handle.peer == 0 || handle.address == 0)
         {
             return NULL;
         }else
         {
             Proxy<service_type>* proxy =  new Proxy<service_type>(provider, handle);
             proxy->AddRef();
             return proxy;
         }
     }
     	
} // End namespace RPC

