/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.util.Objects;

/**
 * The deprecation status associated to a Google Compute Engine resource.
 *
 * @param <T> The Google Compute Engine resource identity to which the deprecation status refers
 */
public final class DeprecationStatus<T extends ResourceId> implements Serializable {

  private static final long serialVersionUID = -2695077634793679794L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();
  private static final DateTimeFormatter TIMESTAMP_PARSER = ISODateTimeFormat.dateTimeParser();

  private final String deleted;
  private final String deprecated;
  private final String obsolete;
  private final T replacement;
  private final Status status;

  /**
   * The deprecation status of a Google Compute Engine resource.
   */
  public enum Status {
    /**
     * Operations that create a Google Compute Engine entity using a deprecated resource will return
     * successfully but with a warning indicating the deprecation and suggesting a replacement.
     */
    DEPRECATED,

    /**
     * Operations that create a Google Compute Engine entity using an obsolete resource will be
     * rejected and result in an error.
     */
    OBSOLETE,

    /**
     * Operations that create a Google Compute Engine entity using a deleted resource will be
     * rejected and result in an error.
     */
    DELETED
  }

  /**
   * A builder for {@code DeprecationStatus} objects.
   *
   * @param <T> The Google Compute Engine resource identity to which the deprecation status refers
   */
  public static final class Builder<T extends ResourceId> {

    private String deleted;
    private String deprecated;
    private String obsolete;
    private T replacement;
    private Status status;

    Builder() {}

    Builder(DeprecationStatus<T> deprecationStatus) {
      this.deleted = deprecationStatus.deleted;
      this.deprecated = deprecationStatus.deprecated;
      this.obsolete = deprecationStatus.obsolete;
      this.replacement = deprecationStatus.replacement;
      this.status = deprecationStatus.status;
    }

    /**
     * Sets the timestamp on or after which the deprecation state of this resource will be changed
     * to {@link Status#DELETED}. Timestamp should be in RFC3339 format.
     *
     * @see <a href="http://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
     */
    // Wrongly-formatted timestamps were allowed, we must still support them (see #732 for details)
    Builder<T> deleted(String deleted) {
      this.deleted = deleted;
      return this;
    }

    /**
     * Sets the timestamp on or after which the deprecation state of this resource will be changed
     * to {@link Status#DEPRECATED}. Timestamp should be in RFC3339 format.
     *
     * @see <a href="http://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
     */
    // Wrongly-formatted timestamps were allowed, we must still support them (see #732 for details)
    Builder<T> deprecated(String deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /**
     * Sets the timestamp on or after which the deprecation state of this resource will be changed
     * to {@link Status#OBSOLETE}. Timestamp should be in RFC3339 format.
     *
     * @see <a href="http://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
     */
    // Wrongly-formatted timestamps were allowed, we must still support them (see #732 for details)
    Builder<T> obsolete(String obsolete) {
      this.obsolete = obsolete;
      return this;
    }

    /**
     * Sets the timestamp on or after which the deprecation state of this resource will be changed
     * to {@link Status#DELETED}. In milliseconds since epoch.
     */
    public Builder<T> deleted(long deleted) {
      this.deleted = TIMESTAMP_FORMATTER.print(deleted);
      return this;
    }

    /**
     * Sets the timestamp on or after which the deprecation state of this resource will be changed
     * to {@link Status#DEPRECATED}. In milliseconds since epoch.
     */
    public Builder<T> deprecated(long deprecated) {
      this.deprecated = TIMESTAMP_FORMATTER.print(deprecated);
      return this;
    }

    /**
     * Sets the timestamp on or after which the deprecation state of this resource will be changed
     * to {@link Status#OBSOLETE}. In milliseconds since epoch.
     */
    public Builder<T> obsolete(long obsolete) {
      this.obsolete = TIMESTAMP_FORMATTER.print(obsolete);
      return this;
    }

    /**
     * Sets the identity of the suggested replacement for a deprecated resource. The suggested
     * replacement resource must be the same kind of resource as the deprecated resource.
     */
    public Builder<T> replacement(T replacement) {
      this.replacement = replacement;
      return this;
    }

    /**
     * Sets the status of the deprecated resource.
     */
    public Builder<T> status(Status status) {
      this.status = checkNotNull(status);
      return this;
    }

    /**
     * Creates a {@code DeprecationStatus} object.
     */
    public DeprecationStatus<T> build() {
      return new DeprecationStatus<T>(this);
    }
  }

  DeprecationStatus(Builder<T> builder) {
    this.deleted = builder.deleted;
    this.deprecated = builder.deprecated;
    this.obsolete = builder.obsolete;
    this.replacement = builder.replacement;
    this.status = checkNotNull(builder.status);
  }

  /**
   * Returns the timestamp on or after which the deprecation state of this resource will be changed
   * to {@link Status#DELETED}. Returns {@code null} if not set. This value should be in RFC3339
   * format.
   *
   * @see <a href="http://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  // Wrongly-formatted timestamps were allowed, we must still support them (see #732 for details)
  public String deleted() {
    return deleted;
  }

  /**
   * Returns the timestamp on or after which the deprecation state of this resource will be changed
   * to {@link Status#DEPRECATED}. Returns {@code null} if not set. This value should be in RFC3339
   * format.
   *
   * @see <a href="http://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  // Wrongly-formatted timestamps were allowed, we must still support them (see #732 for details)
  public String deprecated() {
    return deprecated;
  }

  /**
   * Returns the timestamp on or after which the deprecation state of this resource will be changed
   * to {@link Status#OBSOLETE}. Returns {@code null} if not set. This value should be in RFC3339
   * format.
   *
   * @see <a href="http://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  // Wrongly-formatted timestamps were allowed, we must still support them (see #732 for details)
  public String obsolete() {
    return obsolete;
  }

  /**
   * Returns the timestamp (in milliseconds since epoch) on or after which the deprecation state of
   * this resource will be changed to {@link Status#DELETED}. Returns {@code null} if not set.
   *
   * @throws IllegalStateException if {@link #deleted()} is not a valid date, time or datetime
   */
  public Long deletedMillis() {
    try {
      return deleted != null ? TIMESTAMP_PARSER.parseMillis(deleted) : null;
    } catch (IllegalArgumentException ex) {
      throw new IllegalStateException(ex.getMessage(), ex);
    }
  }

  /**
   * Returns the timestamp (in milliseconds since epoch) on or after which the deprecation state of
   * this resource will be changed to {@link Status#DEPRECATED}. Returns {@code null} if not set.
   *
   * @throws IllegalStateException if {@link #deprecated()} is not a valid date, time or datetime
   */
  public Long deprecatedMillis() {
    try {
      return deprecated != null ? TIMESTAMP_PARSER.parseMillis(deprecated) : null;
    } catch (IllegalArgumentException ex) {
      throw new IllegalStateException(ex.getMessage(), ex);
    }
  }

  /**
   * Returns the timestamp (in milliseconds since epoch) on or after which the deprecation state of
   * this resource will be changed to {@link Status#OBSOLETE}. Returns {@code null} if not set.
   *
   * @throws IllegalStateException if {@link #obsolete()} is not a valid date, time or datetime
   */
  public Long obsoleteMillis() {
    try {
      return obsolete != null ? TIMESTAMP_PARSER.parseMillis(obsolete) : null;
    } catch (IllegalArgumentException ex) {
      throw new IllegalStateException(ex.getMessage(), ex);
    }
  }

  /**
   * Returns the identity of the suggested replacement for a deprecated resource. The suggested
   * replacement resource must be the same kind of resource as the deprecated resource.
   */
  public T replacement() {
    return replacement;
  }

  /**
   * Returns the deprecation state of this resource.
   */
  public Status status() {
    return status;
  }

  /**
   * Returns a builder for the {@code DeprecationStatus} object.
   */
  public Builder<T> toBuilder() {
    return new Builder<>(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("deleted", deleted)
        .add("deprecated", deprecated)
        .add("obsolete", obsolete)
        .add("replacement", replacement)
        .add("status", status)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleted, deprecated, obsolete, replacement, status);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof DeprecationStatus
        && Objects.equals(toPb(), ((DeprecationStatus) obj).toPb());
  }

  com.google.api.services.compute.model.DeprecationStatus toPb() {
    com.google.api.services.compute.model.DeprecationStatus deprecationStatusPb =
        new com.google.api.services.compute.model.DeprecationStatus();
    deprecationStatusPb.setDeleted(deleted);
    deprecationStatusPb.setDeprecated(deprecated);
    deprecationStatusPb.setObsolete(obsolete);
    deprecationStatusPb.setReplacement(replacement.selfLink());
    deprecationStatusPb.setState(status.name());
    return deprecationStatusPb;
  }

  /**
   * Returns the builder for a {@code DeprecationStatus} object given the status.
   */
  public static <T extends ResourceId> Builder<T> builder(Status status) {
    return new Builder<T>().status(status);
  }

  /**
   * Returns the builder for a {@code DeprecationStatus} object given the status and replacement's
   * identity.
   */
  public static <T extends ResourceId> Builder<T> builder(Status status, T replacement) {
    return new Builder<T>().status(status).replacement(replacement);
  }

  /**
   * Returns a {@code DeprecationStatus} object given the status and replacement's identity.
   */
  public static <T extends ResourceId> DeprecationStatus<T> of(Status status, T replacement) {
    return builder(status, replacement).build();
  }

  static <T extends ResourceId> DeprecationStatus<T> fromPb(
      com.google.api.services.compute.model.DeprecationStatus deprecationStatusPb,
      Function<String, T> fromUrl) {
    Builder<T> builder = new Builder<>();
    builder.deleted(deprecationStatusPb.getDeleted());
    builder.deprecated(deprecationStatusPb.getDeprecated());
    builder.obsolete(deprecationStatusPb.getObsolete());
    if (deprecationStatusPb.getReplacement() != null) {
      builder.replacement(fromUrl.apply(deprecationStatusPb.getReplacement()));
    }
    if (deprecationStatusPb.getState() != null) {
      builder.status(Status.valueOf(deprecationStatusPb.getState()));
    }
    return builder.build();
  }
}
