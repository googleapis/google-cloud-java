/*
 * Copyright 2015 Google LLC
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
public class JobInfo implements Serializable {

  static final Function<Job, JobInfo> FROM_PB_FUNCTION =
      new Function<Job, JobInfo>() {
        @Override
        public JobInfo apply(Job pb) {
          return JobInfo.fromPb(pb);
        }
      };

  private static final long serialVersionUID = 2740548743267670124L;

  private final String etag;
  private final String generatedId;
  private final JobId jobId;
  private final String selfLink;
  private final JobStatus status;
  private final JobStatistics statistics;
  private final String userEmail;
  private final JobConfiguration configuration;

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

  /**
   *  Specifies options relating to allowing the schema of the destination table to be updated as a side effect of the
   *  load or query job.
   */
  public enum SchemaUpdateOption {
    /**
     * Allow adding a nullable field to the schema.
     */
    ALLOW_FIELD_ADDITION,

    /**
     * Allow relaxing a required field in the original schema to nullable.
     */
    ALLOW_FIELD_RELAXATION
  }

  /**
   * A builder for {@code JobInfo} objects.
   */
  public abstract static class Builder {

    abstract Builder setEtag(String etag);

    abstract Builder setGeneratedId(String generatedId);


    /**
     * Sets the job identity.
     */
    public abstract Builder setJobId(JobId jobId);

    abstract Builder setSelfLink(String selfLink);

    abstract Builder setStatus(JobStatus status);

    abstract Builder setStatistics(JobStatistics statistics);

    abstract Builder setUserEmail(String userEmail);


    /**
     * Sets a configuration for the {@code JobInfo} object. Use {@link CopyJobConfiguration} for a
     * job that copies an existing table. Use {@link ExtractJobConfiguration} for a job that exports
     * a table to Google Cloud Storage. Use {@link LoadJobConfiguration} for a job that loads data
     * from Google Cloud Storage into a table. Use {@link QueryJobConfiguration} for a job that runs
     * a query.
     */
    public abstract Builder setConfiguration(JobConfiguration configuration);

    /**
     * Creates a {@code JobInfo} object.
     */
    public abstract JobInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String etag;
    private String generatedId;
    private JobId jobId;
    private String selfLink;
    private JobStatus status;
    private JobStatistics statistics;
    private String userEmail;
    private JobConfiguration configuration;

    BuilderImpl() {}

    BuilderImpl(JobInfo jobInfo) {
      this.etag = jobInfo.etag;
      this.generatedId = jobInfo.generatedId;
      this.jobId = jobInfo.jobId;
      this.selfLink = jobInfo.selfLink;
      this.status = jobInfo.status;
      this.statistics = jobInfo.statistics;
      this.userEmail = jobInfo.userEmail;
      this.configuration = jobInfo.configuration;
    }

    BuilderImpl(Job jobPb) {
      this.etag = jobPb.getEtag();
      this.generatedId = jobPb.getId();
      if (jobPb.getJobReference() != null) {
        this.jobId = JobId.fromPb(jobPb.getJobReference());
      }
      this.selfLink = jobPb.getSelfLink();
      if (jobPb.getStatus() != null) {
        this.status = JobStatus.fromPb(jobPb.getStatus());
      }
      if (jobPb.getStatistics() != null) {
        this.statistics = JobStatistics.fromPb(jobPb);
      }
      this.userEmail = jobPb.getUserEmail();
      this.configuration = JobConfiguration.fromPb(jobPb.getConfiguration());
    }

    @Override
    Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }


    @Override
    public Builder setJobId(JobId jobId) {
      this.jobId = jobId;
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    @Override
    Builder setStatus(JobStatus status) {
      this.status = status;
      return this;
    }

    @Override
    Builder setStatistics(JobStatistics statistics) {
      this.statistics = statistics;
      return this;
    }

    @Override
    Builder setUserEmail(String userEmail) {
      this.userEmail = userEmail;
      return this;
    }


    @Override
    public Builder setConfiguration(JobConfiguration configuration) {
      this.configuration = configuration;
      return this;
    }

    @Override
    public JobInfo build() {
      return new JobInfo(this);
    }
  }

  JobInfo(BuilderImpl builder) {
    this.jobId = builder.jobId;
    this.etag = builder.etag;
    this.generatedId = builder.generatedId;
    this.selfLink = builder.selfLink;
    this.status = builder.status;
    this.statistics = builder.statistics;
    this.userEmail = builder.userEmail;
    this.configuration = builder.configuration;
  }


  /**
   * Returns the hash of the job resource.
   */
  public String getEtag() {
    return etag;
  }


  /**
   * Returns the service-generated id for the job.
   */
  public String getGeneratedId() {
    return generatedId;
  }


  /**
   * Returns the job identity.
   */
  public JobId getJobId() {
    return jobId;
  }


  /**
   * Returns an URL that can be used to access the resource again. The returned URL can be used for
   * GET requests.
   */
  public String getSelfLink() {
    return selfLink;
  }


  /**
   * Returns the status of this job. Examine this value when polling an asynchronous job to see if
   * the job is complete.
   */
  public JobStatus getStatus() {
    return status;
  }


  /**
   * Returns information about the job, including starting time and ending time of the job.
   */
  @SuppressWarnings("unchecked")
  public <S extends JobStatistics> S getStatistics() {
    return (S) statistics;
  }


  /**
   * Returns the email address of the user who ran the job.
   */
  public String getUserEmail() {
    return userEmail;
  }


  /**
   * Returns the job's configuration.
   */
  @SuppressWarnings("unchecked")
  public <C extends JobConfiguration> C getConfiguration() {
    return (C) configuration;
  }

  /**
   * Returns a builder for the job object.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("job", jobId)
        .add("status", status)
        .add("statistics", statistics)
        .add("userEmail", userEmail)
        .add("etag", etag)
        .add("generatedId", generatedId)
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
    return obj == this
        || obj != null
        && obj.getClass().equals(JobInfo.class)
        && Objects.equals(toPb(), ((JobInfo) obj).toPb());
  }

  JobInfo setProjectId(String projectId) {
    Builder builder = toBuilder();
    if (jobId != null) {
      builder.setJobId(jobId.setProjectId(projectId));
    }
    return builder.setConfiguration(configuration.setProjectId(projectId)).build();
  }

  Job toPb() {
    Job jobPb = new Job();
    jobPb.setEtag(etag);
    jobPb.setId(generatedId);
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


  /**
   * Returns a builder for a {@code JobInfo} object given the job configuration. Use
   * {@link CopyJobConfiguration} for a job that copies an existing table. Use
   * {@link ExtractJobConfiguration} for a job that exports a table to Google Cloud Storage. Use
   * {@link LoadJobConfiguration} for a job that loads data from Google Cloud Storage into a table.
   * Use {@link QueryJobConfiguration} for a job that runs a query.
   */
  public static Builder newBuilder(JobConfiguration configuration) {
    return new BuilderImpl().setConfiguration(configuration);
  }

  /**
   * Returns a {@code JobInfo} object given the job configuration. Use {@link CopyJobConfiguration}
   * for a job that copies an existing table. Use {@link ExtractJobConfiguration} for a job that
   * exports a table to Google Cloud Storage. Use {@link LoadJobConfiguration} for a job that loads
   * data from Google Cloud Storage into a table. Use {@link QueryJobConfiguration} for a job that
   * runs a query.
   */
  public static JobInfo of(JobConfiguration configuration) {
    return newBuilder(configuration).build();
  }

  /**
   * Returns a builder for a {@code JobInfo} object given the job identity and configuration. Use
   * {@link CopyJobConfiguration} for a job that copies an existing table. Use
   * {@link ExtractJobConfiguration} for a job that exports a table to Google Cloud Storage. Use
   * {@link LoadJobConfiguration} for a job that loads data from Google Cloud Storage into a table.
   * Use {@link QueryJobConfiguration} for a job that runs a query.
   */
  public static JobInfo of(JobId jobId, JobConfiguration configuration) {
    return newBuilder(configuration).setJobId(jobId).build();
  }

  static JobInfo fromPb(Job jobPb) {
    return new BuilderImpl(jobPb).build();
  }
}
