#include "com/suntec/hbg/PageRender/params.h"
namespace IPC
{
    
    //ParamTraits for com::suntec::hbg::PageRender::FactoryService    
    void ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService>::CreateRenderInstance_Params> ::Write(Message* m, const param_type& p) {        
        WriteParam(m, p.client);
        
    }
    bool ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService>::CreateRenderInstance_Params>::Read(const Message* m,
                                    PickleIterator* iter,
                                    param_type* r) {
      return ReadParam(m, iter, &r->client);
    }

    void ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService>::CreateRenderInstance_Params>::Log(const param_type& p, std::string* l) {
      // Doesn't make sense to implement this!
    };
    
    
    //ParamTraits for com::suntec::hbg::PageRender::FactoryService::IPageRender    
    void ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IPageRender>::CreateView_Params> ::Write(Message* m, const param_type& p) {        
        WriteParam(m, p.viewHandle);
        
    }
    bool ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IPageRender>::CreateView_Params>::Read(const Message* m,
                                    PickleIterator* iter,
                                    param_type* r) {
      return ReadParam(m, iter, &r->viewHandle);
    }

    void ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IPageRender>::CreateView_Params>::Log(const param_type& p, std::string* l) {
      // Doesn't make sense to implement this!
    };
    
    
    //ParamTraits for com::suntec::hbg::PageRender::FactoryService::IRenderClient    
    void ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IRenderClient>::OnInstanceCreate_Params> ::Write(Message* m, const param_type& p) {        
        WriteParam(m, p.render);
        
    }
    bool ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IRenderClient>::OnInstanceCreate_Params>::Read(const Message* m,
                                    PickleIterator* iter,
                                    param_type* r) {
      return ReadParam(m, iter, &r->render);
    }

    void ParamTraits<RPC::MethodInfos<com::suntec::hbg::PageRender::FactoryService::IRenderClient>::OnInstanceCreate_Params>::Log(const param_type& p, std::string* l) {
      // Doesn't make sense to implement this!
    };
    
    
};
