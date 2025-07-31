pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
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
