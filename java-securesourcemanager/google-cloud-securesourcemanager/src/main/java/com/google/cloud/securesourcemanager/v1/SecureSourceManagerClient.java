/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.securesourcemanager.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securesourcemanager.v1.stub.SecureSourceManagerStub;
import com.google.cloud.securesourcemanager.v1.stub.SecureSourceManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Secure Source Manager API
 *
 * <p>Access Secure Source Manager instances, resources, and repositories.
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
 * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = secureSourceManagerClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecureSourceManagerClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListInstances</td>
 *      <td><p> Lists Instances in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInstances(ListInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInstances(LocationName parent)
 *           <li><p> listInstances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInstancesPagedCallable()
 *           <li><p> listInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInstance</td>
 *      <td><p> Gets details of a single instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInstance(GetInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInstance(InstanceName name)
 *           <li><p> getInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInstance</td>
 *      <td><p> Creates a new instance in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInstanceAsync(CreateInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInstanceAsync(LocationName parent, Instance instance, String instanceId)
 *           <li><p> createInstanceAsync(String parent, Instance instance, String instanceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInstanceOperationCallable()
 *           <li><p> createInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInstance</td>
 *      <td><p> Deletes a single instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInstanceAsync(DeleteInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInstanceAsync(InstanceName name)
 *           <li><p> deleteInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInstanceOperationCallable()
 *           <li><p> deleteInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRepositories</td>
 *      <td><p> Lists Repositories in a given project and location.
 * <p>  The instance field is required in the query parameter for requests using the securesourcemanager.googleapis.com endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRepositories(ListRepositoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRepositories(LocationName parent)
 *           <li><p> listRepositories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRepositoriesPagedCallable()
 *           <li><p> listRepositoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRepository</td>
 *      <td><p> Gets metadata of a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRepository(GetRepositoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRepository(RepositoryName name)
 *           <li><p> getRepository(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRepository</td>
 *      <td><p> Creates a new repository in a given project and location.
 * <p>  The Repository.Instance field is required in the request body for requests using the securesourcemanager.googleapis.com endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRepositoryAsync(CreateRepositoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRepositoryAsync(LocationName parent, Repository repository, String repositoryId)
 *           <li><p> createRepositoryAsync(String parent, Repository repository, String repositoryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRepositoryOperationCallable()
 *           <li><p> createRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRepository</td>
 *      <td><p> Updates the metadata of a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRepositoryAsync(UpdateRepositoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRepositoryAsync(Repository repository, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRepositoryOperationCallable()
 *           <li><p> updateRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRepository</td>
 *      <td><p> Deletes a Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRepositoryAsync(DeleteRepositoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRepositoryAsync(RepositoryName name)
 *           <li><p> deleteRepositoryAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRepositoryOperationCallable()
 *           <li><p> deleteRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHooks</td>
 *      <td><p> Lists hooks in a given repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHooks(ListHooksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHooks(RepositoryName parent)
 *           <li><p> listHooks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHooksPagedCallable()
 *           <li><p> listHooksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHook</td>
 *      <td><p> Gets metadata of a hook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHook(GetHookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHook(HookName name)
 *           <li><p> getHook(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHook</td>
 *      <td><p> Creates a new hook in a given repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHookAsync(CreateHookRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createHookAsync(RepositoryName parent, Hook hook, String hookId)
 *           <li><p> createHookAsync(String parent, Hook hook, String hookId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHookOperationCallable()
 *           <li><p> createHookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHook</td>
 *      <td><p> Updates the metadata of a hook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHookAsync(UpdateHookRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateHookAsync(Hook hook, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHookOperationCallable()
 *           <li><p> updateHookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHook</td>
 *      <td><p> Deletes a Hook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHookAsync(DeleteHookRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteHookAsync(HookName name)
 *           <li><p> deleteHookAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHookOperationCallable()
 *           <li><p> deleteHookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicyRepo</td>
 *      <td><p> Get IAM policy for a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicyRepo(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicyRepo(ResourceName resource)
 *           <li><p> getIamPolicyRepo(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyRepoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicyRepo</td>
 *      <td><p> Set IAM policy on a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicyRepo(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicyRepo(ResourceName resource)
 *           <li><p> setIamPolicyRepo(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyRepoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissionsRepo</td>
 *      <td><p> Test IAM permissions on a repository. IAM permission checks are not required on this method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissionsRepo(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissionsRepo(ResourceName resource)
 *           <li><p> testIamPermissionsRepo(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsRepoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBranchRule</td>
 *      <td><p> CreateBranchRule creates a branch rule in a given repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBranchRuleAsync(CreateBranchRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBranchRuleAsync(RepositoryName parent, BranchRule branchRule, String branchRuleId)
 *           <li><p> createBranchRuleAsync(String parent, BranchRule branchRule, String branchRuleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBranchRuleOperationCallable()
 *           <li><p> createBranchRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBranchRules</td>
 *      <td><p> ListBranchRules lists branch rules in a given repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBranchRules(ListBranchRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBranchRules(RepositoryName parent)
 *           <li><p> listBranchRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBranchRulesPagedCallable()
 *           <li><p> listBranchRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBranchRule</td>
 *      <td><p> GetBranchRule gets a branch rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBranchRule(GetBranchRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBranchRule(BranchRuleName name)
 *           <li><p> getBranchRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBranchRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBranchRule</td>
 *      <td><p> UpdateBranchRule updates a branch rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBranchRuleAsync(UpdateBranchRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBranchRuleAsync(BranchRule branchRule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBranchRuleOperationCallable()
 *           <li><p> updateBranchRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBranchRule</td>
 *      <td><p> DeleteBranchRule deletes a branch rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBranchRuleAsync(DeleteBranchRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBranchRuleAsync(BranchRuleName name)
 *           <li><p> deleteBranchRuleAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBranchRuleOperationCallable()
 *           <li><p> deleteBranchRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePullRequest</td>
 *      <td><p> Creates a pull request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPullRequestAsync(CreatePullRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPullRequestAsync(RepositoryName parent, PullRequest pullRequest)
 *           <li><p> createPullRequestAsync(String parent, PullRequest pullRequest)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPullRequestOperationCallable()
 *           <li><p> createPullRequestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPullRequest</td>
 *      <td><p> Gets a pull request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPullRequest(GetPullRequestRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPullRequest(PullRequestName name)
 *           <li><p> getPullRequest(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPullRequestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPullRequests</td>
 *      <td><p> Lists pull requests in a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPullRequests(ListPullRequestsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPullRequests(RepositoryName parent)
 *           <li><p> listPullRequests(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPullRequestsPagedCallable()
 *           <li><p> listPullRequestsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePullRequest</td>
 *      <td><p> Updates a pull request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePullRequestAsync(UpdatePullRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePullRequestAsync(PullRequest pullRequest, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePullRequestOperationCallable()
 *           <li><p> updatePullRequestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MergePullRequest</td>
 *      <td><p> Merges a pull request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> mergePullRequestAsync(MergePullRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> mergePullRequestAsync(PullRequestName name)
 *           <li><p> mergePullRequestAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> mergePullRequestOperationCallable()
 *           <li><p> mergePullRequestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> OpenPullRequest</td>
 *      <td><p> Opens a pull request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> openPullRequestAsync(OpenPullRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> openPullRequestAsync(PullRequestName name)
 *           <li><p> openPullRequestAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> openPullRequestOperationCallable()
 *           <li><p> openPullRequestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ClosePullRequest</td>
 *      <td><p> Closes a pull request without merging.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> closePullRequestAsync(ClosePullRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> closePullRequestAsync(PullRequestName name)
 *           <li><p> closePullRequestAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> closePullRequestOperationCallable()
 *           <li><p> closePullRequestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPullRequestFileDiffs</td>
 *      <td><p> Lists a pull request's file diffs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPullRequestFileDiffs(ListPullRequestFileDiffsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPullRequestFileDiffs(PullRequestName name)
 *           <li><p> listPullRequestFileDiffs(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPullRequestFileDiffsPagedCallable()
 *           <li><p> listPullRequestFileDiffsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchTree</td>
 *      <td><p> Fetches a tree from a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchTree(FetchTreeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchTreePagedCallable()
 *           <li><p> fetchTreeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchBlob</td>
 *      <td><p> Fetches a blob from a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchBlob(FetchBlobRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchBlobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIssue</td>
 *      <td><p> Creates an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIssueAsync(CreateIssueRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createIssueAsync(RepositoryName parent, Issue issue)
 *           <li><p> createIssueAsync(String parent, Issue issue)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIssueOperationCallable()
 *           <li><p> createIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIssue</td>
 *      <td><p> Gets an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIssue(GetIssueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIssue(IssueName name)
 *           <li><p> getIssue(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIssues</td>
 *      <td><p> Lists issues in a repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIssues(ListIssuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIssues(RepositoryName parent)
 *           <li><p> listIssues(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIssuesPagedCallable()
 *           <li><p> listIssuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIssue</td>
 *      <td><p> Updates a issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIssueAsync(UpdateIssueRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateIssueAsync(Issue issue, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIssueOperationCallable()
 *           <li><p> updateIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIssue</td>
 *      <td><p> Deletes an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIssueAsync(DeleteIssueRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteIssueAsync(IssueName name)
 *           <li><p> deleteIssueAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIssueOperationCallable()
 *           <li><p> deleteIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> OpenIssue</td>
 *      <td><p> Opens an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> openIssueAsync(OpenIssueRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> openIssueAsync(IssueName name)
 *           <li><p> openIssueAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> openIssueOperationCallable()
 *           <li><p> openIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CloseIssue</td>
 *      <td><p> Closes an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> closeIssueAsync(CloseIssueRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> closeIssueAsync(IssueName name)
 *           <li><p> closeIssueAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> closeIssueOperationCallable()
 *           <li><p> closeIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPullRequestComment</td>
 *      <td><p> Gets a pull request comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPullRequestComment(GetPullRequestCommentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPullRequestComment(PullRequestCommentName name)
 *           <li><p> getPullRequestComment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPullRequestCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPullRequestComments</td>
 *      <td><p> Lists pull request comments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPullRequestComments(ListPullRequestCommentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPullRequestComments(PullRequestName parent)
 *           <li><p> listPullRequestComments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPullRequestCommentsPagedCallable()
 *           <li><p> listPullRequestCommentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePullRequestComment</td>
 *      <td><p> Creates a pull request comment. This function is used to create a single PullRequestComment of type Comment, or a single PullRequestComment of type Code that's replying to another PullRequestComment of type Code. Use BatchCreatePullRequestComments to create multiple PullRequestComments for code reviews.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPullRequestCommentAsync(CreatePullRequestCommentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPullRequestCommentAsync(PullRequestName parent, PullRequestComment pullRequestComment)
 *           <li><p> createPullRequestCommentAsync(String parent, PullRequestComment pullRequestComment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPullRequestCommentOperationCallable()
 *           <li><p> createPullRequestCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePullRequestComment</td>
 *      <td><p> Updates a pull request comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePullRequestCommentAsync(UpdatePullRequestCommentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePullRequestCommentAsync(PullRequestComment pullRequestComment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePullRequestCommentOperationCallable()
 *           <li><p> updatePullRequestCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePullRequestComment</td>
 *      <td><p> Deletes a pull request comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePullRequestCommentAsync(DeletePullRequestCommentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePullRequestCommentAsync(PullRequestCommentName name)
 *           <li><p> deletePullRequestCommentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePullRequestCommentOperationCallable()
 *           <li><p> deletePullRequestCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreatePullRequestComments</td>
 *      <td><p> Batch creates pull request comments. This function is used to create multiple PullRequestComments for code review. There needs to be exactly one PullRequestComment of type Review, and at most 100 PullRequestComments of type Code per request. The Postition of the code comments must be unique within the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreatePullRequestCommentsAsync(PullRequestName parent, List&lt;CreatePullRequestCommentRequest&gt; requests)
 *           <li><p> batchCreatePullRequestCommentsAsync(String parent, List&lt;CreatePullRequestCommentRequest&gt; requests)
 *           <li><p> batchCreatePullRequestCommentsAsync(BatchCreatePullRequestCommentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreatePullRequestCommentsOperationCallable()
 *           <li><p> batchCreatePullRequestCommentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResolvePullRequestComments</td>
 *      <td><p> Resolves pull request comments. A list of PullRequestComment names must be provided. The PullRequestComment names must be in the same conversation thread. If auto_fill is set, all comments in the conversation thread will be resolved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resolvePullRequestCommentsAsync(ResolvePullRequestCommentsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resolvePullRequestCommentsAsync(PullRequestName parent, List&lt;String&gt; names)
 *           <li><p> resolvePullRequestCommentsAsync(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resolvePullRequestCommentsOperationCallable()
 *           <li><p> resolvePullRequestCommentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UnresolvePullRequestComments</td>
 *      <td><p> Unresolves pull request comments. A list of PullRequestComment names must be provided. The PullRequestComment names must be in the same conversation thread. If auto_fill is set, all comments in the conversation thread will be unresolved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> unresolvePullRequestCommentsAsync(UnresolvePullRequestCommentsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> unresolvePullRequestCommentsAsync(PullRequestName parent, List&lt;String&gt; names)
 *           <li><p> unresolvePullRequestCommentsAsync(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> unresolvePullRequestCommentsOperationCallable()
 *           <li><p> unresolvePullRequestCommentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIssueComment</td>
 *      <td><p> Creates an issue comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIssueCommentAsync(CreateIssueCommentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createIssueCommentAsync(IssueName parent, IssueComment issueComment)
 *           <li><p> createIssueCommentAsync(String parent, IssueComment issueComment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIssueCommentOperationCallable()
 *           <li><p> createIssueCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIssueComment</td>
 *      <td><p> Gets an issue comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIssueComment(GetIssueCommentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIssueComment(IssueCommentName name)
 *           <li><p> getIssueComment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIssueCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIssueComments</td>
 *      <td><p> Lists comments in an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIssueComments(ListIssueCommentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIssueComments(IssueName parent)
 *           <li><p> listIssueComments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIssueCommentsPagedCallable()
 *           <li><p> listIssueCommentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIssueComment</td>
 *      <td><p> Updates an issue comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIssueCommentAsync(UpdateIssueCommentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateIssueCommentAsync(IssueComment issueComment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIssueCommentOperationCallable()
 *           <li><p> updateIssueCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIssueComment</td>
 *      <td><p> Deletes an issue comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIssueCommentAsync(DeleteIssueCommentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteIssueCommentAsync(IssueCommentName name)
 *           <li><p> deleteIssueCommentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIssueCommentOperationCallable()
 *           <li><p> deleteIssueCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SecureSourceManagerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecureSourceManagerSettings secureSourceManagerSettings =
 *     SecureSourceManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecureSourceManagerClient secureSourceManagerClient =
 *     SecureSourceManagerClient.create(secureSourceManagerSettings);
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
 * SecureSourceManagerSettings secureSourceManagerSettings =
 *     SecureSourceManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecureSourceManagerClient secureSourceManagerClient =
 *     SecureSourceManagerClient.create(secureSourceManagerSettings);
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
 * SecureSourceManagerSettings secureSourceManagerSettings =
 *     SecureSourceManagerSettings.newHttpJsonBuilder().build();
 * SecureSourceManagerClient secureSourceManagerClient =
 *     SecureSourceManagerClient.create(secureSourceManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SecureSourceManagerClient implements BackgroundResource {
  private final SecureSourceManagerSettings settings;
  private final SecureSourceManagerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SecureSourceManagerClient with default settings. */
  public static final SecureSourceManagerClient create() throws IOException {
    return create(SecureSourceManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecureSourceManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SecureSourceManagerClient create(SecureSourceManagerSettings settings)
      throws IOException {
    return new SecureSourceManagerClient(settings);
  }

  /**
   * Constructs an instance of SecureSourceManagerClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SecureSourceManagerSettings).
   */
  public static final SecureSourceManagerClient create(SecureSourceManagerStub stub) {
    return new SecureSourceManagerClient(stub);
  }

  /**
   * Constructs an instance of SecureSourceManagerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SecureSourceManagerClient(SecureSourceManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SecureSourceManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SecureSourceManagerClient(SecureSourceManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SecureSourceManagerSettings getSettings() {
    return settings;
  }

  public SecureSourceManagerStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : secureSourceManagerClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Instance element : secureSourceManagerClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Instance element : secureSourceManagerClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Instance> future =
   *       secureSourceManagerClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response =
   *         secureSourceManagerClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = secureSourceManagerClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = secureSourceManagerClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = secureSourceManagerClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future =
   *       secureSourceManagerClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response =
   *       secureSourceManagerClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param instance Required. The resource being created.
   * @param instanceId Required. ID of the instance to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      LocationName parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response =
   *       secureSourceManagerClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param instance Required. The resource being created.
   * @param instanceId Required. ID of the instance to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Instance response = secureSourceManagerClient.createInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       secureSourceManagerClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   secureSourceManagerClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(InstanceName name) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   secureSourceManagerClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   secureSourceManagerClient.deleteInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secureSourceManagerClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>The instance field is required in the query parameter for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Repository element : secureSourceManagerClient.listRepositories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRepositoriesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRepositoriesPagedResponse listRepositories(LocationName parent) {
    ListRepositoriesRequest request =
        ListRepositoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRepositories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>The instance field is required in the query parameter for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Repository element : secureSourceManagerClient.listRepositories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRepositoriesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRepositoriesPagedResponse listRepositories(String parent) {
    ListRepositoriesRequest request =
        ListRepositoriesRequest.newBuilder().setParent(parent).build();
    return listRepositories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>The instance field is required in the query parameter for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   for (Repository element : secureSourceManagerClient.listRepositories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRepositoriesPagedResponse listRepositories(ListRepositoriesRequest request) {
    return listRepositoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>The instance field is required in the query parameter for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Repository> future =
   *       secureSourceManagerClient.listRepositoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Repository element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    return stub.listRepositoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>The instance field is required in the query parameter for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   while (true) {
   *     ListRepositoriesResponse response =
   *         secureSourceManagerClient.listRepositoriesCallable().call(request);
   *     for (Repository element : response.getRepositoriesList()) {
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
  public final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    return stub.listRepositoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Repository response = secureSourceManagerClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the repository to retrieve. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(RepositoryName name) {
    GetRepositoryRequest request =
        GetRepositoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Repository response = secureSourceManagerClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the repository to retrieve. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(String name) {
    GetRepositoryRequest request = GetRepositoryRequest.newBuilder().setName(name).build();
    return getRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   Repository response = secureSourceManagerClient.getRepository(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(GetRepositoryRequest request) {
    return getRepositoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   ApiFuture<Repository> future =
   *       secureSourceManagerClient.getRepositoryCallable().futureCall(request);
   *   // Do something.
   *   Repository response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return stub.getRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new repository in a given project and location.
   *
   * <p>The Repository.Instance field is required in the request body for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Repository repository = Repository.newBuilder().build();
   *   String repositoryId = "repositoryId2113747461";
   *   Repository response =
   *       secureSourceManagerClient.createRepositoryAsync(parent, repository, repositoryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which to create the repository. Values are of the form
   *     `projects/{project_number}/locations/{location_id}`
   * @param repository Required. The resource being created.
   * @param repositoryId Required. The ID to use for the repository, which will become the final
   *     component of the repository's resource name. This value should be 4-63 characters, and
   *     valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> createRepositoryAsync(
      LocationName parent, Repository repository, String repositoryId) {
    CreateRepositoryRequest request =
        CreateRepositoryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRepository(repository)
            .setRepositoryId(repositoryId)
            .build();
    return createRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new repository in a given project and location.
   *
   * <p>The Repository.Instance field is required in the request body for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Repository repository = Repository.newBuilder().build();
   *   String repositoryId = "repositoryId2113747461";
   *   Repository response =
   *       secureSourceManagerClient.createRepositoryAsync(parent, repository, repositoryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which to create the repository. Values are of the form
   *     `projects/{project_number}/locations/{location_id}`
   * @param repository Required. The resource being created.
   * @param repositoryId Required. The ID to use for the repository, which will become the final
   *     component of the repository's resource name. This value should be 4-63 characters, and
   *     valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> createRepositoryAsync(
      String parent, Repository repository, String repositoryId) {
    CreateRepositoryRequest request =
        CreateRepositoryRequest.newBuilder()
            .setParent(parent)
            .setRepository(repository)
            .setRepositoryId(repositoryId)
            .build();
    return createRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new repository in a given project and location.
   *
   * <p>The Repository.Instance field is required in the request body for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepository(Repository.newBuilder().build())
   *           .setRepositoryId("repositoryId2113747461")
   *           .build();
   *   Repository response = secureSourceManagerClient.createRepositoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> createRepositoryAsync(
      CreateRepositoryRequest request) {
    return createRepositoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new repository in a given project and location.
   *
   * <p>The Repository.Instance field is required in the request body for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepository(Repository.newBuilder().build())
   *           .setRepositoryId("repositoryId2113747461")
   *           .build();
   *   OperationFuture<Repository, OperationMetadata> future =
   *       secureSourceManagerClient.createRepositoryOperationCallable().futureCall(request);
   *   // Do something.
   *   Repository response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    return stub.createRepositoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new repository in a given project and location.
   *
   * <p>The Repository.Instance field is required in the request body for requests using the
   * securesourcemanager.googleapis.com endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepository(Repository.newBuilder().build())
   *           .setRepositoryId("repositoryId2113747461")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createRepositoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    return stub.createRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   Repository repository = Repository.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Repository response =
   *       secureSourceManagerClient.updateRepositoryAsync(repository, updateMask).get();
   * }
   * }</pre>
   *
   * @param repository Required. The repository being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     repository resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> updateRepositoryAsync(
      Repository repository, FieldMask updateMask) {
    UpdateRepositoryRequest request =
        UpdateRepositoryRequest.newBuilder()
            .setRepository(repository)
            .setUpdateMask(updateMask)
            .build();
    return updateRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateRepositoryRequest request =
   *       UpdateRepositoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRepository(Repository.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Repository response = secureSourceManagerClient.updateRepositoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> updateRepositoryAsync(
      UpdateRepositoryRequest request) {
    return updateRepositoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateRepositoryRequest request =
   *       UpdateRepositoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRepository(Repository.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Repository, OperationMetadata> future =
   *       secureSourceManagerClient.updateRepositoryOperationCallable().futureCall(request);
   *   // Do something.
   *   Repository response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRepositoryRequest, Repository, OperationMetadata>
      updateRepositoryOperationCallable() {
    return stub.updateRepositoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateRepositoryRequest request =
   *       UpdateRepositoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRepository(Repository.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.updateRepositoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRepositoryRequest, Operation> updateRepositoryCallable() {
    return stub.updateRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   secureSourceManagerClient.deleteRepositoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the repository to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRepositoryAsync(
      RepositoryName name) {
    DeleteRepositoryRequest request =
        DeleteRepositoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   secureSourceManagerClient.deleteRepositoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the repository to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRepositoryAsync(String name) {
    DeleteRepositoryRequest request = DeleteRepositoryRequest.newBuilder().setName(name).build();
    return deleteRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   secureSourceManagerClient.deleteRepositoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRepositoryAsync(
      DeleteRepositoryRequest request) {
    return deleteRepositoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secureSourceManagerClient.deleteRepositoryOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    return stub.deleteRepositoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.deleteRepositoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    return stub.deleteRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hooks in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (Hook element : secureSourceManagerClient.listHooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListHooksRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHooksPagedResponse listHooks(RepositoryName parent) {
    ListHooksRequest request =
        ListHooksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listHooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hooks in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (Hook element : secureSourceManagerClient.listHooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListHooksRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHooksPagedResponse listHooks(String parent) {
    ListHooksRequest request = ListHooksRequest.newBuilder().setParent(parent).build();
    return listHooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hooks in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListHooksRequest request =
   *       ListHooksRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Hook element : secureSourceManagerClient.listHooks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHooksPagedResponse listHooks(ListHooksRequest request) {
    return listHooksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hooks in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListHooksRequest request =
   *       ListHooksRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Hook> future =
   *       secureSourceManagerClient.listHooksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Hook element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHooksRequest, ListHooksPagedResponse> listHooksPagedCallable() {
    return stub.listHooksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hooks in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListHooksRequest request =
   *       ListHooksRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHooksResponse response = secureSourceManagerClient.listHooksCallable().call(request);
   *     for (Hook element : response.getHooksList()) {
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
  public final UnaryCallable<ListHooksRequest, ListHooksResponse> listHooksCallable() {
    return stub.listHooksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   HookName name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]");
   *   Hook response = secureSourceManagerClient.getHook(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the hook to retrieve. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/hooks/{hook_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hook getHook(HookName name) {
    GetHookRequest request =
        GetHookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString();
   *   Hook response = secureSourceManagerClient.getHook(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the hook to retrieve. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/hooks/{hook_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hook getHook(String name) {
    GetHookRequest request = GetHookRequest.newBuilder().setName(name).build();
    return getHook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetHookRequest request =
   *       GetHookRequest.newBuilder()
   *           .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
   *           .build();
   *   Hook response = secureSourceManagerClient.getHook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hook getHook(GetHookRequest request) {
    return getHookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetHookRequest request =
   *       GetHookRequest.newBuilder()
   *           .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
   *           .build();
   *   ApiFuture<Hook> future = secureSourceManagerClient.getHookCallable().futureCall(request);
   *   // Do something.
   *   Hook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHookRequest, Hook> getHookCallable() {
    return stub.getHookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hook in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Hook hook = Hook.newBuilder().build();
   *   String hookId = "hookId-1211612770";
   *   Hook response = secureSourceManagerClient.createHookAsync(parent, hook, hookId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the hook. Values are of the form
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @param hook Required. The resource being created.
   * @param hookId Required. The ID to use for the hook, which will become the final component of
   *     the hook's resource name. This value restricts to lower-case letters, numbers, and hyphen,
   *     with the first character a letter, the last a letter or a number, and a 63 character
   *     maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hook, OperationMetadata> createHookAsync(
      RepositoryName parent, Hook hook, String hookId) {
    CreateHookRequest request =
        CreateHookRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHook(hook)
            .setHookId(hookId)
            .build();
    return createHookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hook in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Hook hook = Hook.newBuilder().build();
   *   String hookId = "hookId-1211612770";
   *   Hook response = secureSourceManagerClient.createHookAsync(parent, hook, hookId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the hook. Values are of the form
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @param hook Required. The resource being created.
   * @param hookId Required. The ID to use for the hook, which will become the final component of
   *     the hook's resource name. This value restricts to lower-case letters, numbers, and hyphen,
   *     with the first character a letter, the last a letter or a number, and a 63 character
   *     maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hook, OperationMetadata> createHookAsync(
      String parent, Hook hook, String hookId) {
    CreateHookRequest request =
        CreateHookRequest.newBuilder().setParent(parent).setHook(hook).setHookId(hookId).build();
    return createHookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hook in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateHookRequest request =
   *       CreateHookRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setHook(Hook.newBuilder().build())
   *           .setHookId("hookId-1211612770")
   *           .build();
   *   Hook response = secureSourceManagerClient.createHookAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hook, OperationMetadata> createHookAsync(CreateHookRequest request) {
    return createHookOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hook in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateHookRequest request =
   *       CreateHookRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setHook(Hook.newBuilder().build())
   *           .setHookId("hookId-1211612770")
   *           .build();
   *   OperationFuture<Hook, OperationMetadata> future =
   *       secureSourceManagerClient.createHookOperationCallable().futureCall(request);
   *   // Do something.
   *   Hook response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateHookRequest, Hook, OperationMetadata>
      createHookOperationCallable() {
    return stub.createHookOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hook in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateHookRequest request =
   *       CreateHookRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setHook(Hook.newBuilder().build())
   *           .setHookId("hookId-1211612770")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createHookCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHookRequest, Operation> createHookCallable() {
    return stub.createHookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   Hook hook = Hook.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Hook response = secureSourceManagerClient.updateHookAsync(hook, updateMask).get();
   * }
   * }</pre>
   *
   * @param hook Required. The hook being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     hook resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. The
   *     special value "&#42;" means full replacement.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hook, OperationMetadata> updateHookAsync(
      Hook hook, FieldMask updateMask) {
    UpdateHookRequest request =
        UpdateHookRequest.newBuilder().setHook(hook).setUpdateMask(updateMask).build();
    return updateHookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateHookRequest request =
   *       UpdateHookRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHook(Hook.newBuilder().build())
   *           .build();
   *   Hook response = secureSourceManagerClient.updateHookAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hook, OperationMetadata> updateHookAsync(UpdateHookRequest request) {
    return updateHookOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateHookRequest request =
   *       UpdateHookRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHook(Hook.newBuilder().build())
   *           .build();
   *   OperationFuture<Hook, OperationMetadata> future =
   *       secureSourceManagerClient.updateHookOperationCallable().futureCall(request);
   *   // Do something.
   *   Hook response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateHookRequest, Hook, OperationMetadata>
      updateHookOperationCallable() {
    return stub.updateHookOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata of a hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateHookRequest request =
   *       UpdateHookRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHook(Hook.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.updateHookCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHookRequest, Operation> updateHookCallable() {
    return stub.updateHookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   HookName name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]");
   *   secureSourceManagerClient.deleteHookAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the hook to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/hooks/{hook_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHookAsync(HookName name) {
    DeleteHookRequest request =
        DeleteHookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteHookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString();
   *   secureSourceManagerClient.deleteHookAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the hook to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/hooks/{hook_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHookAsync(String name) {
    DeleteHookRequest request = DeleteHookRequest.newBuilder().setName(name).build();
    return deleteHookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteHookRequest request =
   *       DeleteHookRequest.newBuilder()
   *           .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
   *           .build();
   *   secureSourceManagerClient.deleteHookAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHookAsync(
      DeleteHookRequest request) {
    return deleteHookOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteHookRequest request =
   *       DeleteHookRequest.newBuilder()
   *           .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secureSourceManagerClient.deleteHookOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteHookRequest, Empty, OperationMetadata>
      deleteHookOperationCallable() {
    return stub.deleteHookOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Hook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteHookRequest request =
   *       DeleteHookRequest.newBuilder()
   *           .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.deleteHookCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHookRequest, Operation> deleteHookCallable() {
    return stub.deleteHookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get IAM policy for a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Policy response = secureSourceManagerClient.getIamPolicyRepo(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicyRepo(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicyRepo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get IAM policy for a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String resource = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Policy response = secureSourceManagerClient.getIamPolicyRepo(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicyRepo(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicyRepo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get IAM policy for a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = secureSourceManagerClient.getIamPolicyRepo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicyRepo(GetIamPolicyRequest request) {
    return getIamPolicyRepoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get IAM policy for a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       secureSourceManagerClient.getIamPolicyRepoCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyRepoCallable() {
    return stub.getIamPolicyRepoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set IAM policy on a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Policy response = secureSourceManagerClient.setIamPolicyRepo(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicyRepo(ResourceName resource) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return setIamPolicyRepo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set IAM policy on a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String resource = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Policy response = secureSourceManagerClient.setIamPolicyRepo(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicyRepo(String resource) {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder().setResource(resource).build();
    return setIamPolicyRepo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set IAM policy on a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = secureSourceManagerClient.setIamPolicyRepo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicyRepo(SetIamPolicyRequest request) {
    return setIamPolicyRepoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set IAM policy on a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       secureSourceManagerClient.setIamPolicyRepoCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyRepoCallable() {
    return stub.setIamPolicyRepoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Test IAM permissions on a repository. IAM permission checks are not required on this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   TestIamPermissionsResponse response =
   *       secureSourceManagerClient.testIamPermissionsRepo(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissionsRepo(ResourceName resource) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return testIamPermissionsRepo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Test IAM permissions on a repository. IAM permission checks are not required on this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String resource = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TestIamPermissionsResponse response =
   *       secureSourceManagerClient.testIamPermissionsRepo(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissionsRepo(String resource) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder().setResource(resource).build();
    return testIamPermissionsRepo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Test IAM permissions on a repository. IAM permission checks are not required on this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       secureSourceManagerClient.testIamPermissionsRepo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissionsRepo(
      TestIamPermissionsRequest request) {
    return testIamPermissionsRepoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Test IAM permissions on a repository. IAM permission checks are not required on this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       secureSourceManagerClient.testIamPermissionsRepoCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoCallable() {
    return stub.testIamPermissionsRepoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateBranchRule creates a branch rule in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   BranchRule branchRule = BranchRule.newBuilder().build();
   *   String branchRuleId = "branchRuleId-1052663431";
   *   BranchRule response =
   *       secureSourceManagerClient.createBranchRuleAsync(parent, branchRule, branchRuleId).get();
   * }
   * }</pre>
   *
   * @param parent
   * @param branchRule
   * @param branchRuleId
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BranchRule, OperationMetadata> createBranchRuleAsync(
      RepositoryName parent, BranchRule branchRule, String branchRuleId) {
    CreateBranchRuleRequest request =
        CreateBranchRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBranchRule(branchRule)
            .setBranchRuleId(branchRuleId)
            .build();
    return createBranchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateBranchRule creates a branch rule in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   BranchRule branchRule = BranchRule.newBuilder().build();
   *   String branchRuleId = "branchRuleId-1052663431";
   *   BranchRule response =
   *       secureSourceManagerClient.createBranchRuleAsync(parent, branchRule, branchRuleId).get();
   * }
   * }</pre>
   *
   * @param parent
   * @param branchRule
   * @param branchRuleId
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BranchRule, OperationMetadata> createBranchRuleAsync(
      String parent, BranchRule branchRule, String branchRuleId) {
    CreateBranchRuleRequest request =
        CreateBranchRuleRequest.newBuilder()
            .setParent(parent)
            .setBranchRule(branchRule)
            .setBranchRuleId(branchRuleId)
            .build();
    return createBranchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateBranchRule creates a branch rule in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateBranchRuleRequest request =
   *       CreateBranchRuleRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setBranchRule(BranchRule.newBuilder().build())
   *           .setBranchRuleId("branchRuleId-1052663431")
   *           .build();
   *   BranchRule response = secureSourceManagerClient.createBranchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BranchRule, OperationMetadata> createBranchRuleAsync(
      CreateBranchRuleRequest request) {
    return createBranchRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateBranchRule creates a branch rule in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateBranchRuleRequest request =
   *       CreateBranchRuleRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setBranchRule(BranchRule.newBuilder().build())
   *           .setBranchRuleId("branchRuleId-1052663431")
   *           .build();
   *   OperationFuture<BranchRule, OperationMetadata> future =
   *       secureSourceManagerClient.createBranchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   BranchRule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBranchRuleRequest, BranchRule, OperationMetadata>
      createBranchRuleOperationCallable() {
    return stub.createBranchRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateBranchRule creates a branch rule in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateBranchRuleRequest request =
   *       CreateBranchRuleRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setBranchRule(BranchRule.newBuilder().build())
   *           .setBranchRuleId("branchRuleId-1052663431")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createBranchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBranchRuleRequest, Operation> createBranchRuleCallable() {
    return stub.createBranchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListBranchRules lists branch rules in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (BranchRule element : secureSourceManagerClient.listBranchRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBranchRulesPagedResponse listBranchRules(RepositoryName parent) {
    ListBranchRulesRequest request =
        ListBranchRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBranchRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListBranchRules lists branch rules in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (BranchRule element : secureSourceManagerClient.listBranchRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBranchRulesPagedResponse listBranchRules(String parent) {
    ListBranchRulesRequest request = ListBranchRulesRequest.newBuilder().setParent(parent).build();
    return listBranchRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListBranchRules lists branch rules in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListBranchRulesRequest request =
   *       ListBranchRulesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BranchRule element : secureSourceManagerClient.listBranchRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBranchRulesPagedResponse listBranchRules(ListBranchRulesRequest request) {
    return listBranchRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListBranchRules lists branch rules in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListBranchRulesRequest request =
   *       ListBranchRulesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BranchRule> future =
   *       secureSourceManagerClient.listBranchRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BranchRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBranchRulesRequest, ListBranchRulesPagedResponse>
      listBranchRulesPagedCallable() {
    return stub.listBranchRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListBranchRules lists branch rules in a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListBranchRulesRequest request =
   *       ListBranchRulesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBranchRulesResponse response =
   *         secureSourceManagerClient.listBranchRulesCallable().call(request);
   *     for (BranchRule element : response.getBranchRulesList()) {
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
  public final UnaryCallable<ListBranchRulesRequest, ListBranchRulesResponse>
      listBranchRulesCallable() {
    return stub.listBranchRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetBranchRule gets a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   BranchRuleName name =
   *       BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]");
   *   BranchRule response = secureSourceManagerClient.getBranchRule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the repository to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/branchRules/{branch_rule}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BranchRule getBranchRule(BranchRuleName name) {
    GetBranchRuleRequest request =
        GetBranchRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBranchRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetBranchRule gets a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]").toString();
   *   BranchRule response = secureSourceManagerClient.getBranchRule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the repository to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/branchRules/{branch_rule}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BranchRule getBranchRule(String name) {
    GetBranchRuleRequest request = GetBranchRuleRequest.newBuilder().setName(name).build();
    return getBranchRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetBranchRule gets a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetBranchRuleRequest request =
   *       GetBranchRuleRequest.newBuilder()
   *           .setName(
   *               BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
   *                   .toString())
   *           .build();
   *   BranchRule response = secureSourceManagerClient.getBranchRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BranchRule getBranchRule(GetBranchRuleRequest request) {
    return getBranchRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetBranchRule gets a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetBranchRuleRequest request =
   *       GetBranchRuleRequest.newBuilder()
   *           .setName(
   *               BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BranchRule> future =
   *       secureSourceManagerClient.getBranchRuleCallable().futureCall(request);
   *   // Do something.
   *   BranchRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBranchRuleRequest, BranchRule> getBranchRuleCallable() {
    return stub.getBranchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * UpdateBranchRule updates a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   BranchRule branchRule = BranchRule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BranchRule response =
   *       secureSourceManagerClient.updateBranchRuleAsync(branchRule, updateMask).get();
   * }
   * }</pre>
   *
   * @param branchRule
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     branchRule resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. The
   *     special value "&#42;" means full replacement.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BranchRule, OperationMetadata> updateBranchRuleAsync(
      BranchRule branchRule, FieldMask updateMask) {
    UpdateBranchRuleRequest request =
        UpdateBranchRuleRequest.newBuilder()
            .setBranchRule(branchRule)
            .setUpdateMask(updateMask)
            .build();
    return updateBranchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * UpdateBranchRule updates a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateBranchRuleRequest request =
   *       UpdateBranchRuleRequest.newBuilder()
   *           .setBranchRule(BranchRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BranchRule response = secureSourceManagerClient.updateBranchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BranchRule, OperationMetadata> updateBranchRuleAsync(
      UpdateBranchRuleRequest request) {
    return updateBranchRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * UpdateBranchRule updates a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateBranchRuleRequest request =
   *       UpdateBranchRuleRequest.newBuilder()
   *           .setBranchRule(BranchRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<BranchRule, OperationMetadata> future =
   *       secureSourceManagerClient.updateBranchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   BranchRule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
      updateBranchRuleOperationCallable() {
    return stub.updateBranchRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * UpdateBranchRule updates a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateBranchRuleRequest request =
   *       UpdateBranchRuleRequest.newBuilder()
   *           .setBranchRule(BranchRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.updateBranchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBranchRuleRequest, Operation> updateBranchRuleCallable() {
    return stub.updateBranchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteBranchRule deletes a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   BranchRuleName name =
   *       BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]");
   *   secureSourceManagerClient.deleteBranchRuleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBranchRuleAsync(
      BranchRuleName name) {
    DeleteBranchRuleRequest request =
        DeleteBranchRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBranchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteBranchRule deletes a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]").toString();
   *   secureSourceManagerClient.deleteBranchRuleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBranchRuleAsync(String name) {
    DeleteBranchRuleRequest request = DeleteBranchRuleRequest.newBuilder().setName(name).build();
    return deleteBranchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteBranchRule deletes a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteBranchRuleRequest request =
   *       DeleteBranchRuleRequest.newBuilder()
   *           .setName(
   *               BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
   *                   .toString())
   *           .setAllowMissing(true)
   *           .build();
   *   secureSourceManagerClient.deleteBranchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBranchRuleAsync(
      DeleteBranchRuleRequest request) {
    return deleteBranchRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteBranchRule deletes a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteBranchRuleRequest request =
   *       DeleteBranchRuleRequest.newBuilder()
   *           .setName(
   *               BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
   *                   .toString())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secureSourceManagerClient.deleteBranchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBranchRuleRequest, Empty, OperationMetadata>
      deleteBranchRuleOperationCallable() {
    return stub.deleteBranchRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteBranchRule deletes a branch rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteBranchRuleRequest request =
   *       DeleteBranchRuleRequest.newBuilder()
   *           .setName(
   *               BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
   *                   .toString())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.deleteBranchRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBranchRuleRequest, Operation> deleteBranchRuleCallable() {
    return stub.deleteBranchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   PullRequest pullRequest = PullRequest.newBuilder().build();
   *   PullRequest response =
   *       secureSourceManagerClient.createPullRequestAsync(parent, pullRequest).get();
   * }
   * }</pre>
   *
   * @param parent Required. The repository that the pull request is created from. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @param pullRequest Required. The pull request to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> createPullRequestAsync(
      RepositoryName parent, PullRequest pullRequest) {
    CreatePullRequestRequest request =
        CreatePullRequestRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPullRequest(pullRequest)
            .build();
    return createPullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   PullRequest pullRequest = PullRequest.newBuilder().build();
   *   PullRequest response =
   *       secureSourceManagerClient.createPullRequestAsync(parent, pullRequest).get();
   * }
   * }</pre>
   *
   * @param parent Required. The repository that the pull request is created from. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @param pullRequest Required. The pull request to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> createPullRequestAsync(
      String parent, PullRequest pullRequest) {
    CreatePullRequestRequest request =
        CreatePullRequestRequest.newBuilder().setParent(parent).setPullRequest(pullRequest).build();
    return createPullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreatePullRequestRequest request =
   *       CreatePullRequestRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPullRequest(PullRequest.newBuilder().build())
   *           .build();
   *   PullRequest response = secureSourceManagerClient.createPullRequestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> createPullRequestAsync(
      CreatePullRequestRequest request) {
    return createPullRequestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreatePullRequestRequest request =
   *       CreatePullRequestRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPullRequest(PullRequest.newBuilder().build())
   *           .build();
   *   OperationFuture<PullRequest, OperationMetadata> future =
   *       secureSourceManagerClient.createPullRequestOperationCallable().futureCall(request);
   *   // Do something.
   *   PullRequest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePullRequestRequest, PullRequest, OperationMetadata>
      createPullRequestOperationCallable() {
    return stub.createPullRequestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreatePullRequestRequest request =
   *       CreatePullRequestRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPullRequest(PullRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createPullRequestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePullRequestRequest, Operation> createPullRequestCallable() {
    return stub.createPullRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   PullRequest response = secureSourceManagerClient.getPullRequest(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the pull request to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/pullRequests/{pull_request}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullRequest getPullRequest(PullRequestName name) {
    GetPullRequestRequest request =
        GetPullRequestRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPullRequest(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   PullRequest response = secureSourceManagerClient.getPullRequest(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the pull request to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/pullRequests/{pull_request}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullRequest getPullRequest(String name) {
    GetPullRequestRequest request = GetPullRequestRequest.newBuilder().setName(name).build();
    return getPullRequest(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetPullRequestRequest request =
   *       GetPullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   PullRequest response = secureSourceManagerClient.getPullRequest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullRequest getPullRequest(GetPullRequestRequest request) {
    return getPullRequestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetPullRequestRequest request =
   *       GetPullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PullRequest> future =
   *       secureSourceManagerClient.getPullRequestCallable().futureCall(request);
   *   // Do something.
   *   PullRequest response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPullRequestRequest, PullRequest> getPullRequestCallable() {
    return stub.getPullRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull requests in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (PullRequest element : secureSourceManagerClient.listPullRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list pull requests. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestsPagedResponse listPullRequests(RepositoryName parent) {
    ListPullRequestsRequest request =
        ListPullRequestsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPullRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull requests in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (PullRequest element : secureSourceManagerClient.listPullRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list pull requests. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestsPagedResponse listPullRequests(String parent) {
    ListPullRequestsRequest request =
        ListPullRequestsRequest.newBuilder().setParent(parent).build();
    return listPullRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull requests in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestsRequest request =
   *       ListPullRequestsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PullRequest element : secureSourceManagerClient.listPullRequests(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestsPagedResponse listPullRequests(ListPullRequestsRequest request) {
    return listPullRequestsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull requests in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestsRequest request =
   *       ListPullRequestsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PullRequest> future =
   *       secureSourceManagerClient.listPullRequestsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PullRequest element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPullRequestsRequest, ListPullRequestsPagedResponse>
      listPullRequestsPagedCallable() {
    return stub.listPullRequestsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull requests in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestsRequest request =
   *       ListPullRequestsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPullRequestsResponse response =
   *         secureSourceManagerClient.listPullRequestsCallable().call(request);
   *     for (PullRequest element : response.getPullRequestsList()) {
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
  public final UnaryCallable<ListPullRequestsRequest, ListPullRequestsResponse>
      listPullRequestsCallable() {
    return stub.listPullRequestsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequest pullRequest = PullRequest.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PullRequest response =
   *       secureSourceManagerClient.updatePullRequestAsync(pullRequest, updateMask).get();
   * }
   * }</pre>
   *
   * @param pullRequest Required. The pull request to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     pull request resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask.
   *     The special value "&#42;" means full replacement.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> updatePullRequestAsync(
      PullRequest pullRequest, FieldMask updateMask) {
    UpdatePullRequestRequest request =
        UpdatePullRequestRequest.newBuilder()
            .setPullRequest(pullRequest)
            .setUpdateMask(updateMask)
            .build();
    return updatePullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdatePullRequestRequest request =
   *       UpdatePullRequestRequest.newBuilder()
   *           .setPullRequest(PullRequest.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PullRequest response = secureSourceManagerClient.updatePullRequestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> updatePullRequestAsync(
      UpdatePullRequestRequest request) {
    return updatePullRequestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdatePullRequestRequest request =
   *       UpdatePullRequestRequest.newBuilder()
   *           .setPullRequest(PullRequest.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<PullRequest, OperationMetadata> future =
   *       secureSourceManagerClient.updatePullRequestOperationCallable().futureCall(request);
   *   // Do something.
   *   PullRequest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePullRequestRequest, PullRequest, OperationMetadata>
      updatePullRequestOperationCallable() {
    return stub.updatePullRequestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdatePullRequestRequest request =
   *       UpdatePullRequestRequest.newBuilder()
   *           .setPullRequest(PullRequest.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.updatePullRequestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePullRequestRequest, Operation> updatePullRequestCallable() {
    return stub.updatePullRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   PullRequest response = secureSourceManagerClient.mergePullRequestAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The pull request to merge. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> mergePullRequestAsync(
      PullRequestName name) {
    MergePullRequestRequest request =
        MergePullRequestRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return mergePullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   PullRequest response = secureSourceManagerClient.mergePullRequestAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The pull request to merge. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> mergePullRequestAsync(String name) {
    MergePullRequestRequest request = MergePullRequestRequest.newBuilder().setName(name).build();
    return mergePullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   MergePullRequestRequest request =
   *       MergePullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   PullRequest response = secureSourceManagerClient.mergePullRequestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> mergePullRequestAsync(
      MergePullRequestRequest request) {
    return mergePullRequestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   MergePullRequestRequest request =
   *       MergePullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   OperationFuture<PullRequest, OperationMetadata> future =
   *       secureSourceManagerClient.mergePullRequestOperationCallable().futureCall(request);
   *   // Do something.
   *   PullRequest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<MergePullRequestRequest, PullRequest, OperationMetadata>
      mergePullRequestOperationCallable() {
    return stub.mergePullRequestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   MergePullRequestRequest request =
   *       MergePullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.mergePullRequestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MergePullRequestRequest, Operation> mergePullRequestCallable() {
    return stub.mergePullRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   PullRequest response = secureSourceManagerClient.openPullRequestAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The pull request to open. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> openPullRequestAsync(
      PullRequestName name) {
    OpenPullRequestRequest request =
        OpenPullRequestRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return openPullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   PullRequest response = secureSourceManagerClient.openPullRequestAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The pull request to open. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> openPullRequestAsync(String name) {
    OpenPullRequestRequest request = OpenPullRequestRequest.newBuilder().setName(name).build();
    return openPullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   OpenPullRequestRequest request =
   *       OpenPullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   PullRequest response = secureSourceManagerClient.openPullRequestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> openPullRequestAsync(
      OpenPullRequestRequest request) {
    return openPullRequestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   OpenPullRequestRequest request =
   *       OpenPullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   OperationFuture<PullRequest, OperationMetadata> future =
   *       secureSourceManagerClient.openPullRequestOperationCallable().futureCall(request);
   *   // Do something.
   *   PullRequest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<OpenPullRequestRequest, PullRequest, OperationMetadata>
      openPullRequestOperationCallable() {
    return stub.openPullRequestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens a pull request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   OpenPullRequestRequest request =
   *       OpenPullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.openPullRequestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<OpenPullRequestRequest, Operation> openPullRequestCallable() {
    return stub.openPullRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes a pull request without merging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   PullRequest response = secureSourceManagerClient.closePullRequestAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The pull request to close. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> closePullRequestAsync(
      PullRequestName name) {
    ClosePullRequestRequest request =
        ClosePullRequestRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return closePullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes a pull request without merging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   PullRequest response = secureSourceManagerClient.closePullRequestAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The pull request to close. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> closePullRequestAsync(String name) {
    ClosePullRequestRequest request = ClosePullRequestRequest.newBuilder().setName(name).build();
    return closePullRequestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes a pull request without merging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ClosePullRequestRequest request =
   *       ClosePullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   PullRequest response = secureSourceManagerClient.closePullRequestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequest, OperationMetadata> closePullRequestAsync(
      ClosePullRequestRequest request) {
    return closePullRequestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes a pull request without merging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ClosePullRequestRequest request =
   *       ClosePullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   OperationFuture<PullRequest, OperationMetadata> future =
   *       secureSourceManagerClient.closePullRequestOperationCallable().futureCall(request);
   *   // Do something.
   *   PullRequest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ClosePullRequestRequest, PullRequest, OperationMetadata>
      closePullRequestOperationCallable() {
    return stub.closePullRequestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes a pull request without merging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ClosePullRequestRequest request =
   *       ClosePullRequestRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.closePullRequestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ClosePullRequestRequest, Operation> closePullRequestCallable() {
    return stub.closePullRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a pull request's file diffs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   for (FileDiff element :
   *       secureSourceManagerClient.listPullRequestFileDiffs(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The pull request to list file diffs for. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestFileDiffsPagedResponse listPullRequestFileDiffs(
      PullRequestName name) {
    ListPullRequestFileDiffsRequest request =
        ListPullRequestFileDiffsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listPullRequestFileDiffs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a pull request's file diffs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   for (FileDiff element :
   *       secureSourceManagerClient.listPullRequestFileDiffs(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The pull request to list file diffs for. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestFileDiffsPagedResponse listPullRequestFileDiffs(String name) {
    ListPullRequestFileDiffsRequest request =
        ListPullRequestFileDiffsRequest.newBuilder().setName(name).build();
    return listPullRequestFileDiffs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a pull request's file diffs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestFileDiffsRequest request =
   *       ListPullRequestFileDiffsRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FileDiff element :
   *       secureSourceManagerClient.listPullRequestFileDiffs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestFileDiffsPagedResponse listPullRequestFileDiffs(
      ListPullRequestFileDiffsRequest request) {
    return listPullRequestFileDiffsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a pull request's file diffs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestFileDiffsRequest request =
   *       ListPullRequestFileDiffsRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FileDiff> future =
   *       secureSourceManagerClient.listPullRequestFileDiffsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FileDiff element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsPagedResponse>
      listPullRequestFileDiffsPagedCallable() {
    return stub.listPullRequestFileDiffsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a pull request's file diffs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestFileDiffsRequest request =
   *       ListPullRequestFileDiffsRequest.newBuilder()
   *           .setName(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPullRequestFileDiffsResponse response =
   *         secureSourceManagerClient.listPullRequestFileDiffsCallable().call(request);
   *     for (FileDiff element : response.getFileDiffsList()) {
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
  public final UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
      listPullRequestFileDiffsCallable() {
    return stub.listPullRequestFileDiffsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a tree from a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   FetchTreeRequest request =
   *       FetchTreeRequest.newBuilder()
   *           .setRepository(
   *               RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setRef("ref112787")
   *           .setRecursive(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TreeEntry element : secureSourceManagerClient.fetchTree(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchTreePagedResponse fetchTree(FetchTreeRequest request) {
    return fetchTreePagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a tree from a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   FetchTreeRequest request =
   *       FetchTreeRequest.newBuilder()
   *           .setRepository(
   *               RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setRef("ref112787")
   *           .setRecursive(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TreeEntry> future =
   *       secureSourceManagerClient.fetchTreePagedCallable().futureCall(request);
   *   // Do something.
   *   for (TreeEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchTreeRequest, FetchTreePagedResponse> fetchTreePagedCallable() {
    return stub.fetchTreePagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a tree from a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   FetchTreeRequest request =
   *       FetchTreeRequest.newBuilder()
   *           .setRepository(
   *               RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setRef("ref112787")
   *           .setRecursive(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchTreeResponse response = secureSourceManagerClient.fetchTreeCallable().call(request);
   *     for (TreeEntry element : response.getTreeEntriesList()) {
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
  public final UnaryCallable<FetchTreeRequest, FetchTreeResponse> fetchTreeCallable() {
    return stub.fetchTreeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a blob from a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   FetchBlobRequest request =
   *       FetchBlobRequest.newBuilder()
   *           .setRepository(
   *               RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setSha("sha113836")
   *           .build();
   *   FetchBlobResponse response = secureSourceManagerClient.fetchBlob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchBlobResponse fetchBlob(FetchBlobRequest request) {
    return fetchBlobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a blob from a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   FetchBlobRequest request =
   *       FetchBlobRequest.newBuilder()
   *           .setRepository(
   *               RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setSha("sha113836")
   *           .build();
   *   ApiFuture<FetchBlobResponse> future =
   *       secureSourceManagerClient.fetchBlobCallable().futureCall(request);
   *   // Do something.
   *   FetchBlobResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchBlobRequest, FetchBlobResponse> fetchBlobCallable() {
    return stub.fetchBlobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Issue issue = Issue.newBuilder().build();
   *   Issue response = secureSourceManagerClient.createIssueAsync(parent, issue).get();
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the issue. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @param issue Required. The issue to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> createIssueAsync(
      RepositoryName parent, Issue issue) {
    CreateIssueRequest request =
        CreateIssueRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIssue(issue)
            .build();
    return createIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Issue issue = Issue.newBuilder().build();
   *   Issue response = secureSourceManagerClient.createIssueAsync(parent, issue).get();
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the issue. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @param issue Required. The issue to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> createIssueAsync(
      String parent, Issue issue) {
    CreateIssueRequest request =
        CreateIssueRequest.newBuilder().setParent(parent).setIssue(issue).build();
    return createIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateIssueRequest request =
   *       CreateIssueRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setIssue(Issue.newBuilder().build())
   *           .build();
   *   Issue response = secureSourceManagerClient.createIssueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> createIssueAsync(
      CreateIssueRequest request) {
    return createIssueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateIssueRequest request =
   *       CreateIssueRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setIssue(Issue.newBuilder().build())
   *           .build();
   *   OperationFuture<Issue, OperationMetadata> future =
   *       secureSourceManagerClient.createIssueOperationCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIssueRequest, Issue, OperationMetadata>
      createIssueOperationCallable() {
    return stub.createIssueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateIssueRequest request =
   *       CreateIssueRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setIssue(Issue.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createIssueCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIssueRequest, Operation> createIssueCallable() {
    return stub.createIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
   *   Issue response = secureSourceManagerClient.getIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(IssueName name) {
    GetIssueRequest request =
        GetIssueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString();
   *   Issue response = secureSourceManagerClient.getIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(String name) {
    GetIssueRequest request = GetIssueRequest.newBuilder().setName(name).build();
    return getIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIssueRequest request =
   *       GetIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .build();
   *   Issue response = secureSourceManagerClient.getIssue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(GetIssueRequest request) {
    return getIssueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIssueRequest request =
   *       GetIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .build();
   *   ApiFuture<Issue> future = secureSourceManagerClient.getIssueCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    return stub.getIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (Issue element : secureSourceManagerClient.listIssues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list issues. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesPagedResponse listIssues(RepositoryName parent) {
    ListIssuesRequest request =
        ListIssuesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (Issue element : secureSourceManagerClient.listIssues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list issues. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesPagedResponse listIssues(String parent) {
    ListIssuesRequest request = ListIssuesRequest.newBuilder().setParent(parent).build();
    return listIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListIssuesRequest request =
   *       ListIssuesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Issue element : secureSourceManagerClient.listIssues(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesPagedResponse listIssues(ListIssuesRequest request) {
    return listIssuesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListIssuesRequest request =
   *       ListIssuesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Issue> future =
   *       secureSourceManagerClient.listIssuesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Issue element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIssuesRequest, ListIssuesPagedResponse> listIssuesPagedCallable() {
    return stub.listIssuesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues in a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListIssuesRequest request =
   *       ListIssuesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListIssuesResponse response = secureSourceManagerClient.listIssuesCallable().call(request);
   *     for (Issue element : response.getIssuesList()) {
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
  public final UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    return stub.listIssuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   Issue issue = Issue.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Issue response = secureSourceManagerClient.updateIssueAsync(issue, updateMask).get();
   * }
   * }</pre>
   *
   * @param issue Required. The issue to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     issue resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. The
   *     special value "&#42;" means full replacement.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> updateIssueAsync(
      Issue issue, FieldMask updateMask) {
    UpdateIssueRequest request =
        UpdateIssueRequest.newBuilder().setIssue(issue).setUpdateMask(updateMask).build();
    return updateIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateIssueRequest request =
   *       UpdateIssueRequest.newBuilder()
   *           .setIssue(Issue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Issue response = secureSourceManagerClient.updateIssueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> updateIssueAsync(
      UpdateIssueRequest request) {
    return updateIssueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateIssueRequest request =
   *       UpdateIssueRequest.newBuilder()
   *           .setIssue(Issue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Issue, OperationMetadata> future =
   *       secureSourceManagerClient.updateIssueOperationCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateIssueRequest, Issue, OperationMetadata>
      updateIssueOperationCallable() {
    return stub.updateIssueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateIssueRequest request =
   *       UpdateIssueRequest.newBuilder()
   *           .setIssue(Issue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.updateIssueCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIssueRequest, Operation> updateIssueCallable() {
    return stub.updateIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
   *   secureSourceManagerClient.deleteIssueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIssueAsync(IssueName name) {
    DeleteIssueRequest request =
        DeleteIssueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString();
   *   secureSourceManagerClient.deleteIssueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIssueAsync(String name) {
    DeleteIssueRequest request = DeleteIssueRequest.newBuilder().setName(name).build();
    return deleteIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteIssueRequest request =
   *       DeleteIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   secureSourceManagerClient.deleteIssueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIssueAsync(
      DeleteIssueRequest request) {
    return deleteIssueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteIssueRequest request =
   *       DeleteIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secureSourceManagerClient.deleteIssueOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIssueRequest, Empty, OperationMetadata>
      deleteIssueOperationCallable() {
    return stub.deleteIssueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteIssueRequest request =
   *       DeleteIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.deleteIssueCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIssueRequest, Operation> deleteIssueCallable() {
    return stub.deleteIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
   *   Issue response = secureSourceManagerClient.openIssueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to open. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> openIssueAsync(IssueName name) {
    OpenIssueRequest request =
        OpenIssueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return openIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString();
   *   Issue response = secureSourceManagerClient.openIssueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to open. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> openIssueAsync(String name) {
    OpenIssueRequest request = OpenIssueRequest.newBuilder().setName(name).build();
    return openIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   OpenIssueRequest request =
   *       OpenIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   Issue response = secureSourceManagerClient.openIssueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> openIssueAsync(OpenIssueRequest request) {
    return openIssueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   OpenIssueRequest request =
   *       OpenIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Issue, OperationMetadata> future =
   *       secureSourceManagerClient.openIssueOperationCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<OpenIssueRequest, Issue, OperationMetadata>
      openIssueOperationCallable() {
    return stub.openIssueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Opens an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   OpenIssueRequest request =
   *       OpenIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.openIssueCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<OpenIssueRequest, Operation> openIssueCallable() {
    return stub.openIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
   *   Issue response = secureSourceManagerClient.closeIssueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to close. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> closeIssueAsync(IssueName name) {
    CloseIssueRequest request =
        CloseIssueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return closeIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString();
   *   Issue response = secureSourceManagerClient.closeIssueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue to close. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> closeIssueAsync(String name) {
    CloseIssueRequest request = CloseIssueRequest.newBuilder().setName(name).build();
    return closeIssueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CloseIssueRequest request =
   *       CloseIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   Issue response = secureSourceManagerClient.closeIssueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Issue, OperationMetadata> closeIssueAsync(
      CloseIssueRequest request) {
    return closeIssueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CloseIssueRequest request =
   *       CloseIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Issue, OperationMetadata> future =
   *       secureSourceManagerClient.closeIssueOperationCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CloseIssueRequest, Issue, OperationMetadata>
      closeIssueOperationCallable() {
    return stub.closeIssueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Closes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CloseIssueRequest request =
   *       CloseIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.closeIssueCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CloseIssueRequest, Operation> closeIssueCallable() {
    return stub.closeIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestCommentName name =
   *       PullRequestCommentName.of(
   *           "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]");
   *   PullRequestComment response = secureSourceManagerClient.getPullRequestComment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the pull request comment to retrieve. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullRequestComment getPullRequestComment(PullRequestCommentName name) {
    GetPullRequestCommentRequest request =
        GetPullRequestCommentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPullRequestComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       PullRequestCommentName.of(
   *               "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
   *           .toString();
   *   PullRequestComment response = secureSourceManagerClient.getPullRequestComment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the pull request comment to retrieve. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullRequestComment getPullRequestComment(String name) {
    GetPullRequestCommentRequest request =
        GetPullRequestCommentRequest.newBuilder().setName(name).build();
    return getPullRequestComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetPullRequestCommentRequest request =
   *       GetPullRequestCommentRequest.newBuilder()
   *           .setName(
   *               PullRequestCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   PullRequestComment response = secureSourceManagerClient.getPullRequestComment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullRequestComment getPullRequestComment(GetPullRequestCommentRequest request) {
    return getPullRequestCommentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetPullRequestCommentRequest request =
   *       GetPullRequestCommentRequest.newBuilder()
   *           .setName(
   *               PullRequestCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PullRequestComment> future =
   *       secureSourceManagerClient.getPullRequestCommentCallable().futureCall(request);
   *   // Do something.
   *   PullRequestComment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentCallable() {
    return stub.getPullRequestCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull request comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   for (PullRequestComment element :
   *       secureSourceManagerClient.listPullRequestComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to list pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestCommentsPagedResponse listPullRequestComments(
      PullRequestName parent) {
    ListPullRequestCommentsRequest request =
        ListPullRequestCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPullRequestComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull request comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   for (PullRequestComment element :
   *       secureSourceManagerClient.listPullRequestComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to list pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestCommentsPagedResponse listPullRequestComments(String parent) {
    ListPullRequestCommentsRequest request =
        ListPullRequestCommentsRequest.newBuilder().setParent(parent).build();
    return listPullRequestComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull request comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestCommentsRequest request =
   *       ListPullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PullRequestComment element :
   *       secureSourceManagerClient.listPullRequestComments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPullRequestCommentsPagedResponse listPullRequestComments(
      ListPullRequestCommentsRequest request) {
    return listPullRequestCommentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull request comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestCommentsRequest request =
   *       ListPullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PullRequestComment> future =
   *       secureSourceManagerClient.listPullRequestCommentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PullRequestComment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsPagedResponse>
      listPullRequestCommentsPagedCallable() {
    return stub.listPullRequestCommentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists pull request comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListPullRequestCommentsRequest request =
   *       ListPullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPullRequestCommentsResponse response =
   *         secureSourceManagerClient.listPullRequestCommentsCallable().call(request);
   *     for (PullRequestComment element : response.getPullRequestCommentsList()) {
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
  public final UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
      listPullRequestCommentsCallable() {
    return stub.listPullRequestCommentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request comment. This function is used to create a single PullRequestComment of
   * type Comment, or a single PullRequestComment of type Code that's replying to another
   * PullRequestComment of type Code. Use BatchCreatePullRequestComments to create multiple
   * PullRequestComments for code reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();
   *   PullRequestComment response =
   *       secureSourceManagerClient.createPullRequestCommentAsync(parent, pullRequestComment).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to create the pull request comment. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param pullRequestComment Required. The pull request comment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequestComment, OperationMetadata> createPullRequestCommentAsync(
      PullRequestName parent, PullRequestComment pullRequestComment) {
    CreatePullRequestCommentRequest request =
        CreatePullRequestCommentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPullRequestComment(pullRequestComment)
            .build();
    return createPullRequestCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request comment. This function is used to create a single PullRequestComment of
   * type Comment, or a single PullRequestComment of type Code that's replying to another
   * PullRequestComment of type Code. Use BatchCreatePullRequestComments to create multiple
   * PullRequestComments for code reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();
   *   PullRequestComment response =
   *       secureSourceManagerClient.createPullRequestCommentAsync(parent, pullRequestComment).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to create the pull request comment. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param pullRequestComment Required. The pull request comment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequestComment, OperationMetadata> createPullRequestCommentAsync(
      String parent, PullRequestComment pullRequestComment) {
    CreatePullRequestCommentRequest request =
        CreatePullRequestCommentRequest.newBuilder()
            .setParent(parent)
            .setPullRequestComment(pullRequestComment)
            .build();
    return createPullRequestCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request comment. This function is used to create a single PullRequestComment of
   * type Comment, or a single PullRequestComment of type Code that's replying to another
   * PullRequestComment of type Code. Use BatchCreatePullRequestComments to create multiple
   * PullRequestComments for code reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreatePullRequestCommentRequest request =
   *       CreatePullRequestCommentRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPullRequestComment(PullRequestComment.newBuilder().build())
   *           .build();
   *   PullRequestComment response =
   *       secureSourceManagerClient.createPullRequestCommentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequestComment, OperationMetadata> createPullRequestCommentAsync(
      CreatePullRequestCommentRequest request) {
    return createPullRequestCommentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request comment. This function is used to create a single PullRequestComment of
   * type Comment, or a single PullRequestComment of type Code that's replying to another
   * PullRequestComment of type Code. Use BatchCreatePullRequestComments to create multiple
   * PullRequestComments for code reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreatePullRequestCommentRequest request =
   *       CreatePullRequestCommentRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPullRequestComment(PullRequestComment.newBuilder().build())
   *           .build();
   *   OperationFuture<PullRequestComment, OperationMetadata> future =
   *       secureSourceManagerClient.createPullRequestCommentOperationCallable().futureCall(request);
   *   // Do something.
   *   PullRequestComment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      createPullRequestCommentOperationCallable() {
    return stub.createPullRequestCommentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pull request comment. This function is used to create a single PullRequestComment of
   * type Comment, or a single PullRequestComment of type Code that's replying to another
   * PullRequestComment of type Code. Use BatchCreatePullRequestComments to create multiple
   * PullRequestComments for code reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreatePullRequestCommentRequest request =
   *       CreatePullRequestCommentRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .setPullRequestComment(PullRequestComment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createPullRequestCommentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentCallable() {
    return stub.createPullRequestCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PullRequestComment response =
   *       secureSourceManagerClient
   *           .updatePullRequestCommentAsync(pullRequestComment, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param pullRequestComment Required. The pull request comment to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     pull request comment resource by the update. Updatable fields are `body`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequestComment, OperationMetadata> updatePullRequestCommentAsync(
      PullRequestComment pullRequestComment, FieldMask updateMask) {
    UpdatePullRequestCommentRequest request =
        UpdatePullRequestCommentRequest.newBuilder()
            .setPullRequestComment(pullRequestComment)
            .setUpdateMask(updateMask)
            .build();
    return updatePullRequestCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdatePullRequestCommentRequest request =
   *       UpdatePullRequestCommentRequest.newBuilder()
   *           .setPullRequestComment(PullRequestComment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PullRequestComment response =
   *       secureSourceManagerClient.updatePullRequestCommentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PullRequestComment, OperationMetadata> updatePullRequestCommentAsync(
      UpdatePullRequestCommentRequest request) {
    return updatePullRequestCommentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdatePullRequestCommentRequest request =
   *       UpdatePullRequestCommentRequest.newBuilder()
   *           .setPullRequestComment(PullRequestComment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<PullRequestComment, OperationMetadata> future =
   *       secureSourceManagerClient.updatePullRequestCommentOperationCallable().futureCall(request);
   *   // Do something.
   *   PullRequestComment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      updatePullRequestCommentOperationCallable() {
    return stub.updatePullRequestCommentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdatePullRequestCommentRequest request =
   *       UpdatePullRequestCommentRequest.newBuilder()
   *           .setPullRequestComment(PullRequestComment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.updatePullRequestCommentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentCallable() {
    return stub.updatePullRequestCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestCommentName name =
   *       PullRequestCommentName.of(
   *           "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]");
   *   secureSourceManagerClient.deletePullRequestCommentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the pull request comment to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePullRequestCommentAsync(
      PullRequestCommentName name) {
    DeletePullRequestCommentRequest request =
        DeletePullRequestCommentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePullRequestCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       PullRequestCommentName.of(
   *               "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
   *           .toString();
   *   secureSourceManagerClient.deletePullRequestCommentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the pull request comment to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePullRequestCommentAsync(
      String name) {
    DeletePullRequestCommentRequest request =
        DeletePullRequestCommentRequest.newBuilder().setName(name).build();
    return deletePullRequestCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeletePullRequestCommentRequest request =
   *       DeletePullRequestCommentRequest.newBuilder()
   *           .setName(
   *               PullRequestCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   secureSourceManagerClient.deletePullRequestCommentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePullRequestCommentAsync(
      DeletePullRequestCommentRequest request) {
    return deletePullRequestCommentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeletePullRequestCommentRequest request =
   *       DeletePullRequestCommentRequest.newBuilder()
   *           .setName(
   *               PullRequestCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secureSourceManagerClient.deletePullRequestCommentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePullRequestCommentRequest, Empty, OperationMetadata>
      deletePullRequestCommentOperationCallable() {
    return stub.deletePullRequestCommentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pull request comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeletePullRequestCommentRequest request =
   *       DeletePullRequestCommentRequest.newBuilder()
   *           .setName(
   *               PullRequestCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.deletePullRequestCommentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentCallable() {
    return stub.deletePullRequestCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates pull request comments. This function is used to create multiple
   * PullRequestComments for code review. There needs to be exactly one PullRequestComment of type
   * Review, and at most 100 PullRequestComments of type Code per request. The Postition of the code
   * comments must be unique within the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   List<CreatePullRequestCommentRequest> requests = new ArrayList<>();
   *   BatchCreatePullRequestCommentsResponse response =
   *       secureSourceManagerClient.batchCreatePullRequestCommentsAsync(parent, requests).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to create the pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param requests Required. The request message specifying the resources to create. There should
   *     be exactly one CreatePullRequestCommentRequest with CommentDetail being REVIEW in the list,
   *     and no more than 100 CreatePullRequestCommentRequests with CommentDetail being CODE in the
   *     list
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchCreatePullRequestCommentsResponse, OperationMetadata>
      batchCreatePullRequestCommentsAsync(
          PullRequestName parent, List<CreatePullRequestCommentRequest> requests) {
    BatchCreatePullRequestCommentsRequest request =
        BatchCreatePullRequestCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreatePullRequestCommentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates pull request comments. This function is used to create multiple
   * PullRequestComments for code review. There needs to be exactly one PullRequestComment of type
   * Review, and at most 100 PullRequestComments of type Code per request. The Postition of the code
   * comments must be unique within the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   List<CreatePullRequestCommentRequest> requests = new ArrayList<>();
   *   BatchCreatePullRequestCommentsResponse response =
   *       secureSourceManagerClient.batchCreatePullRequestCommentsAsync(parent, requests).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to create the pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param requests Required. The request message specifying the resources to create. There should
   *     be exactly one CreatePullRequestCommentRequest with CommentDetail being REVIEW in the list,
   *     and no more than 100 CreatePullRequestCommentRequests with CommentDetail being CODE in the
   *     list
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchCreatePullRequestCommentsResponse, OperationMetadata>
      batchCreatePullRequestCommentsAsync(
          String parent, List<CreatePullRequestCommentRequest> requests) {
    BatchCreatePullRequestCommentsRequest request =
        BatchCreatePullRequestCommentsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreatePullRequestCommentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates pull request comments. This function is used to create multiple
   * PullRequestComments for code review. There needs to be exactly one PullRequestComment of type
   * Review, and at most 100 PullRequestComments of type Code per request. The Postition of the code
   * comments must be unique within the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   BatchCreatePullRequestCommentsRequest request =
   *       BatchCreatePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreatePullRequestCommentRequest>())
   *           .build();
   *   BatchCreatePullRequestCommentsResponse response =
   *       secureSourceManagerClient.batchCreatePullRequestCommentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchCreatePullRequestCommentsResponse, OperationMetadata>
      batchCreatePullRequestCommentsAsync(BatchCreatePullRequestCommentsRequest request) {
    return batchCreatePullRequestCommentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates pull request comments. This function is used to create multiple
   * PullRequestComments for code review. There needs to be exactly one PullRequestComment of type
   * Review, and at most 100 PullRequestComments of type Code per request. The Postition of the code
   * comments must be unique within the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   BatchCreatePullRequestCommentsRequest request =
   *       BatchCreatePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreatePullRequestCommentRequest>())
   *           .build();
   *   OperationFuture<BatchCreatePullRequestCommentsResponse, OperationMetadata> future =
   *       secureSourceManagerClient
   *           .batchCreatePullRequestCommentsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreatePullRequestCommentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchCreatePullRequestCommentsRequest,
          BatchCreatePullRequestCommentsResponse,
          OperationMetadata>
      batchCreatePullRequestCommentsOperationCallable() {
    return stub.batchCreatePullRequestCommentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates pull request comments. This function is used to create multiple
   * PullRequestComments for code review. There needs to be exactly one PullRequestComment of type
   * Review, and at most 100 PullRequestComments of type Code per request. The Postition of the code
   * comments must be unique within the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   BatchCreatePullRequestCommentsRequest request =
   *       BatchCreatePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreatePullRequestCommentRequest>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.batchCreatePullRequestCommentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsCallable() {
    return stub.batchCreatePullRequestCommentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be resolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   List<String> names = new ArrayList<>();
   *   ResolvePullRequestCommentsResponse response =
   *       secureSourceManagerClient.resolvePullRequestCommentsAsync(parent, names).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to resolve the pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param names Required. The names of the pull request comments to resolve. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`
   *     Only comments from the same threads are allowed in the same request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsAsync(PullRequestName parent, List<String> names) {
    ResolvePullRequestCommentsRequest request =
        ResolvePullRequestCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return resolvePullRequestCommentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be resolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   List<String> names = new ArrayList<>();
   *   ResolvePullRequestCommentsResponse response =
   *       secureSourceManagerClient.resolvePullRequestCommentsAsync(parent, names).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to resolve the pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param names Required. The names of the pull request comments to resolve. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`
   *     Only comments from the same threads are allowed in the same request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsAsync(String parent, List<String> names) {
    ResolvePullRequestCommentsRequest request =
        ResolvePullRequestCommentsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return resolvePullRequestCommentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be resolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ResolvePullRequestCommentsRequest request =
   *       ResolvePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAutoFill(true)
   *           .build();
   *   ResolvePullRequestCommentsResponse response =
   *       secureSourceManagerClient.resolvePullRequestCommentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsAsync(ResolvePullRequestCommentsRequest request) {
    return resolvePullRequestCommentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be resolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ResolvePullRequestCommentsRequest request =
   *       ResolvePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAutoFill(true)
   *           .build();
   *   OperationFuture<ResolvePullRequestCommentsResponse, OperationMetadata> future =
   *       secureSourceManagerClient
   *           .resolvePullRequestCommentsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ResolvePullRequestCommentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ResolvePullRequestCommentsRequest, ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsOperationCallable() {
    return stub.resolvePullRequestCommentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be resolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ResolvePullRequestCommentsRequest request =
   *       ResolvePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAutoFill(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.resolvePullRequestCommentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsCallable() {
    return stub.resolvePullRequestCommentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unresolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be unresolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   PullRequestName parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
   *   List<String> names = new ArrayList<>();
   *   UnresolvePullRequestCommentsResponse response =
   *       secureSourceManagerClient.unresolvePullRequestCommentsAsync(parent, names).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to resolve the pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param names Required. The names of the pull request comments to unresolve. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`
   *     Only comments from the same threads are allowed in the same request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UnresolvePullRequestCommentsResponse, OperationMetadata>
      unresolvePullRequestCommentsAsync(PullRequestName parent, List<String> names) {
    UnresolvePullRequestCommentsRequest request =
        UnresolvePullRequestCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return unresolvePullRequestCommentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unresolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be unresolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent =
   *       PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *           .toString();
   *   List<String> names = new ArrayList<>();
   *   UnresolvePullRequestCommentsResponse response =
   *       secureSourceManagerClient.unresolvePullRequestCommentsAsync(parent, names).get();
   * }
   * }</pre>
   *
   * @param parent Required. The pull request in which to resolve the pull request comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}`
   * @param names Required. The names of the pull request comments to unresolve. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/pullRequests/{pull_request_id}/pullRequestComments/{comment_id}`
   *     Only comments from the same threads are allowed in the same request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UnresolvePullRequestCommentsResponse, OperationMetadata>
      unresolvePullRequestCommentsAsync(String parent, List<String> names) {
    UnresolvePullRequestCommentsRequest request =
        UnresolvePullRequestCommentsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return unresolvePullRequestCommentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unresolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be unresolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UnresolvePullRequestCommentsRequest request =
   *       UnresolvePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAutoFill(true)
   *           .build();
   *   UnresolvePullRequestCommentsResponse response =
   *       secureSourceManagerClient.unresolvePullRequestCommentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UnresolvePullRequestCommentsResponse, OperationMetadata>
      unresolvePullRequestCommentsAsync(UnresolvePullRequestCommentsRequest request) {
    return unresolvePullRequestCommentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unresolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be unresolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UnresolvePullRequestCommentsRequest request =
   *       UnresolvePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAutoFill(true)
   *           .build();
   *   OperationFuture<UnresolvePullRequestCommentsResponse, OperationMetadata> future =
   *       secureSourceManagerClient
   *           .unresolvePullRequestCommentsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   UnresolvePullRequestCommentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UnresolvePullRequestCommentsRequest,
          UnresolvePullRequestCommentsResponse,
          OperationMetadata>
      unresolvePullRequestCommentsOperationCallable() {
    return stub.unresolvePullRequestCommentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unresolves pull request comments. A list of PullRequestComment names must be provided. The
   * PullRequestComment names must be in the same conversation thread. If auto_fill is set, all
   * comments in the conversation thread will be unresolved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UnresolvePullRequestCommentsRequest request =
   *       UnresolvePullRequestCommentsRequest.newBuilder()
   *           .setParent(
   *               PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAutoFill(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.unresolvePullRequestCommentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsCallable() {
    return stub.unresolvePullRequestCommentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueName parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
   *   IssueComment issueComment = IssueComment.newBuilder().build();
   *   IssueComment response =
   *       secureSourceManagerClient.createIssueCommentAsync(parent, issueComment).get();
   * }
   * }</pre>
   *
   * @param parent Required. The issue in which to create the issue comment. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`
   * @param issueComment Required. The issue comment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueComment, OperationMetadata> createIssueCommentAsync(
      IssueName parent, IssueComment issueComment) {
    CreateIssueCommentRequest request =
        CreateIssueCommentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIssueComment(issueComment)
            .build();
    return createIssueCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString();
   *   IssueComment issueComment = IssueComment.newBuilder().build();
   *   IssueComment response =
   *       secureSourceManagerClient.createIssueCommentAsync(parent, issueComment).get();
   * }
   * }</pre>
   *
   * @param parent Required. The issue in which to create the issue comment. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`
   * @param issueComment Required. The issue comment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueComment, OperationMetadata> createIssueCommentAsync(
      String parent, IssueComment issueComment) {
    CreateIssueCommentRequest request =
        CreateIssueCommentRequest.newBuilder()
            .setParent(parent)
            .setIssueComment(issueComment)
            .build();
    return createIssueCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateIssueCommentRequest request =
   *       CreateIssueCommentRequest.newBuilder()
   *           .setParent(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setIssueComment(IssueComment.newBuilder().build())
   *           .build();
   *   IssueComment response = secureSourceManagerClient.createIssueCommentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueComment, OperationMetadata> createIssueCommentAsync(
      CreateIssueCommentRequest request) {
    return createIssueCommentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateIssueCommentRequest request =
   *       CreateIssueCommentRequest.newBuilder()
   *           .setParent(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setIssueComment(IssueComment.newBuilder().build())
   *           .build();
   *   OperationFuture<IssueComment, OperationMetadata> future =
   *       secureSourceManagerClient.createIssueCommentOperationCallable().futureCall(request);
   *   // Do something.
   *   IssueComment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIssueCommentRequest, IssueComment, OperationMetadata>
      createIssueCommentOperationCallable() {
    return stub.createIssueCommentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   CreateIssueCommentRequest request =
   *       CreateIssueCommentRequest.newBuilder()
   *           .setParent(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setIssueComment(IssueComment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.createIssueCommentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIssueCommentRequest, Operation> createIssueCommentCallable() {
    return stub.createIssueCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueCommentName name =
   *       IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]");
   *   IssueComment response = secureSourceManagerClient.getIssueComment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue comment to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/issues/{issue_id}/issueComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueComment getIssueComment(IssueCommentName name) {
    GetIssueCommentRequest request =
        GetIssueCommentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIssueComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
   *           .toString();
   *   IssueComment response = secureSourceManagerClient.getIssueComment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue comment to retrieve. The format is
   *     `projects/{project}/locations/{location}/repositories/{repository}/issues/{issue_id}/issueComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueComment getIssueComment(String name) {
    GetIssueCommentRequest request = GetIssueCommentRequest.newBuilder().setName(name).build();
    return getIssueComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIssueCommentRequest request =
   *       GetIssueCommentRequest.newBuilder()
   *           .setName(
   *               IssueCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   IssueComment response = secureSourceManagerClient.getIssueComment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueComment getIssueComment(GetIssueCommentRequest request) {
    return getIssueCommentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIssueCommentRequest request =
   *       GetIssueCommentRequest.newBuilder()
   *           .setName(
   *               IssueCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<IssueComment> future =
   *       secureSourceManagerClient.getIssueCommentCallable().futureCall(request);
   *   // Do something.
   *   IssueComment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIssueCommentRequest, IssueComment> getIssueCommentCallable() {
    return stub.getIssueCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists comments in an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueName parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
   *   for (IssueComment element :
   *       secureSourceManagerClient.listIssueComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The issue in which to list the comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueCommentsPagedResponse listIssueComments(IssueName parent) {
    ListIssueCommentsRequest request =
        ListIssueCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIssueComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists comments in an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString();
   *   for (IssueComment element :
   *       secureSourceManagerClient.listIssueComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The issue in which to list the comments. Format:
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueCommentsPagedResponse listIssueComments(String parent) {
    ListIssueCommentsRequest request =
        ListIssueCommentsRequest.newBuilder().setParent(parent).build();
    return listIssueComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists comments in an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListIssueCommentsRequest request =
   *       ListIssueCommentsRequest.newBuilder()
   *           .setParent(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (IssueComment element :
   *       secureSourceManagerClient.listIssueComments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueCommentsPagedResponse listIssueComments(ListIssueCommentsRequest request) {
    return listIssueCommentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists comments in an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListIssueCommentsRequest request =
   *       ListIssueCommentsRequest.newBuilder()
   *           .setParent(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<IssueComment> future =
   *       secureSourceManagerClient.listIssueCommentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IssueComment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsPagedResponse>
      listIssueCommentsPagedCallable() {
    return stub.listIssueCommentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists comments in an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListIssueCommentsRequest request =
   *       ListIssueCommentsRequest.newBuilder()
   *           .setParent(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIssueCommentsResponse response =
   *         secureSourceManagerClient.listIssueCommentsCallable().call(request);
   *     for (IssueComment element : response.getIssueCommentsList()) {
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
  public final UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsResponse>
      listIssueCommentsCallable() {
    return stub.listIssueCommentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueComment issueComment = IssueComment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IssueComment response =
   *       secureSourceManagerClient.updateIssueCommentAsync(issueComment, updateMask).get();
   * }
   * }</pre>
   *
   * @param issueComment Required. The issue comment to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     issue comment resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask.
   *     The special value "&#42;" means full replacement.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueComment, OperationMetadata> updateIssueCommentAsync(
      IssueComment issueComment, FieldMask updateMask) {
    UpdateIssueCommentRequest request =
        UpdateIssueCommentRequest.newBuilder()
            .setIssueComment(issueComment)
            .setUpdateMask(updateMask)
            .build();
    return updateIssueCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateIssueCommentRequest request =
   *       UpdateIssueCommentRequest.newBuilder()
   *           .setIssueComment(IssueComment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IssueComment response = secureSourceManagerClient.updateIssueCommentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueComment, OperationMetadata> updateIssueCommentAsync(
      UpdateIssueCommentRequest request) {
    return updateIssueCommentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateIssueCommentRequest request =
   *       UpdateIssueCommentRequest.newBuilder()
   *           .setIssueComment(IssueComment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<IssueComment, OperationMetadata> future =
   *       secureSourceManagerClient.updateIssueCommentOperationCallable().futureCall(request);
   *   // Do something.
   *   IssueComment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
      updateIssueCommentOperationCallable() {
    return stub.updateIssueCommentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   UpdateIssueCommentRequest request =
   *       UpdateIssueCommentRequest.newBuilder()
   *           .setIssueComment(IssueComment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.updateIssueCommentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIssueCommentRequest, Operation> updateIssueCommentCallable() {
    return stub.updateIssueCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   IssueCommentName name =
   *       IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]");
   *   secureSourceManagerClient.deleteIssueCommentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue comment to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}/issueComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIssueCommentAsync(
      IssueCommentName name) {
    DeleteIssueCommentRequest request =
        DeleteIssueCommentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteIssueCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   String name =
   *       IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
   *           .toString();
   *   secureSourceManagerClient.deleteIssueCommentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the issue comment to delete. The format is
   *     `projects/{project_number}/locations/{location_id}/repositories/{repository_id}/issues/{issue_id}/issueComments/{comment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIssueCommentAsync(String name) {
    DeleteIssueCommentRequest request =
        DeleteIssueCommentRequest.newBuilder().setName(name).build();
    return deleteIssueCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteIssueCommentRequest request =
   *       DeleteIssueCommentRequest.newBuilder()
   *           .setName(
   *               IssueCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   secureSourceManagerClient.deleteIssueCommentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIssueCommentAsync(
      DeleteIssueCommentRequest request) {
    return deleteIssueCommentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteIssueCommentRequest request =
   *       DeleteIssueCommentRequest.newBuilder()
   *           .setName(
   *               IssueCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secureSourceManagerClient.deleteIssueCommentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIssueCommentRequest, Empty, OperationMetadata>
      deleteIssueCommentOperationCallable() {
    return stub.deleteIssueCommentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   DeleteIssueCommentRequest request =
   *       DeleteIssueCommentRequest.newBuilder()
   *           .setName(
   *               IssueCommentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secureSourceManagerClient.deleteIssueCommentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIssueCommentRequest, Operation> deleteIssueCommentCallable() {
    return stub.deleteIssueCommentCallable();
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : secureSourceManagerClient.listLocations(request).iterateAll()) {
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       secureSourceManagerClient.listLocationsPagedCallable().futureCall(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         secureSourceManagerClient.listLocationsCallable().call(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = secureSourceManagerClient.getLocation(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       secureSourceManagerClient.getLocationCallable().futureCall(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = secureSourceManagerClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       secureSourceManagerClient.setIamPolicyCallable().futureCall(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = secureSourceManagerClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       secureSourceManagerClient.getIamPolicyCallable().futureCall(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = secureSourceManagerClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
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
   * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       secureSourceManagerClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRepositoriesPagedResponse
      extends AbstractPagedListResponse<
          ListRepositoriesRequest,
          ListRepositoriesResponse,
          Repository,
          ListRepositoriesPage,
          ListRepositoriesFixedSizeCollection> {

    public static ApiFuture<ListRepositoriesPagedResponse> createAsync(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ApiFuture<ListRepositoriesResponse> futureResponse) {
      ApiFuture<ListRepositoriesPage> futurePage =
          ListRepositoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRepositoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRepositoriesPagedResponse(ListRepositoriesPage page) {
      super(page, ListRepositoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRepositoriesPage
      extends AbstractPage<
          ListRepositoriesRequest, ListRepositoriesResponse, Repository, ListRepositoriesPage> {

    private ListRepositoriesPage(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ListRepositoriesResponse response) {
      super(context, response);
    }

    private static ListRepositoriesPage createEmptyPage() {
      return new ListRepositoriesPage(null, null);
    }

    @Override
    protected ListRepositoriesPage createPage(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ListRepositoriesResponse response) {
      return new ListRepositoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListRepositoriesPage> createPageAsync(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ApiFuture<ListRepositoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRepositoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRepositoriesRequest,
          ListRepositoriesResponse,
          Repository,
          ListRepositoriesPage,
          ListRepositoriesFixedSizeCollection> {

    private ListRepositoriesFixedSizeCollection(
        List<ListRepositoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRepositoriesFixedSizeCollection createEmptyCollection() {
      return new ListRepositoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRepositoriesFixedSizeCollection createCollection(
        List<ListRepositoriesPage> pages, int collectionSize) {
      return new ListRepositoriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHooksPagedResponse
      extends AbstractPagedListResponse<
          ListHooksRequest, ListHooksResponse, Hook, ListHooksPage, ListHooksFixedSizeCollection> {

    public static ApiFuture<ListHooksPagedResponse> createAsync(
        PageContext<ListHooksRequest, ListHooksResponse, Hook> context,
        ApiFuture<ListHooksResponse> futureResponse) {
      ApiFuture<ListHooksPage> futurePage =
          ListHooksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListHooksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListHooksPagedResponse(ListHooksPage page) {
      super(page, ListHooksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHooksPage
      extends AbstractPage<ListHooksRequest, ListHooksResponse, Hook, ListHooksPage> {

    private ListHooksPage(
        PageContext<ListHooksRequest, ListHooksResponse, Hook> context,
        ListHooksResponse response) {
      super(context, response);
    }

    private static ListHooksPage createEmptyPage() {
      return new ListHooksPage(null, null);
    }

    @Override
    protected ListHooksPage createPage(
        PageContext<ListHooksRequest, ListHooksResponse, Hook> context,
        ListHooksResponse response) {
      return new ListHooksPage(context, response);
    }

    @Override
    public ApiFuture<ListHooksPage> createPageAsync(
        PageContext<ListHooksRequest, ListHooksResponse, Hook> context,
        ApiFuture<ListHooksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHooksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHooksRequest, ListHooksResponse, Hook, ListHooksPage, ListHooksFixedSizeCollection> {

    private ListHooksFixedSizeCollection(List<ListHooksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHooksFixedSizeCollection createEmptyCollection() {
      return new ListHooksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHooksFixedSizeCollection createCollection(
        List<ListHooksPage> pages, int collectionSize) {
      return new ListHooksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBranchRulesPagedResponse
      extends AbstractPagedListResponse<
          ListBranchRulesRequest,
          ListBranchRulesResponse,
          BranchRule,
          ListBranchRulesPage,
          ListBranchRulesFixedSizeCollection> {

    public static ApiFuture<ListBranchRulesPagedResponse> createAsync(
        PageContext<ListBranchRulesRequest, ListBranchRulesResponse, BranchRule> context,
        ApiFuture<ListBranchRulesResponse> futureResponse) {
      ApiFuture<ListBranchRulesPage> futurePage =
          ListBranchRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBranchRulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBranchRulesPagedResponse(ListBranchRulesPage page) {
      super(page, ListBranchRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBranchRulesPage
      extends AbstractPage<
          ListBranchRulesRequest, ListBranchRulesResponse, BranchRule, ListBranchRulesPage> {

    private ListBranchRulesPage(
        PageContext<ListBranchRulesRequest, ListBranchRulesResponse, BranchRule> context,
        ListBranchRulesResponse response) {
      super(context, response);
    }

    private static ListBranchRulesPage createEmptyPage() {
      return new ListBranchRulesPage(null, null);
    }

    @Override
    protected ListBranchRulesPage createPage(
        PageContext<ListBranchRulesRequest, ListBranchRulesResponse, BranchRule> context,
        ListBranchRulesResponse response) {
      return new ListBranchRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListBranchRulesPage> createPageAsync(
        PageContext<ListBranchRulesRequest, ListBranchRulesResponse, BranchRule> context,
        ApiFuture<ListBranchRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBranchRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBranchRulesRequest,
          ListBranchRulesResponse,
          BranchRule,
          ListBranchRulesPage,
          ListBranchRulesFixedSizeCollection> {

    private ListBranchRulesFixedSizeCollection(
        List<ListBranchRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBranchRulesFixedSizeCollection createEmptyCollection() {
      return new ListBranchRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBranchRulesFixedSizeCollection createCollection(
        List<ListBranchRulesPage> pages, int collectionSize) {
      return new ListBranchRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPullRequestsPagedResponse
      extends AbstractPagedListResponse<
          ListPullRequestsRequest,
          ListPullRequestsResponse,
          PullRequest,
          ListPullRequestsPage,
          ListPullRequestsFixedSizeCollection> {

    public static ApiFuture<ListPullRequestsPagedResponse> createAsync(
        PageContext<ListPullRequestsRequest, ListPullRequestsResponse, PullRequest> context,
        ApiFuture<ListPullRequestsResponse> futureResponse) {
      ApiFuture<ListPullRequestsPage> futurePage =
          ListPullRequestsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPullRequestsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPullRequestsPagedResponse(ListPullRequestsPage page) {
      super(page, ListPullRequestsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPullRequestsPage
      extends AbstractPage<
          ListPullRequestsRequest, ListPullRequestsResponse, PullRequest, ListPullRequestsPage> {

    private ListPullRequestsPage(
        PageContext<ListPullRequestsRequest, ListPullRequestsResponse, PullRequest> context,
        ListPullRequestsResponse response) {
      super(context, response);
    }

    private static ListPullRequestsPage createEmptyPage() {
      return new ListPullRequestsPage(null, null);
    }

    @Override
    protected ListPullRequestsPage createPage(
        PageContext<ListPullRequestsRequest, ListPullRequestsResponse, PullRequest> context,
        ListPullRequestsResponse response) {
      return new ListPullRequestsPage(context, response);
    }

    @Override
    public ApiFuture<ListPullRequestsPage> createPageAsync(
        PageContext<ListPullRequestsRequest, ListPullRequestsResponse, PullRequest> context,
        ApiFuture<ListPullRequestsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPullRequestsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPullRequestsRequest,
          ListPullRequestsResponse,
          PullRequest,
          ListPullRequestsPage,
          ListPullRequestsFixedSizeCollection> {

    private ListPullRequestsFixedSizeCollection(
        List<ListPullRequestsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPullRequestsFixedSizeCollection createEmptyCollection() {
      return new ListPullRequestsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPullRequestsFixedSizeCollection createCollection(
        List<ListPullRequestsPage> pages, int collectionSize) {
      return new ListPullRequestsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPullRequestFileDiffsPagedResponse
      extends AbstractPagedListResponse<
          ListPullRequestFileDiffsRequest,
          ListPullRequestFileDiffsResponse,
          FileDiff,
          ListPullRequestFileDiffsPage,
          ListPullRequestFileDiffsFixedSizeCollection> {

    public static ApiFuture<ListPullRequestFileDiffsPagedResponse> createAsync(
        PageContext<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse, FileDiff>
            context,
        ApiFuture<ListPullRequestFileDiffsResponse> futureResponse) {
      ApiFuture<ListPullRequestFileDiffsPage> futurePage =
          ListPullRequestFileDiffsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPullRequestFileDiffsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPullRequestFileDiffsPagedResponse(ListPullRequestFileDiffsPage page) {
      super(page, ListPullRequestFileDiffsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPullRequestFileDiffsPage
      extends AbstractPage<
          ListPullRequestFileDiffsRequest,
          ListPullRequestFileDiffsResponse,
          FileDiff,
          ListPullRequestFileDiffsPage> {

    private ListPullRequestFileDiffsPage(
        PageContext<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse, FileDiff>
            context,
        ListPullRequestFileDiffsResponse response) {
      super(context, response);
    }

    private static ListPullRequestFileDiffsPage createEmptyPage() {
      return new ListPullRequestFileDiffsPage(null, null);
    }

    @Override
    protected ListPullRequestFileDiffsPage createPage(
        PageContext<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse, FileDiff>
            context,
        ListPullRequestFileDiffsResponse response) {
      return new ListPullRequestFileDiffsPage(context, response);
    }

    @Override
    public ApiFuture<ListPullRequestFileDiffsPage> createPageAsync(
        PageContext<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse, FileDiff>
            context,
        ApiFuture<ListPullRequestFileDiffsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPullRequestFileDiffsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPullRequestFileDiffsRequest,
          ListPullRequestFileDiffsResponse,
          FileDiff,
          ListPullRequestFileDiffsPage,
          ListPullRequestFileDiffsFixedSizeCollection> {

    private ListPullRequestFileDiffsFixedSizeCollection(
        List<ListPullRequestFileDiffsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPullRequestFileDiffsFixedSizeCollection createEmptyCollection() {
      return new ListPullRequestFileDiffsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPullRequestFileDiffsFixedSizeCollection createCollection(
        List<ListPullRequestFileDiffsPage> pages, int collectionSize) {
      return new ListPullRequestFileDiffsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchTreePagedResponse
      extends AbstractPagedListResponse<
          FetchTreeRequest,
          FetchTreeResponse,
          TreeEntry,
          FetchTreePage,
          FetchTreeFixedSizeCollection> {

    public static ApiFuture<FetchTreePagedResponse> createAsync(
        PageContext<FetchTreeRequest, FetchTreeResponse, TreeEntry> context,
        ApiFuture<FetchTreeResponse> futureResponse) {
      ApiFuture<FetchTreePage> futurePage =
          FetchTreePage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new FetchTreePagedResponse(input), MoreExecutors.directExecutor());
    }

    private FetchTreePagedResponse(FetchTreePage page) {
      super(page, FetchTreeFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchTreePage
      extends AbstractPage<FetchTreeRequest, FetchTreeResponse, TreeEntry, FetchTreePage> {

    private FetchTreePage(
        PageContext<FetchTreeRequest, FetchTreeResponse, TreeEntry> context,
        FetchTreeResponse response) {
      super(context, response);
    }

    private static FetchTreePage createEmptyPage() {
      return new FetchTreePage(null, null);
    }

    @Override
    protected FetchTreePage createPage(
        PageContext<FetchTreeRequest, FetchTreeResponse, TreeEntry> context,
        FetchTreeResponse response) {
      return new FetchTreePage(context, response);
    }

    @Override
    public ApiFuture<FetchTreePage> createPageAsync(
        PageContext<FetchTreeRequest, FetchTreeResponse, TreeEntry> context,
        ApiFuture<FetchTreeResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchTreeFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchTreeRequest,
          FetchTreeResponse,
          TreeEntry,
          FetchTreePage,
          FetchTreeFixedSizeCollection> {

    private FetchTreeFixedSizeCollection(List<FetchTreePage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchTreeFixedSizeCollection createEmptyCollection() {
      return new FetchTreeFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchTreeFixedSizeCollection createCollection(
        List<FetchTreePage> pages, int collectionSize) {
      return new FetchTreeFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListIssuesPagedResponse
      extends AbstractPagedListResponse<
          ListIssuesRequest,
          ListIssuesResponse,
          Issue,
          ListIssuesPage,
          ListIssuesFixedSizeCollection> {

    public static ApiFuture<ListIssuesPagedResponse> createAsync(
        PageContext<ListIssuesRequest, ListIssuesResponse, Issue> context,
        ApiFuture<ListIssuesResponse> futureResponse) {
      ApiFuture<ListIssuesPage> futurePage =
          ListIssuesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListIssuesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListIssuesPagedResponse(ListIssuesPage page) {
      super(page, ListIssuesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIssuesPage
      extends AbstractPage<ListIssuesRequest, ListIssuesResponse, Issue, ListIssuesPage> {

    private ListIssuesPage(
        PageContext<ListIssuesRequest, ListIssuesResponse, Issue> context,
        ListIssuesResponse response) {
      super(context, response);
    }

    private static ListIssuesPage createEmptyPage() {
      return new ListIssuesPage(null, null);
    }

    @Override
    protected ListIssuesPage createPage(
        PageContext<ListIssuesRequest, ListIssuesResponse, Issue> context,
        ListIssuesResponse response) {
      return new ListIssuesPage(context, response);
    }

    @Override
    public ApiFuture<ListIssuesPage> createPageAsync(
        PageContext<ListIssuesRequest, ListIssuesResponse, Issue> context,
        ApiFuture<ListIssuesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIssuesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIssuesRequest,
          ListIssuesResponse,
          Issue,
          ListIssuesPage,
          ListIssuesFixedSizeCollection> {

    private ListIssuesFixedSizeCollection(List<ListIssuesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIssuesFixedSizeCollection createEmptyCollection() {
      return new ListIssuesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIssuesFixedSizeCollection createCollection(
        List<ListIssuesPage> pages, int collectionSize) {
      return new ListIssuesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPullRequestCommentsPagedResponse
      extends AbstractPagedListResponse<
          ListPullRequestCommentsRequest,
          ListPullRequestCommentsResponse,
          PullRequestComment,
          ListPullRequestCommentsPage,
          ListPullRequestCommentsFixedSizeCollection> {

    public static ApiFuture<ListPullRequestCommentsPagedResponse> createAsync(
        PageContext<
                ListPullRequestCommentsRequest, ListPullRequestCommentsResponse, PullRequestComment>
            context,
        ApiFuture<ListPullRequestCommentsResponse> futureResponse) {
      ApiFuture<ListPullRequestCommentsPage> futurePage =
          ListPullRequestCommentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPullRequestCommentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPullRequestCommentsPagedResponse(ListPullRequestCommentsPage page) {
      super(page, ListPullRequestCommentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPullRequestCommentsPage
      extends AbstractPage<
          ListPullRequestCommentsRequest,
          ListPullRequestCommentsResponse,
          PullRequestComment,
          ListPullRequestCommentsPage> {

    private ListPullRequestCommentsPage(
        PageContext<
                ListPullRequestCommentsRequest, ListPullRequestCommentsResponse, PullRequestComment>
            context,
        ListPullRequestCommentsResponse response) {
      super(context, response);
    }

    private static ListPullRequestCommentsPage createEmptyPage() {
      return new ListPullRequestCommentsPage(null, null);
    }

    @Override
    protected ListPullRequestCommentsPage createPage(
        PageContext<
                ListPullRequestCommentsRequest, ListPullRequestCommentsResponse, PullRequestComment>
            context,
        ListPullRequestCommentsResponse response) {
      return new ListPullRequestCommentsPage(context, response);
    }

    @Override
    public ApiFuture<ListPullRequestCommentsPage> createPageAsync(
        PageContext<
                ListPullRequestCommentsRequest, ListPullRequestCommentsResponse, PullRequestComment>
            context,
        ApiFuture<ListPullRequestCommentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPullRequestCommentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPullRequestCommentsRequest,
          ListPullRequestCommentsResponse,
          PullRequestComment,
          ListPullRequestCommentsPage,
          ListPullRequestCommentsFixedSizeCollection> {

    private ListPullRequestCommentsFixedSizeCollection(
        List<ListPullRequestCommentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPullRequestCommentsFixedSizeCollection createEmptyCollection() {
      return new ListPullRequestCommentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPullRequestCommentsFixedSizeCollection createCollection(
        List<ListPullRequestCommentsPage> pages, int collectionSize) {
      return new ListPullRequestCommentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListIssueCommentsPagedResponse
      extends AbstractPagedListResponse<
          ListIssueCommentsRequest,
          ListIssueCommentsResponse,
          IssueComment,
          ListIssueCommentsPage,
          ListIssueCommentsFixedSizeCollection> {

    public static ApiFuture<ListIssueCommentsPagedResponse> createAsync(
        PageContext<ListIssueCommentsRequest, ListIssueCommentsResponse, IssueComment> context,
        ApiFuture<ListIssueCommentsResponse> futureResponse) {
      ApiFuture<ListIssueCommentsPage> futurePage =
          ListIssueCommentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIssueCommentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIssueCommentsPagedResponse(ListIssueCommentsPage page) {
      super(page, ListIssueCommentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIssueCommentsPage
      extends AbstractPage<
          ListIssueCommentsRequest,
          ListIssueCommentsResponse,
          IssueComment,
          ListIssueCommentsPage> {

    private ListIssueCommentsPage(
        PageContext<ListIssueCommentsRequest, ListIssueCommentsResponse, IssueComment> context,
        ListIssueCommentsResponse response) {
      super(context, response);
    }

    private static ListIssueCommentsPage createEmptyPage() {
      return new ListIssueCommentsPage(null, null);
    }

    @Override
    protected ListIssueCommentsPage createPage(
        PageContext<ListIssueCommentsRequest, ListIssueCommentsResponse, IssueComment> context,
        ListIssueCommentsResponse response) {
      return new ListIssueCommentsPage(context, response);
    }

    @Override
    public ApiFuture<ListIssueCommentsPage> createPageAsync(
        PageContext<ListIssueCommentsRequest, ListIssueCommentsResponse, IssueComment> context,
        ApiFuture<ListIssueCommentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIssueCommentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIssueCommentsRequest,
          ListIssueCommentsResponse,
          IssueComment,
          ListIssueCommentsPage,
          ListIssueCommentsFixedSizeCollection> {

    private ListIssueCommentsFixedSizeCollection(
        List<ListIssueCommentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIssueCommentsFixedSizeCollection createEmptyCollection() {
      return new ListIssueCommentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIssueCommentsFixedSizeCollection createCollection(
        List<ListIssueCommentsPage> pages, int collectionSize) {
      return new ListIssueCommentsFixedSizeCollection(pages, collectionSize);
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
