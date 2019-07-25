/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Contains all {@link ClientSideStatementValueConverter} implementations. */
class ClientSideStatementValueConverters {
  /** Map for mapping case-insensitive strings to enums. */
  private static final class CaseInsensitiveEnumMap<E extends Enum<E>> {
    private final Map<String, E> map = new HashMap<>();

    /** Create an map using the name of the enum elements as keys. */
    private CaseInsensitiveEnumMap(Class<E> elementType) {
      this(
          elementType,
          new Function<E, String>() {
            @Override
            public String apply(E input) {
              return input.name();
            }
          });
    }

    /** Create a map using the specific function to get the key per enum value. */
    private CaseInsensitiveEnumMap(Class<E> elementType, Function<E, String> keyFunction) {
      Preconditions.checkNotNull(elementType);
      Preconditions.checkNotNull(keyFunction);
      EnumSet<E> set = EnumSet.allOf(elementType);
      for (E e : set) {
        if (map.put(keyFunction.apply(e).toUpperCase(), e) != null) {
          throw new IllegalArgumentException(
              "Enum contains multiple elements with the same case-insensitive key");
        }
      }
    }

    private E get(String value) {
      Preconditions.checkNotNull(value);
      return map.get(value.toUpperCase());
    }
  }

  /** Converter from string to {@link Boolean} */
  static class BooleanConverter implements ClientSideStatementValueConverter<Boolean> {

    public BooleanConverter(String allowedValues) {}

    @Override
    public Class<Boolean> getParameterClass() {
      return Boolean.class;
    }

    @Override
    public Boolean convert(String value) {
      if ("true".equalsIgnoreCase(value)) {
        return Boolean.TRUE;
      }
      if ("false".equalsIgnoreCase(value)) {
        return Boolean.FALSE;
      }
      return null;
    }
  }

  /** Converter from string to {@link Duration}. */
  static class DurationConverter implements ClientSideStatementValueConverter<Duration> {
    private final Pattern allowedValues;

    public DurationConverter(String allowedValues) {
      // Remove the parentheses from the beginning and end.
      this.allowedValues =
          Pattern.compile(
              "(?is)\\A" + allowedValues.substring(1, allowedValues.length() - 1) + "\\z");
    }

    @Override
    public Class<Duration> getParameterClass() {
      return Duration.class;
    }

    @Override
    public Duration convert(String value) {
      Matcher matcher = allowedValues.matcher(value);
      if (matcher.find()) {
        if (matcher.group(0).equalsIgnoreCase("null")) {
          return Durations.fromNanos(0L);
        } else {
          Duration duration =
              ReadOnlyStalenessUtil.createDuration(
                  Long.valueOf(matcher.group(1)),
                  ReadOnlyStalenessUtil.parseTimeUnit(matcher.group(2)));
          if (duration.getSeconds() == 0L && duration.getNanos() == 0) {
            return null;
          }
          return duration;
        }
      }
      return null;
    }
  }

  /** Converter from string to possible values for read only staleness ({@link TimestampBound}). */
  static class ReadOnlyStalenessConverter
      implements ClientSideStatementValueConverter<TimestampBound> {
    private final Pattern allowedValues;
    private final CaseInsensitiveEnumMap<Mode> values = new CaseInsensitiveEnumMap<>(Mode.class);

    public ReadOnlyStalenessConverter(String allowedValues) {
      // Remove the single quotes at the beginning and end.
      this.allowedValues =
          Pattern.compile(
              "(?is)\\A" + allowedValues.substring(1, allowedValues.length() - 1) + "\\z");
    }

    @Override
    public Class<TimestampBound> getParameterClass() {
      return TimestampBound.class;
    }

    @Override
    public TimestampBound convert(String value) {
      Matcher matcher = allowedValues.matcher(value);
      if (matcher.find() && matcher.groupCount() >= 1) {
        Mode mode = null;
        int groupIndex = 0;
        for (int group = 1; group <= matcher.groupCount(); group++) {
          if (matcher.group(group) != null) {
            mode = values.get(matcher.group(group));
            if (mode != null) {
              groupIndex = group;
              break;
            }
          }
        }
        switch (mode) {
          case STRONG:
            return TimestampBound.strong();
          case READ_TIMESTAMP:
            return TimestampBound.ofReadTimestamp(
                ReadOnlyStalenessUtil.parseRfc3339(matcher.group(groupIndex + 1)));
          case MIN_READ_TIMESTAMP:
            return TimestampBound.ofMinReadTimestamp(
                ReadOnlyStalenessUtil.parseRfc3339(matcher.group(groupIndex + 1)));
          case EXACT_STALENESS:
            try {
              return TimestampBound.ofExactStaleness(
                  Long.valueOf(matcher.group(groupIndex + 2)),
                  ReadOnlyStalenessUtil.parseTimeUnit(matcher.group(groupIndex + 3)));
            } catch (IllegalArgumentException e) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, e.getMessage());
            }
          case MAX_STALENESS:
            try {
              return TimestampBound.ofMaxStaleness(
                  Long.valueOf(matcher.group(groupIndex + 2)),
                  ReadOnlyStalenessUtil.parseTimeUnit(matcher.group(groupIndex + 3)));
            } catch (IllegalArgumentException e) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, e.getMessage());
            }
          default:
            // fall through to allow the calling method to handle this
        }
      }
      return null;
    }
  }

  /** Converter for converting strings to {@link AutocommitDmlMode} values. */
  static class AutocommitDmlModeConverter
      implements ClientSideStatementValueConverter<AutocommitDmlMode> {
    private final CaseInsensitiveEnumMap<AutocommitDmlMode> values =
        new CaseInsensitiveEnumMap<>(AutocommitDmlMode.class);

    public AutocommitDmlModeConverter(String allowedValues) {}

    @Override
    public Class<AutocommitDmlMode> getParameterClass() {
      return AutocommitDmlMode.class;
    }

    @Override
    public AutocommitDmlMode convert(String value) {
      return values.get(value);
    }
  }

  /** Converter for converting string values to {@link TransactionMode} values. */
  static class TransactionModeConverter
      implements ClientSideStatementValueConverter<TransactionMode> {
    private final CaseInsensitiveEnumMap<TransactionMode> values =
        new CaseInsensitiveEnumMap<>(
            TransactionMode.class,
            new Function<TransactionMode, String>() {
              @Override
              public String apply(TransactionMode input) {
                return input.getStatementString();
              }
            });

    public TransactionModeConverter(String allowedValues) {}

    @Override
    public Class<TransactionMode> getParameterClass() {
      return TransactionMode.class;
    }

    @Override
    public TransactionMode convert(String value) {
      // Transaction mode may contain multiple spaces.
      String valueWithSingleSpaces = value.replaceAll("\\s+", " ");
      return values.get(valueWithSingleSpaces);
    }
  }
}
