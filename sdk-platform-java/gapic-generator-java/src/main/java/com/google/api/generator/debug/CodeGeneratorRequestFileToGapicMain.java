// Copyright 2021 Google LLC
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

package com.google.api.generator.debug;

import com.google.api.generator.ProtoRegistry;
import com.google.api.generator.gapic.Generator;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// A generator entry point class, similar to Main but reads the CodeGeneratorRequest directly from a
// file instead of relying on protoc to pipe it in.
public class CodeGeneratorRequestFileToGapicMain {
  public static void main(String[] args) throws IOException {
    ExtensionRegistry registry = ExtensionRegistry.newInstance();
    ProtoRegistry.registerAllExtensions(registry);

    String inputFile = args[0];
    String outputFile = args[1];

    try (InputStream inputStream = new FileInputStream(inputFile);
        OutputStream outputStream = new FileOutputStream(outputFile)) {
      CodeGeneratorRequest request = CodeGeneratorRequest.parseFrom(inputStream, registry);
      CodeGeneratorResponse response = Generator.generateGapic(request);
      response.writeTo(outputStream);
    }
  }
}
