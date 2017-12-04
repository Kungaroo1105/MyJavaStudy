package yhk.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yhk.annotation.Component;
import yhk.annotation.Function;
import yhk.annotation.Resource;

public class BeanFactoryOnMethod {
	/** 
     * pkg:package to scan; 
     */  
    private String pkg;  
    /** 
     * 将Component注解的value返回值作为key,对应的类作为value,存放在instanceMap中 
     */  
    private Map<String, Object> instanceMap = new HashMap<>();  
    
    private Map<String, Object> methodMap= new HashMap<>();
    /** 
     * 如果使用无参构造器,之后请记得使用setPkg方法 
     */  
    public BeanFactoryOnMethod() {
	}
  
    /** 
     * 调用该构造器会回调ioc 
     *  
     * @param pkg 
     */  
    public BeanFactoryOnMethod(String pkg, Class[] annotations) {  
        this.pkg = pkg;  
        IoC(annotations);  
    }  
  
    private void IoC(Class[] annotations) {  
        // 将包形式转换为文件路径形式  
        String pkgPath = pkg.replaceAll("\\.", "/");  
        // 获取当前project的绝对路径  
        String projectPath = BeanFactory.class.getResource("/").toString();  
        // 对获取的路径进行处理,去掉开头的file:/  
        projectPath = projectPath.substring(projectPath.indexOf("/") + 1);  
        // 获取指定路径下的所有文件  
  
        // 遍历所有的文件和文件夹  
        recursion(new File(projectPath + pkgPath));  
        findMethod(annotations);
        //findResource();  
    }  
   
    // 将instanceMap里所有的实例的methods找出,看看是否存在@Method,如果存在就将它实例化  
    private void findMethod(Class[] annotations) {  
        // 获取指定路径pkg下存在@Component的所有对象实例  
        Collection<Object> values = instanceMap.values();  
        for (Object obj : values) {  
            try {  
                initMethod(obj,annotations);  
            } catch (IllegalArgumentException | IllegalAccessException e) {  
                e.printStackTrace();  
            }  
        }  
    } 
    
    /** 
     * 将带有@Method的方法和所在类读进配置文件 
     *  
     * @param obj 
     *            field的拥有者 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */  
    private void initMethod(Object obj,Class[] annotations) throws IllegalArgumentException,  
            IllegalAccessException {  
        Class<? extends Object> clz = obj.getClass();  
        Method[] methods= clz.getDeclaredMethods();
        for (Method m : methods) {  
        		for (Class anno : annotations) {
    				if (m.isAnnotationPresent(anno)) {   
    	            	methodMap.put(m.getName(),clz.getName()+","+anno.getSimpleName());
    	            } 
				}
        }  
    }  
    
    /** 
     * 递归寻找指定路径下的所有类文件 
     *  
     * @param file 
     */  
    private void recursion(File file) {  
        File[] files = file.listFiles();  
        for (File f : files) {  
            if (f.isFile()) {  
                fillMap(f);  
            } else {  
                recursion(f);  
            }  
        }  
    }  
  
    /** 
     * 对找到类文件进行处理,将该类文件头上的注解解析,将对应信息存放到map中 
     *  
     * @param f 
     */  
    private void fillMap(File f) {  
        // 类的绝对路径  
        String absolutePath = f.getAbsolutePath();  
        // 包路径  
        String pkgPath = absolutePath.replaceAll("\\\\", ".");  
        // 获取类路径,并去掉文件格式  
        String objPath = pkgPath.substring(pkgPath.indexOf("bin"),  
                pkgPath.length() - 6);  
        objPath = objPath.substring(objPath.indexOf(pkg),  
        		objPath.length());  
        try {  
            // 通过类路径创建指定的类  
            Class<?> clz = Class.forName(objPath);  
  
            Class<Component> annoClz = Component.class;  
  
            if (clz.isAnnotationPresent(annoClz)) {  
  
                Component c = clz.getAnnotation(annoClz);  
  
                Object instance = clz.newInstance();  
  
                String instanceName = "";  
  
                String annoValue = c.value();  
                // 如果使用的是默认值,则以类名为key存入map  
                if ("".equals(annoValue)) {  
                    instanceName = instance.getClass().getSimpleName();  
                    // 将类名第一个字母改成小写  
                    instanceName = (instanceName.charAt(0) + "").toLowerCase()  
                            + instanceName.substring(1);  
                } else {  
                    instanceName = annoValue;  
                }  
  
                // 存放到map中,如果返回值不为空,则表明已存在同名实例.  
                if (instanceMap.put(instanceName, instance) != null) {  
                    throw new Exception("存在同名实例");  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public Map<String, Object> getInstances() {  
        return instanceMap;  
    }  
  
    /** 
     * 根据实例名获取实例 
     *  
     * @param instanceName 
     *            实例名 
     * @return 实例 
     */  
    public <T> T getInstance(String instanceName) {  
        return (T) instanceMap.get(instanceName);  
    }  
  
    public String getPkg() {  
        return pkg;  
    }  
  
    /** 
     * 调用set方法会回调IoC 
     *  
     * @param pkg 
     */  
    public void setPkg(String pkg,Class[] annotations) {  
        this.pkg = pkg;  
        IoC(annotations);  
    }  
    
    public static void main(String[] args) {
		BeanFactoryOnMethod a = new BeanFactoryOnMethod("yhk",new Class[]{Function.class});
		Map b = a.instanceMap;
		Map method= a.methodMap;
		System.out.println(b.size());
		
		List<Map<String,String>>list= new ArrayList<Map<String,String>>();
		
		for (Object key : method.keySet()) {
			Map<String, String> tmp= new HashMap<String,String>();
			tmp.put("methodName", key.toString());
			tmp.put("location", method.get(key).toString());
			list.add(tmp);
		}
		WriteXML.printXml(list);
		
	}
    
    public static void write(String path, Class[] annotations){
    	BeanFactoryOnMethod a = new BeanFactoryOnMethod(path,annotations);
		Map method= a.methodMap;
		List<Map<String,String>>list= new ArrayList<Map<String,String>>();
		
		for (Object key : method.keySet()) {
			Map<String, String> tmp= new HashMap<String,String>();
			tmp.put("methodName", key.toString());
			String[] methodInfo=method.get(key).toString().split(",");
			tmp.put("location", methodInfo[0]);
			tmp.put("methodAnno",methodInfo[1]);
			list.add(tmp);
		}
		WriteXML.printXml(list);
    }
}
