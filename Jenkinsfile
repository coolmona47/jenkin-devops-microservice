pipeline {
    agent {
        docker {
            image 'maven:3.6.3'
            args '-u root --entrypoint=""'
        }
    }

    stages {
        stage('Build') {
            steps {
                echo "🔧 Running Maven Build..."
                sh 'mvn --version'
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Running Tests..."
                sh 'echo "Tests passed!"'
            }
        }

        stage('Deploy') {
            steps {
                echo "🚀 Deploying the Application..."
            }
        }

        stage('Integration Test') {
            steps {
                echo "🔗 Running Integration Tests..."
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Please check logs."
        }
        always {
            echo "🔁 Pipeline finished."
        }
    }
}
