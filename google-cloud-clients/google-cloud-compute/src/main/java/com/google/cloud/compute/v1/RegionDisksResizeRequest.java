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
public final class RegionDisksResizeRequest implements ApiMessage {
  private final String sizeGb;

  private RegionDisksResizeRequest() {
    this.sizeGb = null;
  }

  private RegionDisksResizeRequest(String sizeGb) {
    this.sizeGb = sizeGb;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("sizeGb".equals(fieldName)) {
      return sizeGb;
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

  /** The new size of the regional persistent disk, which is specified in GB. */
  public String getSizeGb() {
    return sizeGb;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionDisksResizeRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionDisksResizeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionDisksResizeRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionDisksResizeRequest();
  }

  public static class Builder {
    private String sizeGb;

    Builder() {}

    public Builder mergeFrom(RegionDisksResizeRequest other) {
      if (other == RegionDisksResizeRequest.getDefaultInstance()) return this;
      if (other.getSizeGb() != null) {
        this.sizeGb = other.sizeGb;
      }
      return this;
    }

    Builder(RegionDisksResizeRequest source) {
      this.sizeGb = source.sizeGb;
    }

    /** The new size of the regional persistent disk, which is specified in GB. */
    public String getSizeGb() {
      return sizeGb;
    }

    /** The new size of the regional persistent disk, which is specified in GB. */
    public Builder setSizeGb(String sizeGb) {
      this.sizeGb = sizeGb;
      return this;
    }

    public RegionDisksResizeRequest build() {
      return new RegionDisksResizeRequest(sizeGb);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setSizeGb(this.sizeGb);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RegionDisksResizeRequest{" + "sizeGb=" + sizeGb + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegionDisksResizeRequest) {
      RegionDisksResizeRequest that = (RegionDisksResizeRequest) o;
      return Objects.equals(this.sizeGb, that.getSizeGb());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizeGb);
  }
}
