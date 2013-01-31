package rpc;
import com.sun.javadoc.*;

public class PackageVisitor {
    Delegate mDelegate;
    PackageDoc mPackage;

    static public abstract class Delegate {
        public void BeginVisitPackage(PackageDoc pkg) {
        }

        public void VisitPackage(PackageDoc pkg) {
            for (ClassDoc cls : pkg.allClasses()) {
                BegineVisitAllClass(cls);
                VisitAllClass(cls);
                EndVisitAllClass(cls);
            }

            for (ClassDoc cls : pkg.ordinaryClasses()) {
                BegineVisitOrdinaryClass(cls);
                VisitOrdinaryClass(cls);
                EndVisitOrdinaryClass(cls);
            }

            for (ClassDoc cls : pkg.interfaces()) {
                BegineVisitInterface(cls);
                VisitInterface(cls);
                EndVisitInterface(cls);
            }
        }

        public void BegineVisitAllClass(ClassDoc cls) {
        }

        public void VisitAllClass(ClassDoc cls) {
        }

        public void EndVisitAllClass(ClassDoc cls) {
        }

        public void BegineVisitOrdinaryClass(ClassDoc cls) {
        }

        public void VisitOrdinaryClass(ClassDoc cls) {
        }

        public void EndVisitOrdinaryClass(ClassDoc cls) {
        }

        public void BegineVisitInterface(ClassDoc cls) {
        }

        public void VisitInterface(ClassDoc cls) {
        }

        public void EndVisitInterface(ClassDoc cls) {
        }

        public void EndVisitPackage(PackageDoc pkg) {
        }
    };

    public PackageVisitor(PackageDoc pkg, Delegate delegate) {
        mPackage = pkg;
        mDelegate = delegate;
    }

    public void visit() {
        mDelegate.BeginVisitPackage(mPackage);
        mDelegate.VisitPackage(mPackage);
        mDelegate.EndVisitPackage(mPackage);
    }

}
