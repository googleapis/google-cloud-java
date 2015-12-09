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
import com.google.common.base.MoreObjects.ToStringHelper;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for Google BigQuery Job information. Jobs are objects that manage asynchronous tasks
 * such as running queries, loading data, and exporting data. Use {@link CopyJobInfo} for a job that
 * copies an existing table. Use {@link ExtractJobInfo} for a job that exports a table to Google
 * Cloud Storage. Use {@link LoadJobInfo} for a job that loads data from Google Cloud Storage into
 * a table. Use {@link QueryJobInfo} for a job that runs a query.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs">Jobs</a>
 */
public abstract class JobInfo<S extends JobStatistics> implements Serializable {

  static final Function<Job, JobInfo> FROM_PB_FUNCTION =
      new Function<Job, JobInfo>() {
        @Override
        public JobInfo apply(Job pb) {
          return JobInfo.fromPb(pb);
        }
      };
  private static final long serialVersionUID = -7086529810736715842L;

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
  private final S statistics;
  private final String userEmail;

  public abstract static class Builder<T extends JobInfo, S extends JobStatistics,
      B extends Builder<T, S, B>> {

    private String etag;
    private String id;
    private JobId jobId;
    private String selfLink;
    private JobStatus status;
    private S statistics;
    private String userEmail;

    protected Builder() {}

    protected Builder(JobInfo<S> jobInfo) {
      this.etag = jobInfo.etag;
      this.id = jobInfo.id;
      this.jobId = jobInfo.jobId;
      this.selfLink = jobInfo.selfLink;
      this.status = jobInfo.status;
      this.statistics = jobInfo.statistics;
      this.userEmail = jobInfo.userEmail;

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
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    B etag(String etag) {
      this.etag = etag;
      return self();
    }

    B id(String id) {
      this.id = id;
      return self();
    }

    /**
     * Sets the job identity.
     */
    public B jobId(JobId jobId) {
      this.jobId = jobId;
      return self();
    }

    B selfLink(String selfLink) {
      this.selfLink = selfLink;
      return self();
    }

    B status(JobStatus status) {
      this.status = status;
      return self();
    }

    B statistics(S statistics) {
      this.statistics = statistics;
      return self();
    }

    B userEmail(String userEmail) {
      this.userEmail = userEmail;
      return self();
    }

    public abstract T build();
  }

  protected JobInfo(Builder<? extends JobInfo, ? extends S, ?> builder) {
    this.jobId = builder.jobId;
    this.etag = builder.etag;
    this.id = builder.id;
    this.selfLink = builder.selfLink;
    this.status = builder.status;
    this.statistics = builder.statistics;
    this.userEmail = builder.userEmail;
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
  public S statistics() {
    return statistics;
  }

  /**
   * Returns the email address of the user who ran the job.
   */
  public String userEmail() {
    return userEmail;
  }

  /**
   * Returns a builder for the job.
   */
  public abstract Builder toBuilder();

  ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("jobId", jobId)
        .add("status", status)
        .add("statistics", statistics)
        .add("userEmail", userEmail)
        .add("etag", etag)
        .add("id", id)
        .add("selfLink", selfLink);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof JobInfo && Objects.equals(toPb(), ((JobInfo) obj).toPb());
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
    return jobPb;
  }

  @SuppressWarnings("unchecked")
  static <T extends JobInfo> T fromPb(Job jobPb) {
    if (jobPb.getConfiguration().getLoad() != null) {
      return (T) LoadJobInfo.fromPb(jobPb);
    } else if (jobPb.getConfiguration().getCopy() != null) {
      return (T) CopyJobInfo.fromPb(jobPb);
    } else if (jobPb.getConfiguration().getExtract() != null) {
      return (T) ExtractJobInfo.fromPb(jobPb);
    } else  if (jobPb.getConfiguration().getQuery() != null) {
      return (T) QueryJobInfo.fromPb(jobPb);
    } else {
      // never reached
      throw new IllegalArgumentException("Job configuration is not supported");
    }
  }
}
