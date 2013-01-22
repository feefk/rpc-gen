
package com.suntec.hbg.PageRender;

import rpc.annotation.*;

@ServiceType
public interface FactoryService {
	
	@InterfaceType
	public interface IPageRender
	{
		@SyncMethod
		void CreateView(int viewHandle);
	};
	
	@InterfaceType
	public interface IRenderClient
	{
		@SyncMethod
		void OnInstanceCreate(IPageRender render);
	};
	
	@SyncMethod
    void CreateRenderInstance(IRenderClient client);
    
}
