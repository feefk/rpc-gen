#ifndef GEN_JS_INTERFACES_H_
#define GEN_JS_INTERFACES_H_
#include "rpc/public/rpc_interface.h"
#include "com/suntec/hbg/PageRender/interfaces.h"
namespace js{ 
    //Class ExtensionHandler
    class ExtensionHandler: public virtual RPC::IService
    {
    public:
        virtual ~ExtensionHandler(){ }
        static const char* ServiceName()
        { 
        	return "js.ExtensionHandler"; 
        }
        //Inner Interface Declare
         class Client;
        
        //Methods 
        virtual void BindClient(
              js::ExtensionHandler::Client* client) = 0;

        virtual void SendRequest(
              int viewId, 
              int callId, 
              int appId, 
              const std::string& methodName, 
              const std::string& requestJson) = 0;
        
    }; // End Class ExtensionHandler
    
    //Inner Interface Define
    //Class ExtensionHandler::Client
    class ExtensionHandler::Client: public virtual RPC::IInterface
    {
    public:
        virtual ~Client(){ }
        //Inner Interface Declare
        
        //Methods 
        virtual void SendResponse(
              int viewId, 
              int callid, 
              const std::string& responseJson) = 0;
        
    }; // End Class ExtensionHandler::Client
    
    //Inner Interface Define
    
    




}; 

#endif //#ifndef GEN_JS_INTERFACES_H_
