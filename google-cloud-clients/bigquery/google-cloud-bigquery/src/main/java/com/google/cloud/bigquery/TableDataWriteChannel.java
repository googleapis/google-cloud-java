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

import static com.google.cloud.RetryHelper.runWithRetries;

import com.google.cloud.BaseWriteChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.RetryHelper;
import com.google.cloud.WriteChannel;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * {@link WriteChannel} implementation to stream data into a BigQuery table. Use {@link #getJob()}
 * to get the job used to insert streamed data. Please notice that {@link #getJob()} returns {@code
 * null} until the channel is closed.
 */
public class TableDataWriteChannel
    extends BaseWriteChannel<BigQueryOptions, WriteChannelConfiguration> {

  private Job job;

  TableDataWriteChannel(
      BigQueryOptions options, JobId jobId, WriteChannelConfiguration writeChannelConfiguration) {
    this(options, writeChannelConfiguration, open(options, jobId, writeChannelConfiguration));
  }

  TableDataWriteChannel(
      BigQueryOptions options, WriteChannelConfiguration config, String uploadId) {
    super(options, config, uploadId);
  }

  @Override
  protected void flushBuffer(final int length, final boolean last) {
    try {
      com.google.api.services.bigquery.model.Job jobPb =
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Job>() {
                @Override
                public com.google.api.services.bigquery.model.Job call() {
                  return getOptions()
                      .getBigQueryRpcV2()
                      .write(getUploadId(), getBuffer(), 0, getPosition(), length, last);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryImpl.EXCEPTION_HANDLER,
              getOptions().getClock());
      job = jobPb != null ? Job.fromPb(getOptions().getService(), jobPb) : null;
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  protected StateImpl.Builder stateBuilder() {
    return StateImpl.builder(getOptions(), getEntity(), getUploadId(), job);
  }

  private static String open(
      final BigQueryOptions options,
      final JobId jobId,
      final WriteChannelConfiguration writeChannelConfiguration) {
    try {
      return runWithRetries(
          new Callable<String>() {
            @Override
            public String call() {
              return options
                  .getBigQueryRpcV2()
                  .open(
                      new com.google.api.services.bigquery.model.Job()
                          .setConfiguration(writeChannelConfiguration.toPb())
                          .setJobReference(jobId.toPb()));
            }
          },
          options.getRetrySettings(),
          BigQueryImpl.EXCEPTION_HANDLER,
          options.getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private void setJob(Job job) {
    this.job = job;
  }

  /**
   * Returns the {@code Job} created to insert the rows. The job is available only once the upload
   * finished and the channel was closed, returns {@code null} otherwise.
   */
  public Job getJob() {
    return job;
  }

  static class StateImpl
      extends BaseWriteChannel.BaseState<BigQueryOptions, WriteChannelConfiguration> {

    private static final long serialVersionUID = -2692851818766876346L;

    private final Job job;

    StateImpl(Builder builder) {
      super(builder);
      this.job = builder.job;
    }

    static class Builder
        extends BaseWriteChannel.BaseState.Builder<BigQueryOptions, WriteChannelConfiguration> {

      private final Job job;

      private Builder(
          BigQueryOptions options,
          WriteChannelConfiguration configuration,
          String uploadId,
          Job job) {
        super(options, configuration, uploadId);
        this.job = job;
      }

      public RestorableState<WriteChannel> build() {
        return new StateImpl(this);
      }
    }

    static Builder builder(
        BigQueryOptions options, WriteChannelConfiguration config, String uploadId, Job job) {
      return new Builder(options, config, uploadId, job);
    }

    @Override
    public WriteChannel restore() {
      TableDataWriteChannel channel = new TableDataWriteChannel(serviceOptions, entity, uploadId);
      channel.restore(this);
      channel.setJob(job);
      return channel;
    }

    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), job);
    }

    @Override
    public boolean equals(Object obj) {
      return super.equals(obj)
          && obj instanceof StateImpl
          && Objects.equals(job, ((StateImpl) obj).job);
    }

    @Override
    protected List<ValueHolder> toStringHelper() {
      List<ValueHolder> valueList = super.toStringHelper();
      valueList.add(ValueHolder.create("job", job));
      return valueList;
    }
  }
}
