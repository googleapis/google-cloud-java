// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.protoparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.testgapic.v1beta1.LockerProto;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResourceReferenceParserTest {
  private static final String MAIN_PACKAGE = "com.google.testgapic.v1beta1";

  private FileDescriptor lockerServiceFileDescriptor;

  @BeforeEach
  void setUp() {
    lockerServiceFileDescriptor = LockerProto.getDescriptor();
  }

  @Test
  void parseParentResourceName_createFromPattern() {
    String resourceNamePackage = String.format("%s.common", MAIN_PACKAGE);
    String domainName = "cloudbilling.googleapis.com";
    String description = "This is the resource name description";
    String resourceTypeString = String.format("%s/BillingAccount", domainName);
    String parentResourceTypeString = String.format("%s/Project", domainName);
    Map<String, ResourceName> patternsToResourceNames = new HashMap<>();

    String parentPattern = "projects/{project}";
    Optional<ResourceName> parentResourceNameOpt =
        ResourceReferenceParser.parseParentResourceName(
            String.format("%s/billingAccounts/{billing_account}", parentPattern),
            MAIN_PACKAGE,
            resourceNamePackage,
            resourceTypeString,
            description,
            patternsToResourceNames);
    assertTrue(parentResourceNameOpt.isPresent());

    ResourceName parentResourceName = parentResourceNameOpt.get();
    assertEquals("project", parentResourceName.variableName());
    assertEquals(Arrays.asList(parentPattern), parentResourceName.patterns());
    assertEquals(parentResourceTypeString, parentResourceName.resourceTypeString());
    assertEquals(resourceNamePackage, parentResourceName.pakkage());
    assertEquals(description, parentResourceName.description());
    assertEquals(
        TypeNode.withReference(
            VaporReference.builder()
                .setName("ProjectName")
                .setPakkage(resourceNamePackage)
                .build()),
        parentResourceName.type());
    assertEquals(patternsToResourceNames.get(parentPattern), parentResourceName);
  }

  @Test
  void parseParentResourceName_parentResourceNameExists() {
    Map<String, ResourceName> typeStringsToResourceNames =
        ResourceNameParser.parseResourceNamesFromFile(lockerServiceFileDescriptor);

    Map<String, ResourceName> patternsToResourceNames = new HashMap<>();
    for (ResourceName resourceName : typeStringsToResourceNames.values()) {
      for (String pattern : resourceName.patterns()) {
        patternsToResourceNames.put(pattern, resourceName);
      }
    }

    Optional<ResourceName> parentResourceNameOpt =
        ResourceReferenceParser.parseParentResourceName(
            "projects/{project}/folders/{folder}/documents/{document}",
            MAIN_PACKAGE,
            null,
            MAIN_PACKAGE,
            "cloudresourcemanager.googleapis.com/Document",
            patternsToResourceNames);

    assertTrue(parentResourceNameOpt.isPresent());
    assertEquals(
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Folder"),
        parentResourceNameOpt.get());
  }

  @Test
  void parseParentResourceName_badPattern() {
    Optional<ResourceName> parentResourceNameOpt =
        ResourceReferenceParser.parseParentResourceName(
            "projects/{project}/billingAccounts",
            MAIN_PACKAGE,
            "com.google.cloud.billing.v1",
            "cloudbilling.googleapis.com/Feature",
            null,
            new HashMap<String, ResourceName>());
    assertTrue(parentResourceNameOpt.isPresent());
    assertEquals("projects/{project}", parentResourceNameOpt.get().patterns().get(0));
  }

  @Test
  void resolvePackages_resourcePackageIsSubpackageOfService() {
    String resourcePackage = "com.google.testgapic.v1beta1.common";
    assertEquals(
        resourcePackage, ResourceReferenceParser.resolvePackages(resourcePackage, MAIN_PACKAGE));
  }

  @Test
  void resolvePackages_resourcePackageIsSameAsService() {
    assertEquals(MAIN_PACKAGE, ResourceReferenceParser.resolvePackages(MAIN_PACKAGE, MAIN_PACKAGE));
  }

  @Test
  void resolvePackages_resourcePackageIsNotSubpackageOfService() {
    assertEquals(
        MAIN_PACKAGE, ResourceReferenceParser.resolvePackages("com.google.cloud", MAIN_PACKAGE));
  }
}
