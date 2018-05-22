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
public final class RouterAdvertisedIpRange implements ApiMessage {
  private final String description;
  private final String range;

  private RouterAdvertisedIpRange() {
    this.description = null;
    this.range = null;
  }

  private RouterAdvertisedIpRange(String description, String range) {
    this.description = description;
    this.range = range;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("range")) {
      return range;
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

  public String getDescription() {
    return description;
  }

  public String getRange() {
    return range;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterAdvertisedIpRange prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterAdvertisedIpRange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterAdvertisedIpRange DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterAdvertisedIpRange();
  }

  public static class Builder {
    private String description;
    private String range;

    Builder() {}

    public Builder mergeFrom(RouterAdvertisedIpRange other) {
      if (other == RouterAdvertisedIpRange.getDefaultInstance()) return this;
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getRange() != null) {
        this.range = other.range;
      }
      return this;
    }

    Builder(RouterAdvertisedIpRange source) {
      this.description = source.description;
      this.range = source.range;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getRange() {
      return range;
    }

    public Builder setRange(String range) {
      this.range = range;
      return this;
    }

    public RouterAdvertisedIpRange build() {

      return new RouterAdvertisedIpRange(description, range);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDescription(this.description);
      newBuilder.setRange(this.range);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterAdvertisedIpRange{"
        + "description="
        + description
        + ", "
        + "range="
        + range
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterAdvertisedIpRange) {
      RouterAdvertisedIpRange that = (RouterAdvertisedIpRange) o;
      return Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.range, that.getRange());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, range);
  }
}
