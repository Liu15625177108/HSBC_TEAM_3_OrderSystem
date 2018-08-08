package hsbc.team03.ordersystem.displayproduct.common;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Author:Evan
 * @Time:2018/08/02
 * @Describe:this class is to sort product by product's name
 */
public class SortUtils {
	/**
	 * sort by desc
	 */
   public static final String DESC="desc";
	/**
	 * sort by asc
	 */
	public static final String ASC="asc";
   
   public static List<?> sort(List<?> list, final String field) {
		return sort(list, field, null);
	}

    /**
     *
     * @param list
     * @param field
     * @param sort
     * @return list
     * sort by product's price
     */
   @SuppressWarnings("unchecked")
public static List<?> sort(List<?> list, final String field,final String sort) {
		Collections.sort(list, new Comparator() {
			public int compare(Object a, Object b) {
				int ret = 0;
				try {
					Field f = a.getClass().getDeclaredField(field);
                    /**
                     * set the Product class of field visible(permission of public )
                     */
					f.setAccessible(true);
                    /**
                     * use java reflection to get operation class object
                     */
					Class<?> type = f.getType();

					if (type == int.class) {
						ret = ((Integer) f.getInt(a)).compareTo((Integer) f.getInt(b));
					} 
					else if (type == double.class) {
						ret = ((Double) f.getDouble(a)).compareTo((Double) f.getDouble(b));
					} 
					else if (type == long.class) {
						ret = ((Long) f.getLong(a)).compareTo((Long) f.getLong(b));
					} 
					else if (type == float.class) {
						ret = ((Float) f.getFloat(a)).compareTo((Float) f.getFloat(b));
					} 
					else if (type == Date.class) {
						ret = ((Date) f.get(a)).compareTo((Date) f.get(b));
					} 
					else if (isImplementsOf(type, Comparable.class)) {
						ret = ((Comparable) f.get(a)).compareTo((Comparable) f.get(b));
					} 
					else {
						ret = String.valueOf(f.get(a)).compareTo(String.valueOf(f.get(b)));
					}

				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (sort != null && sort.toLowerCase().equals(ASC)) {
					return -ret;
				} else {
					return ret;
				}

			}
		});
		return list;
	}

    /**
     * 对list中的元素按fields和sorts进行排序,
     * fields[i]  the specified sort filed ,and the sorts[0] is sort way,if sorts[i] is null,the default sort is asc.指定排序字段,sorts[i]指定排序方式.如果sorts[i]为空则默认按升序排列.
     * @param list
     * @param fields
     * @param sorts
     * @return
     */
   @SuppressWarnings("unchecked")
	public static List<?> sort(List<?> list, String[] fields, String[] sorts) {
		if (fields != null && fields.length > 0) {
			for (int i = fields.length - 1; i >= 0; i--) {
				final String field = fields[i];
				String tmpSort = ASC;
				if (sorts != null && sorts.length > i && sorts[i] != null) {
					tmpSort = sorts[i];
				}
				final String sort = tmpSort;
				Collections.sort(list, new Comparator() {
					public int compare(Object a, Object b) {
						int ret = 0;
						try {
							Field f = a.getClass().getDeclaredField(field);
							f.setAccessible(true);
							Class<?> type = f.getType();
							if (type == int.class) {
								ret = ((Integer) f.getInt(a))
										.compareTo((Integer) f.getInt(b));
							} else if (type == double.class) {
								ret = ((Double) f.getDouble(a))
										.compareTo((Double) f.getDouble(b));
							} else if (type == long.class) {
								ret = ((Long) f.getLong(a)).compareTo((Long) f
										.getLong(b));
							} else if (type == float.class) {
								ret = ((Float) f.getFloat(a))
										.compareTo((Float) f.getFloat(b));
							} else if (type == Date.class) {
								ret = ((Date) f.get(a)).compareTo((Date) f
										.get(b));
							} else if (isImplementsOf(type, Comparable.class)) {
								ret = ((Comparable) f.get(a))
										.compareTo((Comparable) f.get(b));
							} else {
								ret = String.valueOf(f.get(a)).compareTo(
										String.valueOf(f.get(b)));
							}

						} catch (SecurityException e) {
							e.printStackTrace();
						} catch (NoSuchFieldException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						if (sort != null && sort.toLowerCase().equals(DESC)) {
							return -ret;
						} else {
							return ret;
						}
					}
				});
			}
		}
		return list;
	}

   
   
   public static boolean isImplementsOf(Class<?> clazz, Class<?> szInterface) {
		boolean flag = false;
//���ܹ�������������ʵ�ֵĽӿ�
		Class<?>[] face = clazz.getInterfaces();//it relation to java's reflection and it can get this object  which interface implement 
		for (Class<?> c : face) {
			if (c == szInterface) {
				flag = true;
			} else {
				flag = isImplementsOf(c, szInterface);
			}
		}

		if (!flag && null != clazz.getSuperclass()) {
			return isImplementsOf(clazz.getSuperclass(), szInterface);
		}

		return flag;
	}

   
}
