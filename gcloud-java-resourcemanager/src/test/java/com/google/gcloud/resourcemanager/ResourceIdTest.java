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

package com.google.gcloud.resourcemanager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ResourceIdTest {

private static final ResourceId RESOURCE_ID = ResourceId.of("id", ResourceId.Type.ORGANIZATION);

  @Test
  public void testOf() {
    assertEquals(RESOURCE_ID.id(), "id");
    assertEquals(RESOURCE_ID.type(), ResourceId.Type.ORGANIZATION);
  }

  @Test
  public void testEquals() {
    assertEquals(RESOURCE_ID, ResourceId.of("id", ResourceId.Type.ORGANIZATION));
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(RESOURCE_ID, ResourceId.fromPb(RESOURCE_ID.toPb()));
  }
}
