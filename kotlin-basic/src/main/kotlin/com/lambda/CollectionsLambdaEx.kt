package com.lambda


fun main() {
    val list = listOf(1, 2, 3, 4, 5)

    // filter (원소 중 짝수만 필터링)
    list.filter {
        it%2 == 0
    }.forEach{
        print("$it ")
    }
    println()

    // 컬렉션 필터링 예제
    val movie1 = Movie("action movie", MovieGenre.ACTION)
    val movie2 = Movie("action movie2", MovieGenre.ACTION)
    val movie3 = Movie("comic movie1", MovieGenre.COMIC)
    val movie4 = Movie("drama movie1", MovieGenre.DRAMA)

    val movieList = listOf(movie1, movie2, movie3, movie4)

    val actionMovies = genreFilter(movieList) { m: Movie -> m.genre == MovieGenre.ACTION}
    println(actionMovies)

    val comicMovies = genreFilter(movieList) {m: Movie -> m.genre == MovieGenre.COMIC}
    println(comicMovies)
}


// predicate: (Movie) -> Boolean : Movie에 대한 조건의 결과를 Boolean 타입으로 리턴
fun genreFilter(movieList: List<Movie>, predicate: (Movie) -> Boolean): List<Movie> {
    return movieList
        .filter {
            predicate.invoke(it)
        }
}


class Movie(
    val title: String,
    val genre: MovieGenre
) {
    override fun toString(): String {
        return "Movie(title='$title', genre=$genre)"
    }
}
