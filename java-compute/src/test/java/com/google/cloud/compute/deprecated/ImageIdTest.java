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

package com.google.cloud.compute.deprecated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ImageIdTest {

  private static final String PROJECT = "project";
  private static final String NAME = "image";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/global/images/image";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    ImageId imageId = ImageId.of(PROJECT, NAME);
    assertEquals(PROJECT, imageId.getProject());
    assertEquals(NAME, imageId.getImage());
    assertEquals(URL, imageId.getSelfLink());
    imageId = ImageId.of(NAME);
    assertNull(imageId.getProject());
    assertEquals(NAME, imageId.getImage());
  }

  @Test
  public void testToAndFromUrl() {
    ImageId imageId = ImageId.of(PROJECT, NAME);
    compareImageId(imageId, ImageId.fromUrl(imageId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid image URL");
    ImageId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    ImageId imageId = ImageId.of(PROJECT, NAME);
    assertSame(imageId, imageId.setProjectId(PROJECT));
    compareImageId(imageId, ImageId.of(NAME).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(ImageId.matchesUrl(ImageId.of(PROJECT, NAME).getSelfLink()));
    assertFalse(ImageId.matchesUrl("notMatchingUrl"));
  }

  private void compareImageId(ImageId expected, ImageId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getImage(), expected.getImage());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
