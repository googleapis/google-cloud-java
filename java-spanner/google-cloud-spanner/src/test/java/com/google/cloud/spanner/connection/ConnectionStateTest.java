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
import static com.google.cloud.spanner.connection.ConnectionProperties.RETRY_ABORTS_INTERNALLY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.cloud.spanner.connection.ConnectionState.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ConnectionStateTest {

  @Parameters(name = "connectionStateType = {0}")
  public static Object[] data() {
    return ConnectionState.Type.values();
  }

  @SuppressWarnings("ClassEscapesDefinedScope")
  @Parameter
  public ConnectionState.Type connectionStateType;

  ConnectionState getNonTransactionalState() {
    return new ConnectionState(
        createConnectionOptionsBuilder().build().getInitialConnectionPropertyValues());
  }

  ConnectionState getTransactionalState() {
    return new ConnectionState(
        createConnectionOptionsBuilder()
            .setConnectionPropertyValue(CONNECTION_STATE_TYPE, Type.TRANSACTIONAL)
            .build()
            .getInitialConnectionPropertyValues());
  }

  ConnectionOptions.Builder createConnectionOptionsBuilder() {
    return ConnectionOptions.newBuilder()
        .setUri("cloudspanner:/projects/p/instances/i/databases/d")
        .setCredentials(NoCredentials.getInstance());
  }

  ConnectionState getConnectionState() {
    return connectionStateType == Type.TRANSACTIONAL
        ? getTransactionalState()
        : getNonTransactionalState();
  }

  @Test
  public void testSetOutsideTransaction() {
    ConnectionState state = getConnectionState();
    assertEquals(connectionStateType, state.getType());

    assertEquals(false, state.getValue(READONLY).getValue());
    state.setValue(READONLY, true, Context.USER, /* inTransaction= */ false);
    assertEquals(true, state.getValue(READONLY).getValue());
  }

  @Test
  public void testSetToNullOutsideTransaction() {
    ConnectionState state = getConnectionState();
    assertEquals(AutocommitDmlMode.TRANSACTIONAL, state.getValue(AUTOCOMMIT_DML_MODE).getValue());
    state.setValue(AUTOCOMMIT_DML_MODE, null, Context.USER, /* inTransaction= */ false);
    assertNull(state.getValue(AUTOCOMMIT_DML_MODE).getValue());
  }

  @Test
  public void testSetInTransactionCommit() {
    ConnectionState state = getConnectionState();
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setValue(RETRY_ABORTS_INTERNALLY, false, Context.USER, /* inTransaction= */ true);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());

    // Verify that the change is persisted if the transaction is committed.
    state.commit();
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }

  @Test
  public void testSetInTransactionRollback() {
    ConnectionState state = getConnectionState();
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setValue(RETRY_ABORTS_INTERNALLY, false, Context.USER, /* inTransaction= */ true);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());

    // Verify that the change is rolled back if the transaction is rolled back and the connection
    // state is transactional.
    state.rollback();
    // The value should rolled back to true if the state is transactional.
    // The value should (still) be false if the state is non-transactional.
    boolean expectedValue = connectionStateType == Type.TRANSACTIONAL;
    assertEquals(expectedValue, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }

  @Test
  public void testResetInTransactionCommit() {
    ConnectionState state = getConnectionState();
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setValue(RETRY_ABORTS_INTERNALLY, false, Context.USER, /* inTransaction= */ true);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.commit();

    // Reset the value to the default (true).
    state.resetValue(RETRY_ABORTS_INTERNALLY, Context.USER, /* inTransaction= */ true);
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());

    // Verify that the change is persisted if the transaction is committed.
    state.commit();
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }

  @Test
  public void testResetInTransactionRollback() {
    ConnectionState state = getConnectionState();
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setValue(RETRY_ABORTS_INTERNALLY, false, Context.USER, /* inTransaction= */ true);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.commit();

    // Reset the value to the default (true).
    state.resetValue(RETRY_ABORTS_INTERNALLY, Context.USER, /* inTransaction= */ true);
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());

    // Verify that the change is rolled back if the transaction is rolled back and the connection
    // state is transactional.
    state.rollback();
    // The value should rolled back to false if the state is transactional.
    // The value should (still) be true if the state is non-transactional.
    boolean expectedValue = connectionStateType != Type.TRANSACTIONAL;
    assertEquals(expectedValue, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }

  @Test
  public void testSetLocal() {
    ConnectionState state = getConnectionState();
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setLocalValue(RETRY_ABORTS_INTERNALLY, false);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());

    // Verify that the change is no longer visible once the transaction has ended, even if the
    // transaction was committed.
    state.commit();
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }

  @Test
  public void testSetLocalForStartupProperty() {
    ConnectionState state = getConnectionState();
    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () -> state.setLocalValue(CONNECTION_STATE_TYPE, Type.TRANSACTIONAL));
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
  }

  @Test
  public void testSetInTransactionForStartupProperty() {
    ConnectionState state = getConnectionState();
    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                state.setValue(
                    CONNECTION_STATE_TYPE,
                    Type.TRANSACTIONAL,
                    Context.USER,
                    /* inTransaction= */ true));
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
  }

  @Test
  public void testSetStartupOnlyProperty() {
    ConnectionState state = getConnectionState();
    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                state.setValue(
                    CONNECTION_STATE_TYPE,
                    Type.TRANSACTIONAL,
                    Context.USER,
                    /* inTransaction= */ false));
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
  }

  @Test
  public void testReset() {
    ConnectionState state = getConnectionState();
    // The default should be true.
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setValue(RETRY_ABORTS_INTERNALLY, false, Context.USER, /* inTransaction= */ false);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());

    // Resetting the property should reset it to the default value.
    state.resetValue(RETRY_ABORTS_INTERNALLY, Context.USER, /* inTransaction= */ false);
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }

  @Test
  public void testResetInTransaction() {
    ConnectionState state = getConnectionState();
    // The default should be true.
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setValue(RETRY_ABORTS_INTERNALLY, false, Context.USER, /* inTransaction= */ true);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.commit();

    // Resetting the property should reset it to the default value.
    state.resetValue(RETRY_ABORTS_INTERNALLY, Context.USER, /* inTransaction= */ true);
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }

  @Test
  public void testResetStartupOnlyProperty() {
    ConnectionState state = getConnectionState();
    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                state.resetValue(CONNECTION_STATE_TYPE, Context.USER, /* inTransaction= */ false));
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
  }

  @Test
  public void testInitialValueInConnectionUrl() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri("cloudspanner:/projects/p/instances/i/databases/d?retryAbortsInternally=false")
            .setCredentials(NoCredentials.getInstance())
            .build();
    ConnectionState state = new ConnectionState(options.getInitialConnectionPropertyValues());

    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
    state.setValue(RETRY_ABORTS_INTERNALLY, true, Context.USER, /* inTransaction= */ false);
    assertEquals(true, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());

    // Resetting the property should reset it to the value that was set in the connection URL.
    state.resetValue(RETRY_ABORTS_INTERNALLY, Context.USER, /* inTransaction= */ false);
    assertEquals(false, state.getValue(RETRY_ABORTS_INTERNALLY).getValue());
  }
}
