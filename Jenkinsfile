pipeline {
    agent {
            label "Permanent"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Rehtegot47/computation.git', branch: 'main'
            }
        }
        stage("Compiles") {
                steps {
                    bat "chmod +x gradlew"
                    bat "java -version"
                    bat "./gradlew --version"
                    bat "./gradlew clean"
                    bat "./gradlew compileJava"
            }
        }
        stage("Test") {
                steps {
                    bat "./gradlew test"
            }
        }
        stage("Code Coverage") {
            steps {
                bat "./gradlew jacocoTestReport"
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                bat "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("CheckStyle") {
                steps {
                    bat "./gradlew checkstyleMain"
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
    post {
            always {
                mail to: 'codeble101@gmail.com',
                     subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
                     body: "Your build completed check : ${env.BUILD_URL}"
                     slackSend channel: "#all-rehtegot47", color: "good", message: "The message is pulchritudous"
            }
        }
}