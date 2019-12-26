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
public final class ExchangedPeeringRoute implements ApiMessage {
  private final String destRange;
  private final Boolean imported;
  private final String nextHopRegion;
  private final Integer priority;
  private final String type;

  private ExchangedPeeringRoute() {
    this.destRange = null;
    this.imported = null;
    this.nextHopRegion = null;
    this.priority = null;
    this.type = null;
  }

  private ExchangedPeeringRoute(
      String destRange, Boolean imported, String nextHopRegion, Integer priority, String type) {
    this.destRange = destRange;
    this.imported = imported;
    this.nextHopRegion = nextHopRegion;
    this.priority = priority;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("destRange".equals(fieldName)) {
      return destRange;
    }
    if ("imported".equals(fieldName)) {
      return imported;
    }
    if ("nextHopRegion".equals(fieldName)) {
      return nextHopRegion;
    }
    if ("priority".equals(fieldName)) {
      return priority;
    }
    if ("type".equals(fieldName)) {
      return type;
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

  /** The destination range of the route. */
  public String getDestRange() {
    return destRange;
  }

  /**
   * True if the peering route has been imported from a peer. The actual import happens if the field
   * networkPeering.importCustomRoutes is true for this network, and
   * networkPeering.exportCustomRoutes is true for the peer network, and the import does not result
   * in a route conflict.
   */
  public Boolean getImported() {
    return imported;
  }

  /** The region of peering route next hop, only applies to dynamic routes. */
  public String getNextHopRegion() {
    return nextHopRegion;
  }

  /** The priority of the peering route. */
  public Integer getPriority() {
    return priority;
  }

  /** The type of the peering route. */
  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ExchangedPeeringRoute prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ExchangedPeeringRoute getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ExchangedPeeringRoute DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ExchangedPeeringRoute();
  }

  public static class Builder {
    private String destRange;
    private Boolean imported;
    private String nextHopRegion;
    private Integer priority;
    private String type;

    Builder() {}

    public Builder mergeFrom(ExchangedPeeringRoute other) {
      if (other == ExchangedPeeringRoute.getDefaultInstance()) return this;
      if (other.getDestRange() != null) {
        this.destRange = other.destRange;
      }
      if (other.getImported() != null) {
        this.imported = other.imported;
      }
      if (other.getNextHopRegion() != null) {
        this.nextHopRegion = other.nextHopRegion;
      }
      if (other.getPriority() != null) {
        this.priority = other.priority;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(ExchangedPeeringRoute source) {
      this.destRange = source.destRange;
      this.imported = source.imported;
      this.nextHopRegion = source.nextHopRegion;
      this.priority = source.priority;
      this.type = source.type;
    }

    /** The destination range of the route. */
    public String getDestRange() {
      return destRange;
    }

    /** The destination range of the route. */
    public Builder setDestRange(String destRange) {
      this.destRange = destRange;
      return this;
    }

    /**
     * True if the peering route has been imported from a peer. The actual import happens if the
     * field networkPeering.importCustomRoutes is true for this network, and
     * networkPeering.exportCustomRoutes is true for the peer network, and the import does not
     * result in a route conflict.
     */
    public Boolean getImported() {
      return imported;
    }

    /**
     * True if the peering route has been imported from a peer. The actual import happens if the
     * field networkPeering.importCustomRoutes is true for this network, and
     * networkPeering.exportCustomRoutes is true for the peer network, and the import does not
     * result in a route conflict.
     */
    public Builder setImported(Boolean imported) {
      this.imported = imported;
      return this;
    }

    /** The region of peering route next hop, only applies to dynamic routes. */
    public String getNextHopRegion() {
      return nextHopRegion;
    }

    /** The region of peering route next hop, only applies to dynamic routes. */
    public Builder setNextHopRegion(String nextHopRegion) {
      this.nextHopRegion = nextHopRegion;
      return this;
    }

    /** The priority of the peering route. */
    public Integer getPriority() {
      return priority;
    }

    /** The priority of the peering route. */
    public Builder setPriority(Integer priority) {
      this.priority = priority;
      return this;
    }

    /** The type of the peering route. */
    public String getType() {
      return type;
    }

    /** The type of the peering route. */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public ExchangedPeeringRoute build() {

      return new ExchangedPeeringRoute(destRange, imported, nextHopRegion, priority, type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDestRange(this.destRange);
      newBuilder.setImported(this.imported);
      newBuilder.setNextHopRegion(this.nextHopRegion);
      newBuilder.setPriority(this.priority);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ExchangedPeeringRoute{"
        + "destRange="
        + destRange
        + ", "
        + "imported="
        + imported
        + ", "
        + "nextHopRegion="
        + nextHopRegion
        + ", "
        + "priority="
        + priority
        + ", "
        + "type="
        + type
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ExchangedPeeringRoute) {
      ExchangedPeeringRoute that = (ExchangedPeeringRoute) o;
      return Objects.equals(this.destRange, that.getDestRange())
          && Objects.equals(this.imported, that.getImported())
          && Objects.equals(this.nextHopRegion, that.getNextHopRegion())
          && Objects.equals(this.priority, that.getPriority())
          && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(destRange, imported, nextHopRegion, priority, type);
  }
}
