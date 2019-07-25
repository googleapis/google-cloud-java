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
import com.google.cloud.spanner.jdbc.ClientSideStatementValueConverters.AutocommitDmlModeConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AutocommitDmlModeConverterTest {

  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(AutocommitDmlModeConverter.class);
    assertThat(allowedValues, is(notNullValue()));
    AutocommitDmlModeConverter converter = new AutocommitDmlModeConverter(allowedValues);
    assertThat(converter.convert("transactional"), is(equalTo(AutocommitDmlMode.TRANSACTIONAL)));
    assertThat(converter.convert("TRANSACTIONAL"), is(equalTo(AutocommitDmlMode.TRANSACTIONAL)));
    assertThat(converter.convert("Transactional"), is(equalTo(AutocommitDmlMode.TRANSACTIONAL)));

    assertThat(
        converter.convert("partitioned_non_atomic"),
        is(equalTo(AutocommitDmlMode.PARTITIONED_NON_ATOMIC)));
    assertThat(
        converter.convert("Partitioned_Non_Atomic"),
        is(equalTo(AutocommitDmlMode.PARTITIONED_NON_ATOMIC)));
    assertThat(
        converter.convert("PARTITIONED_NON_ATOMIC"),
        is(equalTo(AutocommitDmlMode.PARTITIONED_NON_ATOMIC)));

    assertThat(converter.convert(""), is(nullValue()));
    assertThat(converter.convert(" "), is(nullValue()));
    assertThat(converter.convert("random string"), is(nullValue()));
  }
}
