/*
 * Copyright 2016 Google LLC
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

import com.google.common.base.MoreObjects;
import com.google.logging.v2.LogSink;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cloud Logging sinks can be used to control the export of your logs. Each sink specifies the
 * export of a set of log entries to a certain destination. A sink consists of a name, unique to the
 * project, a filter for choosing the log entries to export and a destination for the log entries.
 *
 * <p>Sink destination can either be a Google Cloud Storage bucket (see {@link
 * Destination.BucketDestination}, a Google Cloud BigQuery dataset (see {@link
 * Destination.DatasetDestination}) or a Google Cloud Pub/Sub topic (see {@link
 * Destination.TopicDestination}).
 *
 * @see <a href="https://cloud.google.com/logging/docs/api/tasks/exporting-logs#about_sinks">About
 *     Sinks</a>
 */
public class SinkInfo implements Serializable {

  private static final long serialVersionUID = 6652676315712662729L;

  private final String name;
  private final Destination destination;
  private final String filter;
  private final VersionFormat versionFormat;

  public abstract static class Destination implements Serializable {

    private static final long serialVersionUID = 5257964588379880017L;

    private final Type type;

    /** Type of destination for Cloud Logging sink. */
    public enum Type {
      /** Specifies a Google Cloud Storage bucket as destination for the sink. */
      BUCKET,

      /** Specifies a Google Cloud BigQuery dataset as destination for the sink. */
      DATASET,

      /** Specifies a Google Cloud Pub/Sub topic as destination for the sink. */
      TOPIC,

      /** Specifies a Logging bucket as destination for the sink. */
      LOGGING_BUCKET
    }

    /** Class for specifying a Google Cloud Storage bucket as destination for the sink. */
    public static final class BucketDestination extends Destination {

      private static final long serialVersionUID = -7614931032119779091L;
      private static final String BASE_NAME = "storage.googleapis.com/";
      private static final String REGEX = BASE_NAME + "([^/]+)";
      private static final Pattern PATTERN = Pattern.compile(REGEX);

      private final String bucket;

      BucketDestination(String bucket) {
        super(Type.BUCKET);
        this.bucket = checkNotNull(bucket);
      }

      /** Returns the name of the Google Cloud Storage bucket this destination represents. */
      public String getBucket() {
        return bucket;
      }

      @Override
      public boolean equals(Object obj) {
        if (obj == this) {
          return true;
        }
        if (obj == null || !(obj instanceof BucketDestination)) {
          return false;
        }
        BucketDestination other = (BucketDestination) obj;
        return baseEquals(other) && bucket.equals(other.bucket);
      }

      @Override
      public int hashCode() {
        return Objects.hash(baseHashCode(), bucket);
      }

      static boolean matchesDestination(String destinationPb) {
        return PATTERN.matcher(destinationPb).matches();
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this).add("bucket", bucket).toString();
      }

      @Override
      String toPb(String projectId) {
        return BASE_NAME + bucket;
      }

      /**
       * Creates a {@code BucketDestination} object given the name of the bucket to be used as sink
       * destination.
       */
      public static BucketDestination of(String bucket) {
        return new BucketDestination(bucket);
      }

      static BucketDestination fromPb(String destinationPb) {
        Matcher matcher = PATTERN.matcher(destinationPb);
        if (!matcher.matches()) {
          throw new IllegalArgumentException(destinationPb + " is not a valid sink destination");
        }
        return new BucketDestination(matcher.group(1));
      }
    }

    /** Class for specifying a Google Cloud BigQuery dataset as destination for the sink. */
    public static final class DatasetDestination extends Destination {

      private static final long serialVersionUID = 6952354643801154411L;
      private static final String BASE_NAME = "bigquery.googleapis.com/";
      private static final String REGEX = BASE_NAME + "projects/([^/]+)/datasets/([^/]+)";
      private static final Pattern PATTERN = Pattern.compile(REGEX);

      private final String project;
      private final String dataset;

      DatasetDestination(String project, String dataset) {
        super(Type.DATASET);
        this.project = project;
        this.dataset = checkNotNull(dataset);
      }

      /**
       * Returns the name of the project where the Google Cloud BigQuery dataset resides. If {@code
       * null}, the default project is used.
       */
      public String getProject() {
        return project;
      }

      /** Returns the name of the Google Cloud BigQuery dataset this destination represents. */
      public String getDataset() {
        return dataset;
      }

      @Override
      public boolean equals(Object obj) {
        if (obj == this) {
          return true;
        }
        if (obj == null || !(obj instanceof DatasetDestination)) {
          return false;
        }
        DatasetDestination other = (DatasetDestination) obj;
        return baseEquals(other)
            && Objects.equals(project, other.project)
            && Objects.equals(dataset, other.dataset);
      }

      @Override
      public int hashCode() {
        return Objects.hash(baseHashCode(), project, dataset);
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("project", project)
            .add("dataset", dataset)
            .toString();
      }

      @Override
      String toPb(String projectId) {
        String project = this.project == null ? projectId : this.project;
        return BASE_NAME + "projects/" + project + "/datasets/" + dataset;
      }

      /**
       * Creates a {@code DatasetDestination} object given the name of the project and dataset to be
       * used as sink destination.
       */
      public static DatasetDestination of(String project, String dataset) {
        return new DatasetDestination(project, dataset);
      }

      /**
       * Creates a {@code DatasetDestination} object given the name of the dataset to be used as
       * sink destination. Dataset is assumed to reside in the default project.
       */
      public static DatasetDestination of(String dataset) {
        return new DatasetDestination(null, dataset);
      }

      static boolean matchesDestination(String destinationPb) {
        return PATTERN.matcher(destinationPb).matches();
      }

      static DatasetDestination fromPb(String destinationPb) {
        Matcher matcher = PATTERN.matcher(destinationPb);
        if (!matcher.matches()) {
          throw new IllegalArgumentException(destinationPb + " is not a valid sink destination");
        }
        return new DatasetDestination(matcher.group(1), matcher.group(2));
      }
    }

    public static final class LoggingBucketDestination extends Destination {

      private static final long serialVersionUID = 4894431968778789038L;
      private static final String BASE_NAME = "logging.googleapis.com/";
      private static final String REGEX =
          BASE_NAME + "projects/([^/]+)/locations/([^/]+)/buckets/([^/]+)";
      private static final Pattern PATTERN = Pattern.compile(REGEX);

      private final String project;
      private final String location;
      private final String bucket;

      LoggingBucketDestination(String project, String location, String bucket) {
        super(Type.LOGGING_BUCKET);
        this.project = project;
        this.location = checkNotNull(location);
        this.bucket = checkNotNull(bucket);
      }

      /**
       * Returns the name of the project where the Google Cloud BigQuery dataset resides. If {@code
       * null}, the default project is used.
       */
      public String getProject() {
        return project;
      }

      /** Returns the name of the bucket location this destination represents. */
      public String getLocation() {
        return location;
      }

      /** Returns the name of the logging bucket this destination represents. */
      public String getBucket() {
        return bucket;
      }

      @Override
      public boolean equals(Object obj) {
        if (obj == this) {
          return true;
        }
        if (obj == null || !(obj instanceof LoggingBucketDestination)) {
          return false;
        }
        LoggingBucketDestination other = (LoggingBucketDestination) obj;
        return baseEquals(other)
            && Objects.equals(project, other.project)
            && Objects.equals(location, other.location);
      }

      @Override
      public int hashCode() {
        return Objects.hash(baseHashCode(), project, location, bucket);
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("project", project)
            .add("location", location)
            .add("bucket", bucket)
            .toString();
      }

      @Override
      String toPb(String projectId) {
        String project = this.project == null ? projectId : this.project;
        return BASE_NAME + "projects/" + project + "/locations/" + location + "/buckets/" + bucket;
      }

      /**
       * Creates a {@code DatasetDestination} object given the name of the project and dataset to be
       * used as sink destination.
       */
      public static LoggingBucketDestination of(String project, String location, String bucket) {
        return new LoggingBucketDestination(project, location, bucket);
      }

      /**
       * Creates a {@code DatasetDestination} object given the name of the dataset to be used as
       * sink destination. Dataset is assumed to reside in the default project.
       */
      public static LoggingBucketDestination of(String location, String bucket) {
        return new LoggingBucketDestination(null, location, bucket);
      }

      static boolean matchesDestination(String destinationPb) {
        return PATTERN.matcher(destinationPb).matches();
      }

      static LoggingBucketDestination fromPb(String destinationPb) {
        Matcher matcher = PATTERN.matcher(destinationPb);
        if (!matcher.matches()) {
          throw new IllegalArgumentException(destinationPb + " is not a valid sink destination");
        }
        return new LoggingBucketDestination(matcher.group(1), matcher.group(2), matcher.group(3));
      }
    }

    /** Class for specifying a Google Cloud BigQuery dataset as destination for the sink. */
    public static final class TopicDestination extends Destination {

      private static final long serialVersionUID = -8252473597084887048L;
      private static final String BASE_NAME = "pubsub.googleapis.com/";
      private static final String REGEX = BASE_NAME + "projects/([^/]+)/topics/([^/]+)";
      private static final Pattern PATTERN = Pattern.compile(REGEX);

      private final String project;
      private final String topic;

      TopicDestination(String project, String topic) {
        super(Type.TOPIC);
        this.project = project;
        this.topic = checkNotNull(topic);
      }

      /**
       * Returns the name of the project where the Google Cloud Pub/Sub topic resides. If {@code
       * null}, the default project is used.
       */
      public String getProject() {
        return project;
      }

      /** Returns the name of the Google Cloud Pub/Sub topic this destination represents. */
      public String getTopic() {
        return topic;
      }

      @Override
      public boolean equals(Object obj) {
        if (obj == this) {
          return true;
        }
        if (obj == null || !(obj instanceof TopicDestination)) {
          return false;
        }
        TopicDestination other = (TopicDestination) obj;
        return baseEquals(other)
            && Objects.equals(project, other.project)
            && Objects.equals(topic, other.topic);
      }

      @Override
      public int hashCode() {
        return Objects.hash(baseHashCode(), project, topic);
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("project", project)
            .add("topic", topic)
            .toString();
      }

      @Override
      String toPb(String projectId) {
        String project = this.project == null ? projectId : this.project;
        return BASE_NAME + "projects/" + project + "/topics/" + topic;
      }

      /**
       * Creates a {@code TopicDestination} object given the name of the project and topic to be
       * used as sink destination.
       */
      public static TopicDestination of(String project, String topic) {
        return new TopicDestination(project, topic);
      }

      /**
       * Creates a {@code DatasetDestination} object given the name of the topic to be used as sink
       * destination. Topic is assumed to reside in the default project.
       */
      public static TopicDestination of(String topic) {
        return new TopicDestination(null, topic);
      }

      static boolean matchesDestination(String destinationPb) {
        return PATTERN.matcher(destinationPb).matches();
      }

      static TopicDestination fromPb(String destinationPb) {
        Matcher matcher = PATTERN.matcher(destinationPb);
        if (!matcher.matches()) {
          throw new IllegalArgumentException(destinationPb + " is not a valid sink destination");
        }
        return new TopicDestination(matcher.group(1), matcher.group(2));
      }
    }

    Destination(Type type) {
      this.type = checkNotNull(type);
    }

    /** Returns the type of this destination. */
    public Type getType() {
      return type;
    }

    final boolean baseEquals(Destination other) {
      return type.equals(other.type);
    }

    final int baseHashCode() {
      return Objects.hash(type);
    }

    abstract String toPb(String projectId);

    @SuppressWarnings("unchecked")
    static <T extends Destination> T fromPb(String destinationPb) {
      if (BucketDestination.matchesDestination(destinationPb)) {
        return (T) BucketDestination.fromPb(destinationPb);
      } else if (DatasetDestination.matchesDestination(destinationPb)) {
        return (T) DatasetDestination.fromPb(destinationPb);
      } else if (TopicDestination.matchesDestination(destinationPb)) {
        return (T) TopicDestination.fromPb(destinationPb);
      } else if (LoggingBucketDestination.matchesDestination(destinationPb)) {
        return (T) LoggingBucketDestination.fromPb(destinationPb);
      }
      throw new IllegalArgumentException(destinationPb + " is not a valid sink destination");
    }
  }

  /**
   * Available log entry formats. Log entries can be written to Cloud Logging in either format and
   * can be exported in either format. Version 2 is the preferred format.
   */
  public enum VersionFormat {
    V1(LogSink.VersionFormat.V1),
    V2(LogSink.VersionFormat.V2);

    private LogSink.VersionFormat versionPb;

    VersionFormat(LogSink.VersionFormat versionPb) {
      this.versionPb = versionPb;
    }

    LogSink.VersionFormat toPb() {
      return versionPb;
    }

    static VersionFormat fromPb(LogSink.VersionFormat versionPb) {
      switch (versionPb) {
        case V1:
          return VersionFormat.V1;
        case V2:
          return VersionFormat.V2;
        case VERSION_FORMAT_UNSPECIFIED:
          return null;
        default:
          throw new IllegalArgumentException(versionPb + " is not a valid version");
      }
    }
  }

  /** A builder for {@code SinkInfo} objects. */
  public abstract static class Builder {

    /**
     * Sets the name of the sink. Example: {@code my-severe-errors-to-pubsub}. Sink identifiers are
     * limited to 1000 characters and can include only the following characters: {@code A-Z}, {@code
     * a-z}, {@code 0-9}, and the special characters {@code _-.}.
     */
    public abstract Builder setName(String name);

    /**
     * Sets the export destination. Use a {@link Destination.BucketDestination} object to create a
     * sink that exports logs to a Google Cloud Storage bucket. Use a {@link
     * Destination.DatasetDestination} object to create a sink that exports logs to a Google Cloud
     * BigQuery dataset. Use a {@link Destination.TopicDestination} object to create a sink that
     * exports logs to a Google Cloud Pub/Sub topic.
     *
     * @see <a href="https://cloud.google.com/logging/docs/api/tasks/exporting-logs#about_sinks">
     *     Exporting Logs</a>
     */
    public abstract Builder setDestination(Destination destination);

    /**
     * Sets an advanced logs filter. Only log entries matching that filter are exported. The filter
     * must be consistent with the log entry format specified with {@link
     * #setVersionFormat(VersionFormat)}, regardless of the format of the log entry that was
     * originally written to Cloud Logging. Example (V2 format): {@code
     * logName=projects/my-projectid/logs/syslog AND severity>=ERROR}.
     *
     * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Log
     *     Filters</a>
     */
    public abstract Builder setFilter(String filter);

    /**
     * Sets the log entry version to use for this sink's exported log entries. This version does not
     * have to correspond to the version of the log entry when it was written to Google Cloud
     * Logging.
     */
    public abstract Builder setVersionFormat(VersionFormat versionFormat);

    /** Creates a {@code SinkInfo} object for this builder. */
    public abstract SinkInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String name;
    private Destination destination;
    private String filter;
    private VersionFormat versionFormat;

    BuilderImpl(String name, Destination destination) {
      this.name = name;
      this.destination = destination;
    }

    BuilderImpl(SinkInfo sink) {
      this.name = sink.name;
      this.destination = sink.destination;
      this.filter = sink.filter;
      this.versionFormat = sink.versionFormat;
    }

    @Override
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    @Override
    public Builder setDestination(Destination destination) {
      this.destination = destination;
      return this;
    }

    @Override
    public Builder setFilter(String filter) {
      this.filter = filter;
      return this;
    }

    @Override
    public Builder setVersionFormat(VersionFormat versionFormat) {
      this.versionFormat = versionFormat;
      return this;
    }

    @Override
    public SinkInfo build() {
      return new SinkInfo(this);
    }
  }

  SinkInfo(BuilderImpl builder) {
    this.name = checkNotNull(builder.name);
    this.destination = checkNotNull(builder.destination);
    this.filter = builder.filter;
    this.versionFormat = builder.versionFormat;
  }

  /**
   * Returns the name of the sink. Example: {@code my-severe-errors-to-pubsub}. Sink identifiers are
   * limited to 1000 characters and can include only the following characters: {@code A-Z}, {@code
   * a-z}, {@code 0-9}, and the special characters {@code _-.}.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the export destination. This method returns a {@link Destination.BucketDestination} for
   * sinks that export logs to Google Cloud Storage buckets. Returns {@link
   * Destination.DatasetDestination} for sinks that export logs to Google Cloud BigQuery datasets.
   * Returns {@link Destination.TopicDestination} for sinks that export logs to Google Cloud Pub/Sub
   * topics.
   *
   * @see <a href="https://cloud.google.com/logging/docs/api/tasks/exporting-logs#about_sinks">
   *     Exporting Logs</a>
   */
  @SuppressWarnings("unchecked")
  public <T extends Destination> T getDestination() {
    return (T) destination;
  }

  /**
   * Returns an advanced logs filter. Only log entries matching that filter are exported. The filter
   * must be consistent with the log entry format specified in {@link #getVersionFormat()},
   * regardless of the format of the log entry that wa originally written to Cloud Logging. Example
   * (V2 format): {@code logName=projects/my-projectid/logs/syslog AND severity>=ERROR}.
   *
   * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Log
   *     Filters</a>
   */
  public String getFilter() {
    return filter;
  }

  /**
   * Returns the log entry version to use for this sink's exported log entries. This version does
   * not have to correspond to the version of the log entry when it was written to Google Cloud
   * Logging.
   */
  public VersionFormat getVersionFormat() {
    return versionFormat;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("destination", destination)
        .add("filter", filter)
        .add("versionFormat", versionFormat)
        .toString();
  }

  final boolean baseEquals(SinkInfo sinkInfo) {
    return Objects.equals(name, sinkInfo.name)
        && Objects.equals(destination, sinkInfo.destination)
        && Objects.equals(filter, sinkInfo.filter)
        && Objects.equals(versionFormat, sinkInfo.versionFormat);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !(obj.getClass().equals(SinkInfo.class))) {
      return false;
    }
    return baseEquals((SinkInfo) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, destination, filter, versionFormat);
  }

  /** Returns a builder for this {@code SinkInfo} object. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  /**
   * Returns a builder for {@code SinkInfo} objects given the name of the sink and its destination.
   */
  public static Builder newBuilder(String name, Destination destination) {
    return new BuilderImpl(name, destination);
  }

  /** Creates a {@code SinkInfo} object given the name of the sink and its destination. */
  public static SinkInfo of(String name, Destination destination) {
    return new BuilderImpl(name, destination).build();
  }

  LogSink toPb(String projectId) {
    LogSink.Builder builder =
        LogSink.newBuilder().setName(name).setDestination(destination.toPb(projectId));
    if (filter != null) {
      builder.setFilter(filter);
    }
    return builder.build();
  }

  static SinkInfo fromPb(LogSink sinkPb) {
    Builder builder =
        newBuilder(sinkPb.getName(), Destination.fromPb(sinkPb.getDestination()))
            .setVersionFormat(VersionFormat.fromPb(LogSink.VersionFormat.V2));
    if (!sinkPb.getFilter().equals("")) {
      builder.setFilter(sinkPb.getFilter());
    }
    return builder.build();
  }
}
