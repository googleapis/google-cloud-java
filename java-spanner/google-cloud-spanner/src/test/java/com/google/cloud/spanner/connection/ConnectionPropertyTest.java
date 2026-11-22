/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.connection.ConnectionProperty.create;
import static com.google.cloud.spanner.connection.ConnectionProperty.createKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.DialectConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.NonNegativeIntegerConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.StringValueConverter;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import java.time.Duration;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionPropertyTest {

  @Test
  public void testCreateKey() {
    assertEquals("my_property", createKey(/* extension= */ null, "my_property"));
    assertEquals("my_property", createKey(/* extension= */ null, "My_Property"));
    assertEquals("my_property", createKey(/* extension= */ null, "MY_PROPERTY"));
    assertEquals("my_extension.my_property", createKey("my_extension", "my_property"));
    assertEquals("my_extension.my_property", createKey("My_Extension", "My_Property"));
    assertEquals("my_extension.my_property", createKey("MY_EXTENSION", "MY_PROPERTY"));

    //noinspection DataFlowIssue
    assertThrows(SpannerException.class, () -> createKey("my_extension", /* name= */ null));
    assertThrows(SpannerException.class, () -> createKey("my_extension", ""));
  }

  @Test
  public void testCreate() {
    ConnectionProperty<String> property =
        create(
            "my_property",
            "Description of my_property",
            "default_value",
            /* nullAllowed= */ false,
            StringValueConverter.INSTANCE,
            Context.USER);
    assertEquals("my_property", property.getName());
    assertEquals("Description of my_property", property.getDescription());
    assertEquals("default_value", property.getDefaultValue());
    assertEquals("my_value", Objects.requireNonNull(property.convert("my_value")).getValue());
    assertEquals(property.getContext(), Context.USER);
    assertEquals("my_property", property.getKey());
    assertFalse(property.isNullAllowed());

    ConnectionProperty<Integer> startupProperty =
        create(
            "STARTUP_PROPERTY",
            "Description of STARTUP_PROPERTY",
            1,
            /* nullAllowed= */ true,
            NonNegativeIntegerConverter.INSTANCE,
            Context.STARTUP);
    // The name is folded to lower-case.
    assertEquals("startup_property", startupProperty.getName());
    assertEquals("Description of STARTUP_PROPERTY", startupProperty.getDescription());
    assertEquals(Integer.valueOf(1), startupProperty.getDefaultValue());
    assertEquals(
        Integer.valueOf(2), Objects.requireNonNull(startupProperty.convert("2")).getValue());
    assertEquals(startupProperty.getContext(), Context.STARTUP);
    assertEquals("startup_property", startupProperty.getKey());
    assertTrue(startupProperty.isNullAllowed());

    assertThrows(
        SpannerException.class,
        () ->
            create(
                "invalid_property",
                "Description",
                null,
                /* nullAllowed= */ false,
                StringValueConverter.INSTANCE,
                Context.USER));
  }

  @Test
  public void testEquals() {
    ConnectionProperty<String> property1 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "my_property",
            "Description of property1",
            "default_value_1",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property2 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "my_property",
            "Description of property2",
            "default_value_2",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.USER);
    ConnectionProperty<String> property3 =
        new ConnectionProperty<>(
            "my_extension",
            "my_property",
            "Description of property3",
            "default_value_3",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property4 =
        new ConnectionProperty<>(
            "my_extension",
            "my_property",
            "Description of property4",
            "default_value_4",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.USER);
    ConnectionProperty<String> property5 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "my_other_property",
            "Description of property5",
            "default_value_5",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property6 =
        new ConnectionProperty<>(
            "my_extension",
            "my_other_property",
            "Description of property6",
            "default_value_6",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property7 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "MY_PROPERTY",
            "Description of property7",
            "default_value_7",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property8 =
        new ConnectionProperty<>(
            "MY_EXTENSION",
            "my_property",
            "Description of property8",
            "default_value_8",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property9 =
        new ConnectionProperty<>(
            "my_extension",
            "MY_PROPERTY",
            "Description of property9",
            "default_value_9",
            null,
            false,
            StringValueConverter.INSTANCE,
            Context.STARTUP);

    // Equality is based only on the key.
    // The key is the lower case combination of extension and name.
    // If extension is null, then only the name is the key.

    // property1 = my_property
    assertEquals(property1, property2);
    assertNotEquals(property1, property3);
    assertNotEquals(property1, property4);
    assertNotEquals(property1, property5);
    assertNotEquals(property1, property6);
    assertEquals(property1, property7);
    assertNotEquals(property1, property8);
    assertNotEquals(property1, property9);

    // property2 = my_property
    assertEquals(property2, property1);
    assertNotEquals(property2, property3);
    assertNotEquals(property2, property4);
    assertNotEquals(property2, property5);
    assertNotEquals(property2, property6);
    assertEquals(property2, property7);
    assertNotEquals(property2, property8);
    assertNotEquals(property2, property9);

    // property3 = my_extension.my_property
    assertNotEquals(property3, property1);
    assertNotEquals(property3, property2);
    assertEquals(property3, property4);
    assertNotEquals(property3, property5);
    assertNotEquals(property3, property6);
    assertNotEquals(property3, property7);
    assertEquals(property3, property8);
    assertEquals(property3, property9);

    // property4 = my_extension.my_property
    assertNotEquals(property4, property1);
    assertNotEquals(property4, property2);
    assertEquals(property4, property3);
    assertNotEquals(property4, property5);
    assertNotEquals(property4, property6);
    assertNotEquals(property4, property7);
    assertEquals(property4, property8);
    assertEquals(property4, property9);

    // property5 = my_other_property
    assertNotEquals(property5, property1);
    assertNotEquals(property5, property2);
    assertNotEquals(property5, property3);
    assertNotEquals(property5, property4);
    assertNotEquals(property5, property6);
    assertNotEquals(property5, property7);
    assertNotEquals(property5, property8);
    assertNotEquals(property5, property9);

    // property6 = my_extension.my_other_property
    assertNotEquals(property6, property1);
    assertNotEquals(property6, property2);
    assertNotEquals(property6, property3);
    assertNotEquals(property6, property4);
    assertNotEquals(property6, property5);
    assertNotEquals(property6, property7);
    assertNotEquals(property6, property8);
    assertNotEquals(property6, property9);

    // property7 = MY_PROPERTY (same as property1 and property2)
    assertEquals(property7, property1);
    assertEquals(property7, property2);
    assertNotEquals(property7, property3);
    assertNotEquals(property7, property4);
    assertNotEquals(property7, property5);
    assertNotEquals(property7, property6);
    assertNotEquals(property7, property8);
    assertNotEquals(property7, property9);

    // property8 = MY_EXTENSION.my_property (same as property4)
    assertNotEquals(property8, property1);
    assertNotEquals(property8, property2);
    assertEquals(property8, property3);
    assertEquals(property8, property4);
    assertNotEquals(property8, property5);
    assertNotEquals(property8, property6);
    assertNotEquals(property8, property7);
    assertEquals(property8, property9);

    // property9 = my_extension.MY_PROPERTY (same as property4 and property8)
    assertNotEquals(property9, property1);
    assertNotEquals(property9, property2);
    assertEquals(property9, property3);
    assertEquals(property9, property4);
    assertNotEquals(property9, property5);
    assertNotEquals(property9, property6);
    assertNotEquals(property9, property7);
    assertEquals(property9, property8);
  }

  @Test
  public void testConvert() {
    ConnectionProperty<Integer> property =
        create(
            "my_property",
            "Description of my_property",
            1,
            /* nullAllowed= */ false,
            NonNegativeIntegerConverter.INSTANCE,
            Context.STARTUP);
    assertEquals(Integer.valueOf(100), Objects.requireNonNull(property.convert("100")).getValue());
    assertThrows(SpannerException.class, () -> property.convert("foo"));
    assertThrows(SpannerException.class, () -> property.convert("-100"));
  }

  @Test
  public void testCreateInitialValue() {
    ConnectionProperty<String> property =
        create(
            "my_property",
            "Description of my_property",
            "default_value",
            /* nullAllowed= */ false,
            StringValueConverter.INSTANCE,
            Context.USER);

    ConnectionPropertyValue<String> initialValue = property.createInitialValue(null);
    assertEquals(property.getDefaultValue(), initialValue.getValue());
    assertEquals(property.getDefaultValue(), initialValue.getResetValue());
    assertSame(initialValue.getProperty(), property);

    ConnectionPropertyValue<String> startupValue =
        new ConnectionPropertyValue<>(property, "other_value", "other_value");
    ConnectionPropertyValue<String> initialValueWithStartupValue =
        property.createInitialValue(startupValue);
    assertEquals("other_value", initialValueWithStartupValue.getValue());
    assertEquals("other_value", initialValueWithStartupValue.getResetValue());
    assertSame(initialValueWithStartupValue.getProperty(), property);
  }

  @Test
  public void testCreateConnectionPropertyValue() {
    ConnectionPropertyValue<String> stringValue =
        ConnectionPropertyValue.of(ConnectionProperties.ENDPOINT, "localhost:9010");
    assertSame(ConnectionProperties.ENDPOINT, stringValue.getProperty());
    assertEquals("localhost:9010", stringValue.getValue());
    assertEquals("localhost:9010", stringValue.getResetValue());

    ConnectionPropertyValue<Boolean> boolValue =
        ConnectionPropertyValue.of(ConnectionProperties.AUTOCOMMIT, false);
    assertSame(ConnectionProperties.AUTOCOMMIT, boolValue.getProperty());
    assertEquals(Boolean.FALSE, boolValue.getValue());

    ConnectionPropertyValue<Dialect> dialectValue =
        ConnectionPropertyValue.of(ConnectionProperties.DIALECT, Dialect.POSTGRESQL);
    assertSame(ConnectionProperties.DIALECT, dialectValue.getProperty());
    assertEquals(Dialect.POSTGRESQL, dialectValue.getValue());

    // Nullable / optional properties accept null, including those with bounded validValues.
    for (ConnectionProperty<?> nullableProperty :
        new ConnectionProperty<?>[] {
          ConnectionProperties.CONNECTION_STATE_TYPE,
          ConnectionProperties.ENABLE_DIRECT_ACCESS,
          ConnectionProperties.ENABLE_EXTENDED_TRACING,
          ConnectionProperties.ENABLE_API_TRACING,
          ConnectionProperties.ENABLE_DYNAMIC_CHANNEL_POOL,
          ConnectionProperties.ENABLE_GRPC_GCP,
          ConnectionProperties.MIN_SESSIONS,
          ConnectionProperties.ENDPOINT,
          ConnectionProperties.STATEMENT_TIMEOUT,
          ConnectionProperties.AUTOCOMMIT_DML_MODE,
          ConnectionProperties.RPC_PRIORITY,
          ConnectionProperties.UNIVERSE_DOMAIN,
        }) {
      assertTrue(nullableProperty.isNullAllowed());
      assertNull(ConnectionPropertyValue.of(nullableProperty, null).getValue());
    }
    assertEquals(
        Boolean.TRUE,
        ConnectionPropertyValue.of(ConnectionProperties.ENABLE_API_TRACING, true).getValue());

    assertThrows(
        NullPointerException.class, () -> ConnectionPropertyValue.of(null, "localhost:9010"));

    for (ConnectionProperty<?> nonNullProperty :
        new ConnectionProperty<?>[] {
          ConnectionProperties.AUTOCOMMIT,
          ConnectionProperties.MAX_PARTITIONS,
          ConnectionProperties.BATCH_DML_UPDATE_COUNT,
          ConnectionProperties.DIALECT,
          ConnectionProperties.TYPE,
          ConnectionProperties.DEFAULT_ISOLATION_LEVEL,
          ConnectionProperties.READ_LOCK_MODE,
          ConnectionProperties.SAVEPOINT_SUPPORT,
          ConnectionProperties.DDL_IN_TRANSACTION_MODE,
          ConnectionProperties.TRACING_PREFIX,
          ConnectionProperties.OPTIMIZER_VERSION,
          ConnectionProperties.READ_ONLY_STALENESS,
        }) {
      assertFalse(nonNullProperty.isNullAllowed());
      SpannerException exception =
          assertThrows(
              "Expected null rejection for " + nonNullProperty.getKey(),
              SpannerException.class,
              () -> ConnectionPropertyValue.of(nonNullProperty, null));
      assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    }

    SpannerException unrecognizedLockMode =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionPropertyValue.of(
                    ConnectionProperties.READ_LOCK_MODE, ReadLockMode.UNRECOGNIZED));
    assertEquals(ErrorCode.INVALID_ARGUMENT, unrecognizedLockMode.getErrorCode());

    SpannerException unrecognizedIsolationLevel =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionPropertyValue.of(
                    ConnectionProperties.DEFAULT_ISOLATION_LEVEL, IsolationLevel.UNRECOGNIZED));
    assertEquals(ErrorCode.INVALID_ARGUMENT, unrecognizedIsolationLevel.getErrorCode());

    // Negative integers, longs, and durations are rejected consistently with string conversion.
    SpannerException negativeChannels =
        assertThrows(
            SpannerException.class,
            () -> ConnectionPropertyValue.of(ConnectionProperties.NUM_CHANNELS, -1));
    assertEquals(ErrorCode.INVALID_ARGUMENT, negativeChannels.getErrorCode());

    SpannerException negativeMaxPartitions =
        assertThrows(
            SpannerException.class,
            () -> ConnectionPropertyValue.of(ConnectionProperties.MAX_PARTITIONS, -1));
    assertEquals(ErrorCode.INVALID_ARGUMENT, negativeMaxPartitions.getErrorCode());

    SpannerException negativeUpdateCount =
        assertThrows(
            SpannerException.class,
            () -> ConnectionPropertyValue.of(ConnectionProperties.BATCH_DML_UPDATE_COUNT, -1L));
    assertEquals(ErrorCode.INVALID_ARGUMENT, negativeUpdateCount.getErrorCode());

    SpannerException negativeTimeout =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionPropertyValue.of(
                    ConnectionProperties.STATEMENT_TIMEOUT, Duration.ofSeconds(-1)));
    assertEquals(ErrorCode.INVALID_ARGUMENT, negativeTimeout.getErrorCode());

    assertEquals(
        Integer.valueOf(0),
        ConnectionPropertyValue.of(ConnectionProperties.MAX_PARTITIONS, 0).getValue());
    assertEquals(
        Long.valueOf(0L),
        ConnectionPropertyValue.of(ConnectionProperties.BATCH_DML_UPDATE_COUNT, 0L).getValue());
    assertEquals(
        Long.valueOf(1L),
        ConnectionPropertyValue.of(ConnectionProperties.BATCH_DML_UPDATE_COUNT, 1L).getValue());
    assertEquals(
        Duration.ZERO,
        ConnectionPropertyValue.of(ConnectionProperties.STATEMENT_TIMEOUT, Duration.ZERO)
            .getValue());
    assertEquals(
        Duration.ofSeconds(5),
        ConnectionPropertyValue.of(ConnectionProperties.STATEMENT_TIMEOUT, Duration.ofSeconds(5))
            .getValue());

    ConnectionProperty<Dialect> restrictedDialect =
        create(
            "restricted_dialect",
            "Restricted dialect test property",
            Dialect.GOOGLE_STANDARD_SQL,
            new Dialect[] {Dialect.GOOGLE_STANDARD_SQL},
            /* nullAllowed= */ false,
            DialectConverter.INSTANCE,
            Context.USER);
    assertEquals(
        Dialect.GOOGLE_STANDARD_SQL,
        ConnectionPropertyValue.of(restrictedDialect, Dialect.GOOGLE_STANDARD_SQL).getValue());
    SpannerException disallowedDialect =
        assertThrows(
            SpannerException.class,
            () -> ConnectionPropertyValue.of(restrictedDialect, Dialect.POSTGRESQL));
    assertEquals(ErrorCode.INVALID_ARGUMENT, disallowedDialect.getErrorCode());
  }
}
