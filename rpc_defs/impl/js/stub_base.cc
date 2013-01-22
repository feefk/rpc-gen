#include "rpc/stub/rpc_service_stub_base.h"
#include "rpc/stub/rpc_interface_stub_base.h"
#include "rpc/stub/rpc_invoke_context.h"
#include "js/interfaces.h"
#include "js/params.h"
#include "js/proxys.h"

namespace RPC
{
    template<>
    bool ServiceStubBase< js::ExtensionHandler >::OnHandleInvoke(
        const RPC::InvokeContext& context)
    {
        switch (context.header.message_type)
        {
        case RPC::MethodInfos<interface_type>::BindClient_Params::ID:
        {
            RPC::MethodInfos<interface_type>::BindClient_Params params;
            IPC::ParamTraits<RPC::MethodInfos<interface_type>::BindClient_Params>::Read(
                    context.message, context.iterator, &params);
            this->BindClient(
                    scoped_refptr<RPC::Proxy<js::ExtensionHandler::Client > >( 
                          new RPC::Proxy< js::ExtensionHandler::Client>(params.client)).get()
            	  );
            break;
        }
     	
        case RPC::MethodInfos<interface_type>::SendRequest_Params::ID:
        {
            RPC::MethodInfos<interface_type>::SendRequest_Params params;
            IPC::ParamTraits<RPC::MethodInfos<interface_type>::SendRequest_Params>::Read(
                    context.message, context.iterator, &params);
            this->SendRequest(
                    params.viewId,
                    params.callId,
                    params.appId,
                    params.methodName,
                    params.requestJson
            	  );
            break;
        }
     	
        default:
            return false;
        }
        return true;
    }
    template<>
    bool InterfaceStubBase< js::ExtensionHandler::Client >::OnHandleInvoke(
        const RPC::InvokeContext& context)
    {
        switch (context.header.message_type)
        {
        case RPC::MethodInfos<interface_type>::SendResponse_Params::ID:
        {
            RPC::MethodInfos<interface_type>::SendResponse_Params params;
            IPC::ParamTraits<RPC::MethodInfos<interface_type>::SendResponse_Params>::Read(
                    context.message, context.iterator, &params);
            this->SendResponse(
                    params.viewId,
                    params.callid,
                    params.responseJson
            	  );
            break;
        }
     	
        default:
            return false;
        }
        return true;
    }
     
}// End namespace RPC



