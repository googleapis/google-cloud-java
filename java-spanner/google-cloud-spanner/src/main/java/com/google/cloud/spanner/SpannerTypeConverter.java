/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.cloud.Date;
import com.google.protobuf.ListValue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class SpannerTypeConverter {

  private static final ZoneId UTC_ZONE = ZoneId.of("UTC");
  private static final DateTimeFormatter ISO_8601_DATE_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

  static <T> Value createUntypedArrayValue(Stream<T> stream) {
    List<com.google.protobuf.Value> values =
        stream
            .map(
                val ->
                    com.google.protobuf.Value.newBuilder()
                        .setStringValue(String.valueOf(val))
                        .build())
            .collect(Collectors.toList());
    return Value.untyped(
        com.google.protobuf.Value.newBuilder()
            .setListValue(ListValue.newBuilder().addAllValues(values).build())
            .build());
  }

  static <T extends TemporalAccessor> String convertToISO8601(T dateTime) {
    return ISO_8601_DATE_FORMATTER.format(dateTime);
  }

  static <T> Value createUntypedStringValue(T value) {
    return Value.untyped(
        com.google.protobuf.Value.newBuilder().setStringValue(String.valueOf(value)).build());
  }

  static <T, U> Iterable<U> convertToTypedIterable(
      Function<T, U> func, T val, Iterator<?> iterator) {
    List<U> values = new ArrayList<>();
    SpannerTypeConverter.processIterable(val, iterator, func, values::add);
    return values;
  }

  static <T> Iterable<T> convertToTypedIterable(T val, Iterator<?> iterator) {
    return convertToTypedIterable(v -> v, val, iterator);
  }

  @SuppressWarnings("unchecked")
  static <T, U> void processIterable(
      T val, Iterator<?> iterator, Function<T, U> func, Consumer<U> consumer) {
    consumer.accept(func.apply(val));
    iterator.forEachRemaining(values -> consumer.accept(func.apply((T) values)));
  }

  static Date convertLocalDateToSpannerDate(LocalDate date) {
    return Date.fromYearMonthDay(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
  }

  static <T> Value createUntypedIterableValue(
      T value, Iterator<?> iterator, Function<T, String> func) {
    ListValue.Builder listValueBuilder = ListValue.newBuilder();
    SpannerTypeConverter.processIterable(
        value,
        iterator,
        (val) -> com.google.protobuf.Value.newBuilder().setStringValue(func.apply(val)).build(),
        listValueBuilder::addValues);
    return Value.untyped(
        com.google.protobuf.Value.newBuilder().setListValue(listValueBuilder.build()).build());
  }

  static ZonedDateTime atUTC(LocalDateTime localDateTime) {
    return atUTC(localDateTime.atZone(ZoneId.systemDefault()));
  }

  static ZonedDateTime atUTC(OffsetDateTime localDateTime) {
    return localDateTime.atZoneSameInstant(UTC_ZONE);
  }

  static ZonedDateTime atUTC(ZonedDateTime localDateTime) {
    return localDateTime.withZoneSameInstant(UTC_ZONE);
  }
}
