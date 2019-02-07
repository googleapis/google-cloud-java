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
/** Contains a list of VmEndpointNatMappings. */
public final class VmEndpointNatMappingsList implements ApiMessage {
  private final String id;
  private final String kind;
  private final String nextPageToken;
  private final List<VmEndpointNatMappings> result;
  private final String selfLink;
  private final Warning warning;

  private VmEndpointNatMappingsList() {
    this.id = null;
    this.kind = null;
    this.nextPageToken = null;
    this.result = null;
    this.selfLink = null;
    this.warning = null;
  }

  private VmEndpointNatMappingsList(
      String id,
      String kind,
      String nextPageToken,
      List<VmEndpointNatMappings> result,
      String selfLink,
      Warning warning) {
    this.id = id;
    this.kind = kind;
    this.nextPageToken = nextPageToken;
    this.result = result;
    this.selfLink = selfLink;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("nextPageToken".equals(fieldName)) {
      return nextPageToken;
    }
    if ("result".equals(fieldName)) {
      return result;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output Only] Type of resource. Always compute#vmEndpointNatMappingsList for lists of Nat
   * mappings of VM endpoints.
   */
  public String getKind() {
    return kind;
  }

  /**
   * [Output Only] This token allows you to get the next page of results for list requests. If the
   * number of results is larger than maxResults, use the nextPageToken as a value for the query
   * parameter pageToken in the next list request. Subsequent list requests will have their own
   * nextPageToken to continue paging through the results.
   */
  public String getNextPageToken() {
    return nextPageToken;
  }

  /** [Output Only] A list of Nat mapping information of VM endpoints. */
  public List<VmEndpointNatMappings> getResultList() {
    return result;
  }

  /** [Output Only] Server-defined URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Informational warning message. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VmEndpointNatMappingsList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VmEndpointNatMappingsList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VmEndpointNatMappingsList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VmEndpointNatMappingsList();
  }

  public static class Builder {
    private String id;
    private String kind;
    private String nextPageToken;
    private List<VmEndpointNatMappings> result;
    private String selfLink;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(VmEndpointNatMappingsList other) {
      if (other == VmEndpointNatMappingsList.getDefaultInstance()) return this;
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getNextPageToken() != null) {
        this.nextPageToken = other.nextPageToken;
      }
      if (other.getResultList() != null) {
        this.result = other.result;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(VmEndpointNatMappingsList source) {
      this.id = source.id;
      this.kind = source.kind;
      this.nextPageToken = source.nextPageToken;
      this.result = source.result;
      this.selfLink = source.selfLink;
      this.warning = source.warning;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Output Only] Type of resource. Always compute#vmEndpointNatMappingsList for lists of Nat
     * mappings of VM endpoints.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of resource. Always compute#vmEndpointNatMappingsList for lists of Nat
     * mappings of VM endpoints.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * [Output Only] This token allows you to get the next page of results for list requests. If the
     * number of results is larger than maxResults, use the nextPageToken as a value for the query
     * parameter pageToken in the next list request. Subsequent list requests will have their own
     * nextPageToken to continue paging through the results.
     */
    public String getNextPageToken() {
      return nextPageToken;
    }

    /**
     * [Output Only] This token allows you to get the next page of results for list requests. If the
     * number of results is larger than maxResults, use the nextPageToken as a value for the query
     * parameter pageToken in the next list request. Subsequent list requests will have their own
     * nextPageToken to continue paging through the results.
     */
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
      return this;
    }

    /** [Output Only] A list of Nat mapping information of VM endpoints. */
    public List<VmEndpointNatMappings> getResultList() {
      return result;
    }

    /** [Output Only] A list of Nat mapping information of VM endpoints. */
    public Builder addAllResult(List<VmEndpointNatMappings> result) {
      if (this.result == null) {
        this.result = new LinkedList<>();
      }
      this.result.addAll(result);
      return this;
    }

    /** [Output Only] A list of Nat mapping information of VM endpoints. */
    public Builder addResult(VmEndpointNatMappings result) {
      if (this.result == null) {
        this.result = new LinkedList<>();
      }
      this.result.add(result);
      return this;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** [Output Only] Informational warning message. */
    public Warning getWarning() {
      return warning;
    }

    /** [Output Only] Informational warning message. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public VmEndpointNatMappingsList build() {

      return new VmEndpointNatMappingsList(id, kind, nextPageToken, result, selfLink, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setNextPageToken(this.nextPageToken);
      newBuilder.addAllResult(this.result);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VmEndpointNatMappingsList{"
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "nextPageToken="
        + nextPageToken
        + ", "
        + "result="
        + result
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VmEndpointNatMappingsList) {
      VmEndpointNatMappingsList that = (VmEndpointNatMappingsList) o;
      return Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.nextPageToken, that.getNextPageToken())
          && Objects.equals(this.result, that.getResultList())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, kind, nextPageToken, result, selfLink, warning);
  }
}
