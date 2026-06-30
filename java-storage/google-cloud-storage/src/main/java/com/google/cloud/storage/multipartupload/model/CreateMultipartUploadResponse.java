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

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * Represents the response from a CreateMultipartUpload request. This class encapsulates the details
 * of the initiated multipart upload, including the bucket, key, and the unique upload ID.
 *
 * @since 2.60.0
 */
@JacksonXmlRootElement(localName = "InitiateMultipartUploadResult")
public final class CreateMultipartUploadResponse {

  @JacksonXmlProperty(localName = "Bucket")
  private String bucket;

  @JacksonXmlProperty(localName = "Key")
  private String key;

  @JacksonXmlProperty(localName = "UploadId")
  private String uploadId;

  private CreateMultipartUploadResponse() {}

  private CreateMultipartUploadResponse(Builder builder) {
    this.bucket = builder.bucket;
    this.key = builder.key;
    this.uploadId = builder.uploadId;
  }

  /**
   * Returns the name of the bucket where the multipart upload was initiated.
   *
   * @return The bucket name.
   * @since 2.60.0
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Returns the key (object name) for which the multipart upload was initiated.
   *
   * @return The object key.
   * @since 2.60.0
   */
  public String key() {
    return key;
  }

  /**
   * Returns the unique identifier for this multipart upload. This ID must be included in all
   * subsequent requests related to this upload (e.g., uploading parts, completing the upload).
   *
   * @return The upload ID.
   * @since 2.60.0
   */
  public String uploadId() {
    return uploadId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CreateMultipartUploadResponse)) {
      return false;
    }
    CreateMultipartUploadResponse that = (CreateMultipartUploadResponse) o;
    return Objects.equals(bucket, that.bucket)
        && Objects.equals(key, that.key)
        && Objects.equals(uploadId, that.uploadId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket, key, uploadId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket)
        .add("key", key)
        .add("uploadId", uploadId)
        .toString();
  }

  /**
   * Creates a new builder for {@link CreateMultipartUploadResponse}.
   *
   * @return A new builder.
   * @since 2.60.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * A builder for {@link CreateMultipartUploadResponse} objects.
   *
   * @since 2.60.0
   */
  public static final class Builder {
    private String bucket;
    private String key;
    private String uploadId;

    private Builder() {}

    /**
     * Sets the bucket name for the multipart upload.
     *
     * @param bucket The bucket name.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Sets the key (object name) for the multipart upload.
     *
     * @param key The object key.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Sets the upload ID for the multipart upload.
     *
     * @param uploadId The upload ID.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder uploadId(String uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    /**
     * Builds a new {@link CreateMultipartUploadResponse} object.
     *
     * @return A new {@link CreateMultipartUploadResponse} object.
     * @since 2.60.0
     */
    public CreateMultipartUploadResponse build() {
      return new CreateMultipartUploadResponse(this);
    }
  }
}
