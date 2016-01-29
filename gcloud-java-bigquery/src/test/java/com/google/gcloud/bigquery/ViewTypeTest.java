/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class ViewTypeTest {

  private static final String VIEW_QUERY = "VIEW QUERY";
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS =
      ImmutableList.of(UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final ViewType VIEW_TYPE =
      ViewType.builder(VIEW_QUERY, USER_DEFINED_FUNCTIONS).build();

  @Test
  public void testToBuilder() {
    compareViewType(VIEW_TYPE, VIEW_TYPE.toBuilder().build());
    ViewType viewType = VIEW_TYPE.toBuilder()
        .query("NEW QUERY")
        .build();
    assertEquals("NEW QUERY", viewType.query());
    viewType = viewType.toBuilder()
        .query(VIEW_QUERY)
        .build();
    compareViewType(VIEW_TYPE, viewType);
  }

  @Test
  public void testToBuilderIncomplete() {
    BaseTableType tableType = ViewType.of(VIEW_QUERY);
    assertEquals(tableType, tableType.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(VIEW_QUERY, VIEW_TYPE.query());
    assertEquals(BaseTableType.Type.VIEW, VIEW_TYPE.type());
    assertEquals(USER_DEFINED_FUNCTIONS, VIEW_TYPE.userDefinedFunctions());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(BaseTableType.fromPb(VIEW_TYPE.toPb()) instanceof ViewType);
    compareViewType(VIEW_TYPE, BaseTableType.<ViewType>fromPb(VIEW_TYPE.toPb()));
  }

  private void compareViewType(ViewType expected, ViewType value) {
    assertEquals(expected, value);
    assertEquals(expected.query(), value.query());
    assertEquals(expected.userDefinedFunctions(), value.userDefinedFunctions());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
