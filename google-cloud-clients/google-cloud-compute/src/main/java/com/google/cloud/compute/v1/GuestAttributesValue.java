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
/** Array of guest attribute namespace/key/value tuples. */
public final class GuestAttributesValue implements ApiMessage {
  private final List<GuestAttributesEntry> items;

  private GuestAttributesValue() {
    this.items = null;
  }

  private GuestAttributesValue(List<GuestAttributesEntry> items) {
    this.items = items;
  }

  @Override
  public Object getFieldValue(String fieldName) {
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  public List<GuestAttributesEntry> getItemsList() {
    return items;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(GuestAttributesValue prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static GuestAttributesValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final GuestAttributesValue DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new GuestAttributesValue();
  }

  public static class Builder {
    private List<GuestAttributesEntry> items;

    Builder() {}

    public Builder mergeFrom(GuestAttributesValue other) {
      if (other == GuestAttributesValue.getDefaultInstance()) return this;
      if (other.getItemsList() != null) {
        this.items = other.items;
      }
      return this;
    }

    Builder(GuestAttributesValue source) {
      this.items = source.items;
    }

    public List<GuestAttributesEntry> getItemsList() {
      return items;
    }

    public Builder addAllItems(List<GuestAttributesEntry> items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.addAll(items);
      return this;
    }

    public Builder addItems(GuestAttributesEntry items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.add(items);
      return this;
    }

    public GuestAttributesValue build() {
      return new GuestAttributesValue(items);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllItems(this.items);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "GuestAttributesValue{" + "items=" + items + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GuestAttributesValue) {
      GuestAttributesValue that = (GuestAttributesValue) o;
      return Objects.equals(this.items, that.getItemsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }
}
