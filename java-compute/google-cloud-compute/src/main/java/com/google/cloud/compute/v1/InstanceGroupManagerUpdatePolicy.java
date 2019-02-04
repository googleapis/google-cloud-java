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
public final class InstanceGroupManagerUpdatePolicy implements ApiMessage {
  private final FixedOrPercent maxSurge;
  private final FixedOrPercent maxUnavailable;
  private final String minimalAction;
  private final String type;

  private InstanceGroupManagerUpdatePolicy() {
    this.maxSurge = null;
    this.maxUnavailable = null;
    this.minimalAction = null;
    this.type = null;
  }

  private InstanceGroupManagerUpdatePolicy(
      FixedOrPercent maxSurge, FixedOrPercent maxUnavailable, String minimalAction, String type) {
    this.maxSurge = maxSurge;
    this.maxUnavailable = maxUnavailable;
    this.minimalAction = minimalAction;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("maxSurge".equals(fieldName)) {
      return maxSurge;
    }
    if ("maxUnavailable".equals(fieldName)) {
      return maxUnavailable;
    }
    if ("minimalAction".equals(fieldName)) {
      return minimalAction;
    }
    if ("type".equals(fieldName)) {
      return type;
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

  public FixedOrPercent getMaxSurge() {
    return maxSurge;
  }

  public FixedOrPercent getMaxUnavailable() {
    return maxUnavailable;
  }

  public String getMinimalAction() {
    return minimalAction;
  }

  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerUpdatePolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerUpdatePolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerUpdatePolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerUpdatePolicy();
  }

  public static class Builder {
    private FixedOrPercent maxSurge;
    private FixedOrPercent maxUnavailable;
    private String minimalAction;
    private String type;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerUpdatePolicy other) {
      if (other == InstanceGroupManagerUpdatePolicy.getDefaultInstance()) return this;
      if (other.getMaxSurge() != null) {
        this.maxSurge = other.maxSurge;
      }
      if (other.getMaxUnavailable() != null) {
        this.maxUnavailable = other.maxUnavailable;
      }
      if (other.getMinimalAction() != null) {
        this.minimalAction = other.minimalAction;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(InstanceGroupManagerUpdatePolicy source) {
      this.maxSurge = source.maxSurge;
      this.maxUnavailable = source.maxUnavailable;
      this.minimalAction = source.minimalAction;
      this.type = source.type;
    }

    public FixedOrPercent getMaxSurge() {
      return maxSurge;
    }

    public Builder setMaxSurge(FixedOrPercent maxSurge) {
      this.maxSurge = maxSurge;
      return this;
    }

    public FixedOrPercent getMaxUnavailable() {
      return maxUnavailable;
    }

    public Builder setMaxUnavailable(FixedOrPercent maxUnavailable) {
      this.maxUnavailable = maxUnavailable;
      return this;
    }

    public String getMinimalAction() {
      return minimalAction;
    }

    public Builder setMinimalAction(String minimalAction) {
      this.minimalAction = minimalAction;
      return this;
    }

    public String getType() {
      return type;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public InstanceGroupManagerUpdatePolicy build() {

      return new InstanceGroupManagerUpdatePolicy(maxSurge, maxUnavailable, minimalAction, type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMaxSurge(this.maxSurge);
      newBuilder.setMaxUnavailable(this.maxUnavailable);
      newBuilder.setMinimalAction(this.minimalAction);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerUpdatePolicy{"
        + "maxSurge="
        + maxSurge
        + ", "
        + "maxUnavailable="
        + maxUnavailable
        + ", "
        + "minimalAction="
        + minimalAction
        + ", "
        + "type="
        + type
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerUpdatePolicy) {
      InstanceGroupManagerUpdatePolicy that = (InstanceGroupManagerUpdatePolicy) o;
      return Objects.equals(this.maxSurge, that.getMaxSurge())
          && Objects.equals(this.maxUnavailable, that.getMaxUnavailable())
          && Objects.equals(this.minimalAction, that.getMinimalAction())
          && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxSurge, maxUnavailable, minimalAction, type);
  }
}
