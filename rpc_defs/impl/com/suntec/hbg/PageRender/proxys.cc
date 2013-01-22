
#include "rpc/public/rpc_service_proxy_base.h"
#include "rpc/proxy/rpc_proxy_helper.h"
#include "rpc/base/rpc_param_traits.h"
#include "rpc/base/rpc_thread_state.h"
#include "rpc/master/service_master_proxy.h"
#include "com/suntec/hbg/PageRender/proxys.h"
#include "com/suntec/hbg/PageRender/interfaces.h"
#include "com/suntec/hbg/PageRender/params.h"
namespace RPC
{
    //Proxy methods for com::suntec::hbg::PageRender::FactoryService    
	
        
     void Proxy< com::suntec::hbg::PageRender::FactoryService >::CreateRenderInstance(
              com::suntec::hbg::PageRender::FactoryService::IRenderClient* client)
      {
        RPC::Message::Header header;        
        header.message_type = RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService>::CreateRenderInstance_Params::ID;        
        header.source.peer = ProcessState::self()->master_proxy()->localPeerId();
        IPC::Message* msg = new IPC::Message(this->handle().address, RPC::Message::ID, IPC::Message::PRIORITY_NORMAL);
        IPC::ParamTraits<RPC::Message::Header>::Write(msg, header);
        IPC::ParamTraits< RPC::InterfaceHandle >::Write(msg, client->handle());
        helper_->Send(msg);
       }
    //Proxy methods for com::suntec::hbg::PageRender::FactoryService::IPageRender    
	
        
     void Proxy< com::suntec::hbg::PageRender::FactoryService::IPageRender >::CreateView(
              int viewHandle)
      {
        RPC::Message::Header header;        
        header.message_type = RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IPageRender>::CreateView_Params::ID;        
        header.source.peer = ProcessState::self()->master_proxy()->localPeerId();
        IPC::Message* msg = new IPC::Message(this->handle().address, RPC::Message::ID, IPC::Message::PRIORITY_NORMAL);
        IPC::ParamTraits<RPC::Message::Header>::Write(msg, header);
        IPC::ParamTraits< int >::Write(msg, viewHandle);
        helper_->Send(msg);
       }
    //Proxy methods for com::suntec::hbg::PageRender::FactoryService::IRenderClient    
	
        
     void Proxy< com::suntec::hbg::PageRender::FactoryService::IRenderClient >::OnInstanceCreate(
              com::suntec::hbg::PageRender::FactoryService::IPageRender* render)
      {
        RPC::Message::Header header;        
        header.message_type = RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IRenderClient>::OnInstanceCreate_Params::ID;        
        header.source.peer = ProcessState::self()->master_proxy()->localPeerId();
        IPC::Message* msg = new IPC::Message(this->handle().address, RPC::Message::ID, IPC::Message::PRIORITY_NORMAL);
        IPC::ParamTraits<RPC::Message::Header>::Write(msg, header);
        IPC::ParamTraits< RPC::InterfaceHandle >::Write(msg, render->handle());
        helper_->Send(msg);
       }

    //ServiceProxyFactorys 
     template<>
     Proxy<com::suntec::hbg::PageRender::FactoryService>* ServiceProxyFactory<com::suntec::hbg::PageRender::FactoryService>::CreateServiceProxy(const std::string& provider)
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

