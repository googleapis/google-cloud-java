/*
 * Copyright 2018 Google LLC
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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class ZoneSetPolicyRequest implements ApiMessage {
  private final List<Binding> bindings;
  private final String etag;
  private final Policy policy;

  private ZoneSetPolicyRequest() {
    this.bindings = null;
    this.etag = null;
    this.policy = null;
  }

  private ZoneSetPolicyRequest(List<Binding> bindings, String etag, Policy policy) {
    this.bindings = bindings;
    this.etag = etag;
    this.policy = policy;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("bindings")) {
      return bindings;
    }
    if (fieldName.equals("etag")) {
      return etag;
    }
    if (fieldName.equals("policy")) {
      return policy;
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

  public List<Binding> getBindingsList() {
    return bindings;
  }

  public String getEtag() {
    return etag;
  }

  public Policy getPolicy() {
    return policy;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ZoneSetPolicyRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ZoneSetPolicyRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ZoneSetPolicyRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ZoneSetPolicyRequest();
  }

  public static class Builder {
    private List<Binding> bindings;
    private String etag;
    private Policy policy;

    Builder() {}

    public Builder mergeFrom(ZoneSetPolicyRequest other) {
      if (other == ZoneSetPolicyRequest.getDefaultInstance()) return this;
      if (other.getBindingsList() != null) {
        this.bindings = other.bindings;
      }
      if (other.getEtag() != null) {
        this.etag = other.etag;
      }
      if (other.getPolicy() != null) {
        this.policy = other.policy;
      }
      return this;
    }

    Builder(ZoneSetPolicyRequest source) {
      this.bindings = source.bindings;
      this.etag = source.etag;
      this.policy = source.policy;
    }

    public List<Binding> getBindingsList() {
      return bindings;
    }

    public Builder addAllBindings(List<Binding> bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.addAll(bindings);
      return this;
    }

    public Builder addBindings(Binding bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.add(bindings);
      return this;
    }

    public String getEtag() {
      return etag;
    }

    public Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    public Policy getPolicy() {
      return policy;
    }

    public Builder setPolicy(Policy policy) {
      this.policy = policy;
      return this;
    }

    public ZoneSetPolicyRequest build() {

      return new ZoneSetPolicyRequest(bindings, etag, policy);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllBindings(this.bindings);
      newBuilder.setEtag(this.etag);
      newBuilder.setPolicy(this.policy);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ZoneSetPolicyRequest{"
        + "bindings="
        + bindings
        + ", "
        + "etag="
        + etag
        + ", "
        + "policy="
        + policy
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ZoneSetPolicyRequest) {
      ZoneSetPolicyRequest that = (ZoneSetPolicyRequest) o;
      return Objects.equals(this.bindings, that.getBindingsList())
          && Objects.equals(this.etag, that.getEtag())
          && Objects.equals(this.policy, that.getPolicy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bindings, etag, policy);
  }
}
