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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class DiskTypesScopedList implements ApiMessage {
  private final List<DiskType> diskTypes;
  private final Warning warning;

  private DiskTypesScopedList() {
    this.diskTypes = null;
    this.warning = null;
  }

  private DiskTypesScopedList(List<DiskType> diskTypes, Warning warning) {
    this.diskTypes = diskTypes;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("diskTypes".equals(fieldName)) {
      return diskTypes;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  /** [Output Only] A list of disk types contained in this scope. */
  public List<DiskType> getDiskTypesList() {
    return diskTypes;
  }

  /**
   * [Output Only] Informational warning which replaces the list of disk types when the list is
   * empty.
   */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DiskTypesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DiskTypesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DiskTypesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DiskTypesScopedList();
  }

  public static class Builder {
    private List<DiskType> diskTypes;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(DiskTypesScopedList other) {
      if (other == DiskTypesScopedList.getDefaultInstance()) return this;
      if (other.getDiskTypesList() != null) {
        this.diskTypes = other.diskTypes;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(DiskTypesScopedList source) {
      this.diskTypes = source.diskTypes;
      this.warning = source.warning;
    }

    /** [Output Only] A list of disk types contained in this scope. */
    public List<DiskType> getDiskTypesList() {
      return diskTypes;
    }

    /** [Output Only] A list of disk types contained in this scope. */
    public Builder addAllDiskTypes(List<DiskType> diskTypes) {
      if (this.diskTypes == null) {
        this.diskTypes = new LinkedList<>();
      }
      this.diskTypes.addAll(diskTypes);
      return this;
    }

    /** [Output Only] A list of disk types contained in this scope. */
    public Builder addDiskTypes(DiskType diskTypes) {
      if (this.diskTypes == null) {
        this.diskTypes = new LinkedList<>();
      }
      this.diskTypes.add(diskTypes);
      return this;
    }

    /**
     * [Output Only] Informational warning which replaces the list of disk types when the list is
     * empty.
     */
    public Warning getWarning() {
      return warning;
    }

    /**
     * [Output Only] Informational warning which replaces the list of disk types when the list is
     * empty.
     */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public DiskTypesScopedList build() {

      return new DiskTypesScopedList(diskTypes, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllDiskTypes(this.diskTypes);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DiskTypesScopedList{" + "diskTypes=" + diskTypes + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DiskTypesScopedList) {
      DiskTypesScopedList that = (DiskTypesScopedList) o;
      return Objects.equals(this.diskTypes, that.getDiskTypesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diskTypes, warning);
  }
}
