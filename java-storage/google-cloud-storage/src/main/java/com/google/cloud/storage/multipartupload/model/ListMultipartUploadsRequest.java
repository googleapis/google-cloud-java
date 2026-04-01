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
 * A request to list all multipart uploads in a bucket.
 *
 * @see <a href="https://cloud.google.com/storage/docs/multipart-uploads#listing-uploads">Listing
 *     multipart uploads</a>
 * @since 2.61.0
 */
public final class ListMultipartUploadsRequest {

  private final String bucket;
  private final String delimiter;
  private final String encodingType;
  private final String keyMarker;
  private final Integer maxUploads;
  private final String prefix;
  private final String uploadIdMarker;
  private final String userProject;

  private ListMultipartUploadsRequest(
      String bucket,
      String delimiter,
      String encodingType,
      String keyMarker,
      Integer maxUploads,
      String prefix,
      String uploadIdMarker,
      String userProject) {
    this.bucket = bucket;
    this.delimiter = delimiter;
    this.encodingType = encodingType;
    this.keyMarker = keyMarker;
    this.maxUploads = maxUploads;
    this.prefix = prefix;
    this.uploadIdMarker = uploadIdMarker;
    this.userProject = userProject;
  }

  /**
   * The bucket to list multipart uploads from.
   *
   * @return The bucket name.
   * @since 2.61.0
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Character used to group keys.
   *
   * @return The delimiter.
   * @since 2.61.0
   */
  public String delimiter() {
    return delimiter;
  }

  /**
   * The encoding type used by Cloud Storage to encode object names in the response.
   *
   * @return The encoding type.
   * @since 2.61.0
   */
  public String encodingType() {
    return encodingType;
  }

  /**
   * Together with {@code upload-id-marker}, specifies the multipart upload after which listing
   * should begin.
   *
   * @return The key marker.
   * @since 2.61.0
   */
  public String keyMarker() {
    return keyMarker;
  }

  /**
   * The maximum number of multipart uploads to return.
   *
   * @return The maximum number of uploads.
   * @since 2.61.0
   */
  public Integer maxUploads() {
    return maxUploads;
  }

  /**
   * Filters results to multipart uploads whose keys begin with this prefix.
   *
   * @return The prefix.
   * @since 2.61.0
   */
  public String prefix() {
    return prefix;
  }

  /**
   * Together with {@code key-marker}, specifies the multipart upload after which listing should
   * begin.
   *
   * @return The upload ID marker.
   * @since 2.61.0
   */
  public String uploadIdMarker() {
    return uploadIdMarker;
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListMultipartUploadsRequest that = (ListMultipartUploadsRequest) o;
    return Objects.equals(bucket, that.bucket)
        && Objects.equals(delimiter, that.delimiter)
        && Objects.equals(encodingType, that.encodingType)
        && Objects.equals(keyMarker, that.keyMarker)
        && Objects.equals(maxUploads, that.maxUploads)
        && Objects.equals(prefix, that.prefix)
        && Objects.equals(uploadIdMarker, that.uploadIdMarker)
        && Objects.equals(userProject, that.userProject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        bucket,
        delimiter,
        encodingType,
        keyMarker,
        maxUploads,
        prefix,
        uploadIdMarker,
        userProject);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket)
        .add("delimiter", delimiter)
        .add("encodingType", encodingType)
        .add("keyMarker", keyMarker)
        .add("maxUploads", maxUploads)
        .add("prefix", prefix)
        .add("uploadIdMarker", uploadIdMarker)
        .add("userProject", userProject)
        .toString();
  }

  /**
   * Returns a new builder for this request.
   *
   * @return A new builder.
   * @since 2.61.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * A builder for {@link ListMultipartUploadsRequest}.
   *
   * @since 2.61.0
   */
  public static final class Builder {
    private String bucket;
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private Integer maxUploads;
    private String prefix;
    private String uploadIdMarker;
    private String userProject;

    private Builder() {}

    /**
     * Sets the bucket to list multipart uploads from.
     *
     * @param bucket The bucket name.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Sets the delimiter used to group keys.
     *
     * @param delimiter The delimiter.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder delimiter(String delimiter) {
      this.delimiter = delimiter;
      return this;
    }

    /**
     * Sets the encoding type used by Cloud Storage to encode object names in the response.
     *
     * @param encodingType The encoding type.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder encodingType(String encodingType) {
      this.encodingType = encodingType;
      return this;
    }

    /**
     * Sets the key marker.
     *
     * @param keyMarker The key marker.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder keyMarker(String keyMarker) {
      this.keyMarker = keyMarker;
      return this;
    }

    /**
     * Sets the maximum number of multipart uploads to return.
     *
     * @param maxUploads The maximum number of uploads.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder maxUploads(Integer maxUploads) {
      this.maxUploads = maxUploads;
      return this;
    }

    /**
     * Sets the prefix to filter results.
     *
     * @param prefix The prefix.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder prefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    /**
     * Sets the upload ID marker.
     *
     * @param uploadIdMarker The upload ID marker.
     * @return This builder.
     * @since 2.61.0
     */
    public Builder uploadIdMarker(String uploadIdMarker) {
      this.uploadIdMarker = uploadIdMarker;
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
     * Builds the request.
     *
     * @return The built request.
     * @since 2.61.0
     */
    public ListMultipartUploadsRequest build() {
      return new ListMultipartUploadsRequest(
          bucket,
          delimiter,
          encodingType,
          keyMarker,
          maxUploads,
          prefix,
          uploadIdMarker,
          userProject);
    }
  }
}
