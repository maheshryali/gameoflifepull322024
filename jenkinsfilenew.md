pipeline {
    agent {label 'GAMEOFLIFE'}
    parameters {
        choice(name: 'branch_1', choices: ['master', 'branch1'], description: 'this isfor barnchselection')
        string(name: 'MAVEN', defaultValue: 'mvn package', description: 'this is for maven build')
    }
    stages {
        stage('vcs') {
            steps{
            git branch : "${params.branch_1}",
                   url : 'https://github.com/maheshryali/game-of-life.git' 
                   }
        }
        stage('mavenbuild') {
            steps{
            sh "${params.MAVEN}"
            }
        }
    }
}