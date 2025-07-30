pipeline {
    agent {
        docker {
            image 'maven:3.8.5-openjdk-8' // or any Java 8 compatible Maven image
            args '--entrypoint=""' // removes potential shell conflicts
        }
    }

    environment {
        BUILD_ID = "${env.BUILD_ID}"
        JOB_NAME = "${env.JOB_NAME}"
        BUILD_TAG = "${env.BUILD_TAG}"
        BUILD_URL = "${env.BUILD_URL}"
    }

    stages {
        stage('Build Info') {
            steps {
                sh 'mvn --version'
                sh 'java -version'
                echo "BUILD_ID: ${BUILD_ID}"
                echo "JOB_NAME: ${JOB_NAME}"
                echo "BUILD_TAG: ${BUILD_TAG}"
                echo "BUILD_URL: ${BUILD_URL}"
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Integration Test') {
            steps {
                sh 'mvn failsafe:integration-test failsafe:verify'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests=true'
            }
        }
    }

    post {
        always {
            echo 'I always run (cleanup, logs, etc.)'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
