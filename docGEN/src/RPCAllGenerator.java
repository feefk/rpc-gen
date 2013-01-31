import rpc.RPCFolderGenerator;
import rpc.RPCInterfaceHeaderGenerator;
import rpc.RPCParamsHeaderGenerator;
import rpc.RPCParamsSourceGenerator;
import rpc.RPCProxyHeaderGenerator;
import rpc.RPCProxySourceGenerator;
import rpc.RPCStubSourceGenerator;

import com.sun.javadoc.*;

public class RPCAllGenerator extends Doclet {

    public static int optionLength(String s) {
        if (s.equals("-d")) {
            return 2;
        } else {
            return Doclet.optionLength(s);
        }
    }

    public static boolean start(RootDoc root) {
        rpc.Context.Get().setRoot(root);
        return RPCFolderGenerator.start(root)
                && RPCInterfaceHeaderGenerator.start(root)
                && RPCProxyHeaderGenerator.start(root)
                && RPCStubSourceGenerator.start(root)
                && RPCProxySourceGenerator.start(root)
                && RPCParamsSourceGenerator.start(root)
                && RPCParamsHeaderGenerator.start(root);
    }
}