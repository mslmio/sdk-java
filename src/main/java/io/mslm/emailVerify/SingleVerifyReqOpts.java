package io.mslm.emailVerify;

import io.mslm.lib.ReqOpts;

public class SingleVerifyReqOpts {
    private ReqOpts reqOpts;
    private Boolean disableUrlEncode;

    public SingleVerifyReqOpts() {}

    public void setReqOpts(ReqOpts reqOpts) {
        this.reqOpts = reqOpts;
    }

    public ReqOpts getReqOpts() {
        return reqOpts;
    }

    public Boolean getDisableUrlEncode() {
        return disableUrlEncode;
    }

    // Builder class for SingleVerifyReqOpts
    public static class Builder {
        private SingleVerifyReqOpts opts;

        public Builder() {
            opts = new SingleVerifyReqOpts();
        }

        public Builder withReqOpts(ReqOpts reqOpts) {
            opts.reqOpts = reqOpts;
            return this;
        }

        public Builder withDisableUrlEncode(boolean disableUrlEncode) {
            opts.disableUrlEncode = disableUrlEncode;
            return this;
        }

        public SingleVerifyReqOpts build() {
            return opts;
        }
    }
}
