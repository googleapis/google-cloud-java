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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.cloud.PageImpl;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryOption;
import com.google.cloud.bigquery.BigQuery.JobOption;
import com.google.cloud.bigquery.BigQuery.QueryResultsOption;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.JobConfiguration.Type;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * A Google BigQuery Job.
 *
 * <p>Objects of this class are immutable. To get a {@code Job} object with the most recent
 * information use {@link #reload}. {@code Job} adds a layer of service-related functionality over
 * {@link JobInfo}.
 */
public class Job extends JobInfo {

  private static final long serialVersionUID = -4324100991693024704L;

  private static final RetrySettings DEFAULT_JOB_WAIT_SETTINGS =
      RetrySettings.newBuilder()
          .setTotalTimeoutDuration(Duration.ofHours(12L))
          .setInitialRetryDelayDuration(Duration.ofSeconds(1L))
          .setRetryDelayMultiplier(2.0)
          .setJittered(true)
          .setMaxRetryDelayDuration(Duration.ofMinutes(1L))
          .build();

  static final RetrySettings DEFAULT_QUERY_JOB_WAIT_SETTINGS =
      RetrySettings.newBuilder()
          .setTotalTimeoutDuration(Duration.ofHours(12L))
          .setInitialRetryDelayDuration(Duration.ofSeconds(3L))
          .setRetryDelayMultiplier(1.0)
          .setJittered(true)
          .setMaxRetryDelayDuration(Duration.ofSeconds(3L))
          .build();

  static final QueryResultsOption[] DEFAULT_QUERY_WAIT_OPTIONS = {
    QueryResultsOption.pageSize(0L),
  };

  private final BigQueryOptions options;
  private transient BigQuery bigquery;
  private static final BigQueryRetryConfig DEFAULT_RETRY_CONFIG =
      BigQueryRetryConfig.newBuilder()
          .retryOnMessage(BigQueryErrorMessages.RATE_LIMIT_EXCEEDED_MSG)
          .build(); // retry config with Error Message for RateLimitExceeded Error

  /** A builder for {@code Job} objects. */
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
   *
   * <pre>{@code
   * if (!job.exists()) {
   *   // job doesn't exist
   * }
   * }</pre>
   *
   * @return {@code true} if this job exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    checkNotDryRun("exists");
    Span exists = null;
    if (options.isOpenTelemetryTracingEnabled() && options.getOpenTelemetryTracer() != null) {
      exists =
          options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.exists")
              .startSpan();
    }
    try (Scope existsScope = exists != null ? exists.makeCurrent() : null) {
      return bigquery.getJob(getJobId(), JobOption.fields()) != null;
    } finally {
      if (exists != null) {
        exists.end();
      }
    }
  }

  /**
   * Checks if this job has completed its execution, either failing or succeeding. If the job does
   * not exist this method returns {@code true}.
   *
   * <p>Example of waiting for a job until it reports that it is done.
   *
   * <pre>{@code
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
    checkNotDryRun("isDone");
    Span isDone = null;
    if (options.isOpenTelemetryTracingEnabled() && options.getOpenTelemetryTracer() != null) {
      isDone =
          options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.isDone")
              .startSpan();
    }
    try (Scope isDoneScope = isDone != null ? isDone.makeCurrent() : null) {
      Job job = bigquery.getJob(getJobId(), JobOption.fields(BigQuery.JobField.STATUS));
      return job == null || JobStatus.State.DONE.equals(job.getStatus().getState());
    } finally {
      if (isDone != null) {
        isDone.end();
      }
    }
  }

  /** See {@link #waitFor(BigQueryRetryConfig, RetryOption...)} */
  public Job waitFor(RetryOption... waitOptions) throws InterruptedException {
    return waitForInternal(DEFAULT_RETRY_CONFIG, waitOptions);
  }

  /**
   * Blocks until this job completes its execution, either failing or succeeding. This method
   * returns current job's latest information. If the job no longer exists, this method returns
   * {@code null}. By default, the job status is checked using jittered exponential backoff with 1
   * second as an initial delay, 2.0 as a backoff factor, 1 minute as maximum delay between polls,
   * 12 hours as a total timeout and unlimited number of attempts. For query jobs, the job status
   * check can be configured to retry on specific BigQuery error messages using {@link
   * BigQueryRetryConfig}. This {@link BigQueryRetryConfig} configuration is not available for
   * non-query jobs.
   *
   * <p>Example usage of {@code waitFor()}.
   *
   * <pre>{@code
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
   *
   * <pre>{@code
   * Job completedJob =
   *     job.waitFor(
   *         RetryOption.initialRetryDelay(Duration.ofSeconds(1)),
   *         RetryOption.totalTimeout(Duration.ofMinutes(1)));
   * if (completedJob == null) {
   *   // job no longer exists
   * } else if (completedJob.getStatus().getError() != null) {
   *   // job failed, handle error
   * } else {
   *   // job completed successfully
   * }
   * }</pre>
   *
   * <p>Example usage of {@code waitFor()} with BigQuery retry configuration to retry on rate limit
   * exceeded error messages for query jobs.
   *
   * <pre>{@code
   * Job completedJob =
   *     job.waitFor(
   *             BigQueryRetryConfig.newBuilder()
   *                 .retryOnMessage(BigQueryErrorMessages.RATE_LIMIT_EXCEEDED_MSG)
   *                 .retryOnMessage(BigQueryErrorMessages.JOB_RATE_LIMIT_EXCEEDED_MSG)
   *                 .retryOnRegEx(BigQueryErrorMessages.RetryRegExPatterns.RATE_LIMIT_EXCEEDED_REGEX)
   *                 .build());
   * if (completedJob == null) {
   *   // job no longer exists
   * } else if (completedJob.getStatus().getError() != null) {
   *   // job failed, handle error
   * } else {
   *   // job completed successfully
   * }
   * }</pre>
   *
   * @param bigQueryRetryConfig configures retries for query jobs for BigQuery failures
   * @param waitOptions options to configure checking period and timeout
   * @throws BigQueryException upon failure, check {@link BigQueryException#getCause()} for details
   * @throws InterruptedException if the current thread gets interrupted while waiting for the job
   *     to complete
   */
  public Job waitFor(BigQueryRetryConfig bigQueryRetryConfig, RetryOption... waitOptions)
      throws InterruptedException {
    return waitForInternal(bigQueryRetryConfig, waitOptions);
  }

  private Job waitForInternal(BigQueryRetryConfig bigQueryRetryConfig, RetryOption... waitOptions)
      throws InterruptedException {
    checkNotDryRun("waitFor");
    Span waitFor = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      waitFor =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.waitFor")
              .startSpan();
    }
    try (Scope waitForScope = waitFor != null ? waitFor.makeCurrent() : null) {
      Object completedJobResponse;
      if (getConfiguration().getType() == Type.QUERY) {
        completedJobResponse =
            waitForQueryResults(
                RetryOption.mergeToSettings(DEFAULT_JOB_WAIT_SETTINGS, waitOptions),
                bigQueryRetryConfig,
                DEFAULT_QUERY_WAIT_OPTIONS);
      } else {
        completedJobResponse =
            waitForJob(RetryOption.mergeToSettings(DEFAULT_QUERY_JOB_WAIT_SETTINGS, waitOptions));
      }

      return completedJobResponse == null ? null : reload();
    } finally {
      if (waitFor != null) {
        waitFor.end();
      }
    }
  }

  /**
   * Gets the query results of this job. This job must be of type {@code
   * JobConfiguration.Type.QUERY}, otherwise this method will throw {@link
   * UnsupportedOperationException}.
   *
   * <p>If the job hasn't finished, this method waits for the job to complete. However, the state of
   * the current {@code Job} instance is not updated. To get the new state, call {@link
   * #waitFor(RetryOption...)} or {@link #reload(JobOption...)}.
   *
   * @throws BigQueryException upon failure
   */
  public TableResult getQueryResults(QueryResultsOption... options)
      throws InterruptedException, JobException {
    checkNotDryRun("getQueryResults");

    Span getQueryResults = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getQueryResults =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.getQueryResults")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope getQueryResultsScope =
        getQueryResults != null ? getQueryResults.makeCurrent() : null) {

      if (getConfiguration().getType() != Type.QUERY) {
        throw new UnsupportedOperationException(
            "Getting query results is supported only for " + Type.QUERY + " jobs");
      }

      List<QueryResultsOption> waitOptions =
          new ArrayList<>(Arrays.asList(DEFAULT_QUERY_WAIT_OPTIONS));
      List<TableDataListOption> listOptions = new ArrayList<>();
      for (QueryResultsOption option : options) {
        switch (option.getRpcOption()) {
          case MAX_RESULTS:
            listOptions.add(TableDataListOption.pageSize((Long) option.getValue()));
            break;
          case PAGE_TOKEN:
            listOptions.add(TableDataListOption.pageToken((String) option.getValue()));
            break;
          case START_INDEX:
            listOptions.add(TableDataListOption.startIndex((Long) option.getValue()));
            break;
          case TIMEOUT:
            waitOptions.add(QueryResultsOption.maxWaitTime((Long) option.getValue()));
            break;
        }
      }

      QueryResponse response =
          waitForQueryResults(
              DEFAULT_JOB_WAIT_SETTINGS,
              DEFAULT_RETRY_CONFIG,
              waitOptions.toArray(new QueryResultsOption[0]));

      // Get the job resource to determine if it has errored.
      Job job = this;
      if (job.getStatus() == null || !JobStatus.State.DONE.equals(job.getStatus().getState())) {
        job = reload();
      }
      if (job.getStatus() != null && job.getStatus().getError() != null) {
        throw new BigQueryException(
            job.getStatus().getExecutionErrors() == null
                ? ImmutableList.of(job.getStatus().getError())
                : ImmutableList.copyOf(job.getStatus().getExecutionErrors()));
      }

      // If there are no rows in the result, this may have been a DDL query.
      // Listing table data might fail, such as with CREATE VIEW queries.
      // Avoid a tabledata.list API request by returning an empty TableResult.
      if (response.getTotalRows() == 0) {
        TableResult emptyTableResult =
            TableResult.newBuilder()
                .setSchema(response.getSchema())
                .setJobId(job.getJobId())
                .setTotalRows(0L)
                .setPageNoSchema(new PageImpl<FieldValueList>(null, "", null))
                .build();
        return emptyTableResult;
      }

      TableId table =
          ((QueryJobConfiguration) getConfiguration()).getDestinationTable() == null
              ? ((QueryJobConfiguration) job.getConfiguration()).getDestinationTable()
              : ((QueryJobConfiguration) getConfiguration()).getDestinationTable();
      TableResult tableResult =
          bigquery.listTableData(
              table, response.getSchema(), listOptions.toArray(new TableDataListOption[0]));
      TableResult tableResultWithJobId = tableResult.toBuilder().setJobId(job.getJobId()).build();
      return tableResultWithJobId;
    } finally {
      if (getQueryResults != null) {
        getQueryResults.end();
      }
    }
  }

  private QueryResponse waitForQueryResults(
      RetrySettings retrySettings,
      BigQueryRetryConfig bigQueryRetryConfig,
      final QueryResultsOption... resultsOptions)
      throws InterruptedException {
    if (getConfiguration().getType() != Type.QUERY) {
      throw new UnsupportedOperationException(
          "Waiting for query results is supported only for " + Type.QUERY + " jobs");
    }

    Span waitForQueryResults = null;
    if (options.isOpenTelemetryTracingEnabled() && options.getOpenTelemetryTracer() != null) {
      waitForQueryResults =
          options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.waitForQueryResults")
              .setAllAttributes(otelAttributesFromOptions(resultsOptions))
              .startSpan();
    }
    try (Scope waitForQueryResultsScope =
        waitForQueryResults != null ? waitForQueryResults.makeCurrent() : null) {
      return BigQueryRetryHelper.runWithRetries(
          new Callable<QueryResponse>() {
            @Override
            public QueryResponse call() {
              return bigquery.getQueryResults(getJobId(), resultsOptions);
            }
          },
          retrySettings,
          new BasicResultRetryAlgorithm<QueryResponse>() {
            @Override
            public boolean shouldRetry(
                Throwable prevThrowable,
                QueryResponse
                    prevResponse) { // Used by BigQueryRetryAlgorithm.shouldRetryBasedOnResult
              return prevResponse != null && !prevResponse.getCompleted();
            }
          },
          options.getClock(),
          bigQueryRetryConfig,
          options.isOpenTelemetryTracingEnabled(),
          options.getOpenTelemetryTracer());
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (waitForQueryResults != null) {
        waitForQueryResults.end();
      }
    }
  }

  private Job waitForJob(RetrySettings waitSettings) throws InterruptedException {
    Span waitForJob = null;
    if (options.isOpenTelemetryTracingEnabled() && options.getOpenTelemetryTracer() != null) {
      waitForJob =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.waitForJob")
              .setAttribute(
                  "bq.job.wait_settings.total_timeout",
                  getFieldAsString(waitSettings.getTotalTimeoutDuration()))
              .setAttribute(
                  "bq.job.wait_settings.initial_retry_delay",
                  getFieldAsString(waitSettings.getInitialRetryDelayDuration()))
              .setAttribute(
                  "bq.job.wait_settings.max_retry_delay",
                  getFieldAsString(waitSettings.getMaxRetryDelayDuration()))
              .setAttribute(
                  "bq.job.wait_settings.initial_rpc_timeout",
                  getFieldAsString(waitSettings.getInitialRpcTimeoutDuration()))
              .setAttribute(
                  "bq.job.wait_settings.max_rpc_timeout",
                  getFieldAsString(waitSettings.getMaxRpcTimeoutDuration()))
              .startSpan();
    }
    try (Scope waitForJobScope = waitForJob != null ? waitForJob.makeCurrent() : null) {
      return RetryHelper.poll(
          new Callable<Job>() {
            @Override
            public Job call() throws Exception {
              return bigquery.getJob(getJobId(), JobOption.fields(BigQuery.JobField.STATUS));
            }
          },
          waitSettings,
          new BasicResultRetryAlgorithm<Job>() {
            @Override
            public TimedAttemptSettings createNextAttempt(
                Throwable prevThrowable, Job prevResponse, TimedAttemptSettings prevSettings) {
              return null;
            }

            @Override
            public boolean shouldRetry(Throwable prevThrowable, Job prevResponse) {
              return prevResponse != null
                  && !JobStatus.State.DONE.equals(prevResponse.getStatus().getState());
            }
          },
          options.getClock());
    } catch (ExecutionException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (waitForJob != null) {
        waitForJob.end();
      }
    }
  }

  /**
   * Fetches current job's latest information. Returns {@code null} if the job does not exist.
   *
   * <p>Example of reloading all fields until job status is DONE.
   *
   * <pre>{@code
   * while (!JobStatus.State.DONE.equals(job.getStatus().getState())) {
   *   Thread.sleep(1000L);
   *   job = job.reload();
   * }
   * }</pre>
   *
   * <p>Example of reloading status field until job status is DONE.
   *
   * <pre>{@code
   * while (!JobStatus.State.DONE.equals(job.getStatus().getState())) {
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
    checkNotDryRun("reload");
    Span reload = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      reload =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.reload")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }

    try (Scope reloadScope = reload != null ? reload.makeCurrent() : null) {
      Job job = bigquery.getJob(getJobId(), options);
      if (job != null && job.getStatus().getError() != null) {
        throw new BigQueryException(
            job.getStatus().getExecutionErrors() == null
                ? ImmutableList.of(job.getStatus().getError())
                : ImmutableList.copyOf(job.getStatus().getExecutionErrors()));
      }
      return job;
    } finally {
      if (reload != null) {
        reload.end();
      }
    }
  }

  /**
   * Sends a job cancel request.
   *
   * <p>Example of cancelling a job.
   *
   * <pre>{@code
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
    checkNotDryRun("cancel");
    Span cancel = null;
    if (options.isOpenTelemetryTracingEnabled() && options.getOpenTelemetryTracer() != null) {
      cancel =
          options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.Job.cancel")
              .startSpan();
    }

    try (Scope cancelScope = cancel != null ? cancel.makeCurrent() : null) {
      return bigquery.cancel(getJobId());
    } finally {
      if (cancel != null) {
        cancel.end();
      }
    }
  }

  private void checkNotDryRun(String op) {
    checkNotDryRun(getConfiguration(), op);
  }

  static void checkNotDryRun(JobConfiguration jobConfig, String op) {
    QueryJobConfiguration config;
    if (jobConfig instanceof QueryJobConfiguration) {
      config = (QueryJobConfiguration) jobConfig;
    } else {
      return;
    }

    Boolean dryRun = config.dryRun();
    if (dryRun == null) {
      dryRun = false;
    }
    if (dryRun) {
      String msg =
          "Operation \"%s\" does not work for dryrun queries, "
              + "since a dry run does not actually create a job. "
              + "To validate a query and obtain some processing statistics, consider calling "
              + "BigQuery.create(JobInfo).";
      throw new UnsupportedOperationException(String.format(msg, op));
    }
  }

  /** Returns the job's {@code BigQuery} object used to issue requests. */
  public BigQuery getBigQuery() {
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
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
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

  private static Attributes otelAttributesFromOptions(Option... options) {
    Attributes attributes = Attributes.builder().build();
    for (Option option : options) {
      attributes =
          attributes.toBuilder()
              .put(option.getRpcOption().toString(), option.getValue().toString())
              .build();
    }
    return attributes;
  }

  private static String getFieldAsString(Object field) {
    return field == null ? "null" : field.toString();
  }
}
