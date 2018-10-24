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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class SignedUrlKey implements ApiMessage {
  private final String keyName;
  private final String keyValue;

  private SignedUrlKey() {
    this.keyName = null;
    this.keyValue = null;
  }

  private SignedUrlKey(String keyName, String keyValue) {
    this.keyName = keyName;
    this.keyValue = keyValue;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("keyName")) {
      return keyName;
    }
    if (fieldName.equals("keyValue")) {
      return keyValue;
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

  public String getKeyName() {
    return keyName;
  }

  public String getKeyValue() {
    return keyValue;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SignedUrlKey prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SignedUrlKey getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SignedUrlKey DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SignedUrlKey();
  }

  public static class Builder {
    private String keyName;
    private String keyValue;

    Builder() {}

    public Builder mergeFrom(SignedUrlKey other) {
      if (other == SignedUrlKey.getDefaultInstance()) return this;
      if (other.getKeyName() != null) {
        this.keyName = other.keyName;
      }
      if (other.getKeyValue() != null) {
        this.keyValue = other.keyValue;
      }
      return this;
    }

    Builder(SignedUrlKey source) {
      this.keyName = source.keyName;
      this.keyValue = source.keyValue;
    }

    public String getKeyName() {
      return keyName;
    }

    public Builder setKeyName(String keyName) {
      this.keyName = keyName;
      return this;
    }

    public String getKeyValue() {
      return keyValue;
    }

    public Builder setKeyValue(String keyValue) {
      this.keyValue = keyValue;
      return this;
    }

    public SignedUrlKey build() {

      return new SignedUrlKey(keyName, keyValue);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKeyName(this.keyName);
      newBuilder.setKeyValue(this.keyValue);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SignedUrlKey{" + "keyName=" + keyName + ", " + "keyValue=" + keyValue + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SignedUrlKey) {
      SignedUrlKey that = (SignedUrlKey) o;
      return Objects.equals(this.keyName, that.getKeyName())
          && Objects.equals(this.keyValue, that.getKeyValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyName, keyValue);
  }
}
