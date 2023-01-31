import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private lateinit var visited : IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n  = br.readLine().toInt()
    visited = IntArray(n+1)
    bfs(n)
    // 경로 출력
    var i = 1
    var result = ArrayList<Int>()
    var count = 0
    result.add(i)
    while(true){
        val temp = visited[i]
        if(temp == 0) break
        result.add(temp)
        count++
        i = temp
    }
    result.reverse()
    bw.write(count.toString()+"\n")
    bw.write(result.joinToString(" "))
    bw.flush()
    bw.close()
}

private fun bfs(start: Int){
    var dq = ArrayDeque<Int>()
    dq.addLast(start)
    visited[start] = 0
    while (!dq.isEmpty()){
        val v = dq.removeFirst()
        if (v == 1) {
            break
        }
        // 다음 탐색 리스트 만들기
        val tempAry = ArrayList<Int>()
        tempAry.add(v-1)
        if(v %3 == 0){
            tempAry.add(v/3)
        }
        if (v%2 ==0) {
            tempAry.add(v/2)
        }
        // 방문하기
        for (i in tempAry){
            if (visited[i] == 0){
                dq.addLast(i)
                visited[i] = v
            }
        }
    }


}