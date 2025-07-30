pipeline {
    agent any
	environment {
		dockerHome = tool'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
	}

    stages {
        stage('Build') {
            steps {
				sh 'mvn --version'
				sh 'docker version'
                echo "Build Stage"
                echo "PATH: $PATH"
                echo "BUILD_ID: ${env.BUILD_ID}"
                echo "JOB_NAME: ${env.JOB_NAME}"
                echo "BUILD_TAG: ${env.BUILD_TAG}"
                echo "BUILD_URL: ${env.BUILD_URL}"
            }
        }

        stage('Test') {
            steps {
                echo 'Test Stage'
                // sh 'npm test'
            }
        }

        stage('Integration Test') {
            steps {
                echo 'Integration Test Stage'
                // sh 'npm run test:integration'
            }
        }
    }

    post {
        always {
            echo 'I am awesome. I run always.'
        }
        success {
            echo 'I run when you are successful.'
        }
        failure {
            echo 'I run when you fail.'
        }
    }
}
