/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static java.util.Objects.requireNonNull;

import com.google.api.client.util.DateTime;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.storage.Conversions.Codec;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.ProjectName;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A collection of general utility functions providing convenience facilities.
 *
 * <p>Nothing in here should be Storage specific. Anything Storage specific should go in an
 * appropriately named and scoped class.
 */
@InternalApi
final class Utils {
  private static final Function<ImmutableMap.Builder<?, ?>, ImmutableMap<?, ?>> mapBuild;

  static {
    Function<ImmutableMap.Builder<?, ?>, ImmutableMap<?, ?>> tmp;
    // buildOrThrow was added in guava 31.0
    // if it fails, fallback to the older build() method instead.
    // The behavior was the same, but the new name makes the behavior clear
    try {
      ImmutableMap.builder().buildOrThrow();
      tmp = ImmutableMap.Builder::buildOrThrow;
    } catch (NoSuchMethodError e) {
      tmp = ImmutableMap.Builder::build;
    }
    mapBuild = tmp;
  }

  static final DateTimeFormatter RFC_3339_DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
  static final Codec<Duration, Long> durationSecondsCodec =
      Codec.of(Duration::getSeconds, Duration::ofSeconds);

  static final Codec<OffsetDateTime, String> offsetDateTimeRfc3339Codec =
      Codec.of(
          RFC_3339_DATE_TIME_FORMATTER::format,
          s -> OffsetDateTime.parse(s, RFC_3339_DATE_TIME_FORMATTER));

  @VisibleForTesting
  static final Codec<OffsetDateTime, DateTime> dateTimeCodec =
      Codec.of(
          odt -> {
            ZoneOffset offset = odt.getOffset();
            int i = Math.toIntExact(TimeUnit.SECONDS.toMinutes(offset.getTotalSeconds()));
            return new DateTime(odt.toInstant().toEpochMilli(), i);
          },
          dt -> {
            long milli = dt.getValue();
            int timeZoneShiftMinutes = dt.getTimeZoneShift();

            Duration timeZoneShift = Duration.of(timeZoneShiftMinutes, ChronoUnit.MINUTES);

            int hours = Math.toIntExact(timeZoneShift.toHours());
            int minutes =
                Math.toIntExact(
                    timeZoneShift.minusHours(timeZoneShift.toHours()).getSeconds() / 60);
            ZoneOffset offset = ZoneOffset.ofHoursMinutes(hours, minutes);

            return Instant.ofEpochMilli(milli).atOffset(offset);
          });

  static final Codec<OffsetDateTime, DateTime> nullableDateTimeCodec = dateTimeCodec.nullable();

  /**
   * Define a Codec which encapsulates the logic necessary to handle encoding and decoding bucket
   * names.
   *
   * <p>The "Model Type" in this case is the raw bucket name as would be read from {@link
   * BucketInfo#getName()}. The "Proto Type" in this case is the OnePlatform formatted
   * representation of the bucket name.
   *
   * <p>As of the time of writing this, project scoped buckets are not implemented by the backend
   * service. While we need to be cognisant that they are on the horizon, we do not need to track
   * any data related to this future feature. As such, this method attempts to make it easier to
   * work with bucket names that require the OnePlatform format while still preventing any subtle
   * bugs happening to customers if they happen to attempt to use project scoped bucket features in
   * this library once the service does support it.
   *
   * <p>TODO: this will need to change once the project scoped buckets first class feature work is
   * done.
   */
  static final Codec<String, String> bucketNameCodec =
      Codec.of(
          bucket -> {
            requireNonNull(bucket, "bucket must be non null");
            if (bucket.startsWith("projects/")) {
              if (bucket.startsWith("projects/_")) {
                return bucket;
              } else {
                throw new IllegalArgumentException(
                    "Project scoped buckets are not supported by this version of the library."
                        + " (bucket = "
                        + bucket
                        + ")");
              }
            } else {
              return "projects/_/buckets/" + bucket;
            }
          },
          resourceName -> {
            requireNonNull(resourceName, "resourceName must be non null");
            if (BucketName.isParsableFrom(resourceName)) {
              BucketName parse = BucketName.parse(resourceName);
              return parse.getBucket();
            } else {
              return resourceName;
            }
          });

  /**
   * Define a Codec which encapsulates the logic necessary to handle encoding and decoding project
   * names.
   */
  static final Codec<String, String> projectNameCodec =
      Codec.of(
          project -> {
            requireNonNull(project, "project must be non null");
            if (project.startsWith("projects/")) {
              return project;
            } else {
              return "projects/" + project;
            }
          },
          resourceName -> {
            requireNonNull(resourceName, "resourceName must be non null");
            if (ProjectName.isParsableFrom(resourceName)) {
              ProjectName parse = ProjectName.parse(resourceName);
              return parse.getProject();
            } else {
              return resourceName;
            }
          });

  /**
   * Define a Codec which encapsulates the logic necessary to handle encoding and decoding project
   * numbers.
   */
  static final Codec<@NonNull BigInteger, @NonNull String> projectNumberResourceCodec =
      Codec.of(
          projectNumber -> {
            requireNonNull(projectNumber, "projectNumber must be non null");
            return ProjectName.format(projectNumber.toString());
          },
          projectNumberResource -> {
            requireNonNull(projectNumberResource, "projectNumberResource must be non null");
            Preconditions.checkArgument(
                ProjectName.isParsableFrom(projectNumberResource),
                "projectNumberResource '%s' is not parsable as a %s",
                projectNumberResource,
                ProjectName.class.getName());
            ProjectName parse = ProjectName.parse(projectNumberResource);
            return new BigInteger(parse.getProject());
          });

  static final Codec<Integer, String> crc32cCodec =
      Codec.of(Utils::crc32cEncode, Utils::crc32cDecode);

  private Utils() {}

  /**
   * If the value provided as {@code t} is non-null, consume it via {@code c}.
   *
   * <p>Helper method to allow for more terse expression of:
   *
   * <pre>{@code
   * if (t != null) {
   *   x.setT(t);
   * }
   * }</pre>
   */
  @InternalApi
  static <T> void ifNonNull(@Nullable T t, Consumer<T> c) {
    if (t != null) {
      c.accept(t);
    }
  }

  /**
   * If the value provided as {@code t} is non-null, transform it using {@code map} and consume it
   * via {@code c}.
   *
   * <p>Helper method to allow for more terse expression of:
   *
   * <pre>{@code
   * if (t != null) {
   *   x.setT(map.apply(t));
   * }
   * }</pre>
   */
  @InternalApi
  static <T1, T2> void ifNonNull(@Nullable T1 t, Function<T1, T2> map, Consumer<T2> c) {
    if (t != null) {
      T2 apply = map.apply(t);
      if (apply != null) {
        c.accept(apply);
      }
    }
  }

  /**
   * Convenience method to "lift" a method reference to a {@link Function}.
   *
   * <p>While a method reference can be pass as an argument to a method which expects a {@code
   * Function} it does not then allow calling {@link Function#andThen(Function) #andThen(Function)}.
   * This method forces the method reference to be a {@code Function} thereby allowing {@code
   * #andThen} composition.
   */
  @InternalApi
  static <T1, T2> Function<T1, T2> lift(Function<T1, T2> f) {
    return f;
  }

  /**
   * Convenience method to resolve the first non-null {@code T} from an array of suppliers.
   *
   * <p>Each supplier will have {@link Supplier#get()} called, and if non-null the value will be
   * returned.
   */
  @NonNull
  @SafeVarargs
  static <T> T firstNonNull(Supplier<@Nullable T>... ss) {
    for (Supplier<T> s : ss) {
      T t = s.get();
      if (t != null) {
        return t;
      }
    }
    throw new IllegalStateException("Unable to resolve non-null value");
  }

  /**
   * Diff two maps, and append each differing key to {@code sink} with the parent of {{@code parent}
   */
  static void diffMaps(
      NamedField parent, Map<String, ?> left, Map<String, ?> right, Consumer<NamedField> sink) {
    final Stream<String> keys;
    if (left != null && right == null) {
      keys = left.keySet().stream();
    } else if (left == null && right != null) {
      keys = right.keySet().stream();
    } else if (left != null && right != null) {
      MapDifference<String, ?> difference = Maps.difference(left, right);
      keys =
          Stream.of(
                  // keys with modified values
                  difference.entriesDiffering().keySet().stream(),
                  // Only include keys to remove if ALL keys were removed
                  right.isEmpty()
                      ? difference.entriesOnlyOnLeft().keySet().stream()
                      : Stream.<String>empty(),
                  // new keys
                  difference.entriesOnlyOnRight().keySet().stream())
              .flatMap(x -> x);
    } else {
      keys = Stream.empty();
    }
    keys.map(NamedField::literal).map(k -> NamedField.nested(parent, k)).forEach(sink);
  }

  static <T> T[] subArray(T[] ts, int offset, int length) {
    if (offset == 0 && length == ts.length) {
      return ts;
    } else {
      return Arrays.copyOfRange(ts, offset, length);
    }
  }

  private static int crc32cDecode(String from) {
    byte[] decodeCrc32c = BaseEncoding.base64().decode(from);
    return Ints.fromByteArray(decodeCrc32c);
  }

  private static String crc32cEncode(int from) {
    return BaseEncoding.base64().encode(Ints.toByteArray(from));
  }

  /**
   * Type preserving method for {@link GrpcCallContext#merge(ApiCallContext)}
   *
   * @see GrpcCallContext#merge(ApiCallContext)
   */
  @NonNull
  static GrpcCallContext merge(@NonNull GrpcCallContext l, @NonNull GrpcCallContext r) {
    return (GrpcCallContext) l.merge(r);
  }

  static <T> ImmutableList<T> nullSafeList(@Nullable T t) {
    if (t == null) {
      return ImmutableList.of();
    } else {
      return ImmutableList.of(t);
    }
  }

  static <K, V> ImmutableMap<K, V> mapBuild(ImmutableMap.Builder<K, V> b) {
    return (ImmutableMap<K, V>) mapBuild.apply(b);
  }

  static String headerNameToLowerCase(String headerName) {
    return headerName.toLowerCase(Locale.US);
  }

  static <K, V> Map<@NonNull K, @Nullable V> setToMap(
      Set<@NonNull K> s, Function<@NonNull K, @Nullable V> valueFunction) {
    // use hashmap so we can have null values
    HashMap<@NonNull K, @Nullable V> m = new HashMap<>();
    for (@NonNull K k : s) {
      m.put(k, valueFunction.apply(k));
    }
    return Collections.unmodifiableMap(m);
  }
}
