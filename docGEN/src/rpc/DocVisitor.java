package rpc;
import com.sun.javadoc.*;

public class DocVisitor {

    RootDoc mRoot;
    Delegate mDelegate;

    static public abstract class Delegate {
        public void BeginVisitDoc(RootDoc root) {
        }
        
        public void VisitDoc(RootDoc root) {
            for (String[] option : root.options()) {
                VisitOption(option);
            }

            for (PackageDoc pkg : root.specifiedPackages()) {
                BeginVisitSpecifiedPackage(pkg);
                VisitSpecifiedPackage(pkg);
                EndVisitSpecifiedPackage(pkg);
            }

            for (ClassDoc cls : root.specifiedClasses()) {
                BeginVisitSpecifiedClass(cls);
                VisitSpecifiedClass(cls);
                EndVisitSpecifiedClass(cls);
            }

            for (ClassDoc cls : root.classes()) {
                BeginVisitClass(cls);
                VisitClass(cls);
                EndVisitClass(cls);
            }
        }

        public void VisitOption(String[] option) {

        }

        public void BeginVisitSpecifiedPackage(PackageDoc pkg) {

        }

        public void VisitSpecifiedPackage(PackageDoc pkg) {

        }

        public void EndVisitSpecifiedPackage(PackageDoc pkg) {

        }

        public void BeginVisitSpecifiedClass(ClassDoc cls) {

        }

        public void VisitSpecifiedClass(ClassDoc cls) {

        }

        public void EndVisitSpecifiedClass(ClassDoc cls) {

        }

        public void BeginVisitClass(ClassDoc cls) {

        }

        public void VisitClass(ClassDoc cls) {

        }

        public void EndVisitClass(ClassDoc cls) {

        }

        public void EndVisitDoc(RootDoc root) {
        }
    };

    public DocVisitor(RootDoc root, Delegate delegate) {
        mRoot = root;
        mDelegate = delegate;
    }

    public void visit() {
        mDelegate.BeginVisitDoc(mRoot);
        mDelegate.VisitDoc(mRoot);

        mDelegate.EndVisitDoc(mRoot);
    }
}
