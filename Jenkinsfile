pipeline {
    agent any
    
    tools {
        jdk 'jdk17'
        maven 'maven3'
    }
    
    environment {
        SCANNER_HOME = tool 'sonar-scanner'
    }

    stages {
        stage('Github checkout') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/mnraomq/CICD.git'
            }
        }
        stage('Build using Maven') {
            steps {
                sh "mvn clean install -DHOST=localhost"
            }
        }
        stage('SonarQube') {
            steps {
                sh """$SCANNER_HOME/bin/sonar-scanner \
                    -Dsonar.host.url=http://localhost:9000/ \
                    -Dsonar.login=sqp_df2a5b30be3c453d1b0f9933a4845dd4a6eee484 \
                    -Dsonar.projectName=sonarqube \
                    -Dsonar.java.binaries=target/classes \
                    -Dsonar.java.libraries=. \
                    -Dsonar.projectKey=sonarqube \
                    -Dsonar.scm.disabled=True \
                    -Dsonar.sources=src \
                    -Dsonar.language=java \
                    -Dsonar.tests=target/surefire-reports \
                    -Dsonar.dynamicAnalysis=reuseReports \
                    -Dsonar.junit.reportsPath=target \
                    -Dsonar.coverage.exclusions=src/test/java/edu/tus/test/* \
                    -Dsonar.java.coveragePlugin=jacoco"""
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn clean test -DHOST=localhost'
            }
        }
        stage('Integration Tests') {
            steps {
                sh 'mvn verify -P integration-tests -DHOST=localhost'
            }
        }
        stage('End-to-End Tests') {
            steps {
                sh 'mvn verify -P e2e-tests -DHOST=localhost'
            }
        }
        stage('Build docker image and push') {
            steps {
                script {
                    sh 'docker build -t mnraomq/bookstore --platform linux/amd64/v3 .'
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerjenkinspwd')]) {
                        sh 'docker login -u mnraomq -p ${dockerjenkinspwd}'
                        sh 'docker push mnraomq/bookstore:latest'
                    }
                }
            }
        }
        stage('Update Deployment File') {
            environment {
                GIT_REPO_NAME = "CICD"
                GIT_USER_NAME = "mnraomq"
                GIT_USER_EMAIL = "mnraomq@gmail.com"
            }
            steps {
                script {
                    def buildNumber = env.BUILD_NUMBER
                    sh """
                        git config user.email "${GIT_USER_EMAIL}"
                        git config user.name "${GIT_USER_NAME}"
                        sed -i 's/replaceImageTag/${buildNumber}/g' ${GIT_REPO_NAME}/argo/deployment.yml
                        git add ${GIT_REPO_NAME}/argo/deployment.yml
                        git commit -m "Update deployment image to version ${buildNumber}"
                        git push https://github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:master
                    """
                }
            }
        }
    }
}
