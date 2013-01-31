package rpc;
import com.sun.javadoc.*;

public class ClassVisitor {

    Delegate mDelegate;
    ClassDoc mClassDoc;

    static public abstract class Delegate {
        public void BeginVisitClass(ClassDoc cls) {
        }

        public void VisitClass(ClassDoc cls) {
            for (ClassDoc innerClass : cls.innerClasses()) {
                BegineVisitInnerClass(innerClass);
                VisitInnerClass(innerClass);
                EndVisitInnerClass(innerClass);
            }

            for (FieldDoc field : cls.fields()) {
                BegineVisitField(field);
                VisitField(field);
                EndVisitField(field);
            }

            for (MethodDoc method : cls.methods()) {
                BegineVisitMethod(method);
                VisitMethod(method);
                EndVisitMethod(method);
            }
        }

        public void BegineVisitInnerClass(ClassDoc innerClass) {
        }

        public void VisitInnerClass(ClassDoc innerClass) {
        }

        public void EndVisitInnerClass(ClassDoc innerClass) {
        }

        public void BegineVisitMethod(MethodDoc Method) {
        }

        public void VisitMethod(MethodDoc Method) {
        }

        public void EndVisitMethod(MethodDoc Method) {
        }

        public void BegineVisitField(FieldDoc Field) {
        }

        public void VisitField(FieldDoc Field) {
        }

        public void EndVisitField(FieldDoc Field) {
        }

        public void EndVisitClass(ClassDoc cls) {
        }
    };

    public ClassVisitor(ClassDoc cls, Delegate delegate) {
        mClassDoc = cls;
        mDelegate = delegate;
    }

    public void visit() {
        mDelegate.BeginVisitClass(mClassDoc);
        mDelegate.VisitClass(mClassDoc);
        mDelegate.EndVisitClass(mClassDoc);
    }

}
