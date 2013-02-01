package js;


import rpc.annotation.AsyncMethod;
import rpc.annotation.InterfaceType;
import rpc.annotation.ServiceType;

@ServiceType
public interface ExtensionHandler {
	 
	
	@InterfaceType
	public interface Client{
		void SendResponse( 
				int viewId, 
				int callid,
				String responseJson);
		
	};
	
	@AsyncMethod
	public void BindClient(Client client);
	
	@AsyncMethod
	public void SendRequest(
			int viewId, 
			int callId,
			int appId,
			String methodName,
			String requestJson);
	
}
