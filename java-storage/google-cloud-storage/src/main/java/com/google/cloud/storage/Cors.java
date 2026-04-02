/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

/**
 * Cross-Origin Resource Sharing (CORS) configuration for a bucket.
 *
 * @see <a href="https://cloud.google.com/storage/docs/cross-origin">Cross-Origin Resource Sharing
 *     (CORS)</a>
 */
public final class Cors implements Serializable {

  private static final long serialVersionUID = 3811576113627241235L;

  private final Integer maxAgeSeconds;
  private final ImmutableList<HttpMethod> methods;
  private final ImmutableList<Origin> origins;
  private final ImmutableList<String> responseHeaders;

  /** Class for a CORS origin. */
  public static final class Origin implements Serializable {

    private static final long serialVersionUID = -3240120183350397818L;
    private static final String ANY_URI = "*";
    private final String value;

    private static final Origin ANY = new Origin(ANY_URI);

    private Origin(String value) {
      this.value = checkNotNull(value);
    }

    /** Returns an {@code Origin} object for all possible origins. */
    public static Origin any() {
      return ANY;
    }

    /** Returns an {@code Origin} object for the given scheme, host and port. */
    public static Origin of(String scheme, String host, int port) {
      try {
        return of(new URI(scheme, null, host, port, null, null, null).toString());
      } catch (URISyntaxException e) {
        throw new IllegalArgumentException(e);
      }
    }

    /** Creates an {@code Origin} object for the provided value. */
    public static Origin of(String value) {
      if (ANY_URI.equals(value)) {
        return any();
      }
      return new Origin(value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Origin)) {
        return false;
      }
      Origin origin = (Origin) obj;
      return Objects.equals(value, origin.value);
    }

    @Override
    public String toString() {
      return getValue();
    }

    public String getValue() {
      return value;
    }
  }

  /** CORS configuration builder. */
  public static final class Builder {

    private Integer maxAgeSeconds;
    private ImmutableList<HttpMethod> methods;
    private ImmutableList<Origin> origins;
    private ImmutableList<String> responseHeaders;

    private Builder() {}

    /**
     * Sets the max time in seconds in which a client can issue requests before sending a new
     * preflight request.
     */
    public Builder setMaxAgeSeconds(Integer maxAgeSeconds) {
      this.maxAgeSeconds = maxAgeSeconds;
      return this;
    }

    /** Sets the HTTP methods supported by this CORS configuration. */
    public Builder setMethods(Iterable<HttpMethod> methods) {
      this.methods = methods != null ? ImmutableList.copyOf(methods) : null;
      return this;
    }

    /** Sets the origins for this CORS configuration. */
    public Builder setOrigins(Iterable<Origin> origins) {
      this.origins = origins != null ? ImmutableList.copyOf(origins) : null;
      return this;
    }

    /** Sets the response headers supported by this CORS configuration. */
    public Builder setResponseHeaders(Iterable<String> headers) {
      this.responseHeaders = headers != null ? ImmutableList.copyOf(headers) : null;
      return this;
    }

    /** Creates a CORS configuration. */
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

  /**
   * Returns the max time in seconds in which a client can issue requests before sending a new
   * preflight request.
   */
  public Integer getMaxAgeSeconds() {
    return maxAgeSeconds;
  }

  /** Returns the HTTP methods supported by this CORS configuration. */
  public List<HttpMethod> getMethods() {
    return methods;
  }

  /** Returns the origins in this CORS configuration. */
  public List<Origin> getOrigins() {
    return origins;
  }

  /** Returns the response headers supported by this CORS configuration. */
  public List<String> getResponseHeaders() {
    return responseHeaders;
  }

  /** Returns a builder for this CORS configuration. */
  public Builder toBuilder() {
    return newBuilder()
        .setMaxAgeSeconds(maxAgeSeconds)
        .setMethods(methods)
        .setOrigins(origins)
        .setResponseHeaders(responseHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxAgeSeconds, methods, origins, responseHeaders);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Cors)) {
      return false;
    }
    Cors other = (Cors) obj;
    return Objects.equals(maxAgeSeconds, other.maxAgeSeconds)
        && Objects.equals(methods, other.methods)
        && Objects.equals(origins, other.origins)
        && Objects.equals(responseHeaders, other.responseHeaders);
  }

  /** Returns a CORS configuration builder. */
  public static Builder newBuilder() {
    return new Builder();
  }
}
