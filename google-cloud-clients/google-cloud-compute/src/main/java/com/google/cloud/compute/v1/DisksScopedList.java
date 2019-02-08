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
public final class DisksScopedList implements ApiMessage {
  private final List<Disk> disks;
  private final Warning warning;

  private DisksScopedList() {
    this.disks = null;
    this.warning = null;
  }

  private DisksScopedList(List<Disk> disks, Warning warning) {
    this.disks = disks;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("disks".equals(fieldName)) {
      return disks;
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

  /** [Output Only] A list of disks contained in this scope. */
  public List<Disk> getDisksList() {
    return disks;
  }

  /**
   * [Output Only] Informational warning which replaces the list of disks when the list is empty.
   */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DisksScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DisksScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DisksScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DisksScopedList();
  }

  public static class Builder {
    private List<Disk> disks;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(DisksScopedList other) {
      if (other == DisksScopedList.getDefaultInstance()) return this;
      if (other.getDisksList() != null) {
        this.disks = other.disks;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(DisksScopedList source) {
      this.disks = source.disks;
      this.warning = source.warning;
    }

    /** [Output Only] A list of disks contained in this scope. */
    public List<Disk> getDisksList() {
      return disks;
    }

    /** [Output Only] A list of disks contained in this scope. */
    public Builder addAllDisks(List<Disk> disks) {
      if (this.disks == null) {
        this.disks = new LinkedList<>();
      }
      this.disks.addAll(disks);
      return this;
    }

    /** [Output Only] A list of disks contained in this scope. */
    public Builder addDisks(Disk disks) {
      if (this.disks == null) {
        this.disks = new LinkedList<>();
      }
      this.disks.add(disks);
      return this;
    }

    /**
     * [Output Only] Informational warning which replaces the list of disks when the list is empty.
     */
    public Warning getWarning() {
      return warning;
    }

    /**
     * [Output Only] Informational warning which replaces the list of disks when the list is empty.
     */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public DisksScopedList build() {

      return new DisksScopedList(disks, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllDisks(this.disks);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DisksScopedList{" + "disks=" + disks + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DisksScopedList) {
      DisksScopedList that = (DisksScopedList) o;
      return Objects.equals(this.disks, that.getDisksList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(disks, warning);
  }
}
