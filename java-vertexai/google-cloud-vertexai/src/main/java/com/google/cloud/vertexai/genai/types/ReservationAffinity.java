/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * A ReservationAffinity can be used to configure a Vertex AI resource (e.g., a DeployedModel) to
 * draw its Compute Engine resources from a Shared Reservation, or exclusively from on-demand
 * capacity.
 */
@AutoValue
@JsonDeserialize(builder = ReservationAffinity.Builder.class)
public abstract class ReservationAffinity extends JsonSerializable {
  /**
   * Optional. Corresponds to the label key of a reservation resource. To target a
   * SPECIFIC_RESERVATION by name, use `compute.googleapis.com/reservation-name` as the key and
   * specify the name of your reservation as its value.
   */
  @JsonProperty("key")
  public abstract Optional<String> key();

  /** Required. Specifies the reservation affinity type. */
  @JsonProperty("reservationAffinityType")
  public abstract Optional<Type> reservationAffinityType();

  /**
   * Optional. Corresponds to the label values of a reservation resource. This must be the full
   * resource name of the reservation or reservation block.
   */
  @JsonProperty("values")
  public abstract Optional<List<String>> values();

  /** Instantiates a builder for ReservationAffinity. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReservationAffinity.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReservationAffinity. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ReservationAffinity.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReservationAffinity.Builder();
    }

    /**
     * Setter for key.
     *
     * <p>key: Optional. Corresponds to the label key of a reservation resource. To target a
     * SPECIFIC_RESERVATION by name, use `compute.googleapis.com/reservation-name` as the key and
     * specify the name of your reservation as its value.
     */
    @JsonProperty("key")
    public abstract Builder key(String key);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder key(Optional<String> key);

    /** Clears the value of key field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearKey() {
      return key(Optional.empty());
    }

    /**
     * Setter for reservationAffinityType.
     *
     * <p>reservationAffinityType: Required. Specifies the reservation affinity type.
     */
    @JsonProperty("reservationAffinityType")
    public abstract Builder reservationAffinityType(Type reservationAffinityType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder reservationAffinityType(Optional<Type> reservationAffinityType);

    /** Clears the value of reservationAffinityType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReservationAffinityType() {
      return reservationAffinityType(Optional.empty());
    }

    /**
     * Setter for reservationAffinityType given a known enum.
     *
     * <p>reservationAffinityType: Required. Specifies the reservation affinity type.
     */
    @CanIgnoreReturnValue
    public Builder reservationAffinityType(Type.Known knownType) {
      return reservationAffinityType(new Type(knownType));
    }

    /**
     * Setter for reservationAffinityType given a string.
     *
     * <p>reservationAffinityType: Required. Specifies the reservation affinity type.
     */
    @CanIgnoreReturnValue
    public Builder reservationAffinityType(String reservationAffinityType) {
      return reservationAffinityType(new Type(reservationAffinityType));
    }

    /**
     * Setter for values.
     *
     * <p>values: Optional. Corresponds to the label values of a reservation resource. This must be
     * the full resource name of the reservation or reservation block.
     */
    @JsonProperty("values")
    public abstract Builder values(List<String> values);

    /**
     * Setter for values.
     *
     * <p>values: Optional. Corresponds to the label values of a reservation resource. This must be
     * the full resource name of the reservation or reservation block.
     */
    @CanIgnoreReturnValue
    public Builder values(String... values) {
      return values(Arrays.asList(values));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder values(Optional<List<String>> values);

    /** Clears the value of values field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearValues() {
      return values(Optional.empty());
    }

    public abstract ReservationAffinity build();
  }

  /** Deserializes a JSON string to a ReservationAffinity object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReservationAffinity fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ReservationAffinity.class);
  }
}
