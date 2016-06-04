/**
 * Created by JOSEVALDERLEI on 26/06/2015.
 */
(function() {
    'use strict';

    var fs          =   require('fs');
    var path        =   require('path');
    var del         =   require('del');
    var merge       =   require('merge-stream');
    var stylish     =   require('jshint-stylish');
    var gulp        =   require('gulp');
    var ngAnnotate  =   require('gulp-ng-annotate');
    var concat      =   require('gulp-concat');
    var rename      =   require('gulp-rename');
    var uglify      =   require('gulp-uglify');
    var jshint      =   require('gulp-jshint');
    var sourcemaps  =   require('gulp-sourcemaps');
    var cache       =   require('gulp-cached');

    var pastas = {
        destino: 'content/build',
        app: [
            'content/app/*confaro.app.js',
            'content/app/toast.service.js',
            'content/app/router.app.js',
            'content/app/**/*.js'
        ],
        jshint: [
            'content/app/**/*.js'
        ],
        ignorar: [
            '!content/build/**/*.js',
            '!content/mock/**/*.js',
            '!content/components/**/*.js',
            '!content/teste/**/*.js'
        ]
    };


    gulp.task('app', ['limpar'], function(){
        console.log('[gulp]: Iniciando a compactação do app base..');
        var arquivos = pastas.app.concat(pastas.ignorar);

        return gulp.src(arquivos)
            //Inicio do Source Map
            .pipe(sourcemaps.init())
            //Concatena os arquivos
            .pipe(concat('app.confaro.min.js'),  {newLine: ';'})

            .pipe(ngAnnotate())
            //Minifica
            .pipe(uglify())
            //Fim do Source Map
            .pipe(sourcemaps.write())
            // Grava o arquivo na pasta de destino App.min.js
            .pipe(gulp.dest(pastas.destino));
    });

    gulp.task('jshint', function() {
        console.log('[gulp]: Iniciando a verificação do código..');
        var arquivos = pastas.jshint.concat(pastas.ignorar);

        return gulp.src(arquivos)
            // Realiza cache dos arquivos ja verificados
            .pipe(cache('jshintCache'))
            // Analisa o código usando o jshint seguindo os padr�es estabelecidos no arquivo .jshintrc
            .pipe(jshint('.jshintrc'))
            // Utiliza o reporter stylish para exibir os resultados
            .pipe(jshint.reporter(stylish));
    });

    gulp.task('limpar', function(cb) {
        // Limpa a pasta build
        del(pastas.destino, cb);
    });

    gulp.task('monitorar', function() {
        // Monitora os arquivos do projeto para refazer o build caso houver altera��o
        gulp.watch(pastas.jshint.concat(pastas.ignorar), ['jshint', 'app']);
    });

    gulp.task('default', ['jshint', 'app', 'monitorar']);

    function getFolders(dir) {
        return fs.readdirSync(dir)
            .filter(function(file) {
                return fs.statSync(path.join(dir, file)).isDirectory();
            });
    }
})();
