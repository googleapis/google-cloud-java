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

/**
 * Represents a request to complete a multipart upload.
 *
 * @since 2.60.0
 */
public final class CompleteMultipartUploadRequest {

  private final String bucket;
  private final String key;
  private final String uploadId;
  private final CompletedMultipartUpload multipartUpload;
  private final String userProject;

  private CompleteMultipartUploadRequest(Builder builder) {
    this.bucket = builder.bucket;
    this.key = builder.key;
    this.uploadId = builder.uploadId;
    this.multipartUpload = builder.multipartUpload;
    this.userProject = builder.userProject;
  }

  /**
   * Returns the bucket name.
   *
   * @return The bucket name.
   * @since 2.60.0
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Returns the object name.
   *
   * @return The object name.
   * @since 2.60.0
   */
  public String key() {
    return key;
  }

  /**
   * Returns the upload ID of the multipart upload.
   *
   * @return The upload ID.
   * @since 2.60.0
   */
  public String uploadId() {
    return uploadId;
  }

  /**
   * Returns the {@link CompletedMultipartUpload} payload for this request.
   *
   * @return The {@link CompletedMultipartUpload} payload.
   * @since 2.60.0
   */
  public CompletedMultipartUpload multipartUpload() {
    return multipartUpload;
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
    if (!(o instanceof CompleteMultipartUploadRequest)) {
      return false;
    }
    CompleteMultipartUploadRequest that = (CompleteMultipartUploadRequest) o;
    return Objects.equals(bucket, that.bucket)
        && Objects.equals(key, that.key)
        && Objects.equals(uploadId, that.uploadId)
        && Objects.equals(multipartUpload, that.multipartUpload)
        && Objects.equals(userProject, that.userProject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket, key, uploadId, multipartUpload, userProject);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket)
        .add("key", key)
        .add("uploadId", uploadId)
        .add("completedMultipartUpload", multipartUpload)
        .add("userProject", userProject)
        .toString();
  }

  /**
   * Creates a new builder for {@link CompleteMultipartUploadRequest}.
   *
   * @return A new builder.
   * @since 2.60.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder for {@link CompleteMultipartUploadRequest}.
   *
   * @since 2.60.0
   */
  public static class Builder {
    private String bucket;
    private String key;
    private String uploadId;
    private CompletedMultipartUpload multipartUpload;
    private String userProject;

    private Builder() {}

    /**
     * Sets the bucket name.
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
     * Sets the object name.
     *
     * @param key The object name.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Sets the upload ID of the multipart upload.
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
     * Sets the {@link CompletedMultipartUpload} payload for this request.
     *
     * @param completedMultipartUpload The {@link CompletedMultipartUpload} payload.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder multipartUpload(CompletedMultipartUpload completedMultipartUpload) {
      this.multipartUpload = completedMultipartUpload;
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
     * Builds the {@link CompleteMultipartUploadRequest} object.
     *
     * @return The new {@link CompleteMultipartUploadRequest} object.
     * @since 2.60.0
     */
    public CompleteMultipartUploadRequest build() {
      return new CompleteMultipartUploadRequest(this);
    }
  }
}
