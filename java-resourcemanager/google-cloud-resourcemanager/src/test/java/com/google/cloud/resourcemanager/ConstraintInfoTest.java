/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.resourcemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.services.cloudresourcemanager.model.BooleanConstraint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConstraintInfoTest {

  private static final String NAME = "constraints/serviceuser.services";
  private static final String CONSTRAINT_DEFAULT = "ALLOW";
  private static final String DISPLAY_NAME = "constraints-display-name";
  private static final String DESCRIPTION =
      "Detailed description of what this Constraint controls as well as how and where it is enforced";
  private static final Integer VERSION = 1;
  private static final ConstraintInfo.Constraints LIST_CONSTRAINT =
      new ConstraintInfo.Constraints("suggested-value", true);

  private ConstraintInfo constraintInfo;
  private BooleanConstraint booleanConstraint;

  @Before
  public void setUp() {
    booleanConstraint = new BooleanConstraint();
    booleanConstraint.set("boolean", Boolean.class);
    constraintInfo =
        ConstraintInfo.newBuilder(NAME)
            .setConstraintDefault(CONSTRAINT_DEFAULT)
            .setDisplayName(DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .setConstraints(LIST_CONSTRAINT)
            .setBooleanConstraint(booleanConstraint)
            .setVersion(VERSION)
            .build();
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, constraintInfo.getName());
    assertEquals(CONSTRAINT_DEFAULT, constraintInfo.getConstraintDefault());
    assertEquals(DISPLAY_NAME, constraintInfo.getDisplayName());
    assertEquals(DESCRIPTION, constraintInfo.getDescription());
    assertEquals(LIST_CONSTRAINT, constraintInfo.getConstraints());
    assertEquals(booleanConstraint, constraintInfo.getBooleanConstraint());
    assertEquals(VERSION, constraintInfo.getVersion());
  }

  @Test
  public void testToBuilder() {
    compareConstraints(constraintInfo, constraintInfo.toBuilder().build());
  }

  @Test
  public void testToAndFromProtobuf() {
    compareConstraints(constraintInfo, ConstraintInfo.fromProtobuf(constraintInfo.toProtobuf()));
    assertNotNull(ConstraintInfo.TO_PROTOBUF_FUNCTION.apply(constraintInfo));
    assertNotNull(
        ConstraintInfo.FROM_PROTOBUF_FUNCTION.apply(
            ConstraintInfo.TO_PROTOBUF_FUNCTION.apply(constraintInfo)));
  }

  @Test
  public void testEquals() {
    compareConstraints(
        constraintInfo,
        ConstraintInfo.newBuilder(NAME)
            .setConstraintDefault(CONSTRAINT_DEFAULT)
            .setDisplayName(DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .setConstraints(LIST_CONSTRAINT)
            .setBooleanConstraint(booleanConstraint)
            .setVersion(VERSION)
            .build());
    compareConstraints(constraintInfo, new ConstraintInfo.Builder(constraintInfo).build());
  }

  @Test
  public void testToString() {
    assertTrue(
        LIST_CONSTRAINT
            .toString()
            .contains("suggestedValue=" + LIST_CONSTRAINT.getSuggestedValue()));
    assertTrue(
        LIST_CONSTRAINT.toString().contains("supportsUnder=" + LIST_CONSTRAINT.getSupportsUnder()));
  }

  private void compareConstraints(ConstraintInfo expected, ConstraintInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getConstraintDefault(), value.getConstraintDefault());
    assertEquals(expected.getDisplayName(), value.getDisplayName());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getConstraints(), value.getConstraints());
    assertEquals(expected.getVersion(), value.getVersion());
  }
}
