/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.dtos;

/**
 * @author muzongyan
 *
 */
public class ApplyStatus {

    private int id;

    private int memberId;

    private boolean step1Status;

    private boolean step2Status;

    private boolean step3Status;

    private boolean step4Status;
    
    private boolean isSubmit;

    private boolean isValid;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     *            the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the step1Status
     */
    public boolean isStep1Status() {
        return step1Status;
    }

    /**
     * @param step1Status
     *            the step1Status to set
     */
    public void setStep1Status(boolean step1Status) {
        this.step1Status = step1Status;
    }

    /**
     * @return the step2Status
     */
    public boolean isStep2Status() {
        return step2Status;
    }

    /**
     * @param step2Status
     *            the step2Status to set
     */
    public void setStep2Status(boolean step2Status) {
        this.step2Status = step2Status;
    }

    /**
     * @return the step3Status
     */
    public boolean isStep3Status() {
        return step3Status;
    }

    /**
     * @param step3Status
     *            the step3Status to set
     */
    public void setStep3Status(boolean step3Status) {
        this.step3Status = step3Status;
    }

    /**
     * @return the step4Status
     */
    public boolean isStep4Status() {
        return step4Status;
    }

    /**
     * @param step4Status
     *            the step4Status to set
     */
    public void setStep4Status(boolean step4Status) {
        this.step4Status = step4Status;
    }

    /**
     * @return the isSubmit
     */
    public boolean isSubmit() {
        return isSubmit;
    }

    /**
     * @param isSubmit the isSubmit to set
     */
    public void setSubmit(boolean isSubmit) {
        this.isSubmit = isSubmit;
    }

    /**
     * @return the isValid
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * @param isValid
     *            the isValid to set
     */
    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

}
