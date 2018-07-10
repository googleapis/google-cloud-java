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
public final class BackendBucketCdnPolicy implements ApiMessage {
  private final String signedUrlCacheMaxAgeSec;
  private final List<String> signedUrlKeyNames;

  private BackendBucketCdnPolicy() {
    this.signedUrlCacheMaxAgeSec = null;
    this.signedUrlKeyNames = null;
  }

  private BackendBucketCdnPolicy(String signedUrlCacheMaxAgeSec, List<String> signedUrlKeyNames) {
    this.signedUrlCacheMaxAgeSec = signedUrlCacheMaxAgeSec;
    this.signedUrlKeyNames = signedUrlKeyNames;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("signedUrlCacheMaxAgeSec")) {
      return signedUrlCacheMaxAgeSec;
    }
    if (fieldName.equals("signedUrlKeyNames")) {
      return signedUrlKeyNames;
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

  public String getSignedUrlCacheMaxAgeSec() {
    return signedUrlCacheMaxAgeSec;
  }

  public List<String> getSignedUrlKeyNamesList() {
    return signedUrlKeyNames;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendBucketCdnPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendBucketCdnPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendBucketCdnPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendBucketCdnPolicy();
  }

  public static class Builder {
    private String signedUrlCacheMaxAgeSec;
    private List<String> signedUrlKeyNames;

    Builder() {}

    public Builder mergeFrom(BackendBucketCdnPolicy other) {
      if (other == BackendBucketCdnPolicy.getDefaultInstance()) return this;
      if (other.getSignedUrlCacheMaxAgeSec() != null) {
        this.signedUrlCacheMaxAgeSec = other.signedUrlCacheMaxAgeSec;
      }
      if (other.getSignedUrlKeyNamesList() != null) {
        this.signedUrlKeyNames = other.signedUrlKeyNames;
      }
      return this;
    }

    Builder(BackendBucketCdnPolicy source) {
      this.signedUrlCacheMaxAgeSec = source.signedUrlCacheMaxAgeSec;
      this.signedUrlKeyNames = source.signedUrlKeyNames;
    }

    public String getSignedUrlCacheMaxAgeSec() {
      return signedUrlCacheMaxAgeSec;
    }

    public Builder setSignedUrlCacheMaxAgeSec(String signedUrlCacheMaxAgeSec) {
      this.signedUrlCacheMaxAgeSec = signedUrlCacheMaxAgeSec;
      return this;
    }

    public List<String> getSignedUrlKeyNamesList() {
      return signedUrlKeyNames;
    }

    public Builder addAllSignedUrlKeyNames(List<String> signedUrlKeyNames) {
      if (this.signedUrlKeyNames == null) {
        this.signedUrlKeyNames = new LinkedList<>();
      }
      this.signedUrlKeyNames.addAll(signedUrlKeyNames);
      return this;
    }

    public Builder addSignedUrlKeyNames(String signedUrlKeyNames) {
      if (this.signedUrlKeyNames == null) {
        this.signedUrlKeyNames = new LinkedList<>();
      }
      this.signedUrlKeyNames.add(signedUrlKeyNames);
      return this;
    }

    public BackendBucketCdnPolicy build() {

      return new BackendBucketCdnPolicy(signedUrlCacheMaxAgeSec, signedUrlKeyNames);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setSignedUrlCacheMaxAgeSec(this.signedUrlCacheMaxAgeSec);
      newBuilder.addAllSignedUrlKeyNames(this.signedUrlKeyNames);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendBucketCdnPolicy{"
        + "signedUrlCacheMaxAgeSec="
        + signedUrlCacheMaxAgeSec
        + ", "
        + "signedUrlKeyNames="
        + signedUrlKeyNames
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BackendBucketCdnPolicy) {
      BackendBucketCdnPolicy that = (BackendBucketCdnPolicy) o;
      return Objects.equals(this.signedUrlCacheMaxAgeSec, that.getSignedUrlCacheMaxAgeSec())
          && Objects.equals(this.signedUrlKeyNames, that.getSignedUrlKeyNamesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(signedUrlCacheMaxAgeSec, signedUrlKeyNames);
  }
}
