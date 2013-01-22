#ifndef GEN_COM_SUNTEC_HBG_PAGERENDER_PARAMS_H_
#define GEN_COM_SUNTEC_HBG_PAGERENDER_PARAMS_H_

#include "ipc/ipc_param_traits.h"
#include "rpc/public/rpc_interface.h"
#include "rpc/base/rpc_message_traits.h"
#include "rpc/base/rpc_param_traits.h"
#include "rpc/public/rpc_impl_helper.h"
#include "com/suntec/hbg/PageRender/interfaces.h"

namespace RPC
{
    template<>
    struct MethodInfos< com::suntec::hbg::PageRender::FactoryService >
    {
        struct CreateRenderInstance_Params
        {
              enum {ID = 1 };
              RPC::InterfaceHandle client;
        };
    };
    template<>
    struct MethodInfos< com::suntec::hbg::PageRender::FactoryService::IPageRender >
    {
        struct CreateView_Params
        {
              enum {ID = 1 };
              int viewHandle;
        };
    };
    template<>
    struct MethodInfos< com::suntec::hbg::PageRender::FactoryService::IRenderClient >
    {
        struct OnInstanceCreate_Params
        {
              enum {ID = 1 };
              RPC::InterfaceHandle render;
        };
    };

};

namespace IPC
{
    
    //ParamTraits for com::suntec::hbg::PageRender::FactoryService    
     template<>
    struct ParamTraits<RPC::MethodInfos< com::suntec::hbg::PageRender::FactoryService >::CreateRenderInstance_Params >
    {
          typedef RPC::MethodInfos< com::suntec::hbg::PageRender::FactoryService >::CreateRenderInstance_Params param_type;
            static void Write(Message* m, const param_type& p);
            static bool Read(const Message* m, PickleIterator* iter, param_type* r);
            static void Log(const param_type& p, std::string* l);
    };
    
    //ParamTraits for com::suntec::hbg::PageRender::FactoryService::IPageRender    
     template<>
    struct ParamTraits<RPC::MethodInfos< com::suntec::hbg::PageRender::FactoryService::IPageRender >::CreateView_Params >
    {
          typedef RPC::MethodInfos< com::suntec::hbg::PageRender::FactoryService::IPageRender >::CreateView_Params param_type;
            static void Write(Message* m, const param_type& p);
            static bool Read(const Message* m, PickleIterator* iter, param_type* r);
            static void Log(const param_type& p, std::string* l);
    };
    
    //ParamTraits for com::suntec::hbg::PageRender::FactoryService::IRenderClient    
     template<>
    struct ParamTraits<RPC::MethodInfos< com::suntec::hbg::PageRender::FactoryService::IRenderClient >::OnInstanceCreate_Params >
    {
          typedef RPC::MethodInfos< com::suntec::hbg::PageRender::FactoryService::IRenderClient >::OnInstanceCreate_Params param_type;
            static void Write(Message* m, const param_type& p);
            static bool Read(const Message* m, PickleIterator* iter, param_type* r);
            static void Log(const param_type& p, std::string* l);
    };    
};

#endif //#ifndef GEN_COM_SUNTEC_HBG_PAGERENDER_PARAMS_H_
