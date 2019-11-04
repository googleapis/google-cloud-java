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
/** The spec for modifying the path before sending the request to the matched backend service. */
public final class UrlRewrite implements ApiMessage {
  private final String hostRewrite;
  private final String pathPrefixRewrite;

  private UrlRewrite() {
    this.hostRewrite = null;
    this.pathPrefixRewrite = null;
  }

  private UrlRewrite(String hostRewrite, String pathPrefixRewrite) {
    this.hostRewrite = hostRewrite;
    this.pathPrefixRewrite = pathPrefixRewrite;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("hostRewrite".equals(fieldName)) {
      return hostRewrite;
    }
    if ("pathPrefixRewrite".equals(fieldName)) {
      return pathPrefixRewrite;
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
   * Prior to forwarding the request to the selected service, the request's host header is replaced
   * with contents of hostRewrite. The value must be between 1 and 255 characters.
   */
  public String getHostRewrite() {
    return hostRewrite;
  }

  /**
   * Prior to forwarding the request to the selected backend service, the matching portion of the
   * request's path is replaced by pathPrefixRewrite. The value must be between 1 and 1024
   * characters.
   */
  public String getPathPrefixRewrite() {
    return pathPrefixRewrite;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlRewrite prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlRewrite getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlRewrite DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlRewrite();
  }

  public static class Builder {
    private String hostRewrite;
    private String pathPrefixRewrite;

    Builder() {}

    public Builder mergeFrom(UrlRewrite other) {
      if (other == UrlRewrite.getDefaultInstance()) return this;
      if (other.getHostRewrite() != null) {
        this.hostRewrite = other.hostRewrite;
      }
      if (other.getPathPrefixRewrite() != null) {
        this.pathPrefixRewrite = other.pathPrefixRewrite;
      }
      return this;
    }

    Builder(UrlRewrite source) {
      this.hostRewrite = source.hostRewrite;
      this.pathPrefixRewrite = source.pathPrefixRewrite;
    }

    /**
     * Prior to forwarding the request to the selected service, the request's host header is
     * replaced with contents of hostRewrite. The value must be between 1 and 255 characters.
     */
    public String getHostRewrite() {
      return hostRewrite;
    }

    /**
     * Prior to forwarding the request to the selected service, the request's host header is
     * replaced with contents of hostRewrite. The value must be between 1 and 255 characters.
     */
    public Builder setHostRewrite(String hostRewrite) {
      this.hostRewrite = hostRewrite;
      return this;
    }

    /**
     * Prior to forwarding the request to the selected backend service, the matching portion of the
     * request's path is replaced by pathPrefixRewrite. The value must be between 1 and 1024
     * characters.
     */
    public String getPathPrefixRewrite() {
      return pathPrefixRewrite;
    }

    /**
     * Prior to forwarding the request to the selected backend service, the matching portion of the
     * request's path is replaced by pathPrefixRewrite. The value must be between 1 and 1024
     * characters.
     */
    public Builder setPathPrefixRewrite(String pathPrefixRewrite) {
      this.pathPrefixRewrite = pathPrefixRewrite;
      return this;
    }

    public UrlRewrite build() {

      return new UrlRewrite(hostRewrite, pathPrefixRewrite);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHostRewrite(this.hostRewrite);
      newBuilder.setPathPrefixRewrite(this.pathPrefixRewrite);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlRewrite{"
        + "hostRewrite="
        + hostRewrite
        + ", "
        + "pathPrefixRewrite="
        + pathPrefixRewrite
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlRewrite) {
      UrlRewrite that = (UrlRewrite) o;
      return Objects.equals(this.hostRewrite, that.getHostRewrite())
          && Objects.equals(this.pathPrefixRewrite, that.getPathPrefixRewrite());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostRewrite, pathPrefixRewrite);
  }
}
