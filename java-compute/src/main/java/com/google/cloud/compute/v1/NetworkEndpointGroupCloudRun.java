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
 * Configuration for a Cloud Run network endpoint group (NEG). The service must be provided
 * explicitly or in the URL mask. The tag is optional, may be provided explicitly or in the URL
 * mask.
 *
 * <p>Note: Cloud Run service must be in the same project and located in the same region as the
 * Serverless NEG.
 */
public final class NetworkEndpointGroupCloudRun implements ApiMessage {
  private final String service;
  private final String tag;
  private final String urlMask;

  private NetworkEndpointGroupCloudRun() {
    this.service = null;
    this.tag = null;
    this.urlMask = null;
  }

  private NetworkEndpointGroupCloudRun(String service, String tag, String urlMask) {
    this.service = service;
    this.tag = tag;
    this.urlMask = urlMask;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("service".equals(fieldName)) {
      return service;
    }
    if ("tag".equals(fieldName)) {
      return tag;
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
   * Cloud Run service is the main resource of Cloud Run.
   *
   * <p>The service must be 1-63 characters long, and comply with RFC1035.
   *
   * <p>Example value: "run-service".
   */
  public String getService() {
    return service;
  }

  /**
   * Optional Cloud Run tag represents the "named-revision" to provide additional fine-grained
   * traffic routing information.
   *
   * <p>The tag must be 1-63 characters long, and comply with RFC1035.
   *
   * <p>Example value: "revision-0010".
   */
  public String getTag() {
    return tag;
  }

  /**
   * A template to parse service and tag fields from a request URL. URL mask allows for routing to
   * multiple Run services without having to create multiple network endpoint groups and backend
   * services.
   *
   * <p>For example, request URLs "foo1.domain.com/bar1" and "foo1.domain.com/bar2" can be backed by
   * the same Serverless Network Endpoint Group (NEG) with URL mask ".domain.com/". The URL mask
   * will parse them to { service="bar1", tag="foo1" } and { service="bar2", tag="foo2" }
   * respectively.
   */
  public String getUrlMask() {
    return urlMask;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroupCloudRun prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroupCloudRun getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroupCloudRun DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroupCloudRun();
  }

  public static class Builder {
    private String service;
    private String tag;
    private String urlMask;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroupCloudRun other) {
      if (other == NetworkEndpointGroupCloudRun.getDefaultInstance()) return this;
      if (other.getService() != null) {
        this.service = other.service;
      }
      if (other.getTag() != null) {
        this.tag = other.tag;
      }
      if (other.getUrlMask() != null) {
        this.urlMask = other.urlMask;
      }
      return this;
    }

    Builder(NetworkEndpointGroupCloudRun source) {
      this.service = source.service;
      this.tag = source.tag;
      this.urlMask = source.urlMask;
    }

    /**
     * Cloud Run service is the main resource of Cloud Run.
     *
     * <p>The service must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "run-service".
     */
    public String getService() {
      return service;
    }

    /**
     * Cloud Run service is the main resource of Cloud Run.
     *
     * <p>The service must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "run-service".
     */
    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    /**
     * Optional Cloud Run tag represents the "named-revision" to provide additional fine-grained
     * traffic routing information.
     *
     * <p>The tag must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "revision-0010".
     */
    public String getTag() {
      return tag;
    }

    /**
     * Optional Cloud Run tag represents the "named-revision" to provide additional fine-grained
     * traffic routing information.
     *
     * <p>The tag must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "revision-0010".
     */
    public Builder setTag(String tag) {
      this.tag = tag;
      return this;
    }

    /**
     * A template to parse service and tag fields from a request URL. URL mask allows for routing to
     * multiple Run services without having to create multiple network endpoint groups and backend
     * services.
     *
     * <p>For example, request URLs "foo1.domain.com/bar1" and "foo1.domain.com/bar2" can be backed
     * by the same Serverless Network Endpoint Group (NEG) with URL mask ".domain.com/". The URL
     * mask will parse them to { service="bar1", tag="foo1" } and { service="bar2", tag="foo2" }
     * respectively.
     */
    public String getUrlMask() {
      return urlMask;
    }

    /**
     * A template to parse service and tag fields from a request URL. URL mask allows for routing to
     * multiple Run services without having to create multiple network endpoint groups and backend
     * services.
     *
     * <p>For example, request URLs "foo1.domain.com/bar1" and "foo1.domain.com/bar2" can be backed
     * by the same Serverless Network Endpoint Group (NEG) with URL mask ".domain.com/". The URL
     * mask will parse them to { service="bar1", tag="foo1" } and { service="bar2", tag="foo2" }
     * respectively.
     */
    public Builder setUrlMask(String urlMask) {
      this.urlMask = urlMask;
      return this;
    }

    public NetworkEndpointGroupCloudRun build() {

      return new NetworkEndpointGroupCloudRun(service, tag, urlMask);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setService(this.service);
      newBuilder.setTag(this.tag);
      newBuilder.setUrlMask(this.urlMask);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroupCloudRun{"
        + "service="
        + service
        + ", "
        + "tag="
        + tag
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
    if (o instanceof NetworkEndpointGroupCloudRun) {
      NetworkEndpointGroupCloudRun that = (NetworkEndpointGroupCloudRun) o;
      return Objects.equals(this.service, that.getService())
          && Objects.equals(this.tag, that.getTag())
          && Objects.equals(this.urlMask, that.getUrlMask());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(service, tag, urlMask);
  }
}
