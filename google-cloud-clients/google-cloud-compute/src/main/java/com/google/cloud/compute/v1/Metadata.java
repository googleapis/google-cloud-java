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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class Metadata implements ApiMessage {
  private final String fingerprint;
  private final List<Items> items;
  private final String kind;

  private Metadata() {
    this.fingerprint = null;
    this.items = null;
    this.kind = null;
  }

  private Metadata(String fingerprint, List<Items> items, String kind) {
    this.fingerprint = fingerprint;
    this.items = items;
    this.kind = kind;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("fingerprint")) {
      return fingerprint;
    }
    if (fieldName.equals("items")) {
      return items;
    }
    if (fieldName.equals("kind")) {
      return kind;
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

  public List<Items> getItemsList() {
    return items;
  }

  public String getKind() {
    return kind;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Metadata prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Metadata getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Metadata DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Metadata();
  }

  public static class Builder {
    private String fingerprint;
    private List<Items> items;
    private String kind;

    Builder() {}

    public Builder mergeFrom(Metadata other) {
      if (other == Metadata.getDefaultInstance()) return this;
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getItemsList() != null) {
        this.items = other.items;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      return this;
    }

    Builder(Metadata source) {
      this.fingerprint = source.fingerprint;
      this.items = source.items;
      this.kind = source.kind;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public List<Items> getItemsList() {
      return items;
    }

    public Builder addAllItems(List<Items> items) {
      if (this.items == null) {
        this.items = new ArrayList<>(items.size());
      }
      this.items.addAll(items);
      return this;
    }

    public Builder addItems(Items items) {
      this.items.add(items);
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public Metadata build() {

      return new Metadata(fingerprint, items, kind);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.addAllItems(this.items);
      newBuilder.setKind(this.kind);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Metadata{"
        + "fingerprint="
        + fingerprint
        + ", "
        + "items="
        + items
        + ", "
        + "kind="
        + kind
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Metadata) {
      Metadata that = (Metadata) o;
      return Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.items, that.getItemsList())
          && Objects.equals(this.kind, that.getKind());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fingerprint, items, kind);
  }
}
