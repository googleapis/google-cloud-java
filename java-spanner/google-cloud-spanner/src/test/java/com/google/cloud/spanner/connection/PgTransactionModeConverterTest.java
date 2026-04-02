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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.PgTransactionMode.AccessMode.READ_ONLY_TRANSACTION;
import static com.google.cloud.spanner.connection.PgTransactionMode.AccessMode.READ_WRITE_TRANSACTION;
import static com.google.cloud.spanner.connection.PgTransactionMode.IsolationLevel.ISOLATION_LEVEL_DEFAULT;
import static com.google.cloud.spanner.connection.PgTransactionMode.IsolationLevel.ISOLATION_LEVEL_REPEATABLE_READ;
import static com.google.cloud.spanner.connection.PgTransactionMode.IsolationLevel.ISOLATION_LEVEL_SERIALIZABLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.PgTransactionModeConverter;
import com.google.cloud.spanner.connection.PgTransactionMode.AccessMode;
import com.google.cloud.spanner.connection.PgTransactionMode.IsolationLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PgTransactionModeConverterTest {

  static PgTransactionMode create(AccessMode accessMode) {
    return create(accessMode, null);
  }

  static PgTransactionMode create(IsolationLevel isolationLevel) {
    return create(null, isolationLevel);
  }

  static PgTransactionMode create(AccessMode accessMode, IsolationLevel isolationLevel) {
    PgTransactionMode mode = new PgTransactionMode();
    mode.setAccessMode(accessMode);
    mode.setIsolationLevel(isolationLevel);
    return mode;
  }

  @SuppressWarnings("ClassEscapesDefinedScope")
  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(
            PgTransactionModeConverter.class, Dialect.POSTGRESQL);

    assertNotNull(allowedValues);
    PgTransactionModeConverter converter = new PgTransactionModeConverter(allowedValues);

    assertEquals(create(READ_WRITE_TRANSACTION), converter.convert("read write"));
    assertEquals(create(READ_WRITE_TRANSACTION), converter.convert("READ WRITE"));
    assertEquals(create(READ_WRITE_TRANSACTION), converter.convert("Read Write"));
    assertEquals(create(READ_WRITE_TRANSACTION), converter.convert("read   write"));
    assertEquals(create(READ_WRITE_TRANSACTION), converter.convert("READ\nWRITE"));
    assertEquals(create(READ_WRITE_TRANSACTION), converter.convert("Read\tWrite"));

    assertEquals(create(READ_ONLY_TRANSACTION), converter.convert("read only"));
    assertEquals(create(READ_ONLY_TRANSACTION), converter.convert("READ ONLY"));
    assertEquals(create(READ_ONLY_TRANSACTION), converter.convert("Read Only"));
    assertEquals(create(READ_ONLY_TRANSACTION), converter.convert("read   only"));
    assertEquals(create(READ_ONLY_TRANSACTION), converter.convert("READ\nONLY"));
    assertEquals(create(READ_ONLY_TRANSACTION), converter.convert("Read\tOnly"));

    assertEquals(create(ISOLATION_LEVEL_DEFAULT), converter.convert("isolation level default"));
    assertEquals(create(ISOLATION_LEVEL_DEFAULT), converter.convert("ISOLATION LEVEL DEFAULT"));
    assertEquals(create(ISOLATION_LEVEL_DEFAULT), converter.convert("Isolation Level Default"));
    assertEquals(create(ISOLATION_LEVEL_DEFAULT), converter.convert("isolation    level  default"));
    assertEquals(create(ISOLATION_LEVEL_DEFAULT), converter.convert("ISOLATION\nLEVEL\nDEFAULT"));
    assertEquals(create(ISOLATION_LEVEL_DEFAULT), converter.convert("Isolation\tLevel\tDefault"));

    assertEquals(
        create(ISOLATION_LEVEL_SERIALIZABLE), converter.convert("isolation level serializable"));
    assertEquals(
        create(ISOLATION_LEVEL_SERIALIZABLE), converter.convert("ISOLATION LEVEL SERIALIZABLE"));
    assertEquals(
        create(ISOLATION_LEVEL_SERIALIZABLE), converter.convert("Isolation Level Serializable"));
    assertEquals(
        create(ISOLATION_LEVEL_SERIALIZABLE),
        converter.convert("isolation    level  serializable"));
    assertEquals(
        create(ISOLATION_LEVEL_SERIALIZABLE), converter.convert("ISOLATION\nLEVEL\nSERIALIZABLE"));
    assertEquals(
        create(ISOLATION_LEVEL_SERIALIZABLE), converter.convert("Isolation\tLevel\tSerializable"));

    assertEquals(
        create(ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("isolation level repeatable read"));
    assertEquals(
        create(ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("ISOLATION LEVEL REPEATABLE READ"));
    assertEquals(
        create(ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("Isolation Level Repeatable Read"));
    assertEquals(
        create(ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("isolation    level  repeatable    read"));
    assertEquals(
        create(ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("ISOLATION\nLEVEL\nREPEATABLE\nREAD"));
    assertEquals(
        create(ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("Isolation\tLevel\tRepeatable\tRead"));

    assertEquals(new PgTransactionMode(), converter.convert(""));
    assertEquals(new PgTransactionMode(), converter.convert(" "));
    assertNull(converter.convert("random string"));
    assertNull(converter.convert("read_write"));
    assertNull(converter.convert("READ_WRITE"));
    assertNull(converter.convert("read_only"));
    assertNull(converter.convert("Read_Only"));
    assertNull(converter.convert("READ_ONLY"));

    assertNull(converter.convert("isolation_level default"));
    assertNull(converter.convert("isolationlevel default"));
    assertNull(converter.convert("isolation level read committed"));
    assertNull(converter.convert("isolation level "));
    assertNull(converter.convert("isolation level_default"));

    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("read write isolation level default"));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("  read write isolation level default  "));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("read write, isolation level default"));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("read write,isolation level default"));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("read write , isolation level default"));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("read write\nisolation level default"));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("isolation level default read write "));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("isolation level default, read write"));
    assertEquals(
        create(READ_WRITE_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("isolation level default\nread write"));
    assertEquals(
        create(READ_ONLY_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("read only isolation level default"));
    assertEquals(
        create(READ_ONLY_TRANSACTION, ISOLATION_LEVEL_SERIALIZABLE),
        converter.convert("read only isolation level serializable"));
    assertEquals(
        create(READ_ONLY_TRANSACTION, ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("read only isolation level repeatable read"));

    assertNull(converter.convert("isolation level default, read-only"));
    assertNull(converter.convert("isolation level default, read"));

    // This is consistent with the behavior of PostgreSQL. Specifying multiple access modes or
    // isolation levels in the same string will return the last mode that is specified.
    assertEquals(
        create(READ_ONLY_TRANSACTION, ISOLATION_LEVEL_DEFAULT),
        converter.convert("read write, isolation level default, read only"));
    assertEquals(
        create(READ_ONLY_TRANSACTION, ISOLATION_LEVEL_SERIALIZABLE),
        converter.convert("isolation level default, read only, isolation level serializable"));
    assertEquals(
        create(READ_ONLY_TRANSACTION, ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert("isolation level default, read only, isolation level repeatable read"));
    assertEquals(
        create(READ_ONLY_TRANSACTION, ISOLATION_LEVEL_REPEATABLE_READ),
        converter.convert(
            "read write, isolation level default, read only isolation level repeatable read"));
  }
}
