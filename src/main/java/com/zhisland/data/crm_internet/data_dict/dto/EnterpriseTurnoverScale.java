/**
 * 
 */
package com.zhisland.data.crm_internet.data_dict.dto;

/**
 * @author muzongyan
 *
 */
public class EnterpriseTurnoverScale extends DataDictDTO {

    private long min;
    
    private long max;

    /**
     * @return the min
     */
    public long getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(long min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public long getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(long max) {
        this.max = max;
    }

}
