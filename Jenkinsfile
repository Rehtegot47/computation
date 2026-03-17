pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Rehtegot47/computation.git', branch: 'main'
            }
        }
        stage("Compile") {
                steps {
                    sh "chmod +x gradlew"
                    sh "java -version"
                    sh "./gradlew --version"
                    sh "./gradlew clean"
                    sh "./gradlew compileJava"
            }
        }
        stage("Test") {
                steps {
                    sh "./gradlew test"
            }
        }
        stage("Code Coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("CheckStyle") {
                steps {
                    sh "./gradlew checkstyleMain"
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/reports/checkstyle',
                        reportFiles: 'index.html',
                        reportName: 'CheckStyle Report'
                    ])
            }
        }
    }
}