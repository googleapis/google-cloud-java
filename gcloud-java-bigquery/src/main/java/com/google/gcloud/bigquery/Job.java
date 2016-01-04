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

/**
 * A Google BigQuery Job.
 *
 * <p>Objects of this class are immutable. To get a {@code Job} object with the most recent
 * information use {@link #reload}.
 * </p>
 */
public final class Job {

  private final BigQuery bigquery;
  private final JobInfo info;

  /**
   * Constructs a {@code Job} object for the provided {@code JobInfo}. The BigQuery service
   * is used to issue requests.
   *
   * @param bigquery the BigQuery service used for issuing requests
   * @param info jobs's info
   */
  public Job(BigQuery bigquery, JobInfo info) {
    this.bigquery = checkNotNull(bigquery);
    this.info = checkNotNull(info);
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
  public static Job load(BigQuery bigquery, String job, BigQuery.JobOption... options) {
    JobInfo info = bigquery.getJob(job, options);
    return info != null ? new Job(bigquery, info) : null;
  }

  /**
   * Returns the job's information.
   */
  public JobInfo info() {
    return info;
  }

  /**
   * Checks if this job exists.
   *
   * @return {@code true} if this job exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getJob(info.jobId(), BigQuery.JobOption.fields()) != null;
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
    JobInfo job = bigquery.getJob(info.jobId(),
        BigQuery.JobOption.fields(BigQuery.JobField.STATUS));
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
    return Job.load(bigquery, info.jobId().job(), options);
  }

  /**
   * Sends a job cancel request.
   *
   * @return {@code true} if cancel request was sent successfully, {@code false} if job was not
   *     found
   * @throws BigQueryException upon failure
   */
  public boolean cancel() {
    return bigquery.cancel(info.jobId());
  }

  /**
   * Returns the job's {@code BigQuery} object used to issue requests.
   */
  public BigQuery bigquery() {
    return bigquery;
  }
}
