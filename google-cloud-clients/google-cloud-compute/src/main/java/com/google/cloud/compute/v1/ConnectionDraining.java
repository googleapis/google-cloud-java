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
public final class ConnectionDraining implements ApiMessage {
  private final Integer drainingTimeoutSec;

  private ConnectionDraining() {
    this.drainingTimeoutSec = null;
  }

  private ConnectionDraining(Integer drainingTimeoutSec) {
    this.drainingTimeoutSec = drainingTimeoutSec;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("drainingTimeoutSec".equals(fieldName)) {
      return drainingTimeoutSec;
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

  public Integer getDrainingTimeoutSec() {
    return drainingTimeoutSec;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ConnectionDraining prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ConnectionDraining getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ConnectionDraining DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ConnectionDraining();
  }

  public static class Builder {
    private Integer drainingTimeoutSec;

    Builder() {}

    public Builder mergeFrom(ConnectionDraining other) {
      if (other == ConnectionDraining.getDefaultInstance()) return this;
      if (other.getDrainingTimeoutSec() != null) {
        this.drainingTimeoutSec = other.drainingTimeoutSec;
      }
      return this;
    }

    Builder(ConnectionDraining source) {
      this.drainingTimeoutSec = source.drainingTimeoutSec;
    }

    public Integer getDrainingTimeoutSec() {
      return drainingTimeoutSec;
    }

    public Builder setDrainingTimeoutSec(Integer drainingTimeoutSec) {
      this.drainingTimeoutSec = drainingTimeoutSec;
      return this;
    }

    public ConnectionDraining build() {
      return new ConnectionDraining(drainingTimeoutSec);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDrainingTimeoutSec(this.drainingTimeoutSec);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ConnectionDraining{" + "drainingTimeoutSec=" + drainingTimeoutSec + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ConnectionDraining) {
      ConnectionDraining that = (ConnectionDraining) o;
      return Objects.equals(this.drainingTimeoutSec, that.getDrainingTimeoutSec());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(drainingTimeoutSec);
  }
}
