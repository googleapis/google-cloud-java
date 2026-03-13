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

package com.google.api.generator.gapic.model;

import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;
import javax.annotation.Nonnull;

/**
 * A light wrapper around SourceCodeInfo.Location to provide cleaner protobuf comments. Please see
 * additional documentation on descriptor.proto.
 */
public class SourceCodeInfoLocation {
  @Nonnull private final Location location;

  private SourceCodeInfoLocation(Location location) {
    this.location = location;
  }

  public static SourceCodeInfoLocation create(@Nonnull Location location) {
    return new SourceCodeInfoLocation(location);
  }

  public String getLeadingComments() {
    return processProtobufComment(location.getLeadingComments());
  }

  public String getTrailingComments() {
    return processProtobufComment(location.getTrailingComments());
  }

  public String getLeadingDetachedComments(int index) {
    return processProtobufComment(location.getLeadingDetachedComments(index));
  }

  private String processProtobufComment(String s) {
    return s.trim();
  }
}
