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
/**
 * In contrast to a single BackendService in HttpRouteAction to which all matching traffic is
 * directed to, WeightedBackendService allows traffic to be split across multiple BackendServices.
 * The volume of traffic for each BackendService is proportional to the weight specified in each
 * WeightedBackendService
 */
public final class WeightedBackendService implements ApiMessage {
  private final String backendService;
  private final HttpHeaderAction headerAction;
  private final Integer weight;

  private WeightedBackendService() {
    this.backendService = null;
    this.headerAction = null;
    this.weight = null;
  }

  private WeightedBackendService(
      String backendService, HttpHeaderAction headerAction, Integer weight) {
    this.backendService = backendService;
    this.headerAction = headerAction;
    this.weight = weight;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("backendService".equals(fieldName)) {
      return backendService;
    }
    if ("headerAction".equals(fieldName)) {
      return headerAction;
    }
    if ("weight".equals(fieldName)) {
      return weight;
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
   * The full or partial URL to the default BackendService resource. Before forwarding the request
   * to backendService, the loadbalancer applies any relevant headerActions specified as part of
   * this backendServiceWeight.
   */
  public String getBackendService() {
    return backendService;
  }

  /**
   * Specifies changes to request and response headers that need to take effect for the selected
   * backendService. headerAction specified here take effect before headerAction in the enclosing
   * HttpRouteRule, PathMatcher and UrlMap.
   */
  public HttpHeaderAction getHeaderAction() {
    return headerAction;
  }

  /**
   * Specifies the fraction of traffic sent to backendService, computed as weight / (sum of all
   * weightedBackendService weights in routeAction) . The selection of a backend service is
   * determined only for new traffic. Once a user's request has been directed to a backendService,
   * subsequent requests will be sent to the same backendService as determined by the
   * BackendService's session affinity policy. The value must be between 0 and 1000
   */
  public Integer getWeight() {
    return weight;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(WeightedBackendService prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static WeightedBackendService getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final WeightedBackendService DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new WeightedBackendService();
  }

  public static class Builder {
    private String backendService;
    private HttpHeaderAction headerAction;
    private Integer weight;

    Builder() {}

    public Builder mergeFrom(WeightedBackendService other) {
      if (other == WeightedBackendService.getDefaultInstance()) return this;
      if (other.getBackendService() != null) {
        this.backendService = other.backendService;
      }
      if (other.getHeaderAction() != null) {
        this.headerAction = other.headerAction;
      }
      if (other.getWeight() != null) {
        this.weight = other.weight;
      }
      return this;
    }

    Builder(WeightedBackendService source) {
      this.backendService = source.backendService;
      this.headerAction = source.headerAction;
      this.weight = source.weight;
    }

    /**
     * The full or partial URL to the default BackendService resource. Before forwarding the request
     * to backendService, the loadbalancer applies any relevant headerActions specified as part of
     * this backendServiceWeight.
     */
    public String getBackendService() {
      return backendService;
    }

    /**
     * The full or partial URL to the default BackendService resource. Before forwarding the request
     * to backendService, the loadbalancer applies any relevant headerActions specified as part of
     * this backendServiceWeight.
     */
    public Builder setBackendService(String backendService) {
      this.backendService = backendService;
      return this;
    }

    /**
     * Specifies changes to request and response headers that need to take effect for the selected
     * backendService. headerAction specified here take effect before headerAction in the enclosing
     * HttpRouteRule, PathMatcher and UrlMap.
     */
    public HttpHeaderAction getHeaderAction() {
      return headerAction;
    }

    /**
     * Specifies changes to request and response headers that need to take effect for the selected
     * backendService. headerAction specified here take effect before headerAction in the enclosing
     * HttpRouteRule, PathMatcher and UrlMap.
     */
    public Builder setHeaderAction(HttpHeaderAction headerAction) {
      this.headerAction = headerAction;
      return this;
    }

    /**
     * Specifies the fraction of traffic sent to backendService, computed as weight / (sum of all
     * weightedBackendService weights in routeAction) . The selection of a backend service is
     * determined only for new traffic. Once a user's request has been directed to a backendService,
     * subsequent requests will be sent to the same backendService as determined by the
     * BackendService's session affinity policy. The value must be between 0 and 1000
     */
    public Integer getWeight() {
      return weight;
    }

    /**
     * Specifies the fraction of traffic sent to backendService, computed as weight / (sum of all
     * weightedBackendService weights in routeAction) . The selection of a backend service is
     * determined only for new traffic. Once a user's request has been directed to a backendService,
     * subsequent requests will be sent to the same backendService as determined by the
     * BackendService's session affinity policy. The value must be between 0 and 1000
     */
    public Builder setWeight(Integer weight) {
      this.weight = weight;
      return this;
    }

    public WeightedBackendService build() {

      return new WeightedBackendService(backendService, headerAction, weight);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBackendService(this.backendService);
      newBuilder.setHeaderAction(this.headerAction);
      newBuilder.setWeight(this.weight);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "WeightedBackendService{"
        + "backendService="
        + backendService
        + ", "
        + "headerAction="
        + headerAction
        + ", "
        + "weight="
        + weight
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof WeightedBackendService) {
      WeightedBackendService that = (WeightedBackendService) o;
      return Objects.equals(this.backendService, that.getBackendService())
          && Objects.equals(this.headerAction, that.getHeaderAction())
          && Objects.equals(this.weight, that.getWeight());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(backendService, headerAction, weight);
  }
}
