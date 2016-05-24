package cn.lidm.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {
	 /**
     * 将request对象转换成T对象
     * @param request 
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames(); 
            while(e.hasMoreElements()){
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static <T> T row2Bean(ResultSet row,Class<T> clazz)
    {
    	try {
			T bean=clazz.newInstance();
			ResultSetMetaData metaData=row.getMetaData();
			for(int i=0;i<metaData.getColumnCount();i++)
			{
				String name=metaData.getColumnLabel(i+1);
				String value=row.getString(i+1);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
    }
   
}
