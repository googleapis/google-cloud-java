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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.Clock;
import com.google.cloud.WaitForOption;
import com.google.cloud.WaitForOption.CheckingPeriod;
import com.google.cloud.WaitForOption.Timeout;
import com.google.cloud.bigquery.BigQuery.JobOption;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A Google BigQuery Job.
 *
 * <p>Objects of this class are immutable. To get a {@code Job} object with the most recent
 * information use {@link #reload}. {@code Job} adds a layer of service-related functionality over
 * {@link JobInfo}.
 * </p>
 */
public class Job extends JobInfo {

  private static final long serialVersionUID = -4324100991693024704L;

  private final BigQueryOptions options;
  private transient BigQuery bigquery;

  /**
   * A builder for {@code Job} objects.
   */
  public static final class Builder extends JobInfo.Builder {

    private final BigQuery bigquery;
    private final JobInfo.BuilderImpl infoBuilder;

    Builder(BigQuery bigquery, JobConfiguration configuration) {
      this.bigquery = bigquery;
      this.infoBuilder = new JobInfo.BuilderImpl();
      this.infoBuilder.setConfiguration(configuration);
    }

    Builder(Job job) {
      this.bigquery = job.bigquery;
      this.infoBuilder = new JobInfo.BuilderImpl(job);
    }

    @Override
    Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      infoBuilder.setGeneratedId(generatedId);
      return this;
    }


    @Override
    public Builder setJobId(JobId jobId) {
      infoBuilder.setJobId(jobId);
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      infoBuilder.setSelfLink(selfLink);
      return this;
    }

    @Override
    Builder setStatus(JobStatus status) {
      infoBuilder.setStatus(status);
      return this;
    }

    @Override
    Builder setStatistics(JobStatistics statistics) {
      infoBuilder.setStatistics(statistics);
      return this;
    }

    @Override
    Builder setUserEmail(String userEmail) {
      infoBuilder.setUserEmail(userEmail);
      return this;
    }


    @Override
    public Builder setConfiguration(JobConfiguration configuration) {
      infoBuilder.setConfiguration(configuration);
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
    this.options = bigquery.getOptions();
  }

  /**
   * Checks if this job exists.
   *
   * <p>Example of checking that a job exists.
   * <pre> {@code
   * if (!job.exists()) {
   *   // job doesn't exist
   * }
   * }</pre>
   *
   * @return {@code true} if this job exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getJob(getJobId(), JobOption.fields()) != null;
  }

  /**
   * Checks if this job has completed its execution, either failing or succeeding. If the job does
   * not exist this method returns {@code true}.
   *
   * <p>Example of waiting for a job until it reports that it is done.
   * <pre> {@code
   * while (!job.isDone()) {
   *   Thread.sleep(1000L);
   * }
   * }</pre>
   *
   * @return {@code true} if this job is in {@link JobStatus.State#DONE} state or if it does not
   *     exist, {@code false} if the state is not {@link JobStatus.State#DONE}
   * @throws BigQueryException upon failure
   */
  public boolean isDone() {
    Job job = bigquery.getJob(getJobId(), JobOption.fields(BigQuery.JobField.STATUS));
    return job == null || job.getStatus().getState() == JobStatus.State.DONE;
  }

  /**
   * Blocks until this job completes its execution, either failing or succeeding. This method
   * returns current job's latest information. If the job no longer exists, this method returns
   * {@code null}. By default, the job status is checked every 500 milliseconds, to configure this
   * value use {@link WaitForOption#checkEvery(long, TimeUnit)}. Use
   * {@link WaitForOption#timeout(long, TimeUnit)} to set the maximum time to wait.
   *
   * <p>Example usage of {@code waitFor()}.
   * <pre> {@code
   * Job completedJob = job.waitFor();
   * if (completedJob == null) {
   *   // job no longer exists
   * } else if (completedJob.getStatus().getError() != null) {
   *   // job failed, handle error
   * } else {
   *   // job completed successfully
   * }
   * }</pre>
   *
   * <p>Example usage of {@code waitFor()} with checking period and timeout.
   * <pre> {@code
   * Job completedJob =
   *     job.waitFor(
   *         WaitForOption.checkEvery(1, TimeUnit.SECONDS),
   *         WaitForOption.timeout(60, TimeUnit.SECONDS));
   * if (completedJob == null) {
   *   // job no longer exists
   * } else if (completedJob.getStatus().getError() != null) {
   *   // job failed, handle error
   * } else {
   *   // job completed successfully
   * }
   * }</pre>
   *
   * @param waitOptions options to configure checking period and timeout
   * @throws BigQueryException upon failure
   * @throws InterruptedException if the current thread gets interrupted while waiting for the job
   *     to complete
   * @throws TimeoutException if the timeout provided with
   *     {@link WaitForOption#timeout(long, TimeUnit)} is exceeded. If no such option is provided
   *     this exception is never thrown.
   */
  public Job waitFor(WaitForOption... waitOptions) throws InterruptedException, TimeoutException {
    Timeout timeout = Timeout.getOrDefault(waitOptions);
    CheckingPeriod checkingPeriod = CheckingPeriod.getOrDefault(waitOptions);
    long timeoutMillis = timeout.getTimeoutMillis();
    Clock clock = options.getClock();
    long startTime = clock.millis();
    while (!isDone()) {
      if (timeoutMillis  != -1 && (clock.millis() - startTime)  >= timeoutMillis) {
        throw new TimeoutException();
      }
      checkingPeriod.sleep();
    }
    return reload();
  }

  /**
   * Fetches current job's latest information. Returns {@code null} if the job does not exist.
   *
   * <p>Example of reloading all fields until job status is DONE.
   * <pre> {@code
   * while (job.getStatus().getState() != JobStatus.State.DONE) {
   *   Thread.sleep(1000L);
   *   job = job.reload();
   * }
   * }</pre>
   *
   * <p>Example of reloading status field until job status is DONE.
   * <pre> {@code
   * while (job.getStatus().getState() != JobStatus.State.DONE) {
   *   Thread.sleep(1000L);
   *   job = job.reload(BigQuery.JobOption.fields(BigQuery.JobField.STATUS));
   * }
   * }</pre>
   *
   * @param options job options
   * @return a {@code Job} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Job reload(JobOption... options) {
    return bigquery.getJob(getJobId(), options);
  }

  /**
   * Sends a job cancel request.
   *
   * <p>Example of cancelling a job.
   * <pre> {@code
   * if (job.cancel()) {
   *   return true; // job successfully cancelled
   * } else {
   *   // job not found
   * }
   * }</pre>
   *
   * @return {@code true} if cancel request was sent successfully, {@code false} if job was not
   *     found
   * @throws BigQueryException upon failure
   */
  public boolean cancel() {
    return bigquery.cancel(getJobId());
  }


  /**
   * Returns the job's {@code BigQuery} object used to issue requests.
   */
  public BigQuery getBigquery() {
    return bigquery;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Job.class)) {
      return false;
    }
    Job other = (Job) obj;
    return Objects.equals(toPb(), other.toPb())
        && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.getService();
  }

  static Job fromPb(BigQuery bigquery, com.google.api.services.bigquery.model.Job jobPb) {
    return new Job(bigquery, new JobInfo.BuilderImpl(jobPb));
  }
}
