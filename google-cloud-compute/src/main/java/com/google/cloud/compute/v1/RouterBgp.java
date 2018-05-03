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
public final class RouterBgp implements ApiMessage {
  private final String advertiseMode;
  private final List<String> advertisedGroups;
  private final List<RouterAdvertisedIpRange> advertisedIpRanges;
  private final Integer asn;

  private RouterBgp() {
    this.advertiseMode = null;
    this.advertisedGroups = null;
    this.advertisedIpRanges = null;
    this.asn = null;
  }

  private RouterBgp(
      String advertiseMode,
      List<String> advertisedGroups,
      List<RouterAdvertisedIpRange> advertisedIpRanges,
      Integer asn) {
    this.advertiseMode = advertiseMode;
    this.advertisedGroups = advertisedGroups;
    this.advertisedIpRanges = advertisedIpRanges;
    this.asn = asn;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("advertiseMode")) {
      return advertiseMode;
    }
    if (fieldName.equals("advertisedGroups")) {
      return advertisedGroups;
    }
    if (fieldName.equals("advertisedIpRanges")) {
      return advertisedIpRanges;
    }
    if (fieldName.equals("asn")) {
      return asn;
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

  public String getAdvertiseMode() {
    return advertiseMode;
  }

  public List<String> getAdvertisedGroupsList() {
    return advertisedGroups;
  }

  public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
    return advertisedIpRanges;
  }

  public Integer getAsn() {
    return asn;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterBgp prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterBgp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterBgp DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterBgp();
  }

  public static class Builder {
    private String advertiseMode;
    private List<String> advertisedGroups;
    private List<RouterAdvertisedIpRange> advertisedIpRanges;
    private Integer asn;

    Builder() {}

    public Builder mergeFrom(RouterBgp other) {
      if (other == RouterBgp.getDefaultInstance()) return this;
      if (other.getAdvertiseMode() != null) {
        this.advertiseMode = other.advertiseMode;
      }
      if (other.getAdvertisedGroupsList() != null) {
        this.advertisedGroups = other.advertisedGroups;
      }
      if (other.getAdvertisedIpRangesList() != null) {
        this.advertisedIpRanges = other.advertisedIpRanges;
      }
      if (other.getAsn() != null) {
        this.asn = other.asn;
      }
      return this;
    }

    Builder(RouterBgp source) {
      this.advertiseMode = source.advertiseMode;
      this.advertisedGroups = source.advertisedGroups;
      this.advertisedIpRanges = source.advertisedIpRanges;
      this.asn = source.asn;
    }

    public String getAdvertiseMode() {
      return advertiseMode;
    }

    public Builder setAdvertiseMode(String advertiseMode) {
      this.advertiseMode = advertiseMode;
      return this;
    }

    public List<String> getAdvertisedGroupsList() {
      return advertisedGroups;
    }

    public Builder addAllAdvertisedGroups(List<String> advertisedGroups) {
      if (this.advertisedGroups == null) {
        this.advertisedGroups = new ArrayList<>(advertisedGroups.size());
      }
      this.advertisedGroups.addAll(advertisedGroups);
      return this;
    }

    public Builder addAdvertisedGroups(String advertisedGroups) {
      this.advertisedGroups.add(advertisedGroups);
      return this;
    }

    public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
      return advertisedIpRanges;
    }

    public Builder addAllAdvertisedIpRanges(List<RouterAdvertisedIpRange> advertisedIpRanges) {
      if (this.advertisedIpRanges == null) {
        this.advertisedIpRanges = new ArrayList<>(advertisedIpRanges.size());
      }
      this.advertisedIpRanges.addAll(advertisedIpRanges);
      return this;
    }

    public Builder addAdvertisedIpRanges(RouterAdvertisedIpRange advertisedIpRanges) {
      this.advertisedIpRanges.add(advertisedIpRanges);
      return this;
    }

    public Integer getAsn() {
      return asn;
    }

    public Builder setAsn(Integer asn) {
      this.asn = asn;
      return this;
    }

    public RouterBgp build() {

      return new RouterBgp(advertiseMode, advertisedGroups, advertisedIpRanges, asn);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAdvertiseMode(this.advertiseMode);
      newBuilder.addAllAdvertisedGroups(this.advertisedGroups);
      newBuilder.addAllAdvertisedIpRanges(this.advertisedIpRanges);
      newBuilder.setAsn(this.asn);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterBgp{"
        + "advertiseMode="
        + advertiseMode
        + ", "
        + "advertisedGroups="
        + advertisedGroups
        + ", "
        + "advertisedIpRanges="
        + advertisedIpRanges
        + ", "
        + "asn="
        + asn
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterBgp) {
      RouterBgp that = (RouterBgp) o;
      return Objects.equals(this.advertiseMode, that.getAdvertiseMode())
          && Objects.equals(this.advertisedGroups, that.getAdvertisedGroupsList())
          && Objects.equals(this.advertisedIpRanges, that.getAdvertisedIpRangesList())
          && Objects.equals(this.asn, that.getAsn());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(advertiseMode, advertisedGroups, advertisedIpRanges, asn);
  }
}
