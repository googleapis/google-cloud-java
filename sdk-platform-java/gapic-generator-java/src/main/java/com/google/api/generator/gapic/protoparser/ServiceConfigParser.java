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

import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.protobuf.util.JsonFormat;
import io.grpc.serviceconfig.ServiceConfig;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class ServiceConfigParser {
  public static Optional<GapicServiceConfig> parse(String serviceConfigFilePath) {
    Optional<ServiceConfig> rawConfigOpt = parseFile(serviceConfigFilePath);
    return Optional.of(GapicServiceConfig.create(rawConfigOpt));
  }

  @VisibleForTesting
  static Optional<ServiceConfig> parseFile(String serviceConfigFilePath) {
    if (Strings.isNullOrEmpty(serviceConfigFilePath)) {
      return Optional.empty();
    }

    ServiceConfig.Builder builder = ServiceConfig.newBuilder();
    FileReader file = null;
    try {
      file = new FileReader(serviceConfigFilePath);
    } catch (FileNotFoundException e) {
      return Optional.empty();
    }

    try {
      JsonFormat.parser().merge(file, builder);
    } catch (IOException e) {
      return Optional.empty();
    }
    return Optional.of(builder.build());
  }
}
