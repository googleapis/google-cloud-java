// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

'use strict';

const assert = require('assert');
const redirectUrl = require('../src/redirects.js').redirectUrl;

describe('redirectUrl', () => {

  it('should handle framed root link', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html';
    const expected = 'https://googleapis.dev/java/google-cloud-clients/latest/index.html';
    assert.equal(redirectUrl(url), expected);
  });

  it('should handle framed root link with no index.html', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/';
    const expected = 'https://googleapis.dev/java/google-cloud-clients/latest/';
    assert.equal(redirectUrl(url), expected);
  });

  it('should handle framed cloud package summary link', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/datalabeling/v1beta1/package-summary.html';
    const expected = 'https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/datalabeling/v1beta1/package-summary.html';
    assert.equal(redirectUrl(url), expected);
  });

  it('should handle framed cloud class link', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/bigquery/Acl.Role.html';
    const expected = 'https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/bigquery/Acl.Role.html';
    assert.equal(redirectUrl(url), expected);
  });

  it('should handle framed proto package summary link', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-api-grpc/apidocs/index.html?com/google/cloud/dataproc/v1beta2/package-summary.html';
    const expected = 'https://googleapis.dev/java/google-api-grpc/latest/index.html?com/google/cloud/dataproc/v1beta2/package-summary.html';
    assert.equal(redirectUrl(url), expected);
  });

  it('should handle framed proto class link', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-api-grpc/apidocs/index.html?com/google/cloud/dialogflow/v2beta1/BatchUpdateEntityTypesRequest.html';
    const expected = 'https://googleapis.dev/java/google-api-grpc/latest/index.html?com/google/cloud/dialogflow/v2beta1/BatchUpdateEntityTypesRequest.html';
    assert.equal(redirectUrl(url), expected);
  });

  it('should handle framed grpc class link', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-api-grpc/apidocs/index.html?com/google/cloud/dataproc/v1beta2/WorkflowTemplateServiceGrpc.WorkflowTemplateServiceBlockingStub.html'
    const expected = 'https://googleapis.dev/java/google-api-grpc/latest/index.html?com/google/cloud/dataproc/v1beta2/WorkflowTemplateServiceGrpc.WorkflowTemplateServiceBlockingStub.html';
    assert.equal(redirectUrl(url), expected);
  });

  it('should handle anchor to method', () => {
    const url = 'https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/com/google/cloud/bigtable/data/v2/BigtableDataClient.html#bulkMutateRows-com.google.cloud.bigtable.data.v2.models.BulkMutation-';
    const expected = 'https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/data/v2/BigtableDataClient.html#bulkMutateRows-com.google.cloud.bigtable.data.v2.models.BulkMutation-';
    assert.equal(redirectUrl(url), expected);
  });
});