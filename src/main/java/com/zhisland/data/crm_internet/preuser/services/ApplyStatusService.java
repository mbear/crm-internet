/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhisland.data.crm_internet.preuser.dtos.ApplyStatus;
import com.zhisland.data.crm_internet.preuser.mappers.ApplyStatusMapper;
import com.zhisland.data.crm_internet.utils.ShortURL;

/**
 * @author muzongyan
 *
 */
@Service
public class ApplyStatusService {

    @Autowired
    private ApplyStatusMapper applyStatusMapper;

    public ApplyStatus getApplyStatus(String encode) throws Exception {
        int id = ShortURL.decode(encode);
        return applyStatusMapper.getApplyStatus(id);
    }

    public void updateStep1Status(boolean status, int id) throws Exception {
        applyStatusMapper.updateStep1Status(status, id);
    }
    
    public void updateStep2Status(boolean status, int id) throws Exception {
        applyStatusMapper.updateStep2Status(status, id);
    }
    
    public void updateStep3Status(boolean status, int id) throws Exception {
        applyStatusMapper.updateStep3Status(status, id);
    }
    
    public void updateStep4Status(boolean status, int id) throws Exception {
        applyStatusMapper.updateStep4Status(status, id);
    }
    
    public void submit(boolean submit, int id) throws Exception {
        applyStatusMapper.submit(submit, id);
    }
}
