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

package com.google.gcloud.compute;

import com.google.api.client.util.DateTime;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * The deprecation status associated to a Google Compute Engine resource.
 *
 * @param <T> The Google Compute Engine resource to which the deprecation status refers to.
 */
public final class DeprecationStatus<T extends ResourceId> implements Serializable {

  private static final long serialVersionUID = -2695077634793679794L;

  private final Long deleted;
  private final Long deprecated;
  private final Long obsolete;
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

  DeprecationStatus(Long deleted, Long deprecated, Long obsolete, T replacement, Status status) {
    this.deleted = deleted;
    this.deprecated = deprecated;
    this.obsolete = obsolete;
    this.replacement = replacement;
    this.status = status;
  }

  /**
   * Returns the timestamp on or after which the deprecation state of this resource will be changed
   * to {@link Status#DELETED}. In milliseconds since epoch.
   */
  public Long deleted() {
    return deleted;
  }

  /**
   * Returns the timestamp on or after which the deprecation state of this resource will be changed
   * to {@link Status#DEPRECATED}. In milliseconds since epoch.
   */
  public Long deprecated() {
    return deprecated;
  }

  /**
   * Returns the timestamp on or after which the deprecation state of this resource will be changed
   * to {@link Status#OBSOLETE}. In milliseconds since epoch.
   */
  public Long obsolete() {
    return obsolete;
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
    return obj instanceof DeprecationStatus
        && Objects.equals(toPb(), ((DeprecationStatus) obj).toPb());
  }

  com.google.api.services.compute.model.DeprecationStatus toPb() {
    com.google.api.services.compute.model.DeprecationStatus deprecationStatusPb =
        new com.google.api.services.compute.model.DeprecationStatus();
    if (deleted != null) {
      deprecationStatusPb.setDeleted(new DateTime(deleted).toStringRfc3339());
    }
    if (deprecated != null) {
      deprecationStatusPb.setDeprecated(new DateTime(deprecated).toStringRfc3339());
    }
    if (obsolete != null) {
      deprecationStatusPb.setObsolete(new DateTime(obsolete).toStringRfc3339());
    }
    if (replacement != null) {
      deprecationStatusPb.setReplacement(replacement.selfLink());
    }
    if (status() != null) {
      deprecationStatusPb.setState(status.name());
    }
    return deprecationStatusPb;
  }

  static <T extends ResourceId> DeprecationStatus<T> fromPb(
      com.google.api.services.compute.model.DeprecationStatus deprecationStatusPb,
      Function<String, T> fromUrl) {
    return new DeprecationStatus<>(
        deprecationStatusPb.getDeleted() != null
            ? DateTime.parseRfc3339(deprecationStatusPb.getDeleted()).getValue() : null,
        deprecationStatusPb.getDeprecated() != null
            ? DateTime.parseRfc3339(deprecationStatusPb.getDeprecated()).getValue() : null,
        deprecationStatusPb.getObsolete() != null
            ? DateTime.parseRfc3339(deprecationStatusPb.getObsolete()).getValue() : null,
        deprecationStatusPb.getReplacement() != null
            ? fromUrl.apply(deprecationStatusPb.getReplacement()) : null,
        deprecationStatusPb.getState() != null
            ? Status.valueOf(deprecationStatusPb.getState()) : null);
  }
}
