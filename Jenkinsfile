pipeline {
    agent {
        docker {
            image 'maven:3.6.3'
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
                // You can replace this with actual test commands
                sh 'echo "Tests passed!"'
            }
        }

        stage('Deploy') {
            steps {
                echo "🚀 Deploying the Application..."
                // You can add real deploy commands here
                sh 'echo "Deploy step placeholder"'
            }
        }

        stage('Integration Test') {
            steps {
                echo "🔗 Running Integration Tests..."
                // You can add actual integration tests
                sh 'echo "Integration test step placeholder"'
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Please check the logs."
        }
        always {
            echo "🔁 Pipeline finished. (Runs always)"
        }
    }
}
