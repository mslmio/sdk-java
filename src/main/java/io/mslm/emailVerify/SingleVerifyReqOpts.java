package io.mslm.emailVerify;

import io.mslm.lib.ReqOpts;

public class SingleVerifyReqOpts {
    public ReqOpts reqOpts;
    private Boolean disableUrlEncode;

    public ReqOpts getReqOpts() {
        return reqOpts;
    }

    public void setReqOpts(ReqOpts reqOpts) {
        this.reqOpts = reqOpts;
    }

    public Boolean getDisableUrlEncode() {
        return disableUrlEncode;
    }

    public void setDisableUrlEncode(Boolean disableUrlEncode) {
        this.disableUrlEncode = disableUrlEncode;
    }
}
