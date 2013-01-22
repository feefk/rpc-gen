package rpc.tests;

import rpc.annotation.InterfaceType;
import rpc.annotation.ServiceType;

@ServiceType
public interface PingPongService {
	
	@InterfaceType
	public interface Client
	{
		void Pong(String answer);
	}
	void Ping(Client client, String question);
}
