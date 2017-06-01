/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.common.base.Preconditions;

public class PartitionParameters {
  private final Integer desiredBytesPerBatch;
  private final Integer maxPartitionCount;
  
  PartitionParameters(Builder builder) {
    desiredBytesPerBatch = builder.desiredBytesPerBatch;
    maxPartitionCount = builder.maxPartitionCount;
  }
  
  /** Builder for {@PartitionParameters} instance. **/
  public static class Builder {
    
    private Integer desiredBytesPerBatch;
    private Integer maxPartitionCount;
    
    private Builder() {}
    
    public Builder setDesiredBytesPerBatch(int desiredBytesPerBatch) {
      Preconditions.checkArgument(desiredBytesPerBatch > 0,
          "Invalid desiredBytesPerBatch: " + desiredBytesPerBatch);
      this.desiredBytesPerBatch = desiredBytesPerBatch;
      return this;
    }

    public Builder setMaxPartitionCount(int maxPartitionCount) {
      Preconditions.checkArgument(maxPartitionCount > 0, 
          "Invalid maxPartitionCount: " + maxPartitionCount);
      this.maxPartitionCount = maxPartitionCount;
      return this;
    }

    public PartitionParameters build() {
      return new PartitionParameters(this);
    }
  }
  
  public static PartitionParameters getDefaultInstance() {
    return newBuilder().build();
  }
  
  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getDesiredBytesPerBatch() {
    return desiredBytesPerBatch;
  }

  public Integer getMaxPartitionCount() {
    return maxPartitionCount;
  }
}