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

import com.google.api.services.bigquery.model.Job;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google BigQuery Job information. Jobs are objects that manage asynchronous tasks such as running
 * queries, loading data, and exporting data. Use {@link CopyJobConfiguration} for a job that
 * copies an existing table. Use {@link ExtractJobConfiguration} for a job that exports a table to
 * Google Cloud Storage. Use {@link LoadJobConfiguration} for a job that loads data from Google
 * Cloud Storage into a table. Use {@link QueryJobConfiguration} for a job that runs a query.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs">Jobs</a>
 */
public final class JobInfo implements Serializable {

  static final Function<Job, JobInfo> FROM_PB_FUNCTION =
      new Function<Job, JobInfo>() {
        @Override
        public JobInfo apply(Job pb) {
          return JobInfo.fromPb(pb);
        }
      };
  private static final long serialVersionUID = -3272941007234620265L;

  /**
   * Specifies whether the job is allowed to create new tables.
   */
  public enum CreateDisposition {
    /**
     * Configures the job to create the table if it does not exist.
     */
    CREATE_IF_NEEDED,

    /**
     * Configures the job to fail with a not-found error if the table does not exist.
     */
    CREATE_NEVER
  }

  /**
   * Specifies the action that occurs if the destination table already exists.
   */
  public enum WriteDisposition {
    /**
     * Configures the job to overwrite the table data if table already exists.
     */
    WRITE_TRUNCATE,

    /**
     * Configures the job to append data to the table if it already exists.
     */
    WRITE_APPEND,

    /**
     * Configures the job to fail with a duplicate error if the table already exists.
     */
    WRITE_EMPTY
  }

  private final String etag;
  private final String id;
  private final JobId jobId;
  private final String selfLink;
  private final JobStatus status;
  private final JobStatistics statistics;
  private final String userEmail;
  private final JobConfiguration configuration;

  public static final class Builder {

    private String etag;
    private String id;
    private JobId jobId;
    private String selfLink;
    private JobStatus status;
    private JobStatistics statistics;
    private String userEmail;
    private JobConfiguration configuration;

    private Builder() {}

    private Builder(JobInfo jobInfo) {
      this.etag = jobInfo.etag;
      this.id = jobInfo.id;
      this.jobId = jobInfo.jobId;
      this.selfLink = jobInfo.selfLink;
      this.status = jobInfo.status;
      this.statistics = jobInfo.statistics;
      this.userEmail = jobInfo.userEmail;
      this.configuration = jobInfo.configuration;
    }

    protected Builder(Job jobPb) {
      this.etag = jobPb.getEtag();
      this.id = jobPb.getId();
      if (jobPb.getJobReference() != null) {
        this.jobId = JobId.fromPb(jobPb.getJobReference());
      }
      this.selfLink = jobPb.getSelfLink();
      if (jobPb.getStatus() != null) {
        this.status = JobStatus.fromPb(jobPb.getStatus());
      }
      if (jobPb.getStatistics() != null) {
        this.statistics = JobStatistics.fromPb(jobPb.getStatistics());
      }
      this.userEmail = jobPb.getUserEmail();
      this.configuration = JobConfiguration.fromPb(jobPb.getConfiguration());
    }

    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the job identity.
     */
    public Builder jobId(JobId jobId) {
      this.jobId = jobId;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    Builder status(JobStatus status) {
      this.status = status;
      return this;
    }

    Builder statistics(JobStatistics statistics) {
      this.statistics = statistics;
      return this;
    }

    Builder userEmail(String userEmail) {
      this.userEmail = userEmail;
      return this;
    }

    public Builder configuration(JobConfiguration configuration) {
      this.configuration = configuration;
      return this;
    }

    public JobInfo build() {
      return new JobInfo(this);
    }
  }

  private JobInfo(Builder builder) {
    this.jobId = builder.jobId;
    this.etag = builder.etag;
    this.id = builder.id;
    this.selfLink = builder.selfLink;
    this.status = builder.status;
    this.statistics = builder.statistics;
    this.userEmail = builder.userEmail;
    this.configuration = builder.configuration;
  }

  /**
   * Returns the hash of the job resource.
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns an opaque id for the job.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the job identity.
   */
  public JobId jobId() {
    return jobId;
  }

  /**
   * Returns an URL that can be used to access the resource again. The returned URL can be used for
   * GET requests.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns the status of this job. Examine this value when polling an asynchronous job to see if
   * the job is complete.
   */
  public JobStatus status() {
    return status;
  }

  /**
   * Returns information about the job, including starting time and ending time of the job.
   */
  @SuppressWarnings("unchecked")
  public <S extends JobStatistics> S statistics() {
    return (S) statistics;
  }

  /**
   * Returns the email address of the user who ran the job.
   */
  public String userEmail() {
    return userEmail;
  }

  /**
   * Returns the job's configuration.
   */
  @SuppressWarnings("unchecked")
  public <C extends JobConfiguration> C configuration() {
    return (C) configuration;
  }

  /**
   * Returns a builder for the job.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("job", jobId)
        .add("status", status)
        .add("statistics", statistics)
        .add("userEmail", userEmail)
        .add("etag", etag)
        .add("id", id)
        .add("selfLink", selfLink)
        .add("configuration", configuration)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof JobInfo && Objects.equals(toPb(), ((JobInfo) obj).toPb());
  }

  JobInfo setProjectId(String projectId) {
    return toBuilder().configuration(configuration.setProjectId(projectId)).build();
  }

  Job toPb() {
    Job jobPb = new Job();
    jobPb.setEtag(etag);
    jobPb.setId(id);
    jobPb.setSelfLink(selfLink);
    jobPb.setUserEmail(userEmail);
    if (jobId != null) {
      jobPb.setJobReference(jobId.toPb());
    }
    if (status != null) {
      jobPb.setStatus(status.toPb());
    }
    if (statistics != null) {
      jobPb.setStatistics(statistics.toPb());
    }
    jobPb.setConfiguration(configuration.toPb());
    return jobPb;
  }

  public static Builder builder(JobConfiguration configuration) {
    return new Builder().configuration(configuration);
  }

  public static JobInfo of(JobConfiguration configuration) {
    return builder(configuration).build();
  }

  public static JobInfo of(JobId jobId, JobConfiguration configuration) {
    return builder(configuration).jobId(jobId).build();
  }

  static JobInfo fromPb(Job jobPb) {
    return new Builder(jobPb).build();
  }
}
