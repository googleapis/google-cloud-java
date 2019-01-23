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
public final class ScratchDisks implements ApiMessage {
  private final Integer diskGb;

  private ScratchDisks() {
    this.diskGb = null;
  }

  private ScratchDisks(Integer diskGb) {
    this.diskGb = diskGb;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("diskGb".equals(fieldName)) {
      return diskGb;
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
  public List<String> getFieldMask() {
    return null;
  }

  public Integer getDiskGb() {
    return diskGb;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ScratchDisks prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ScratchDisks getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ScratchDisks DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ScratchDisks();
  }

  public static class Builder {
    private Integer diskGb;

    Builder() {}

    public Builder mergeFrom(ScratchDisks other) {
      if (other == ScratchDisks.getDefaultInstance()) return this;
      if (other.getDiskGb() != null) {
        this.diskGb = other.diskGb;
      }
      return this;
    }

    Builder(ScratchDisks source) {
      this.diskGb = source.diskGb;
    }

    public Integer getDiskGb() {
      return diskGb;
    }

    public Builder setDiskGb(Integer diskGb) {
      this.diskGb = diskGb;
      return this;
    }

    public ScratchDisks build() {
      return new ScratchDisks(diskGb);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDiskGb(this.diskGb);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ScratchDisks{" + "diskGb=" + diskGb + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ScratchDisks) {
      ScratchDisks that = (ScratchDisks) o;
      return Objects.equals(this.diskGb, that.getDiskGb());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diskGb);
  }
}
