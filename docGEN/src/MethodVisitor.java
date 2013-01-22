import com.sun.javadoc.*;

public class MethodVisitor {

    Delegate mDelegate;
    MethodDoc mMethodDoc;

    static public abstract class Delegate {
        public void BeginVisitMethod(MethodDoc method) {
        }

        public void VisitMethod(MethodDoc method) {
            for (Parameter param : method.parameters()) {
                BegineVisitParameter(param);
                VisitParameter(param);
                EndVisitParameter(param);
            }
        }

        public void BegineVisitParameter(Parameter param) {
        }

        public void VisitParameter(Parameter param) {
        }

        public void EndVisitParameter(Parameter param) {
        }

        public void EndVisitMethod(MethodDoc method) {
        }
    };

    public MethodVisitor(MethodDoc method, Delegate delegate) {
        mMethodDoc = method;
        mDelegate = delegate;
    }

    public void visit() {
        mDelegate.BeginVisitMethod(mMethodDoc);
        mDelegate.VisitMethod(mMethodDoc);
        mDelegate.EndVisitMethod(mMethodDoc);
    }

}
