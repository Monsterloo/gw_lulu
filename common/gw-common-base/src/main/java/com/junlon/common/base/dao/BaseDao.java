package com.junlon.common.base.dao;

import com.junlon.common.base.page.PageBean;
import com.junlon.common.base.page.PageParam;

import java.util.List;
import java.util.Map;

/**
 * @描述 : 数据访问层基础支撑接口
 * @author junlonlu
 *
 */
public interface BaseDao<T> {

	/**
	 * 根据实体对象新增记录.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	long insert(T entity);

	/**
	 * 批量保存对象.
	 * 
	 * @param list
	 *            .
	 * @return id .
	 */
	long insert(List<T> list);

	/**
	 * 更新实体对应的记录.
	 * 
	 * @param entity
	 *            .
	 * @return
	 */
	long update(T entity);
	
	/**
	 * 更新实体对应对象(非空的字段)
	 * @param entity
	 * @return
	 */
	long updateIfNotNull(T entity);

	/**
	 * 批量更新对象.
	 * 
	 * @param list
	 *            .
	 * @return int .
	 */
	long update(List<T> list);
	
	/**
	 * 根据ID查找记录.
	 * 
	 * @param id
	 *            .
	 * @return entity .
	 */
	T getById(long id);

	/**
	 * 根据ID删除记录.
	 * 
	 * @param id
	 *            .
	 * @return
	 */
	long deleteById(long id);

	/**
	 * 分页查询 .
	 * 
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
	
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);
	
	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回集合
	 */
	List<T> listBy(Map<String, Object> paramMap);

	List<Object> listBy(Map<String, Object> paramMap, String sqlId);
	
	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回实体
	 */
	T getBy(Map<String, Object> paramMap);

	Object getBy(Map<String, Object> paramMap, String sqlId);

	/**
	 * 统计总计记录
	 * @param paramMap
	 * @return
	 */
	long countTotalRecord(Map<String, Object> paramMap);
	
	/**
	 * 汇总数据
	 * @param paramMap
	 * @return
	 */
	Map<String, Object> sumData(Map<String, Object> paramMap);

	/**
	 * 根据序列名称获取下一个值
	 *
	 * @return
	 */
	String getSeqNextValue(String seqName);
}
