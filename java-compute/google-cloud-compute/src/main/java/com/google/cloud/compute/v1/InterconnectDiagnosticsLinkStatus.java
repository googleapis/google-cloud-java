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
public final class InterconnectDiagnosticsLinkStatus implements ApiMessage {
  private final List<InterconnectDiagnosticsARPEntry> arpCaches;
  private final String circuitId;
  private final String googleDemarc;
  private final InterconnectDiagnosticsLinkLACPStatus lacpStatus;
  private final InterconnectDiagnosticsLinkOpticalPower receivingOpticalPower;
  private final InterconnectDiagnosticsLinkOpticalPower transmittingOpticalPower;

  private InterconnectDiagnosticsLinkStatus() {
    this.arpCaches = null;
    this.circuitId = null;
    this.googleDemarc = null;
    this.lacpStatus = null;
    this.receivingOpticalPower = null;
    this.transmittingOpticalPower = null;
  }

  private InterconnectDiagnosticsLinkStatus(
      List<InterconnectDiagnosticsARPEntry> arpCaches,
      String circuitId,
      String googleDemarc,
      InterconnectDiagnosticsLinkLACPStatus lacpStatus,
      InterconnectDiagnosticsLinkOpticalPower receivingOpticalPower,
      InterconnectDiagnosticsLinkOpticalPower transmittingOpticalPower) {
    this.arpCaches = arpCaches;
    this.circuitId = circuitId;
    this.googleDemarc = googleDemarc;
    this.lacpStatus = lacpStatus;
    this.receivingOpticalPower = receivingOpticalPower;
    this.transmittingOpticalPower = transmittingOpticalPower;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("arpCaches".equals(fieldName)) {
      return arpCaches;
    }
    if ("circuitId".equals(fieldName)) {
      return circuitId;
    }
    if ("googleDemarc".equals(fieldName)) {
      return googleDemarc;
    }
    if ("lacpStatus".equals(fieldName)) {
      return lacpStatus;
    }
    if ("receivingOpticalPower".equals(fieldName)) {
      return receivingOpticalPower;
    }
    if ("transmittingOpticalPower".equals(fieldName)) {
      return transmittingOpticalPower;
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
   * A list of InterconnectDiagnostics.ARPEntry objects, describing the ARP neighbor entries seen on
   * this link. This will be empty if the link is bundled
   */
  public List<InterconnectDiagnosticsARPEntry> getArpCachesList() {
    return arpCaches;
  }

  /** The unique ID for this link assigned during turn up by Google. */
  public String getCircuitId() {
    return circuitId;
  }

  /** The Demarc address assigned by Google and provided in the LoA. */
  public String getGoogleDemarc() {
    return googleDemarc;
  }

  public InterconnectDiagnosticsLinkLACPStatus getLacpStatus() {
    return lacpStatus;
  }

  public InterconnectDiagnosticsLinkOpticalPower getReceivingOpticalPower() {
    return receivingOpticalPower;
  }

  public InterconnectDiagnosticsLinkOpticalPower getTransmittingOpticalPower() {
    return transmittingOpticalPower;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectDiagnosticsLinkStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectDiagnosticsLinkStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectDiagnosticsLinkStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectDiagnosticsLinkStatus();
  }

  public static class Builder {
    private List<InterconnectDiagnosticsARPEntry> arpCaches;
    private String circuitId;
    private String googleDemarc;
    private InterconnectDiagnosticsLinkLACPStatus lacpStatus;
    private InterconnectDiagnosticsLinkOpticalPower receivingOpticalPower;
    private InterconnectDiagnosticsLinkOpticalPower transmittingOpticalPower;

    Builder() {}

    public Builder mergeFrom(InterconnectDiagnosticsLinkStatus other) {
      if (other == InterconnectDiagnosticsLinkStatus.getDefaultInstance()) return this;
      if (other.getArpCachesList() != null) {
        this.arpCaches = other.arpCaches;
      }
      if (other.getCircuitId() != null) {
        this.circuitId = other.circuitId;
      }
      if (other.getGoogleDemarc() != null) {
        this.googleDemarc = other.googleDemarc;
      }
      if (other.getLacpStatus() != null) {
        this.lacpStatus = other.lacpStatus;
      }
      if (other.getReceivingOpticalPower() != null) {
        this.receivingOpticalPower = other.receivingOpticalPower;
      }
      if (other.getTransmittingOpticalPower() != null) {
        this.transmittingOpticalPower = other.transmittingOpticalPower;
      }
      return this;
    }

    Builder(InterconnectDiagnosticsLinkStatus source) {
      this.arpCaches = source.arpCaches;
      this.circuitId = source.circuitId;
      this.googleDemarc = source.googleDemarc;
      this.lacpStatus = source.lacpStatus;
      this.receivingOpticalPower = source.receivingOpticalPower;
      this.transmittingOpticalPower = source.transmittingOpticalPower;
    }

    /**
     * A list of InterconnectDiagnostics.ARPEntry objects, describing the ARP neighbor entries seen
     * on this link. This will be empty if the link is bundled
     */
    public List<InterconnectDiagnosticsARPEntry> getArpCachesList() {
      return arpCaches;
    }

    /**
     * A list of InterconnectDiagnostics.ARPEntry objects, describing the ARP neighbor entries seen
     * on this link. This will be empty if the link is bundled
     */
    public Builder addAllArpCaches(List<InterconnectDiagnosticsARPEntry> arpCaches) {
      if (this.arpCaches == null) {
        this.arpCaches = new LinkedList<>();
      }
      this.arpCaches.addAll(arpCaches);
      return this;
    }

    /**
     * A list of InterconnectDiagnostics.ARPEntry objects, describing the ARP neighbor entries seen
     * on this link. This will be empty if the link is bundled
     */
    public Builder addArpCaches(InterconnectDiagnosticsARPEntry arpCaches) {
      if (this.arpCaches == null) {
        this.arpCaches = new LinkedList<>();
      }
      this.arpCaches.add(arpCaches);
      return this;
    }

    /** The unique ID for this link assigned during turn up by Google. */
    public String getCircuitId() {
      return circuitId;
    }

    /** The unique ID for this link assigned during turn up by Google. */
    public Builder setCircuitId(String circuitId) {
      this.circuitId = circuitId;
      return this;
    }

    /** The Demarc address assigned by Google and provided in the LoA. */
    public String getGoogleDemarc() {
      return googleDemarc;
    }

    /** The Demarc address assigned by Google and provided in the LoA. */
    public Builder setGoogleDemarc(String googleDemarc) {
      this.googleDemarc = googleDemarc;
      return this;
    }

    public InterconnectDiagnosticsLinkLACPStatus getLacpStatus() {
      return lacpStatus;
    }

    public Builder setLacpStatus(InterconnectDiagnosticsLinkLACPStatus lacpStatus) {
      this.lacpStatus = lacpStatus;
      return this;
    }

    public InterconnectDiagnosticsLinkOpticalPower getReceivingOpticalPower() {
      return receivingOpticalPower;
    }

    public Builder setReceivingOpticalPower(
        InterconnectDiagnosticsLinkOpticalPower receivingOpticalPower) {
      this.receivingOpticalPower = receivingOpticalPower;
      return this;
    }

    public InterconnectDiagnosticsLinkOpticalPower getTransmittingOpticalPower() {
      return transmittingOpticalPower;
    }

    public Builder setTransmittingOpticalPower(
        InterconnectDiagnosticsLinkOpticalPower transmittingOpticalPower) {
      this.transmittingOpticalPower = transmittingOpticalPower;
      return this;
    }

    public InterconnectDiagnosticsLinkStatus build() {

      return new InterconnectDiagnosticsLinkStatus(
          arpCaches,
          circuitId,
          googleDemarc,
          lacpStatus,
          receivingOpticalPower,
          transmittingOpticalPower);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllArpCaches(this.arpCaches);
      newBuilder.setCircuitId(this.circuitId);
      newBuilder.setGoogleDemarc(this.googleDemarc);
      newBuilder.setLacpStatus(this.lacpStatus);
      newBuilder.setReceivingOpticalPower(this.receivingOpticalPower);
      newBuilder.setTransmittingOpticalPower(this.transmittingOpticalPower);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectDiagnosticsLinkStatus{"
        + "arpCaches="
        + arpCaches
        + ", "
        + "circuitId="
        + circuitId
        + ", "
        + "googleDemarc="
        + googleDemarc
        + ", "
        + "lacpStatus="
        + lacpStatus
        + ", "
        + "receivingOpticalPower="
        + receivingOpticalPower
        + ", "
        + "transmittingOpticalPower="
        + transmittingOpticalPower
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectDiagnosticsLinkStatus) {
      InterconnectDiagnosticsLinkStatus that = (InterconnectDiagnosticsLinkStatus) o;
      return Objects.equals(this.arpCaches, that.getArpCachesList())
          && Objects.equals(this.circuitId, that.getCircuitId())
          && Objects.equals(this.googleDemarc, that.getGoogleDemarc())
          && Objects.equals(this.lacpStatus, that.getLacpStatus())
          && Objects.equals(this.receivingOpticalPower, that.getReceivingOpticalPower())
          && Objects.equals(this.transmittingOpticalPower, that.getTransmittingOpticalPower());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        arpCaches,
        circuitId,
        googleDemarc,
        lacpStatus,
        receivingOpticalPower,
        transmittingOpticalPower);
  }
}
