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
public final class SslPolicyReference implements ApiMessage {
  private final String sslPolicy;

  private SslPolicyReference() {
    this.sslPolicy = null;
  }

  private SslPolicyReference(String sslPolicy) {
    this.sslPolicy = sslPolicy;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("sslPolicy".equals(fieldName)) {
      return sslPolicy;
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

  /**
   * URL of the SSL policy resource. Set this to empty string to clear any existing SSL policy
   * associated with the target proxy resource.
   */
  public String getSslPolicy() {
    return sslPolicy;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SslPolicyReference prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SslPolicyReference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SslPolicyReference DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SslPolicyReference();
  }

  public static class Builder {
    private String sslPolicy;

    Builder() {}

    public Builder mergeFrom(SslPolicyReference other) {
      if (other == SslPolicyReference.getDefaultInstance()) return this;
      if (other.getSslPolicy() != null) {
        this.sslPolicy = other.sslPolicy;
      }
      return this;
    }

    Builder(SslPolicyReference source) {
      this.sslPolicy = source.sslPolicy;
    }

    /**
     * URL of the SSL policy resource. Set this to empty string to clear any existing SSL policy
     * associated with the target proxy resource.
     */
    public String getSslPolicy() {
      return sslPolicy;
    }

    /**
     * URL of the SSL policy resource. Set this to empty string to clear any existing SSL policy
     * associated with the target proxy resource.
     */
    public Builder setSslPolicy(String sslPolicy) {
      this.sslPolicy = sslPolicy;
      return this;
    }

    public SslPolicyReference build() {
      return new SslPolicyReference(sslPolicy);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setSslPolicy(this.sslPolicy);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SslPolicyReference{" + "sslPolicy=" + sslPolicy + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SslPolicyReference) {
      SslPolicyReference that = (SslPolicyReference) o;
      return Objects.equals(this.sslPolicy, that.getSslPolicy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sslPolicy);
  }
}
