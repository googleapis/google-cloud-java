/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.kms.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.kms.v1.stub.KeyManagementServiceStub;
import com.google.cloud.kms.v1.stub.KeyManagementServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Cloud Key Management Service
 *
 * <p>Manages cryptographic keys and operations using those keys. Implements a REST model with the
 * following objects:
 *
 * <ul>
 *   <li>[KeyRing][google.cloud.kms.v1.KeyRing]
 *   <li>[CryptoKey][google.cloud.kms.v1.CryptoKey]
 *   <li>[CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
 *   <li>[ImportJob][google.cloud.kms.v1.ImportJob]
 * </ul>
 *
 * <p>If you are using manual gRPC libraries, see [Using gRPC with Cloud
 * KMS](https://cloud.google.com/kms/docs/grpc).
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (KeyManagementServiceClient keyManagementServiceClient =
 *     KeyManagementServiceClient.create()) {
 *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
 *   KeyRing response = keyManagementServiceClient.getKeyRing(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the KeyManagementServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ListKeyRings</td>
 *      <td><p> Lists [KeyRings][google.cloud.kms.v1.KeyRing].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listKeyRings(ListKeyRingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listKeyRings(LocationName parent)
 *           <li>listKeyRings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listKeyRingsPagedCallable()
 *           <li>listKeyRingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListCryptoKeys</td>
 *      <td><p> Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listCryptoKeys(ListCryptoKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listCryptoKeys(KeyRingName parent)
 *           <li>listCryptoKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listCryptoKeysPagedCallable()
 *           <li>listCryptoKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListCryptoKeyVersions</td>
 *      <td><p> Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listCryptoKeyVersions(ListCryptoKeyVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listCryptoKeyVersions(CryptoKeyName parent)
 *           <li>listCryptoKeyVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listCryptoKeyVersionsPagedCallable()
 *           <li>listCryptoKeyVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListImportJobs</td>
 *      <td><p> Lists [ImportJobs][google.cloud.kms.v1.ImportJob].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listImportJobs(ListImportJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listImportJobs(KeyRingName parent)
 *           <li>listImportJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listImportJobsPagedCallable()
 *           <li>listImportJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetKeyRing</td>
 *      <td><p> Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getKeyRing(GetKeyRingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getKeyRing(KeyRingName name)
 *           <li>getKeyRing(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getKeyRingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetCryptoKey</td>
 *      <td><p> Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its [primary][google.cloud.kms.v1.CryptoKey.primary] [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getCryptoKey(GetCryptoKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getCryptoKey(CryptoKeyName name)
 *           <li>getCryptoKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getCryptoKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetCryptoKeyVersion</td>
 *      <td><p> Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getCryptoKeyVersion(GetCryptoKeyVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getCryptoKeyVersion(CryptoKeyVersionName name)
 *           <li>getCryptoKeyVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getCryptoKeyVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetPublicKey</td>
 *      <td><p> Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getPublicKey(GetPublicKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getPublicKey(CryptoKeyVersionName name)
 *           <li>getPublicKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getPublicKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetImportJob</td>
 *      <td><p> Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getImportJob(GetImportJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getImportJob(ImportJobName name)
 *           <li>getImportJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateKeyRing</td>
 *      <td><p> Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createKeyRing(CreateKeyRingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createKeyRing(LocationName parent, String keyRingId, KeyRing keyRing)
 *           <li>createKeyRing(String parent, String keyRingId, KeyRing keyRing)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createKeyRingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateCryptoKey</td>
 *      <td><p> Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a [KeyRing][google.cloud.kms.v1.KeyRing].
 * <p>  [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm] are required.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createCryptoKey(CreateCryptoKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createCryptoKey(KeyRingName parent, String cryptoKeyId, CryptoKey cryptoKey)
 *           <li>createCryptoKey(String parent, String cryptoKeyId, CryptoKey cryptoKey)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createCryptoKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateCryptoKeyVersion</td>
 *      <td><p> Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a [CryptoKey][google.cloud.kms.v1.CryptoKey].
 * <p>  The server will assign the next sequential id. If unset, [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createCryptoKeyVersion(CreateCryptoKeyVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createCryptoKeyVersion(CryptoKeyName parent, CryptoKeyVersion cryptoKeyVersion)
 *           <li>createCryptoKeyVersion(String parent, CryptoKeyVersion cryptoKeyVersion)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createCryptoKeyVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ImportCryptoKeyVersion</td>
 *      <td><p> Import wrapped key material into a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
 * <p>  All requests must specify a [CryptoKey][google.cloud.kms.v1.CryptoKey]. If a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] is additionally specified in the request, key material will be reimported into that version. Otherwise, a new version will be created, and will be assigned the next sequential id within the [CryptoKey][google.cloud.kms.v1.CryptoKey].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>importCryptoKeyVersion(ImportCryptoKeyVersionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>importCryptoKeyVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateImportJob</td>
 *      <td><p> Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a [KeyRing][google.cloud.kms.v1.KeyRing].
 * <p>  [ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is required.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createImportJob(CreateImportJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createImportJob(KeyRingName parent, String importJobId, ImportJob importJob)
 *           <li>createImportJob(String parent, String importJobId, ImportJob importJob)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateCryptoKey</td>
 *      <td><p> Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateCryptoKey(UpdateCryptoKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateCryptoKey(CryptoKey cryptoKey, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateCryptoKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateCryptoKeyVersion</td>
 *      <td><p> Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s metadata.
 * <p>  [state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED] and [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED] using this method. See [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion] and [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] to move between other states.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateCryptoKeyVersion(UpdateCryptoKeyVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateCryptoKeyVersion(CryptoKeyVersion cryptoKeyVersion, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateCryptoKeyVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateCryptoKeyPrimaryVersion</td>
 *      <td><p> Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
 * <p>  Returns an error if called on a key whose purpose is not [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateCryptoKeyPrimaryVersion(UpdateCryptoKeyPrimaryVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateCryptoKeyPrimaryVersion(CryptoKeyName name, String cryptoKeyVersionId)
 *           <li>updateCryptoKeyPrimaryVersion(String name, String cryptoKeyVersionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateCryptoKeyPrimaryVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DestroyCryptoKeyVersion</td>
 *      <td><p> Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
 * <p>  Upon calling this method, [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED], and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to the time [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration] in the future. At that time, the [state][google.cloud.kms.v1.CryptoKeyVersion.state] will automatically change to [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key material will be irrevocably destroyed.
 * <p>  Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached, [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may be called to reverse the process.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>destroyCryptoKeyVersion(DestroyCryptoKeyVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>destroyCryptoKeyVersion(CryptoKeyVersionName name)
 *           <li>destroyCryptoKeyVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>destroyCryptoKeyVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>RestoreCryptoKeyVersion</td>
 *      <td><p> Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED] state.
 * <p>  Upon restoration of the CryptoKeyVersion, [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>restoreCryptoKeyVersion(RestoreCryptoKeyVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>restoreCryptoKeyVersion(CryptoKeyVersionName name)
 *           <li>restoreCryptoKeyVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>restoreCryptoKeyVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>Encrypt</td>
 *      <td><p> Encrypts data, so that it can only be recovered by a call to [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>encrypt(EncryptRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>encrypt(ResourceName name, ByteString plaintext)
 *           <li>encrypt(String name, ByteString plaintext)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>encryptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>Decrypt</td>
 *      <td><p> Decrypts data that was protected by [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>decrypt(DecryptRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>decrypt(CryptoKeyName name, ByteString ciphertext)
 *           <li>decrypt(String name, ByteString ciphertext)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>decryptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>RawEncrypt</td>
 *      <td><p> Encrypts data using portable cryptographic primitives. Most users should choose [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt] and [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt] rather than their raw counterparts. The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be [RAW_ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.RAW_ENCRYPT_DECRYPT].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>rawEncrypt(RawEncryptRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>rawEncryptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>RawDecrypt</td>
 *      <td><p> Decrypts data that was originally encrypted using a raw cryptographic mechanism. The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be [RAW_ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.RAW_ENCRYPT_DECRYPT].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>rawDecrypt(RawDecryptRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>rawDecryptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>AsymmetricSign</td>
 *      <td><p> Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a signature that can be verified with the public key retrieved from [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>asymmetricSign(AsymmetricSignRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>asymmetricSign(CryptoKeyVersionName name, Digest digest)
 *           <li>asymmetricSign(String name, Digest digest)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>asymmetricSignCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>AsymmetricDecrypt</td>
 *      <td><p> Decrypts data that was encrypted with a public key retrieved from [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>asymmetricDecrypt(AsymmetricDecryptRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>asymmetricDecrypt(CryptoKeyVersionName name, ByteString ciphertext)
 *           <li>asymmetricDecrypt(String name, ByteString ciphertext)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>asymmetricDecryptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>MacSign</td>
 *      <td><p> Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, producing a tag that can be verified by another source with the same key.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>macSign(MacSignRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>macSign(CryptoKeyVersionName name, ByteString data)
 *           <li>macSign(String name, ByteString data)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>macSignCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>MacVerify</td>
 *      <td><p> Verifies MAC tag using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns a response that indicates whether or not the verification was successful.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>macVerify(MacVerifyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>macVerify(CryptoKeyVersionName name, ByteString data, ByteString mac)
 *           <li>macVerify(String name, ByteString data, ByteString mac)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>macVerifyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GenerateRandomBytes</td>
 *      <td><p> Generate random bytes using the Cloud KMS randomness source in the provided location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>generateRandomBytes(GenerateRandomBytesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>generateRandomBytes(String location, int lengthBytes, ProtectionLevel protectionLevel)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>generateRandomBytesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of KeyManagementServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * KeyManagementServiceSettings keyManagementServiceSettings =
 *     KeyManagementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * KeyManagementServiceClient keyManagementServiceClient =
 *     KeyManagementServiceClient.create(keyManagementServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * KeyManagementServiceSettings keyManagementServiceSettings =
 *     KeyManagementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * KeyManagementServiceClient keyManagementServiceClient =
 *     KeyManagementServiceClient.create(keyManagementServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * KeyManagementServiceSettings keyManagementServiceSettings =
 *     KeyManagementServiceSettings.newHttpJsonBuilder().build();
 * KeyManagementServiceClient keyManagementServiceClient =
 *     KeyManagementServiceClient.create(keyManagementServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class KeyManagementServiceClient implements BackgroundResource {
  private final KeyManagementServiceSettings settings;
  private final KeyManagementServiceStub stub;

  /** Constructs an instance of KeyManagementServiceClient with default settings. */
  public static final KeyManagementServiceClient create() throws IOException {
    return create(KeyManagementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of KeyManagementServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final KeyManagementServiceClient create(KeyManagementServiceSettings settings)
      throws IOException {
    return new KeyManagementServiceClient(settings);
  }

  /**
   * Constructs an instance of KeyManagementServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(KeyManagementServiceSettings).
   */
  public static final KeyManagementServiceClient create(KeyManagementServiceStub stub) {
    return new KeyManagementServiceClient(stub);
  }

  /**
   * Constructs an instance of KeyManagementServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected KeyManagementServiceClient(KeyManagementServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((KeyManagementServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected KeyManagementServiceClient(KeyManagementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final KeyManagementServiceSettings getSettings() {
    return settings;
  }

  public KeyManagementServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (KeyRing element : keyManagementServiceClient.listKeyRings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeyRingsPagedResponse listKeyRings(LocationName parent) {
    ListKeyRingsRequest request =
        ListKeyRingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listKeyRings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (KeyRing element : keyManagementServiceClient.listKeyRings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeyRingsPagedResponse listKeyRings(String parent) {
    ListKeyRingsRequest request = ListKeyRingsRequest.newBuilder().setParent(parent).build();
    return listKeyRings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListKeyRingsRequest request =
   *       ListKeyRingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (KeyRing element : keyManagementServiceClient.listKeyRings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeyRingsPagedResponse listKeyRings(ListKeyRingsRequest request) {
    return listKeyRingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListKeyRingsRequest request =
   *       ListKeyRingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<KeyRing> future =
   *       keyManagementServiceClient.listKeyRingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (KeyRing element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListKeyRingsRequest, ListKeyRingsPagedResponse>
      listKeyRingsPagedCallable() {
    return stub.listKeyRingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListKeyRingsRequest request =
   *       ListKeyRingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListKeyRingsResponse response =
   *         keyManagementServiceClient.listKeyRingsCallable().call(request);
   *     for (KeyRing element : response.getKeyRingsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsCallable() {
    return stub.listKeyRingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   for (CryptoKey element : keyManagementServiceClient.listCryptoKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [KeyRing][google.cloud.kms.v1.KeyRing] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(KeyRingName parent) {
    ListCryptoKeysRequest request =
        ListCryptoKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCryptoKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString();
   *   for (CryptoKey element : keyManagementServiceClient.listCryptoKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [KeyRing][google.cloud.kms.v1.KeyRing] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(String parent) {
    ListCryptoKeysRequest request = ListCryptoKeysRequest.newBuilder().setParent(parent).build();
    return listCryptoKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListCryptoKeysRequest request =
   *       ListCryptoKeysRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CryptoKey element : keyManagementServiceClient.listCryptoKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(ListCryptoKeysRequest request) {
    return listCryptoKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListCryptoKeysRequest request =
   *       ListCryptoKeysRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CryptoKey> future =
   *       keyManagementServiceClient.listCryptoKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CryptoKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    return stub.listCryptoKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListCryptoKeysRequest request =
   *       ListCryptoKeysRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCryptoKeysResponse response =
   *         keyManagementServiceClient.listCryptoKeysCallable().call(request);
   *     for (CryptoKey element : response.getCryptoKeysList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse>
      listCryptoKeysCallable() {
    return stub.listCryptoKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   for (CryptoKeyVersion element :
   *       keyManagementServiceClient.listCryptoKeyVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;/cryptoKeys/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeyVersionsPagedResponse listCryptoKeyVersions(CryptoKeyName parent) {
    ListCryptoKeyVersionsRequest request =
        ListCryptoKeyVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCryptoKeyVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   for (CryptoKeyVersion element :
   *       keyManagementServiceClient.listCryptoKeyVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;/cryptoKeys/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeyVersionsPagedResponse listCryptoKeyVersions(String parent) {
    ListCryptoKeyVersionsRequest request =
        ListCryptoKeyVersionsRequest.newBuilder().setParent(parent).build();
    return listCryptoKeyVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListCryptoKeyVersionsRequest request =
   *       ListCryptoKeyVersionsRequest.newBuilder()
   *           .setParent(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CryptoKeyVersion element :
   *       keyManagementServiceClient.listCryptoKeyVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeyVersionsPagedResponse listCryptoKeyVersions(
      ListCryptoKeyVersionsRequest request) {
    return listCryptoKeyVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListCryptoKeyVersionsRequest request =
   *       ListCryptoKeyVersionsRequest.newBuilder()
   *           .setParent(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CryptoKeyVersion> future =
   *       keyManagementServiceClient.listCryptoKeyVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CryptoKeyVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsPagedCallable() {
    return stub.listCryptoKeyVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListCryptoKeyVersionsRequest request =
   *       ListCryptoKeyVersionsRequest.newBuilder()
   *           .setParent(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCryptoKeyVersionsResponse response =
   *         keyManagementServiceClient.listCryptoKeyVersionsCallable().call(request);
   *     for (CryptoKeyVersion element : response.getCryptoKeyVersionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsCallable() {
    return stub.listCryptoKeyVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   for (ImportJob element : keyManagementServiceClient.listImportJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [KeyRing][google.cloud.kms.v1.KeyRing] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportJobsPagedResponse listImportJobs(KeyRingName parent) {
    ListImportJobsRequest request =
        ListImportJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listImportJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString();
   *   for (ImportJob element : keyManagementServiceClient.listImportJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [KeyRing][google.cloud.kms.v1.KeyRing] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportJobsPagedResponse listImportJobs(String parent) {
    ListImportJobsRequest request = ListImportJobsRequest.newBuilder().setParent(parent).build();
    return listImportJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListImportJobsRequest request =
   *       ListImportJobsRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ImportJob element : keyManagementServiceClient.listImportJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportJobsPagedResponse listImportJobs(ListImportJobsRequest request) {
    return listImportJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListImportJobsRequest request =
   *       ListImportJobsRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ImportJob> future =
   *       keyManagementServiceClient.listImportJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ImportJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImportJobsRequest, ListImportJobsPagedResponse>
      listImportJobsPagedCallable() {
    return stub.listImportJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListImportJobsRequest request =
   *       ListImportJobsRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListImportJobsResponse response =
   *         keyManagementServiceClient.listImportJobsCallable().call(request);
   *     for (ImportJob element : response.getImportJobsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImportJobsRequest, ListImportJobsResponse>
      listImportJobsCallable() {
    return stub.listImportJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   KeyRing response = keyManagementServiceClient.getKeyRing(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.KeyRing.name] of the
   *     [KeyRing][google.cloud.kms.v1.KeyRing] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing getKeyRing(KeyRingName name) {
    GetKeyRingRequest request =
        GetKeyRingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString();
   *   KeyRing response = keyManagementServiceClient.getKeyRing(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.KeyRing.name] of the
   *     [KeyRing][google.cloud.kms.v1.KeyRing] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing getKeyRing(String name) {
    GetKeyRingRequest request = GetKeyRingRequest.newBuilder().setName(name).build();
    return getKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetKeyRingRequest request =
   *       GetKeyRingRequest.newBuilder()
   *           .setName(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .build();
   *   KeyRing response = keyManagementServiceClient.getKeyRing(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing getKeyRing(GetKeyRingRequest request) {
    return getKeyRingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetKeyRingRequest request =
   *       GetKeyRingRequest.newBuilder()
   *           .setName(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .build();
   *   ApiFuture<KeyRing> future =
   *       keyManagementServiceClient.getKeyRingCallable().futureCall(request);
   *   // Do something.
   *   KeyRing response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetKeyRingRequest, KeyRing> getKeyRingCallable() {
    return stub.getKeyRingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyName name =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKey response = keyManagementServiceClient.getCryptoKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey getCryptoKey(CryptoKeyName name) {
    GetCryptoKeyRequest request =
        GetCryptoKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   CryptoKey response = keyManagementServiceClient.getCryptoKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey getCryptoKey(String name) {
    GetCryptoKeyRequest request = GetCryptoKeyRequest.newBuilder().setName(name).build();
    return getCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetCryptoKeyRequest request =
   *       GetCryptoKeyRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .build();
   *   CryptoKey response = keyManagementServiceClient.getCryptoKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey getCryptoKey(GetCryptoKeyRequest request) {
    return getCryptoKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetCryptoKeyRequest request =
   *       GetCryptoKeyRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CryptoKey> future =
   *       keyManagementServiceClient.getCryptoKeyCallable().futureCall(request);
   *   // Do something.
   *   CryptoKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCryptoKeyRequest, CryptoKey> getCryptoKeyCallable() {
    return stub.getCryptoKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.getCryptoKeyVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion getCryptoKeyVersion(CryptoKeyVersionName name) {
    GetCryptoKeyVersionRequest request =
        GetCryptoKeyVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   CryptoKeyVersion response = keyManagementServiceClient.getCryptoKeyVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion getCryptoKeyVersion(String name) {
    GetCryptoKeyVersionRequest request =
        GetCryptoKeyVersionRequest.newBuilder().setName(name).build();
    return getCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetCryptoKeyVersionRequest request =
   *       GetCryptoKeyVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.getCryptoKeyVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion getCryptoKeyVersion(GetCryptoKeyVersionRequest request) {
    return getCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetCryptoKeyVersionRequest request =
   *       GetCryptoKeyVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CryptoKeyVersion> future =
   *       keyManagementServiceClient.getCryptoKeyVersionCallable().futureCall(request);
   *   // Do something.
   *   CryptoKeyVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionCallable() {
    return stub.getCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   PublicKey response = keyManagementServiceClient.getPublicKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] public key to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicKey getPublicKey(CryptoKeyVersionName name) {
    GetPublicKeyRequest request =
        GetPublicKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   PublicKey response = keyManagementServiceClient.getPublicKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] public key to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicKey getPublicKey(String name) {
    GetPublicKeyRequest request = GetPublicKeyRequest.newBuilder().setName(name).build();
    return getPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetPublicKeyRequest request =
   *       GetPublicKeyRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   PublicKey response = keyManagementServiceClient.getPublicKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicKey getPublicKey(GetPublicKeyRequest request) {
    return getPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetPublicKeyRequest request =
   *       GetPublicKeyRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PublicKey> future =
   *       keyManagementServiceClient.getPublicKeyCallable().futureCall(request);
   *   // Do something.
   *   PublicKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPublicKeyRequest, PublicKey> getPublicKeyCallable() {
    return stub.getPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ImportJobName name =
   *       ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]");
   *   ImportJob response = keyManagementServiceClient.getImportJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.ImportJob.name] of the
   *     [ImportJob][google.cloud.kms.v1.ImportJob] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob getImportJob(ImportJobName name) {
    GetImportJobRequest request =
        GetImportJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]").toString();
   *   ImportJob response = keyManagementServiceClient.getImportJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.ImportJob.name] of the
   *     [ImportJob][google.cloud.kms.v1.ImportJob] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob getImportJob(String name) {
    GetImportJobRequest request = GetImportJobRequest.newBuilder().setName(name).build();
    return getImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetImportJobRequest request =
   *       GetImportJobRequest.newBuilder()
   *           .setName(
   *               ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]")
   *                   .toString())
   *           .build();
   *   ImportJob response = keyManagementServiceClient.getImportJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob getImportJob(GetImportJobRequest request) {
    return getImportJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetImportJobRequest request =
   *       GetImportJobRequest.newBuilder()
   *           .setName(
   *               ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ImportJob> future =
   *       keyManagementServiceClient.getImportJobCallable().futureCall(request);
   *   // Do something.
   *   ImportJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImportJobRequest, ImportJob> getImportJobCallable() {
    return stub.getImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String keyRingId = "keyRingId-2027180374";
   *   KeyRing keyRing = KeyRing.newBuilder().build();
   *   KeyRing response = keyManagementServiceClient.createKeyRing(parent, keyRingId, keyRing);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @param keyRingId Required. It must be unique within a location and match the regular expression
   *     `[a-zA-Z0-9_-]{1,63}`
   * @param keyRing Required. A [KeyRing][google.cloud.kms.v1.KeyRing] with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing createKeyRing(LocationName parent, String keyRingId, KeyRing keyRing) {
    CreateKeyRingRequest request =
        CreateKeyRingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKeyRingId(keyRingId)
            .setKeyRing(keyRing)
            .build();
    return createKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String keyRingId = "keyRingId-2027180374";
   *   KeyRing keyRing = KeyRing.newBuilder().build();
   *   KeyRing response = keyManagementServiceClient.createKeyRing(parent, keyRingId, keyRing);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @param keyRingId Required. It must be unique within a location and match the regular expression
   *     `[a-zA-Z0-9_-]{1,63}`
   * @param keyRing Required. A [KeyRing][google.cloud.kms.v1.KeyRing] with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing createKeyRing(String parent, String keyRingId, KeyRing keyRing) {
    CreateKeyRingRequest request =
        CreateKeyRingRequest.newBuilder()
            .setParent(parent)
            .setKeyRingId(keyRingId)
            .setKeyRing(keyRing)
            .build();
    return createKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateKeyRingRequest request =
   *       CreateKeyRingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKeyRingId("keyRingId-2027180374")
   *           .setKeyRing(KeyRing.newBuilder().build())
   *           .build();
   *   KeyRing response = keyManagementServiceClient.createKeyRing(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing createKeyRing(CreateKeyRingRequest request) {
    return createKeyRingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateKeyRingRequest request =
   *       CreateKeyRingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKeyRingId("keyRingId-2027180374")
   *           .setKeyRing(KeyRing.newBuilder().build())
   *           .build();
   *   ApiFuture<KeyRing> future =
   *       keyManagementServiceClient.createKeyRingCallable().futureCall(request);
   *   // Do something.
   *   KeyRing response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateKeyRingRequest, KeyRing> createKeyRingCallable() {
    return stub.createKeyRingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   String cryptoKeyId = "cryptoKeyId-1643185255";
   *   CryptoKey cryptoKey = CryptoKey.newBuilder().build();
   *   CryptoKey response =
   *       keyManagementServiceClient.createCryptoKey(parent, cryptoKeyId, cryptoKey);
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.KeyRing.name] of the KeyRing associated
   *     with the [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   * @param cryptoKeyId Required. It must be unique within a KeyRing and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`
   * @param cryptoKey Required. A [CryptoKey][google.cloud.kms.v1.CryptoKey] with initial field
   *     values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey createCryptoKey(
      KeyRingName parent, String cryptoKeyId, CryptoKey cryptoKey) {
    CreateCryptoKeyRequest request =
        CreateCryptoKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCryptoKeyId(cryptoKeyId)
            .setCryptoKey(cryptoKey)
            .build();
    return createCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString();
   *   String cryptoKeyId = "cryptoKeyId-1643185255";
   *   CryptoKey cryptoKey = CryptoKey.newBuilder().build();
   *   CryptoKey response =
   *       keyManagementServiceClient.createCryptoKey(parent, cryptoKeyId, cryptoKey);
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.KeyRing.name] of the KeyRing associated
   *     with the [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   * @param cryptoKeyId Required. It must be unique within a KeyRing and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`
   * @param cryptoKey Required. A [CryptoKey][google.cloud.kms.v1.CryptoKey] with initial field
   *     values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey createCryptoKey(String parent, String cryptoKeyId, CryptoKey cryptoKey) {
    CreateCryptoKeyRequest request =
        CreateCryptoKeyRequest.newBuilder()
            .setParent(parent)
            .setCryptoKeyId(cryptoKeyId)
            .setCryptoKey(cryptoKey)
            .build();
    return createCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateCryptoKeyRequest request =
   *       CreateCryptoKeyRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setCryptoKeyId("cryptoKeyId-1643185255")
   *           .setCryptoKey(CryptoKey.newBuilder().build())
   *           .setSkipInitialVersionCreation(true)
   *           .build();
   *   CryptoKey response = keyManagementServiceClient.createCryptoKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey createCryptoKey(CreateCryptoKeyRequest request) {
    return createCryptoKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateCryptoKeyRequest request =
   *       CreateCryptoKeyRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setCryptoKeyId("cryptoKeyId-1643185255")
   *           .setCryptoKey(CryptoKey.newBuilder().build())
   *           .setSkipInitialVersionCreation(true)
   *           .build();
   *   ApiFuture<CryptoKey> future =
   *       keyManagementServiceClient.createCryptoKeyCallable().futureCall(request);
   *   // Do something.
   *   CryptoKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyCallable() {
    return stub.createCryptoKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   CryptoKeyVersion response =
   *       keyManagementServiceClient.createCryptoKeyVersion(parent, cryptoKeyVersion);
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] associated with the
   *     [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   * @param cryptoKeyVersion Required. A [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   *     with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion createCryptoKeyVersion(
      CryptoKeyName parent, CryptoKeyVersion cryptoKeyVersion) {
    CreateCryptoKeyVersionRequest request =
        CreateCryptoKeyVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCryptoKeyVersion(cryptoKeyVersion)
            .build();
    return createCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   CryptoKeyVersion response =
   *       keyManagementServiceClient.createCryptoKeyVersion(parent, cryptoKeyVersion);
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] associated with the
   *     [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   * @param cryptoKeyVersion Required. A [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   *     with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion createCryptoKeyVersion(
      String parent, CryptoKeyVersion cryptoKeyVersion) {
    CreateCryptoKeyVersionRequest request =
        CreateCryptoKeyVersionRequest.newBuilder()
            .setParent(parent)
            .setCryptoKeyVersion(cryptoKeyVersion)
            .build();
    return createCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateCryptoKeyVersionRequest request =
   *       CreateCryptoKeyVersionRequest.newBuilder()
   *           .setParent(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCryptoKeyVersion(CryptoKeyVersion.newBuilder().build())
   *           .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.createCryptoKeyVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion createCryptoKeyVersion(CreateCryptoKeyVersionRequest request) {
    return createCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateCryptoKeyVersionRequest request =
   *       CreateCryptoKeyVersionRequest.newBuilder()
   *           .setParent(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCryptoKeyVersion(CryptoKeyVersion.newBuilder().build())
   *           .build();
   *   ApiFuture<CryptoKeyVersion> future =
   *       keyManagementServiceClient.createCryptoKeyVersionCallable().futureCall(request);
   *   // Do something.
   *   CryptoKeyVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionCallable() {
    return stub.createCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import wrapped key material into a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>All requests must specify a [CryptoKey][google.cloud.kms.v1.CryptoKey]. If a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] is additionally specified in the
   * request, key material will be reimported into that version. Otherwise, a new version will be
   * created, and will be assigned the next sequential id within the
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ImportCryptoKeyVersionRequest request =
   *       ImportCryptoKeyVersionRequest.newBuilder()
   *           .setParent(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCryptoKeyVersion(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setImportJob("importJob-208547368")
   *           .setWrappedKey(ByteString.EMPTY)
   *           .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.importCryptoKeyVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion importCryptoKeyVersion(ImportCryptoKeyVersionRequest request) {
    return importCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import wrapped key material into a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>All requests must specify a [CryptoKey][google.cloud.kms.v1.CryptoKey]. If a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] is additionally specified in the
   * request, key material will be reimported into that version. Otherwise, a new version will be
   * created, and will be assigned the next sequential id within the
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ImportCryptoKeyVersionRequest request =
   *       ImportCryptoKeyVersionRequest.newBuilder()
   *           .setParent(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCryptoKeyVersion(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setImportJob("importJob-208547368")
   *           .setWrappedKey(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<CryptoKeyVersion> future =
   *       keyManagementServiceClient.importCryptoKeyVersionCallable().futureCall(request);
   *   // Do something.
   *   CryptoKeyVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionCallable() {
    return stub.importCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   String importJobId = "importJobId1449444627";
   *   ImportJob importJob = ImportJob.newBuilder().build();
   *   ImportJob response =
   *       keyManagementServiceClient.createImportJob(parent, importJobId, importJob);
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.KeyRing.name] of the
   *     [KeyRing][google.cloud.kms.v1.KeyRing] associated with the
   *     [ImportJobs][google.cloud.kms.v1.ImportJob].
   * @param importJobId Required. It must be unique within a KeyRing and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`
   * @param importJob Required. An [ImportJob][google.cloud.kms.v1.ImportJob] with initial field
   *     values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob createImportJob(
      KeyRingName parent, String importJobId, ImportJob importJob) {
    CreateImportJobRequest request =
        CreateImportJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setImportJobId(importJobId)
            .setImportJob(importJob)
            .build();
    return createImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString();
   *   String importJobId = "importJobId1449444627";
   *   ImportJob importJob = ImportJob.newBuilder().build();
   *   ImportJob response =
   *       keyManagementServiceClient.createImportJob(parent, importJobId, importJob);
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.KeyRing.name] of the
   *     [KeyRing][google.cloud.kms.v1.KeyRing] associated with the
   *     [ImportJobs][google.cloud.kms.v1.ImportJob].
   * @param importJobId Required. It must be unique within a KeyRing and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`
   * @param importJob Required. An [ImportJob][google.cloud.kms.v1.ImportJob] with initial field
   *     values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob createImportJob(String parent, String importJobId, ImportJob importJob) {
    CreateImportJobRequest request =
        CreateImportJobRequest.newBuilder()
            .setParent(parent)
            .setImportJobId(importJobId)
            .setImportJob(importJob)
            .build();
    return createImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateImportJobRequest request =
   *       CreateImportJobRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setImportJobId("importJobId1449444627")
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .build();
   *   ImportJob response = keyManagementServiceClient.createImportJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob createImportJob(CreateImportJobRequest request) {
    return createImportJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is required.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CreateImportJobRequest request =
   *       CreateImportJobRequest.newBuilder()
   *           .setParent(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
   *           .setImportJobId("importJobId1449444627")
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .build();
   *   ApiFuture<ImportJob> future =
   *       keyManagementServiceClient.createImportJobCallable().futureCall(request);
   *   // Do something.
   *   ImportJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateImportJobRequest, ImportJob> createImportJobCallable() {
    return stub.createImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKey cryptoKey = CryptoKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKey(cryptoKey, updateMask);
   * }
   * }</pre>
   *
   * @param cryptoKey Required. [CryptoKey][google.cloud.kms.v1.CryptoKey] with updated values.
   * @param updateMask Required. List of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKey(CryptoKey cryptoKey, FieldMask updateMask) {
    UpdateCryptoKeyRequest request =
        UpdateCryptoKeyRequest.newBuilder()
            .setCryptoKey(cryptoKey)
            .setUpdateMask(updateMask)
            .build();
    return updateCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   UpdateCryptoKeyRequest request =
   *       UpdateCryptoKeyRequest.newBuilder()
   *           .setCryptoKey(CryptoKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKey(UpdateCryptoKeyRequest request) {
    return updateCryptoKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   UpdateCryptoKeyRequest request =
   *       UpdateCryptoKeyRequest.newBuilder()
   *           .setCryptoKey(CryptoKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CryptoKey> future =
   *       keyManagementServiceClient.updateCryptoKeyCallable().futureCall(request);
   *   // Do something.
   *   CryptoKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyCallable() {
    return stub.updateCryptoKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s metadata.
   *
   * <p>[state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED] and
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED] using this
   * method. See
   * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion] and
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] to
   * move between other states.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CryptoKeyVersion response =
   *       keyManagementServiceClient.updateCryptoKeyVersion(cryptoKeyVersion, updateMask);
   * }
   * }</pre>
   *
   * @param cryptoKeyVersion Required. [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   *     updated values.
   * @param updateMask Required. List of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion updateCryptoKeyVersion(
      CryptoKeyVersion cryptoKeyVersion, FieldMask updateMask) {
    UpdateCryptoKeyVersionRequest request =
        UpdateCryptoKeyVersionRequest.newBuilder()
            .setCryptoKeyVersion(cryptoKeyVersion)
            .setUpdateMask(updateMask)
            .build();
    return updateCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s metadata.
   *
   * <p>[state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED] and
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED] using this
   * method. See
   * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion] and
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] to
   * move between other states.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   UpdateCryptoKeyVersionRequest request =
   *       UpdateCryptoKeyVersionRequest.newBuilder()
   *           .setCryptoKeyVersion(CryptoKeyVersion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.updateCryptoKeyVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion updateCryptoKeyVersion(UpdateCryptoKeyVersionRequest request) {
    return updateCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s metadata.
   *
   * <p>[state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED] and
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED] using this
   * method. See
   * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion] and
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] to
   * move between other states.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   UpdateCryptoKeyVersionRequest request =
   *       UpdateCryptoKeyVersionRequest.newBuilder()
   *           .setCryptoKeyVersion(CryptoKeyVersion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CryptoKeyVersion> future =
   *       keyManagementServiceClient.updateCryptoKeyVersionCallable().futureCall(request);
   *   // Do something.
   *   CryptoKeyVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionCallable() {
    return stub.updateCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on a key whose purpose is not
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyName name =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   String cryptoKeyVersionId = "cryptoKeyVersionId987674581";
   *   CryptoKey response =
   *       keyManagementServiceClient.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     update.
   * @param cryptoKeyVersionId Required. The id of the child
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use as primary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKeyPrimaryVersion(
      CryptoKeyName name, String cryptoKeyVersionId) {
    UpdateCryptoKeyPrimaryVersionRequest request =
        UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCryptoKeyVersionId(cryptoKeyVersionId)
            .build();
    return updateCryptoKeyPrimaryVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on a key whose purpose is not
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   String cryptoKeyVersionId = "cryptoKeyVersionId987674581";
   *   CryptoKey response =
   *       keyManagementServiceClient.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     update.
   * @param cryptoKeyVersionId Required. The id of the child
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use as primary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKeyPrimaryVersion(String name, String cryptoKeyVersionId) {
    UpdateCryptoKeyPrimaryVersionRequest request =
        UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
            .setName(name)
            .setCryptoKeyVersionId(cryptoKeyVersionId)
            .build();
    return updateCryptoKeyPrimaryVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on a key whose purpose is not
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   UpdateCryptoKeyPrimaryVersionRequest request =
   *       UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCryptoKeyVersionId("cryptoKeyVersionId987674581")
   *           .build();
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKeyPrimaryVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKeyPrimaryVersion(
      UpdateCryptoKeyPrimaryVersionRequest request) {
    return updateCryptoKeyPrimaryVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on a key whose purpose is not
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   UpdateCryptoKeyPrimaryVersionRequest request =
   *       UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCryptoKeyVersionId("cryptoKeyVersionId987674581")
   *           .build();
   *   ApiFuture<CryptoKey> future =
   *       keyManagementServiceClient.updateCryptoKeyPrimaryVersionCallable().futureCall(request);
   *   // Do something.
   *   CryptoKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionCallable() {
    return stub.updateCryptoKeyPrimaryVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to the time
   * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration] in the
   * future. At that time, the [state][google.cloud.kms.v1.CryptoKeyVersion.state] will
   * automatically change to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.destroyCryptoKeyVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to destroy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion destroyCryptoKeyVersion(CryptoKeyVersionName name) {
    DestroyCryptoKeyVersionRequest request =
        DestroyCryptoKeyVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return destroyCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to the time
   * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration] in the
   * future. At that time, the [state][google.cloud.kms.v1.CryptoKeyVersion.state] will
   * automatically change to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   CryptoKeyVersion response = keyManagementServiceClient.destroyCryptoKeyVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to destroy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion destroyCryptoKeyVersion(String name) {
    DestroyCryptoKeyVersionRequest request =
        DestroyCryptoKeyVersionRequest.newBuilder().setName(name).build();
    return destroyCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to the time
   * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration] in the
   * future. At that time, the [state][google.cloud.kms.v1.CryptoKeyVersion.state] will
   * automatically change to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   DestroyCryptoKeyVersionRequest request =
   *       DestroyCryptoKeyVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.destroyCryptoKeyVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion destroyCryptoKeyVersion(DestroyCryptoKeyVersionRequest request) {
    return destroyCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to the time
   * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration] in the
   * future. At that time, the [state][google.cloud.kms.v1.CryptoKeyVersion.state] will
   * automatically change to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   DestroyCryptoKeyVersionRequest request =
   *       DestroyCryptoKeyVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CryptoKeyVersion> future =
   *       keyManagementServiceClient.destroyCryptoKeyVersionCallable().futureCall(request);
   *   // Do something.
   *   CryptoKeyVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionCallable() {
    return stub.destroyCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.restoreCryptoKeyVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion restoreCryptoKeyVersion(CryptoKeyVersionName name) {
    RestoreCryptoKeyVersionRequest request =
        RestoreCryptoKeyVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return restoreCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   CryptoKeyVersion response = keyManagementServiceClient.restoreCryptoKeyVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion restoreCryptoKeyVersion(String name) {
    RestoreCryptoKeyVersionRequest request =
        RestoreCryptoKeyVersionRequest.newBuilder().setName(name).build();
    return restoreCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   RestoreCryptoKeyVersionRequest request =
   *       RestoreCryptoKeyVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.restoreCryptoKeyVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion restoreCryptoKeyVersion(RestoreCryptoKeyVersionRequest request) {
    return restoreCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   RestoreCryptoKeyVersionRequest request =
   *       RestoreCryptoKeyVersionRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CryptoKeyVersion> future =
   *       keyManagementServiceClient.restoreCryptoKeyVersionCallable().futureCall(request);
   *   // Do something.
   *   CryptoKeyVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionCallable() {
    return stub.restoreCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ResourceName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString plaintext = ByteString.EMPTY;
   *   EncryptResponse response = keyManagementServiceClient.encrypt(name, plaintext);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] or
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for encryption.
   *     <p>If a [CryptoKey][google.cloud.kms.v1.CryptoKey] is specified, the server will use its
   *     [primary version][google.cloud.kms.v1.CryptoKey.primary].
   * @param plaintext Required. The data to encrypt. Must be no larger than 64KiB.
   *     <p>The maximum size depends on the key version's
   *     [protection_level][google.cloud.kms.v1.CryptoKeyVersionTemplate.protection_level]. For
   *     [SOFTWARE][google.cloud.kms.v1.ProtectionLevel.SOFTWARE],
   *     [EXTERNAL][google.cloud.kms.v1.ProtectionLevel.EXTERNAL], and
   *     [EXTERNAL_VPC][google.cloud.kms.v1.ProtectionLevel.EXTERNAL_VPC] keys, the plaintext must
   *     be no larger than 64KiB. For [HSM][google.cloud.kms.v1.ProtectionLevel.HSM] keys, the
   *     combined length of the plaintext and additional_authenticated_data fields must be no larger
   *     than 8KiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(ResourceName name, ByteString plaintext) {
    EncryptRequest request =
        EncryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPlaintext(plaintext)
            .build();
    return encrypt(request);
  }

  // ADDED BY SYNTH
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyPathName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString plaintext = ByteString.copyFromUtf8("");
   *   EncryptResponse response = keyManagementServiceClient.encrypt(name, plaintext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] or
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for encryption.
   *     <p>If a [CryptoKey][google.cloud.kms.v1.CryptoKey] is specified, the server will use its
   *     [primary version][google.cloud.kms.v1.CryptoKey.primary].
   * @param plaintext Required. The data to encrypt. Must be no larger than 64KiB.
   *     <p>The maximum size depends on the key version's
   *     [protection_level][google.cloud.kms.v1.CryptoKeyVersionTemplate.protection_level]. For
   *     [SOFTWARE][google.cloud.kms.v1.ProtectionLevel.SOFTWARE] keys, the plaintext must be no
   *     larger than 64KiB. For [HSM][google.cloud.kms.v1.ProtectionLevel.HSM] keys, the combined
   *     length of the plaintext and additional_authenticated_data fields must be no larger than
   *     8KiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(CryptoKeyPathName name, ByteString plaintext) {
    EncryptRequest request =
        EncryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPlaintext(plaintext)
            .build();
    return encrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   ByteString plaintext = ByteString.EMPTY;
   *   EncryptResponse response = keyManagementServiceClient.encrypt(name, plaintext);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] or
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for encryption.
   *     <p>If a [CryptoKey][google.cloud.kms.v1.CryptoKey] is specified, the server will use its
   *     [primary version][google.cloud.kms.v1.CryptoKey.primary].
   * @param plaintext Required. The data to encrypt. Must be no larger than 64KiB.
   *     <p>The maximum size depends on the key version's
   *     [protection_level][google.cloud.kms.v1.CryptoKeyVersionTemplate.protection_level]. For
   *     [SOFTWARE][google.cloud.kms.v1.ProtectionLevel.SOFTWARE],
   *     [EXTERNAL][google.cloud.kms.v1.ProtectionLevel.EXTERNAL], and
   *     [EXTERNAL_VPC][google.cloud.kms.v1.ProtectionLevel.EXTERNAL_VPC] keys, the plaintext must
   *     be no larger than 64KiB. For [HSM][google.cloud.kms.v1.ProtectionLevel.HSM] keys, the
   *     combined length of the plaintext and additional_authenticated_data fields must be no larger
   *     than 8KiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(String name, ByteString plaintext) {
    EncryptRequest request =
        EncryptRequest.newBuilder().setName(name).setPlaintext(plaintext).build();
    return encrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   EncryptRequest request =
   *       EncryptRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPlaintext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setPlaintextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   EncryptResponse response = keyManagementServiceClient.encrypt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(EncryptRequest request) {
    return encryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   EncryptRequest request =
   *       EncryptRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPlaintext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setPlaintextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<EncryptResponse> future =
   *       keyManagementServiceClient.encryptCallable().futureCall(request);
   *   // Do something.
   *   EncryptResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EncryptRequest, EncryptResponse> encryptCallable() {
    return stub.encryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyName name =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString ciphertext = ByteString.EMPTY;
   *   DecryptResponse response = keyManagementServiceClient.decrypt(name, ciphertext);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     use for decryption. The server will choose the appropriate version.
   * @param ciphertext Required. The encrypted data originally returned in
   *     [EncryptResponse.ciphertext][google.cloud.kms.v1.EncryptResponse.ciphertext].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DecryptResponse decrypt(CryptoKeyName name, ByteString ciphertext) {
    DecryptRequest request =
        DecryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCiphertext(ciphertext)
            .build();
    return decrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   ByteString ciphertext = ByteString.EMPTY;
   *   DecryptResponse response = keyManagementServiceClient.decrypt(name, ciphertext);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     use for decryption. The server will choose the appropriate version.
   * @param ciphertext Required. The encrypted data originally returned in
   *     [EncryptResponse.ciphertext][google.cloud.kms.v1.EncryptResponse.ciphertext].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DecryptResponse decrypt(String name, ByteString ciphertext) {
    DecryptRequest request =
        DecryptRequest.newBuilder().setName(name).setCiphertext(ciphertext).build();
    return decrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   DecryptRequest request =
   *       DecryptRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCiphertext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setCiphertextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   DecryptResponse response = keyManagementServiceClient.decrypt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DecryptResponse decrypt(DecryptRequest request) {
    return decryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   DecryptRequest request =
   *       DecryptRequest.newBuilder()
   *           .setName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCiphertext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setCiphertextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<DecryptResponse> future =
   *       keyManagementServiceClient.decryptCallable().futureCall(request);
   *   // Do something.
   *   DecryptResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DecryptRequest, DecryptResponse> decryptCallable() {
    return stub.decryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypts data using portable cryptographic primitives. Most users should choose
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt] and
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt] rather than their raw counterparts.
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [RAW_ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.RAW_ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   RawEncryptRequest request =
   *       RawEncryptRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPlaintext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setPlaintextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .setInitializationVector(ByteString.EMPTY)
   *           .setInitializationVectorCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   RawEncryptResponse response = keyManagementServiceClient.rawEncrypt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RawEncryptResponse rawEncrypt(RawEncryptRequest request) {
    return rawEncryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypts data using portable cryptographic primitives. Most users should choose
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt] and
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt] rather than their raw counterparts.
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [RAW_ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.RAW_ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   RawEncryptRequest request =
   *       RawEncryptRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPlaintext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setPlaintextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .setInitializationVector(ByteString.EMPTY)
   *           .setInitializationVectorCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<RawEncryptResponse> future =
   *       keyManagementServiceClient.rawEncryptCallable().futureCall(request);
   *   // Do something.
   *   RawEncryptResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RawEncryptRequest, RawEncryptResponse> rawEncryptCallable() {
    return stub.rawEncryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was originally encrypted using a raw cryptographic mechanism. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [RAW_ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.RAW_ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   RawDecryptRequest request =
   *       RawDecryptRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCiphertext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setInitializationVector(ByteString.EMPTY)
   *           .setTagLength(172791595)
   *           .setCiphertextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .setInitializationVectorCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   RawDecryptResponse response = keyManagementServiceClient.rawDecrypt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RawDecryptResponse rawDecrypt(RawDecryptRequest request) {
    return rawDecryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was originally encrypted using a raw cryptographic mechanism. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [RAW_ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.RAW_ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   RawDecryptRequest request =
   *       RawDecryptRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCiphertext(ByteString.EMPTY)
   *           .setAdditionalAuthenticatedData(ByteString.EMPTY)
   *           .setInitializationVector(ByteString.EMPTY)
   *           .setTagLength(172791595)
   *           .setCiphertextCrc32C(Int64Value.newBuilder().build())
   *           .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
   *           .setInitializationVectorCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<RawDecryptResponse> future =
   *       keyManagementServiceClient.rawDecryptCallable().futureCall(request);
   *   // Do something.
   *   RawDecryptResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RawDecryptRequest, RawDecryptResponse> rawDecryptCallable() {
    return stub.rawDecryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   Digest digest = Digest.newBuilder().build();
   *   AsymmetricSignResponse response = keyManagementServiceClient.asymmetricSign(name, digest);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for signing.
   * @param digest Optional. The digest of the data to sign. The digest must be produced with the
   *     same digest algorithm as specified by the key version's
   *     [algorithm][google.cloud.kms.v1.CryptoKeyVersion.algorithm].
   *     <p>This field may not be supplied if
   *     [AsymmetricSignRequest.data][google.cloud.kms.v1.AsymmetricSignRequest.data] is supplied.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricSignResponse asymmetricSign(CryptoKeyVersionName name, Digest digest) {
    AsymmetricSignRequest request =
        AsymmetricSignRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDigest(digest)
            .build();
    return asymmetricSign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   Digest digest = Digest.newBuilder().build();
   *   AsymmetricSignResponse response = keyManagementServiceClient.asymmetricSign(name, digest);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for signing.
   * @param digest Optional. The digest of the data to sign. The digest must be produced with the
   *     same digest algorithm as specified by the key version's
   *     [algorithm][google.cloud.kms.v1.CryptoKeyVersion.algorithm].
   *     <p>This field may not be supplied if
   *     [AsymmetricSignRequest.data][google.cloud.kms.v1.AsymmetricSignRequest.data] is supplied.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricSignResponse asymmetricSign(String name, Digest digest) {
    AsymmetricSignRequest request =
        AsymmetricSignRequest.newBuilder().setName(name).setDigest(digest).build();
    return asymmetricSign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   AsymmetricSignRequest request =
   *       AsymmetricSignRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setDigest(Digest.newBuilder().build())
   *           .setDigestCrc32C(Int64Value.newBuilder().build())
   *           .setData(ByteString.EMPTY)
   *           .setDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   AsymmetricSignResponse response = keyManagementServiceClient.asymmetricSign(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricSignResponse asymmetricSign(AsymmetricSignRequest request) {
    return asymmetricSignCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   AsymmetricSignRequest request =
   *       AsymmetricSignRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setDigest(Digest.newBuilder().build())
   *           .setDigestCrc32C(Int64Value.newBuilder().build())
   *           .setData(ByteString.EMPTY)
   *           .setDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<AsymmetricSignResponse> future =
   *       keyManagementServiceClient.asymmetricSignCallable().futureCall(request);
   *   // Do something.
   *   AsymmetricSignResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AsymmetricSignRequest, AsymmetricSignResponse>
      asymmetricSignCallable() {
    return stub.asymmetricSignCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   ByteString ciphertext = ByteString.EMPTY;
   *   AsymmetricDecryptResponse response =
   *       keyManagementServiceClient.asymmetricDecrypt(name, ciphertext);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for decryption.
   * @param ciphertext Required. The data encrypted with the named
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s public key using OAEP.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricDecryptResponse asymmetricDecrypt(
      CryptoKeyVersionName name, ByteString ciphertext) {
    AsymmetricDecryptRequest request =
        AsymmetricDecryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCiphertext(ciphertext)
            .build();
    return asymmetricDecrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   ByteString ciphertext = ByteString.EMPTY;
   *   AsymmetricDecryptResponse response =
   *       keyManagementServiceClient.asymmetricDecrypt(name, ciphertext);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for decryption.
   * @param ciphertext Required. The data encrypted with the named
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s public key using OAEP.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricDecryptResponse asymmetricDecrypt(String name, ByteString ciphertext) {
    AsymmetricDecryptRequest request =
        AsymmetricDecryptRequest.newBuilder().setName(name).setCiphertext(ciphertext).build();
    return asymmetricDecrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   AsymmetricDecryptRequest request =
   *       AsymmetricDecryptRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setCiphertext(ByteString.EMPTY)
   *           .setCiphertextCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   AsymmetricDecryptResponse response = keyManagementServiceClient.asymmetricDecrypt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricDecryptResponse asymmetricDecrypt(AsymmetricDecryptRequest request) {
    return asymmetricDecryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   AsymmetricDecryptRequest request =
   *       AsymmetricDecryptRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setCiphertext(ByteString.EMPTY)
   *           .setCiphertextCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<AsymmetricDecryptResponse> future =
   *       keyManagementServiceClient.asymmetricDecryptCallable().futureCall(request);
   *   // Do something.
   *   AsymmetricDecryptResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptCallable() {
    return stub.asymmetricDecryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, producing a tag that can be
   * verified by another source with the same key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   ByteString data = ByteString.EMPTY;
   *   MacSignResponse response = keyManagementServiceClient.macSign(name, data);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for signing.
   * @param data Required. The data to sign. The MAC tag is computed over this data field based on
   *     the specific algorithm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MacSignResponse macSign(CryptoKeyVersionName name, ByteString data) {
    MacSignRequest request =
        MacSignRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setData(data)
            .build();
    return macSign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, producing a tag that can be
   * verified by another source with the same key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   ByteString data = ByteString.EMPTY;
   *   MacSignResponse response = keyManagementServiceClient.macSign(name, data);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for signing.
   * @param data Required. The data to sign. The MAC tag is computed over this data field based on
   *     the specific algorithm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MacSignResponse macSign(String name, ByteString data) {
    MacSignRequest request = MacSignRequest.newBuilder().setName(name).setData(data).build();
    return macSign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, producing a tag that can be
   * verified by another source with the same key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   MacSignRequest request =
   *       MacSignRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setData(ByteString.EMPTY)
   *           .setDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   MacSignResponse response = keyManagementServiceClient.macSign(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MacSignResponse macSign(MacSignRequest request) {
    return macSignCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, producing a tag that can be
   * verified by another source with the same key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   MacSignRequest request =
   *       MacSignRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setData(ByteString.EMPTY)
   *           .setDataCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<MacSignResponse> future =
   *       keyManagementServiceClient.macSignCallable().futureCall(request);
   *   // Do something.
   *   MacSignResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MacSignRequest, MacSignResponse> macSignCallable() {
    return stub.macSignCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies MAC tag using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns a response that
   * indicates whether or not the verification was successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name =
   *       CryptoKeyVersionName.of(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   ByteString data = ByteString.EMPTY;
   *   ByteString mac = ByteString.EMPTY;
   *   MacVerifyResponse response = keyManagementServiceClient.macVerify(name, data, mac);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for verification.
   * @param data Required. The data used previously as a
   *     [MacSignRequest.data][google.cloud.kms.v1.MacSignRequest.data] to generate the MAC tag.
   * @param mac Required. The signature to verify.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MacVerifyResponse macVerify(
      CryptoKeyVersionName name, ByteString data, ByteString mac) {
    MacVerifyRequest request =
        MacVerifyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setData(data)
            .setMac(mac)
            .build();
    return macVerify(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies MAC tag using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns a response that
   * indicates whether or not the verification was successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String name =
   *       CryptoKeyVersionName.of(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]")
   *           .toString();
   *   ByteString data = ByteString.EMPTY;
   *   ByteString mac = ByteString.EMPTY;
   *   MacVerifyResponse response = keyManagementServiceClient.macVerify(name, data, mac);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for verification.
   * @param data Required. The data used previously as a
   *     [MacSignRequest.data][google.cloud.kms.v1.MacSignRequest.data] to generate the MAC tag.
   * @param mac Required. The signature to verify.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MacVerifyResponse macVerify(String name, ByteString data, ByteString mac) {
    MacVerifyRequest request =
        MacVerifyRequest.newBuilder().setName(name).setData(data).setMac(mac).build();
    return macVerify(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies MAC tag using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns a response that
   * indicates whether or not the verification was successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   MacVerifyRequest request =
   *       MacVerifyRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setData(ByteString.EMPTY)
   *           .setDataCrc32C(Int64Value.newBuilder().build())
   *           .setMac(ByteString.EMPTY)
   *           .setMacCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   MacVerifyResponse response = keyManagementServiceClient.macVerify(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MacVerifyResponse macVerify(MacVerifyRequest request) {
    return macVerifyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies MAC tag using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns a response that
   * indicates whether or not the verification was successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   MacVerifyRequest request =
   *       MacVerifyRequest.newBuilder()
   *           .setName(
   *               CryptoKeyVersionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[KEY_RING]",
   *                       "[CRYPTO_KEY]",
   *                       "[CRYPTO_KEY_VERSION]")
   *                   .toString())
   *           .setData(ByteString.EMPTY)
   *           .setDataCrc32C(Int64Value.newBuilder().build())
   *           .setMac(ByteString.EMPTY)
   *           .setMacCrc32C(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<MacVerifyResponse> future =
   *       keyManagementServiceClient.macVerifyCallable().futureCall(request);
   *   // Do something.
   *   MacVerifyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MacVerifyRequest, MacVerifyResponse> macVerifyCallable() {
    return stub.macVerifyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate random bytes using the Cloud KMS randomness source in the provided location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   String location = "location1901043637";
   *   int lengthBytes = -745661998;
   *   ProtectionLevel protectionLevel = ProtectionLevel.forNumber(0);
   *   GenerateRandomBytesResponse response =
   *       keyManagementServiceClient.generateRandomBytes(location, lengthBytes, protectionLevel);
   * }
   * }</pre>
   *
   * @param location The project-specific location in which to generate random bytes. For example,
   *     "projects/my-project/locations/us-central1".
   * @param lengthBytes The length in bytes of the amount of randomness to retrieve. Minimum 8
   *     bytes, maximum 1024 bytes.
   * @param protectionLevel The [ProtectionLevel][google.cloud.kms.v1.ProtectionLevel] to use when
   *     generating the random data. Currently, only [HSM][google.cloud.kms.v1.ProtectionLevel.HSM]
   *     protection level is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateRandomBytesResponse generateRandomBytes(
      String location, int lengthBytes, ProtectionLevel protectionLevel) {
    GenerateRandomBytesRequest request =
        GenerateRandomBytesRequest.newBuilder()
            .setLocation(location)
            .setLengthBytes(lengthBytes)
            .setProtectionLevel(protectionLevel)
            .build();
    return generateRandomBytes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate random bytes using the Cloud KMS randomness source in the provided location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GenerateRandomBytesRequest request =
   *       GenerateRandomBytesRequest.newBuilder()
   *           .setLocation("location1901043637")
   *           .setLengthBytes(-745661998)
   *           .setProtectionLevel(ProtectionLevel.forNumber(0))
   *           .build();
   *   GenerateRandomBytesResponse response =
   *       keyManagementServiceClient.generateRandomBytes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateRandomBytesResponse generateRandomBytes(GenerateRandomBytesRequest request) {
    return generateRandomBytesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate random bytes using the Cloud KMS randomness source in the provided location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GenerateRandomBytesRequest request =
   *       GenerateRandomBytesRequest.newBuilder()
   *           .setLocation("location1901043637")
   *           .setLengthBytes(-745661998)
   *           .setProtectionLevel(ProtectionLevel.forNumber(0))
   *           .build();
   *   ApiFuture<GenerateRandomBytesResponse> future =
   *       keyManagementServiceClient.generateRandomBytesCallable().futureCall(request);
   *   // Do something.
   *   GenerateRandomBytesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesCallable() {
    return stub.generateRandomBytesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : keyManagementServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       keyManagementServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         keyManagementServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = keyManagementServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       keyManagementServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // ADDED BY SYNTH
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(resource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(KeyName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // ADDED BY SYNTH
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(resource.toString(), policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       keyManagementServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = keyManagementServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // ADDED BY SYNTH
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy response = keyManagementServiceClient.getIamPolicy(resource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(KeyName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // ADDED BY SYNTH
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy response = keyManagementServiceClient.getIamPolicy(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       keyManagementServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // ADDED BY SYNTH
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(resource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      KeyName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // ADDED BY SYNTH
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(resource.toString(), permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyManagementServiceClient keyManagementServiceClient =
   *     KeyManagementServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       keyManagementServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListKeyRingsPagedResponse
      extends AbstractPagedListResponse<
          ListKeyRingsRequest,
          ListKeyRingsResponse,
          KeyRing,
          ListKeyRingsPage,
          ListKeyRingsFixedSizeCollection> {

    public static ApiFuture<ListKeyRingsPagedResponse> createAsync(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ApiFuture<ListKeyRingsResponse> futureResponse) {
      ApiFuture<ListKeyRingsPage> futurePage =
          ListKeyRingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListKeyRingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListKeyRingsPagedResponse(ListKeyRingsPage page) {
      super(page, ListKeyRingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListKeyRingsPage
      extends AbstractPage<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing, ListKeyRingsPage> {

    private ListKeyRingsPage(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ListKeyRingsResponse response) {
      super(context, response);
    }

    private static ListKeyRingsPage createEmptyPage() {
      return new ListKeyRingsPage(null, null);
    }

    @Override
    protected ListKeyRingsPage createPage(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ListKeyRingsResponse response) {
      return new ListKeyRingsPage(context, response);
    }

    @Override
    public ApiFuture<ListKeyRingsPage> createPageAsync(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ApiFuture<ListKeyRingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListKeyRingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListKeyRingsRequest,
          ListKeyRingsResponse,
          KeyRing,
          ListKeyRingsPage,
          ListKeyRingsFixedSizeCollection> {

    private ListKeyRingsFixedSizeCollection(List<ListKeyRingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListKeyRingsFixedSizeCollection createEmptyCollection() {
      return new ListKeyRingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListKeyRingsFixedSizeCollection createCollection(
        List<ListKeyRingsPage> pages, int collectionSize) {
      return new ListKeyRingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCryptoKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCryptoKeysRequest,
          ListCryptoKeysResponse,
          CryptoKey,
          ListCryptoKeysPage,
          ListCryptoKeysFixedSizeCollection> {

    public static ApiFuture<ListCryptoKeysPagedResponse> createAsync(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ApiFuture<ListCryptoKeysResponse> futureResponse) {
      ApiFuture<ListCryptoKeysPage> futurePage =
          ListCryptoKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCryptoKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCryptoKeysPagedResponse(ListCryptoKeysPage page) {
      super(page, ListCryptoKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCryptoKeysPage
      extends AbstractPage<
          ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey, ListCryptoKeysPage> {

    private ListCryptoKeysPage(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ListCryptoKeysResponse response) {
      super(context, response);
    }

    private static ListCryptoKeysPage createEmptyPage() {
      return new ListCryptoKeysPage(null, null);
    }

    @Override
    protected ListCryptoKeysPage createPage(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ListCryptoKeysResponse response) {
      return new ListCryptoKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCryptoKeysPage> createPageAsync(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ApiFuture<ListCryptoKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCryptoKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCryptoKeysRequest,
          ListCryptoKeysResponse,
          CryptoKey,
          ListCryptoKeysPage,
          ListCryptoKeysFixedSizeCollection> {

    private ListCryptoKeysFixedSizeCollection(List<ListCryptoKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCryptoKeysFixedSizeCollection createEmptyCollection() {
      return new ListCryptoKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCryptoKeysFixedSizeCollection createCollection(
        List<ListCryptoKeysPage> pages, int collectionSize) {
      return new ListCryptoKeysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCryptoKeyVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListCryptoKeyVersionsRequest,
          ListCryptoKeyVersionsResponse,
          CryptoKeyVersion,
          ListCryptoKeyVersionsPage,
          ListCryptoKeyVersionsFixedSizeCollection> {

    public static ApiFuture<ListCryptoKeyVersionsPagedResponse> createAsync(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ApiFuture<ListCryptoKeyVersionsResponse> futureResponse) {
      ApiFuture<ListCryptoKeyVersionsPage> futurePage =
          ListCryptoKeyVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCryptoKeyVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCryptoKeyVersionsPagedResponse(ListCryptoKeyVersionsPage page) {
      super(page, ListCryptoKeyVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCryptoKeyVersionsPage
      extends AbstractPage<
          ListCryptoKeyVersionsRequest,
          ListCryptoKeyVersionsResponse,
          CryptoKeyVersion,
          ListCryptoKeyVersionsPage> {

    private ListCryptoKeyVersionsPage(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ListCryptoKeyVersionsResponse response) {
      super(context, response);
    }

    private static ListCryptoKeyVersionsPage createEmptyPage() {
      return new ListCryptoKeyVersionsPage(null, null);
    }

    @Override
    protected ListCryptoKeyVersionsPage createPage(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ListCryptoKeyVersionsResponse response) {
      return new ListCryptoKeyVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListCryptoKeyVersionsPage> createPageAsync(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ApiFuture<ListCryptoKeyVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCryptoKeyVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCryptoKeyVersionsRequest,
          ListCryptoKeyVersionsResponse,
          CryptoKeyVersion,
          ListCryptoKeyVersionsPage,
          ListCryptoKeyVersionsFixedSizeCollection> {

    private ListCryptoKeyVersionsFixedSizeCollection(
        List<ListCryptoKeyVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCryptoKeyVersionsFixedSizeCollection createEmptyCollection() {
      return new ListCryptoKeyVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCryptoKeyVersionsFixedSizeCollection createCollection(
        List<ListCryptoKeyVersionsPage> pages, int collectionSize) {
      return new ListCryptoKeyVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListImportJobsPagedResponse
      extends AbstractPagedListResponse<
          ListImportJobsRequest,
          ListImportJobsResponse,
          ImportJob,
          ListImportJobsPage,
          ListImportJobsFixedSizeCollection> {

    public static ApiFuture<ListImportJobsPagedResponse> createAsync(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ApiFuture<ListImportJobsResponse> futureResponse) {
      ApiFuture<ListImportJobsPage> futurePage =
          ListImportJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListImportJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListImportJobsPagedResponse(ListImportJobsPage page) {
      super(page, ListImportJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListImportJobsPage
      extends AbstractPage<
          ListImportJobsRequest, ListImportJobsResponse, ImportJob, ListImportJobsPage> {

    private ListImportJobsPage(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ListImportJobsResponse response) {
      super(context, response);
    }

    private static ListImportJobsPage createEmptyPage() {
      return new ListImportJobsPage(null, null);
    }

    @Override
    protected ListImportJobsPage createPage(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ListImportJobsResponse response) {
      return new ListImportJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListImportJobsPage> createPageAsync(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ApiFuture<ListImportJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListImportJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImportJobsRequest,
          ListImportJobsResponse,
          ImportJob,
          ListImportJobsPage,
          ListImportJobsFixedSizeCollection> {

    private ListImportJobsFixedSizeCollection(List<ListImportJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListImportJobsFixedSizeCollection createEmptyCollection() {
      return new ListImportJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListImportJobsFixedSizeCollection createCollection(
        List<ListImportJobsPage> pages, int collectionSize) {
      return new ListImportJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
