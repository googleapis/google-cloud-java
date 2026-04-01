# GOOGLE_APPLICATION_CREDENTIALS is required when running certain tests
SECRET=`cat $(GOOGLE_APPLICATION_CREDENTIALS)`

SIMBA_JDBC_VERSION=${_VERSION}
SIMBA_ZIP_FILE="SimbaJDBCDriverforGoogleBigQuery42_$(SIMBA_JDBC_VERSION).zip"

# Driver under test configuration
JDBC_FOLDER=drivers
JDBC_JAR_NAME=GoogleBigQueryJDBC42.jar
JDBC_JAR_PATH="$(JDBC_FOLDER)/$(JDBC_JAR_NAME)"
JDBC_VERSION=$(SIMBA_JDBC_VERSION)

skipSurefire ?= true

# Container name used during this test
CONTAINER_NAME=jdbc_test

# no indentation for ifndef\endif due to their evaluation before execution
.check-env: |
ifndef GOOGLE_APPLICATION_CREDENTIALS
	$(error GOOGLE_APPLICATION_CREDENTIALS is required to run tests)
endif

# Important: By default, this command will skip unittests.
# To include unit tests, run: make integration-test skipSurefire=false
integration-test:
	mvn -B -ntp \
		-Penable-integration-tests \
		-DtrimStackTrace=false \
		-DskipSurefire=$(skipSurefire) \
		-Dclirr.skip=true \
		-Denforcer.skip=true \
		-Dit.failIfNoSpecifiedTests=true \
		-Dit.test=$(test) \
		integration-test

.docker-run: | 
	docker run -it \
		-v $(GOOGLE_APPLICATION_CREDENTIALS):/auth/application_creds.json \
		-e "GOOGLE_APPLICATION_CREDENTIALS=/auth/application_creds.json" \
		-v "$(GOOGLE_APPLICATION_CREDENTIALS).p12":/auth/application_creds.p12 \
		-v $(PWD):/src \
		-e "SA_SECRET=$(SECRET)" \
		-e "SA_SECRET_P12=/auth/application_creds.p12" \
		$(CONTAINER_NAME) $(args)

download-simba:
	mkdir -p $(JDBC_FOLDER)
	gsutil -m cp gs://bq-dev-tools-simba-drivers-testing/simba-jdbc/$(SIMBA_ZIP_FILE) $(JDBC_FOLDER)
	unzip -p ./$(JDBC_FOLDER)/$(SIMBA_ZIP_FILE) $(JDBC_JAR_NAME) > $(JDBC_JAR_PATH)

docker-build: |
	docker build --build-arg JDBC_JAR_PATH=$(JDBC_JAR_PATH) --build-arg JDBC_VERSION=$(JDBC_VERSION) -t $(CONTAINER_NAME) .

docker-test-authentication: .check-env |
	$(MAKE) .docker-run args="mvn -Dtest=ITJdbcAuthenticationTest test"

docker-test test: .check-env |
	$(MAKE) .docker-run args="mvn test -Dtest=$(test)"

docker-test-all: .check-env |
	$(MAKE) .docker-run args="mvn test"
