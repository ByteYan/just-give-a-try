package com.byteyan.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BatchProcessJob {
    @XxlJob("batchProcessJob") // 任务名称
    public void batchProcess() {
        log.info("start to batch process data");
        XxlJobHelper.log("process job has finished");
    }

}
