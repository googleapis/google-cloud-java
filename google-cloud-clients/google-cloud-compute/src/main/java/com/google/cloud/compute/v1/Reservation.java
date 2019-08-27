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
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a reservation resource. A reservation ensures that capacity is held in a specific zone
 * even if the reserved VMs are not running. For more information, read Reserving zonal resources.
 * (== resource_for beta.reservations ==) (== resource_for v1.reservations ==) (== NextID: 13 ==)
 */
public final class Reservation implements ApiMessage {
  private final String commitment;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String selfLink;
  private final AllocationSpecificSKUReservation specificReservation;
  private final Boolean specificReservationRequired;
  private final String status;
  private final String zone;

  private Reservation() {
    this.commitment = null;
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.selfLink = null;
    this.specificReservation = null;
    this.specificReservationRequired = null;
    this.status = null;
    this.zone = null;
  }

  private Reservation(
      String commitment,
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String selfLink,
      AllocationSpecificSKUReservation specificReservation,
      Boolean specificReservationRequired,
      String status,
      String zone) {
    this.commitment = commitment;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.selfLink = selfLink;
    this.specificReservation = specificReservation;
    this.specificReservationRequired = specificReservationRequired;
    this.status = status;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("commitment".equals(fieldName)) {
      return commitment;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("specificReservation".equals(fieldName)) {
      return specificReservation;
    }
    if ("specificReservationRequired".equals(fieldName)) {
      return specificReservationRequired;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("zone".equals(fieldName)) {
      return zone;
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
   * [OutputOnly] Full or partial url for parent commitment for reservations which are tied to a
   * commitment.
   */
  public String getCommitment() {
    return commitment;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#reservations for reservations. */
  public String getKind() {
    return kind;
  }

  /**
   * The name of the resource, provided by the client when initially creating the resource. The
   * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
   * must be 1-63 characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`
   * which means the first character must be a lowercase letter, and all following characters must
   * be a dash, lowercase letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /** [Output Only] Server-defined fully-qualified URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** Reservation for instances with specific machine shapes. */
  public AllocationSpecificSKUReservation getSpecificReservation() {
    return specificReservation;
  }

  /**
   * Indicates whether the reservation can be consumed by VMs with affinity for "any" reservation.
   * If the field is set, then only VMs that target the reservation by name can consume from this
   * reservation.
   */
  public Boolean getSpecificReservationRequired() {
    return specificReservationRequired;
  }

  /** [Output Only] The status of the reservation. */
  public String getStatus() {
    return status;
  }

  /**
   * Zone in which the reservation resides, must be provided if reservation is created with
   * commitment creation.
   */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Reservation prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Reservation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Reservation DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Reservation();
  }

  public static class Builder {
    private String commitment;
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String selfLink;
    private AllocationSpecificSKUReservation specificReservation;
    private Boolean specificReservationRequired;
    private String status;
    private String zone;

    Builder() {}

    public Builder mergeFrom(Reservation other) {
      if (other == Reservation.getDefaultInstance()) return this;
      if (other.getCommitment() != null) {
        this.commitment = other.commitment;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSpecificReservation() != null) {
        this.specificReservation = other.specificReservation;
      }
      if (other.getSpecificReservationRequired() != null) {
        this.specificReservationRequired = other.specificReservationRequired;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(Reservation source) {
      this.commitment = source.commitment;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.specificReservation = source.specificReservation;
      this.specificReservationRequired = source.specificReservationRequired;
      this.status = source.status;
      this.zone = source.zone;
    }

    /**
     * [OutputOnly] Full or partial url for parent commitment for reservations which are tied to a
     * commitment.
     */
    public String getCommitment() {
      return commitment;
    }

    /**
     * [OutputOnly] Full or partial url for parent commitment for reservations which are tied to a
     * commitment.
     */
    public Builder setCommitment(String commitment) {
      this.commitment = commitment;
      return this;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#reservations for reservations. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#reservations for reservations. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** Reservation for instances with specific machine shapes. */
    public AllocationSpecificSKUReservation getSpecificReservation() {
      return specificReservation;
    }

    /** Reservation for instances with specific machine shapes. */
    public Builder setSpecificReservation(AllocationSpecificSKUReservation specificReservation) {
      this.specificReservation = specificReservation;
      return this;
    }

    /**
     * Indicates whether the reservation can be consumed by VMs with affinity for "any" reservation.
     * If the field is set, then only VMs that target the reservation by name can consume from this
     * reservation.
     */
    public Boolean getSpecificReservationRequired() {
      return specificReservationRequired;
    }

    /**
     * Indicates whether the reservation can be consumed by VMs with affinity for "any" reservation.
     * If the field is set, then only VMs that target the reservation by name can consume from this
     * reservation.
     */
    public Builder setSpecificReservationRequired(Boolean specificReservationRequired) {
      this.specificReservationRequired = specificReservationRequired;
      return this;
    }

    /** [Output Only] The status of the reservation. */
    public String getStatus() {
      return status;
    }

    /** [Output Only] The status of the reservation. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * Zone in which the reservation resides, must be provided if reservation is created with
     * commitment creation.
     */
    public String getZone() {
      return zone;
    }

    /**
     * Zone in which the reservation resides, must be provided if reservation is created with
     * commitment creation.
     */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Reservation build() {

      return new Reservation(
          commitment,
          creationTimestamp,
          description,
          id,
          kind,
          name,
          selfLink,
          specificReservation,
          specificReservationRequired,
          status,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCommitment(this.commitment);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSpecificReservation(this.specificReservation);
      newBuilder.setSpecificReservationRequired(this.specificReservationRequired);
      newBuilder.setStatus(this.status);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Reservation{"
        + "commitment="
        + commitment
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "specificReservation="
        + specificReservation
        + ", "
        + "specificReservationRequired="
        + specificReservationRequired
        + ", "
        + "status="
        + status
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Reservation) {
      Reservation that = (Reservation) o;
      return Objects.equals(this.commitment, that.getCommitment())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.specificReservation, that.getSpecificReservation())
          && Objects.equals(this.specificReservationRequired, that.getSpecificReservationRequired())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        commitment,
        creationTimestamp,
        description,
        id,
        kind,
        name,
        selfLink,
        specificReservation,
        specificReservationRequired,
        status,
        zone);
  }
}
