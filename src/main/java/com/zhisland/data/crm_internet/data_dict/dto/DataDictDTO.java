/**
 * 
 */
package com.zhisland.data.crm_internet.data_dict.dto;

import java.text.Collator;
import java.util.Locale;

/**
 * 数据字典
 * 
 * @author muzongyan
 *
 */
public class DataDictDTO implements Comparable<DataDictDTO> {

    private Integer itemId;

    private String itemName;

    private Integer itemSort;
    
    private String itemDescription;

    @Override
    public int compareTo(DataDictDTO obj) {
        if (this.itemSort != null && obj.getItemSort() != null && this.itemSort != obj.getItemSort()
                && (this.itemSort != 0 || obj.getItemSort() != 0)) {
            return this.itemSort - obj.getItemSort();
        }

        Collator collator = Collator.getInstance(Locale.SIMPLIFIED_CHINESE);
        return collator.compare(this.itemName, obj.getItemName());
    }

    @Override
    public boolean equals(Object object) {
        DataDictDTO obj = (DataDictDTO) object;

        return this.itemName.equals(obj.getItemName());
    }

    /**
     * @return the itemId
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     *            the itemId to set
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     *            the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemSort
     */
    public Integer getItemSort() {
        return itemSort;
    }

    /**
     * @param itemSort
     *            the itemSort to set
     */
    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }

    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * @param itemDescription the itemDescription to set
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

}
