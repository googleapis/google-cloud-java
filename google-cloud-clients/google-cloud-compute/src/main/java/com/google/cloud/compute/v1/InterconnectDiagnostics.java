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
public final class InterconnectDiagnostics implements ApiMessage {
  private final List<InterconnectDiagnosticsARPEntry> arpCaches;
  private final List<InterconnectDiagnosticsLinkStatus> links;
  private final String macAddress;

  private InterconnectDiagnostics() {
    this.arpCaches = null;
    this.links = null;
    this.macAddress = null;
  }

  private InterconnectDiagnostics(
      List<InterconnectDiagnosticsARPEntry> arpCaches,
      List<InterconnectDiagnosticsLinkStatus> links,
      String macAddress) {
    this.arpCaches = arpCaches;
    this.links = links;
    this.macAddress = macAddress;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("arpCaches".equals(fieldName)) {
      return arpCaches;
    }
    if ("links".equals(fieldName)) {
      return links;
    }
    if ("macAddress".equals(fieldName)) {
      return macAddress;
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

  public List<InterconnectDiagnosticsARPEntry> getArpCachesList() {
    return arpCaches;
  }

  public List<InterconnectDiagnosticsLinkStatus> getLinksList() {
    return links;
  }

  public String getMacAddress() {
    return macAddress;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectDiagnostics prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectDiagnostics getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectDiagnostics DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectDiagnostics();
  }

  public static class Builder {
    private List<InterconnectDiagnosticsARPEntry> arpCaches;
    private List<InterconnectDiagnosticsLinkStatus> links;
    private String macAddress;

    Builder() {}

    public Builder mergeFrom(InterconnectDiagnostics other) {
      if (other == InterconnectDiagnostics.getDefaultInstance()) return this;
      if (other.getArpCachesList() != null) {
        this.arpCaches = other.arpCaches;
      }
      if (other.getLinksList() != null) {
        this.links = other.links;
      }
      if (other.getMacAddress() != null) {
        this.macAddress = other.macAddress;
      }
      return this;
    }

    Builder(InterconnectDiagnostics source) {
      this.arpCaches = source.arpCaches;
      this.links = source.links;
      this.macAddress = source.macAddress;
    }

    public List<InterconnectDiagnosticsARPEntry> getArpCachesList() {
      return arpCaches;
    }

    public Builder addAllArpCaches(List<InterconnectDiagnosticsARPEntry> arpCaches) {
      if (this.arpCaches == null) {
        this.arpCaches = new LinkedList<>();
      }
      this.arpCaches.addAll(arpCaches);
      return this;
    }

    public Builder addArpCaches(InterconnectDiagnosticsARPEntry arpCaches) {
      if (this.arpCaches == null) {
        this.arpCaches = new LinkedList<>();
      }
      this.arpCaches.add(arpCaches);
      return this;
    }

    public List<InterconnectDiagnosticsLinkStatus> getLinksList() {
      return links;
    }

    public Builder addAllLinks(List<InterconnectDiagnosticsLinkStatus> links) {
      if (this.links == null) {
        this.links = new LinkedList<>();
      }
      this.links.addAll(links);
      return this;
    }

    public Builder addLinks(InterconnectDiagnosticsLinkStatus links) {
      if (this.links == null) {
        this.links = new LinkedList<>();
      }
      this.links.add(links);
      return this;
    }

    public String getMacAddress() {
      return macAddress;
    }

    public Builder setMacAddress(String macAddress) {
      this.macAddress = macAddress;
      return this;
    }

    public InterconnectDiagnostics build() {

      return new InterconnectDiagnostics(arpCaches, links, macAddress);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllArpCaches(this.arpCaches);
      newBuilder.addAllLinks(this.links);
      newBuilder.setMacAddress(this.macAddress);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectDiagnostics{"
        + "arpCaches="
        + arpCaches
        + ", "
        + "links="
        + links
        + ", "
        + "macAddress="
        + macAddress
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectDiagnostics) {
      InterconnectDiagnostics that = (InterconnectDiagnostics) o;
      return Objects.equals(this.arpCaches, that.getArpCachesList())
          && Objects.equals(this.links, that.getLinksList())
          && Objects.equals(this.macAddress, that.getMacAddress());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(arpCaches, links, macAddress);
  }
}
