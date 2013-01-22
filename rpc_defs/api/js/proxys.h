#ifndef GEN_JS_PROXYS_H_
#define GEN_JS_PROXYS_H_

#include "rpc/public/rpc_service_proxy_base.h"
#include "rpc/public/rpc_interface_proxy_base.h"
#include "js/interfaces.h"

namespace RPC
{
    //Proxy for js::ExtensionHandler
    template<>
    class Proxy< js::ExtensionHandler > :
        public js::ExtensionHandler,public RPC::ServiceProxyBase
    {
    
    public:
        Proxy(const std::string& serviceProvider, const RPC::InterfaceHandle& handle):RPC::ServiceProxyBase(js::ExtensionHandler::ServiceName(),serviceProvider, handle)
        {
        }

        
        virtual void BindClient(
              js::ExtensionHandler::Client* client);
        
        virtual void SendRequest(
              int viewId, 
              int callId, 
              int appId, 
              const std::string& methodName, 
              const std::string& requestJson);
        
    private:
        //DISALLOW_COPY_AND_ASSIGN
        Proxy(const Proxy&);
        void operator=(const Proxy&);
    };
    //Proxy for js::ExtensionHandler::Client
    template<>
    class Proxy< js::ExtensionHandler::Client > :
        public js::ExtensionHandler::Client,public RPC::InterfaceProxyBase
    {
    
    public:
        Proxy(const RPC::InterfaceHandle& handle):RPC::InterfaceProxyBase(handle)
        {
        }

        
        virtual void SendResponse(
              int viewId, 
              int callid, 
              const std::string& responseJson);
        
    private:
        //DISALLOW_COPY_AND_ASSIGN
        Proxy(const Proxy&);
        void operator=(const Proxy&);
    };
} // End namespace RPC

#endif //#ifndef GEN_JS_PROXYS_H_
