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

package com.google.cloud.logging;

import com.google.api.client.util.Strings;
import com.google.api.gax.core.GaxProperties;
import com.google.cloud.Tuple;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jspecify.nullness.Nullable;

public final class Instrumentation {
  public static final String DIAGNOSTIC_INFO_KEY = "logging.googleapis.com/diagnostic";
  public static final String INSTRUMENTATION_SOURCE_KEY = "instrumentation_source";
  public static final String INSTRUMENTATION_NAME_KEY = "name";
  public static final String INSTRUMENTATION_VERSION_KEY = "version";
  public static final String JAVA_LIBRARY_NAME_PREFIX = "java";
  // Using release-please annotations to update DEFAULT_INSTRUMENTATION_VERSION with latest version.
  // See
  // https://github.com/googleapis/release-please/blob/main/docs/customizing.md#updating-arbitrary-files
  // {x-version-update-start:google-cloud-logging:current}
  public static final String DEFAULT_INSTRUMENTATION_VERSION = "3.13.7";
  // {x-version-update-end}
  public static final String INSTRUMENTATION_LOG_NAME = "diagnostic-log";
  public static final int MAX_DIAGNOSTIC_VALUE_LENGTH = 14;
  public static final int MAX_DIAGNOSTIC_ENTIES = 3;
  private static boolean instrumentationAdded = false;
  private static final Object instrumentationLock = new Object();

  /**
   * Populates entries with instrumentation info which is added in separate log entry
   *
   * @param logEntries {@code Iterable<LogEntry>} The list of entries to be populated
   * @return {@code Tuple<Boolean, Iterable<LogEntry>>} containing a flag if instrumentation info
   *     was added or not and a modified list of log entries
   */
  public static Tuple<Boolean, Iterable<LogEntry>> populateInstrumentationInfo(
      Iterable<LogEntry> logEntries) {
    boolean isWritten = setInstrumentationStatus(true);
    if (isWritten) {
      return Tuple.of(false, logEntries);
    }
    List<LogEntry> entries = new ArrayList<>();

    for (LogEntry logEntry : logEntries) {
      // Check if LogEntry has a proper payload and also contains a diagnostic entry
      if (!isWritten
          && logEntry.getPayload().getType() == Payload.Type.JSON
          && logEntry
              .<Payload.JsonPayload>getPayload()
              .getData()
              .containsFields(DIAGNOSTIC_INFO_KEY)) {
        try {
          ListValue infoList =
              logEntry
                  .<Payload.JsonPayload>getPayload()
                  .getData()
                  .getFieldsOrThrow(DIAGNOSTIC_INFO_KEY)
                  .getStructValue()
                  .getFieldsOrThrow(INSTRUMENTATION_SOURCE_KEY)
                  .getListValue();
          entries.add(createDiagnosticEntry(null, null, infoList));
          isWritten = true;
        } catch (RuntimeException ex) {
          System.err.println("ERROR: unexpected exception in populateInstrumentationInfo: " + ex);
        }
      } else {
        entries.add(logEntry);
      }
    }
    if (!isWritten) {
      entries.add(createDiagnosticEntry(null, null, null));
    }
    return Tuple.of(true, entries);
  }

  /**
   * Adds a partialSuccess flag option to array of WriteOption
   *
   * @param options {WriteOption[]} The options array to be extended
   * @return The new array of oprions containing WriteOption.OptionType.PARTIAL_SUCCESS flag set to
   *     true
   */
  public static WriteOption @Nullable [] addPartialSuccessOption(WriteOption[] options) {
    if (options == null) {
      return options;
    }
    List<WriteOption> writeOptions = new ArrayList<>();
    Collections.addAll(writeOptions, options);
    // Make sure we remove all partial success flags if any exist
    writeOptions.removeIf(
        option -> option.getOptionType() == WriteOption.OptionType.PARTIAL_SUCCESS);
    writeOptions.add(WriteOption.partialSuccess(true));
    return Iterables.toArray(writeOptions, WriteOption.class);
  }

  /**
   * The helper method to generate a log entry with diagnostic instrumentation data.
   *
   * @param libraryName {string} The name of the logging library to be reported. Should be prefixed
   *     with 'java'. Will be truncated if longer than 14 characters.
   * @param libraryVersion {string} The version of the logging library to be reported. Will be
   *     truncated if longer than 14 characters.
   * @return {LogEntry} The entry with diagnostic instrumentation data.
   */
  public static LogEntry createDiagnosticEntry(String libraryName, String libraryVersion) {
    return createDiagnosticEntry(libraryName, libraryVersion, null);
  }

  private static LogEntry createDiagnosticEntry(
      String libraryName, String libraryVersion, ListValue existingLibraryList) {
    Struct instrumentation =
        Struct.newBuilder()
            .putAllFields(
                ImmutableMap.of(
                    INSTRUMENTATION_SOURCE_KEY,
                    Value.newBuilder()
                        .setListValue(
                            generateLibrariesList(libraryName, libraryVersion, existingLibraryList))
                        .build()))
            .build();
    return LogEntry.newBuilder(
            JsonPayload.of(
                Struct.newBuilder()
                    .putAllFields(
                        ImmutableMap.of(
                            DIAGNOSTIC_INFO_KEY,
                            Value.newBuilder().setStructValue(instrumentation).build()))
                    .build()))
        .setLogName(INSTRUMENTATION_LOG_NAME)
        .build();
  }

  private static ListValue generateLibrariesList(
      String libraryName, String libraryVersion, ListValue existingLibraryList) {
    if (Strings.isNullOrEmpty(libraryName) || !libraryName.startsWith(JAVA_LIBRARY_NAME_PREFIX)) {
      libraryName = JAVA_LIBRARY_NAME_PREFIX;
    }
    if (Strings.isNullOrEmpty(libraryVersion)) {
      libraryVersion = getLibraryVersion(Instrumentation.class);
    }
    Struct libraryInfo = createInfoStruct(libraryName, libraryVersion);
    ListValue.Builder libraryList = ListValue.newBuilder();
    // First add instrumentation data of other libraries to a list if any
    if (existingLibraryList != null) {
      for (Value val : existingLibraryList.getValuesList()) {
        if (val.hasStructValue()) {
          try {
            String name =
                val.getStructValue().getFieldsOrThrow(INSTRUMENTATION_NAME_KEY).getStringValue();
            if (Strings.isNullOrEmpty(name) || !name.startsWith(JAVA_LIBRARY_NAME_PREFIX)) {
              continue;
            }
            String version =
                val.getStructValue().getFieldsOrThrow(INSTRUMENTATION_VERSION_KEY).getStringValue();
            if (Strings.isNullOrEmpty(version)) {
              continue;
            }
            libraryList.addValues(
                Value.newBuilder().setStructValue(createInfoStruct(name, version)).build());
            if (libraryList.getValuesCount() == MAX_DIAGNOSTIC_ENTIES) {
              break;
            }
          } catch (RuntimeException ex) {
            System.err.println("ERROR: unexpected exception in generateLibrariesList: " + ex);
          }
        }
      }
    }
    // At last, append this library info to a list
    libraryList.addValues(Value.newBuilder().setStructValue(libraryInfo).build());
    return libraryList.build();
  }

  private static Struct createInfoStruct(String libraryName, String libraryVersion) {
    return Struct.newBuilder()
        .putAllFields(
            ImmutableMap.of(
                INSTRUMENTATION_NAME_KEY,
                    Value.newBuilder().setStringValue(truncateValue(libraryName)).build(),
                INSTRUMENTATION_VERSION_KEY,
                    Value.newBuilder().setStringValue(truncateValue(libraryVersion)).build()))
        .build();
  }

  /**
   * The package-private helper method used to set the flag which indicates if instrumentation info
   * already written or not.
   *
   * @return The value of the flag before it was set.
   */
  static boolean setInstrumentationStatus(boolean value) {
    if (instrumentationAdded == value) {
      return instrumentationAdded;
    }
    synchronized (instrumentationLock) {
      boolean current = instrumentationAdded;
      instrumentationAdded = value;
      return current;
    }
  }

  /**
   * Returns a library version associated with given class
   *
   * @param libraryClass {Class<?>} The class to be used to determine a library version
   * @return The version number string for given class or DEFAULT_INSTRUMENTATION_VERSION if class
   *     library version cannot be detected
   */
  public static String getLibraryVersion(Class<?> libraryClass) {
    String libraryVersion = GaxProperties.getLibraryVersion(libraryClass);
    if (Strings.isNullOrEmpty(libraryVersion)) {
      libraryVersion = DEFAULT_INSTRUMENTATION_VERSION;
    }
    return libraryVersion;
  }

  /**
   * Trancates given string to MAX_DIAGNOSTIC_VALUE_LENGTH and adds "*" instead of reduced suffix
   *
   * @param value {String} Value to be truncated
   * @return The truncated string
   */
  public static String truncateValue(String value) {
    if (Strings.isNullOrEmpty(value) || value.length() < MAX_DIAGNOSTIC_VALUE_LENGTH) {
      return value;
    }
    return value.substring(0, MAX_DIAGNOSTIC_VALUE_LENGTH) + "*";
  }

  private Instrumentation() {}
}
