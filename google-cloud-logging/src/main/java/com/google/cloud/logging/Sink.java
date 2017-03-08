/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.gax.core.ApiFuture;
import com.google.common.base.Function;
import com.google.logging.v2.LogSink;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * Stackdriver Logging sinks can be used to control the export of your logs. Each sink specifies the
 * export of a set of log entries to a certain destination. A sink consists of a name, unique to the
 * project, a filter for choosing the log entries to export and a destination for the log entries.
 *
 * <p>Sink destination can either be a Google Cloud Storage bucket (see
 * {@link SinkInfo.Destination.BucketDestination}, a Google Cloud BigQuery dataset (see
 * {@link SinkInfo.Destination.DatasetDestination}) or a Google CloudPub/Sub topic (see
 * {@link SinkInfo.Destination.TopicDestination}).
 *
 * <p>{@code Sink} adds a layer of service-related functionality over {@link SinkInfo}. Objects of
 * this class are immutable. To get a {@code Sink} object with the most recent information use
 * {@link #reload} or {@link #reloadAsync}.
 *
 * @see <a href="https://cloud.google.com/logging/docs/api/tasks/exporting-logs#about_sinks">About
 *     Sinks</a>
 */
public class Sink extends SinkInfo {

  private static final long serialVersionUID = -1549310461066853001L;

  private final LoggingOptions options;
  private transient Logging logging;

  /**
   * A builder for {@code Sink} objects.
   */
  public static final class Builder extends SinkInfo.Builder {

    private final Logging logging;
    private final BuilderImpl delegate;

    private Builder(Sink sink) {
      logging = sink.logging;
      delegate = new BuilderImpl(sink);
    }


    @Override
    public Builder setName(String name) {
      delegate.setName(name);
      return this;
    }


    @Override
    public Builder setDestination(Destination destination) {
      delegate.setDestination(destination);
      return this;
    }


    @Override
    public Builder setFilter(String filter) {
      delegate.setFilter(filter);
      return this;
    }


    @Override
    public Builder setVersionFormat(VersionFormat versionFormat) {
      delegate.setVersionFormat(versionFormat);
      return this;
    }

    @Override
    public Sink build() {
      return new Sink(this.logging, this.delegate);
    }
  }

  Sink(Logging logging, BuilderImpl builder) {
    super(builder);
    this.logging = checkNotNull(logging);
    options = logging.getOptions();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(options, super.hashCode());
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Sink.class)) {
      return false;
    }
    Sink other = (Sink) obj;
    return baseEquals(other) && Objects.equals(options, other.options);
  }


  /**
   * Returns the sinks's {@code Logging} object used to issue requests.
   */
  public Logging getLogging() {
    return logging;
  }

  /**
   * Deletes this sink.
   *
   * <p>Example of deleting the sink.
   * <pre> {@code
   * boolean deleted = sink.delete();
   * if (deleted) {
   *   // the sink was deleted
   * } else {
   *   // the sink was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the sink was deleted, {@code false} if it was not found
   * @throws LoggingException upon failure
   */
  public boolean delete() {
    return logging.deleteSink(getName());
  }

  /**
   * Sends a request for deleting this sink. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns {@code true} if the sink was deleted, {@code false}
   * if it was not found.
   *
   * <p>Example of asynchronously deleting the sink.
   * <pre> {@code
   * ApiFuture<Boolean> future = sink.deleteAsync();
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the sink was deleted
   * } else {
   *   // the sink was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  public ApiFuture<Boolean> deleteAsync() {
    return logging.deleteSinkAsync(getName());
  }

  /**
   * Fetches current sink's latest information. Returns {@code null} if the sink does not exist.
   *
   * <p>Example of getting the sink's latest information.
   * <pre> {@code
   * Sink latestSink = sink.reload();
   * if (latestSink == null) {
   *   // the sink was not found
   * }
   * }</pre>
   *
   * @return a {@code Sink} object with latest information or {@code null} if not found
   * @throws LoggingException upon failure
   */
  public Sink reload() {
    return logging.getSink(getName());
  }

  /**
   * Sends a request to fetch current sink's latest information. This method returns a
   * {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns a {@code Sink} object
   * with latest information or {@code null} if not found.
   *
   * <p>Example of asynchronously getting the sink's latest information.
   * <pre> {@code
   * ApiFuture<Sink> future = sink.reloadAsync();
   * // ...
   * Sink latestSink = future.get();
   * if (latestSink == null) {
   *   // the sink was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  public ApiFuture<Sink> reloadAsync() {
    return logging.getSinkAsync(getName());
  }

  /**
   * Updates current sink. If the sink does not exist, it is created.
   *
   * <p>Example of updating the sink's information.
   * <pre> {@code
   * Sink updatedSink = sink.toBuilder()
   *     .setFilter("severity<=ERROR")
   *     .build()
   *     .update();
   * }</pre>
   *
   * @return a {@code Sink} object with updated information
   * @throws LoggingException upon failure
   */
  public Sink update() {
    return logging.update(this);
  }

  /**
   * Sends a request to update current sink. If the sink does not exist, it is created. This method
   * returns a {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns a
   * {@code Sink} object with updated information.
   *
   * <p>Example of asynchronously updating the sink's information.
   * <pre> {@code
   * ApiFuture<Sink> future = sink.toBuilder()
   *     .setFilter("severity<=ERROR")
   *     .build()
   *     .updateAsync();
   * // ...
   * Sink updatedSink = future.get();
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  public ApiFuture<Sink> updateAsync() {
    return logging.updateAsync(this);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.logging = options.getService();
  }

  static Sink fromPb(Logging logging, LogSink sinkPb) {
    SinkInfo sinkInfo = SinkInfo.fromPb(sinkPb);
    return new Sink(logging, new BuilderImpl(sinkInfo));
  }

  static Function<LogSink, Sink> fromPbFunction(final Logging logging) {
    return new Function<LogSink, Sink>() {
      @Override
      public Sink apply(LogSink sinkPb) {
        return sinkPb != null ? fromPb(logging, sinkPb) : null;
      }
    };
  }
}
