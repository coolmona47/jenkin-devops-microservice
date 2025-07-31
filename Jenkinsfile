pipeline {
    agent {
        docker {
            image 'maven:3.6.3'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                echo "build"
            }
        }

        stage('Test') {
            steps {
                echo "test"
            }
        }

        stage('Deploy') {
            steps {
                echo "deploy"
            }
        }

        stage('Integration Test') {
            steps {
                echo "Integration Test"
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully ✅"
        }

        failure {
            echo "Pipeline failed ❌"
        }

        always {
            echo "This runs regardless of success or failure 🔁"
        }
    }
}
