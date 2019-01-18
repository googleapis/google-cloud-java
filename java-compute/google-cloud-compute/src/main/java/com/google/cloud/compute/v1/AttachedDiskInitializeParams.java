/*
 * Copyright 2019 Google LLC
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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class AttachedDiskInitializeParams implements ApiMessage {
  private final String description;
  private final String diskName;
  private final String diskSizeGb;
  private final String diskType;
  private final Map<String, String> labels;
  private final String sourceImage;
  private final CustomerEncryptionKey sourceImageEncryptionKey;

  private AttachedDiskInitializeParams() {
    this.description = null;
    this.diskName = null;
    this.diskSizeGb = null;
    this.diskType = null;
    this.labels = null;
    this.sourceImage = null;
    this.sourceImageEncryptionKey = null;
  }

  private AttachedDiskInitializeParams(
      String description,
      String diskName,
      String diskSizeGb,
      String diskType,
      Map<String, String> labels,
      String sourceImage,
      CustomerEncryptionKey sourceImageEncryptionKey) {
    this.description = description;
    this.diskName = diskName;
    this.diskSizeGb = diskSizeGb;
    this.diskType = diskType;
    this.labels = labels;
    this.sourceImage = sourceImage;
    this.sourceImageEncryptionKey = sourceImageEncryptionKey;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("diskName".equals(fieldName)) {
      return diskName;
    }
    if ("diskSizeGb".equals(fieldName)) {
      return diskSizeGb;
    }
    if ("diskType".equals(fieldName)) {
      return diskType;
    }
    if ("labels".equals(fieldName)) {
      return labels;
    }
    if ("sourceImage".equals(fieldName)) {
      return sourceImage;
    }
    if ("sourceImageEncryptionKey".equals(fieldName)) {
      return sourceImageEncryptionKey;
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getDescription() {
    return description;
  }

  public String getDiskName() {
    return diskName;
  }

  public String getDiskSizeGb() {
    return diskSizeGb;
  }

  public String getDiskType() {
    return diskType;
  }

  public Map<String, String> getLabelsMap() {
    return labels;
  }

  public String getSourceImage() {
    return sourceImage;
  }

  public CustomerEncryptionKey getSourceImageEncryptionKey() {
    return sourceImageEncryptionKey;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AttachedDiskInitializeParams prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AttachedDiskInitializeParams getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AttachedDiskInitializeParams DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AttachedDiskInitializeParams();
  }

  public static class Builder {
    private String description;
    private String diskName;
    private String diskSizeGb;
    private String diskType;
    private Map<String, String> labels;
    private String sourceImage;
    private CustomerEncryptionKey sourceImageEncryptionKey;

    Builder() {}

    public Builder mergeFrom(AttachedDiskInitializeParams other) {
      if (other == AttachedDiskInitializeParams.getDefaultInstance()) return this;
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDiskName() != null) {
        this.diskName = other.diskName;
      }
      if (other.getDiskSizeGb() != null) {
        this.diskSizeGb = other.diskSizeGb;
      }
      if (other.getDiskType() != null) {
        this.diskType = other.diskType;
      }
      if (other.getLabelsMap() != null) {
        this.labels = other.labels;
      }
      if (other.getSourceImage() != null) {
        this.sourceImage = other.sourceImage;
      }
      if (other.getSourceImageEncryptionKey() != null) {
        this.sourceImageEncryptionKey = other.sourceImageEncryptionKey;
      }
      return this;
    }

    Builder(AttachedDiskInitializeParams source) {
      this.description = source.description;
      this.diskName = source.diskName;
      this.diskSizeGb = source.diskSizeGb;
      this.diskType = source.diskType;
      this.labels = source.labels;
      this.sourceImage = source.sourceImage;
      this.sourceImageEncryptionKey = source.sourceImageEncryptionKey;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getDiskName() {
      return diskName;
    }

    public Builder setDiskName(String diskName) {
      this.diskName = diskName;
      return this;
    }

    public String getDiskSizeGb() {
      return diskSizeGb;
    }

    public Builder setDiskSizeGb(String diskSizeGb) {
      this.diskSizeGb = diskSizeGb;
      return this;
    }

    public String getDiskType() {
      return diskType;
    }

    public Builder setDiskType(String diskType) {
      this.diskType = diskType;
      return this;
    }

    public Map<String, String> getLabelsMap() {
      return labels;
    }

    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    public String getSourceImage() {
      return sourceImage;
    }

    public Builder setSourceImage(String sourceImage) {
      this.sourceImage = sourceImage;
      return this;
    }

    public CustomerEncryptionKey getSourceImageEncryptionKey() {
      return sourceImageEncryptionKey;
    }

    public Builder setSourceImageEncryptionKey(CustomerEncryptionKey sourceImageEncryptionKey) {
      this.sourceImageEncryptionKey = sourceImageEncryptionKey;
      return this;
    }

    public AttachedDiskInitializeParams build() {

      return new AttachedDiskInitializeParams(
          description,
          diskName,
          diskSizeGb,
          diskType,
          labels,
          sourceImage,
          sourceImageEncryptionKey);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDescription(this.description);
      newBuilder.setDiskName(this.diskName);
      newBuilder.setDiskSizeGb(this.diskSizeGb);
      newBuilder.setDiskType(this.diskType);
      newBuilder.putAllLabels(this.labels);
      newBuilder.setSourceImage(this.sourceImage);
      newBuilder.setSourceImageEncryptionKey(this.sourceImageEncryptionKey);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AttachedDiskInitializeParams{"
        + "description="
        + description
        + ", "
        + "diskName="
        + diskName
        + ", "
        + "diskSizeGb="
        + diskSizeGb
        + ", "
        + "diskType="
        + diskType
        + ", "
        + "labels="
        + labels
        + ", "
        + "sourceImage="
        + sourceImage
        + ", "
        + "sourceImageEncryptionKey="
        + sourceImageEncryptionKey
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AttachedDiskInitializeParams) {
      AttachedDiskInitializeParams that = (AttachedDiskInitializeParams) o;
      return Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.diskName, that.getDiskName())
          && Objects.equals(this.diskSizeGb, that.getDiskSizeGb())
          && Objects.equals(this.diskType, that.getDiskType())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.sourceImage, that.getSourceImage())
          && Objects.equals(this.sourceImageEncryptionKey, that.getSourceImageEncryptionKey());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        description, diskName, diskSizeGb, diskType, labels, sourceImage, sourceImageEncryptionKey);
  }
}
