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

import com.google.api.services.bigquery.model.BiEngineStatistics;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** BIEngineStatistics contains query statistics specific to the use of BI Engine. */
@AutoValue
public abstract class BiEngineStats implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * Specifies which mode of BI Engine acceleration was performed (if any).
     *
     * @param biEngineMode biEngineMode or {@code null} for none
     */
    public abstract Builder setBiEngineMode(String biEngineMode);

    /**
     * In case of DISABLED or PARTIAL bi_engine_mode, these contain the explanatory reasons as to
     * why BI Engine could not accelerate. In case the full query was accelerated, this field is not
     * populated.
     *
     * @param biEngineReasons biEngineReasons or {@code null} for none
     */
    public abstract Builder setBiEngineReasons(List<BiEngineReason> biEngineReasons);

    /** Creates a @code BiEngineStats} object. */
    public abstract BiEngineStats build();
  }

  /**
   * Specifies which mode of BI Engine acceleration was performed (if any).
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getBiEngineMode();

  /**
   * In case of DISABLED or PARTIAL bi_engine_mode, these contain the explanatory reasons as to why
   * BI Engine could not accelerate. In case the full query was accelerated, this field is not
   * populated.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract List<BiEngineReason> getBiEngineReasons();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_BiEngineStats.Builder();
  }

  BiEngineStatistics toPb() {
    BiEngineStatistics biEngineStatisticsPb = new BiEngineStatistics();
    if (getBiEngineMode() != null) {
      biEngineStatisticsPb.setBiEngineMode(getBiEngineMode());
    }
    if (getBiEngineReasons() != null) {
      biEngineStatisticsPb.setBiEngineReasons(
          getBiEngineReasons().stream().map(BiEngineReason::toPb).collect(Collectors.toList()));
    }
    return biEngineStatisticsPb;
  }

  static BiEngineStats fromPb(BiEngineStatistics biEngineStatisticsPb) {
    Builder builder = newBuilder();
    if (biEngineStatisticsPb.getBiEngineMode() != null) {
      builder.setBiEngineMode(biEngineStatisticsPb.getBiEngineMode());
    }
    if (biEngineStatisticsPb.getBiEngineReasons() != null) {
      builder.setBiEngineReasons(
          biEngineStatisticsPb.getBiEngineReasons().stream()
              .map(BiEngineReason::fromPb)
              .collect(Collectors.toList()));
    }
    return builder.build();
  }
}
