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

public class ViewDefinitionTest {

  private static final String VIEW_QUERY = "VIEW QUERY";
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS =
      ImmutableList.of(UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final ViewDefinition VIEW_DEFINITION =
      ViewDefinition.builder(VIEW_QUERY, USER_DEFINED_FUNCTIONS).build();

  @Test
  public void testToBuilder() {
    compareViewDefinition(VIEW_DEFINITION, VIEW_DEFINITION.toBuilder().build());
    ViewDefinition viewDefinition = VIEW_DEFINITION.toBuilder()
        .query("NEW QUERY")
        .build();
    assertEquals("NEW QUERY", viewDefinition.query());
    viewDefinition = viewDefinition.toBuilder()
        .query(VIEW_QUERY)
        .build();
    compareViewDefinition(VIEW_DEFINITION, viewDefinition);
  }

  @Test
  public void testToBuilderIncomplete() {
    BaseTableDefinition viewDefinition = ViewDefinition.of(VIEW_QUERY);
    assertEquals(viewDefinition, viewDefinition.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(VIEW_QUERY, VIEW_DEFINITION.query());
    assertEquals(BaseTableDefinition.Type.VIEW, VIEW_DEFINITION.type());
    assertEquals(USER_DEFINED_FUNCTIONS, VIEW_DEFINITION.userDefinedFunctions());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(BaseTableDefinition.fromPb(VIEW_DEFINITION.toPb()) instanceof ViewDefinition);
    compareViewDefinition(VIEW_DEFINITION, BaseTableDefinition.<ViewDefinition>fromPb(VIEW_DEFINITION.toPb()));
  }

  private void compareViewDefinition(ViewDefinition expected, ViewDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.query(), value.query());
    assertEquals(expected.userDefinedFunctions(), value.userDefinedFunctions());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
