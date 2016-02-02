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

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * A Google BigQuery Job.
 *
 * <p>Objects of this class are immutable. To get a {@code Job} object with the most recent
 * information use {@link #reload}. {@code Job} adds a layer of service-related functionality over
 * {@link JobInfo}.
 * </p>
 */
public final class Job extends JobInfo {

  private static final long serialVersionUID = -4324100991693024704L;

  private final BigQueryOptions options;
  private transient BigQuery bigquery;

  static final class Builder extends JobInfo.Builder {

    private final BigQuery bigquery;
    private final JobInfo.BuilderImpl infoBuilder;

    private Builder(BigQuery bigquery) {
      this.bigquery = bigquery;
      this.infoBuilder = new JobInfo.BuilderImpl();
    }

    private Builder(Job job) {
      this.bigquery = job.bigquery;
      this.infoBuilder = new JobInfo.BuilderImpl(job);
    }

    @Override
    Builder etag(String etag) {
      infoBuilder.etag(etag);
      return this;
    }

    @Override
    Builder id(String id) {
      infoBuilder.id(id);
      return this;
    }

    @Override
    public Builder jobId(JobId jobId) {
      infoBuilder.jobId(jobId);
      return this;
    }

    @Override
    Builder selfLink(String selfLink) {
      infoBuilder.selfLink(selfLink);
      return this;
    }

    @Override
    Builder status(JobStatus status) {
      infoBuilder.status(status);
      return this;
    }

    @Override
    Builder statistics(JobStatistics statistics) {
      infoBuilder.statistics(statistics);
      return this;
    }

    @Override
    Builder userEmail(String userEmail) {
      infoBuilder.userEmail(userEmail);
      return this;
    }

    @Override
    public Builder configuration(JobConfiguration configuration) {
      infoBuilder.configuration(configuration);
      return this;
    }

    @Override
    public Job build() {
      return new Job(bigquery, infoBuilder);
    }
  }

  Job(BigQuery bigquery, JobInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.bigquery = checkNotNull(bigquery);
    this.options = bigquery.options();
  }

  /**
   * Creates a {@code Job} object for the provided job's user-defined id. Performs an RPC call to
   * get the latest job information.
   *
   * @param bigquery the BigQuery service used for issuing requests
   * @param job job's id, either user-defined or picked by the BigQuery service
   * @param options job options
   * @return the {@code Job} object or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public static Job get(BigQuery bigquery, String job, BigQuery.JobOption... options) {
    return bigquery.getJob(job, options);
  }

  /**
   * Checks if this job exists.
   *
   * @return {@code true} if this job exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getJob(jobId(), BigQuery.JobOption.fields()) != null;
  }

  /**
   * Checks if this job has completed its execution, either failing or succeeding. If the job does
   * not exist this method returns {@code false}. To correctly wait for job's completion check that
   * the job exists first, using {@link #exists()}:
   * <pre> {@code
   * if (job.exists()) {
   *   while(!job.isDone()) {
   *     Thread.sleep(1000L);
   *   }
   * }}</pre>
   *
   * @return {@code true} if this job is in {@link JobStatus.State#DONE} state, {@code false} if the
   *     state is not {@link JobStatus.State#DONE} or the job does not exist
   * @throws BigQueryException upon failure
   */
  public boolean isDone() {
    Job job = bigquery.getJob(jobId(), BigQuery.JobOption.fields(BigQuery.JobField.STATUS));
    return job != null && job.status().state() == JobStatus.State.DONE;
  }

  /**
   * Fetches current job's latest information. Returns {@code null} if the job does not exist.
   *
   * @param options job options
   * @return a {@code Job} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Job reload(BigQuery.JobOption... options) {
    return Job.get(bigquery, jobId().job(), options);
  }

  /**
   * Sends a job cancel request.
   *
   * @return {@code true} if cancel request was sent successfully, {@code false} if job was not
   *     found
   * @throws BigQueryException upon failure
   */
  public boolean cancel() {
    return bigquery.cancel(jobId());
  }

  /**
   * Returns the job's {@code BigQuery} object used to issue requests.
   */
  public BigQuery bigquery() {
    return bigquery;
  }

  static Builder builder(BigQuery bigquery, JobConfiguration configuration) {
    return new Builder(bigquery).configuration(configuration);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Job
        && Objects.equals(toPb(), ((Job) obj).toPb())
        && Objects.equals(options, ((Job) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.service();
  }

  static Job fromPb(BigQuery bigquery, com.google.api.services.bigquery.model.Job jobPb) {
    return new Job(bigquery, new JobInfo.BuilderImpl(jobPb));
  }
}
