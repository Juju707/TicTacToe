package pwr.jszy
import pwr.jszy.TicTacToeType.*
class TicTacToeTable {
    var table= arrayOf<Array<TicTacToeType>>()
    var game=false
    var drawEnd=false
    //Inicjalizacja
    init{
        emptyTable()
    }
    //Funkcja wyświetlająca planszę
    fun printTable(){
        println("   0   1   2 ")
        var rowIdx=0
        table.forEach { row-> print("$rowIdx ");row.forEach { element -> print("[${element.id}] ") };rowIdx++;print("\n") }
    }
    //Funkcja czyszcząca planszę i rozpoczynająca nową grę
    fun emptyTable(){
        game=false
        drawEnd=false
        table=arrayOf()
        for (i in 0..2) {
            var array = arrayOf<TicTacToeType>()
            for (j in 0..2){
                array += EMPTY
            }
            table += array
        }
    }
    //Funkcja dla ruchu gracza
    fun makeMove(move:TicTacToeType,row: Int?=null, column: Int?=null ):Boolean{
        if(row==null || column==null){
            println("You have to make a proper move")
            return true
        }else{
            return when {
                move==EMPTY-> {println("A move is required");checkGame(row,column);true
                }
                table[row][column]==EMPTY->{table[row][column]=move;checkGame(row,column);false
                }
                else-> {println("Place impossible to take");checkGame(row,column);true
                }
            }

        }

    }
    //Funkcja dla sprawdzania stanu gry
    private fun checkGame(row: Int, column: Int ){
        printTable()
        println("****************")
        //Sprawdź rząd danego ruchu, czy to te same symbole
        //Z kolumną tak samo
        //A po skosie jest 5 pozycji
        //Zawsze jest 0 i 2 w różnych kombinacjach i 1,1
        var victory: Boolean
        var draw=false
        val win= arrayOf(
            arrayOf(table[0][0],table[1][1],table[2][2]),
            arrayOf(table[2][0],table[1][1],table[0][2]),
            arrayOf(table[0][column],table[1][column],table[2][column]),
            arrayOf(table[row][0],table[row][1],table[row][2])
        )
        //Sprawdź czy ktoś wygrał
        for (value in win){
            val tempList=value.distinct()
            if (tempList.size==1 ){
                victory = when{
                    tempList[0]==O->{println("Player O won!");game=true;true }
                    tempList[0]==X->{println("Player X won!");game=true;true }
                    else->{ false }
                }
                if(victory){draw=true;break}
            }else{
                draw=draw||value.contains(EMPTY)

            }
        }
        //Jak nikt nie wygrał sprawdź czy remis
        if(!draw){println("It's a draw!");game=true;drawEnd=true}
    }
    //Funkcja kontrolująca ruch komputera
    fun computerMove(move:TicTacToeType): Boolean{
        //Możliwe kombinacja na planszy
        var combinations= arrayOf(
            //przekątne
            arrayOf(table[0][0],table[1][1],table[2][2]),//lewy górny róg
            arrayOf(table[2][0],table[1][1],table[0][2]),//prawy górny róg
            //kolumny
            arrayOf(table[0][0],table[1][0],table[2][0]),//1
            arrayOf(table[0][1],table[1][1],table[2][1]),//2
            arrayOf(table[0][2],table[1][2],table[2][2]),//3
            //rzędy
            arrayOf(table[0][0],table[0][1],table[0][2]),//1
            arrayOf(table[1][0],table[1][1],table[1][2]),//2
            arrayOf(table[2][0],table[2][1],table[2][2])//3
        )
        //Zdefiniuj kto jest kim
        var player=X
        if (move==X){player=O}

        //Sprawdź czy możesz wygrać w tym ruchu
        for (row in combinations){
            if(!row.contains(player)){
                var places=0
                row.forEach { element -> if(element==EMPTY) {places++} }
                if(places==1){
                    when (combinations.indexOf(row)) {
                        0 -> {table[0][0]=move;table[1][1]=move;table[2][2]=move;checkGame(0,0);return true}
                        1 -> {table[2][0]=move;table[1][1]=move;table[0][2]=move;checkGame(2,0);return true}
                        2 -> {table[0][0]=move;table[1][0]=move;table[2][0]=move;checkGame(2,0);return true}
                        3 -> {table[0][1]=move;table[1][1]=move;table[2][1]=move;checkGame(2,1);return true}
                        4 -> {table[0][2]=move;table[1][2]=move;table[2][2]=move;checkGame(2,2);return true}
                        5 -> {table[0][0]=move;table[0][1]=move;table[0][2]=move;checkGame(0,2);return true}
                        6 -> {table[1][0]=move;table[1][1]=move;table[1][2]=move;checkGame(1,2);return true}
                        7 -> {table[2][0]=move;table[2][1]=move;table[2][2]=move;checkGame(2,0);return true}
                    }
                }
            }
        }

        //Sprawdź czy gracz może wygrać w tym ruchu
        var index=-1
        for (row in combinations){
            index++
            if(!row.contains(move)){
                var places=0
                row.forEach { element -> if(element==EMPTY) {places++} }
                if(places==1){
                    when (combinations.indexOf(row)) {
                        0 -> {if(table[0][0]==EMPTY)table[0][0]=move;if(table[1][1]==EMPTY)table[1][1]=move;if(table[2][2]==EMPTY)table[2][2]=move;checkGame(0,0);return true}
                        1 -> {if(table[2][0]==EMPTY)table[2][0]=move;if(table[1][1]==EMPTY)table[1][1]=move;if(table[0][2]==EMPTY)table[0][2]=move;checkGame(2,0);return true}
                        2 -> {if(table[0][0]==EMPTY)table[0][0]=move;if(table[1][0]==EMPTY)table[1][0]=move;if(table[2][0]==EMPTY)table[2][0]=move;checkGame(2,0);return true}
                        3 -> {if(table[0][1]==EMPTY)table[0][1]=move;if(table[1][1]==EMPTY)table[1][1]=move;if(table[2][1]==EMPTY)table[2][1]=move;checkGame(2,1);return true}
                        4 -> {if(table[0][2]==EMPTY)table[0][2]=move;if(table[1][2]==EMPTY)table[1][2]=move;if(table[2][2]==EMPTY)table[2][2]=move;checkGame(2,2);return true}
                        5 -> {if(table[0][0]==EMPTY)table[0][0]=move;if(table[0][1]==EMPTY)table[0][1]=move;if(table[0][2]==EMPTY)table[0][2]=move;checkGame(0,2);return true}
                        6 -> {if(table[1][0]==EMPTY)table[1][0]=move;if(table[1][1]==EMPTY)table[1][1]=move;if(table[1][2]==EMPTY)table[1][2]=move;checkGame(1,2);return true}
                        7 -> {if(table[2][0]==EMPTY)table[2][0]=move;if(table[2][1]==EMPTY)table[2][1]=move;if(table[2][2]==EMPTY)table[2][2]=move;checkGame(2,0);return true}
                    }
                }
            }
        }

        //Spróbuj obsadzić rogi
        val corner=choseRandomMove("corner",move)
        if(corner[1]!=8){
            table[corner[0]][corner[1]]=move
        checkGame(corner[0],corner[1])
        return true}

        //Spróbuj wziąć środek
        if(table[1][1] == EMPTY) {
            table[1][1]=move
            checkGame(1,1)
            return true}

        //Obsadź dowolną stronę
        val place=choseRandomMove("side",move)
        checkGame(place[0],place[1])
        return true
    }
    //Wybierz losową pozycję z 4
    private fun choseRandomMove( option: String,move:TicTacToeType): List<Int> {
        if(option=="side"){
            val sides= arrayOf(Pair(0,1),Pair(1,0),Pair(1,2),Pair(2,1))
            val (pos1,pos2)=sides.random()
            return if(table[pos1][pos2]==EMPTY){
                table[pos1][pos2]=move
                listOf(pos1,pos2)
            }else choseRandomMove("side",move)
        }
        val cornersCheck= arrayOf(table[0][0],table[0][2],table[2][0],table[2][2])
        val taken=cornersCheck.contains(EMPTY)
        //Zabezpiecz na wypadek jakby wszystkie rogi były zajęte
        if(!taken) return listOf(8,8)
        //Wybierz losowy róg
        var corners= arrayOf(Pair(0,0),Pair(0,2),Pair(2,0),Pair(2,2))
        var (pos1,pos2)=corners.random()
        var next=true
        while(next) {
            if (table[pos1][pos2]==EMPTY) {
                break
            }
            else{
               var (pos1,pos2)=corners.random()
            }
        }
        table[pos1][pos2]=move
        return listOf(pos1,pos2)
    }
}