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
public final class Tags implements ApiMessage {
  private final String fingerprint;
  private final List<String> items;

  private Tags() {
    this.fingerprint = null;
    this.items = null;
  }

  private Tags(String fingerprint, List<String> items) {
    this.fingerprint = fingerprint;
    this.items = items;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("items".equals(fieldName)) {
      return items;
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

  public String getFingerprint() {
    return fingerprint;
  }

  public List<String> getItemsList() {
    return items;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Tags prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Tags getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Tags DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Tags();
  }

  public static class Builder {
    private String fingerprint;
    private List<String> items;

    Builder() {}

    public Builder mergeFrom(Tags other) {
      if (other == Tags.getDefaultInstance()) return this;
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getItemsList() != null) {
        this.items = other.items;
      }
      return this;
    }

    Builder(Tags source) {
      this.fingerprint = source.fingerprint;
      this.items = source.items;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public List<String> getItemsList() {
      return items;
    }

    public Builder addAllItems(List<String> items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.addAll(items);
      return this;
    }

    public Builder addItems(String items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.add(items);
      return this;
    }

    public Tags build() {

      return new Tags(fingerprint, items);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.addAllItems(this.items);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Tags{" + "fingerprint=" + fingerprint + ", " + "items=" + items + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Tags) {
      Tags that = (Tags) o;
      return Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.items, that.getItemsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fingerprint, items);
  }
}
