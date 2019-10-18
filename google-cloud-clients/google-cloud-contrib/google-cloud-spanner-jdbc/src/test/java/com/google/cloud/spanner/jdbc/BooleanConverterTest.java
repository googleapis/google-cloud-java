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
import com.google.cloud.spanner.jdbc.ClientSideStatementValueConverters.BooleanConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BooleanConverterTest {

  @Test
  public void testConvert() throws CompileException {
    String allowedValues = ReadOnlyStalenessConverterTest.getAllowedValues(BooleanConverter.class);
    assertThat(allowedValues, is(notNullValue()));
    BooleanConverter converter = new BooleanConverter(allowedValues);
    assertThat(converter.convert("true"), is(equalTo(Boolean.TRUE)));
    assertThat(converter.convert("TRUE"), is(equalTo(Boolean.TRUE)));
    assertThat(converter.convert("True"), is(equalTo(Boolean.TRUE)));

    assertThat(converter.convert("false"), is(equalTo(Boolean.FALSE)));
    assertThat(converter.convert("FALSE"), is(equalTo(Boolean.FALSE)));
    assertThat(converter.convert("False"), is(equalTo(Boolean.FALSE)));

    assertThat(converter.convert(""), is(nullValue()));
    assertThat(converter.convert(" "), is(nullValue()));
    assertThat(converter.convert("random string"), is(nullValue()));
  }
}
