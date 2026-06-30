/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.multipartupload.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.cloud.storage.StorageClass;
import com.google.common.base.MoreObjects;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a multipart upload that is in progress.
 *
 * @since 2.61.0
 */
public final class MultipartUpload {

  @JacksonXmlProperty(localName = "Key")
  private String key;

  @JacksonXmlProperty(localName = "UploadId")
  private String uploadId;

  @JacksonXmlProperty(localName = "StorageClass")
  private StorageClass storageClass;

  @JacksonXmlProperty(localName = "Initiated")
  private OffsetDateTime initiated;

  private MultipartUpload() {}

  private MultipartUpload(
      String key, String uploadId, StorageClass storageClass, OffsetDateTime initiated) {
    this.key = key;
    this.uploadId = uploadId;
    this.storageClass = storageClass;
    this.initiated = initiated;
  }

  /**
   * The object name for which the multipart upload was initiated.
   *
   * @return The object name.
   * @since 2.61.0
   */
  public String key() {
    return key;
  }

  /**
   * The ID of the multipart upload.
   *
   * @return The upload ID.
   * @since 2.61.0
   */
  public String uploadId() {
    return uploadId;
  }

  /**
   * The storage class of the object.
   *
   * @return The storage class.
   * @since 2.61.0
   */
  public StorageClass storageClass() {
    return storageClass;
  }

  /**
   * The date and time at which the multipart upload was initiated.
   *
   * @return The initiation date and time.
   * @since 2.61.0
   */
  public OffsetDateTime initiated() {
    return initiated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultipartUpload that = (MultipartUpload) o;
    return Objects.equals(key, that.key)
        && Objects.equals(uploadId, that.uploadId)
        && Objects.equals(storageClass, that.storageClass)
        && Objects.equals(initiated, that.initiated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, uploadId, storageClass, initiated);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("key", key)
        .add("uploadId", uploadId)
        .add("storageClass", storageClass)
        .add("initiated", initiated)
        .toString();
  }

  /**
   * Returns a new builder for this multipart upload.
   *
   * @return A new builder.
   * @since 2.61.0
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * A builder for {@link MultipartUpload}.
   *
   * @since 2.61.0
   */
  public static final class Builder {
    private String key;
    private String uploadId;
    private StorageClass storageClass;
    private OffsetDateTime initiated;

    private Builder() {}

    /**
     * Sets the object name for which the multipart upload was initiated.
     *
     * @param key The object name.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Sets the ID of the multipart upload.
     *
     * @param uploadId The upload ID.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder uploadId(String uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    /**
     * Sets the storage class of the object.
     *
     * @param storageClass The storage class.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder storageClass(StorageClass storageClass) {
      this.storageClass = storageClass;
      return this;
    }

    /**
     * Sets the date and time at which the multipart upload was initiated.
     *
     * @param initiated The initiation date and time.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder initiated(OffsetDateTime initiated) {
      this.initiated = initiated;
      return this;
    }

    /**
     * Builds the multipart upload.
     *
     * @return The built multipart upload.
     * @since 2.61.0
     */
    public MultipartUpload build() {
      return new MultipartUpload(key, uploadId, storageClass, initiated);
    }
  }
}
