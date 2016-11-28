/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class QueryParameterTest {
  @Test
  public void testOf() {
    QueryParameter param = QueryParameter.of(QueryParameterValue.int64(0));
    assertNull(param.getName());
    assertEquals(QueryParameterValue.int64(0), param.getParameterValue());
  }

  @Test
  public void testNamed() {
    QueryParameter param = QueryParameter.named("paramName", QueryParameterValue.string("val"));
    assertEquals("paramName", param.getName());
    assertEquals(QueryParameterValue.string("val"), param.getParameterValue());
  }

  @Test
  public void testToPbAndFromPb() {
    QueryParameter param = QueryParameter.named("paramName", QueryParameterValue.string("val"));
    QueryParameter reconverted = QueryParameter.fromPb(param.toPb());
    assertEquals(param.getName(), reconverted.getName());
    assertEquals(param.getParameterValue(), reconverted.getParameterValue());
  }
}
