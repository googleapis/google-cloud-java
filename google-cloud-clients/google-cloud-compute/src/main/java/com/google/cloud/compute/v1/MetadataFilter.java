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
/**
 * Opaque filter criteria used by loadbalancers to restrict routing configuration to a limited set
 * of loadbalancing proxies. Proxies and sidecars involved in loadbalancing would typically present
 * metadata to the loadbalancers which need to match criteria specified here. If a match takes
 * place, the relevant routing configuration is made available to those proxies. For each
 * metadataFilter in this list, if its filterMatchCriteria is set to MATCH_ANY, at least one of the
 * filterLabels must match the corresponding label provided in the metadata. If its
 * filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels must match with
 * corresponding labels in the provided metadata. An example for using metadataFilters would be: if
 * loadbalancing involves Envoys, they will only receive routing configuration when values in
 * metadataFilters match values supplied in &lt;a
 * href="https://www.envoyproxy.io/docs/envoy/latest/api-v2/api/v2/core/base.proto#envoy-api-msg-core-node"
 * Node metadata of their XDS requests to loadbalancers.
 */
public final class MetadataFilter implements ApiMessage {
  private final List<MetadataFilterLabelMatch> filterLabels;
  private final String filterMatchCriteria;

  private MetadataFilter() {
    this.filterLabels = null;
    this.filterMatchCriteria = null;
  }

  private MetadataFilter(List<MetadataFilterLabelMatch> filterLabels, String filterMatchCriteria) {
    this.filterLabels = filterLabels;
    this.filterMatchCriteria = filterMatchCriteria;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("filterLabels".equals(fieldName)) {
      return filterLabels;
    }
    if ("filterMatchCriteria".equals(fieldName)) {
      return filterMatchCriteria;
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
   * The list of label value pairs that must match labels in the provided metadata based on
   * filterMatchCriteria This list must not be empty and can have at the most 64 entries.
   */
  public List<MetadataFilterLabelMatch> getFilterLabelsList() {
    return filterLabels;
  }

  /**
   * Specifies how individual filterLabel matches within the list of filterLabels contribute towards
   * the overall metadataFilter match. Supported values are: - MATCH_ANY: At least one of the
   * filterLabels must have a matching label in the provided metadata. - MATCH_ALL: All filterLabels
   * must have matching labels in the provided metadata.
   */
  public String getFilterMatchCriteria() {
    return filterMatchCriteria;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(MetadataFilter prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static MetadataFilter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final MetadataFilter DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new MetadataFilter();
  }

  public static class Builder {
    private List<MetadataFilterLabelMatch> filterLabels;
    private String filterMatchCriteria;

    Builder() {}

    public Builder mergeFrom(MetadataFilter other) {
      if (other == MetadataFilter.getDefaultInstance()) return this;
      if (other.getFilterLabelsList() != null) {
        this.filterLabels = other.filterLabels;
      }
      if (other.getFilterMatchCriteria() != null) {
        this.filterMatchCriteria = other.filterMatchCriteria;
      }
      return this;
    }

    Builder(MetadataFilter source) {
      this.filterLabels = source.filterLabels;
      this.filterMatchCriteria = source.filterMatchCriteria;
    }

    /**
     * The list of label value pairs that must match labels in the provided metadata based on
     * filterMatchCriteria This list must not be empty and can have at the most 64 entries.
     */
    public List<MetadataFilterLabelMatch> getFilterLabelsList() {
      return filterLabels;
    }

    /**
     * The list of label value pairs that must match labels in the provided metadata based on
     * filterMatchCriteria This list must not be empty and can have at the most 64 entries.
     */
    public Builder addAllFilterLabels(List<MetadataFilterLabelMatch> filterLabels) {
      if (this.filterLabels == null) {
        this.filterLabels = new LinkedList<>();
      }
      this.filterLabels.addAll(filterLabels);
      return this;
    }

    /**
     * The list of label value pairs that must match labels in the provided metadata based on
     * filterMatchCriteria This list must not be empty and can have at the most 64 entries.
     */
    public Builder addFilterLabels(MetadataFilterLabelMatch filterLabels) {
      if (this.filterLabels == null) {
        this.filterLabels = new LinkedList<>();
      }
      this.filterLabels.add(filterLabels);
      return this;
    }

    /**
     * Specifies how individual filterLabel matches within the list of filterLabels contribute
     * towards the overall metadataFilter match. Supported values are: - MATCH_ANY: At least one of
     * the filterLabels must have a matching label in the provided metadata. - MATCH_ALL: All
     * filterLabels must have matching labels in the provided metadata.
     */
    public String getFilterMatchCriteria() {
      return filterMatchCriteria;
    }

    /**
     * Specifies how individual filterLabel matches within the list of filterLabels contribute
     * towards the overall metadataFilter match. Supported values are: - MATCH_ANY: At least one of
     * the filterLabels must have a matching label in the provided metadata. - MATCH_ALL: All
     * filterLabels must have matching labels in the provided metadata.
     */
    public Builder setFilterMatchCriteria(String filterMatchCriteria) {
      this.filterMatchCriteria = filterMatchCriteria;
      return this;
    }

    public MetadataFilter build() {

      return new MetadataFilter(filterLabels, filterMatchCriteria);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllFilterLabels(this.filterLabels);
      newBuilder.setFilterMatchCriteria(this.filterMatchCriteria);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "MetadataFilter{"
        + "filterLabels="
        + filterLabels
        + ", "
        + "filterMatchCriteria="
        + filterMatchCriteria
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MetadataFilter) {
      MetadataFilter that = (MetadataFilter) o;
      return Objects.equals(this.filterLabels, that.getFilterLabelsList())
          && Objects.equals(this.filterMatchCriteria, that.getFilterMatchCriteria());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(filterLabels, filterMatchCriteria);
  }
}
