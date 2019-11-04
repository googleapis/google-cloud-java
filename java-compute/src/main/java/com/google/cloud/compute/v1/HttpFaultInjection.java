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
 * The specification for fault injection introduced into traffic to test the resiliency of clients
 * to backend service failure. As part of fault injection, when clients send requests to a backend
 * service, delays can be introduced by Loadbalancer on a percentage of requests before sending
 * those request to the backend service. Similarly requests from clients can be aborted by the
 * Loadbalancer for a percentage of requests.
 */
public final class HttpFaultInjection implements ApiMessage {
  private final HttpFaultAbort abort;
  private final HttpFaultDelay delay;

  private HttpFaultInjection() {
    this.abort = null;
    this.delay = null;
  }

  private HttpFaultInjection(HttpFaultAbort abort, HttpFaultDelay delay) {
    this.abort = abort;
    this.delay = delay;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("abort".equals(fieldName)) {
      return abort;
    }
    if ("delay".equals(fieldName)) {
      return delay;
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

  /** The specification for how client requests are aborted as part of fault injection. */
  public HttpFaultAbort getAbort() {
    return abort;
  }

  /**
   * The specification for how client requests are delayed as part of fault injection, before being
   * sent to a backend service.
   */
  public HttpFaultDelay getDelay() {
    return delay;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpFaultInjection prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpFaultInjection getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpFaultInjection DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpFaultInjection();
  }

  public static class Builder {
    private HttpFaultAbort abort;
    private HttpFaultDelay delay;

    Builder() {}

    public Builder mergeFrom(HttpFaultInjection other) {
      if (other == HttpFaultInjection.getDefaultInstance()) return this;
      if (other.getAbort() != null) {
        this.abort = other.abort;
      }
      if (other.getDelay() != null) {
        this.delay = other.delay;
      }
      return this;
    }

    Builder(HttpFaultInjection source) {
      this.abort = source.abort;
      this.delay = source.delay;
    }

    /** The specification for how client requests are aborted as part of fault injection. */
    public HttpFaultAbort getAbort() {
      return abort;
    }

    /** The specification for how client requests are aborted as part of fault injection. */
    public Builder setAbort(HttpFaultAbort abort) {
      this.abort = abort;
      return this;
    }

    /**
     * The specification for how client requests are delayed as part of fault injection, before
     * being sent to a backend service.
     */
    public HttpFaultDelay getDelay() {
      return delay;
    }

    /**
     * The specification for how client requests are delayed as part of fault injection, before
     * being sent to a backend service.
     */
    public Builder setDelay(HttpFaultDelay delay) {
      this.delay = delay;
      return this;
    }

    public HttpFaultInjection build() {

      return new HttpFaultInjection(abort, delay);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAbort(this.abort);
      newBuilder.setDelay(this.delay);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpFaultInjection{" + "abort=" + abort + ", " + "delay=" + delay + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpFaultInjection) {
      HttpFaultInjection that = (HttpFaultInjection) o;
      return Objects.equals(this.abort, that.getAbort())
          && Objects.equals(this.delay, that.getDelay());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(abort, delay);
  }
}
