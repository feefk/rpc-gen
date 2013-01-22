#ifndef GEN_COM_SUNTEC_HBG_PAGERENDER_PROXYS_H_
#define GEN_COM_SUNTEC_HBG_PAGERENDER_PROXYS_H_

#include "rpc/public/rpc_service_proxy_base.h"
#include "rpc/public/rpc_interface_proxy_base.h"
#include "com/suntec/hbg/PageRender/interfaces.h"

namespace RPC
{
    //Proxy for com::suntec::hbg::PageRender::FactoryService
    template<>
    class Proxy< com::suntec::hbg::PageRender::FactoryService > :
        public com::suntec::hbg::PageRender::FactoryService,public RPC::ServiceProxyBase
    {
    
    public:
        Proxy(const std::string& serviceProvider, const RPC::InterfaceHandle& handle):RPC::ServiceProxyBase(com::suntec::hbg::PageRender::FactoryService::ServiceName(),serviceProvider, handle)
        {
        }

        
        virtual void CreateRenderInstance(
              com::suntec::hbg::PageRender::FactoryService::IRenderClient* client);
        
    private:
        //DISALLOW_COPY_AND_ASSIGN
        Proxy(const Proxy&);
        void operator=(const Proxy&);
    };
    //Proxy for com::suntec::hbg::PageRender::FactoryService::IPageRender
    template<>
    class Proxy< com::suntec::hbg::PageRender::FactoryService::IPageRender > :
        public com::suntec::hbg::PageRender::FactoryService::IPageRender,public RPC::InterfaceProxyBase
    {
    
    public:
        Proxy(const RPC::InterfaceHandle& handle):RPC::InterfaceProxyBase(handle)
        {
        }

        
        virtual void CreateView(
              int viewHandle);
        
    private:
        //DISALLOW_COPY_AND_ASSIGN
        Proxy(const Proxy&);
        void operator=(const Proxy&);
    };
    //Proxy for com::suntec::hbg::PageRender::FactoryService::IRenderClient
    template<>
    class Proxy< com::suntec::hbg::PageRender::FactoryService::IRenderClient > :
        public com::suntec::hbg::PageRender::FactoryService::IRenderClient,public RPC::InterfaceProxyBase
    {
    
    public:
        Proxy(const RPC::InterfaceHandle& handle):RPC::InterfaceProxyBase(handle)
        {
        }

        
        virtual void OnInstanceCreate(
              com::suntec::hbg::PageRender::FactoryService::IPageRender* render);
        
    private:
        //DISALLOW_COPY_AND_ASSIGN
        Proxy(const Proxy&);
        void operator=(const Proxy&);
    };
} // End namespace RPC

#endif //#ifndef GEN_COM_SUNTEC_HBG_PAGERENDER_PROXYS_H_
