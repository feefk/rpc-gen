package rpc;


import com.sun.javadoc.*;
public class Context {
	
	RootDoc root = null;
	PackageDoc currentPackage = null;
	ClassDoc   currentClass = null;
	static Context instance= null;	
	String outputDir = "./";
	
	public RootDoc getRoot() {
		return root;
	}
	public void setRoot(RootDoc root) {
		this.root = root;
	}
	public PackageDoc getCurrentPackage() {
		return currentPackage;
	}
	public void setCurrentPackage(PackageDoc currentPackage) {
		this.currentPackage = currentPackage;
	}
	public ClassDoc getCurrentClass() {
		return currentClass;
	}
	public void setCurrentClass(ClassDoc currentClass) {
		this.currentClass = currentClass;
	}
	
	public static Context Get()
	{
		if(instance == null)
		{
			instance = new Context();
		}
		return instance;
	}

	public String getOutputDir() {
		return outputDir;
	}
	
	public String getPath(rpc.Helper.PathType type)
	{
		String ret = rpc.Helper.getRelativePath(this.getCurrentPackage(), type);
		switch(type)
		{
		case eInterfaceHeader:
		case eApiFolder:
		case eProxyHeader:
		case eStubBaseHeader:
			ret = outputDir+"/api/" + ret;
			break;
		case eImplFolder:
		case eParamsHeader:
		case eProxySource:
		case eParamsSource:		
		case eStubBaseSource:
			ret = outputDir+"/impl/" + ret;
			break;
		default:
			break;
		}
		return ret;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}
}
