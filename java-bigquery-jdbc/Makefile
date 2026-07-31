SHELL := /bin/bash # Default 'sh' doesn't support 'source'
BUILD_BRANCH=main
CONTAINER_NAME=jdbc
PROXY_CONTAINER_NAME=$(CONTAINER_NAME)-proxy
PACKAGE_DESTINATION=$(PWD)/drivers
SRC="$(PWD)"
skipSurefire ?= true
skipShade ?= true
JDBC_DRIVER_VERSION = $(shell mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
JDBC_JAR = $(PACKAGE_DESTINATION)/google-cloud-bigquery-jdbc-$(JDBC_DRIVER_VERSION)-all.jar


# no indendation for ifndef\endif due to their evaluation before execution
.check-env: |
ifndef GOOGLE_APPLICATION_CREDENTIALS
	$(error GOOGLE_APPLICATION_CREDENTIALS is required to run tests)
endif

install:
	cd "$(PWD)/.." && \
	source ".kokoro/common.sh" && \
	install_modules java-bigquery-jdbc

clean:
	mvn clean

lint:
	mvn com.spotify.fmt:fmt-maven-plugin:format

unittest: |
	mvn -B -ntp \
		-DtrimStackTrace=false \
		-Dclirr.skip=true \
		-Denforcer.skip=true \
		-Dtest=$(test) \
		test

# Important: By default, this command will skip unittests & uberjar build.
# To include unit tests, run: make integration-test skipSurefire=false
integration-test:
	mvn -B -ntp \
		-Penable-integration-tests \
		-DtrimStackTrace=false \
		-DskipSurefire=$(skipSurefire) \
		-DskipShade=$(skipShade) \
		-Dclirr.skip=true \
		-Denforcer.skip=true \
		-Dit.failIfNoSpecifiedTests=true \
		-Dit.test=$(test) \
		integration-test \
		verify

unit-test-coverage:
	$(MAKE) unittest
	mvn -B -ntp jacoco:report
	BUILD_DIR=$$(mvn -B -ntp help:evaluate -Dexpression=project.build.directory -q -DforceStdout); \
	cd $$BUILD_DIR/site && zip -r $$OLDPWD/jacoco-unittests.zip jacoco && cd $$OLDPWD

full-coverage:
	$(MAKE) integration-test skipSurefire=false test=ITBigQueryJDBCTest,ITNightlyBigQueryTest
	mvn -B -ntp jacoco:report
	BUILD_DIR=$$(mvn -B -ntp  help:evaluate -Dexpression=project.build.directory -q -DforceStdout); \
	cd $$BUILD_DIR/site && zip -r $$OLDPWD/jacoco-full.zip jacoco && cd $$OLDPWD

package: 
	mvn clean package \
		-DincludeScope=runtime \
		-Dmaven.test.skip=true
	mkdir -p $(PACKAGE_DESTINATION)
	cp target/google-cloud-bigquery-jdbc-*-all.jar $(PACKAGE_DESTINATION)/

build-it-standalone:
	mvn -Dmaven.test.skip=true package -f pom-it.xml -Dbigquery-jdbc.version=$(JDBC_DRIVER_VERSION)

run-it-standalone:
	java -cp $(JDBC_JAR):target-it/* org.junit.platform.console.ConsoleLauncher --select-class com.google.cloud.bigquery.jdbc.it.suites.ITDriverAgnosticTests


# Commands for dockerized environments
.docker-run: | 
	docker run \
		$(DOCKER_INTERACTIVE_OPTS) \
		--cap-add=NET_ADMIN \
		-v $(GOOGLE_APPLICATION_CREDENTIALS):/auth/application_creds.json \
		-v "$(GOOGLE_APPLICATION_CREDENTIALS).p12":/auth/application_creds.p12 \
		-e "GOOGLE_APPLICATION_CREDENTIALS=/auth/application_creds.json" \
		-v $(SRC):/src \
		-e "SA_EMAIL=$(SA_EMAIL)" \
		-e "KMS_RESOURCE_PATH=$(KMS_RESOURCE_PATH)" \
		-e "SA_SECRET=/auth/application_creds.json" \
		-e "SA_SECRET_P12=/auth/application_creds.p12" \
		-e "BIGQUERY_BASE_URL=$(BIGQUERY_BASE_URL)" \
		-e "BIGQUERY_URL_FLAGS=$(BIGQUERY_URL_FLAGS)" \
		$(CONTAINER_NAME) $(args)

docker-build:
	docker build --target regular -t $(CONTAINER_NAME) -f Dockerfile --build-arg BRANCH=${BUILD_BRANCH} $(SRC)

docker-proxy-build:
	docker build --target proxy -t $(PROXY_CONTAINER_NAME) -f Dockerfile --build-arg BRANCH=${BUILD_BRANCH} $(SRC)

docker-session:
	$(MAKE) .docker-run args="bash" DOCKER_INTERACTIVE_OPTS="-it"

docker-proxy-session:
	$(MAKE) .docker-run CONTAINER_NAME=$(PROXY_CONTAINER_NAME) args="bash" DOCKER_INTERACTIVE_OPTS="-it"

docker-package-all-dependencies: docker-build
	mkdir -p $(PACKAGE_DESTINATION)
	docker run \
		-v $(SRC):/src \
		-v $(PACKAGE_DESTINATION):/pkg \
		$(CONTAINER_NAME) \
		sh -c "make package-all-dependencies && \
			cp --no-preserve=ownership /mvn/test-target/google-cloud-bigquery-jdbc-*.jar /pkg && \
			rm -f /pkg/*tests.jar"

docker-package-all-dependencies-shaded: docker-build
	mkdir -p $(PACKAGE_DESTINATION)
	docker run \
		-v $(SRC):/src \
		-v $(PACKAGE_DESTINATION):/pkg \
		$(CONTAINER_NAME) \
		sh -c "make package-all-dependencies-shaded && \
			cp --no-preserve=ownership /mvn/test-target/google-cloud-bigquery-jdbc-*.jar /pkg && \
			rm -f /pkg/*tests.jar"

docker-package: docker-build
	mkdir -p $(PACKAGE_DESTINATION)
	docker run \
		-v $(SRC):/src \
		-v $(PACKAGE_DESTINATION):/pkg \
		$(CONTAINER_NAME) \
		sh -c "make package && \
			mkdir -p /tmp/package && \
			cp --no-preserve=ownership /mvn/test-target/google-cloud-bigquery-jdbc-*.jar /tmp/package && \
			rm -f /tmp/package/google-cloud-bigquery-jdbc-*-all.jar && \
			rm -f /tmp/package/*tests.jar && \
			cp --no-preserve=ownership dependencies.txt /tmp/package && \
			rm dependencies.txt && \
			cp --no-preserve=ownership /mvn/test-target/dependency/*.jar /tmp/package && \
			zip -j -r /pkg/google-cloud-bigquery-jdbc-$$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout).zip /tmp/package && \
			cp --no-preserve=ownership /mvn/test-target/google-cloud-bigquery-jdbc-*-all.jar /pkg "

docker-unittest: |
	$(MAKE) .docker-run args="make unittest test=$(test)"

docker-integration-test: .check-env
	$(MAKE) .docker-run args="make integration-test test=$(test) skipSurefire=$(skipSurefire)"

docker-proxy-integration-test: .check-env docker-proxy-build
	$(MAKE) docker-integration-test CONTAINER_NAME=$(PROXY_CONTAINER_NAME) BIGQUERY_URL_FLAGS="ProxyHost=127.0.0.1;ProxyPort=3128;"

docker-coverage: 
	$(MAKE) .docker-run args="make unit-test-coverage"
	$(MAKE) .docker-run args="make full-coverage"
