// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class GapicBatchingSettings {
  public enum FlowControlLimitExceededBehavior {
    THROW_EXCEPTION,
    BLOCK,
    IGNORE
  };

  // Threshold fields.
  public abstract String protoPakkage();

  public abstract String serviceName();

  public abstract String methodName();

  public abstract int elementCountThreshold();

  public abstract long requestByteThreshold();

  public abstract long delayThresholdMillis();

  @Nullable
  public abstract Integer flowControlElementLimit();

  @Nullable
  public abstract Integer flowControlByteLimit();

  public abstract FlowControlLimitExceededBehavior flowControlLimitExceededBehavior();

  // Batch descriptor fields.
  public abstract String batchedFieldName();

  public abstract ImmutableList<String> discriminatorFieldNames();

  @Nullable
  public abstract String subresponseFieldName();

  public boolean matches(Service service, Method method) {
    return protoPakkage().equals(service.protoPakkage())
        && serviceName().equals(service.name())
        && methodName().equals(method.name());
  }

  public static Builder builder() {
    return new AutoValue_GapicBatchingSettings.Builder()
        .setFlowControlLimitExceededBehavior(FlowControlLimitExceededBehavior.IGNORE);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setProtoPakkage(String protoPakkage);

    public abstract Builder setServiceName(String serviceName);

    public abstract Builder setMethodName(String methodName);

    public abstract Builder setElementCountThreshold(int elementCountThreshold);

    public abstract Builder setRequestByteThreshold(long requestByteThreshold);

    public abstract Builder setDelayThresholdMillis(long delalyThresholdMillis);

    public abstract Builder setFlowControlElementLimit(Integer flowControlElementLimit);

    public abstract Builder setFlowControlByteLimit(Integer flowControlByteLimit);

    public abstract Builder setFlowControlLimitExceededBehavior(
        FlowControlLimitExceededBehavior behavior);

    public abstract Builder setBatchedFieldName(String batchedFieldName);

    public abstract Builder setDiscriminatorFieldNames(List<String> discriminatorFieldNames);

    public abstract Builder setSubresponseFieldName(String subresponseFieldName);

    public abstract GapicBatchingSettings build();
  }
}
