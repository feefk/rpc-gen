#include "js/params.h"
namespace IPC
{
    
    //ParamTraits for js::ExtensionHandler    
    void ParamTraits<RPC::MethodInfos<js::ExtensionHandler>::BindClient_Params> ::Write(Message* m, const param_type& p) {        
        WriteParam(m, p.client);
        
    }
    bool ParamTraits<RPC::MethodInfos<js::ExtensionHandler>::BindClient_Params>::Read(const Message* m,
                                    PickleIterator* iter,
                                    param_type* r) {
      return ReadParam(m, iter, &r->client);
    }

    void ParamTraits<RPC::MethodInfos<js::ExtensionHandler>::BindClient_Params>::Log(const param_type& p, std::string* l) {
      // Doesn't make sense to implement this!
    };
        
    void ParamTraits<RPC::MethodInfos<js::ExtensionHandler>::SendRequest_Params> ::Write(Message* m, const param_type& p) {        
        WriteParam(m, p.viewId);
        WriteParam(m, p.callId);
        WriteParam(m, p.appId);
        WriteParam(m, p.methodName);
        WriteParam(m, p.requestJson);
        
    }
    bool ParamTraits<RPC::MethodInfos<js::ExtensionHandler>::SendRequest_Params>::Read(const Message* m,
                                    PickleIterator* iter,
                                    param_type* r) {
      return ReadParam(m, iter, &r->viewId) && 
              ReadParam(m, iter, &r->callId) && 
              ReadParam(m, iter, &r->appId) && 
              ReadParam(m, iter, &r->methodName) && 
              ReadParam(m, iter, &r->requestJson);
    }

    void ParamTraits<RPC::MethodInfos<js::ExtensionHandler>::SendRequest_Params>::Log(const param_type& p, std::string* l) {
      // Doesn't make sense to implement this!
    };
    
    
    //ParamTraits for js::ExtensionHandler::Client    
    void ParamTraits<RPC::MethodInfos<js::ExtensionHandler::Client>::SendResponse_Params> ::Write(Message* m, const param_type& p) {        
        WriteParam(m, p.viewId);
        WriteParam(m, p.callid);
        WriteParam(m, p.responseJson);
        
    }
    bool ParamTraits<RPC::MethodInfos<js::ExtensionHandler::Client>::SendResponse_Params>::Read(const Message* m,
                                    PickleIterator* iter,
                                    param_type* r) {
      return ReadParam(m, iter, &r->viewId) && 
              ReadParam(m, iter, &r->callid) && 
              ReadParam(m, iter, &r->responseJson);
    }

    void ParamTraits<RPC::MethodInfos<js::ExtensionHandler::Client>::SendResponse_Params>::Log(const param_type& p, std::string* l) {
      // Doesn't make sense to implement this!
    };
    
    
};
