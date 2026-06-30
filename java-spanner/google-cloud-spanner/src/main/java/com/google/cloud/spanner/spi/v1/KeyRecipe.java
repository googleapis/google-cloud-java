/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.google.spanner.v1.KeyRange;
import com.google.spanner.v1.KeySet;
import com.google.spanner.v1.Mutation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@InternalApi
public final class KeyRecipe {

  // kInfinity is "\xff" - the largest single byte, used as a sentinel for ranges
  private static final ByteString K_INFINITY = ByteString.copyFrom(new byte[] {(byte) 0xFF});

  private enum Kind {
    TAG,
    VALUE,
    INVALID
  }

  private enum KeyType {
    FULL_KEY,
    PREFIX,
    PREFIX_SUCCESSOR,
    INDEX_KEY
  }

  private enum EncodeState {
    OK,
    FAILED,
    END_OF_KEYS
  }

  private static final class Part {
    private final Kind kind;
    private final int tag; // if kind == TAG
    private final com.google.spanner.v1.Type type; // if kind == VALUE
    private final com.google.spanner.v1.KeyRecipe.Part.Order order; // if kind == VALUE
    private final com.google.spanner.v1.KeyRecipe.Part.NullOrder nullOrder; // if kind == VALUE
    private final String identifier; // if kind == VALUE
    private final List<Integer> structIdentifiers; // if kind == VALUE
    private final Value constantValue; // if kind == VALUE and value is set
    private final boolean random; // if kind == VALUE and random: true

    private Value constantValue() {
      return constantValue;
    }

    private boolean hasConstantValue() {
      return constantValue != null;
    }

    private Part(
        Kind kind,
        int tag,
        com.google.spanner.v1.Type type,
        com.google.spanner.v1.KeyRecipe.Part.Order order,
        com.google.spanner.v1.KeyRecipe.Part.NullOrder nullOrder,
        String identifier,
        List<Integer> structIdentifiers,
        Value constantValue,
        boolean random) {
      this.kind = kind;
      this.tag = tag;
      this.type = type;
      this.order = order;
      this.nullOrder = nullOrder;
      this.identifier = identifier;
      this.structIdentifiers = structIdentifiers;
      this.constantValue = constantValue;
      this.random = random;
    }

    private ResolvedValue resolveValue(BiFunction<Integer, String, Value> valueFinder, int index) {
      if (hasConstantValue()) {
        return ResolvedValue.ofValue(constantValue());
      }
      Value value = valueFinder.apply(index, identifier == null ? "" : identifier);
      if (value == null) {
        return ResolvedValue.missing();
      }
      if (structIdentifiers.isEmpty()) {
        return ResolvedValue.ofValue(value);
      }
      Value current = value;
      // structIdentifiers is a path of list indices into nested STRUCT values.
      // STRUCT values are represented as ListValue in field order.
      for (int structIndex : structIdentifiers) {
        if (current.getKindCase() != Value.KindCase.LIST_VALUE
            || structIndex < 0
            || structIndex >= current.getListValue().getValuesCount()) {
          return ResolvedValue.failed();
        }
        current = current.getListValue().getValues(structIndex);
      }
      return ResolvedValue.ofValue(current);
    }

    private boolean shouldConsumeValueIndex() {
      return !hasConstantValue() && !random;
    }

    static Part fromProto(com.google.spanner.v1.KeyRecipe.Part partProto) {
      if (partProto.getTag() != 0) {
        if (partProto.getTag() < 0) {
          return new Part(Kind.INVALID, 0, null, null, null, null, null, null, false);
        }
        return new Part(Kind.TAG, partProto.getTag(), null, null, null, null, null, null, false);
      }
      if (!partProto.hasType()) {
        return new Part(Kind.INVALID, 0, null, null, null, null, null, null, false);
      }
      if (partProto.getOrder() != com.google.spanner.v1.KeyRecipe.Part.Order.ASCENDING
          && partProto.getOrder() != com.google.spanner.v1.KeyRecipe.Part.Order.DESCENDING) {
        return new Part(Kind.INVALID, 0, null, null, null, null, null, null, false);
      }
      if (partProto.getNullOrder() != com.google.spanner.v1.KeyRecipe.Part.NullOrder.NULLS_FIRST
          && partProto.getNullOrder() != com.google.spanner.v1.KeyRecipe.Part.NullOrder.NULLS_LAST
          && partProto.getNullOrder() != com.google.spanner.v1.KeyRecipe.Part.NullOrder.NOT_NULL) {
        return new Part(Kind.INVALID, 0, null, null, null, null, null, null, false);
      }
      if (partProto.hasRandom()
          && partProto.getType().getCode() != com.google.spanner.v1.TypeCode.INT64) {
        return new Part(Kind.INVALID, 0, null, null, null, null, null, null, false);
      }

      String identifier = partProto.hasIdentifier() ? partProto.getIdentifier() : null;
      List<Integer> structIdentifiers = new ArrayList<>(partProto.getStructIdentifiersList());

      Value constantValue = partProto.hasValue() ? partProto.getValue() : null;

      return new Part(
          Kind.VALUE,
          0,
          partProto.getType(),
          partProto.getOrder(),
          partProto.getNullOrder(),
          identifier,
          structIdentifiers,
          constantValue,
          partProto.hasRandom());
    }
  }

  private static void encodeRandomValuePart(Part part, UnsynchronizedByteArrayOutputStream out) {
    long value = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);
    boolean ascending = part.order == com.google.spanner.v1.KeyRecipe.Part.Order.ASCENDING;
    if (ascending) {
      SsFormat.appendInt64Increasing(out, value);
    } else {
      SsFormat.appendInt64Decreasing(out, value);
    }
  }

  private static final class ResolvedValue {
    private final Value value;
    private final boolean found;
    private final boolean failed;

    private ResolvedValue(Value value, boolean found, boolean failed) {
      this.value = value;
      this.found = found;
      this.failed = failed;
    }

    private static ResolvedValue ofValue(Value value) {
      return new ResolvedValue(value, true, false);
    }

    private static ResolvedValue missing() {
      return new ResolvedValue(null, false, false);
    }

    private static ResolvedValue failed() {
      return new ResolvedValue(null, false, true);
    }
  }

  private final List<Part> parts;
  private final boolean isIndex;

  private KeyRecipe(List<Part> parts, boolean isIndex) {
    this.parts = parts;
    this.isIndex = isIndex;
  }

  public static KeyRecipe create(com.google.spanner.v1.KeyRecipe in) {
    if (in.getPartCount() == 0) {
      throw new IllegalArgumentException("KeyRecipe must have at least one part.");
    }
    boolean isIndex = in.hasIndexName();
    List<Part> partsList =
        in.getPartList().stream().map(Part::fromProto).collect(Collectors.toList());
    if (partsList.get(0).kind != Kind.TAG) {
      throw new IllegalArgumentException("KeyRecipe must start with a tag.");
    }
    return new KeyRecipe(partsList, isIndex);
  }

  private static void encodeNull(Part part, UnsynchronizedByteArrayOutputStream out) {
    switch (part.nullOrder) {
      case NULLS_FIRST:
        SsFormat.appendNullOrderedFirst(out);
        break;
      case NULLS_LAST:
        SsFormat.appendNullOrderedLast(out);
        break;
      case NOT_NULL:
        throw new IllegalArgumentException("Key part cannot be NULL");
      default:
        throw new IllegalArgumentException("Unknown null order: " + part.nullOrder);
    }
  }

  private static void encodeNotNull(Part part, UnsynchronizedByteArrayOutputStream out) {
    switch (part.nullOrder) {
      case NULLS_FIRST:
        SsFormat.appendNotNullMarkerNullOrderedFirst(out);
        break;
      case NULLS_LAST:
        SsFormat.appendNotNullMarkerNullOrderedLast(out);
        break;
      case NOT_NULL:
        // No marker needed for NOT_NULL
        break;
      default:
        throw new IllegalArgumentException("Unknown null order: " + part.nullOrder);
    }
  }

  private static void encodeSingleValuePart(
      Part part, Value value, UnsynchronizedByteArrayOutputStream out) {
    if (value.getKindCase() == Value.KindCase.NULL_VALUE) {
      encodeNull(part, out);
      return;
    }

    // Validate type compatibility BEFORE encoding anything
    validateValueType(part, value);

    // Now safe to encode the NOT_NULL marker
    encodeNotNull(part, out);

    boolean isAscending = (part.order == com.google.spanner.v1.KeyRecipe.Part.Order.ASCENDING);

    switch (part.type.getCode()) {
      case BOOL:
        if (isAscending) {
          SsFormat.appendBoolIncreasing(out, value.getBoolValue());
        } else {
          SsFormat.appendBoolDecreasing(out, value.getBoolValue());
        }
        break;
      case INT64:
        long intVal = Long.parseLong(value.getStringValue());
        if (isAscending) {
          SsFormat.appendInt64Increasing(out, intVal);
        } else {
          SsFormat.appendInt64Decreasing(out, intVal);
        }
        break;
      case FLOAT64:
        double dblVal;
        if (value.getKindCase() == Value.KindCase.STRING_VALUE) {
          // Handle special float values like Infinity, -Infinity, NaN
          String strVal = value.getStringValue();
          if ("Infinity".equals(strVal)) {
            dblVal = Double.POSITIVE_INFINITY;
          } else if ("-Infinity".equals(strVal)) {
            dblVal = Double.NEGATIVE_INFINITY;
          } else if ("NaN".equals(strVal)) {
            dblVal = Double.NaN;
          } else {
            throw new IllegalArgumentException("Invalid FLOAT64 string: " + strVal);
          }
        } else {
          dblVal = value.getNumberValue();
        }
        if (isAscending) {
          SsFormat.appendDoubleIncreasing(out, dblVal);
        } else {
          SsFormat.appendDoubleDecreasing(out, dblVal);
        }
        break;
      case STRING:
        if (isAscending) {
          SsFormat.appendStringIncreasing(out, value.getStringValue());
        } else {
          SsFormat.appendStringDecreasing(out, value.getStringValue());
        }
        break;
      case BYTES:
        byte[] bytesDecoded = Base64.getDecoder().decode(value.getStringValue());
        if (isAscending) {
          SsFormat.appendBytesIncreasing(out, bytesDecoded);
        } else {
          SsFormat.appendBytesDecreasing(out, bytesDecoded);
        }
        break;
      case TIMESTAMP:
        String tsStr = value.getStringValue();
        long[] parsed = parseTimestamp(tsStr);
        byte[] encoded = SsFormat.encodeTimestamp(parsed[0], (int) parsed[1]);
        if (isAscending) {
          SsFormat.appendBytesIncreasing(out, encoded);
        } else {
          SsFormat.appendBytesDecreasing(out, encoded);
        }
        break;
      case DATE:
        String dateStr = value.getStringValue();
        int daysSinceEpoch = parseDate(dateStr);
        if (isAscending) {
          SsFormat.appendInt64Increasing(out, daysSinceEpoch);
        } else {
          SsFormat.appendInt64Decreasing(out, daysSinceEpoch);
        }
        break;
      case UUID:
        String uuidStr = value.getStringValue();
        long[] parsedUuid = parseUuid(uuidStr);
        byte[] encodedUuid = SsFormat.encodeUuid(parsedUuid[0], parsedUuid[1]);
        if (isAscending) {
          SsFormat.appendBytesIncreasing(out, encodedUuid);
        } else {
          SsFormat.appendBytesDecreasing(out, encodedUuid);
        }
        break;
      case ENUM:
        // ENUM values are sent as string representation of the enum number
        long enumVal = Long.parseLong(value.getStringValue());
        if (isAscending) {
          SsFormat.appendInt64Increasing(out, enumVal);
        } else {
          SsFormat.appendInt64Decreasing(out, enumVal);
        }
        break;
      case NUMERIC:
      case TYPE_CODE_UNSPECIFIED:
      case ARRAY:
      case STRUCT:
      case PROTO:
      case UNRECOGNIZED:
      default:
        throw new IllegalArgumentException(
            "Unsupported type code for ssformat encoding: " + part.type.getCode());
    }
  }

  private static void validateValueType(Part part, Value value) {
    switch (part.type.getCode()) {
      case BOOL:
        if (value.getKindCase() != Value.KindCase.BOOL_VALUE) {
          throw new IllegalArgumentException("Type mismatch for BOOL.");
        }
        break;
      case INT64:
        if (value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for INT64, expecting decimal string.");
        }
        // Also validate it's a valid integer
        try {
          Long.parseLong(value.getStringValue());
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Invalid INT64 string: " + value.getStringValue(), e);
        }
        break;
      case FLOAT64:
        if (value.getKindCase() != Value.KindCase.NUMBER_VALUE
            && value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for FLOAT64.");
        }
        if (value.getKindCase() == Value.KindCase.STRING_VALUE) {
          String strVal = value.getStringValue();
          if (!"Infinity".equals(strVal) && !"-Infinity".equals(strVal) && !"NaN".equals(strVal)) {
            throw new IllegalArgumentException("Invalid FLOAT64 string: " + strVal);
          }
        }
        break;
      case STRING:
        if (value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for STRING.");
        }
        break;
      case BYTES:
        if (value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for BYTES, expecting base64 string.");
        }
        // Validate base64
        try {
          Base64.getDecoder().decode(value.getStringValue());
        } catch (IllegalArgumentException e) {
          throw new IllegalArgumentException("Invalid base64 for BYTES type.", e);
        }
        break;
      case TIMESTAMP:
        if (value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for TIMESTAMP.");
        }
        // Validate timestamp format: must end with Z (UTC) and be RFC3339
        validateTimestamp(value.getStringValue());
        break;
      case DATE:
        if (value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for DATE.");
        }
        // Validate date format: YYYY-MM-DD, exactly 10 chars
        validateDate(value.getStringValue());
        break;
      case UUID:
        if (value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for UUID.");
        }
        // Validate UUID format
        validateUuid(value.getStringValue());
        break;
      case ENUM:
        if (value.getKindCase() != Value.KindCase.STRING_VALUE) {
          throw new IllegalArgumentException("Type mismatch for ENUM, expecting string.");
        }
        // Validate it's a valid integer string
        try {
          Long.parseLong(value.getStringValue());
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException(
              "Invalid ENUM string (expecting number): " + value.getStringValue(), e);
        }
        break;
      case NUMERIC:
      case TYPE_CODE_UNSPECIFIED:
      case ARRAY:
      case STRUCT:
      case PROTO:
      case UNRECOGNIZED:
      default:
        throw new IllegalArgumentException(
            "Unsupported type code for ssformat encoding: " + part.type.getCode());
    }
  }

  private static void validateTimestamp(String ts) {
    parseTimestamp(ts);
  }

  private static long[] parseTimestamp(String ts) {
    if (!ts.endsWith("Z")) {
      throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts);
    }
    String withoutZ = ts.substring(0, ts.length() - 1);
    int tIndex = withoutZ.indexOf('T');
    if (tIndex <= 0 || tIndex == withoutZ.length() - 1) {
      throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts);
    }

    String datePart = withoutZ.substring(0, tIndex);
    String timePart = withoutZ.substring(tIndex + 1);
    LocalDate date;
    try {
      date = LocalDate.parse(datePart, DATE_FORMATTER);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts, e);
    }

    int nanos = 0;
    String timeMain = timePart;
    int dotIndex = timePart.indexOf('.');
    if (dotIndex >= 0) {
      timeMain = timePart.substring(0, dotIndex);
      String fracStr = timePart.substring(dotIndex + 1);
      if (fracStr.isEmpty()) {
        throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts);
      }
      for (int i = 0; i < fracStr.length(); i++) {
        char c = fracStr.charAt(i);
        if (c < '0' || c > '9') {
          throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts);
        }
      }
      while (fracStr.length() < 9) {
        fracStr = fracStr + "0";
      }
      if (fracStr.length() > 9) {
        fracStr = fracStr.substring(0, 9);
      }
      nanos = Integer.parseInt(fracStr);
    }

    String[] timeParts = timeMain.split(":");
    if (timeParts.length != 3) {
      throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts);
    }
    int hour;
    int minute;
    int second;
    try {
      hour = Integer.parseInt(timeParts[0]);
      minute = Integer.parseInt(timeParts[1]);
      second = Integer.parseInt(timeParts[2]);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts, e);
    }
    if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
      throw new IllegalArgumentException("Invalid TIMESTAMP string: " + ts);
    }

    long seconds = date.toEpochDay() * 86400L + hour * 3600L + minute * 60L + second;
    return new long[] {seconds, nanos};
  }

  private static final DateTimeFormatter DATE_FORMATTER =
      DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);

  private static void validateDate(String dateStr) {
    parseDate(dateStr);
  }

  private static int parseDate(String dateStr) {
    try {
      LocalDate date = LocalDate.parse(dateStr, DATE_FORMATTER);
      return (int) date.toEpochDay();
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid DATE string: " + dateStr, e);
    }
  }

  private static void validateUuid(String uuid) {
    parseUuid(uuid);
    // parseUuid throws if invalid
  }

  private static long[] parseUuid(String uuid) {
    String originalUuid = uuid;

    // Handle optional braces
    if (uuid.startsWith("{")) {
      if (!uuid.endsWith("}")) {
        throw new IllegalArgumentException("Invalid UUID string: " + originalUuid);
      }
      uuid = uuid.substring(1, uuid.length() - 1);
    }

    // Minimum 36 characters required (standard UUID format: 8-4-4-4-12)
    if (uuid.length() < 36) {
      throw new IllegalArgumentException("Invalid UUID string: " + originalUuid);
    }

    // Check for leading hyphen
    if (uuid.startsWith("-")) {
      throw new IllegalArgumentException("Invalid UUID string: " + originalUuid);
    }

    // Parse 32 hex digits (ignoring hyphens in between)
    long high = 0;
    long low = 0;
    int hexCount = 0;

    for (int i = 0; i < uuid.length(); i++) {
      char c = uuid.charAt(i);
      if (c == '-') {
        continue; // Skip hyphens
      }
      int digit = hexDigit(c);
      if (digit < 0) {
        throw new IllegalArgumentException("Invalid UUID string: " + originalUuid);
      }
      if (hexCount < 16) {
        high = (high << 4) | digit;
      } else {
        low = (low << 4) | digit;
      }
      hexCount++;
    }

    if (hexCount != 32) {
      throw new IllegalArgumentException("Invalid UUID string: " + originalUuid);
    }

    // After parsing, verify there are no trailing characters
    // (uuid must be exactly consumed)
    if (uuid.length() > 36) {
      throw new IllegalArgumentException("Invalid UUID string: " + originalUuid);
    }

    return new long[] {high, low};
  }

  private static int hexDigit(char c) {
    if (c >= '0' && c <= '9') return c - '0';
    if (c >= 'a' && c <= 'f') return 10 + (c - 'a');
    if (c >= 'A' && c <= 'F') return 10 + (c - 'A');
    return -1;
  }

  private TargetRange encodeKeyInternal(
      BiFunction<Integer, String, Value> valueFinder, KeyType keyType) {
    UnsynchronizedByteArrayOutputStream ssKey = new UnsynchronizedByteArrayOutputStream();
    int valueIdx = 0;
    EncodeState state = EncodeState.OK;
    int p = 0;
    for (; p < parts.size(); ++p) {
      final Part part = parts.get(p);
      if (part.kind == Kind.TAG) {
        SsFormat.appendCompositeTag(ssKey, part.tag);
      } else if (part.kind == Kind.VALUE) {
        if (part.random) {
          encodeRandomValuePart(part, ssKey);
          continue;
        }

        int currentIndex = valueIdx;
        if (part.shouldConsumeValueIndex()) {
          valueIdx++;
        }
        ResolvedValue resolved = part.resolveValue(valueFinder, currentIndex);
        if (resolved.failed) {
          state = EncodeState.FAILED;
          break;
        }
        if (!resolved.found) {
          state = part.shouldConsumeValueIndex() ? EncodeState.END_OF_KEYS : EncodeState.FAILED;
          break;
        }
        try {
          encodeSingleValuePart(part, resolved.value, ssKey);
        } catch (IllegalArgumentException e) {
          state = EncodeState.FAILED;
          break;
        }
      } else {
        state = EncodeState.FAILED;
        break;
      }
    }

    ByteString start = ByteString.copyFrom(ssKey.toByteArray());
    ByteString limit = ByteString.EMPTY;
    boolean approximate = false;

    if (p == parts.size() || (keyType != KeyType.FULL_KEY && state == EncodeState.END_OF_KEYS)) {
      if (keyType == KeyType.PREFIX_SUCCESSOR) {
        start = SsFormat.makePrefixSuccessor(start);
      } else if (keyType == KeyType.INDEX_KEY) {
        limit = SsFormat.makePrefixSuccessor(start);
      }
    } else {
      approximate = true;
      limit = SsFormat.makePrefixSuccessor(start);
    }
    return new TargetRange(start, limit, approximate);
  }

  public TargetRange keyToTargetRange(ListValue in) {
    return encodeKeyInternal(
        (index, identifier) -> {
          if (index < 0 || index >= in.getValuesCount()) {
            return null;
          }
          return in.getValues(index);
        },
        isIndex ? KeyType.INDEX_KEY : KeyType.FULL_KEY);
  }

  public TargetRange keyRangeToTargetRange(KeyRange in) {
    TargetRange start;
    switch (in.getStartKeyTypeCase()) {
      case START_CLOSED:
        start =
            encodeKeyInternal(
                (index, id) -> {
                  if (index < 0 || index >= in.getStartClosed().getValuesCount()) {
                    return null;
                  }
                  return in.getStartClosed().getValues(index);
                },
                KeyType.PREFIX);
        break;
      case START_OPEN:
        start =
            encodeKeyInternal(
                (index, id) -> {
                  if (index < 0 || index >= in.getStartOpen().getValuesCount()) {
                    return null;
                  }
                  return in.getStartOpen().getValues(index);
                },
                KeyType.PREFIX_SUCCESSOR);
        break;
      default:
        start = encodeKeyInternal((index, id) -> null, KeyType.PREFIX);
        start.approximate = true;
        break;
    }

    TargetRange limit;
    switch (in.getEndKeyTypeCase()) {
      case END_CLOSED:
        limit =
            encodeKeyInternal(
                (index, id) -> {
                  if (index < 0 || index >= in.getEndClosed().getValuesCount()) {
                    return null;
                  }
                  return in.getEndClosed().getValues(index);
                },
                KeyType.PREFIX_SUCCESSOR);
        break;
      case END_OPEN:
        limit =
            encodeKeyInternal(
                (index, id) -> {
                  if (index < 0 || index >= in.getEndOpen().getValuesCount()) {
                    return null;
                  }
                  return in.getEndOpen().getValues(index);
                },
                KeyType.PREFIX);
        break;
      default:
        limit = encodeKeyInternal((index, id) -> null, KeyType.PREFIX_SUCCESSOR);
        limit.approximate = true;
        break;
    }
    ByteString limitKey = limit.approximate ? limit.limit : limit.start;
    return new TargetRange(start.start, limitKey, start.approximate || limit.approximate);
  }

  public TargetRange keySetToTargetRange(KeySet in) {
    if (in.getAll()) {
      return keyRangeToTargetRange(
          KeyRange.newBuilder()
              .setStartClosed(ListValue.getDefaultInstance())
              .setEndClosed(ListValue.getDefaultInstance())
              .build());
    }
    if (in.getRangesCount() == 0) {
      if (in.getKeysCount() == 0) {
        return new TargetRange(ByteString.EMPTY, K_INFINITY, true);
      } else if (in.getKeysCount() == 1) {
        return keyToTargetRange(in.getKeys(0));
      }
    }

    TargetRange target = new TargetRange(K_INFINITY, ByteString.EMPTY, false);
    for (ListValue key : in.getKeysList()) {
      target.mergeFrom(keyToTargetRange(key));
    }
    for (KeyRange range : in.getRangesList()) {
      target.mergeFrom(keyRangeToTargetRange(range));
    }
    return target;
  }

  public TargetRange queryParamsToTargetRange(Struct in) {
    // toLowerCase(Locale.ROOT) is safe for query parameter names, even for non-ASCII
    // characters such as the Turkish upper-case İ (U+0130). Query parameter names cannot
    // be quoted in Spanner SQL (the @paramName syntax imposes an unquoted identifier
    // grammar), so both the identifier sent by the server in the KeyRecipe and the
    // parameter name bound by the user must follow the same syntax rules. Applying the
    // same Locale.ROOT case-folding to both sides guarantees a consistent match.
    // If the server were to normalize identifiers differently, the only consequence is
    // a routing miss and graceful fallback to the default endpoint — not a query failure.
    //
    // Sort field names before inserting into the map so that when two param names
    // collide after case-folding (e.g. "Id" vs "ID") the winner is deterministic,
    // matching the Go implementation.
    List<String> fieldNames = new ArrayList<>(in.getFieldsMap().keySet());
    Collections.sort(fieldNames);
    final Map<String, Value> lowercaseFields = new HashMap<>(fieldNames.size());
    for (String fieldName : fieldNames) {
      lowercaseFields.put(fieldName.toLowerCase(Locale.ROOT), in.getFieldsMap().get(fieldName));
    }
    return encodeKeyInternal(
        (index, identifier) -> lowercaseFields.get(identifier.toLowerCase(Locale.ROOT)),
        KeyType.FULL_KEY);
  }

  public TargetRange mutationToTargetRange(Mutation in) {
    TargetRange target = new TargetRange(K_INFINITY, ByteString.EMPTY, false);

    switch (in.getOperationCase()) {
      case INSERT:
      case UPDATE:
      case INSERT_OR_UPDATE:
      case REPLACE:
        final Mutation.Write write = getWrite(in);
        for (ListValue values : write.getValuesList()) {
          target.mergeFrom(
              encodeKeyInternal(
                  (index, id) -> {
                    int colIndex = write.getColumnsList().indexOf(id);
                    if (colIndex == -1 || colIndex >= values.getValuesCount()) {
                      return null;
                    }
                    return values.getValues(colIndex);
                  },
                  KeyType.FULL_KEY));
        }
        break;
      case DELETE:
        target.mergeFrom(keySetToTargetRange(in.getDelete().getKeySet()));
        break;
      case SEND:
        target.mergeFrom(keyToTargetRange(in.getSend().getKey()));
        break;
      case ACK:
        target.mergeFrom(keyToTargetRange(in.getAck().getKey()));
        break;
      default:
        break;
    }

    if (target.start.equals(K_INFINITY)) {
      target = new TargetRange(ByteString.EMPTY, K_INFINITY, true);
    }
    return target;
  }

  private Mutation.Write getWrite(Mutation in) {
    switch (in.getOperationCase()) {
      case INSERT:
        return in.getInsert();
      case UPDATE:
        return in.getUpdate();
      case INSERT_OR_UPDATE:
        return in.getInsertOrUpdate();
      case REPLACE:
        return in.getReplace();
      default:
        throw new IllegalArgumentException("Mutation is not a write operation");
    }
  }
}
