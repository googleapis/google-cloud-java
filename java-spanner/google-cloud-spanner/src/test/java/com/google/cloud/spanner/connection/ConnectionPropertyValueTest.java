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

import static com.google.cloud.spanner.connection.ConnectionProperties.AUTOCOMMIT_DML_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.CONNECTION_STATE_TYPE;
import static com.google.cloud.spanner.connection.ConnectionProperties.READONLY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.cloud.spanner.connection.ConnectionState.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionPropertyValueTest {

  @Test
  public void testSetValue() {
    // This value can be set at any time.
    ConnectionPropertyValue<Boolean> value = READONLY.createInitialValue(null);
    assertEquals(READONLY.getDefaultValue(), value.getValue());

    value.setValue(Boolean.FALSE, Context.STARTUP);
    assertEquals(Boolean.FALSE, value.getValue());

    value.setValue(Boolean.TRUE, Context.USER);
    assertEquals(Boolean.TRUE, value.getValue());

    value.setValue(Boolean.FALSE, Context.USER);
    assertEquals(Boolean.FALSE, value.getValue());

    // This value may only be set outside transactions.
    ConnectionPropertyValue<AutocommitDmlMode> outsideTransactionOnlyValue =
        AUTOCOMMIT_DML_MODE.createInitialValue(null);
    assertEquals(AUTOCOMMIT_DML_MODE.getDefaultValue(), outsideTransactionOnlyValue.getValue());

    outsideTransactionOnlyValue.setValue(AutocommitDmlMode.PARTITIONED_NON_ATOMIC, Context.STARTUP);
    assertEquals(AutocommitDmlMode.PARTITIONED_NON_ATOMIC, outsideTransactionOnlyValue.getValue());

    outsideTransactionOnlyValue.setValue(AutocommitDmlMode.TRANSACTIONAL, Context.USER);
    assertEquals(AutocommitDmlMode.TRANSACTIONAL, outsideTransactionOnlyValue.getValue());

    // This value may only be set at startup.
    ConnectionPropertyValue<ConnectionState.Type> startupOnlyValue =
        CONNECTION_STATE_TYPE.createInitialValue(null);
    assertEquals(CONNECTION_STATE_TYPE.getDefaultValue(), startupOnlyValue.getValue());

    startupOnlyValue.setValue(Type.TRANSACTIONAL, Context.STARTUP);
    assertEquals(Type.TRANSACTIONAL, startupOnlyValue.getValue());

    // This property may not be set after startup..
    assertThrows(
        SpannerException.class,
        () -> startupOnlyValue.setValue(Type.NON_TRANSACTIONAL, Context.USER));
    // The value should not have changed.
    assertEquals(Type.TRANSACTIONAL, startupOnlyValue.getValue());

    // This property may not be set in a transaction.
    assertThrows(
        SpannerException.class,
        () -> startupOnlyValue.setValue(Type.NON_TRANSACTIONAL, Context.USER));
    // The value should not have changed.
    assertEquals(Type.TRANSACTIONAL, startupOnlyValue.getValue());
  }

  @Test
  public void testCopy() {
    ConnectionPropertyValue<AutocommitDmlMode> value =
        new ConnectionPropertyValue<>(
            /* property= */ AUTOCOMMIT_DML_MODE,
            /* resetValue= */ AutocommitDmlMode.PARTITIONED_NON_ATOMIC,
            /* value= */ AutocommitDmlMode.TRANSACTIONAL);
    ConnectionPropertyValue<AutocommitDmlMode> copy = value.copy();

    assertEquals(value, copy);
    assertNotSame(value, copy);
    assertEquals(value.getProperty(), copy.getProperty());
    assertEquals(value.getValue(), copy.getValue());
    assertEquals(value.getResetValue(), copy.getResetValue());
  }
}
