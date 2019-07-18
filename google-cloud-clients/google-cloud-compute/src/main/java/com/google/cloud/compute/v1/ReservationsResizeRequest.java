/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class ReservationsResizeRequest implements ApiMessage {
  private final String specificSkuCount;

  private ReservationsResizeRequest() {
    this.specificSkuCount = null;
  }

  private ReservationsResizeRequest(String specificSkuCount) {
    this.specificSkuCount = specificSkuCount;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("specificSkuCount".equals(fieldName)) {
      return specificSkuCount;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** Number of allocated resources can be resized with minimum = 1 and maximum = 1000. */
  public String getSpecificSkuCount() {
    return specificSkuCount;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ReservationsResizeRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ReservationsResizeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ReservationsResizeRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ReservationsResizeRequest();
  }

  public static class Builder {
    private String specificSkuCount;

    Builder() {}

    public Builder mergeFrom(ReservationsResizeRequest other) {
      if (other == ReservationsResizeRequest.getDefaultInstance()) return this;
      if (other.getSpecificSkuCount() != null) {
        this.specificSkuCount = other.specificSkuCount;
      }
      return this;
    }

    Builder(ReservationsResizeRequest source) {
      this.specificSkuCount = source.specificSkuCount;
    }

    /** Number of allocated resources can be resized with minimum = 1 and maximum = 1000. */
    public String getSpecificSkuCount() {
      return specificSkuCount;
    }

    /** Number of allocated resources can be resized with minimum = 1 and maximum = 1000. */
    public Builder setSpecificSkuCount(String specificSkuCount) {
      this.specificSkuCount = specificSkuCount;
      return this;
    }

    public ReservationsResizeRequest build() {
      return new ReservationsResizeRequest(specificSkuCount);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setSpecificSkuCount(this.specificSkuCount);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ReservationsResizeRequest{" + "specificSkuCount=" + specificSkuCount + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ReservationsResizeRequest) {
      ReservationsResizeRequest that = (ReservationsResizeRequest) o;
      return Objects.equals(this.specificSkuCount, that.getSpecificSkuCount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(specificSkuCount);
  }
}
