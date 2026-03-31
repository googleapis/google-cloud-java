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
import com.google.common.base.MoreObjects;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a part of a multipart upload.
 *
 * @since 2.60.0
 */
public final class Part {

  @JacksonXmlProperty(localName = "PartNumber")
  private int partNumber;

  @JacksonXmlProperty(localName = "ETag")
  private String eTag;

  @JacksonXmlProperty(localName = "Size")
  private long size;

  @JacksonXmlProperty(localName = "LastModified")
  private OffsetDateTime lastModified;

  // for jackson
  private Part() {}

  private Part(Builder builder) {
    this.partNumber = builder.partNumber;
    this.eTag = builder.eTag;
    this.size = builder.size;
    this.lastModified = builder.lastModified;
  }

  /**
   * Returns the part number.
   *
   * @return the part number.
   * @since 2.60.0
   */
  public int partNumber() {
    return partNumber;
  }

  /**
   * Returns the ETag of the part.
   *
   * @return the ETag of the part.
   * @since 2.60.0
   */
  public String eTag() {
    return eTag;
  }

  /**
   * Returns the size of the part.
   *
   * @return the size of the part.
   * @since 2.60.0
   */
  public long size() {
    return size;
  }

  /**
   * Returns the last modified time of the part.
   *
   * @return the last modified time of the part.
   * @since 2.60.0
   */
  public OffsetDateTime lastModified() {
    return lastModified;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Part)) {
      return false;
    }
    Part that = (Part) o;
    return Objects.equals(partNumber, that.partNumber)
        && Objects.equals(eTag, that.eTag)
        && Objects.equals(size, that.size)
        && Objects.equals(lastModified, that.lastModified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partNumber, eTag, size, lastModified);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("partNumber", partNumber)
        .add("eTag", eTag)
        .add("size", size)
        .add("lastModified", lastModified)
        .toString();
  }

  /**
   * A builder for {@link Part}.
   *
   * @since 2.60.0
   */
  public static final class Builder {
    private int partNumber;
    private String eTag;
    private long size;
    private OffsetDateTime lastModified;

    private Builder() {}

    /**
     * Sets the part number.
     *
     * @param partNumber the part number.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder partNumber(int partNumber) {
      this.partNumber = partNumber;
      return this;
    }

    /**
     * Sets the ETag of the part.
     *
     * @param eTag the ETag of the part.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder eTag(String eTag) {
      this.eTag = eTag;
      return this;
    }

    /**
     * Sets the size of the part.
     *
     * @param size the size of the part.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder size(long size) {
      this.size = size;
      return this;
    }

    /**
     * Sets the last modified time of the part.
     *
     * @param lastModified the last modified time of the part.
     * @return this builder.
     * @since 2.60.0
     */
    public Builder lastModified(OffsetDateTime lastModified) {
      this.lastModified = lastModified;
      return this;
    }

    /**
     * Builds a new {@link Part} object.
     *
     * @return a new {@link Part} object.
     * @since 2.60.0
     */
    public Part build() {
      return new Part(this);
    }
  }
}
