/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class FileContentBuffer implements ApiMessage {
  private final String content;
  private final String fileType;

  private FileContentBuffer() {
    this.content = null;
    this.fileType = null;
  }

  private FileContentBuffer(String content, String fileType) {
    this.content = content;
    this.fileType = fileType;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("content".equals(fieldName)) {
      return content;
    }
    if ("fileType".equals(fieldName)) {
      return fileType;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** The raw content in the secure keys file. */
  public String getContent() {
    return content;
  }

  public String getFileType() {
    return fileType;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(FileContentBuffer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static FileContentBuffer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final FileContentBuffer DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new FileContentBuffer();
  }

  public static class Builder {
    private String content;
    private String fileType;

    Builder() {}

    public Builder mergeFrom(FileContentBuffer other) {
      if (other == FileContentBuffer.getDefaultInstance()) return this;
      if (other.getContent() != null) {
        this.content = other.content;
      }
      if (other.getFileType() != null) {
        this.fileType = other.fileType;
      }
      return this;
    }

    Builder(FileContentBuffer source) {
      this.content = source.content;
      this.fileType = source.fileType;
    }

    /** The raw content in the secure keys file. */
    public String getContent() {
      return content;
    }

    /** The raw content in the secure keys file. */
    public Builder setContent(String content) {
      this.content = content;
      return this;
    }

    public String getFileType() {
      return fileType;
    }

    public Builder setFileType(String fileType) {
      this.fileType = fileType;
      return this;
    }

    public FileContentBuffer build() {

      return new FileContentBuffer(content, fileType);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setContent(this.content);
      newBuilder.setFileType(this.fileType);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "FileContentBuffer{" + "content=" + content + ", " + "fileType=" + fileType + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FileContentBuffer) {
      FileContentBuffer that = (FileContentBuffer) o;
      return Objects.equals(this.content, that.getContent())
          && Objects.equals(this.fileType, that.getFileType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, fileType);
  }
}
