/*
 * Copyright 2023 Google LLC
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
package com.google.api.gax.httpjson.longrunning.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.HttpRule;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.CancelOperationRequest;
import com.google.longrunning.DeleteOperationRequest;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.ListOperationsRequest;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class HttpJsonOperationsStubTest {

  @Test
  void testMethodDescriptorsURI() throws IOException {
    String operationListURI = "testList";
    String operationGetURI = "testGet";
    String operationDeleteURI = "testDelete";
    String operationCancelURI = "testCancel";
    HttpJsonOperationsStub httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            ClientContext.newBuilder()
                .setCredentials(NoCredentialsProvider.create().getCredentials())
                .setDefaultCallContext(FakeCallContext.createDefault())
                .build(),
            new HttpJsonOperationsCallableFactory(),
            TypeRegistry.newBuilder().build(),
            ImmutableMap.of(
                "google.longrunning.Operations.ListOperations",
                HttpRule.newBuilder().setGet(operationListURI).build(),
                "google.longrunning.Operations.GetOperation",
                HttpRule.newBuilder().setGet(operationGetURI).build(),
                "google.longrunning.Operations.DeleteOperation",
                HttpRule.newBuilder().setDelete(operationDeleteURI).build(),
                "google.longrunning.Operations.CancelOperation",
                HttpRule.newBuilder().setPost(operationCancelURI).build()));
    // The order is: List, Get, Delete, Cancel
    List<ApiMethodDescriptor> apiMethodDescriptorList =
        httpJsonOperationsStub.getAllMethodDescriptors();
    assertThat(apiMethodDescriptorList.get(0).getRequestFormatter().getPathTemplate().toRawString())
        .isEqualTo(operationListURI);
    assertThat(apiMethodDescriptorList.get(1).getRequestFormatter().getPathTemplate().toRawString())
        .isEqualTo(operationGetURI);
    assertThat(apiMethodDescriptorList.get(2).getRequestFormatter().getPathTemplate().toRawString())
        .isEqualTo(operationDeleteURI);
    assertThat(apiMethodDescriptorList.get(3).getRequestFormatter().getPathTemplate().toRawString())
        .isEqualTo(operationCancelURI);
  }

  @Test
  void testMethodDescriptorsAdditionalBindings() throws IOException {
    // We set a random URI in this OperationsStub, otherwise PathTemplate won't compile
    String operationListAdditionalBindingURI = "testList2";
    String operationGetAdditionalBindingURI = "testGet2";
    String operationDeleteAdditionalBindingURI = "testDelete2";
    String operationCancelAdditionalBindingURI = "testCancel2";
    HttpJsonOperationsStub httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            ClientContext.newBuilder()
                .setCredentials(NoCredentialsProvider.create().getCredentials())
                .setDefaultCallContext(FakeCallContext.createDefault())
                .build(),
            new HttpJsonOperationsCallableFactory(),
            TypeRegistry.newBuilder().build(),
            ImmutableMap.of(
                "google.longrunning.Operations.ListOperations",
                HttpRule.newBuilder()
                    .setGet("test")
                    .addAdditionalBindings(
                        HttpRule.newBuilder().setGet(operationListAdditionalBindingURI))
                    .build(),
                "google.longrunning.Operations.GetOperation",
                HttpRule.newBuilder()
                    .setGet("test")
                    .addAdditionalBindings(
                        HttpRule.newBuilder().setGet(operationGetAdditionalBindingURI))
                    .build(),
                "google.longrunning.Operations.DeleteOperation",
                HttpRule.newBuilder()
                    .setDelete("test")
                    .addAdditionalBindings(
                        HttpRule.newBuilder().setDelete(operationDeleteAdditionalBindingURI))
                    .build(),
                "google.longrunning.Operations.CancelOperation",
                HttpRule.newBuilder()
                    .setPost("test")
                    .addAdditionalBindings(
                        HttpRule.newBuilder().setPost(operationCancelAdditionalBindingURI))
                    .build()));
    // The order is: List, Get, Delete, Cancel
    List<ApiMethodDescriptor> apiMethodDescriptorList =
        httpJsonOperationsStub.getAllMethodDescriptors();
    ProtoMessageRequestFormatter<ListOperationsRequest>
        listOperationsRequestProtoMessageRequestFormatter =
            (ProtoMessageRequestFormatter<ListOperationsRequest>)
                apiMethodDescriptorList.get(0).getRequestFormatter();
    assertThat(listOperationsRequestProtoMessageRequestFormatter.getAdditionalPathTemplates())
        .hasSize(1);
    assertThat(
            listOperationsRequestProtoMessageRequestFormatter
                .getAdditionalPathTemplates()
                .get(0)
                .toRawString())
        .isEqualTo(operationListAdditionalBindingURI);
    ProtoMessageRequestFormatter<GetOperationRequest>
        getOperationRequestProtoMessageRequestFormatter =
            (ProtoMessageRequestFormatter<GetOperationRequest>)
                apiMethodDescriptorList.get(1).getRequestFormatter();
    assertThat(getOperationRequestProtoMessageRequestFormatter.getAdditionalPathTemplates())
        .hasSize(1);
    assertThat(
            getOperationRequestProtoMessageRequestFormatter
                .getAdditionalPathTemplates()
                .get(0)
                .toRawString())
        .isEqualTo(operationGetAdditionalBindingURI);
    ProtoMessageRequestFormatter<DeleteOperationRequest>
        deleteOperationRequestProtoMessageRequestFormatter =
            (ProtoMessageRequestFormatter<DeleteOperationRequest>)
                apiMethodDescriptorList.get(2).getRequestFormatter();
    assertThat(deleteOperationRequestProtoMessageRequestFormatter.getAdditionalPathTemplates())
        .hasSize(1);
    assertThat(
            deleteOperationRequestProtoMessageRequestFormatter
                .getAdditionalPathTemplates()
                .get(0)
                .toRawString())
        .isEqualTo(operationDeleteAdditionalBindingURI);
    ProtoMessageRequestFormatter<CancelOperationRequest>
        cancelOperationRequestProtoMessageRequestFormatter =
            (ProtoMessageRequestFormatter<CancelOperationRequest>)
                apiMethodDescriptorList.get(3).getRequestFormatter();
    assertThat(cancelOperationRequestProtoMessageRequestFormatter.getAdditionalPathTemplates())
        .hasSize(1);
    assertThat(
            cancelOperationRequestProtoMessageRequestFormatter
                .getAdditionalPathTemplates()
                .get(0)
                .toRawString())
        .isEqualTo(operationCancelAdditionalBindingURI);
  }
}
