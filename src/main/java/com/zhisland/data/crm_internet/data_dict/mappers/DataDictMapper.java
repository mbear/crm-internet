/**
 * 
 */
package com.zhisland.data.crm_internet.data_dict.mappers;

import java.util.List;
import java.util.TreeSet;

import org.apache.ibatis.annotations.Select;

import com.zhisland.data.crm_internet.data_dict.dto.City;
import com.zhisland.data.crm_internet.data_dict.dto.DataDictDTO;
import com.zhisland.data.crm_internet.data_dict.dto.Province;

/**
 * @author muzongyan
 *
 */
public interface DataDictMapper {

    @Select("SELECT item_id AS itemId, item_name AS itemName, item_sort AS itemSort,"
            + " item_description AS itemDescription"
            + " FROM data_dictionary"
            + " WHERE parent_item_id = #{categoryId} AND is_valid = 1")
    public TreeSet<DataDictDTO> findAllItemsByOneLevelCategory(int categoryId);
    
    @Select("SELECT d2.item_id AS itemId, d2.item_name AS itemName,"
            + " (d1.item_sort * 1000 + d2.item_sort) AS itemSort, d2.item_description AS itemDescription"
            + " FROM data_dictionary d1, data_dictionary d2"
            + " WHERE d1.item_id = d2.parent_item_id AND d1.is_valid = 1"
            + " AND d2.is_valid = 1 AND d1.parent_item_id = #{categoryId}")
    public TreeSet<DataDictDTO> findAllItemsByTwoLevelCategory(int categoryId);

    @Select("SELECT id, `name` FROM province")
    public List<Province> findAllProvinces();

    @Select("SELECT id, `name` FROM city WHERE perant_id = #{parentId}")
    public List<City> findAllCitiesByProvince(int parentId);
}
