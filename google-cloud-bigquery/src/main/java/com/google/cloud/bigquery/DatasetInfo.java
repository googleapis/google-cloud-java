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

package com.google.cloud.bigquery;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.TableReference;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Dataset information. A dataset is a grouping mechanism that holds zero or more
 * tables. Datasets are the lowest level unit of access control; you cannot control access at the
 * table level.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#datasets">
 * Managing Jobs, Datasets, and Projects</a>
 */
public class DatasetInfo implements Serializable {

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
  private static final long serialVersionUID = 8469473744160758489L;

  private final DatasetId datasetId;
  private final List<Acl> acl;
  private final Long creationTime;
  private final Long defaultTableLifetime;
  private final String description;
  private final String etag;
  private final String friendlyName;
  private final String generatedId;
  private final Long lastModified;
  private final String location;
  private final String selfLink;

  /**
   * A builder for {@code DatasetInfo} objects.
   */
  public abstract static class Builder {

    /**
     * Sets the dataset identity.
     */
    @Deprecated
    public abstract Builder datasetId(DatasetId datasetId);

    /**
     * Sets the dataset identity.
     */
    public abstract Builder setDatasetId(DatasetId datasetId);

    /**
     * Sets the dataset's access control configuration.
     *
     * @see <a href="https://cloud.google.com/bigquery/access-control">Access Control</a>
     */
    @Deprecated
    public abstract Builder acl(List<Acl> acl);

    /**
     * Sets the dataset's access control configuration.
     *
     * @see <a href="https://cloud.google.com/bigquery/access-control">Access Control</a>
     */
    public abstract Builder setAcl(List<Acl> acl);

    abstract Builder setCreationTime(Long creationTime);

    /**
     * Sets the default lifetime of all tables in the dataset, in milliseconds. The minimum value is
     * 3600000 milliseconds (one hour). Once this property is set, all newly-created tables in the
     * dataset will have an expirationTime property set to the creation time plus the value in this
     * property, and changing the value will only affect new tables, not existing ones. When the
     * expirationTime for a given table is reached, that table will be deleted automatically. If a
     * table's expirationTime is modified or removed before the table expires, or if you provide an
     * explicit expirationTime when creating a table, that value takes precedence over the default
     * expiration time indicated by this property. This property is experimental and might be
     * subject to change or removed.
     */
    @Deprecated
    public abstract Builder defaultTableLifetime(Long defaultTableLifetime);

    /**
     * Sets the default lifetime of all tables in the dataset, in milliseconds. The minimum value is
     * 3600000 milliseconds (one hour). Once this property is set, all newly-created tables in the
     * dataset will have an expirationTime property set to the creation time plus the value in this
     * property, and changing the value will only affect new tables, not existing ones. When the
     * expirationTime for a given table is reached, that table will be deleted automatically. If a
     * table's expirationTime is modified or removed before the table expires, or if you provide an
     * explicit expirationTime when creating a table, that value takes precedence over the default
     * expiration time indicated by this property. This property is experimental and might be
     * subject to change or removed.
     */
    public abstract Builder setDefaultTableLifetime(Long defaultTableLifetime);

    /**
     * Sets a user-friendly description for the dataset.
     */
    @Deprecated
    public abstract Builder description(String description);

    /**
     * Sets a user-friendly description for the dataset.
     */
    public abstract Builder setDescription(String description);

    abstract Builder setEtag(String etag);

    /**
     * Sets a user-friendly name for the dataset.
     */
    @Deprecated
    public abstract Builder friendlyName(String friendlyName);

    /**
     * Sets a user-friendly name for the dataset.
     */
    public abstract Builder setFriendlyName(String friendlyName);

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder setLastModified(Long lastModified);

    /**
     * Sets the geographic location where the dataset should reside. This property is experimental
     * and might be subject to change or removed.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets#location">Dataset
     *     Location</a>
     */
    @Deprecated
    public abstract Builder location(String location);

    /**
     * Sets the geographic location where the dataset should reside. This property is experimental
     * and might be subject to change or removed.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets#location">Dataset
     *     Location</a>
     */
    public abstract Builder setLocation(String location);

    abstract Builder setSelfLink(String selfLink);

    /**
     * Creates a {@code DatasetInfo} object.
     */
    public abstract DatasetInfo build();
  }

  static final class BuilderImpl extends Builder {

    private DatasetId datasetId;
    private List<Acl> acl;
    private Long creationTime;
    private Long defaultTableLifetime;
    private String description;
    private String etag;
    private String friendlyName;
    private String generatedId;
    private Long lastModified;
    private String location;
    private String selfLink;

    BuilderImpl() {}

    BuilderImpl(DatasetInfo datasetInfo) {
      this.datasetId = datasetInfo.datasetId;
      this.acl = datasetInfo.acl;
      this.creationTime = datasetInfo.creationTime;
      this.defaultTableLifetime = datasetInfo.defaultTableLifetime;
      this.description = datasetInfo.description;
      this.etag = datasetInfo.etag;
      this.friendlyName = datasetInfo.friendlyName;
      this.generatedId = datasetInfo.generatedId;
      this.lastModified = datasetInfo.lastModified;
      this.location = datasetInfo.location;
      this.selfLink = datasetInfo.selfLink;
    }

    BuilderImpl(com.google.api.services.bigquery.model.Dataset datasetPb) {
      if (datasetPb.getDatasetReference() != null) {
        this.datasetId = DatasetId.fromPb(datasetPb.getDatasetReference());
      }
      if (datasetPb.getAccess() != null) {
        this.acl = Lists.transform(datasetPb.getAccess(), new Function<Dataset.Access, Acl>() {
          @Override
          public Acl apply(Dataset.Access accessPb) {
            return Acl.fromPb(accessPb);
          }
        });
      }
      this.creationTime = datasetPb.getCreationTime();
      this.defaultTableLifetime = datasetPb.getDefaultTableExpirationMs();
      this.description = datasetPb.getDescription();
      this.etag = datasetPb.getEtag();
      this.friendlyName = datasetPb.getFriendlyName();
      this.generatedId = datasetPb.getId();
      this.lastModified = datasetPb.getLastModifiedTime();
      this.location = datasetPb.getLocation();
      this.selfLink = datasetPb.getSelfLink();
    }

    @Override
    @Deprecated
    public Builder datasetId(DatasetId datasetId) {
      return setDatasetId(datasetId);
    }

    @Override
    public Builder setDatasetId(DatasetId datasetId) {
      this.datasetId = checkNotNull(datasetId);
      return this;
    }

    @Override
    @Deprecated
    public Builder acl(List<Acl> acl) {
      return setAcl(acl);
    }

    @Override
    public Builder setAcl(List<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    @Override
    Builder setCreationTime(Long creationTime) {
      this.creationTime = creationTime;
      return this;
    }

    @Override
    @Deprecated
    public Builder defaultTableLifetime(Long defaultTableLifetime) {
      return setDefaultTableLifetime(defaultTableLifetime);
    }

    @Override
    public Builder setDefaultTableLifetime(Long defaultTableLifetime) {
      this.defaultTableLifetime =
          firstNonNull(defaultTableLifetime, Data.<Long>nullOf(Long.class));
      return this;
    }

    @Override
    @Deprecated
    public Builder description(String description) {
      return setDescription(description);
    }

    @Override
    public Builder setDescription(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    @Deprecated
    public Builder friendlyName(String friendlyName) {
      return setFriendlyName(friendlyName);
    }

    @Override
    public Builder setFriendlyName(String friendlyName) {
      this.friendlyName = firstNonNull(friendlyName, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    Builder setLastModified(Long lastModified) {
      this.lastModified = lastModified;
      return this;
    }

    @Override
    @Deprecated
    public Builder location(String location) {
      return setLocation(location);
    }

    @Override
    public Builder setLocation(String location) {
      this.location = firstNonNull(location, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    @Override
    public DatasetInfo build() {
      return new DatasetInfo(this);
    }
  }

  DatasetInfo(BuilderImpl builder) {
    datasetId = checkNotNull(builder.datasetId);
    acl = builder.acl;
    creationTime = builder.creationTime;
    defaultTableLifetime = builder.defaultTableLifetime;
    description = builder.description;
    etag = builder.etag;
    friendlyName = builder.friendlyName;
    generatedId = builder.generatedId;
    lastModified = builder.lastModified;
    location = builder.location;
    selfLink = builder.selfLink;
  }

  /**
   * Returns the dataset identity.
   */
  @Deprecated
  public DatasetId datasetId() {
    return getDatasetId();
  }

  /**
   * Returns the dataset identity.
   */
  public DatasetId getDatasetId() {
    return datasetId;
  }

  /**
   * Returns the dataset's access control configuration.
   *
   * @see <a href="https://cloud.google.com/bigquery/access-control">Access Control</a>
   */
  @Deprecated
  public List<Acl> acl() {
    return getAcl();
  }

  /**
   * Returns the dataset's access control configuration.
   *
   * @see <a href="https://cloud.google.com/bigquery/access-control">Access Control</a>
   */
  public List<Acl> getAcl() {
    return acl;
  }

  /**
   * Returns the time when this dataset was created, in milliseconds since the epoch.
   */
  @Deprecated
  public Long creationTime() {
    return getCreationTime();
  }

  /**
   * Returns the time when this dataset was created, in milliseconds since the epoch.
   */
  public Long getCreationTime() {
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
  @Deprecated
  public Long defaultTableLifetime() {
    return getDefaultTableLifetime();
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
  public Long getDefaultTableLifetime() {
    return defaultTableLifetime;
  }

  /**
   * Returns a user-friendly description for the dataset.
   */
  @Deprecated
  public String description() {
    return getDescription();
  }

  /**
   * Returns a user-friendly description for the dataset.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the hash of the dataset resource.
   */
  @Deprecated
  public String etag() {
    return getEtag();
  }

  /**
   * Returns the hash of the dataset resource.
   */
  public String getEtag() {
    return etag;
  }

  /**
   * Returns a user-friendly name for the dataset.
   */
  @Deprecated
  public String friendlyName() {
    return getFriendlyName();
  }

  /**
   * Returns a user-friendly name for the dataset.
   */
  public String getFriendlyName() {
    return friendlyName;
  }

  /**
   * Returns the service-generated id for the dataset.
   */
  @Deprecated
  public String generatedId() {
    return getGeneratedId();
  }

  /**
   * Returns the service-generated id for the dataset.
   */
  public String getGeneratedId() {
    return generatedId;
  }

  /**
   * Returns the time when this dataset or any of its tables was last modified, in milliseconds
   * since the epoch.
   */
  @Deprecated
  public Long lastModified() {
    return getLastModified();
  }

  /**
   * Returns the time when this dataset or any of its tables was last modified, in milliseconds
   * since the epoch.
   */
  public Long getLastModified() {
    return lastModified;
  }

  /**
   * Returns the geographic location where the dataset should reside.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
   *     Dataset Location</a>
   */
  @Deprecated
  public String location() {
    return getLocation();
  }

  /**
   * Returns the geographic location where the dataset should reside.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
   *     Dataset Location</a>
   */
  public String getLocation() {
    return location;
  }

  /**
   * Returns an URL that can be used to access the resource again. The returned URL can be used for
   * get or update requests.
   */
  @Deprecated
  public String selfLink() {
    return getSelfLink();
  }

  /**
   * Returns an URL that can be used to access the resource again. The returned URL can be used for
   * get or update requests.
   */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Returns a builder for the dataset object.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("datasetId", datasetId)
        .add("creationTime", creationTime)
        .add("defaultTableLifetime", defaultTableLifetime)
        .add("description", description)
        .add("etag", etag)
        .add("friendlyName", friendlyName)
        .add("generatedId", generatedId)
        .add("lastModified", lastModified)
        .add("location", location)
        .add("selfLink", selfLink)
        .add("acl", acl)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(datasetId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(DatasetInfo.class)
        && Objects.equals(toPb(), ((DatasetInfo) obj).toPb());
  }

  DatasetInfo setProjectId(String projectId) {
    Builder builder = toBuilder();
    builder.setDatasetId(getDatasetId().setProjectId(projectId));
    if (getAcl() != null) {
      List<Acl> acls = Lists.newArrayListWithCapacity(getAcl().size());
      for (Acl acl : getAcl()) {
        if (acl.getEntity().getType() == Acl.Entity.Type.VIEW) {
          Dataset.Access accessPb = acl.toPb();
          TableReference viewReferencePb = accessPb.getView();
          if (viewReferencePb.getProjectId() == null) {
            viewReferencePb.setProjectId(projectId);
          }
          acls.add(Acl.of(new Acl.View(TableId.fromPb(viewReferencePb))));
        } else {
          acls.add(acl);
        }
      }
      builder.setAcl(acls);
    }
    return builder.build();
  }

  Dataset toPb() {
    Dataset datasetPb = new Dataset();
    datasetPb.setDatasetReference(datasetId.toPb());
    datasetPb.setCreationTime(creationTime);
    datasetPb.setDefaultTableExpirationMs(defaultTableLifetime);
    datasetPb.setDescription(description);
    datasetPb.setEtag(etag);
    datasetPb.setFriendlyName(friendlyName);
    datasetPb.setId(generatedId);
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
   * Returns a builder for a {@code DatasetInfo} object given it's identity.
   */
  @Deprecated
  public static Builder builder(DatasetId datasetId) {
    return newBuilder(datasetId);
  }

  /**
   * Returns a builder for a {@code DatasetInfo} object given it's identity.
   */
  public static Builder newBuilder(DatasetId datasetId) {
    return new BuilderImpl().setDatasetId(datasetId);
  }

  /**
   * Returns a builder for a {@code DatasetInfo} object given it's user-defined id.
   */
  @Deprecated
  public static Builder builder(String datasetId) {
    return newBuilder(datasetId);
  }

  /**
   * Returns a builder for a {@code DatasetInfo} object given it's user-defined id.
   */
  public static Builder newBuilder(String datasetId) {
    return newBuilder(DatasetId.of(datasetId));
  }

  /**
   * Returns a builder for the DatasetInfo object given it's user-defined project and dataset ids.
   */
  @Deprecated
  public static Builder builder(String projectId, String datasetId) {
    return newBuilder(projectId, datasetId);
  }

  /**
   * Returns a builder for the DatasetInfo object given it's user-defined project and dataset ids.
   */
  public static Builder newBuilder(String projectId, String datasetId) {
    return newBuilder(DatasetId.of(projectId, datasetId));
  }

  /**
   * Returns a {@code DatasetInfo} object given it's identity.
   */
  public static DatasetInfo of(DatasetId datasetId) {
    return newBuilder(datasetId).build();
  }

  /**
   * Returns a {@code DatasetInfo} object given it's user-defined id.
   */
  public static DatasetInfo of(String datasetId) {
    return newBuilder(datasetId).build();
  }

  static DatasetInfo fromPb(Dataset datasetPb) {
    return new BuilderImpl(datasetPb).build();
  }
}
