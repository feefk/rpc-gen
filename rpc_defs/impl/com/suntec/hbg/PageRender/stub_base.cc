#include "rpc/stub/rpc_service_stub_base.h"
#include "rpc/stub/rpc_interface_stub_base.h"
#include "rpc/stub/rpc_invoke_context.h"
#include "com/suntec/hbg/PageRender/interfaces.h"
#include "com/suntec/hbg/PageRender/params.h"
#include "com/suntec/hbg/PageRender/proxys.h"

namespace RPC
{
    template<>
    bool ServiceStubBase< com::suntec::hbg::PageRender::FactoryService >::OnHandleInvoke(
        const RPC::InvokeContext& context)
    {
        switch (context.header.message_type)
        {
        case RPC::MethodInfos<interface_type>::CreateRenderInstance_Params::ID:
        {
            RPC::MethodInfos<interface_type>::CreateRenderInstance_Params params;
            IPC::ParamTraits<RPC::MethodInfos<interface_type>::CreateRenderInstance_Params>::Read(
                    context.message, context.iterator, &params);
            this->CreateRenderInstance(
                    scoped_refptr<RPC::Proxy<com::suntec::hbg::PageRender::FactoryService::IRenderClient > >( 
                          new RPC::Proxy< com::suntec::hbg::PageRender::FactoryService::IRenderClient>(params.client)).get()
            	  );
            break;
        }
     	
        default:
            return false;
        }
        return true;
    }
    template<>
    bool InterfaceStubBase< com::suntec::hbg::PageRender::FactoryService::IPageRender >::OnHandleInvoke(
        const RPC::InvokeContext& context)
    {
        switch (context.header.message_type)
        {
        case RPC::MethodInfos<interface_type>::CreateView_Params::ID:
        {
            RPC::MethodInfos<interface_type>::CreateView_Params params;
            IPC::ParamTraits<RPC::MethodInfos<interface_type>::CreateView_Params>::Read(
                    context.message, context.iterator, &params);
            this->CreateView(
                    params.viewHandle
            	  );
            break;
        }
     	
        default:
            return false;
        }
        return true;
    }
    template<>
    bool InterfaceStubBase< com::suntec::hbg::PageRender::FactoryService::IRenderClient >::OnHandleInvoke(
        const RPC::InvokeContext& context)
    {
        switch (context.header.message_type)
        {
        case RPC::MethodInfos<interface_type>::OnInstanceCreate_Params::ID:
        {
            RPC::MethodInfos<interface_type>::OnInstanceCreate_Params params;
            IPC::ParamTraits<RPC::MethodInfos<interface_type>::OnInstanceCreate_Params>::Read(
                    context.message, context.iterator, &params);
            this->OnInstanceCreate(
                    scoped_refptr<RPC::Proxy<com::suntec::hbg::PageRender::FactoryService::IPageRender > >( 
                          new RPC::Proxy< com::suntec::hbg::PageRender::FactoryService::IPageRender>(params.render)).get()
            	  );
            break;
        }
     	
        default:
            return false;
        }
        return true;
    }
     
}// End namespace RPC



