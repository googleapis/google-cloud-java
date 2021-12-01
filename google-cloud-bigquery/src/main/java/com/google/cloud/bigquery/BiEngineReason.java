/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nullable;

@AutoValue
public abstract class BiEngineReason implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * High-level BI Engine reason for partial or disabled acceleration.
     *
     * @param code code or {@code null} for none
     */
    public abstract Builder setCode(String code);

    /**
     * Free form human-readable reason for partial or disabled acceleration.
     *
     * @param message message or {@code null} for none
     */
    public abstract Builder setMessage(String message);

    /** Creates a {@code BiEngineReason} object. */
    public abstract BiEngineReason build();
  }

  /**
   * High-level BI Engine reason for partial or disabled acceleration.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getCode();

  /**
   * Free form human-readable reason for partial or disabled acceleration.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getMessage();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_BiEngineReason.Builder();
  }

  com.google.api.services.bigquery.model.BiEngineReason toPb() {
    com.google.api.services.bigquery.model.BiEngineReason biEngineReasonPb =
        new com.google.api.services.bigquery.model.BiEngineReason();
    if (getCode() != null) {
      biEngineReasonPb.setCode(getCode());
    }
    if (getMessage() != null) {
      biEngineReasonPb.setMessage(getMessage());
    }
    return biEngineReasonPb;
  }

  static BiEngineReason fromPb(
      com.google.api.services.bigquery.model.BiEngineReason biEngineReasonPb) {
    Builder builder = newBuilder();
    if (biEngineReasonPb.getCode() != null) {
      builder.setCode(biEngineReasonPb.getCode());
    }
    if (biEngineReasonPb.getMessage() != null) {
      builder.setMessage(biEngineReasonPb.getMessage());
    }
    return builder.build();
  }
}
