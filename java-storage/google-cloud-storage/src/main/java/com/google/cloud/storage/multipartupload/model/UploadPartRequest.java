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

import com.google.common.base.MoreObjects;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An object to represent an upload part request. An upload part request is used to upload a single
 * part of a multipart upload.
 *
 * @since 2.60.0
 */
public final class UploadPartRequest {

  private final String bucket;
  private final String key;
  private final int partNumber;
  private final String uploadId;
  @Nullable private final String crc32c;
  private final String userProject;

  private UploadPartRequest(Builder builder) {
    this.bucket = builder.bucket;
    this.key = builder.key;
    this.partNumber = builder.partNumber;
    this.uploadId = builder.uploadId;
    this.crc32c = builder.crc32c;
    this.userProject = builder.userProject;
  }

  /**
   * Returns the bucket to upload the part to.
   *
   * @return The bucket to upload the part to.
   * @since 2.60.0
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Returns the key of the object to upload the part to.
   *
   * @return The key of the object to upload the part to.
   * @since 2.60.0
   */
  public String key() {
    return key;
  }

  /**
   * Returns the part number of the part to upload.
   *
   * @return The part number of the part to upload.
   * @since 2.60.0
   */
  public int partNumber() {
    return partNumber;
  }

  /**
   * Returns the upload ID of the multipart upload.
   *
   * @return The upload ID of the multipart upload.
   * @since 2.60.0
   */
  public String uploadId() {
    return uploadId;
  }

  /**
   * Returns the CRC32C checksum of the part to upload.
   *
   * @return The CRC32C checksum of the part to upload.
   * @since 2.61.0
   */
  @Nullable
  public String crc32c() {
    return crc32c;
  }

  /**
   * Returns the user-project.
   *
   * @return the user-project.
   * @see <a
   *     href="https://docs.cloud.google.com/storage/docs/xml-api/reference-headers#xgooguserproject">x-goog-user-project</a>
   * @since 2.61.0
   */
  public String userProject() {
    return userProject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UploadPartRequest)) {
      return false;
    }
    UploadPartRequest that = (UploadPartRequest) o;
    return partNumber == that.partNumber
        && Objects.equals(bucket, that.bucket)
        && Objects.equals(key, that.key)
        && Objects.equals(uploadId, that.uploadId)
        && Objects.equals(crc32c, that.crc32c)
        && Objects.equals(userProject, that.userProject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket, key, partNumber, uploadId, crc32c, userProject);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket)
        .add("key", key)
        .add("partNumber", partNumber)
        .add("uploadId", uploadId)
        .add("crc32c", crc32c)
        .add("userProject", userProject)
        .toString();
  }

  /**
   * Returns a new builder for an {@link UploadPartRequest}.
   *
   * @return A new builder.
   * @since 2.60.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * A builder for {@link UploadPartRequest}.
   *
   * @since 2.60.0
   */
  public static class Builder {
    private String bucket;
    private String key;
    private int partNumber;
    private String uploadId;
    @Nullable private String crc32c;
    private String userProject;

    private Builder() {}

    /**
     * Sets the bucket to upload the part to.
     *
     * @param bucket The bucket to upload the part to.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Sets the key of the object to upload the part to.
     *
     * @param key The key of the object to upload the part to.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Sets the part number of the part to upload.
     *
     * @param partNumber The part number of the part to upload.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder partNumber(int partNumber) {
      this.partNumber = partNumber;
      return this;
    }

    /**
     * Sets the upload ID of the multipart upload.
     *
     * @param uploadId The upload ID of the multipart upload.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder uploadId(String uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    /**
     * Sets the CRC32C checksum of the part to upload.
     *
     * @param crc32c The CRC32C checksum of the part to upload.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder crc32c(@Nullable String crc32c) {
      this.crc32c = crc32c;
      return this;
    }

    /**
     * Sets the user-project.
     *
     * @param userProject The user-project.
     * @return This builder.
     * @see <a
     *     href="https://docs.cloud.google.com/storage/docs/xml-api/reference-headers#xgooguserproject">x-goog-user-project</a>
     * @since 2.61.0
     */
    public Builder userProject(String userProject) {
      this.userProject = userProject;
      return this;
    }

    /**
     * Builds the {@link UploadPartRequest}.
     *
     * @return The built {@link UploadPartRequest}.
     * @since 2.60.0
     */
    public UploadPartRequest build() {
      return new UploadPartRequest(this);
    }
  }
}
