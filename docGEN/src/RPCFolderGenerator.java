import java.io.File;
import com.sun.javadoc.*;

public class RPCFolderGenerator extends Doclet {

    public static int optionLength(String s) {
        if (s.equals("-d")) {
            return 2;
        } else {
            return Doclet.optionLength(s);
        }
    }

    public static boolean start(RootDoc root) {

        DocVisitor visitor = new DocVisitor(root, new DocVisitor.Delegate() {

            @Override
            public void VisitOption(String[] option) {
                if (option[0].equals("-d")) {
                    rpc.Context.Get().setOutputDir(option[1]);
                }
                super.VisitOption(option);
            }

            @Override
            public void VisitSpecifiedPackage(PackageDoc pkg) {

                new PackageVisitor(pkg, new PackageVisitor.Delegate() {

                    String mOutDir;

                    @Override
                    public void BeginVisitPackage(PackageDoc pkg) {
                        rpc.Context.Get().setCurrentPackage(pkg);
                        mOutDir = rpc.Context.Get().getPath(
                                rpc.Helper.PathType.eApiFolder);
                        System.out.println(">>> MKDIR " + mOutDir);
                        File file = new File(mOutDir);
                        file.mkdirs();
                        mOutDir = rpc.Context.Get().getPath(
                                rpc.Helper.PathType.eImplFolder);
                        System.out.println(">>> MKDIR " + mOutDir);
                        file = new File(mOutDir);
                        file.mkdirs();

                        super.BeginVisitPackage(pkg);
                    }
                }).visit();
            }

        });

        visitor.visit();
        return true;
    }
}