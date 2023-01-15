package decorator.io

import java.io.FilterInputStream
import java.io.InputStream

class LowerCaseInputStream(val inp: InputStream): FilterInputStream(inp) {

    override fun read() : Int {
        val c = inp.read()
        return if (c == -1) c else Character.toLowerCase(c)
    }

    override fun read(b: ByteArray, offset: Int, len: Int): Int {
        val result = inp.read(b, offset, len)
        for (i in offset until offset+len) {
            b[i] = Character.toLowerCase(b[i] as Char) as Byte
        }
        return result
    }

}