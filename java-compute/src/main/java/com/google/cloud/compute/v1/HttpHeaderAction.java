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
/**
 * The request and response header transformations that take effect before the request is passed
 * along to the selected backendService.
 */
public final class HttpHeaderAction implements ApiMessage {
  private final List<HttpHeaderOption> requestHeadersToAdd;
  private final List<String> requestHeadersToRemove;
  private final List<HttpHeaderOption> responseHeadersToAdd;
  private final List<String> responseHeadersToRemove;

  private HttpHeaderAction() {
    this.requestHeadersToAdd = null;
    this.requestHeadersToRemove = null;
    this.responseHeadersToAdd = null;
    this.responseHeadersToRemove = null;
  }

  private HttpHeaderAction(
      List<HttpHeaderOption> requestHeadersToAdd,
      List<String> requestHeadersToRemove,
      List<HttpHeaderOption> responseHeadersToAdd,
      List<String> responseHeadersToRemove) {
    this.requestHeadersToAdd = requestHeadersToAdd;
    this.requestHeadersToRemove = requestHeadersToRemove;
    this.responseHeadersToAdd = responseHeadersToAdd;
    this.responseHeadersToRemove = responseHeadersToRemove;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("requestHeadersToAdd".equals(fieldName)) {
      return requestHeadersToAdd;
    }
    if ("requestHeadersToRemove".equals(fieldName)) {
      return requestHeadersToRemove;
    }
    if ("responseHeadersToAdd".equals(fieldName)) {
      return responseHeadersToAdd;
    }
    if ("responseHeadersToRemove".equals(fieldName)) {
      return responseHeadersToRemove;
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

  /** Headers to add to a matching request prior to forwarding the request to the backendService. */
  public List<HttpHeaderOption> getRequestHeadersToAddList() {
    return requestHeadersToAdd;
  }

  /**
   * A list of header names for headers that need to be removed from the request prior to forwarding
   * the request to the backendService.
   */
  public List<String> getRequestHeadersToRemoveList() {
    return requestHeadersToRemove;
  }

  /** Headers to add the response prior to sending the response back to the client. */
  public List<HttpHeaderOption> getResponseHeadersToAddList() {
    return responseHeadersToAdd;
  }

  /**
   * A list of header names for headers that need to be removed from the response prior to sending
   * the response back to the client.
   */
  public List<String> getResponseHeadersToRemoveList() {
    return responseHeadersToRemove;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpHeaderAction prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpHeaderAction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpHeaderAction DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpHeaderAction();
  }

  public static class Builder {
    private List<HttpHeaderOption> requestHeadersToAdd;
    private List<String> requestHeadersToRemove;
    private List<HttpHeaderOption> responseHeadersToAdd;
    private List<String> responseHeadersToRemove;

    Builder() {}

    public Builder mergeFrom(HttpHeaderAction other) {
      if (other == HttpHeaderAction.getDefaultInstance()) return this;
      if (other.getRequestHeadersToAddList() != null) {
        this.requestHeadersToAdd = other.requestHeadersToAdd;
      }
      if (other.getRequestHeadersToRemoveList() != null) {
        this.requestHeadersToRemove = other.requestHeadersToRemove;
      }
      if (other.getResponseHeadersToAddList() != null) {
        this.responseHeadersToAdd = other.responseHeadersToAdd;
      }
      if (other.getResponseHeadersToRemoveList() != null) {
        this.responseHeadersToRemove = other.responseHeadersToRemove;
      }
      return this;
    }

    Builder(HttpHeaderAction source) {
      this.requestHeadersToAdd = source.requestHeadersToAdd;
      this.requestHeadersToRemove = source.requestHeadersToRemove;
      this.responseHeadersToAdd = source.responseHeadersToAdd;
      this.responseHeadersToRemove = source.responseHeadersToRemove;
    }

    /**
     * Headers to add to a matching request prior to forwarding the request to the backendService.
     */
    public List<HttpHeaderOption> getRequestHeadersToAddList() {
      return requestHeadersToAdd;
    }

    /**
     * Headers to add to a matching request prior to forwarding the request to the backendService.
     */
    public Builder addAllRequestHeadersToAdd(List<HttpHeaderOption> requestHeadersToAdd) {
      if (this.requestHeadersToAdd == null) {
        this.requestHeadersToAdd = new LinkedList<>();
      }
      this.requestHeadersToAdd.addAll(requestHeadersToAdd);
      return this;
    }

    /**
     * Headers to add to a matching request prior to forwarding the request to the backendService.
     */
    public Builder addRequestHeadersToAdd(HttpHeaderOption requestHeadersToAdd) {
      if (this.requestHeadersToAdd == null) {
        this.requestHeadersToAdd = new LinkedList<>();
      }
      this.requestHeadersToAdd.add(requestHeadersToAdd);
      return this;
    }

    /**
     * A list of header names for headers that need to be removed from the request prior to
     * forwarding the request to the backendService.
     */
    public List<String> getRequestHeadersToRemoveList() {
      return requestHeadersToRemove;
    }

    /**
     * A list of header names for headers that need to be removed from the request prior to
     * forwarding the request to the backendService.
     */
    public Builder addAllRequestHeadersToRemove(List<String> requestHeadersToRemove) {
      if (this.requestHeadersToRemove == null) {
        this.requestHeadersToRemove = new LinkedList<>();
      }
      this.requestHeadersToRemove.addAll(requestHeadersToRemove);
      return this;
    }

    /**
     * A list of header names for headers that need to be removed from the request prior to
     * forwarding the request to the backendService.
     */
    public Builder addRequestHeadersToRemove(String requestHeadersToRemove) {
      if (this.requestHeadersToRemove == null) {
        this.requestHeadersToRemove = new LinkedList<>();
      }
      this.requestHeadersToRemove.add(requestHeadersToRemove);
      return this;
    }

    /** Headers to add the response prior to sending the response back to the client. */
    public List<HttpHeaderOption> getResponseHeadersToAddList() {
      return responseHeadersToAdd;
    }

    /** Headers to add the response prior to sending the response back to the client. */
    public Builder addAllResponseHeadersToAdd(List<HttpHeaderOption> responseHeadersToAdd) {
      if (this.responseHeadersToAdd == null) {
        this.responseHeadersToAdd = new LinkedList<>();
      }
      this.responseHeadersToAdd.addAll(responseHeadersToAdd);
      return this;
    }

    /** Headers to add the response prior to sending the response back to the client. */
    public Builder addResponseHeadersToAdd(HttpHeaderOption responseHeadersToAdd) {
      if (this.responseHeadersToAdd == null) {
        this.responseHeadersToAdd = new LinkedList<>();
      }
      this.responseHeadersToAdd.add(responseHeadersToAdd);
      return this;
    }

    /**
     * A list of header names for headers that need to be removed from the response prior to sending
     * the response back to the client.
     */
    public List<String> getResponseHeadersToRemoveList() {
      return responseHeadersToRemove;
    }

    /**
     * A list of header names for headers that need to be removed from the response prior to sending
     * the response back to the client.
     */
    public Builder addAllResponseHeadersToRemove(List<String> responseHeadersToRemove) {
      if (this.responseHeadersToRemove == null) {
        this.responseHeadersToRemove = new LinkedList<>();
      }
      this.responseHeadersToRemove.addAll(responseHeadersToRemove);
      return this;
    }

    /**
     * A list of header names for headers that need to be removed from the response prior to sending
     * the response back to the client.
     */
    public Builder addResponseHeadersToRemove(String responseHeadersToRemove) {
      if (this.responseHeadersToRemove == null) {
        this.responseHeadersToRemove = new LinkedList<>();
      }
      this.responseHeadersToRemove.add(responseHeadersToRemove);
      return this;
    }

    public HttpHeaderAction build() {

      return new HttpHeaderAction(
          requestHeadersToAdd,
          requestHeadersToRemove,
          responseHeadersToAdd,
          responseHeadersToRemove);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllRequestHeadersToAdd(this.requestHeadersToAdd);
      newBuilder.addAllRequestHeadersToRemove(this.requestHeadersToRemove);
      newBuilder.addAllResponseHeadersToAdd(this.responseHeadersToAdd);
      newBuilder.addAllResponseHeadersToRemove(this.responseHeadersToRemove);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpHeaderAction{"
        + "requestHeadersToAdd="
        + requestHeadersToAdd
        + ", "
        + "requestHeadersToRemove="
        + requestHeadersToRemove
        + ", "
        + "responseHeadersToAdd="
        + responseHeadersToAdd
        + ", "
        + "responseHeadersToRemove="
        + responseHeadersToRemove
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpHeaderAction) {
      HttpHeaderAction that = (HttpHeaderAction) o;
      return Objects.equals(this.requestHeadersToAdd, that.getRequestHeadersToAddList())
          && Objects.equals(this.requestHeadersToRemove, that.getRequestHeadersToRemoveList())
          && Objects.equals(this.responseHeadersToAdd, that.getResponseHeadersToAddList())
          && Objects.equals(this.responseHeadersToRemove, that.getResponseHeadersToRemoveList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        requestHeadersToAdd, requestHeadersToRemove, responseHeadersToAdd, responseHeadersToRemove);
  }
}
