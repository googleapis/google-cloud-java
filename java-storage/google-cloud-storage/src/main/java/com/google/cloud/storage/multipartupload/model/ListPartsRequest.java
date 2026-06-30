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
 * Represents a request to list the parts of a multipart upload.
 *
 * @since 2.60.0
 */
public final class ListPartsRequest {
  private final String bucket;

  private final String key;

  private final String uploadId;

  private final Integer maxParts;

  private final Integer partNumberMarker;

  private final String userProject;

  private ListPartsRequest(Builder builder) {
    this.bucket = builder.bucket;
    this.key = builder.key;
    this.uploadId = builder.uploadId;
    this.maxParts = builder.maxParts;
    this.partNumberMarker = builder.partNumberMarker;
    this.userProject = builder.userProject;
  }

  /**
   * Returns the bucket name.
   *
   * @return the bucket name.
   * @since 2.60.0
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Returns the object name.
   *
   * @return the object name.
   * @since 2.60.0
   */
  public String key() {
    return key;
  }

  /**
   * Returns the upload ID.
   *
   * @return the upload ID.
   * @since 2.60.0
   */
  public String uploadId() {
    return uploadId;
  }

  /**
   * Returns the maximum number of parts to return.
   *
   * @return the maximum number of parts to return.
   * @since 2.60.0
   */
  public Integer maxParts() {
    return maxParts;
  }

  /**
   * Returns the part number marker.
   *
   * @return the part number marker.
   * @since 2.60.0
   */
  public Integer partNumberMarker() {
    return partNumberMarker;
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
    if (!(o instanceof ListPartsRequest)) {
      return false;
    }
    ListPartsRequest that = (ListPartsRequest) o;
    return Objects.equals(bucket, that.bucket)
        && Objects.equals(key, that.key)
        && Objects.equals(uploadId, that.uploadId)
        && Objects.equals(maxParts, that.maxParts)
        && Objects.equals(partNumberMarker, that.partNumberMarker)
        && Objects.equals(userProject, that.userProject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket, key, uploadId, maxParts, partNumberMarker, userProject);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket)
        .add("key", key)
        .add("uploadId", uploadId)
        .add("maxParts", maxParts)
        .add("partNumberMarker", partNumberMarker)
        .add("userProject", userProject)
        .toString();
  }

  /**
   * Returns a new builder for this class.
   *
   * @return a new builder for this class.
   * @since 2.60.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * A builder for {@link ListPartsRequest}.
   *
   * @since 2.60.0
   */
  public static class Builder {
    private String bucket;
    private String key;
    private String uploadId;
    private Integer maxParts;
    private Integer partNumberMarker;
    private String userProject;

    private Builder() {}

    /**
     * Sets the bucket name.
     *
     * @param bucket the bucket name.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Sets the object name.
     *
     * @param key the object name.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Sets the upload ID.
     *
     * @param uploadId the upload ID.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder uploadId(String uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    /**
     * Sets the maximum number of parts to return.
     *
     * @param maxParts the maximum number of parts to return.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder maxParts(Integer maxParts) {
      this.maxParts = maxParts;
      return this;
    }

    /**
     * Sets the part number marker.
     *
     * @param partNumberMarker the part number marker.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder partNumberMarker(Integer partNumberMarker) {
      this.partNumberMarker = partNumberMarker;
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
     * Builds a new {@link ListPartsRequest} object.
     *
     * @return a new {@link ListPartsRequest} object.
     * @since 2.60.0
     */
    public ListPartsRequest build() {
      return new ListPartsRequest(this);
    }
  }
}
