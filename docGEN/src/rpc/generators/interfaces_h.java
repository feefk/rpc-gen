package rpc.generators;

import com.sun.javadoc.*;

public class interfaces_h
{
  protected static String nl;
  public static synchronized interfaces_h create(String lineSeparator)
  {
    nl = lineSeparator;
    interfaces_h result = new interfaces_h();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = "#ifndef "; //$NON-NLS-1$
  protected final String TEXT_2 = NL + "#define "; //$NON-NLS-1$
  protected final String TEXT_3 = NL + "#include \"rpc/public/rpc_interface.h\"" + NL; //$NON-NLS-1$
  protected final String TEXT_4 = "#include \""; //$NON-NLS-1$
  protected final String TEXT_5 = "\"" + NL; //$NON-NLS-1$
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + NL + "#endif //#ifndef "; //$NON-NLS-1$
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();

    String header_guide =rpc.Helper.getIncludeGuide(rpc.Context.Get().getCurrentPackage(), rpc.Helper.PathType.eInterfaceHeader);
    PackageDoc thisPkg = rpc.Context.Get().getCurrentPackage();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_3);
 for(PackageDoc pkgDoc : rpc.Helper.importedPackages(rpc.Context.Get().getCurrentPackage()) ) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rpc.Helper.getRelativePath(pkgDoc,rpc.Helper.PathType.eInterfaceHeader));
    stringBuffer.append(TEXT_5);
}
    stringBuffer.append(rpc.Helper.packageNamespaceBegine(rpc.Context.Get().getCurrentPackage()));
    stringBuffer.append(TEXT_6);
 for( ClassDoc cls: thisPkg.allClasses()) {
 if(cls.containingClass() == null ) {
		if( rpc.Helper.isInterface(cls) || rpc.Helper.isService(cls) ) 
		{ 
			interfaces_class_h cg = new interfaces_class_h();
			
    stringBuffer.append(cg.generate(cls));

		} else if ( rpc.Helper.isStructure(cls))
		{
			structure_class_h cg = new structure_class_h();
			
    stringBuffer.append(cg.generate(cls));

		}else if ( rpc.Helper.isEnum(cls))
		{			
			enum_class_h cg = new enum_class_h();
			
    stringBuffer.append(cg.generate(cls));

		}
 } // if(cls.containingClass() == null) 
    stringBuffer.append(TEXT_7);
 } // for class cls 
    stringBuffer.append(rpc.Helper.packageNamespaceEnd(rpc.Context.Get().getCurrentPackage()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(header_guide);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
