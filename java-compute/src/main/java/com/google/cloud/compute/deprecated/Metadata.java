/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Metadata for Google Compute Engine Instance as ket/value pairs. This includes custom metadata and
 * predefined keys.
 *
 * @see <a href="https://cloud.google.com/compute/docs/metadata">Metadata</a>
 */
public final class Metadata implements Serializable {

  static final Function<com.google.api.services.compute.model.Metadata, Metadata> FROM_PB_FUNCTION =
      new Function<com.google.api.services.compute.model.Metadata, Metadata>() {
        @Override
        public Metadata apply(com.google.api.services.compute.model.Metadata pb) {
          return Metadata.fromPb(pb);
        }
      };
  static final Function<Metadata, com.google.api.services.compute.model.Metadata> TO_PB_FUNCTION =
      new Function<Metadata, com.google.api.services.compute.model.Metadata>() {
        @Override
        public com.google.api.services.compute.model.Metadata apply(Metadata metadata) {
          return metadata.toPb();
        }
      };

  private static final long serialVersionUID = -945038809838910107L;

  private final Map<String, String> values;
  private final String fingerprint;

  /** A builder for {@code Metadata} objects. */
  public static final class Builder {

    private Map<String, String> values;
    private String fingerprint;

    Builder() {
      values = Maps.newHashMap();
    }

    Builder(Metadata metadata) {
      this.values =
          metadata.values != null
              ? Maps.newHashMap(metadata.values)
              : Maps.<String, String>newHashMap();
      this.fingerprint = metadata.fingerprint;
    }

    /**
     * Sets the metadata for the instance as key/value pairs. The total size of all keys and values
     * must be less than 512 KB. Keys must conform to the following regexp: {@code [a-zA-Z0-9-_]+},
     * and be less than 128 bytes in length. This is reflected as part of a URL in the metadata
     * server. Additionally, to avoid ambiguity, keys must not conflict with any other metadata keys
     * for the project. Values must be less than or equal to 32768 bytes.
     */
    public Builder setValues(Map<String, String> values) {
      this.values = Maps.newHashMap(checkNotNull(values));
      return this;
    }

    /**
     * Adds a key/value pair to the instance metadata. The total size of all keys and values must be
     * less than 512 KB. Keys must conform to the following regexp: {@code [a-zA-Z0-9-_]+}, and be
     * less than 128 bytes in length. This is reflected as part of a URL in the metadata server.
     * Additionally, to avoid ambiguity, keys must not conflict with any other metadata keys for the
     * project. Values must be less than or equal to 32768 bytes.
     */
    public Builder add(String key, String value) {
      this.values.put(key, value);
      return this;
    }

    /**
     * Sets the fingerprint for the metadata. This value can be used to update instance's metadata.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /** Creates a {@code Metadata} object. */
    public Metadata build() {
      return new Metadata(this);
    }
  }

  private Metadata(Builder builder) {
    this.values = ImmutableMap.copyOf(builder.values);
    this.fingerprint = builder.fingerprint;
  }

  /** Returns instance's metadata as key/value pairs. */
  public Map<String, String> getValues() {
    return values;
  }

  /**
   * Returns the fingerprint for the metadata. This value can be used to update instance's metadata.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /** Returns a builder for the current instance metadata. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("values", values)
        .add("fingerprint", fingerprint)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(values, fingerprint);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof Metadata && Objects.equals(toPb(), ((Metadata) obj).toPb());
  }

  com.google.api.services.compute.model.Metadata toPb() {
    com.google.api.services.compute.model.Metadata metadataPb =
        new com.google.api.services.compute.model.Metadata();
    metadataPb.setFingerprint(fingerprint);
    List<com.google.api.services.compute.model.Metadata.Items> itemsPb =
        Lists.newArrayListWithCapacity(values.size());
    for (Map.Entry<String, String> entry : values.entrySet()) {
      itemsPb.add(
          new com.google.api.services.compute.model.Metadata.Items()
              .setKey(entry.getKey())
              .setValue(entry.getValue()));
    }
    metadataPb.setItems(itemsPb);
    metadataPb.setFingerprint(fingerprint);
    return metadataPb;
  }

  /** Returns a builder for a {@code Metadata} object. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns a {@code Metadata} object given the the metadata as a map. The total size of all keys
   * and values must be less than 512 KB. Keys must conform to the following regexp: {@code
   * [a-zA-Z0-9-_]+}, and be less than 128 bytes in length. This is reflected as part of a URL in
   * the metadata server. Additionally, to avoid ambiguity, keys must not conflict with any other
   * metadata keys for the project. Values must be less than or equal to 32768 bytes.
   */
  public static Metadata of(Map<String, String> values) {
    return newBuilder().setValues(values).build();
  }

  static Metadata fromPb(com.google.api.services.compute.model.Metadata metadataPb) {
    Builder builder = newBuilder();
    if (metadataPb.getItems() != null) {
      Map<String, String> metadataValues =
          Maps.newHashMapWithExpectedSize(metadataPb.getItems().size());
      for (com.google.api.services.compute.model.Metadata.Items item : metadataPb.getItems()) {
        metadataValues.put(item.getKey(), item.getValue());
      }
      builder.setValues(metadataValues);
    }
    return builder.setFingerprint(metadataPb.getFingerprint()).build();
  }
}
