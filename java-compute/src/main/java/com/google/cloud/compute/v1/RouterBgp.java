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
    if ("advertiseMode".equals(fieldName)) {
      return advertiseMode;
    }
    if ("advertisedGroups".equals(fieldName)) {
      return advertisedGroups;
    }
    if ("advertisedIpRanges".equals(fieldName)) {
      return advertisedIpRanges;
    }
    if ("asn".equals(fieldName)) {
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
   * User-specified flag to indicate which mode to use for advertisement. The options are DEFAULT or
   * CUSTOM.
   */
  public String getAdvertiseMode() {
    return advertiseMode;
  }

  /**
   * User-specified list of prefix groups to advertise in custom mode. This field can only be
   * populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These
   * groups will be advertised in addition to any specified prefixes. Leave this field blank to
   * advertise no custom groups.
   */
  public List<String> getAdvertisedGroupsList() {
    return advertisedGroups;
  }

  /**
   * User-specified list of individual IP ranges to advertise in custom mode. This field can only be
   * populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These IP
   * ranges will be advertised in addition to any specified groups. Leave this field blank to
   * advertise no custom IP ranges.
   */
  public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
    return advertisedIpRanges;
  }

  /**
   * Local BGP Autonomous System Number (ASN). Must be an RFC6996 private ASN, either 16-bit or
   * 32-bit. The value will be fixed for this router resource. All VPN tunnels that link to this
   * router will have the same local ASN.
   */
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

    /**
     * User-specified flag to indicate which mode to use for advertisement. The options are DEFAULT
     * or CUSTOM.
     */
    public String getAdvertiseMode() {
      return advertiseMode;
    }

    /**
     * User-specified flag to indicate which mode to use for advertisement. The options are DEFAULT
     * or CUSTOM.
     */
    public Builder setAdvertiseMode(String advertiseMode) {
      this.advertiseMode = advertiseMode;
      return this;
    }

    /**
     * User-specified list of prefix groups to advertise in custom mode. This field can only be
     * populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These
     * groups will be advertised in addition to any specified prefixes. Leave this field blank to
     * advertise no custom groups.
     */
    public List<String> getAdvertisedGroupsList() {
      return advertisedGroups;
    }

    /**
     * User-specified list of prefix groups to advertise in custom mode. This field can only be
     * populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These
     * groups will be advertised in addition to any specified prefixes. Leave this field blank to
     * advertise no custom groups.
     */
    public Builder addAllAdvertisedGroups(List<String> advertisedGroups) {
      if (this.advertisedGroups == null) {
        this.advertisedGroups = new LinkedList<>();
      }
      this.advertisedGroups.addAll(advertisedGroups);
      return this;
    }

    /**
     * User-specified list of prefix groups to advertise in custom mode. This field can only be
     * populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These
     * groups will be advertised in addition to any specified prefixes. Leave this field blank to
     * advertise no custom groups.
     */
    public Builder addAdvertisedGroups(String advertisedGroups) {
      if (this.advertisedGroups == null) {
        this.advertisedGroups = new LinkedList<>();
      }
      this.advertisedGroups.add(advertisedGroups);
      return this;
    }

    /**
     * User-specified list of individual IP ranges to advertise in custom mode. This field can only
     * be populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These
     * IP ranges will be advertised in addition to any specified groups. Leave this field blank to
     * advertise no custom IP ranges.
     */
    public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
      return advertisedIpRanges;
    }

    /**
     * User-specified list of individual IP ranges to advertise in custom mode. This field can only
     * be populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These
     * IP ranges will be advertised in addition to any specified groups. Leave this field blank to
     * advertise no custom IP ranges.
     */
    public Builder addAllAdvertisedIpRanges(List<RouterAdvertisedIpRange> advertisedIpRanges) {
      if (this.advertisedIpRanges == null) {
        this.advertisedIpRanges = new LinkedList<>();
      }
      this.advertisedIpRanges.addAll(advertisedIpRanges);
      return this;
    }

    /**
     * User-specified list of individual IP ranges to advertise in custom mode. This field can only
     * be populated if advertise_mode is CUSTOM and is advertised to all peers of the router. These
     * IP ranges will be advertised in addition to any specified groups. Leave this field blank to
     * advertise no custom IP ranges.
     */
    public Builder addAdvertisedIpRanges(RouterAdvertisedIpRange advertisedIpRanges) {
      if (this.advertisedIpRanges == null) {
        this.advertisedIpRanges = new LinkedList<>();
      }
      this.advertisedIpRanges.add(advertisedIpRanges);
      return this;
    }

    /**
     * Local BGP Autonomous System Number (ASN). Must be an RFC6996 private ASN, either 16-bit or
     * 32-bit. The value will be fixed for this router resource. All VPN tunnels that link to this
     * router will have the same local ASN.
     */
    public Integer getAsn() {
      return asn;
    }

    /**
     * Local BGP Autonomous System Number (ASN). Must be an RFC6996 private ASN, either 16-bit or
     * 32-bit. The value will be fixed for this router resource. All VPN tunnels that link to this
     * router will have the same local ASN.
     */
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
