#ifndef GEN_JS_PARAMS_H_
#define GEN_JS_PARAMS_H_

#include "ipc/ipc_param_traits.h"
#include "rpc/public/rpc_interface.h"
#include "rpc/base/rpc_message_traits.h"
#include "rpc/base/rpc_param_traits.h"
#include "rpc/public/rpc_impl_helper.h"
#include "js/interfaces.h"

namespace RPC
{
    template<>
    struct MethodInfos< js::ExtensionHandler >
    {
        struct BindClient_Params
        {
              enum {ID = 1 };
              RPC::InterfaceHandle client;
        };
        struct SendRequest_Params
        {
              enum {ID = 2 };
              int viewId;
              int callId;
              int appId;
              std::string methodName;
              std::string requestJson;
        };
    };
    template<>
    struct MethodInfos< js::ExtensionHandler::Client >
    {
        struct SendResponse_Params
        {
              enum {ID = 1 };
              int viewId;
              int callid;
              std::string responseJson;
        };
    };

};

namespace IPC
{
    
    //ParamTraits for js::ExtensionHandler    
     template<>
    struct ParamTraits<RPC::MethodInfos< js::ExtensionHandler >::BindClient_Params >
    {
          typedef RPC::MethodInfos< js::ExtensionHandler >::BindClient_Params param_type;
            static void Write(Message* m, const param_type& p);
            static bool Read(const Message* m, PickleIterator* iter, param_type* r);
            static void Log(const param_type& p, std::string* l);
    };    
     template<>
    struct ParamTraits<RPC::MethodInfos< js::ExtensionHandler >::SendRequest_Params >
    {
          typedef RPC::MethodInfos< js::ExtensionHandler >::SendRequest_Params param_type;
            static void Write(Message* m, const param_type& p);
            static bool Read(const Message* m, PickleIterator* iter, param_type* r);
            static void Log(const param_type& p, std::string* l);
    };
    
    //ParamTraits for js::ExtensionHandler::Client    
     template<>
    struct ParamTraits<RPC::MethodInfos< js::ExtensionHandler::Client >::SendResponse_Params >
    {
          typedef RPC::MethodInfos< js::ExtensionHandler::Client >::SendResponse_Params param_type;
            static void Write(Message* m, const param_type& p);
            static bool Read(const Message* m, PickleIterator* iter, param_type* r);
            static void Log(const param_type& p, std::string* l);
    };    
};

#endif //#ifndef GEN_JS_PARAMS_H_
