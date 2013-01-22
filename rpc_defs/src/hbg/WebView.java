package hbg;
import rpc.annotation.InterfaceType;
import rpc.annotation.ServiceType;
import rpc.annotation.StructureType;
import rpc.annotation.EnumType;


@InterfaceType
public interface WebView {
    
    @StructureType
    class Settings
    {
        public boolean js_extension_supported;
    };
    
    @EnumType
    enum TouchEventType
    {
        eTouchEventPressed,
        eTouchEventReleased,
        eTouchEventMoved,
    };
    
    @InterfaceType
    interface WebViewClient
    {
        void OnWebViewCreated(WebView render);
        
        void OnResized(int width, int height);
        
        void OnTitleChanged(String title);
        
        void OnURLChanged(String url);
        
        void OnExternalLinkClicked(String url);
        
        void OnPaint();
       
    }
    
    @ServiceType
    public interface FactoryService 
    {
        void CreateWebView(WebViewClient client);
    }
    
    void SetSetting(Settings settings);
    
    void Resize(int width, int height);

    void LoadURL(String url);
    
    void ProcessHostTouchEvent();
    
    void ProcessHostKeyEvent();
    
    void Close();

}
