pipeline {
    agent {
        docker {
            image 'node:20-alpine'
     
        }
    }

    stages {
        stage('Build') {
            steps {
         
                sh 'node --version'
                echo "build"
         
            }
        }

        stage('Test') {
            steps {
                echo "Tests"
        
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
