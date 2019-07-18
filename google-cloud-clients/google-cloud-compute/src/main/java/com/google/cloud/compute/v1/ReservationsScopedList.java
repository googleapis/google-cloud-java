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
public final class ReservationsScopedList implements ApiMessage {
  private final List<Reservation> reservations;
  private final Warning warning;

  private ReservationsScopedList() {
    this.reservations = null;
    this.warning = null;
  }

  private ReservationsScopedList(List<Reservation> reservations, Warning warning) {
    this.reservations = reservations;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("reservations".equals(fieldName)) {
      return reservations;
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

  /** A list of reservations contained in this scope. */
  public List<Reservation> getReservationsList() {
    return reservations;
  }

  /** Informational warning which replaces the list of reservations when the list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ReservationsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ReservationsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ReservationsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ReservationsScopedList();
  }

  public static class Builder {
    private List<Reservation> reservations;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(ReservationsScopedList other) {
      if (other == ReservationsScopedList.getDefaultInstance()) return this;
      if (other.getReservationsList() != null) {
        this.reservations = other.reservations;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(ReservationsScopedList source) {
      this.reservations = source.reservations;
      this.warning = source.warning;
    }

    /** A list of reservations contained in this scope. */
    public List<Reservation> getReservationsList() {
      return reservations;
    }

    /** A list of reservations contained in this scope. */
    public Builder addAllReservations(List<Reservation> reservations) {
      if (this.reservations == null) {
        this.reservations = new LinkedList<>();
      }
      this.reservations.addAll(reservations);
      return this;
    }

    /** A list of reservations contained in this scope. */
    public Builder addReservations(Reservation reservations) {
      if (this.reservations == null) {
        this.reservations = new LinkedList<>();
      }
      this.reservations.add(reservations);
      return this;
    }

    /** Informational warning which replaces the list of reservations when the list is empty. */
    public Warning getWarning() {
      return warning;
    }

    /** Informational warning which replaces the list of reservations when the list is empty. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public ReservationsScopedList build() {

      return new ReservationsScopedList(reservations, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllReservations(this.reservations);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ReservationsScopedList{"
        + "reservations="
        + reservations
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
    if (o instanceof ReservationsScopedList) {
      ReservationsScopedList that = (ReservationsScopedList) o;
      return Objects.equals(this.reservations, that.getReservationsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservations, warning);
  }
}
