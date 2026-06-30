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

package com.google.api.generator.gapic.protowriter;

import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.PackageInfoDefinition;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.composer.samplecode.SampleCodeWriter;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicPackageInfo;
import com.google.api.generator.gapic.model.ReflectConfig;
import com.google.api.generator.gapic.model.Sample;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class Writer {

  static class GapicWriterException extends RuntimeException {
    public GapicWriterException(String errorMessage, Throwable cause) {
      super(errorMessage, cause);
    }
  }

  public static final CodeGeneratorResponse EMPTY_RESPONSE = null;

  @VisibleForTesting
  protected static CodeGeneratorResponse write(
      GapicContext context,
      List<GapicClass> clazzes,
      GapicPackageInfo gapicPackageInfo,
      List<ReflectConfig> reflectConfigInfo,
      String outputFilePath,
      JarOutputStream jos,
      ByteString.Output output)
      throws IOException {
    JavaWriterVisitor codeWriter = new JavaWriterVisitor();

    if (!context.containsServices()) {
      return EMPTY_RESPONSE;
    }

    for (GapicClass gapicClazz : clazzes) {
      if (gapicClazz.kind() == GapicClass.Kind.NON_GENERATED) {
        continue;
      }
      String classPath = writeClazz(gapicClazz, codeWriter, jos);
      writeSamples(gapicClazz, getSamplePackage(gapicClazz), classPath, jos);
    }

    writeMetadataFile(context, writePackageInfo(gapicPackageInfo, codeWriter, jos), jos);
    writeReflectConfigFile(gapicPackageInfo.packageInfo().pakkage(), reflectConfigInfo, jos);

    jos.finish();
    jos.flush();

    CodeGeneratorResponse.Builder response = CodeGeneratorResponse.newBuilder();
    response
        .setSupportedFeatures(CodeGeneratorResponse.Feature.FEATURE_PROTO3_OPTIONAL_VALUE)
        .addFileBuilder()
        .setName(outputFilePath)
        .setContentBytes(output.toByteString());
    return response.build();
  }

  public static CodeGeneratorResponse write(
      GapicContext context,
      List<GapicClass> clazzes,
      GapicPackageInfo gapicPackageInfo,
      List<ReflectConfig> reflectConfigInfo,
      String outputFilePath) {
    ByteString.Output output = ByteString.newOutput();
    CodeGeneratorResponse response;
    try (JarOutputStream jos = new JarOutputStream(output)) {
      response =
          write(context, clazzes, gapicPackageInfo, reflectConfigInfo, outputFilePath, jos, output);
    } catch (IOException e) {
      throw new GapicWriterException(e.getMessage(), e);
    }
    return response;
  }

  @VisibleForTesting
  static void writeReflectConfigFile(
      String pakkage, List<ReflectConfig> reflectConfigInfo, JarOutputStream jos) {
    if (reflectConfigInfo.isEmpty()) {
      return;
    }
    Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

    // This path does not follow the recommended native-image subdirectory structure defined by
    // https://www.graalvm.org/22.1/reference-manual/native-image/BuildConfiguration/#embedding-a-configuration-file
    //
    // The recommended subdirectory is .../native-image/<groupId>/<artifactId>/reflect-config.json
    // to prevent multiple jars from having overlapping configurations when combined into the same
    // native-image. However, we don't have access to the client library's groupId and artifactId in
    // the GAPIC generator, and we're only providing a single reflection configuration per client
    // library. So this package-based path is "unique enough" for our current use.
    //
    // TODO: If we begin splitting the reflection configuration into gapic-specific, grpc-specific,
    // and proto-specific files, we will need to prevent collisions by either following the
    // recommended subdirectory structure, or adding a gapic/grpc/proto identifier to this path.
    String jarEntryLocation =
        String.format("src/main/resources/META-INF/native-image/%s/reflect-config.json", pakkage);
    try {
      jos.putNextEntry(new JarEntry(jarEntryLocation));
      jos.write(prettyGson.toJson(reflectConfigInfo).getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new GapicWriterException("Could not write reflect-config.json", e);
    }
  }

  private static String writeClazz(
      GapicClass gapicClazz, JavaWriterVisitor codeWriter, JarOutputStream jos) {
    ClassDefinition clazz = gapicClazz.classDefinition();

    clazz.accept(codeWriter);
    String code = codeWriter.write();
    codeWriter.clear();

    String path = getPath(clazz.packageString(), clazz.classIdentifier().name());
    String className = clazz.classIdentifier().name();
    JarEntry jarEntry = new JarEntry(String.format("%s/%s.java", path, className));
    try {
      jos.putNextEntry(jarEntry);
      jos.write(code.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new GapicWriterException(
          String.format(
              "Could not write code for class %s.%s: %s",
              clazz.packageString(), clazz.classIdentifier().name(), e.getMessage()),
          e);
    }
    return path;
  }

  private static void writeSamples(
      GapicClass gapicClazz, String pakkage, String clazzPath, JarOutputStream jos) {
    for (Sample sample : gapicClazz.samples()) {
      JarEntry jarEntry =
          new JarEntry(
              String.format(
                  "samples/snippets/generated/%s/%s/%s/%s.java",
                  clazzPath,
                  sample.regionTag().serviceName().toLowerCase(),
                  sample.regionTag().rpcName().toLowerCase(),
                  sample.name()));
      String executableSampleCode = SampleCodeWriter.writeExecutableSample(sample, pakkage);
      try {
        jos.putNextEntry(jarEntry);
        jos.write(executableSampleCode.getBytes(StandardCharsets.UTF_8));
      } catch (IOException e) {
        throw new GapicWriterException(
            String.format(
                "Could not write sample code for %s/%s.: %s",
                clazzPath, sample.name(), e.getMessage()),
            e);
      }
    }
  }

  @VisibleForTesting
  static String writePackageInfo(
      GapicPackageInfo gapicPackageInfo, JavaWriterVisitor codeWriter, JarOutputStream jos) {
    PackageInfoDefinition packageInfo = gapicPackageInfo.packageInfo();
    packageInfo.accept(codeWriter);
    String code = codeWriter.write();
    codeWriter.clear();

    String packagePath = "src/main/java/" + packageInfo.pakkage().replaceAll("\\.", "/");
    JarEntry jarEntry = new JarEntry(String.format("%s/package-info.java", packagePath));
    try {
      jos.putNextEntry(jarEntry);
      jos.write(code.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new GapicWriterException("Could not write code for package-info.java", e);
    }
    return packagePath;
  }

  private static void writeMetadataFile(GapicContext context, String path, JarOutputStream jos) {
    if (context.gapicMetadataEnabled()) {
      JarEntry jarEntry = new JarEntry(String.format("%s/gapic_metadata.json", path));
      try {
        jos.putNextEntry(jarEntry);
        jos.write(
            JsonFormat.printer().print(context.gapicMetadata()).getBytes(StandardCharsets.UTF_8));
      } catch (IOException e) {
        throw new GapicWriterException("Could not write gapic_metadata.json", e);
      }
    }
  }

  private static String getPath(String pakkage, String className) {
    String path = pakkage.replaceAll("\\.", "/");
    if (className.startsWith("Mock") || className.endsWith("Test")) {
      path = "src/test/java/" + path;
    } else {
      path = "src/main/java/" + path;
    }

    // Resource name helpers go into the protobuf package. Denote this with "proto/src/main/*".
    if (className.endsWith("Name")) {
      path = "proto/" + path;
    }
    return path;
  }

  private static String getSamplePackage(GapicClass gapicClazz) {
    return gapicClazz.classDefinition().packageString().concat(".samples");
  }
}
