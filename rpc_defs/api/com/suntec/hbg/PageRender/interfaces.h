#ifndef GEN_COM_SUNTEC_HBG_PAGERENDER_INTERFACES_H_
#define GEN_COM_SUNTEC_HBG_PAGERENDER_INTERFACES_H_
#include "rpc/public/rpc_interface.h"
namespace com{ namespace suntec{ namespace hbg{ namespace PageRender{ 
    //Class FactoryService
    class FactoryService: public virtual RPC::IService
    {
    public:
        virtual ~FactoryService(){ }
        static const char* ServiceName()
        { 
        	return "com.suntec.hbg.PageRender.FactoryService"; 
        }
        //Inner Interface Declare
         class IPageRender;
         class IRenderClient;
        
        //Methods 
        virtual void CreateRenderInstance(
              com::suntec::hbg::PageRender::FactoryService::IRenderClient* client) = 0;
        
    }; // End Class FactoryService
    
    //Inner Interface Define
    //Class FactoryService::IPageRender
    class FactoryService::IPageRender: public virtual RPC::IInterface
    {
    public:
        virtual ~IPageRender(){ }
        //Inner Interface Declare
        
        //Methods 
        virtual void CreateView(
              int viewHandle) = 0;
        
    }; // End Class FactoryService::IPageRender
    
    //Inner Interface Define
    
    //Class FactoryService::IRenderClient
    class FactoryService::IRenderClient: public virtual RPC::IInterface
    {
    public:
        virtual ~IRenderClient(){ }
        //Inner Interface Declare
        
        //Methods 
        virtual void OnInstanceCreate(
              com::suntec::hbg::PageRender::FactoryService::IPageRender* render) = 0;
        
    }; // End Class FactoryService::IRenderClient
    
    //Inner Interface Define
    
    






}; }; }; }; 

#endif //#ifndef GEN_COM_SUNTEC_HBG_PAGERENDER_INTERFACES_H_
