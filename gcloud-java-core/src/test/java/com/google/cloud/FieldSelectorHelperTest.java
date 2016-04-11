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

package com.google.cloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.cloud.FieldSelector.Helper;

import org.junit.Test;

import java.util.List;

public class FieldSelectorHelperTest {

  private static final FieldSelector FIELD1 = new FieldSelector() {
    @Override
    public String selector() {
      return "field1";
    }
  };
  private static final FieldSelector FIELD2 = new FieldSelector() {
    @Override
    public String selector() {
      return "field2";
    }
  };
  private static final FieldSelector FIELD3 = new FieldSelector() {
    @Override
    public String selector() {
      return "field3";
    }
  };
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
    String selector = Helper.listSelector(CONTAINER, REQUIRED_FIELDS,
        new FieldSelector[]{FIELD3}, "field4");
    assertTrue(selector.startsWith("nextPageToken,container("));
    assertTrue(selector.contains("field1"));
    assertTrue(selector.contains("field2"));
    assertTrue(selector.contains("field3"));
    assertTrue(selector.contains("field4"));
    assertTrue(selector.endsWith(")"));
    assertEquals(52, selector.length());
  }
}
