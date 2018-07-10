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
public final class InterconnectAttachmentPartnerMetadata implements ApiMessage {
  private final String interconnectName;
  private final String partnerName;
  private final String portalUrl;

  private InterconnectAttachmentPartnerMetadata() {
    this.interconnectName = null;
    this.partnerName = null;
    this.portalUrl = null;
  }

  private InterconnectAttachmentPartnerMetadata(
      String interconnectName, String partnerName, String portalUrl) {
    this.interconnectName = interconnectName;
    this.partnerName = partnerName;
    this.portalUrl = portalUrl;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("interconnectName")) {
      return interconnectName;
    }
    if (fieldName.equals("partnerName")) {
      return partnerName;
    }
    if (fieldName.equals("portalUrl")) {
      return portalUrl;
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

  public String getInterconnectName() {
    return interconnectName;
  }

  public String getPartnerName() {
    return partnerName;
  }

  public String getPortalUrl() {
    return portalUrl;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectAttachmentPartnerMetadata prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectAttachmentPartnerMetadata getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectAttachmentPartnerMetadata DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectAttachmentPartnerMetadata();
  }

  public static class Builder {
    private String interconnectName;
    private String partnerName;
    private String portalUrl;

    Builder() {}

    public Builder mergeFrom(InterconnectAttachmentPartnerMetadata other) {
      if (other == InterconnectAttachmentPartnerMetadata.getDefaultInstance()) return this;
      if (other.getInterconnectName() != null) {
        this.interconnectName = other.interconnectName;
      }
      if (other.getPartnerName() != null) {
        this.partnerName = other.partnerName;
      }
      if (other.getPortalUrl() != null) {
        this.portalUrl = other.portalUrl;
      }
      return this;
    }

    Builder(InterconnectAttachmentPartnerMetadata source) {
      this.interconnectName = source.interconnectName;
      this.partnerName = source.partnerName;
      this.portalUrl = source.portalUrl;
    }

    public String getInterconnectName() {
      return interconnectName;
    }

    public Builder setInterconnectName(String interconnectName) {
      this.interconnectName = interconnectName;
      return this;
    }

    public String getPartnerName() {
      return partnerName;
    }

    public Builder setPartnerName(String partnerName) {
      this.partnerName = partnerName;
      return this;
    }

    public String getPortalUrl() {
      return portalUrl;
    }

    public Builder setPortalUrl(String portalUrl) {
      this.portalUrl = portalUrl;
      return this;
    }

    public InterconnectAttachmentPartnerMetadata build() {

      return new InterconnectAttachmentPartnerMetadata(interconnectName, partnerName, portalUrl);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInterconnectName(this.interconnectName);
      newBuilder.setPartnerName(this.partnerName);
      newBuilder.setPortalUrl(this.portalUrl);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectAttachmentPartnerMetadata{"
        + "interconnectName="
        + interconnectName
        + ", "
        + "partnerName="
        + partnerName
        + ", "
        + "portalUrl="
        + portalUrl
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectAttachmentPartnerMetadata) {
      InterconnectAttachmentPartnerMetadata that = (InterconnectAttachmentPartnerMetadata) o;
      return Objects.equals(this.interconnectName, that.getInterconnectName())
          && Objects.equals(this.partnerName, that.getPartnerName())
          && Objects.equals(this.portalUrl, that.getPortalUrl());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(interconnectName, partnerName, portalUrl);
  }
}
