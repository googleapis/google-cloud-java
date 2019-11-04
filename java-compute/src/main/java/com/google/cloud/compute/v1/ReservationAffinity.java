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
/** Specifies the reservations that this instance can consume from. */
public final class ReservationAffinity implements ApiMessage {
  private final String consumeReservationType;
  private final String key;
  private final List<String> values;

  private ReservationAffinity() {
    this.consumeReservationType = null;
    this.key = null;
    this.values = null;
  }

  private ReservationAffinity(String consumeReservationType, String key, List<String> values) {
    this.consumeReservationType = consumeReservationType;
    this.key = key;
    this.values = values;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("consumeReservationType".equals(fieldName)) {
      return consumeReservationType;
    }
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("values".equals(fieldName)) {
      return values;
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
   * Specifies the type of reservation from which this instance can consume resources:
   * ANY_RESERVATION (default), SPECIFIC_RESERVATION, or NO_RESERVATION. See Consuming reserved
   * instances for examples.
   */
  public String getConsumeReservationType() {
    return consumeReservationType;
  }

  /**
   * Corresponds to the label key of a reservation resource. To target a SPECIFIC_RESERVATION by
   * name, specify googleapis.com/reservation-name as the key and specify the name of your
   * reservation as its value.
   */
  public String getKey() {
    return key;
  }

  /** Corresponds to the label values of a reservation resource. */
  public List<String> getValuesList() {
    return values;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ReservationAffinity prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ReservationAffinity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ReservationAffinity DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ReservationAffinity();
  }

  public static class Builder {
    private String consumeReservationType;
    private String key;
    private List<String> values;

    Builder() {}

    public Builder mergeFrom(ReservationAffinity other) {
      if (other == ReservationAffinity.getDefaultInstance()) return this;
      if (other.getConsumeReservationType() != null) {
        this.consumeReservationType = other.consumeReservationType;
      }
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getValuesList() != null) {
        this.values = other.values;
      }
      return this;
    }

    Builder(ReservationAffinity source) {
      this.consumeReservationType = source.consumeReservationType;
      this.key = source.key;
      this.values = source.values;
    }

    /**
     * Specifies the type of reservation from which this instance can consume resources:
     * ANY_RESERVATION (default), SPECIFIC_RESERVATION, or NO_RESERVATION. See Consuming reserved
     * instances for examples.
     */
    public String getConsumeReservationType() {
      return consumeReservationType;
    }

    /**
     * Specifies the type of reservation from which this instance can consume resources:
     * ANY_RESERVATION (default), SPECIFIC_RESERVATION, or NO_RESERVATION. See Consuming reserved
     * instances for examples.
     */
    public Builder setConsumeReservationType(String consumeReservationType) {
      this.consumeReservationType = consumeReservationType;
      return this;
    }

    /**
     * Corresponds to the label key of a reservation resource. To target a SPECIFIC_RESERVATION by
     * name, specify googleapis.com/reservation-name as the key and specify the name of your
     * reservation as its value.
     */
    public String getKey() {
      return key;
    }

    /**
     * Corresponds to the label key of a reservation resource. To target a SPECIFIC_RESERVATION by
     * name, specify googleapis.com/reservation-name as the key and specify the name of your
     * reservation as its value.
     */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /** Corresponds to the label values of a reservation resource. */
    public List<String> getValuesList() {
      return values;
    }

    /** Corresponds to the label values of a reservation resource. */
    public Builder addAllValues(List<String> values) {
      if (this.values == null) {
        this.values = new LinkedList<>();
      }
      this.values.addAll(values);
      return this;
    }

    /** Corresponds to the label values of a reservation resource. */
    public Builder addValues(String values) {
      if (this.values == null) {
        this.values = new LinkedList<>();
      }
      this.values.add(values);
      return this;
    }

    public ReservationAffinity build() {

      return new ReservationAffinity(consumeReservationType, key, values);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setConsumeReservationType(this.consumeReservationType);
      newBuilder.setKey(this.key);
      newBuilder.addAllValues(this.values);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ReservationAffinity{"
        + "consumeReservationType="
        + consumeReservationType
        + ", "
        + "key="
        + key
        + ", "
        + "values="
        + values
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ReservationAffinity) {
      ReservationAffinity that = (ReservationAffinity) o;
      return Objects.equals(this.consumeReservationType, that.getConsumeReservationType())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.values, that.getValuesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumeReservationType, key, values);
  }
}
