/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.tracing;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.LibraryMetadata;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiTracerContextTest {

  @Test
  void testGetAttemptAttributes_serverAddress() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(LibraryMetadata.empty())
            .setServerAddress("test-address")
            .build();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes)
        .containsEntry(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE, "test-address");
  }

  @Test
  void testGetAttemptAttributes_repo() {
    LibraryMetadata libraryMetadata =
        LibraryMetadata.newBuilder().setRepository("test-repo").build();
    ApiTracerContext context =
        ApiTracerContext.newBuilder().setLibraryMetadata(libraryMetadata).build();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes).containsEntry(ObservabilityAttributes.REPO_ATTRIBUTE, "test-repo");
  }

  @Test
  void testGetAttemptAttributes_artifact() {
    LibraryMetadata libraryMetadata =
        LibraryMetadata.newBuilder().setArtifactName("test-artifact").build();
    ApiTracerContext context =
        ApiTracerContext.newBuilder().setLibraryMetadata(libraryMetadata).build();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes)
        .containsEntry(ObservabilityAttributes.ARTIFACT_ATTRIBUTE, "test-artifact");
  }

  @Test
  void testGetAttemptAttributes_fullMethodName_noTransport_notPresent() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(LibraryMetadata.empty())
            .setFullMethodName("google.pubsub.v1.Publisher/Publish")
            .build();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes).doesNotContainKey(ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE);
  }

  @Test
  void testGetAttemptAttributes_fullMethodName_grpcTransport_present() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(LibraryMetadata.empty())
            .setFullMethodName("google.pubsub.v1.Publisher/Publish")
            .setTransport(ApiTracerContext.Transport.GRPC)
            .build();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes)
        .containsEntry(
            ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE,
            "google.pubsub.v1.Publisher/Publish");
  }

  @Test
  void testGetAttemptAttributes_rpcSystemName() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.GRPC)
            .build();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "grpc");
  }

  @Test
  void testGetAttemptAttributes_empty() {
    ApiTracerContext context = ApiTracerContext.empty();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes).isEmpty();
  }

  @Test
  void testGetAttemptAttributes_emptyStrings() {
    LibraryMetadata libraryMetadata =
        LibraryMetadata.newBuilder().setRepository("").setArtifactName("").build();
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(libraryMetadata)
            .setServerAddress("")
            .build();
    Map<String, Object> attributes = context.getAttemptAttributes();

    assertThat(attributes).isEmpty();
  }

  @Test
  void testMerge() {
    LibraryMetadata metadata = LibraryMetadata.newBuilder().setRepository("repo").build();
    ApiTracerContext context1 =
        ApiTracerContext.newBuilder()
            .setServerAddress("address1")
            .setLibraryMetadata(metadata)
            .setFullMethodName("method1")
            .setTransport(ApiTracerContext.Transport.HTTP)
            .build();

    LibraryMetadata metadata2 = LibraryMetadata.newBuilder().setArtifactName("artifact").build();
    ApiTracerContext context2 =
        ApiTracerContext.newBuilder()
            .setServerAddress("address2")
            .setLibraryMetadata(metadata2)
            .setFullMethodName("method2")
            .setTransport(ApiTracerContext.Transport.GRPC)
            .build();

    ApiTracerContext merged = context1.merge(context2);

    assertThat(merged.serverAddress()).isEqualTo("address2");
    assertThat(merged.libraryMetadata().artifactName()).isEqualTo("artifact");
    // Note: LibraryMetadata.merge is not called in ApiTracerContext.merge, it replaces it if not
    // empty.
    assertThat(merged.libraryMetadata().repository()).isNull();
    assertThat(merged.fullMethodName()).isEqualTo("method2");
    assertThat(merged.transport()).isEqualTo(ApiTracerContext.Transport.GRPC);
  }

  @Test
  void testMerge_emptyOther() {
    ApiTracerContext context1 =
        ApiTracerContext.newBuilder()
            .setServerAddress("address1")
            .setLibraryMetadata(LibraryMetadata.newBuilder().setRepository("repo").build())
            .setFullMethodName("method1")
            .setTransport(ApiTracerContext.Transport.HTTP)
            .build();

    ApiTracerContext merged = context1.merge(ApiTracerContext.empty());

    assertThat(merged).isEqualTo(context1);
  }
}
