/*
 * Copyright 2018 Google LLC
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class AttachedDiskInitializeParams implements ApiMessage {
  private final String diskName;
  private final String diskSizeGb;
  private final String diskType;
  private final String sourceImage;
  private final CustomerEncryptionKey sourceImageEncryptionKey;

  private AttachedDiskInitializeParams() {
    this.diskName = null;
    this.diskSizeGb = null;
    this.diskType = null;
    this.sourceImage = null;
    this.sourceImageEncryptionKey = null;
  }


  private AttachedDiskInitializeParams(
      String diskName,
      String diskSizeGb,
      String diskType,
      String sourceImage,
      CustomerEncryptionKey sourceImageEncryptionKey
      ) {
    this.diskName = diskName;
    this.diskSizeGb = diskSizeGb;
    this.diskType = diskType;
    this.sourceImage = sourceImage;
    this.sourceImageEncryptionKey = sourceImageEncryptionKey;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("diskName") && diskName != null) {
      fieldMap.put("diskName", Collections.singletonList(String.valueOf(diskName)));
    }
    if (fieldNames.contains("diskSizeGb") && diskSizeGb != null) {
      fieldMap.put("diskSizeGb", Collections.singletonList(String.valueOf(diskSizeGb)));
    }
    if (fieldNames.contains("diskType") && diskType != null) {
      fieldMap.put("diskType", Collections.singletonList(String.valueOf(diskType)));
    }
    if (fieldNames.contains("sourceImage") && sourceImage != null) {
      fieldMap.put("sourceImage", Collections.singletonList(String.valueOf(sourceImage)));
    }
    if (fieldNames.contains("sourceImageEncryptionKey") && sourceImageEncryptionKey != null) {
      fieldMap.put("sourceImageEncryptionKey", Collections.singletonList(String.valueOf(sourceImageEncryptionKey)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("diskName")) {
      return String.valueOf(diskName);
    }
    if (fieldName.equals("diskSizeGb")) {
      return String.valueOf(diskSizeGb);
    }
    if (fieldName.equals("diskType")) {
      return String.valueOf(diskType);
    }
    if (fieldName.equals("sourceImage")) {
      return String.valueOf(sourceImage);
    }
    if (fieldName.equals("sourceImageEncryptionKey")) {
      return String.valueOf(sourceImageEncryptionKey);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AttachedDiskInitializeParams getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final AttachedDiskInitializeParams DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AttachedDiskInitializeParams();
  }

  public static class Builder {
    private String diskName;
    private String diskSizeGb;
    private String diskType;
    private String sourceImage;
    private CustomerEncryptionKey sourceImageEncryptionKey;

    Builder() {}

    public Builder mergeFrom(AttachedDiskInitializeParams other) {
      if (other == AttachedDiskInitializeParams.getDefaultInstance()) return this;
      if (other.getDiskName() != null) {
        this.diskName = other.diskName;
      }
      if (other.getDiskSizeGb() != null) {
        this.diskSizeGb = other.diskSizeGb;
      }
      if (other.getDiskType() != null) {
        this.diskType = other.diskType;
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
      this.diskName = source.diskName;
      this.diskSizeGb = source.diskSizeGb;
      this.diskType = source.diskType;
      this.sourceImage = source.sourceImage;
      this.sourceImageEncryptionKey = source.sourceImageEncryptionKey;
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
        diskName,
        diskSizeGb,
        diskType,
        sourceImage,
        sourceImageEncryptionKey
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDiskName(this.diskName);
      newBuilder.setDiskSizeGb(this.diskSizeGb);
      newBuilder.setDiskType(this.diskType);
      newBuilder.setSourceImage(this.sourceImage);
      newBuilder.setSourceImageEncryptionKey(this.sourceImageEncryptionKey);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AttachedDiskInitializeParams{"
        + "diskName=" + diskName + ", "
        + "diskSizeGb=" + diskSizeGb + ", "
        + "diskType=" + diskType + ", "
        + "sourceImage=" + sourceImage + ", "
        + "sourceImageEncryptionKey=" + sourceImageEncryptionKey
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AttachedDiskInitializeParams) {
      AttachedDiskInitializeParams that = (AttachedDiskInitializeParams) o;
      return
          Objects.equals(this.diskName, that.getDiskName()) &&
          Objects.equals(this.diskSizeGb, that.getDiskSizeGb()) &&
          Objects.equals(this.diskType, that.getDiskType()) &&
          Objects.equals(this.sourceImage, that.getSourceImage()) &&
          Objects.equals(this.sourceImageEncryptionKey, that.getSourceImageEncryptionKey())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      diskName,
      diskSizeGb,
      diskType,
      sourceImage,
      sourceImageEncryptionKey
    );
  }
}
