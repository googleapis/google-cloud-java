/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging.logback;

import static com.google.common.truth.Truth.assertThat;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.cloud.logging.LoggingOptions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAppenderLogbackTest {
  @Test
  public void testLoggingOptionsFromLogbackXMLFileConfig() throws JoranException {
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    JoranConfigurator jc = new JoranConfigurator();
    jc.setContext(context);
    context.reset();
    jc.doConfigure("src/test/java/com/google/cloud/logging/logback/logback.xml");
    Logger logger = LoggerFactory.getLogger(LoggingAppenderLogbackTest.class);
    assertThat(logger.getName())
        .isEqualTo("com.google.cloud.logging.logback.LoggingAppenderLogbackTest");
    LoggingAppender appender = (LoggingAppender) context.getLogger("ROOT").getAppender("CLOUD");
    LoggingOptions options = appender.getLoggingOptions();
    assertThat(options.getAutoPopulateMetadata()).isEqualTo(false);
    assertThat(options.getBatchingSettings().getDelayThreshold().toMillis()).isEqualTo(500);
    assertThat(options.getBatchingSettings().getElementCountThreshold()).isEqualTo(100);
    assertThat(options.getBatchingSettings().getIsEnabled()).isEqualTo(true);
    assertThat(options.getBatchingSettings().getRequestByteThreshold()).isEqualTo(1000);
    assertThat(options.getBatchingSettings().getFlowControlSettings().getLimitExceededBehavior())
        .isEqualTo(LimitExceededBehavior.Ignore);
    assertThat(
            options.getBatchingSettings().getFlowControlSettings().getMaxOutstandingElementCount())
        .isEqualTo(10000);
    assertThat(
            options.getBatchingSettings().getFlowControlSettings().getMaxOutstandingRequestBytes())
        .isEqualTo(100000);
  }
}
