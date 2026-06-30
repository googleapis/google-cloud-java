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

import static com.google.cloud.storage.Utils.RFC_3339_DATE_TIME_FORMATTER;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.util.DateTime;
import com.google.cloud.storage.Conversions.Codec;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.time.api.DateTimes;

final class DateTimeCodecPropertyTest {

  private static final Codec<OffsetDateTime, DateTime> codec = Utils.dateTimeCodec;

  @Example
  void codecShouldRoundTrip_UTC() {
    codecShouldRoundTrip("2019-08-23T07:23:51.396Z");
  }

  @Example
  void codecShouldRoundTrip_negative() {
    codecShouldRoundTrip("2019-08-23T07:23:51.396-08:59");
  }

  @Example
  void codecShouldRoundTrip_positive() {
    codecShouldRoundTrip("2019-08-23T07:23:51.396+00:13");
  }

  @Property(tries = 10000)
  void codecShouldRoundTrip(@ForAll("rfc3339") String rfc3339String) {
    DateTime actual = new DateTime(rfc3339String);
    OffsetDateTime odt = codec.decode(actual);
    DateTime dt = codec.encode(odt);

    assertThat(dt.toStringRfc3339()).isEqualTo(rfc3339String);
  }

  @Provide("rfc3339")
  Arbitrary<String> arbitraryRfc3339Strings() {
    return Combinators.combine(DateTimes.offsetDateTimes(), Arbitraries.integers().between(0, 999))
        .as((odt, millis) -> odt.plus(millis, ChronoUnit.MILLIS))
        .map(DateTimeCodecPropertyTest::offsetDateTimeToString);
  }

  private static String offsetDateTimeToString(OffsetDateTime odt) {
    return odt.format(RFC_3339_DATE_TIME_FORMATTER);
  }
}
