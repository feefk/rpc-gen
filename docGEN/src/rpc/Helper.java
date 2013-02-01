package rpc;

import com.sun.javadoc.*;
public class Helper {
	public static enum PathType
	{
		eInterfaceHeader,
		eProxyHeader,
		eProxySource,
		eParamsHeader,
		eParamsSource,
		eStubBaseHeader,
		eStubBaseSource,
		eApiFolder,
		eImplFolder,
	};
	
	public static boolean isInterface(ClassDoc cls)
    {
        for(AnnotationDesc an :cls.annotations())
        {
            if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.InterfaceType"))
            {
                    return true;
            }
        }
        return false;
    };
	
	public static boolean isService(ClassDoc cls)
	{
		for(AnnotationDesc an :cls.annotations())
		{
			if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.ServiceType"))
			{
					return true;
			}
		}
		return false;
	};
		
	public static boolean isStructure(ClassDoc cls)
    {
        for(AnnotationDesc an :cls.annotations())
        {
            if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.StructureType"))
            {
                    return true;
            }
        }
        return false;
    };
    
    public static boolean isEnum(ClassDoc cls)
    {
        for(AnnotationDesc an :cls.annotations())
        {
            if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.EnumType"))
            {
                    return true;
            }
        }
        return false;
    };
	
	public static String  getIncludeGuide(PackageDoc packDoc, PathType type)
	{
		String pkgPath = "GEN_"  + packDoc.name().replace('.', '_') + "_";
		switch(type)
		{
		case eInterfaceHeader:	return (pkgPath + "interfaces_h_").toUpperCase();
		case eProxyHeader:		return (pkgPath + "proxys_h_").toUpperCase();		
		case eParamsHeader:		return (pkgPath + "params_h_").toUpperCase();
		case eStubBaseHeader:	return (pkgPath + "stub_base_h_").toUpperCase();
		default:
				return null;
		} 
	}
	
		
	public static String  getRelativePath(PackageDoc packDoc, PathType eparamssource)
	{
		String pkgPath = packDoc.name().replace('.', '/') + "/";
		switch(eparamssource)
		{
		case eInterfaceHeader:	return pkgPath + "interfaces.h";
		case eProxyHeader:		return pkgPath + "proxys.h";	
		case eProxySource:		return pkgPath + "proxys.cc";
		case eParamsHeader:		return pkgPath + "params.h";
		case eParamsSource:		return pkgPath + "params.cc";
		case eStubBaseHeader:	return pkgPath + "stub_base.h";
		case eStubBaseSource:	return pkgPath + "stub_base.cc";
		case eApiFolder:
		case eImplFolder:
			return pkgPath;
		default:
				return null;
		} 
	}
	
	
	public static String convertCPPType(ClassDoc cls)
	{
		return cls.qualifiedTypeName().replace(".", "::");
	};
	
//	enum TypePlace
//	{
//	    eParameterDeclare,
//	    eParameterStoreage,
//	    eParameterStoreage
//	};
	
	public static String getParamTraitsType(Parameter param)
	{
		if(isInterface(param))
		{
			return "RPC::InterfaceHandle";
		}else if(isStructure(param))
        {
            return param.type().qualifiedTypeName().replace('.', ':').replace(":", "::");
        }
		else
		{
			 for(String [] e: J2CPPSTORAGE)
			{
				if(e[0].equals(param.type().qualifiedTypeName()))
				{
					return e[1];
				}
			}
		}
		return param.type().qualifiedTypeName();
	}
	
	
	public static boolean isInterface(FieldDoc param)
    {
        if(param.type().asClassDoc() != null)
        {
            return isService(param.type().asClassDoc()) || isInterface(param.type().asClassDoc());
        }else
        {
            return false;
        }
        
    };
	
	static String getFieldTraitsTypeInternal(FieldDoc field)
    {
        if(isInterface(field))
        {
            return "RPC::InterfaceHandle";
        }
        else
        {
             for(String [] e: J2CPPSTORAGE)
            {
                if(e[0].equals(field.type().typeName()))
                {
                    return e[1];
                }
            }
        }
        return field.type().typeName().replace('.', ':').replaceFirst(":", "::");
    }
	
	public static String getFieldTraitsType(FieldDoc field)
    {
	    return getFieldTraitsTypeInternal(field);
    }
	
	public static boolean isInterface(Parameter param)
	{
		if(param.type().asClassDoc() != null)
		{
			return isService(param.type().asClassDoc()) || isInterface(param.type().asClassDoc());
		}else
		{
			return false;
		}
		
	};
	
	public static boolean isStructure(Parameter param)
    {
        if(param.type().asClassDoc() != null)
        {
            return isStructure(param.type().asClassDoc());
        }else
        {
            return false;
        }
        
    };
	
	public static String[] getPackageUnits(PackageDoc pkg)
	{
		return pkg.name().replace('.', ':').split(":");
	}
	
	public static String packageNamespaceBegine(PackageDoc pkg)
	{
		String tabs = " ";
		String out = "";
		for(String u: getPackageUnits(pkg))
		{
			out = out + ("namespace " + u + "{" + tabs);			
		}
		return out;
	};
	
	public static String packageNamespaceEnd(PackageDoc pkg)
	{
		String tabs = " ";
		String out = "";
		for(@SuppressWarnings("unused") String u: getPackageUnits(pkg))
		{
			out = ("};" + tabs) + out;			
		}
		return out;
	};
	
	
	
	static String [][] J2CPPTYPEMAPS = {
		{"String","const std::string&"},
		{"boolean","bool"},
		{"Long","int64"}
	};
	
	static String [][] J2CPPSTORAGE = {
	    {"java.lang.String","std::string"},
	    {"String","std::string"},
		{"boolean","bool"},
	    {"Long","int64"}
	};
	
	static String parameterDeclareType(Parameter param)
	{
		if(param.type() != null 
				&& param.type().asClassDoc() != null 
				&&param.type().asClassDoc().annotations() != null)
		for(AnnotationDesc an : param.type().asClassDoc().annotations())
		{
			if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.InterfaceType") 
					|| an.annotationType().qualifiedTypeName().equals("rpc.annotation.ServiceType"))
			{
					return param.type().qualifiedTypeName().replace(".", "::") + "*";
			}else if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.StructureType")) 
            {
			    if(param.type().dimension().length() >1)
			    {
                    return param.type().qualifiedTypeName().replace(".", "::");
			    }else
			    {
			        return "const " + param.type().qualifiedTypeName().replace(".", "::") + "&";
			    }
            }else if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.EnumType")) 
            {
                return param.type().qualifiedTypeName().replace(".", "::");
            }
		}
		
		for(String [] e: ( param.type().dimension().length() >1 ? J2CPPSTORAGE : J2CPPTYPEMAPS ))
		{
			if(e[0].equals(param.typeName()))
			{
				return e[1];
			}
		}
		return param.typeName();
	};
	
	public static String parameterDeclare(Parameter param)
    {
	    if(param.type().dimension().length()>0)
	    {
	       return "std::vector<" + parameterDeclareType(param) + " >& "+ param.name();
	    }else{
	        return parameterDeclareType(param) + " " + param.name();
	    }
    };
    
    public static String parameterStorageType(Parameter param)
    {
        String ret = "";
        if(param.type() != null 
                && param.type().asClassDoc() != null 
                &&param.type().asClassDoc().annotations() != null)
            
        RETURN: {
        for(AnnotationDesc an : param.type().asClassDoc().annotations())
        {
            if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.InterfaceType") 
                    || an.annotationType().qualifiedTypeName().equals("rpc.annotation.ServiceType"))
            {
                ret= "RPC::InterfaceHandle";
                break RETURN;
            }else
             if(an.annotationType().qualifiedTypeName().equals("rpc.annotation.StructureType") 
                || an.annotationType().qualifiedTypeName().equals("rpc.annotation.EnumType"))
             {
                ret=  convertCPPType(param.type().asClassDoc());
                break RETURN;
             }
        }
        for(String [] e: J2CPPSTORAGE)
        {
            if(e[0].equals(param.type().qualifiedTypeName()))
            {
                ret = e[1];
                break RETURN;
            }
        }
        ret = param.type().qualifiedTypeName();
        }
        
        if(param.type().dimension().length()>0)
        {
           return "std::vector<" + ret + " > ";
        }else{
            return ret;
        }
    }
	
	public static String parameterStorage(Parameter param)
	{
          return parameterStorageType(param) + " " + param.name();
	};
	
	@SuppressWarnings("deprecation")
    public static PackageDoc[] importedPackages(PackageDoc pkg)
	{
		java.util.Set<PackageDoc> pkgs = new java.util.HashSet<PackageDoc>();
		for(ClassDoc cls: pkg.allClasses())
		{
			if(cls.importedPackages() != null)
			{
			for(PackageDoc impPkg: cls.importedPackages())
			{
				if(impPkg.equals(pkg) || impPkg.name().startsWith("java.") || impPkg.name().startsWith("rpc.annotation"))
				{
					
				}else
				{
					pkgs.add(impPkg);
				}
			}
			}
			
			if(cls.importedClasses() != null)
			{
			for(ClassDoc impcls: cls.importedClasses())
			{
				PackageDoc impPkg = impcls.containingPackage(); 
				if(impPkg == null || impPkg.equals(pkg) || impPkg.name().startsWith("java.") || impPkg.name().startsWith("rpc.annotation"))
				{
					
				}else
				{
					pkgs.add(impPkg);
				}
			}
			}
		}
		return pkgs.toArray(new PackageDoc[0]);
	}
	
	
}
