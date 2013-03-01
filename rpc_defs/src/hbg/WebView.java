package hbg;
import rpc.annotation.*;

@InterfaceType
public interface WebView {
    
    
    @EnumType
    enum SurfaceType
    {
        eClientFrameBuffer,
        eServiceFrameBuffer,
        eClientWindow,
        eHardware,
    };
    
    @StructureType
    class Rect
    {
        public int x;
        public int y;
        public int width;
        public int hidth;
    };
    
    @StructureType
    class Position
    {
        public int x;
        public int y;
    };
    
    @EnumType
    enum TraceDevice
    {
        eTouchPad,
        eMultiTouch,
        eMouse,
     };
     
     @EnumType
     enum MediaPlayerType
     {
         eExternalPlayer,
         eInnternalPlayer,
         eNone,
      };

    
    @StructureType
    class Preferences
    {
       public SurfaceType surfaceType;
       public Rect surfaceRect;
       public TraceDevice input;
       public MediaPlayerType playerType;
    };
    
    @EnumType
    enum TouchEventType
    {
        eTouchEventPressed,
        eTouchEventReleased,
        eTouchEventMoved,
    };
    
    @StructureType
    class TouchItem
    {
        public int identifier;
        public Position pos;
        public float force;
    };
    
    @StructureType
    class TouchEvent
    {
        public TouchEventType type;
        public TouchItem[] items;
    };
    
    @StructureType
    class Surface
    {
        public SurfaceType type;
        public Long handle;
    };
    
    @InterfaceType
    interface WebViewClient
    {
        void OnWebViewCreated(WebView render);
        
        void OnMoved(Rect targetArea);
        
        void OnTitleChanged(String title);
        
        void OnURLChanged(String url);
        
        void OnExternalLinkClicked(String url);
        
        void OnSurfaceSwaped(Surface front, Surface backend);
        
    }
    
    @ServiceType
    public interface FactoryService 
    {
        void CreateWebView(WebViewClient client);
        
        void CreateWebViewWithCustomWindow(WebViewClient client,Long win ,Long off_screen);
    }
    
    void SetPreferences(Preferences pref);
    
    void SwapSurface();
    
    void SetVisible(boolean visible);
    
    void LoadURL(String url);
    
    void Move(Rect targetArea);
    
    void PostTouchEvent(TouchEvent event);
    
    void Navigate(int offset);
    
    void Close();

}
