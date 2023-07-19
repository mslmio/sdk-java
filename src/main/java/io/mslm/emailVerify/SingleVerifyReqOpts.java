package io.mslm.emailVerify;

import io.mslm.lib.ReqOpts;

public class SingleVerifyReqOpts {
    private ReqOpts reqOpts;
    private Boolean disableUrlEncode;

    public SingleVerifyReqOpts() {}

    public ReqOpts getReqOpts() {
        return reqOpts;
    }

    public void setReqOpts(ReqOpts reqOpts) {
        this.reqOpts = reqOpts;
    }

    public Boolean getDisableUrlEncode() {
        return disableUrlEncode;
    }

    public void setDisableUrlEncode(Boolean disableUrlEncode) {this.disableUrlEncode = disableUrlEncode;}

    // Builder class for SingleVerifyReqOpts
    public static class Builder {
        private SingleVerifyReqOpts opts;

        public Builder() {
            opts = new SingleVerifyReqOpts();
            opts.reqOpts = new ReqOpts();
            opts.disableUrlEncode = false;
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
