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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A response from listing all multipart uploads in a bucket.
 *
 * @see <a href="https://cloud.google.com/storage/docs/multipart-uploads#listing-uploads">Listing
 *     multipart uploads</a>
 * @since 2.60.1
 */
public final class ListMultipartUploadsResponse {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "Upload")
  private List<MultipartUpload> uploads;

  @JacksonXmlProperty(localName = "Bucket")
  private String bucket;

  @JacksonXmlProperty(localName = "Delimiter")
  private String delimiter;

  @JacksonXmlProperty(localName = "EncodingType")
  private String encodingType;

  @JacksonXmlProperty(localName = "KeyMarker")
  private String keyMarker;

  @JacksonXmlProperty(localName = "UploadIdMarker")
  private String uploadIdMarker;

  @JacksonXmlProperty(localName = "NextKeyMarker")
  private String nextKeyMarker;

  @JacksonXmlProperty(localName = "NextUploadIdMarker")
  private String nextUploadIdMarker;

  @JacksonXmlProperty(localName = "MaxUploads")
  private int maxUploads;

  @JacksonXmlProperty(localName = "Prefix")
  private String prefix;

  @JsonAlias("truncated")
  @JacksonXmlProperty(localName = "IsTruncated")
  private boolean isTruncated;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "CommonPrefixes")
  private List<CommonPrefixHelper> commonPrefixes;

  // Jackson requires a no-arg constructor
  private ListMultipartUploadsResponse() {}

  private ListMultipartUploadsResponse(
      List<MultipartUpload> uploads,
      String bucket,
      String delimiter,
      String encodingType,
      String keyMarker,
      String uploadIdMarker,
      String nextKeyMarker,
      String nextUploadIdMarker,
      int maxUploads,
      String prefix,
      boolean isTruncated,
      List<String> commonPrefixes) {
    this.uploads = uploads;
    this.bucket = bucket;
    this.delimiter = delimiter;
    this.encodingType = encodingType;
    this.keyMarker = keyMarker;
    this.uploadIdMarker = uploadIdMarker;
    this.nextKeyMarker = nextKeyMarker;
    this.nextUploadIdMarker = nextUploadIdMarker;
    this.maxUploads = maxUploads;
    this.prefix = prefix;
    this.isTruncated = isTruncated;
    if (commonPrefixes != null) {
      this.commonPrefixes = new ArrayList<>();
      for (String p : commonPrefixes) {
        CommonPrefixHelper h = new CommonPrefixHelper();
        h.prefix = p;
        this.commonPrefixes.add(h);
      }
    }
  }

  /**
   * The list of multipart uploads.
   *
   * @return The list of multipart uploads.
   * @since 2.61.0
   */
  public ImmutableList<MultipartUpload> uploads() {
    return uploads == null ? ImmutableList.of() : ImmutableList.copyOf(uploads);
  }

  /**
   * The bucket that contains the multipart uploads.
   *
   * @return The bucket name.
   * @since 2.61.0
   */
  public String bucket() {
    return bucket;
  }

  /**
   * The delimiter applied to the request.
   *
   * @return The delimiter applied to the request.
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
   * The key at or after which the listing began.
   *
   * @return The key marker.
   * @since 2.61.0
   */
  public String keyMarker() {
    return keyMarker;
  }

  /**
   * The upload ID at or after which the listing began.
   *
   * @return The upload ID marker.
   * @since 2.61.0
   */
  public String uploadIdMarker() {
    return uploadIdMarker;
  }

  /**
   * The key after which listing should begin.
   *
   * @return The key after which listing should begin.
   * @since 2.61.0
   */
  public String nextKeyMarker() {
    return nextKeyMarker;
  }

  /**
   * The upload ID after which listing should begin.
   *
   * @return The upload ID after which listing should begin.
   * @since 2.61.0
   */
  public String nextUploadIdMarker() {
    return nextUploadIdMarker;
  }

  /**
   * The maximum number of uploads to return.
   *
   * @return The maximum number of uploads.
   * @since 2.61.0
   */
  public int maxUploads() {
    return maxUploads;
  }

  /**
   * The prefix applied to the request.
   *
   * @return The prefix applied to the request.
   * @since 2.61.0
   */
  public String prefix() {
    return prefix;
  }

  /**
   * A flag indicating whether or not the returned results are truncated.
   *
   * @return A flag indicating whether or not the returned results are truncated.
   * @since 2.61.0
   */
  public boolean truncated() {
    return isTruncated;
  }

  /**
   * If you specify a delimiter in the request, this element is returned.
   *
   * @return The common prefixes.
   * @since 2.61.0
   */
  public ImmutableList<String> commonPrefixes() {
    if (commonPrefixes == null) {
      return ImmutableList.of();
    }
    return commonPrefixes.stream().map(h -> h.prefix).collect(ImmutableList.toImmutableList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListMultipartUploadsResponse that = (ListMultipartUploadsResponse) o;
    return isTruncated == that.isTruncated
        && maxUploads == that.maxUploads
        && Objects.equals(uploads(), that.uploads())
        && Objects.equals(bucket, that.bucket)
        && Objects.equals(delimiter, that.delimiter)
        && Objects.equals(encodingType, that.encodingType)
        && Objects.equals(keyMarker, that.keyMarker)
        && Objects.equals(uploadIdMarker, that.uploadIdMarker)
        && Objects.equals(nextKeyMarker, that.nextKeyMarker)
        && Objects.equals(nextUploadIdMarker, that.nextUploadIdMarker)
        && Objects.equals(prefix, that.prefix)
        && Objects.equals(commonPrefixes(), that.commonPrefixes());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        uploads(),
        bucket,
        delimiter,
        encodingType,
        keyMarker,
        uploadIdMarker,
        nextKeyMarker,
        nextUploadIdMarker,
        maxUploads,
        prefix,
        isTruncated,
        commonPrefixes());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("uploads", uploads())
        .add("bucket", bucket)
        .add("delimiter", delimiter)
        .add("encodingType", encodingType)
        .add("keyMarker", keyMarker)
        .add("uploadIdMarker", uploadIdMarker)
        .add("nextKeyMarker", nextKeyMarker)
        .add("nextUploadIdMarker", nextUploadIdMarker)
        .add("maxUploads", maxUploads)
        .add("prefix", prefix)
        .add("isTruncated", isTruncated)
        .add("commonPrefixes", commonPrefixes())
        .toString();
  }

  /**
   * Returns a new builder for this response.
   *
   * @return A new builder.
   * @since 2.61.0
   */
  public static Builder builder() {
    return new Builder();
  }

  static class CommonPrefixHelper {
    @JacksonXmlProperty(localName = "Prefix")
    public String prefix;
  }

  /**
   * A builder for {@link ListMultipartUploadsResponse}.
   *
   * @since 2.61.0
   */
  public static final class Builder {
    private ImmutableList<MultipartUpload> uploads;
    private String bucket;
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private String uploadIdMarker;
    private String nextKeyMarker;
    private String nextUploadIdMarker;
    private int maxUploads;
    private String prefix;
    private boolean isTruncated;
    private ImmutableList<String> commonPrefixes;

    private Builder() {}

    /**
     * Sets the list of multipart uploads.
     *
     * @param uploads The list of multipart uploads.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder uploads(ImmutableList<MultipartUpload> uploads) {
      this.uploads = uploads;
      return this;
    }

    /**
     * Sets the bucket that contains the multipart uploads.
     *
     * @param bucket The bucket name.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Sets the delimiter applied to the request.
     *
     * @param delimiter The delimiter applied to the request.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
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
     * @since 2.61.0 This new api is in preview.
     */
    public Builder encodingType(String encodingType) {
      this.encodingType = encodingType;
      return this;
    }

    /**
     * Sets the key at or after which the listing began.
     *
     * @param keyMarker The key marker.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder keyMarker(String keyMarker) {
      this.keyMarker = keyMarker;
      return this;
    }

    /**
     * Sets the upload ID at or after which the listing began.
     *
     * @param uploadIdMarker The upload ID marker.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder uploadIdMarker(String uploadIdMarker) {
      this.uploadIdMarker = uploadIdMarker;
      return this;
    }

    /**
     * Sets the key after which listing should begin.
     *
     * @param nextKeyMarker The key after which listing should begin.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder nextKeyMarker(String nextKeyMarker) {
      this.nextKeyMarker = nextKeyMarker;
      return this;
    }

    /**
     * Sets the upload ID after which listing should begin.
     *
     * @param nextUploadIdMarker The upload ID after which listing should begin.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder nextUploadIdMarker(String nextUploadIdMarker) {
      this.nextUploadIdMarker = nextUploadIdMarker;
      return this;
    }

    /**
     * Sets the maximum number of uploads to return.
     *
     * @param maxUploads The maximum number of uploads.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder maxUploads(int maxUploads) {
      this.maxUploads = maxUploads;
      return this;
    }

    /**
     * Sets the prefix applied to the request.
     *
     * @param prefix The prefix applied to the request.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder prefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    /**
     * Sets the flag indicating whether or not the returned results are truncated.
     *
     * @param isTruncated The flag indicating whether or not the returned results are truncated.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder truncated(boolean isTruncated) {
      this.isTruncated = isTruncated;
      return this;
    }

    /**
     * If you specify a delimiter in the request, this element is returned.
     *
     * @param commonPrefixes The common prefixes.
     * @return This builder.
     * @since 2.61.0 This new api is in preview.
     */
    public Builder commonPrefixes(ImmutableList<String> commonPrefixes) {
      this.commonPrefixes = commonPrefixes;
      return this;
    }

    /**
     * Builds the response.
     *
     * @return The built response.
     * @since 2.61.0
     */
    public ListMultipartUploadsResponse build() {
      return new ListMultipartUploadsResponse(
          uploads,
          bucket,
          delimiter,
          encodingType,
          keyMarker,
          uploadIdMarker,
          nextKeyMarker,
          nextUploadIdMarker,
          maxUploads,
          prefix,
          isTruncated,
          commonPrefixes);
    }
  }
}
