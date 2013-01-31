package rpc;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.javadoc.*;

public class RPCParamsHeaderGenerator extends Doclet {

    public static int optionLength(String s) {
        if (s.equals("-d")) {
            return 2;
        } else {
            return Doclet.optionLength(s);
        }
    }

    public static RootDoc rootDoc = null;

    public static boolean start(RootDoc root) {
        rootDoc = root;
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
                rpc.Context.Get().setCurrentPackage(pkg);
                new PackageVisitor(pkg, new PackageVisitor.Delegate() {
                    @Override
                    public void BeginVisitPackage(PackageDoc pkg) {
                        try {

                            FileOutputStream out = new FileOutputStream(
                                    rpc.Context.Get().getPath(
                                            rpc.Helper.PathType.eParamsHeader));
                            rpc.generators.params_h p = new rpc.generators.params_h();
                            rpc.Context.Get().setCurrentPackage(pkg);
                            out.write(p.generate(rootDoc).getBytes());
                            out.close();
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        super.BeginVisitPackage(pkg);
                    }
                }).visit();
            }

        });

        visitor.visit();
        return true;
    }
}