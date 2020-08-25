/*
 * Copyright 2020 Google LLC
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
/**
 * Configuration for a Cloud Function network endpoint group (NEG). The function must be provided
 * explicitly or in the URL mask.
 *
 * <p>Note: Cloud Function must be in the same project and located in the same region as the
 * Serverless NEG.
 */
public final class NetworkEndpointGroupCloudFunction implements ApiMessage {
  private final String function;
  private final String urlMask;

  private NetworkEndpointGroupCloudFunction() {
    this.function = null;
    this.urlMask = null;
  }

  private NetworkEndpointGroupCloudFunction(String function, String urlMask) {
    this.function = function;
    this.urlMask = urlMask;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("function".equals(fieldName)) {
      return function;
    }
    if ("urlMask".equals(fieldName)) {
      return urlMask;
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

  /**
   * A user-defined name of the Cloud Function.
   *
   * <p>The function name is case-sensitive and must be 1-63 characters long.
   *
   * <p>Example value: "func1".
   */
  public String getFunction() {
    return function;
  }

  /**
   * A template to parse function field from a request URL. URL mask allows for routing to multiple
   * Cloud Functions without having to create multiple Network Endpoint Groups and backend services.
   *
   * <p>For example, request URLs "mydomain.com/function1" and "mydomain.com/function2" can be
   * backed by the same Serverless NEG with URL mask "/". The URL mask will parse them to { function
   * = "function1" } and { function = "function2" } respectively.
   */
  public String getUrlMask() {
    return urlMask;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroupCloudFunction prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroupCloudFunction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroupCloudFunction DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroupCloudFunction();
  }

  public static class Builder {
    private String function;
    private String urlMask;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroupCloudFunction other) {
      if (other == NetworkEndpointGroupCloudFunction.getDefaultInstance()) return this;
      if (other.getFunction() != null) {
        this.function = other.function;
      }
      if (other.getUrlMask() != null) {
        this.urlMask = other.urlMask;
      }
      return this;
    }

    Builder(NetworkEndpointGroupCloudFunction source) {
      this.function = source.function;
      this.urlMask = source.urlMask;
    }

    /**
     * A user-defined name of the Cloud Function.
     *
     * <p>The function name is case-sensitive and must be 1-63 characters long.
     *
     * <p>Example value: "func1".
     */
    public String getFunction() {
      return function;
    }

    /**
     * A user-defined name of the Cloud Function.
     *
     * <p>The function name is case-sensitive and must be 1-63 characters long.
     *
     * <p>Example value: "func1".
     */
    public Builder setFunction(String function) {
      this.function = function;
      return this;
    }

    /**
     * A template to parse function field from a request URL. URL mask allows for routing to
     * multiple Cloud Functions without having to create multiple Network Endpoint Groups and
     * backend services.
     *
     * <p>For example, request URLs "mydomain.com/function1" and "mydomain.com/function2" can be
     * backed by the same Serverless NEG with URL mask "/". The URL mask will parse them to {
     * function = "function1" } and { function = "function2" } respectively.
     */
    public String getUrlMask() {
      return urlMask;
    }

    /**
     * A template to parse function field from a request URL. URL mask allows for routing to
     * multiple Cloud Functions without having to create multiple Network Endpoint Groups and
     * backend services.
     *
     * <p>For example, request URLs "mydomain.com/function1" and "mydomain.com/function2" can be
     * backed by the same Serverless NEG with URL mask "/". The URL mask will parse them to {
     * function = "function1" } and { function = "function2" } respectively.
     */
    public Builder setUrlMask(String urlMask) {
      this.urlMask = urlMask;
      return this;
    }

    public NetworkEndpointGroupCloudFunction build() {

      return new NetworkEndpointGroupCloudFunction(function, urlMask);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFunction(this.function);
      newBuilder.setUrlMask(this.urlMask);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroupCloudFunction{"
        + "function="
        + function
        + ", "
        + "urlMask="
        + urlMask
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointGroupCloudFunction) {
      NetworkEndpointGroupCloudFunction that = (NetworkEndpointGroupCloudFunction) o;
      return Objects.equals(this.function, that.getFunction())
          && Objects.equals(this.urlMask, that.getUrlMask());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(function, urlMask);
  }
}
