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

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * The deprecation status associated to a Google Compute Engine resource.
 */
public final class DeprecationStatus<T extends ResourceId> implements Serializable {

  private static final long serialVersionUID = -2695077634793679794L;

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
     * Operations that create Google Compute Engine entity using a deprecated resource will return
     * successfully but with a warning indicating the deprecation and suggesting a replacement.
     */
    DEPRECATED,
    /**
     * Operations that create Google Compute Engine entity using an obsolete resource will be
     * rejected and result in an error.
     */
    OBSOLETE,
    /**
     * Operations that create Google Compute Engine entity using a deleted resource will be
     * rejected and result in an error.
     */
    DELETED
  }

  DeprecationStatus(String deleted, String deprecated, String obsolete, T replacement,
      Status status) {
    this.deleted = deleted;
    this.deprecated = deprecated;
    this.obsolete = obsolete;
    this.replacement = replacement;
    this.status = status;
  }

  /**
   * Returns an optional RFC3339 timestamp on or after which the deprecation state of this resource
   * will be changed to {@link Status#DELETED}.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  public String deleted() {
    return deleted;
  }

  /**
   * Returns an optional RFC3339 timestamp on or after which the deprecation state of this resource
   * will be changed to {@link Status#DEPRECATED}.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  public String deprecated() {
    return deprecated;
  }

  /**
   * Returns an optional RFC3339 timestamp on or after which the deprecation state of this resource
   * will be changed to {@link Status#OBSOLETE}.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  public String obsolete() {
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
    deprecationStatusPb.setDeleted(deleted);
    deprecationStatusPb.setDeprecated(deprecated);
    deprecationStatusPb.setObsolete(obsolete);
    if (replacement != null) {
      deprecationStatusPb.setReplacement(replacement.toUrl());
    }
    if (status() != null) {
      deprecationStatusPb.setState(status.name());
    }
    return deprecationStatusPb;
  }

  static <T extends ResourceId> DeprecationStatus<T> fromPb(
      com.google.api.services.compute.model.DeprecationStatus deprecationStatusPb,
      Function<String, T> fromUrl) {
    return new DeprecationStatus<T>(
        deprecationStatusPb.getDeleted(),
        deprecationStatusPb.getDeprecated(),
        deprecationStatusPb.getObsolete(),
        deprecationStatusPb.getReplacement() != null
            ? fromUrl.apply(deprecationStatusPb.getReplacement()) : null,
        deprecationStatusPb.getState() != null
            ? Status.valueOf(deprecationStatusPb.getState()) : null);
  }
}
