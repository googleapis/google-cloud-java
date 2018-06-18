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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class DiskInstantiationConfig implements ApiMessage {
  private final Boolean autoDelete;
  private final String customImage;
  private final String deviceName;
  private final String instantiateFrom;

  private DiskInstantiationConfig() {
    this.autoDelete = null;
    this.customImage = null;
    this.deviceName = null;
    this.instantiateFrom = null;
  }

  private DiskInstantiationConfig(
      Boolean autoDelete, String customImage, String deviceName, String instantiateFrom) {
    this.autoDelete = autoDelete;
    this.customImage = customImage;
    this.deviceName = deviceName;
    this.instantiateFrom = instantiateFrom;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("autoDelete")) {
      return autoDelete;
    }
    if (fieldName.equals("customImage")) {
      return customImage;
    }
    if (fieldName.equals("deviceName")) {
      return deviceName;
    }
    if (fieldName.equals("instantiateFrom")) {
      return instantiateFrom;
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

  public Boolean getAutoDelete() {
    return autoDelete;
  }

  public String getCustomImage() {
    return customImage;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public String getInstantiateFrom() {
    return instantiateFrom;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DiskInstantiationConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DiskInstantiationConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DiskInstantiationConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DiskInstantiationConfig();
  }

  public static class Builder {
    private Boolean autoDelete;
    private String customImage;
    private String deviceName;
    private String instantiateFrom;

    Builder() {}

    public Builder mergeFrom(DiskInstantiationConfig other) {
      if (other == DiskInstantiationConfig.getDefaultInstance()) return this;
      if (other.getAutoDelete() != null) {
        this.autoDelete = other.autoDelete;
      }
      if (other.getCustomImage() != null) {
        this.customImage = other.customImage;
      }
      if (other.getDeviceName() != null) {
        this.deviceName = other.deviceName;
      }
      if (other.getInstantiateFrom() != null) {
        this.instantiateFrom = other.instantiateFrom;
      }
      return this;
    }

    Builder(DiskInstantiationConfig source) {
      this.autoDelete = source.autoDelete;
      this.customImage = source.customImage;
      this.deviceName = source.deviceName;
      this.instantiateFrom = source.instantiateFrom;
    }

    public Boolean getAutoDelete() {
      return autoDelete;
    }

    public Builder setAutoDelete(Boolean autoDelete) {
      this.autoDelete = autoDelete;
      return this;
    }

    public String getCustomImage() {
      return customImage;
    }

    public Builder setCustomImage(String customImage) {
      this.customImage = customImage;
      return this;
    }

    public String getDeviceName() {
      return deviceName;
    }

    public Builder setDeviceName(String deviceName) {
      this.deviceName = deviceName;
      return this;
    }

    public String getInstantiateFrom() {
      return instantiateFrom;
    }

    public Builder setInstantiateFrom(String instantiateFrom) {
      this.instantiateFrom = instantiateFrom;
      return this;
    }

    public DiskInstantiationConfig build() {

      return new DiskInstantiationConfig(autoDelete, customImage, deviceName, instantiateFrom);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoDelete(this.autoDelete);
      newBuilder.setCustomImage(this.customImage);
      newBuilder.setDeviceName(this.deviceName);
      newBuilder.setInstantiateFrom(this.instantiateFrom);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DiskInstantiationConfig{"
        + "autoDelete="
        + autoDelete
        + ", "
        + "customImage="
        + customImage
        + ", "
        + "deviceName="
        + deviceName
        + ", "
        + "instantiateFrom="
        + instantiateFrom
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DiskInstantiationConfig) {
      DiskInstantiationConfig that = (DiskInstantiationConfig) o;
      return Objects.equals(this.autoDelete, that.getAutoDelete())
          && Objects.equals(this.customImage, that.getCustomImage())
          && Objects.equals(this.deviceName, that.getDeviceName())
          && Objects.equals(this.instantiateFrom, that.getInstantiateFrom());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoDelete, customImage, deviceName, instantiateFrom);
  }
}
