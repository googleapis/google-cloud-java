/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage.multipartupload.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * Represents the response from a completed multipart upload.
 *
 * @since 2.60.0
 */
@JsonDeserialize(builder = CompleteMultipartUploadResponse.Builder.class)
public final class CompleteMultipartUploadResponse {

  private final String location;
  private final String bucket;
  private final String key;
  private final String etag;
  private final String crc32c;

  private CompleteMultipartUploadResponse(Builder builder) {
    this.location = builder.location;
    this.bucket = builder.bucket;
    this.key = builder.key;
    this.etag = builder.etag;
    this.crc32c = builder.crc32c;
  }

  /**
   * Returns the URL of the completed object.
   *
   * @return The URL of the completed object.
   * @since 2.60.0
   */
  @JsonProperty("Location")
  public String location() {
    return location;
  }

  /**
   * Returns the bucket name.
   *
   * @return The bucket name.
   * @since 2.60.0
   */
  @JsonProperty("Bucket")
  public String bucket() {
    return bucket;
  }

  /**
   * Returns the object name.
   *
   * @return The object name.
   * @since 2.60.0
   */
  @JsonProperty("Key")
  public String key() {
    return key;
  }

  /**
   * Returns the ETag of the completed object.
   *
   * @return The ETag of the completed object.
   * @since 2.60.0
   */
  @JsonProperty("ETag")
  public String etag() {
    return etag;
  }

  /**
   * Returns the CRC32C checksum of the completed object.
   *
   * @return The CRC32C checksum of the completed object.
   * @since 2.60.0
   */
  public String crc32c() {
    return crc32c;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CompleteMultipartUploadResponse)) {
      return false;
    }
    CompleteMultipartUploadResponse that = (CompleteMultipartUploadResponse) o;
    return Objects.equals(location, that.location)
        && Objects.equals(bucket, that.bucket)
        && Objects.equals(key, that.key)
        && Objects.equals(etag, that.etag)
        && Objects.equals(crc32c, that.crc32c);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, bucket, key, etag, crc32c);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("location", location)
        .add("bucket", bucket)
        .add("key", key)
        .add("etag", etag)
        .add("crc32c", crc32c)
        .toString();
  }

  /**
   * Creates a new builder for {@link CompleteMultipartUploadResponse}.
   *
   * @return A new builder.
   * @since 2.60.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder for {@link CompleteMultipartUploadResponse}.
   *
   * @since 2.60.0
   */
  @JsonPOJOBuilder(buildMethodName = "build")
  public static class Builder {
    private String location;
    private String bucket;
    private String key;
    private String etag;
    private String crc32c;

    private Builder() {}

    /**
     * Sets the URL of the completed object.
     *
     * @param location The URL of the completed object.
     * @return This builder.
     * @since 2.60.0
     */
    @JsonProperty("Location")
    public Builder location(String location) {
      this.location = location;
      return this;
    }

    /**
     * Sets the bucket name.
     *
     * @param bucket The bucket name.
     * @return This builder.
     * @since 2.60.0
     */
    @JsonProperty("Bucket")
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Sets the object name.
     *
     * @param key The object name.
     * @return This builder.
     * @since 2.60.0
     */
    @JsonProperty("Key")
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Sets the ETag of the completed object.
     *
     * @param etag The ETag of the completed object.
     * @return This builder.
     * @since 2.60.0
     */
    @JsonProperty("ETag")
    public Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    /**
     * Sets the CRC32C checksum of the completed object.
     *
     * @param crc32c The CRC32C checksum of the completed object.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder crc32c(String crc32c) {
      this.crc32c = crc32c;
      return this;
    }

    /**
     * Builds the {@link CompleteMultipartUploadResponse} object.
     *
     * @return The new {@link CompleteMultipartUploadResponse} object.
     * @since 2.60.0
     */
    public CompleteMultipartUploadResponse build() {
      return new CompleteMultipartUploadResponse(this);
    }
  }
}
