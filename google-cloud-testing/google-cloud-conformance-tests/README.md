# Google cloud conformance tests
This maven module is intended to function as a central location for integration with
[googleapis/conformance-tests](https://github.com/googleapis/conformance-tests).

In this directory `conformance-tests` which is a git-submodule, containing the reference for which
the various conformance test resources are updated to. 

## Updating conformance-tests

#### Prerequisites

Part of the process of updating the conformance tests involves running maven a maven build for 
this module. Ensure that all parent modules have been installed locally so the build can run.
```bash
pushd cd ../../
mvn -Dmaven.test.skip.exec=true install
popd
```

#### Performing the update

To update the conformance tests run the following commands from this module directory:
```bash
pushd conformance-tests
git pull
popd
./generate-conformance-tests.sh
git add .
```

If an error is encountered while generating the new resources please check the `generate.log`
written to the working directory.


## Test Suites

### Firestore

The conformance test suites for Firestore are located in the `com.google.cloud.conformance.firestore`
package.

#### Files

There are a number of files that together define the format of the tests as well as the tests 
themselves.

* `src/main/java/com/google/cloud/conformance/firestore/v1/TestDefinition.java`
  * The generated protobuf objects used to read the tests definitions
* `src/main/proto/google/cloud/conformance/firestore/v1/tests.proto`
  * The proto definition for the tests. `TestDefinition.java` is generated from this definition.
* `src/main/resources/com/google/cloud/conformance/firestore/v1/*.json`
  * Each files is a json serialized `TestFile` definition (defined in tests.proto).
