/*
 * Copyright 2016 Google LLC
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

package com.google.cloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.FieldSelector.Helper;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class FieldSelectorHelperTest {

  private static final FieldSelector FIELD1 =
      new FieldSelector() {
        @Override
        public String getSelector() {
          return "field1";
        }
      };
  private static final FieldSelector FIELD2 =
      new FieldSelector() {
        @Override
        public String getSelector() {
          return "field2";
        }
      };
  private static final FieldSelector FIELD3 =
      new FieldSelector() {
        @Override
        public String getSelector() {
          return "field3";
        }
      };
  private static final String[] FIRST_LEVEL_FIELDS = {"firstLevel1", "firstLevel2"};
  private static final List<FieldSelector> REQUIRED_FIELDS = ImmutableList.of(FIELD1, FIELD2);
  private static final String CONTAINER = "container";

  @Test
  public void testSelector() {
    String selector = Helper.selector(REQUIRED_FIELDS, FIELD3);
    assertTrue(selector.contains("field1"));
    assertTrue(selector.contains("field2"));
    assertTrue(selector.contains("field3"));
    assertEquals(20, selector.length());
  }

  @Test
  public void testListSelector() {
    String selector = Helper.listSelector(CONTAINER, REQUIRED_FIELDS, FIELD3);
    assertTrue(selector.startsWith("nextPageToken,container("));
    assertTrue(selector.contains("field1"));
    assertTrue(selector.contains("field2"));
    assertTrue(selector.contains("field3"));
    assertTrue(selector.endsWith(")"));
    assertEquals(45, selector.length());
  }

  @Test
  public void testListSelectorWithExtraFields() {
    String selector =
        Helper.listSelector(CONTAINER, REQUIRED_FIELDS, new FieldSelector[] {FIELD3}, "field4");
    assertTrue(selector.startsWith("nextPageToken,container("));
    assertTrue(selector.contains("field1"));
    assertTrue(selector.contains("field2"));
    assertTrue(selector.contains("field3"));
    assertTrue(selector.contains("field4"));
    assertTrue(selector.endsWith(")"));
    assertEquals(52, selector.length());
  }

  @Test
  public void testListSelectorWithFirstLevelFields() {
    String selector =
        Helper.listSelector(
            FIRST_LEVEL_FIELDS, CONTAINER, REQUIRED_FIELDS, new FieldSelector[] {FIELD3}, "field4");
    assertTrue(selector.contains("firstLevel1"));
    assertTrue(selector.contains("firstLevel2"));
    assertTrue(selector.contains("nextPageToken"));
    assertTrue(selector.contains("container("));
    assertTrue(selector.contains("field1"));
    assertTrue(selector.contains("field2"));
    assertTrue(selector.contains("field3"));
    assertTrue(selector.contains("field4"));
    assertTrue(selector.endsWith(")"));
    assertEquals(76, selector.length());
  }
}
