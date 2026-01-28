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

package com.google.cloud.bigquery;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

public class ConnectionPropertyTest {

  private static final String KEY = "time_zone";
  private static final String VALUE = "US/Eastern";
  private static final ConnectionProperty CONNECTION_PROPERTY =
      ConnectionProperty.newBuilder().setKey(KEY).setValue(VALUE).build();

  @Test
  void testToBuilder() {
    compareConnectionProperty(CONNECTION_PROPERTY, CONNECTION_PROPERTY.toBuilder().build());
    ConnectionProperty property = CONNECTION_PROPERTY.toBuilder().setKey("time-zone").build();
    assertThat(property.getKey()).isEqualTo("time-zone");
    property = CONNECTION_PROPERTY.toBuilder().setKey(KEY).build();
    compareConnectionProperty(CONNECTION_PROPERTY, property);
  }

  @Test
  void testToBuilderIncomplete() {
    ConnectionProperty connectionProperty = ConnectionProperty.of(KEY, VALUE);
    compareConnectionProperty(connectionProperty, connectionProperty.toBuilder().build());
  }

  @Test
  void testBuilder() {
    assertThat(CONNECTION_PROPERTY.getKey()).isEqualTo(KEY);
    assertThat(CONNECTION_PROPERTY.getValue()).isEqualTo(VALUE);
  }

  @Test
  void testToAndFromPb() {
    compareConnectionProperty(
        CONNECTION_PROPERTY, ConnectionProperty.fromPb(CONNECTION_PROPERTY.toPb()));
  }

  private void compareConnectionProperty(ConnectionProperty expected, ConnectionProperty value) {
    assertThat(value).isEqualTo(expected);
    assertThat(value.getKey()).isEqualTo(expected.getKey());
    assertThat(value.getValue()).isEqualTo(expected.getValue());
    assertThat(value.toString()).isEqualTo(expected.toString());
    assertThat(value.hashCode()).isEqualTo(expected.hashCode());
  }
}
