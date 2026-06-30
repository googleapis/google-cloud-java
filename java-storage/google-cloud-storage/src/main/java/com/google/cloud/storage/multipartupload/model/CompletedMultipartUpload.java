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

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.Objects;

/**
 * Represents the XML payload for a completed multipart upload. This is used in the request body
 * when completing a multipart upload.
 *
 * @since 2.60.0 This new api is in preview and is subject to breaking changes.
 */
@JacksonXmlRootElement(localName = "CompleteMultipartUpload")
public class CompletedMultipartUpload {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "Part")
  private final List<CompletedPart> completedPartList;

  private CompletedMultipartUpload(Builder builder) {
    this.completedPartList = builder.parts;
  }

  /**
   * Returns the list of completed parts for this multipart upload.
   *
   * @return The list of completed parts.
   * @since 2.60.0
   */
  public List<CompletedPart> parts() {
    return completedPartList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CompletedMultipartUpload)) {
      return false;
    }
    CompletedMultipartUpload that = (CompletedMultipartUpload) o;
    return Objects.equals(completedPartList, that.completedPartList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completedPartList);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("completedPartList", completedPartList).toString();
  }

  /**
   * Creates a new builder for {@link CompletedMultipartUpload}.
   *
   * @return A new builder.
   * @since 2.60.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder for {@link CompletedMultipartUpload}.
   *
   * @since 2.60.0
   */
  public static class Builder {
    private List<CompletedPart> parts;

    private Builder() {}

    /**
     * Sets the list of completed parts for the multipart upload.
     *
     * @param completedPartList The list of completed parts.
     * @return This builder.
     * @since 2.60.0
     */
    public Builder parts(List<CompletedPart> completedPartList) {
      this.parts = completedPartList;
      return this;
    }

    /**
     * Builds the {@link CompletedMultipartUpload} object.
     *
     * @return The new {@link CompletedMultipartUpload} object.
     * @since 2.60.0
     */
    public CompletedMultipartUpload build() {
      return new CompletedMultipartUpload(this);
    }
  }
}
