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
/** The parameters of the raw disk image. */
public final class RawDisk implements ApiMessage {
  private final String containerType;
  private final String sha1Checksum;
  private final String source;

  private RawDisk() {
    this.containerType = null;
    this.sha1Checksum = null;
    this.source = null;
  }

  private RawDisk(String containerType, String sha1Checksum, String source) {
    this.containerType = containerType;
    this.sha1Checksum = sha1Checksum;
    this.source = source;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("containerType".equals(fieldName)) {
      return containerType;
    }
    if ("sha1Checksum".equals(fieldName)) {
      return sha1Checksum;
    }
    if ("source".equals(fieldName)) {
      return source;
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
   * The format used to encode and transmit the block device, which should be TAR. This is just a
   * container and transmission format and not a runtime format. Provided by the client when the
   * disk image is created.
   */
  public String getContainerType() {
    return containerType;
  }

  /**
   * An optional SHA1 checksum of the disk image before unpackaging; provided by the client when the
   * disk image is created.
   */
  public String getSha1Checksum() {
    return sha1Checksum;
  }

  /**
   * The full Google Cloud Storage URL where the disk image is stored. You must provide either this
   * property or the sourceDisk property but not both.
   */
  public String getSource() {
    return source;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RawDisk prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RawDisk getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RawDisk DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RawDisk();
  }

  public static class Builder {
    private String containerType;
    private String sha1Checksum;
    private String source;

    Builder() {}

    public Builder mergeFrom(RawDisk other) {
      if (other == RawDisk.getDefaultInstance()) return this;
      if (other.getContainerType() != null) {
        this.containerType = other.containerType;
      }
      if (other.getSha1Checksum() != null) {
        this.sha1Checksum = other.sha1Checksum;
      }
      if (other.getSource() != null) {
        this.source = other.source;
      }
      return this;
    }

    Builder(RawDisk source) {
      this.containerType = source.containerType;
      this.sha1Checksum = source.sha1Checksum;
      this.source = source.source;
    }

    /**
     * The format used to encode and transmit the block device, which should be TAR. This is just a
     * container and transmission format and not a runtime format. Provided by the client when the
     * disk image is created.
     */
    public String getContainerType() {
      return containerType;
    }

    /**
     * The format used to encode and transmit the block device, which should be TAR. This is just a
     * container and transmission format and not a runtime format. Provided by the client when the
     * disk image is created.
     */
    public Builder setContainerType(String containerType) {
      this.containerType = containerType;
      return this;
    }

    /**
     * An optional SHA1 checksum of the disk image before unpackaging; provided by the client when
     * the disk image is created.
     */
    public String getSha1Checksum() {
      return sha1Checksum;
    }

    /**
     * An optional SHA1 checksum of the disk image before unpackaging; provided by the client when
     * the disk image is created.
     */
    public Builder setSha1Checksum(String sha1Checksum) {
      this.sha1Checksum = sha1Checksum;
      return this;
    }

    /**
     * The full Google Cloud Storage URL where the disk image is stored. You must provide either
     * this property or the sourceDisk property but not both.
     */
    public String getSource() {
      return source;
    }

    /**
     * The full Google Cloud Storage URL where the disk image is stored. You must provide either
     * this property or the sourceDisk property but not both.
     */
    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    public RawDisk build() {

      return new RawDisk(containerType, sha1Checksum, source);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setContainerType(this.containerType);
      newBuilder.setSha1Checksum(this.sha1Checksum);
      newBuilder.setSource(this.source);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RawDisk{"
        + "containerType="
        + containerType
        + ", "
        + "sha1Checksum="
        + sha1Checksum
        + ", "
        + "source="
        + source
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RawDisk) {
      RawDisk that = (RawDisk) o;
      return Objects.equals(this.containerType, that.getContainerType())
          && Objects.equals(this.sha1Checksum, that.getSha1Checksum())
          && Objects.equals(this.source, that.getSource());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(containerType, sha1Checksum, source);
  }
}
