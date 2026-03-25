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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ReadOnlyStalenessUtil.parseTimeUnit;
import static com.google.cloud.spanner.connection.ReadOnlyStalenessUtil.toChronoUnit;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.cloud.spanner.connection.PgTransactionMode.AccessMode;
import com.google.cloud.spanner.connection.PgTransactionMode.IsolationLevel;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
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
      this(elementType, Enum::name);
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
    static final BooleanConverter INSTANCE = new BooleanConverter();

    private BooleanConverter() {}

    /** Constructor that is needed for reflection. */
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

  /** Converter from string to {@link Boolean} */
  static class PgBooleanConverter implements ClientSideStatementValueConverter<Boolean> {

    public PgBooleanConverter(String allowedValues) {}

    @Override
    public Class<Boolean> getParameterClass() {
      return Boolean.class;
    }

    @Override
    public Boolean convert(String value) {
      if (value == null) {
        return null;
      }
      if (value.length() > 1
          && ((value.startsWith("'") && value.endsWith("'"))
              || (value.startsWith("\"") && value.endsWith("\"")))) {
        value = value.substring(1, value.length() - 1);
      }
      if ("true".equalsIgnoreCase(value)
          || "tru".equalsIgnoreCase(value)
          || "tr".equalsIgnoreCase(value)
          || "t".equalsIgnoreCase(value)
          || "on".equalsIgnoreCase(value)
          || "1".equalsIgnoreCase(value)
          || "yes".equalsIgnoreCase(value)
          || "ye".equalsIgnoreCase(value)
          || "y".equalsIgnoreCase(value)) {
        return Boolean.TRUE;
      }
      if ("false".equalsIgnoreCase(value)
          || "fals".equalsIgnoreCase(value)
          || "fal".equalsIgnoreCase(value)
          || "fa".equalsIgnoreCase(value)
          || "f".equalsIgnoreCase(value)
          || "off".equalsIgnoreCase(value)
          || "of".equalsIgnoreCase(value)
          || "0".equalsIgnoreCase(value)
          || "no".equalsIgnoreCase(value)
          || "n".equalsIgnoreCase(value)) {
        return Boolean.FALSE;
      }
      return null;
    }
  }

  /** Converter from string to a non-negative integer. */
  static class NonNegativeIntegerConverter implements ClientSideStatementValueConverter<Integer> {
    static final NonNegativeIntegerConverter INSTANCE = new NonNegativeIntegerConverter();

    private NonNegativeIntegerConverter() {}

    /** Constructor needed for reflection. */
    public NonNegativeIntegerConverter(String allowedValues) {}

    @Override
    public Class<Integer> getParameterClass() {
      return Integer.class;
    }

    @Override
    public Integer convert(String value) {
      try {
        int res = Integer.parseInt(value);
        if (res < 0) {
          // The conventions for these converters is to return null if the value is invalid.
          return null;
        }
        return res;
      } catch (Exception ignore) {
        return null;
      }
    }
  }

  /** Converter from string to a long. */
  static class LongConverter implements ClientSideStatementValueConverter<Long> {
    static final LongConverter INSTANCE = new LongConverter();

    private LongConverter() {}

    /** Constructor needed for reflection. */
    public LongConverter(String allowedValues) {}

    @Override
    public Class<Long> getParameterClass() {
      return Long.class;
    }

    @Override
    public Long convert(String value) {
      try {
        long res = Long.parseLong(value);
        if (res < 0) {
          // The conventions for these converters is to return null if the value is invalid.
          return null;
        }
        return res;
      } catch (Exception ignore) {
        return null;
      }
    }
  }

  /** Converter from string to {@link Duration}. */
  static class DurationConverter implements ClientSideStatementValueConverter<Duration> {
    static final DurationConverter INSTANCE =
        new DurationConverter("('(\\d{1,19})(s|ms|us|ns)'|\\d{1,19}|NULL)");

    private final String resetValue;

    private final Pattern allowedValues;

    public DurationConverter(String allowedValues) {
      this("NULL", allowedValues);
    }

    DurationConverter(String resetValue, String allowedValues) {
      this.resetValue = Preconditions.checkNotNull(resetValue);
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
        if (value.trim().equalsIgnoreCase(resetValue)) {
          return Duration.ZERO;
        } else {
          try {
            Duration duration;
            if (matcher.group(1) != null && matcher.group(2) != null) {
              ChronoUnit unit = toChronoUnit(parseTimeUnit(matcher.group(2)));
              duration = Duration.of(Long.parseLong(matcher.group(1)), unit);
            } else {
              duration = Duration.ofMillis(Long.parseLong(value.trim()));
            }
            // Converters should return null for invalid values.
            if (duration.isNegative()) {
              return null;
            }
            return duration;
          } catch (NumberFormatException exception) {
            // Converters should return null for invalid values.
            return null;
          }
        }
      }
      return null;
    }
  }

  /** Converter from string to {@link Duration}. */
  static class PgDurationConverter extends DurationConverter {
    public PgDurationConverter(String allowedValues) {
      super("DEFAULT", allowedValues);
    }
  }

  /** Converter from string to possible values for read only staleness ({@link TimestampBound}). */
  static class ReadOnlyStalenessConverter
      implements ClientSideStatementValueConverter<TimestampBound> {
    // Some backslashes need to be specified as hexcode.
    // See https://github.com/google/google-java-format/issues/1253
    static final ReadOnlyStalenessConverter INSTANCE =
        new ReadOnlyStalenessConverter(
            "'((STRONG)|(MIN_READ_TIMESTAMP)[\\t"
                + " ]+((\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d{1,9})?)([Zz]|([+-])(\\d{2}):(\\d{2})))|(READ_TIMESTAMP)[\u005Ct"
                + " ]+((\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(   "
                + " \\d{2})(\\.\\d{1,9})?)([Zz]|([+-])(\\d{2}):(\\d{2})))|(MAX_STALENESS)[\u005Ct"
                + " ]+((\\d{1,19})(s|ms|us|ns))|(EXACT_STALENESS)[\\t"
                + " ]+((\\d{1,19})(s|ms|us|ns)))'");

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
                  Long.parseLong(matcher.group(groupIndex + 2)),
                  parseTimeUnit(matcher.group(groupIndex + 3)));
            } catch (IllegalArgumentException e) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, e.getMessage());
            }
          case MAX_STALENESS:
            try {
              return TimestampBound.ofMaxStaleness(
                  Long.parseLong(matcher.group(groupIndex + 2)),
                  parseTimeUnit(matcher.group(groupIndex + 3)));
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

  /**
   * Converter from string to possible values for {@link com.google.spanner.v1.DirectedReadOptions}.
   */
  static class DirectedReadOptionsConverter
      implements ClientSideStatementValueConverter<DirectedReadOptions> {
    private final Pattern allowedValues;

    public DirectedReadOptionsConverter(String allowedValues) {
      // Remove the single quotes at the beginning and end.
      this.allowedValues =
          Pattern.compile(
              "(?is)\\A" + allowedValues.substring(1, allowedValues.length() - 1) + "\\z");
    }

    @Override
    public Class<DirectedReadOptions> getParameterClass() {
      return DirectedReadOptions.class;
    }

    @Override
    public DirectedReadOptions convert(String value) {
      Matcher matcher = allowedValues.matcher(value);
      if (matcher.find()) {
        try {
          return DirectedReadOptionsUtil.parse(value);
        } catch (SpannerException spannerException) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              String.format(
                  "Failed to parse '%s' as a valid value for DIRECTED_READ.\n"
                      + "The value should be a JSON string like this: '%s'.\n"
                      + "You can generate a valid JSON string from a DirectedReadOptions instance"
                      + " by calling %s.%s",
                  value,
                  "{\"includeReplicas\":{\"replicaSelections\":[{\"location\":\"eu-west1\",\"type\":\"READ_ONLY\"}]}}",
                  DirectedReadOptionsUtil.class.getName(),
                  "toString(DirectedReadOptions directedReadOptions)"),
              spannerException);
        }
      }
      return null;
    }
  }

  /**
   * Converter for converting strings to {@link
   * com.google.spanner.v1.TransactionOptions.IsolationLevel} values.
   */
  static class IsolationLevelConverter
      implements ClientSideStatementValueConverter<TransactionOptions.IsolationLevel> {
    static final IsolationLevelConverter INSTANCE = new IsolationLevelConverter();

    private final CaseInsensitiveEnumMap<TransactionOptions.IsolationLevel> values =
        new CaseInsensitiveEnumMap<>(TransactionOptions.IsolationLevel.class);

    IsolationLevelConverter() {}

    /** Constructor needed for reflection. */
    public IsolationLevelConverter(String allowedValues) {}

    @Override
    public Class<TransactionOptions.IsolationLevel> getParameterClass() {
      return TransactionOptions.IsolationLevel.class;
    }

    @Override
    public TransactionOptions.IsolationLevel convert(String value) {
      if (value != null) {
        // This ensures that 'repeatable read' is translated to 'repeatable_read'. The text between
        // 'repeatable' and 'read' can be any number of valid whitespace characters.
        value = value.trim().replaceFirst("\\s+", "_");
      }
      return values.get(value);
    }
  }

  /**
   * Converter for converting strings to {@link
   * com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode} values.
   */
  static class ReadLockModeConverter implements ClientSideStatementValueConverter<ReadLockMode> {
    static final ReadLockModeConverter INSTANCE = new ReadLockModeConverter();

    private final CaseInsensitiveEnumMap<ReadLockMode> values =
        new CaseInsensitiveEnumMap<>(ReadLockMode.class);

    ReadLockModeConverter() {}

    /** Constructor needed for reflection. */
    public ReadLockModeConverter(String allowedValues) {}

    @Override
    public Class<ReadLockMode> getParameterClass() {
      return ReadLockMode.class;
    }

    @Override
    public ReadLockMode convert(String value) {
      if (value != null && value.equalsIgnoreCase("unspecified")) {
        // Allow 'unspecified' to be used in addition to 'read_lock_mode_unspecified'.
        value = ReadLockMode.READ_LOCK_MODE_UNSPECIFIED.name();
      }
      return values.get(value);
    }
  }

  /** Converter for converting strings to {@link AutocommitDmlMode} values. */
  static class AutocommitDmlModeConverter
      implements ClientSideStatementValueConverter<AutocommitDmlMode> {
    static final AutocommitDmlModeConverter INSTANCE = new AutocommitDmlModeConverter();

    private final CaseInsensitiveEnumMap<AutocommitDmlMode> values =
        new CaseInsensitiveEnumMap<>(AutocommitDmlMode.class);

    private AutocommitDmlModeConverter() {}

    /** Constructor needed for reflection. */
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

  static class ConnectionStateTypeConverter
      implements ClientSideStatementValueConverter<ConnectionState.Type> {
    static final ConnectionStateTypeConverter INSTANCE = new ConnectionStateTypeConverter();

    private final CaseInsensitiveEnumMap<ConnectionState.Type> values =
        new CaseInsensitiveEnumMap<>(ConnectionState.Type.class);

    private ConnectionStateTypeConverter() {}

    /** Constructor that is needed for reflection. */
    public ConnectionStateTypeConverter(String allowedValues) {}

    @Override
    public Class<ConnectionState.Type> getParameterClass() {
      return ConnectionState.Type.class;
    }

    @Override
    public ConnectionState.Type convert(String value) {
      return values.get(value);
    }
  }

  static class StringValueConverter implements ClientSideStatementValueConverter<String> {
    static final StringValueConverter INSTANCE = new StringValueConverter();

    private StringValueConverter() {}

    /** Constructor needed for reflection. */
    public StringValueConverter(String allowedValues) {}

    @Override
    public Class<String> getParameterClass() {
      return String.class;
    }

    @Override
    public String convert(String value) {
      return value;
    }
  }

  /** Converter for converting string values to {@link TransactionMode} values. */
  static class TransactionModeConverter
      implements ClientSideStatementValueConverter<TransactionMode> {
    private final CaseInsensitiveEnumMap<TransactionMode> values =
        new CaseInsensitiveEnumMap<>(TransactionMode.class, TransactionMode::getStatementString);

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

  static class PgTransactionIsolationConverter
      implements ClientSideStatementValueConverter<IsolationLevel> {
    private final CaseInsensitiveEnumMap<IsolationLevel> values =
        new CaseInsensitiveEnumMap<>(IsolationLevel.class, IsolationLevel::getShortStatementString);

    public PgTransactionIsolationConverter(String allowedValues) {}

    @Override
    public Class<IsolationLevel> getParameterClass() {
      return IsolationLevel.class;
    }

    @Override
    public IsolationLevel convert(String value) {
      // Isolation level may contain multiple spaces.
      String valueWithSingleSpaces = value.replaceAll("\\s+", " ");
      if (valueWithSingleSpaces.length() > 1
          && ((valueWithSingleSpaces.startsWith("'") && valueWithSingleSpaces.endsWith("'"))
              || (valueWithSingleSpaces.startsWith("\"")
                  && valueWithSingleSpaces.endsWith("\"")))) {
        valueWithSingleSpaces =
            valueWithSingleSpaces.substring(1, valueWithSingleSpaces.length() - 1);
      }
      return values.get(valueWithSingleSpaces);
    }
  }

  /**
   * Converter for converting string values to {@link PgTransactionMode} values. Includes no-op
   * handling of setting the isolation level of the transaction to default or serializable.
   */
  static class PgTransactionModeConverter
      implements ClientSideStatementValueConverter<PgTransactionMode> {
    PgTransactionModeConverter() {}

    public PgTransactionModeConverter(String allowedValues) {}

    @Override
    public Class<PgTransactionMode> getParameterClass() {
      return PgTransactionMode.class;
    }

    @Override
    public PgTransactionMode convert(String value) {
      PgTransactionMode mode = new PgTransactionMode();
      // Transaction mode may contain multiple spaces.
      String valueWithoutDeferrable = value.replaceAll("(?i)(not\\s+deferrable)", " ");
      String valueWithSingleSpaces =
          valueWithoutDeferrable.replaceAll("\\s+", " ").toLowerCase(Locale.ENGLISH).trim();
      int currentIndex = 0;
      while (currentIndex < valueWithSingleSpaces.length()) {
        // This will use the last access mode and isolation level that is encountered in the string.
        // This is consistent with the behavior of PostgreSQL, which also allows multiple modes to
        // be specified in one string, and will use the last one that is encountered.
        if (valueWithSingleSpaces.substring(currentIndex).startsWith("read only")) {
          currentIndex += "read only".length();
          mode.setAccessMode(AccessMode.READ_ONLY_TRANSACTION);
        } else if (valueWithSingleSpaces.substring(currentIndex).startsWith("read write")) {
          currentIndex += "read write".length();
          mode.setAccessMode(AccessMode.READ_WRITE_TRANSACTION);
        } else if (valueWithSingleSpaces
            .substring(currentIndex)
            .startsWith("isolation level repeatable read")) {
          currentIndex += "isolation level repeatable read".length();
          mode.setIsolationLevel(IsolationLevel.ISOLATION_LEVEL_REPEATABLE_READ);
        } else if (valueWithSingleSpaces
            .substring(currentIndex)
            .startsWith("isolation level serializable")) {
          currentIndex += "isolation level serializable".length();
          mode.setIsolationLevel(IsolationLevel.ISOLATION_LEVEL_SERIALIZABLE);
        } else if (valueWithSingleSpaces
            .substring(currentIndex)
            .startsWith("isolation level default")) {
          currentIndex += "isolation level default".length();
          mode.setIsolationLevel(IsolationLevel.ISOLATION_LEVEL_DEFAULT);
        } else {
          return null;
        }
        // Skip space and/or comma that may separate multiple transaction modes.
        if (currentIndex < valueWithSingleSpaces.length()
            && valueWithSingleSpaces.charAt(currentIndex) == ' ') {
          currentIndex++;
        }
        if (currentIndex < valueWithSingleSpaces.length()
            && valueWithSingleSpaces.charAt(currentIndex) == ',') {
          currentIndex++;
        }
        if (currentIndex < valueWithSingleSpaces.length()
            && valueWithSingleSpaces.charAt(currentIndex) == ' ') {
          currentIndex++;
        }
      }
      return mode;
    }
  }

  /** Converter for converting strings to {@link RpcPriority} values. */
  static class RpcPriorityConverter implements ClientSideStatementValueConverter<RpcPriority> {
    static final RpcPriorityConverter INSTANCE = new RpcPriorityConverter("(HIGH|MEDIUM|LOW|NULL)");

    private final CaseInsensitiveEnumMap<RpcPriority> values =
        new CaseInsensitiveEnumMap<>(RpcPriority.class);
    private final Pattern allowedValues;

    public RpcPriorityConverter(String allowedValues) {
      // Remove the parentheses from the beginning and end.
      this.allowedValues =
          Pattern.compile(
              "(?is)\\A" + allowedValues.substring(1, allowedValues.length() - 1) + "\\z");
    }

    @Override
    public Class<RpcPriority> getParameterClass() {
      return RpcPriority.class;
    }

    @Override
    public RpcPriority convert(String value) {
      Matcher matcher = allowedValues.matcher(value);
      if (matcher.find()) {
        if (matcher.group(0).equalsIgnoreCase("null")) {
          return RpcPriority.UNSPECIFIED;
        }
      }
      return values.get(value);
    }
  }

  /** Converter for converting strings to {@link SavepointSupport} values. */
  static class SavepointSupportConverter
      implements ClientSideStatementValueConverter<SavepointSupport> {
    static final SavepointSupportConverter INSTANCE = new SavepointSupportConverter();

    private final CaseInsensitiveEnumMap<SavepointSupport> values =
        new CaseInsensitiveEnumMap<>(SavepointSupport.class);

    private SavepointSupportConverter() {}

    /** Constructor needed for reflection. */
    public SavepointSupportConverter(String allowedValues) {}

    @Override
    public Class<SavepointSupport> getParameterClass() {
      return SavepointSupport.class;
    }

    @Override
    public SavepointSupport convert(String value) {
      return values.get(value);
    }
  }

  /** Converter for converting strings to {@link DdlInTransactionMode} values. */
  static class DdlInTransactionModeConverter
      implements ClientSideStatementValueConverter<DdlInTransactionMode> {
    static final DdlInTransactionModeConverter INSTANCE = new DdlInTransactionModeConverter();

    private final CaseInsensitiveEnumMap<DdlInTransactionMode> values =
        new CaseInsensitiveEnumMap<>(DdlInTransactionMode.class);

    private DdlInTransactionModeConverter() {}

    /** Constructor needed for reflection. */
    public DdlInTransactionModeConverter(String allowedValues) {}

    @Override
    public Class<DdlInTransactionMode> getParameterClass() {
      return DdlInTransactionMode.class;
    }

    @Override
    public DdlInTransactionMode convert(String value) {
      return values.get(value);
    }
  }

  static class ExplainCommandConverter implements ClientSideStatementValueConverter<String> {
    @Override
    public Class<String> getParameterClass() {
      return String.class;
    }

    @Override
    public String convert(String value) {
      /* The first word in the string should be "explain"
       *  So, if the size of the string <= 7 (number of letters in the word "explain"), its an invalid statement
       *  If the size is greater than 7, we'll consider everything after explain as the query.
       */
      if (value.length() <= 7) {
        return null;
      }
      return value.substring(7).trim();
    }
  }

  /** Converter for converting Base64 encoded string to byte[] */
  static class ProtoDescriptorsConverter implements ClientSideStatementValueConverter<byte[]> {

    public ProtoDescriptorsConverter(String allowedValues) {}

    @Override
    public Class<byte[]> getParameterClass() {
      return byte[].class;
    }

    @Override
    public byte[] convert(String value) {
      if (value == null || value.length() == 0 || value.equalsIgnoreCase("null")) {
        return null;
      }
      try {
        return Base64.getDecoder().decode(value);
      } catch (IllegalArgumentException e) {
        return null;
      }
    }
  }

  /** Converter for converting String that take in file path as input to String */
  static class ProtoDescriptorsFileConverter implements ClientSideStatementValueConverter<String> {

    public ProtoDescriptorsFileConverter(String allowedValues) {}

    @Override
    public Class<String> getParameterClass() {
      return String.class;
    }

    @Override
    public String convert(String filePath) {
      if (Strings.isNullOrEmpty(filePath)) {
        return null;
      }
      return filePath;
    }
  }

  static class CredentialsProviderConverter
      implements ClientSideStatementValueConverter<CredentialsProvider> {
    static final CredentialsProviderConverter INSTANCE = new CredentialsProviderConverter();

    private CredentialsProviderConverter() {}

    @Override
    public Class<CredentialsProvider> getParameterClass() {
      return CredentialsProvider.class;
    }

    @Override
    public CredentialsProvider convert(String credentialsProviderName) {
      if (!Strings.isNullOrEmpty(credentialsProviderName)) {
        try {
          Class<? extends CredentialsProvider> clazz =
              (Class<? extends CredentialsProvider>) Class.forName(credentialsProviderName);
          Constructor<? extends CredentialsProvider> constructor = clazz.getDeclaredConstructor();
          return constructor.newInstance();
        } catch (ClassNotFoundException classNotFoundException) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              "Unknown or invalid CredentialsProvider class name: " + credentialsProviderName,
              classNotFoundException);
        } catch (NoSuchMethodException noSuchMethodException) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              "Credentials provider "
                  + credentialsProviderName
                  + " does not have a public no-arg constructor.",
              noSuchMethodException);
        } catch (InvocationTargetException
            | InstantiationException
            | IllegalAccessException exception) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              "Failed to create an instance of "
                  + credentialsProviderName
                  + ": "
                  + exception.getMessage(),
              exception);
        }
      }
      return null;
    }
  }

  static class GrpcInterceptorProviderConverter
      implements ClientSideStatementValueConverter<GrpcInterceptorProvider> {
    static final GrpcInterceptorProviderConverter INSTANCE = new GrpcInterceptorProviderConverter();

    private GrpcInterceptorProviderConverter() {}

    @Override
    public Class<GrpcInterceptorProvider> getParameterClass() {
      return GrpcInterceptorProvider.class;
    }

    @Override
    public GrpcInterceptorProvider convert(String interceptorProviderName) {
      if (!Strings.isNullOrEmpty(interceptorProviderName)) {
        try {
          Class<? extends GrpcInterceptorProvider> clazz =
              (Class<? extends GrpcInterceptorProvider>) Class.forName(interceptorProviderName);
          Constructor<? extends GrpcInterceptorProvider> constructor =
              clazz.getDeclaredConstructor();
          return constructor.newInstance();
        } catch (ClassNotFoundException classNotFoundException) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              "Unknown or invalid GrpcInterceptorProvider class name: " + interceptorProviderName,
              classNotFoundException);
        } catch (NoSuchMethodException noSuchMethodException) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              "GrpcInterceptorProvider "
                  + interceptorProviderName
                  + " does not have a public no-arg constructor.",
              noSuchMethodException);
        } catch (InvocationTargetException
            | InstantiationException
            | IllegalAccessException exception) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              "Failed to create an instance of "
                  + interceptorProviderName
                  + ": "
                  + exception.getMessage(),
              exception);
        }
      }
      return null;
    }
  }

  /** Converter for converting strings to {@link Dialect} values. */
  static class DialectConverter implements ClientSideStatementValueConverter<Dialect> {
    static final DialectConverter INSTANCE = new DialectConverter();

    private final CaseInsensitiveEnumMap<Dialect> values =
        new CaseInsensitiveEnumMap<>(Dialect.class);

    private DialectConverter() {}

    @Override
    public Class<Dialect> getParameterClass() {
      return Dialect.class;
    }

    @Override
    public Dialect convert(String value) {
      return values.get(value);
    }
  }
}
