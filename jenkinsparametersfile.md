pipeline {
    agent {label 'GAMEOFLIFE'}
    parameters {
        choice (name:'branchname', choices: ['master', 'branch1'], description: 'forbranchselection')
        string(name: 'MAVEN', defaultValue: 'package', description: 'forselectingmaven')
    }
    stages {
        stage ('vcs') {
            git branch: '${params.branchname}'
                   url: 'https://github.com/maheshryali/game-of-life.git'
        }
        stage ('mavenbuild') {
            sh '${params.MAVEN}'
        }
        stage ('archieve') {
            sh 'gameoflife-web/target/*.war'
        }
    }
}