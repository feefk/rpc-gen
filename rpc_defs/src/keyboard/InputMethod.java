package keyboard;


import rpc.annotation.AsyncMethod;
import rpc.annotation.EnumType;
import rpc.annotation.InterfaceType;
import rpc.annotation.ServiceType;
import rpc.annotation.StructureType;


@ServiceType
public interface InputMethod {
	 
	@InterfaceType
	public interface Client{
		
		void InsertString(String str);
		
	};
    
	@EnumType
    enum InputType
    {
        TEXT_INPUT_TYPE_NONE,
        TEXT_INPUT_TYPE_TEXT,
        TEXT_INPUT_TYPE_PASSWORD,
        TEXT_INPUT_TYPE_SEARCH,
        TEXT_INPUT_TYPE_EMAIL,
        TEXT_INPUT_TYPE_NUMBER,
        TEXT_INPUT_TYPE_TELEPHONE,
        TEXT_INPUT_TYPE_URL,
        TEXT_INPUT_TYPE_DATE,
        TEXT_INPUT_TYPE_DATE_TIME,
        TEXT_INPUT_TYPE_DATE_TIME_LOCAL,
        TEXT_INPUT_TYPE_MONTH,
        TEXT_INPUT_TYPE_TIME,
        TEXT_INPUT_TYPE_WEEK,
        TEXT_INPUT_TYPE_TEXT_AREA,
        TEXT_INPUT_TYPE_CONTENT_EDITABLE,
        TEXT_INPUT_TYPE_MAX,
    };
    
    @StructureType
    class ClientStatus{
    	public String current_str;
    	public InputType type;
    }
    
	@AsyncMethod
	public void BindClient(Client client);
	
	@AsyncMethod
	public void SetStatus(ClientStatus status);
	
}


