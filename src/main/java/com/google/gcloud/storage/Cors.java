/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.storage;

import com.google.common.collect.ImmutableList;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public final class Cors {

  private final Integer maxAgeSeconds;
  private final ImmutableList<Method> methods;
  private final ImmutableList<Origin> origins;
  private final ImmutableList<String> responseHeaders;

  public enum Method {
    ANY, GET, HEAD, PUT, POST, DELETE
  }

  public static class Origin {

    private final URI uri;

    public static final Origin ANY = new Origin();

    private Origin() {
      uri = null;
    }

    public Origin(String scheme, String host, int port) {
      try {
        this.uri = new URI(scheme, null, host, port, null, null, null);
      } catch (URISyntaxException e) {
        throw new IllegalArgumentException(e);
      }

    }

    @Override
    public String toString() {
      return uri == null ? "*" : uri.toString();
    }
  }

  public static final class Builder {

    private Integer maxAgeSeconds;
    private ImmutableList<Method> methods;
    private ImmutableList<Origin> origins;
    private ImmutableList<String> responseHeaders;

    private Builder() {
    }

    public Builder maxAgeSeconds(Integer maxAgeSeconds) {
      this.maxAgeSeconds = maxAgeSeconds;
      return this;
    }

    public Builder methods(List<Method> methods) {
      this.methods = ImmutableList.copyOf(methods);
      return this;
    }

    public Builder methods(Method... methods) {
      this.methods = ImmutableList.copyOf(methods);
      return this;
    }

    public Builder origins(List<Origin> origins) {
      this.origins = ImmutableList.copyOf(origins);
      return this;
    }

    public Builder origins(Origin... origins) {
      this.origins = ImmutableList.copyOf(origins);
      return this;
    }

    public Builder responseHeaders(List<String> headers) {
      this.responseHeaders = ImmutableList.copyOf(headers);
      return this;
    }

    public Builder responseHeaders(String... responseHeaders) {
      this.responseHeaders = ImmutableList.copyOf(responseHeaders);
      return this;
    }

    public Cors build() {
      return new Cors(this);
    }
  }

  private Cors(Builder builder) {
    this.maxAgeSeconds = builder.maxAgeSeconds;
    this.methods = builder.methods;
    this.origins = builder.origins;
    this.responseHeaders = builder.responseHeaders;
  }

  public Integer maxAgeSeconds() {
    return maxAgeSeconds;
  }

  public List<Method> methods() {
    return methods;
  }

  public List<Origin> origins() {
    return origins;
  }

  public List<String> responseHeaders() {
    return responseHeaders;
  }

  public Builder toBuilder() {
    return builder()
        .maxAgeSeconds(maxAgeSeconds)
        .methods(methods)
        .origins(origins)
        .responseHeaders(responseHeaders);
  }

  public static Builder builder() {
    return new Builder();
  }
}
