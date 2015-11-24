/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.Dataset;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Dataset information.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#datasets">
 * Managing Jobs, Datasets, and Projects</a>
 */
public final class DatasetInfo implements Serializable {

  static final Function<Dataset, DatasetInfo> FROM_PB_FUNCTION =
      new Function<Dataset, DatasetInfo>() {
        @Override
        public DatasetInfo apply(Dataset pb) {
          return DatasetInfo.fromPb(pb);
        }
      };
  static final Function<DatasetInfo, Dataset> TO_PB_FUNCTION =
      new Function<DatasetInfo, Dataset>() {
        @Override
        public Dataset apply(DatasetInfo datasetInfo) {
          return datasetInfo.toPb();
        }
      };

  private static final long serialVersionUID = -6615133444520365839L;

  private final DatasetId datasetId;
  private final List<Acl> acl;
  private final Long creationTime;
  private final Long defaultTableLifetime;
  private final String description;
  private final String etag;
  private final String friendlyName;
  private final String id;
  private final Long lastModified;
  private final String location;
  private final String selfLink;

  public static final class Builder {

    private DatasetId datasetId;
    private List<Acl> acl;
    private Long creationTime;
    private Long defaultTableLifetime;
    private String description;
    private String etag;
    private String friendlyName;
    private String id;
    private Long lastModified;
    private String location;
    private String selfLink;

    private Builder() {}

    private Builder(DatasetInfo datasetInfo) {
      this.datasetId = datasetInfo.datasetId;
      this.acl = datasetInfo.acl;
      this.creationTime = datasetInfo.creationTime;
      this.defaultTableLifetime = datasetInfo.defaultTableLifetime;
      this.description = datasetInfo.description;
      this.etag = datasetInfo.etag;
      this.friendlyName = datasetInfo.friendlyName;
      this.id = datasetInfo.id;
      this.lastModified = datasetInfo.lastModified;
      this.location = datasetInfo.location;
      this.selfLink = datasetInfo.selfLink;
    }

    /**
     * Sets the dataset identity.
     */
    public Builder datasetId(DatasetId datasetId) {
      this.datasetId = checkNotNull(datasetId);
      return this;
    }

    /**
     * Sets the dataset's access control configuration.
     *
     * @see <a href="https://cloud.google.com/bigquery/access-control">Access Control</a>
     */
    public Builder acl(List<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    Builder creationTime(Long creationTime) {
      this.creationTime = creationTime;
      return this;
    }

    /**
     * Sets the default lifetime of all tables in the dataset, in milliseconds. The minimum value is
     * 3600000 milliseconds (one hour). Once this property is set, all newly-created tables in the
     * dataset will have an expirationTime property set to the creation time plus the value in this
     * property, and changing the value will only affect new tables, not existing ones. When the
     * expirationTime for a given table is reached, that table will be deleted automatically. If a
     * table's expirationTime is modified or removed before the table expires, or if you provide an
     * explicit expirationTime when creating a table, that value takes precedence over the default
     * expiration time indicated by this property.
     */
    public Builder defaultTableLifetime(Long defaultTableLifetime) {
      this.defaultTableLifetime =
          firstNonNull(defaultTableLifetime, Data.<Long>nullOf(Long.class));
      return this;
    }

    /**
     * Sets a user-friendly description for the dataset.
     */
    public Builder description(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return this;
    }

    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    /**
     * Sets a user-friendly name for the dataset.
     */
    public Builder friendlyName(String friendlyName) {
      this.friendlyName = firstNonNull(friendlyName, Data.<String>nullOf(String.class));
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    Builder lastModified(Long lastModified) {
      this.lastModified = lastModified;
      return this;
    }

    /**
     * Sets the geographic location where the dataset should reside.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
     *     Dataset Location</a>
     */
    public Builder location(String location) {
      this.location = firstNonNull(location, Data.<String>nullOf(String.class));
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * Creates a {@code DatasetInfo} object.
     */
    public DatasetInfo build() {
      return new DatasetInfo(this);
    }
  }

  private DatasetInfo(Builder builder) {
    datasetId = checkNotNull(builder.datasetId);
    acl = builder.acl;
    creationTime = builder.creationTime;
    defaultTableLifetime = builder.defaultTableLifetime;
    description = builder.description;
    etag = builder.etag;
    friendlyName = builder.friendlyName;
    id = builder.id;
    lastModified = builder.lastModified;
    location = builder.location;
    selfLink = builder.selfLink;
  }

  /**
   * Returns the dataset identity.
   */
  public DatasetId datasetId() {
    return datasetId;
  }

  /**
   * Returns the dataset's access control configuration.
   *
   * @see <a href="https://cloud.google.com/bigquery/access-control">Access Control</a>
   */
  public List<Acl> acl() {
    return acl;
  }

  /**
   * Returns the time when this dataset was created, in milliseconds since the epoch.
   */
  public Long creationTime() {
    return creationTime;
  }

  /**
   * Returns the default lifetime of all tables in the dataset, in milliseconds. Once this property
   * is set, all newly-created tables in the dataset will have an expirationTime property set to the
   * creation time plus the value in this property, and changing the value will only affect new
   * tables, not existing ones. When the expirationTime for a given table is reached, that table
   * will be deleted automatically. If a table's expirationTime is modified or removed before the
   * table expires, or if you provide an explicit expirationTime when creating a table, that value
   * takes precedence over the default expiration time indicated by this property.
   */
  public Long defaultTableLifetime() {
    return defaultTableLifetime;
  }

  /**
   * Returns a user-friendly description for the dataset.
   */
  public String description() {
    return description;
  }

  /**
   * Returns the hash of the dataset resource.
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns a user-friendly name for the dataset.
   */
  public String friendlyName() {
    return friendlyName;
  }

  /**
   * Returns an opaque id for the dataset.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the time when this dataset or any of its tables was last modified, in milliseconds
   * since the epoch.
   */
  public Long lastModified() {
    return lastModified;
  }

  /**
   * Returns the geographic location where the dataset should reside.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
   *     Dataset Location</a>
   */
  public String location() {
    return location;
  }

  /**
   * Returns an URL that can be used to access the resource again. The returned URL can be used for
   * get or update requests.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns a builder for the {@code DatasetInfo} object.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("datasetId", datasetId)
        .add("description", description)
        .add("acl", acl)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(datasetId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof DatasetInfo && Objects.equals(toPb(), ((DatasetInfo) obj).toPb());
  }

  Dataset toPb() {
    Dataset datasetPb = new Dataset();
    datasetPb.setDatasetReference(datasetId.toPb());
    datasetPb.setCreationTime(creationTime);
    datasetPb.setDefaultTableExpirationMs(defaultTableLifetime);
    datasetPb.setDescription(description);
    datasetPb.setEtag(etag);
    datasetPb.setFriendlyName(friendlyName);
    datasetPb.setId(id);
    datasetPb.setLastModifiedTime(lastModified);
    datasetPb.setLocation(location);
    datasetPb.setSelfLink(selfLink);
    if (acl != null) {
      datasetPb.setAccess(Lists.transform(acl, new Function<Acl, Dataset.Access>() {
        @Override
        public Dataset.Access apply(Acl acl) {
          return acl.toPb();
        }
      }));
    }
    return datasetPb;
  }

  /**
   * Returns a builder for the DatasetInfo object given it's user-defined id.
   */
  public static Builder builder(String datasetId) {
    return new Builder().datasetId(DatasetId.of(datasetId));
  }

  /**
   * Returns a builder for the DatasetInfo object given it's project and user-defined id.
   */
  public static Builder builder(String projectId, String datasetId) {
    return new Builder().datasetId(DatasetId.of(projectId, datasetId));
  }

  /**
   * Returns a builder for the DatasetInfo object given it's identity.
   */
  public static Builder builder(DatasetId datasetId) {
    return new Builder().datasetId(datasetId);
  }

  static DatasetInfo fromPb(Dataset datasetPb) {
    Builder builder = builder(datasetPb.getDatasetReference().getProjectId(),
        datasetPb.getDatasetReference().getDatasetId());
    if (datasetPb.getAccess() != null) {
      builder.acl(Lists.transform(datasetPb.getAccess(),
          new Function<Dataset.Access, Acl>() {
            @Override
            public Acl apply(Dataset.Access f) {
              return Acl.fromPb(f);
            }
          }));
    }
    if (datasetPb.getCreationTime() != null) {
      builder.creationTime(datasetPb.getCreationTime());
    }
    if (datasetPb.getDefaultTableExpirationMs() != null) {
      builder.defaultTableLifetime(datasetPb.getDefaultTableExpirationMs());
    }
    if (datasetPb.getDescription() != null) {
      builder.description(datasetPb.getDescription());
    }
    if (datasetPb.getEtag() != null) {
      builder.etag(datasetPb.getEtag());
    }
    if (datasetPb.getFriendlyName() != null) {
      builder.friendlyName(datasetPb.getFriendlyName());
    }
    if (datasetPb.getId() != null) {
      builder.id(datasetPb.getId());
    }
    if (datasetPb.getLastModifiedTime() != null) {
      builder.lastModified(datasetPb.getLastModifiedTime());
    }
    if (datasetPb.getLocation() != null) {
      builder.location(datasetPb.getLocation());
    }
    if (datasetPb.getSelfLink() != null) {
      builder.selfLink(datasetPb.getSelfLink());
    }
    return builder.build();
  }
}
