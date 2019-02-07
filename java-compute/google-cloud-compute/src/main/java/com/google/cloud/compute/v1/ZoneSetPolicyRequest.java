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
    if ("bindings".equals(fieldName)) {
      return bindings;
    }
    if ("etag".equals(fieldName)) {
      return etag;
    }
    if ("policy".equals(fieldName)) {
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

  /**
   * Flatten Policy to create a backwacd compatible wire-format. Deprecated. Use 'policy' to specify
   * bindings.
   */
  public List<Binding> getBindingsList() {
    return bindings;
  }

  /**
   * Flatten Policy to create a backward compatible wire-format. Deprecated. Use 'policy' to specify
   * the etag.
   */
  public String getEtag() {
    return etag;
  }

  /**
   * REQUIRED: The complete policy to be applied to the 'resource'. The size of the policy is
   * limited to a few 10s of KB. An empty policy is in general a valid policy but certain services
   * (like Projects) might reject them.
   */
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

    /**
     * Flatten Policy to create a backwacd compatible wire-format. Deprecated. Use 'policy' to
     * specify bindings.
     */
    public List<Binding> getBindingsList() {
      return bindings;
    }

    /**
     * Flatten Policy to create a backwacd compatible wire-format. Deprecated. Use 'policy' to
     * specify bindings.
     */
    public Builder addAllBindings(List<Binding> bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.addAll(bindings);
      return this;
    }

    /**
     * Flatten Policy to create a backwacd compatible wire-format. Deprecated. Use 'policy' to
     * specify bindings.
     */
    public Builder addBindings(Binding bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.add(bindings);
      return this;
    }

    /**
     * Flatten Policy to create a backward compatible wire-format. Deprecated. Use 'policy' to
     * specify the etag.
     */
    public String getEtag() {
      return etag;
    }

    /**
     * Flatten Policy to create a backward compatible wire-format. Deprecated. Use 'policy' to
     * specify the etag.
     */
    public Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    /**
     * REQUIRED: The complete policy to be applied to the 'resource'. The size of the policy is
     * limited to a few 10s of KB. An empty policy is in general a valid policy but certain services
     * (like Projects) might reject them.
     */
    public Policy getPolicy() {
      return policy;
    }

    /**
     * REQUIRED: The complete policy to be applied to the 'resource'. The size of the policy is
     * limited to a few 10s of KB. An empty policy is in general a valid policy but certain services
     * (like Projects) might reject them.
     */
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
