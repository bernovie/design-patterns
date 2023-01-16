import com.example.decorator.io.LowerCaseInputStream
import java.io.*

fun main() {
    var c: Int

    try {
        val inp: InputStream = LowerCaseInputStream(BufferedInputStream(ClassLoader.getSystemResourceAsStream("test.txt")))

        c = inp.read()
        while (c >= 0) {
            print(c.toChar())
            c = inp.read()
        }
        inp.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}