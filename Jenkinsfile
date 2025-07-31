pipeline {
    agent any

    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }

    stages {
        stage('Environment Info') {
            steps {
                sh 'java -version || true'
                sh 'mvn -v'
                sh 'docker -v'
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "BUILD_NUMBER - ${env.BUILD_NUMBER}"
                echo "BUILD_ID - ${env.BUILD_ID}"
                echo "JOB_NAME - ${env.JOB_NAME}"
                echo "BUILD_TAG - ${env.BUILD_TAG}"
                echo "BUILD_URL - ${env.BUILD_URL}"
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests=true'
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed. Check console for details.'
        }
        always {
            echo '🔁 Pipeline finished.'
        }
    }
}
