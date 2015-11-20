/*
 * Copyright 2012-2015 CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.codelibs.fess.app.web.admin.scheduler;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.codelibs.fess.Constants;
import org.codelibs.fess.annotation.CronExpression;
import org.codelibs.fess.util.ComponentUtil;
import org.lastaflute.web.validation.Required;
import org.lastaflute.web.validation.theme.conversion.ValidateTypeFailure;

/**
 * @author shinsuke
 */
public class CreateForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ValidateTypeFailure
    public Integer crudMode;

    @Required
    @Size(max = 100)
    public String name;

    @Required
    @Size(max = 100)
    public String target;

    @Required
    @Size(max = 100)
    @CronExpression
    public String cronExpression;

    @Required
    @Size(max = 100)
    public String scriptType;

    @Size(max = 4000)
    public String scriptData;

    public String crawler;

    public String jobLogging;

    public String available;

    @Required
    @Min(value = 0)
    @Max(value = 2147483647)
    @ValidateTypeFailure
    public Integer sortOrder;

    @Required
    @Size(max = 1000)
    public String createdBy;

    @Required
    @ValidateTypeFailure
    public Long createdTime;

    public void initialize() {
        target = Constants.DEFAULT_JOB_TARGET;
        cronExpression = Constants.DEFAULT_CRON_EXPRESSION;
        scriptType = Constants.DEFAULT_JOB_SCRIPT_TYPE;
        sortOrder = 0;
        createdBy = ComponentUtil.getSystemHelper().getUsername();
        createdTime = ComponentUtil.getSystemHelper().getCurrentTimeAsLong();

    }
}