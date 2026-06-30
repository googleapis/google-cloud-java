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

package com.google.cloud.spanner.connection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.BooleanConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BooleanConverterTest {
  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(BooleanConverter.class, dialect);
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
