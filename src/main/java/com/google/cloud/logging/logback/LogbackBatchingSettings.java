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

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import org.threeten.bp.Duration;

/**
 * This class is used only to provide batch settings configuration in logback.xml since {@link
 * com.google.api.gax.batching.BatchingSettings} cannot be used as is with logback configuration
 * described in https://logback.qos.ch/manual/configuration.html. All data members below are simply
 * copy of {@link com.google.api.gax.batching.BatchingSettings} class, so it could be used with
 * logback.xml.
 */
public class LogbackBatchingSettings {
  private Long elementCountThreshold = null;
  private Long requestByteThreshold = null;
  private Long delayThreshold = null;
  private Long maxOutstandingElementCount = null;
  private Long maxOutstandingRequestBytes = null;
  private LimitExceededBehavior limitExceededBehavior = null;

  public void setElementCountThreshold(Long value) {
    elementCountThreshold = value;
  }

  public void setRequestByteThreshold(Long value) {
    requestByteThreshold = value;
  }

  public void setDelayThreshold(Long value) {
    delayThreshold = value;
  }

  public void setMaxOutstandingElementCount(Long value) {
    maxOutstandingElementCount = value;
  }

  public void setMaxOutstandingRequestBytes(Long value) {
    maxOutstandingRequestBytes = value;
  }

  public void setLimitExceededBehavior(LimitExceededBehavior value) {
    limitExceededBehavior = value;
  }

  public BatchingSettings build() {
    BatchingSettings.Builder settings = BatchingSettings.newBuilder();
    if (elementCountThreshold != null) {
      settings.setElementCountThreshold(elementCountThreshold);
    }
    if (requestByteThreshold != null) {
      settings.setRequestByteThreshold(requestByteThreshold);
    }
    if (delayThreshold != null) {
      settings.setDelayThreshold(Duration.ofMillis(delayThreshold));
    }
    if (maxOutstandingElementCount != null
        || maxOutstandingRequestBytes != null
        || limitExceededBehavior != null) {
      FlowControlSettings.Builder flowControlSettings = FlowControlSettings.newBuilder();
      flowControlSettings.setMaxOutstandingElementCount(maxOutstandingElementCount);
      flowControlSettings.setMaxOutstandingRequestBytes(maxOutstandingRequestBytes);
      if (limitExceededBehavior != null) {
        flowControlSettings.setLimitExceededBehavior(limitExceededBehavior);
      }
      settings.setFlowControlSettings(flowControlSettings.build());
    }
    return settings.build();
  }
}
