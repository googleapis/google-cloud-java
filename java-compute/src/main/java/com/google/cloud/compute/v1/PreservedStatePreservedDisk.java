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
public final class PreservedStatePreservedDisk implements ApiMessage {
  private final String autoDelete;
  private final String mode;
  private final String source;

  private PreservedStatePreservedDisk() {
    this.autoDelete = null;
    this.mode = null;
    this.source = null;
  }

  private PreservedStatePreservedDisk(String autoDelete, String mode, String source) {
    this.autoDelete = autoDelete;
    this.mode = mode;
    this.source = source;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoDelete".equals(fieldName)) {
      return autoDelete;
    }
    if ("mode".equals(fieldName)) {
      return mode;
    }
    if ("source".equals(fieldName)) {
      return source;
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

  /**
   * These stateful disks will never be deleted during autohealing, update, instance recreate
   * operations. This flag is used to configure if the disk should be deleted after it is no longer
   * used by the group, e.g. when the given instance or the whole MIG is deleted. Note: disks
   * attached in READ_ONLY mode cannot be auto-deleted.
   */
  public String getAutoDelete() {
    return autoDelete;
  }

  /**
   * The mode in which to attach this disk, either READ_WRITE or READ_ONLY. If not specified, the
   * default is to attach the disk in READ_WRITE mode.
   */
  public String getMode() {
    return mode;
  }

  /** The URL of the disk resource that is stateful and should be attached to the VM instance. */
  public String getSource() {
    return source;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PreservedStatePreservedDisk prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PreservedStatePreservedDisk getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PreservedStatePreservedDisk DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PreservedStatePreservedDisk();
  }

  public static class Builder {
    private String autoDelete;
    private String mode;
    private String source;

    Builder() {}

    public Builder mergeFrom(PreservedStatePreservedDisk other) {
      if (other == PreservedStatePreservedDisk.getDefaultInstance()) return this;
      if (other.getAutoDelete() != null) {
        this.autoDelete = other.autoDelete;
      }
      if (other.getMode() != null) {
        this.mode = other.mode;
      }
      if (other.getSource() != null) {
        this.source = other.source;
      }
      return this;
    }

    Builder(PreservedStatePreservedDisk source) {
      this.autoDelete = source.autoDelete;
      this.mode = source.mode;
      this.source = source.source;
    }

    /**
     * These stateful disks will never be deleted during autohealing, update, instance recreate
     * operations. This flag is used to configure if the disk should be deleted after it is no
     * longer used by the group, e.g. when the given instance or the whole MIG is deleted. Note:
     * disks attached in READ_ONLY mode cannot be auto-deleted.
     */
    public String getAutoDelete() {
      return autoDelete;
    }

    /**
     * These stateful disks will never be deleted during autohealing, update, instance recreate
     * operations. This flag is used to configure if the disk should be deleted after it is no
     * longer used by the group, e.g. when the given instance or the whole MIG is deleted. Note:
     * disks attached in READ_ONLY mode cannot be auto-deleted.
     */
    public Builder setAutoDelete(String autoDelete) {
      this.autoDelete = autoDelete;
      return this;
    }

    /**
     * The mode in which to attach this disk, either READ_WRITE or READ_ONLY. If not specified, the
     * default is to attach the disk in READ_WRITE mode.
     */
    public String getMode() {
      return mode;
    }

    /**
     * The mode in which to attach this disk, either READ_WRITE or READ_ONLY. If not specified, the
     * default is to attach the disk in READ_WRITE mode.
     */
    public Builder setMode(String mode) {
      this.mode = mode;
      return this;
    }

    /** The URL of the disk resource that is stateful and should be attached to the VM instance. */
    public String getSource() {
      return source;
    }

    /** The URL of the disk resource that is stateful and should be attached to the VM instance. */
    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    public PreservedStatePreservedDisk build() {

      return new PreservedStatePreservedDisk(autoDelete, mode, source);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoDelete(this.autoDelete);
      newBuilder.setMode(this.mode);
      newBuilder.setSource(this.source);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PreservedStatePreservedDisk{"
        + "autoDelete="
        + autoDelete
        + ", "
        + "mode="
        + mode
        + ", "
        + "source="
        + source
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PreservedStatePreservedDisk) {
      PreservedStatePreservedDisk that = (PreservedStatePreservedDisk) o;
      return Objects.equals(this.autoDelete, that.getAutoDelete())
          && Objects.equals(this.mode, that.getMode())
          && Objects.equals(this.source, that.getSource());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoDelete, mode, source);
  }
}
