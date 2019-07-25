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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.jdbc.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.jdbc.ClientSideStatementValueConverters.TransactionModeConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TransactionModeConverterTest {

  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(TransactionModeConverter.class);
    assertThat(allowedValues, is(notNullValue()));
    TransactionModeConverter converter = new TransactionModeConverter(allowedValues);
    assertThat(
        converter.convert("read write"), is(equalTo(TransactionMode.READ_WRITE_TRANSACTION)));
    assertThat(
        converter.convert("READ WRITE"), is(equalTo(TransactionMode.READ_WRITE_TRANSACTION)));
    assertThat(
        converter.convert("Read Write"), is(equalTo(TransactionMode.READ_WRITE_TRANSACTION)));
    assertThat(
        converter.convert("read   write"), is(equalTo(TransactionMode.READ_WRITE_TRANSACTION)));
    assertThat(
        converter.convert("READ\nWRITE"), is(equalTo(TransactionMode.READ_WRITE_TRANSACTION)));
    assertThat(
        converter.convert("Read\tWrite"), is(equalTo(TransactionMode.READ_WRITE_TRANSACTION)));

    assertThat(converter.convert("read only"), is(equalTo(TransactionMode.READ_ONLY_TRANSACTION)));
    assertThat(converter.convert("READ ONLY"), is(equalTo(TransactionMode.READ_ONLY_TRANSACTION)));
    assertThat(converter.convert("Read Only"), is(equalTo(TransactionMode.READ_ONLY_TRANSACTION)));
    assertThat(
        converter.convert("read   only"), is(equalTo(TransactionMode.READ_ONLY_TRANSACTION)));
    assertThat(converter.convert("READ\nONLY"), is(equalTo(TransactionMode.READ_ONLY_TRANSACTION)));
    assertThat(converter.convert("Read\tOnly"), is(equalTo(TransactionMode.READ_ONLY_TRANSACTION)));

    assertThat(converter.convert(""), is(nullValue()));
    assertThat(converter.convert(" "), is(nullValue()));
    assertThat(converter.convert("random string"), is(nullValue()));
    assertThat(converter.convert("read_write"), is(nullValue()));
    assertThat(converter.convert("Read_Write"), is(nullValue()));
    assertThat(converter.convert("READ_WRITE"), is(nullValue()));
    assertThat(converter.convert("read_only"), is(nullValue()));
    assertThat(converter.convert("Read_Only"), is(nullValue()));
    assertThat(converter.convert("READ_ONLY"), is(nullValue()));
  }
}
