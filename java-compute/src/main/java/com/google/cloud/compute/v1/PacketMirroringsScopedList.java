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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class PacketMirroringsScopedList implements ApiMessage {
  private final List<PacketMirroring> packetMirrorings;
  private final Warning warning;

  private PacketMirroringsScopedList() {
    this.packetMirrorings = null;
    this.warning = null;
  }

  private PacketMirroringsScopedList(List<PacketMirroring> packetMirrorings, Warning warning) {
    this.packetMirrorings = packetMirrorings;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("packetMirrorings".equals(fieldName)) {
      return packetMirrorings;
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** A list of packetMirrorings contained in this scope. */
  public List<PacketMirroring> getPacketMirroringsList() {
    return packetMirrorings;
  }

  /** Informational warning which replaces the list of packetMirrorings when the list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PacketMirroringsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PacketMirroringsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PacketMirroringsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PacketMirroringsScopedList();
  }

  public static class Builder {
    private List<PacketMirroring> packetMirrorings;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(PacketMirroringsScopedList other) {
      if (other == PacketMirroringsScopedList.getDefaultInstance()) return this;
      if (other.getPacketMirroringsList() != null) {
        this.packetMirrorings = other.packetMirrorings;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(PacketMirroringsScopedList source) {
      this.packetMirrorings = source.packetMirrorings;
      this.warning = source.warning;
    }

    /** A list of packetMirrorings contained in this scope. */
    public List<PacketMirroring> getPacketMirroringsList() {
      return packetMirrorings;
    }

    /** A list of packetMirrorings contained in this scope. */
    public Builder addAllPacketMirrorings(List<PacketMirroring> packetMirrorings) {
      if (this.packetMirrorings == null) {
        this.packetMirrorings = new LinkedList<>();
      }
      this.packetMirrorings.addAll(packetMirrorings);
      return this;
    }

    /** A list of packetMirrorings contained in this scope. */
    public Builder addPacketMirrorings(PacketMirroring packetMirrorings) {
      if (this.packetMirrorings == null) {
        this.packetMirrorings = new LinkedList<>();
      }
      this.packetMirrorings.add(packetMirrorings);
      return this;
    }

    /** Informational warning which replaces the list of packetMirrorings when the list is empty. */
    public Warning getWarning() {
      return warning;
    }

    /** Informational warning which replaces the list of packetMirrorings when the list is empty. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public PacketMirroringsScopedList build() {

      return new PacketMirroringsScopedList(packetMirrorings, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllPacketMirrorings(this.packetMirrorings);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PacketMirroringsScopedList{"
        + "packetMirrorings="
        + packetMirrorings
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PacketMirroringsScopedList) {
      PacketMirroringsScopedList that = (PacketMirroringsScopedList) o;
      return Objects.equals(this.packetMirrorings, that.getPacketMirroringsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(packetMirrorings, warning);
  }
}
