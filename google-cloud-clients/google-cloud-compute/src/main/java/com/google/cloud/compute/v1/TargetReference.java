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
public final class TargetReference implements ApiMessage {
  private final String target;

  private TargetReference() {
    this.target = null;
  }

  private TargetReference(String target) {
    this.target = target;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("target".equals(fieldName)) {
      return target;
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

  public String getTarget() {
    return target;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetReference prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetReference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetReference DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetReference();
  }

  public static class Builder {
    private String target;

    Builder() {}

    public Builder mergeFrom(TargetReference other) {
      if (other == TargetReference.getDefaultInstance()) return this;
      if (other.getTarget() != null) {
        this.target = other.target;
      }
      return this;
    }

    Builder(TargetReference source) {
      this.target = source.target;
    }

    public String getTarget() {
      return target;
    }

    public Builder setTarget(String target) {
      this.target = target;
      return this;
    }

    public TargetReference build() {
      return new TargetReference(target);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setTarget(this.target);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetReference{" + "target=" + target + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetReference) {
      TargetReference that = (TargetReference) o;
      return Objects.equals(this.target, that.getTarget());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(target);
  }
}
